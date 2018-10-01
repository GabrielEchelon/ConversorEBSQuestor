package br.questor.teste.ebs.model;

import java.sql.Date;

public class ValorLinTransp {
    
    protected String TABELA = "VALORLINTRANSP";
    
    protected int CODIGOLINHAVT;
    protected Date DATA;
    protected double VALOR;

    public ValorLinTransp(){
        CODIGOLINHAVT = 0;
        DATA = DATA;
        VALOR = 0;
    }
    
    public ValorLinTransp(int CODIGOLINHAVT, Date DATA, double VALOR) {
        this.CODIGOLINHAVT = CODIGOLINHAVT;
        this.DATA = DATA;
        this.VALOR = VALOR;
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

    public Date getDATA() {
        return DATA;
    }

    public void setDATA(Date DATA) {
        this.DATA = DATA;
    }

    public double getVALOR() {
        return VALOR;
    }

    public void setVALOR(double VALOR) {
        this.VALOR = VALOR;
    }
    
    
    
}
