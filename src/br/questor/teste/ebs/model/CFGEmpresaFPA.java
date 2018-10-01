package br.questor.teste.ebs.model;

public class CFGEmpresaFPA {
    
    protected String TABELA = "CFGEmpresaFPA";
    
    protected int CODIGOEMPRESA;
    
    public CFGEmpresaFPA(){
        this.CODIGOEMPRESA = 1;
    }

    public CFGEmpresaFPA(int CODIGOEMPRESA) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
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
}
