package br.questor.teste.ebs.model;

import java.sql.Date;
import java.util.Calendar;

public class PeriodoAquis {
    
    protected String TABELA = "PERIODOAQUIS";
    protected Date AUXILIAR;
    protected int AUXILIAR2 = 0;
    protected int AUXILIAR3 = 0;
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATAINICIAL;
    protected Date DATAFINAL;
    protected int SITPERIODO;
    protected int DIASJAPAGOS;
    protected int DIASABONO;
    protected int DIASFALTAS;
    protected int DIASAFAST;
    protected int DIASLICREM;
    protected int DIASSERVMILIT;
    protected Date DATALIMPGTO;
    protected int CODIGOUSUARIO;
    protected Date DATAHORALCTO;
    protected int ORIGEMDADO;
    
    public PeriodoAquis(){
        this.CODIGOEMPRESA = 0;
        this.CODIGOFUNCCONTR = 0;
        this.DATAINICIAL = DATAINICIAL;
        this.DATAFINAL = DATAFINAL;
        this.SITPERIODO = 0;
        this.DIASJAPAGOS = 0;
        this.DIASABONO = 0;
        this.DIASFALTAS = 0;
        this.DIASAFAST = 0;
        this.DIASLICREM = 0;
        this.DIASSERVMILIT = 0;
        this.DATALIMPGTO = DATALIMPGTO;
        this.CODIGOUSUARIO = 0;
        this.DATAHORALCTO = DATAHORALCTO;
        this.ORIGEMDADO = 0;
    }

    public PeriodoAquis(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATAINICIAL, Date DATAFINAL, int SITPERIODO, int DIASJAPAGOS, int DIASABONO, int DIASFALTAS, int DIASAFAST, int DIASLICREM, int DIASSERVMILIT, Date DATALIMPGTO, int CODIGOUSUARIO, Date DATAHORALCTO, int ORIGEMDADO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATAINICIAL = DATAINICIAL;
        this.DATAFINAL = DATAFINAL;
        this.SITPERIODO = SITPERIODO;
        this.DIASJAPAGOS = DIASJAPAGOS;
        this.DIASABONO = DIASABONO;
        this.DIASFALTAS = DIASFALTAS;
        this.DIASAFAST = DIASAFAST;
        this.DIASLICREM = DIASLICREM;
        this.DIASSERVMILIT = DIASSERVMILIT;
        this.DATALIMPGTO = DATALIMPGTO;
        this.CODIGOUSUARIO = CODIGOUSUARIO;
        this.DATAHORALCTO = DATAHORALCTO;
        this.ORIGEMDADO = ORIGEMDADO;
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

    public Date getDATAFINAL() {
        return DATAFINAL;
    }

    public void setDATAFINAL(Date DATAFINAL) {
        this.DATAFINAL = DATAFINAL;
    }

    public int getSITPERIODO() {
        return SITPERIODO;
    }

    public void setSITPERIODO(int SITPERIODO) {
        this.SITPERIODO = SITPERIODO;
    }

    public int getDIASJAPAGOS() {
        return DIASJAPAGOS;
    }

    public void setDIASJAPAGOS(int DIASJAPAGOS) {
        this.DIASJAPAGOS = DIASJAPAGOS;
    }

    public int getDIASABONO() {
        return DIASABONO;
    }

    public void setDIASABONO(int DIASABONO) {
        this.DIASABONO = DIASABONO;
    }

    public int getDIASFALTAS() {
        return DIASFALTAS;
    }

    public void setDIASFALTAS(int DIASFALTAS) {
        this.DIASFALTAS = DIASFALTAS;
    }

    public int getDIASAFAST() {
        return DIASAFAST;
    }

    public void setDIASAFAST(int DIASAFAST) {
        this.DIASAFAST = DIASAFAST;
    }

    public int getDIASLICREM() {
        return DIASLICREM;
    }

    public void setDIASLICREM(int DIASLICREM) {
        this.DIASLICREM = DIASLICREM;
    }

    public int getDIASSERVMILIT() {
        return DIASSERVMILIT;
    }

    public void setDIASSERVMILIT(int DIASSERVMILIT) {
        this.DIASSERVMILIT = DIASSERVMILIT;
    }

    public Date getDATALIMPGTO() {
        return DATALIMPGTO;
    }

    public void setDATALIMPGTO(Date DATALIMPGTO) {
        this.DATALIMPGTO = DATALIMPGTO;
    }

    public int getCODIGOUSUARIO() {
        return CODIGOUSUARIO;
    }

    public void setCODIGOUSUARIO(int CODIGOUSUARIO) {
        this.CODIGOUSUARIO = CODIGOUSUARIO;
    }

    public Date getDATAHORALCTO() {
        return DATAHORALCTO;
    }

    public void setDATAHORALCTO(Date DATAHORALCTO) {
        this.DATAHORALCTO = DATAHORALCTO;
    }

    public int getORIGEMDADO() {
        return ORIGEMDADO;
    }

    public void setORIGEMDADO(int ORIGEMDADO) {
        this.ORIGEMDADO = ORIGEMDADO;
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
