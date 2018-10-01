package br.questor.teste.ebs.model;

import java.sql.Date;

public class FuncAdicional {
    
    protected String TABELA = "FUNCADICIONAL";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATAINICIAL;
    protected int JAEXPOSTO;

    public FuncAdicional(){
        CODIGOEMPRESA = 0;
        CODIGOFUNCCONTR = 0;
        DATAINICIAL = DATAINICIAL;
        JAEXPOSTO = 0;
    }
    
    public FuncAdicional(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATAINICIAL, int JAEXPOSTO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATAINICIAL = DATAINICIAL;
        this.JAEXPOSTO = JAEXPOSTO;
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

    public int getJAEXPOSTO() {
        return JAEXPOSTO;
    }

    public void setJAEXPOSTO(int JAEXPOSTO) {
        this.JAEXPOSTO = JAEXPOSTO;
    }
    
    
    
}
