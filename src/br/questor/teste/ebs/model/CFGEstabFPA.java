package br.questor.teste.ebs.model;

public class CFGEstabFPA {
    
    protected String TABELA = "CFGEstabFPA";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOESTAB;
    
    public CFGEstabFPA(){
        this.CODIGOEMPRESA = 1;
        this.CODIGOESTAB = 1;
    }

    public CFGEstabFPA(int CODIGOEMPRESA, int CODIGOESTAB) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOESTAB = CODIGOESTAB;
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
    
    public int getCODIGOESTAB(){
        return CODIGOESTAB;
    }
    
    public void setCODIGOESTAB(int CODIGOESTAB) {
        this.CODIGOESTAB = CODIGOESTAB;
    }
}
