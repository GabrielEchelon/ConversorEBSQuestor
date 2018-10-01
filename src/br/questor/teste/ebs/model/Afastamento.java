package br.questor.teste.ebs.model;

import java.sql.Date;

public class Afastamento {
    
    protected String TABELA = "AFASTAMENTO";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATAAFAST;
    protected int SEQ;
    protected int CODIGOSIT;
    protected Date DATAHORALCTO;

    public Afastamento(){
        CODIGOEMPRESA = 0;
        CODIGOFUNCCONTR = 0;
        DATAAFAST = DATAAFAST;
        SEQ = 0;
        CODIGOSIT = 0;
        DATAHORALCTO = DATAHORALCTO;
    }
    
    public Afastamento(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATAAFAST, int SEQ, int CODIGOSIT, Date DATAHORALCTO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATAAFAST = DATAAFAST;
        this.SEQ = SEQ;
        this.CODIGOSIT = CODIGOSIT;
        this.DATAHORALCTO = DATAHORALCTO;
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

    public Date getDATAAFAST() {
        return DATAAFAST;
    }

    public void setDATAAFAST(Date DATAAFAST) {
        this.DATAAFAST = DATAAFAST;
    }

    public int getSEQ() {
        return SEQ;
    }

    public void setSEQ(int SEQ) {
        this.SEQ = SEQ;
    }

    public int getCODIGOSIT() {
        return CODIGOSIT;
    }

    public void setCODIGOSIT(int CODIGOSIT) {
        this.CODIGOSIT = CODIGOSIT;
    }

    public Date getDATAHORALCTO() {
        return DATAHORALCTO;
    }

    public void setDATAHORALCTO(Date DATAHORALCTO) {
        this.DATAHORALCTO = DATAHORALCTO;
    }
}
