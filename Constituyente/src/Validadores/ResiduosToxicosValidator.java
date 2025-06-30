package Validadores;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class ResiduosToxicosValidator {
    private Connection connection;

    public ResiduosToxicosValidator(Connection connection) {
        this.connection = connection;
    }

    // General validation methods
    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isValidRUC(String ruc) {
        return ruc != null && ruc.length() == 11 && ruc.matches("\\d+");
    }

    private boolean isValidPercentage(BigDecimal percentage) {
        return percentage != null && percentage.compareTo(BigDecimal.ZERO) >= 0 
               && percentage.compareTo(new BigDecimal("100")) <= 0;
    }

    private boolean isValidPositiveDecimal(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) > 0;
    }

    private boolean existsInTable(String tableName, String columnName, Object value) throws SQLException {
        String sql = String.format("SELECT 1 FROM %s WHERE %s = ?", tableName, columnName);
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            if (value instanceof Integer) {
                stmt.setInt(1, (Integer) value);
            } else if (value instanceof String) {
                stmt.setString(1, (String) value);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    // Region validation
    public boolean validateRegion(int regCod, String regNom) {
        if (isNullOrEmpty(regNom) || regNom.length() > 100) {
            return false;
        }
        return true;
    }

    // CodigoResiduo validation
    public boolean validateCodigoResiduo(String codResCod, String codResDesc) {
        if (isNullOrEmpty(codResCod) || codResCod.length() > 10) {
            return false;
        }
        if (isNullOrEmpty(codResDesc) || codResDesc.length() > 200) {
            return false;
        }
        return true;
    }

    // EmpresaProductora validation
    public boolean validateEmpresaProductora(String empNom, String empRUC, String empDir, String empAct, int regCod) throws SQLException {
        if (isNullOrEmpty(empNom) || empNom.length() > 200) {
            return false;
        }
        if (!isValidRUC(empRUC)) {
            return false;
        }
        if (isNullOrEmpty(empDir) || empDir.length() > 250) {
            return false;
        }
        if (empAct != null && empAct.length() > 100) {
            return false;
        }
        return existsInTable("REGION", "RegCod", regCod);
    }

    // EmpresaTransportista validation
    public boolean validateEmpresaTransportista(String trsNom, String trsRUC, String trsDir, BigDecimal trsCap, int regCod) throws SQLException {
        if (isNullOrEmpty(trsNom) || trsNom.length() > 200) {
            return false;
        }
        if (!isValidRUC(trsRUC)) {
            return false;
        }
        if (isNullOrEmpty(trsDir) || trsDir.length() > 250) {
            return false;
        }
        if (trsCap != null && trsCap.compareTo(new BigDecimal("999999.99")) > 0) {
            return false;
        }
        return existsInTable("REGION", "RegCod", regCod);
    }

    // Destino validation
    public boolean validateDestino(String destNom, String destDir, BigDecimal destCap, BigDecimal destCapAct, int regCod) throws SQLException {
        if (isNullOrEmpty(destNom) || destNom.length() > 100) {
            return false;
        }
        if (isNullOrEmpty(destDir) || destDir.length() > 250) {
            return false;
        }
        if (destCap != null && destCap.compareTo(new BigDecimal("99999999.99")) > 0) {
            return false;
        }
        if (destCapAct != null && destCapAct.compareTo(new BigDecimal("99999999.99")) > 0) {
            return false;
        }
        return existsInTable("REGION", "RegCod", regCod);
    }

    // Constituyente validation
    public boolean validateConstituyente(String conNom, String conDes, Integer conGrad) {
        if (isNullOrEmpty(conNom) || conNom.length() > 100) {
            return false;
        }
        if (conDes != null && conDes.length() > 250) {
            return false;
        }
        if (conGrad != null && (conGrad < 0 || conGrad > 127)) { // TINYINT range
            return false;
        }
        return true;
    }

    // Residuo validation
    public boolean validateResiduo(String resNom, String resDes, String codResCod, int empCod) throws SQLException {
        if (isNullOrEmpty(resNom) || resNom.length() > 100) {
            return false;
        }
        if (resDes != null && resDes.length() > 250) {
            return false;
        }
        if (!existsInTable("CODIGO_RESIDUO", "CodResCod", codResCod)) {
            return false;
        }
        return existsInTable("EMPRESA_PRODUCTORA", "EmpCod", empCod);
    }

    // ResiduoConstituyente validation
    public boolean validateResiduoConstituyente(int resCod, int consCod, BigDecimal resConsPorc) throws SQLException {
        if (!existsInTable("RESIDUO", "ResCod", resCod)) {
            return false;
        }
        if (!existsInTable("CONSTITUYENTE", "ConsCod", consCod)) {
            return false;
        }
        if (resConsPorc != null && !isValidPercentage(resConsPorc)) {
            return false;
        }
        return true;
    }

    // TrasladoResiduo validation
    public boolean validateTrasladoResiduo(LocalDate trasFec, BigDecimal trasCant, String trasDsc, 
                                          int resCod, int empCod, int trsEmpCod, int destCod) throws SQLException {
        if (trasFec == null || trasFec.isAfter(LocalDate.now())) {
            return false; // Can't have future dates
        }
        if (!isValidPositiveDecimal(trasCant) || trasCant.compareTo(new BigDecimal("999999.99")) > 0) {
            return false;
        }
        if (trasDsc != null && trasDsc.length() > 250) {
            return false;
        }
        if (!existsInTable("RESIDUO", "ResCod", resCod)) {
            return false;
        }
        if (!existsInTable("EMPRESA_PRODUCTORA", "EmpCod", empCod)) {
            return false;
        }
        if (!existsInTable("EMPRESA_TRANSPORTISTA", "TrsEmpCod", trsEmpCod)) {
            return false;
        }
        if (!existsInTable("DESTINO", "DestCod", destCod)) {
            return false;
        }
        
        // Additional validation: check if destination has enough capacity
        return checkDestinationCapacity(destCod, trasCant);
    }

    private boolean checkDestinationCapacity(int destCod, BigDecimal trasCant) throws SQLException {
        String sql = "SELECT DestCap, DestCapAct FROM DESTINO WHERE DestCod = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, destCod);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    BigDecimal destCap = rs.getBigDecimal("DestCap");
                    BigDecimal destCapAct = rs.getBigDecimal("DestCapAct");
                    
                    if (destCap != null && destCapAct != null) {
                        BigDecimal remainingCapacity = destCap.subtract(destCapAct);
                        return remainingCapacity.compareTo(trasCant) >= 0;
                    }
                }
                return false;
            }
        }
    }

    // Method to validate before insert
    public boolean validateInsert(String tableName, Object entity) throws SQLException {
        // This would be implemented based on your specific data model and ORM
        // You would call the appropriate validation method based on the tableName
        // and cast the entity to the appropriate type
        
        // Example:
        /*
        if ("REGION".equalsIgnoreCase(tableName)) {
            Region region = (Region) entity;
            return validateRegion(region.getRegCod(), region.getRegNom());
        }
        */
        return true;
    }

    // Method to validate before update
    public boolean validateUpdate(String tableName, Object entity) throws SQLException {
        // Similar to validateInsert but might have different rules
        return true;
    }

    // Method to validate before delete
    public boolean validateDelete(String tableName, Object id) throws SQLException {
        // Check for foreign key constraints
        // Example for REGION:
        if ("REGION".equalsIgnoreCase(tableName)) {
            int regCod = (Integer) id;
            return !isRegionReferenced(regCod);
        }
        return true;
    }

    public boolean isRegionReferenced(int regCod) throws SQLException {
        String[] tables = {"EMPRESA_PRODUCTORA", "EMPRESA_TRANSPORTISTA", "DESTINO"};
        for (String table : tables) {
            String sql = String.format("SELECT 1 FROM %s WHERE RegCod = ? LIMIT 1", table);
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, regCod);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
