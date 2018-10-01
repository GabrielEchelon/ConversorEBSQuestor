package br.questor.teste.ebs.model;

public class CFGEmpresaFPAOpcao {
    
    protected String TABELA = "CFGEmpresaFPAOpcao";
    
    protected int CODIGOEMPRESA;
    
    public CFGEmpresaFPAOpcao(){
        this.CODIGOEMPRESA = 1;
    }

    public CFGEmpresaFPAOpcao(int CODIGOEMPRESA) {
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
