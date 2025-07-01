package Registro;

import java.math.BigDecimal;

public class EmpresaTransportista {
    private int trsEmpCod;
    private String trsNom;
    private String trsRUC;
    private String trsDir;
    private BigDecimal trsCap;
    private int regCod;
    private String estReg;

    public int getTrsEmpCod() {
        return trsEmpCod;
    }

    public void setTrsEmpCod(int trsEmpCod) {
        this.trsEmpCod = trsEmpCod;
    }

    public String getTrsNom() {
        return trsNom;
    }

    public void setTrsNom(String trsNom) {
        this.trsNom = trsNom;
    }

    public String getTrsRUC() {
        return trsRUC;
    }

    public void setTrsRUC(String trsRUC) {
        this.trsRUC = trsRUC;
    }

    public String getTrsDir() {
        return trsDir;
    }

    public void setTrsDir(String trsDir) {
        this.trsDir = trsDir;
    }

    public BigDecimal getTrsCap() {
        return trsCap;
    }

    public void setTrsCap(BigDecimal trsCap) {
        this.trsCap = trsCap;
    }

    public int getRegCod() {
        return regCod;
    }

    public void setRegCod(int regCod) {
        this.regCod = regCod;
    }

    public String getEstReg() {
        return estReg;
    }

    public void setEstReg(String estReg) {
        this.estReg = estReg;
    }
}
