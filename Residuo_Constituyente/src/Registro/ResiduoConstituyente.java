package Registro;

import java.math.BigDecimal;

public class ResiduoConstituyente {
    private int resConsCod;
    private int resCod;
    private int consCod;
    private BigDecimal resConsPorc;
    
    // Campos adicionales para mostrar nombres en lugar de códigos
    private String resNom;
    private String conNom;

    public int getResConsCod() {
        return resConsCod;
    }

    public void setResConsCod(int resConsCod) {
        this.resConsCod = resConsCod;
    }

    public int getResCod() {
        return resCod;
    }

    public void setResCod(int resCod) {
        this.resCod = resCod;
    }

    public int getConsCod() {
        return consCod;
    }

    public void setConsCod(int consCod) {
        this.consCod = consCod;
    }

    public BigDecimal getResConsPorc() {
        return resConsPorc;
    }

    public void setResConsPorc(BigDecimal resConsPorc) {
        this.resConsPorc = resConsPorc;
    }

    public String getResNom() {
        return resNom;
    }

    public void setResNom(String resNom) {
        this.resNom = resNom;
    }

    public String getConNom() {
        return conNom;
    }

    public void setConNom(String conNom) {
        this.conNom = conNom;
    }
}
