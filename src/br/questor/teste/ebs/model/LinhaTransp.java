package br.questor.teste.ebs.model;

public class LinhaTransp {
    
    protected String TABELA = "LINHATRANSP";
    
    protected int CODIGOLINHAVT;
    protected String NOMELINHAVT;

    public LinhaTransp(){
        CODIGOLINHAVT = 0;
        NOMELINHAVT = "";
    }
    
    public LinhaTransp(int CODIGOLINHAVT, String NOMELINHAVT) {
        this.CODIGOLINHAVT = CODIGOLINHAVT;
        this.NOMELINHAVT = NOMELINHAVT;
    }

    public String getTABELA(){
        return TABELA;
    }
    
    public int getCODIGOLINHAVT() {
        return CODIGOLINHAVT;
    }

    public void setCODIGOLINHAVT(int CODIGOLINHAVT) {
        this.CODIGOLINHAVT = CODIGOLINHAVT;
    }

    public String getNOMELINHAVT() {
        return NOMELINHAVT;
    }

    public void setNOMELINHAVT(String NOMELINHAVT) {
        this.NOMELINHAVT = NOMELINHAVT;
    }
    
    
    
}
