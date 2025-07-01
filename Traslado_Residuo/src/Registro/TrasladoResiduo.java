package Registro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TrasladoResiduo {
    private int trasCod;
    private LocalDate trasFec;
    private BigDecimal trasCant;
    private String trasDsc;
    private int resCod;
    private int empCod;
    private int trsEmpCod;
    private int destCod;

    public int getTrasCod() {
        return trasCod;
    }

    public void setTrasCod(int trasCod) {
        this.trasCod = trasCod;
    }

    public LocalDate getTrasFec() {
        return trasFec;
    }

    public void setTrasFec(LocalDate trasFec) {
        this.trasFec = trasFec;
    }

    public BigDecimal getTrasCant() {
        return trasCant;
    }

    public void setTrasCant(BigDecimal trasCant) {
        this.trasCant = trasCant;
    }

    public String getTrasDsc() {
        return trasDsc;
    }

    public void setTrasDsc(String trasDsc) {
        this.trasDsc = trasDsc;
    }

    public int getResCod() {
        return resCod;
    }

    public void setResCod(int resCod) {
        this.resCod = resCod;
    }

    public int getEmpCod() {
        return empCod;
    }

    public void setEmpCod(int empCod) {
        this.empCod = empCod;
    }

    public int getTrsEmpCod() {
        return trsEmpCod;
    }

    public void setTrsEmpCod(int trsEmpCod) {
        this.trsEmpCod = trsEmpCod;
    }

    public int getDestCod() {
        return destCod;
    }

    public void setDestCod(int destCod) {
        this.destCod = destCod;
    }
}
