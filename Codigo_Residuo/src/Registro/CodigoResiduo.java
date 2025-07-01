package Registro;

public class CodigoResiduo {
    private String codResCod;
    private String codResDesc;
    private String codResEstReg; // Nuevo campo para el estado

    public String getCodResCod() {
        return codResCod;
    }

    public void setCodResCod(String codResCod) {
        this.codResCod = codResCod;
    }

    public String getCodResDesc() {
        return codResDesc;
    }

    public void setCodResDesc(String codResDesc) {
        this.codResDesc = codResDesc;
    }

    public String getCodResEstReg() {
        return codResEstReg;
    }

    public void setCodResEstReg(String codResEstReg) {
        this.codResEstReg = codResEstReg;
    }
}
