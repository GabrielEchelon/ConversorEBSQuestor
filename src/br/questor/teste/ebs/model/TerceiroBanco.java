package br.questor.teste.ebs.model;

public class TerceiroBanco {
 
    protected String TABELA = "TERCEIROBANCO";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOTERC;

    public TerceiroBanco(){
        CODIGOEMPRESA = 0;
        CODIGOTERC = 0;
    }
    
    public TerceiroBanco(int CODIGOEMPRESA, int CODIGOTERC) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOTERC = CODIGOTERC;
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

    public int getCODIGOTERC() {
        return CODIGOTERC;
    }

    public void setCODIGOTERC(int CODIGOTERC) {
        this.CODIGOTERC = CODIGOTERC;
    }
    
    
    
}
