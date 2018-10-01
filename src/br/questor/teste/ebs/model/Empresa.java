package br.questor.teste.ebs.model;


public class Empresa {
    
    protected String TABELA = "EMPRESA";
    protected int CODIGOEMPRESA;
    protected String NOMEEMPRESA;

    public Empresa(){
        this.CODIGOEMPRESA = 0;
        this.NOMEEMPRESA = " ";
    }
    
    public Empresa(int CODIGOEMPRESA, String NOMEEMPRESA) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.NOMEEMPRESA = NOMEEMPRESA;
    }
    
    public String getTABELA(){
        return TABELA;
    }

    public int getCODIGOEMPRESA() {
        return CODIGOEMPRESA;
    }

    public void setCODIGOEMPRESA(int CODIGOEMPRESA) {
        if((CODIGOEMPRESA >= 32767)&&(CODIGOEMPRESA <= 99999)){
            this.CODIGOEMPRESA = (CODIGOEMPRESA / 10);
        }else if (CODIGOEMPRESA >= 100000){
            this.CODIGOEMPRESA = (CODIGOEMPRESA / 1000);
        }else {
            this.CODIGOEMPRESA = CODIGOEMPRESA;
        }
    }

    public String getNOMEEMPRESA() {
        return NOMEEMPRESA;
    }

    public void setNOMEEMPRESA(String NOMEEMPRESA) {
        this.NOMEEMPRESA = NOMEEMPRESA;
    }

}
