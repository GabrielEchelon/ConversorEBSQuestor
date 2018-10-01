package br.questor.teste.ebs.model;

import java.sql.Date;

public class FuncEscala {
    
    protected String TABELA = "FUNCESCALA";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATAINICIAL;
    protected int CODIGOESCALA;

    public FuncEscala(){
        CODIGOEMPRESA = 0;
        CODIGOFUNCCONTR = 0;
        DATAINICIAL = DATAINICIAL;
        CODIGOESCALA = 0;
    }
    
    public FuncEscala(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATAINICIAL, int CODIGOESCALA) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATAINICIAL = DATAINICIAL;
        this.CODIGOESCALA = CODIGOESCALA;
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

    public Date getDATAINICIAL() {
        return DATAINICIAL;
    }

    public void setDATAINICIAL(Date DATAINICIAL) {
        this.DATAINICIAL = DATAINICIAL;
    }

    public int getCODIGOESCALA() {
        return CODIGOESCALA;
    }

    public void setCODIGOESCALA(int CODIGOESCALA) {
        this.CODIGOESCALA = CODIGOESCALA;
    }
    
    
    
}
