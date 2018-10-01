package br.questor.teste.ebs.model;

public class Organograma {
    
    protected String TABELA = "ORGANOGRAMA";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOESTAB;
    protected String CLASSIFORGAN;
    protected String DESCRORGAN;

    public Organograma(){
        this.CODIGOEMPRESA = 0;
        this.CODIGOESTAB = 0;
        this.CLASSIFORGAN = "";
        this.DESCRORGAN = "";
    }
    
    public Organograma(int CODIGOEMPRESA, int CODIGOESTAB, String CLASSIFORGAN, String DESCRORGAN) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOESTAB = CODIGOESTAB;
        this.CLASSIFORGAN = CLASSIFORGAN;
        this.DESCRORGAN = DESCRORGAN;
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

    public int getCODIGOESTAB() {
        return CODIGOESTAB;
    }

    public void setCODIGOESTAB(int CODIGOESTAB) {
        this.CODIGOESTAB = CODIGOESTAB;
    }

    public String getCLASSIFORGAN() {
        return CLASSIFORGAN;
    }

    public void setCLASSIFORGAN(String CLASSIFORGAN) {
        this.CLASSIFORGAN = CLASSIFORGAN;
    }

    public String getDESCRORGAN() {
        return DESCRORGAN;
    }

    public void setDESCRORGAN(String DESCRORGAN) {
        this.DESCRORGAN = DESCRORGAN;
    } 
}
