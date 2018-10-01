package br.questor.teste.ebs.model;

import java.sql.Date;
import java.util.Calendar;

public class ReciboFerias {
    
    protected String TABELA = "RECIBOFERIAS";
    protected Date AUXILIAR;
    protected int AUXILIAR2 = 0;
    protected int AUXILIAR3 = 0;
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATAINICIAL;
    protected Date DATAINICIALFERIAS;
    protected Date DATAFINALFERIAS;
    protected Date DATAABONO;
    protected Date DATAPGTO;
    protected int TIPORECIBO;
    protected int DIASABONO;
    protected int DIASFERIAS;
    protected Date DATAHORALCTO;
    
    public ReciboFerias(){
        CODIGOEMPRESA = 0;
        CODIGOFUNCCONTR = 0;
        DATAINICIAL = DATAINICIAL;
        DATAINICIALFERIAS = DATAINICIALFERIAS;
        DATAFINALFERIAS = DATAFINALFERIAS;
        DATAABONO = DATAABONO;
        DATAPGTO = DATAPGTO;
        TIPORECIBO = 0;
        DIASABONO = 0;
        DIASFERIAS = 0;
        DATAHORALCTO = DATAHORALCTO;
    }

    public ReciboFerias(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATAINICIAL, Date DATAINICIALFERIAS, Date DATAFINALFERIAS, Date DATAABONO, Date DATAPGTO, int TIPORECIBO, int DIASABONO, int DIASFERIAS, Date DATAHORALCTO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATAINICIAL = DATAINICIAL;
        this.DATAINICIALFERIAS = DATAINICIALFERIAS;
        this.DATAFINALFERIAS = DATAFINALFERIAS;
        this.DATAABONO = DATAABONO;
        this.DATAPGTO = DATAPGTO;
        this.TIPORECIBO = TIPORECIBO;
        this.DIASABONO = DIASABONO;
        this.DIASFERIAS = DIASFERIAS;
        this.DATAHORALCTO = DATAHORALCTO;
    }

    public Date getAUXILIAR() {
        return AUXILIAR;
    }

    public void setAUXILIAR(Date AUXILIAR) {
        this.AUXILIAR = AUXILIAR;
    }

    public int getAUXILIAR2() {
        return AUXILIAR2;
    }

    public void setAUXILIAR2(int AUXILIAR2) {
        this.AUXILIAR2 = AUXILIAR2;
    }
        public int getAUXILIAR3() {
        return AUXILIAR3;
    }

    public void setAUXILIAR3(int AUXILIAR3) {
        this.AUXILIAR3 = AUXILIAR3;
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

    public Date getDATAINICIALFERIAS() {
        return DATAINICIALFERIAS;
    }

    public void setDATAINICIALFERIAS(Date DATAINICIALFERIAS) {
        this.DATAINICIALFERIAS = DATAINICIALFERIAS;
    }

    public Date getDATAFINALFERIAS() {
        return DATAFINALFERIAS;
    }

    public void setDATAFINALFERIAS(Date DATAFINALFERIAS) {
        this.DATAFINALFERIAS = DATAFINALFERIAS;
    }

    public Date getDATAABONO() {
        return DATAABONO;
    }

    public void setDATAABONO(Date DATAABONO) {
        this.DATAABONO = DATAABONO;
    }

    public Date getDATAPGTO() {
        return DATAPGTO;
    }

    public void setDATAPGTO(Date DATAPGTO) {
        this.DATAPGTO = DATAPGTO;
    }

    public int getTIPORECIBO() {
        return TIPORECIBO;
    }

    public void setTIPORECIBO(int TIPORECIBO) {
        this.TIPORECIBO = TIPORECIBO;
    }

    public int getDIASABONO() {
        return DIASABONO;
    }

    public void setDIASABONO(int DIASABONO) {
        this.DIASABONO = DIASABONO;
    }

    public int getDIASFERIAS() {
        return DIASFERIAS;
    }

    public void setDIASFERIAS(int DIASFERIAS) {
        this.DIASFERIAS = DIASFERIAS;
    }

    public Date getDATAHORALCTO() {
        return DATAHORALCTO;
    }

    public void setDATAHORALCTO(Date DATAHORALCTO) {
        this.DATAHORALCTO = DATAHORALCTO;
    }

    public Date defaultAUXILIAR(){
        java.util.Date dataUtil = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(AUXILIAR);
        c.add(Calendar.DATE, +1);
        dataUtil = c.getTime();
        
        this.DATAINICIAL = new java.sql.Date(dataUtil.getTime());
        
        return AUXILIAR;
    }
}
