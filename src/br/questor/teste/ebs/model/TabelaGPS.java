package br.questor.teste.ebs.model;

public class TabelaGPS {
    
    protected String TABELA = "TABELAGPS";
    
    protected int CODIGOEMPRESA;
    protected String DESCRTABGPS;

    public TabelaGPS(){
        CODIGOEMPRESA = 0;
        DESCRTABGPS = " ";
    }
    
    public TabelaGPS(int CODIGOEMPRESA, String DESCRTABGPS) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.DESCRTABGPS = DESCRTABGPS;
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

    public String getDESCRTABGPS() {
        return DESCRTABGPS;
    }

    public void setDESCRTABGPS(String DESCRTABGPS) {
        this.DESCRTABGPS = DESCRTABGPS;
    }
    
    
    
}
