package br.questor.teste.ebs.model;

import java.sql.Date;

public class PeriodoCalculo {
    
    protected String TABELA = "PERIODOCALCULO";
    protected int AUXILIAR = 0;
    
    protected int CODIGOEMPRESA;
    protected Date COMPET;
    protected Date DATAINICIALFOLHA;
    protected Date DATAFINALFOLHA;
    protected Date DATAPGTO;
    protected Date DATAPGTODIRET;

    public PeriodoCalculo(){
        CODIGOEMPRESA = 0;
        COMPET = COMPET;
        DATAINICIALFOLHA = DATAINICIALFOLHA;
        DATAFINALFOLHA = DATAFINALFOLHA;
        DATAPGTO = DATAPGTO;
        DATAPGTODIRET = DATAPGTODIRET;
    }
    
    public PeriodoCalculo(int CODIGOEMPRESA, Date COMPET, Date DATAINICIALFOLHA, Date DATAFINALFOLHA, Date DATAPGTO, Date DATAPGTODIRET) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.COMPET = COMPET;
        this.DATAINICIALFOLHA = DATAINICIALFOLHA;
        this.DATAFINALFOLHA = DATAFINALFOLHA;
        this.DATAPGTO = DATAPGTO;
        this.DATAPGTODIRET = DATAPGTODIRET;
    }

    public String getTABELA(){
        return TABELA;
    }

    public int getAUXILIAR() {
        return AUXILIAR;
    }

    public void setAUXILIAR(int AUXILIAR) {
        this.AUXILIAR = AUXILIAR;
    }
    
    public int getCODIGOEMPRESA() {
        return CODIGOEMPRESA;
    }

    public void setCODIGOEMPRESA(int CODIGOEMPRESA) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
    }

    public Date getCOMPET() {
        return COMPET;
    }

    public void setCOMPET(Date COMPET) {
        this.COMPET = COMPET;
    }

    public Date getDATAINICIALFOLHA() {
        return DATAINICIALFOLHA;
    }

    public void setDATAINICIALFOLHA(Date DATAINICIALFOLHA) {
        this.DATAINICIALFOLHA = DATAINICIALFOLHA;
    }

    public Date getDATAFINALFOLHA() {
        return DATAFINALFOLHA;
    }

    public void setDATAFINALFOLHA(Date DATAFINALFOLHA) {
        this.DATAFINALFOLHA = DATAFINALFOLHA;
    }

    public Date getDATAPGTO() {
        return DATAPGTO;
    }

    public void setDATAPGTO(Date DATAPGTO) {
        this.DATAPGTO = DATAPGTO;
    }

    public Date getDATAPGTODIRET() {
        return DATAPGTODIRET;
    }

    public void setDATAPGTODIRET(Date DATAPGTODIRET) {
        this.DATAPGTODIRET = DATAPGTODIRET;
    }
    
    
    
}
