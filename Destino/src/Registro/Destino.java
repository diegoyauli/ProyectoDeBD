package Registro;

import java.math.BigDecimal;

public class Destino {
    private int destCod;
    private String destNom;
    private String destDir;
    private BigDecimal destCap;
    private BigDecimal destCapAct;
    private int regCod;
    private String estReg;

    public int getDestCod() {
        return destCod;
    }

    public void setDestCod(int destCod) {
        this.destCod = destCod;
    }

    public String getDestNom() {
        return destNom;
    }

    public void setDestNom(String destNom) {
        this.destNom = destNom;
    }

    public String getDestDir() {
        return destDir;
    }

    public void setDestDir(String destDir) {
        this.destDir = destDir;
    }

    public BigDecimal getDestCap() {
        return destCap;
    }

    public void setDestCap(BigDecimal destCap) {
        this.destCap = destCap;
    }

    public BigDecimal getDestCapAct() {
        return destCapAct;
    }

    public void setDestCapAct(BigDecimal destCapAct) {
        this.destCapAct = destCapAct;
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
