package br.questor.teste.ebs.model;

public class FuncOutroContr {
    
    protected String TABELA = "FUNCOUTROCONTR";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected int SEQ;
    protected String NOMEEMPRESA;
    protected int TIPOINSCR;
    protected String INSCRFEDERAL;

    public FuncOutroContr(){
        CODIGOEMPRESA = 0;
        CODIGOFUNCCONTR = 0;
        SEQ = 0;
        NOMEEMPRESA = "";
        TIPOINSCR = 0;
        INSCRFEDERAL = ""; 
    }
    
    public FuncOutroContr(int CODIGOEMPRESA, int CODIGOFUNCCONTR, int SEQ, String NOMEEMPRESA, int TIPOINSCR, String INSCRFEDERAL) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.SEQ = SEQ;
        this.NOMEEMPRESA = NOMEEMPRESA;
        this.TIPOINSCR = TIPOINSCR;
        this.INSCRFEDERAL = INSCRFEDERAL;
    }

    public String getTABELA(){
        return TABELA;
    }
    
    public int getCODIGOEMPRESA() {
        return CODIGOEMPRESA;
    }

    public void setCODIGOEMPRESA(int CODIGOEMPRESA) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
    }

    public int getCODIGOFUNCCONTR() {
        return CODIGOFUNCCONTR;
    }

    public void setCODIGOFUNCCONTR(int CODIGOFUNCCONTR) {
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
    }

    public int getSEQ() {
        return SEQ;
    }

    public void setSEQ(int SEQ) {
        this.SEQ = SEQ;
    }

    public String getNOMEEMPRESA() {
        return NOMEEMPRESA;
    }

    public void setNOMEEMPRESA(String NOMEEMPRESA) {
        this.NOMEEMPRESA = NOMEEMPRESA;
    }

    public int getTIPOINSCR() {
        return TIPOINSCR;
    }

    public void setTIPOINSCR(int TIPOINSCR) {
        this.TIPOINSCR = TIPOINSCR;
    }

    public String getINSCRFEDERAL() {
        return INSCRFEDERAL;
    }

    public void setINSCRFEDERAL(String INSCRFEDERAL) {
        this.INSCRFEDERAL = INSCRFEDERAL;
    }
    
    
    
}
