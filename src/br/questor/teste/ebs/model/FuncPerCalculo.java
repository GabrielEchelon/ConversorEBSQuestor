package br.questor.teste.ebs.model;

import java.sql.Date;

public class FuncPerCalculo {
    
    protected String TABELA = "FUNCPERCALCULO";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOPERCALCULO;
    protected int CODIGOFUNCCONTR;
    protected Date DATACARGO;
    protected Date DATAESCALA;
    protected Date DATALOCAL;
    protected Date DATASALARIO;
    protected Date DATAPGTOFOLHA;
    protected int SEQCALCULO;
    protected Date DATAHORALCTO;
    
    public FuncPerCalculo(){
        CODIGOEMPRESA = 0;
        CODIGOPERCALCULO = 0;
        CODIGOFUNCCONTR = 0;
        DATACARGO = DATACARGO;
        DATAESCALA = DATAESCALA;
        DATALOCAL = DATALOCAL;
        DATASALARIO = DATASALARIO;
        DATAPGTOFOLHA = DATAPGTOFOLHA;
        SEQCALCULO = 0;
        DATAHORALCTO = DATAHORALCTO;
    }

    public FuncPerCalculo(int CODIGOEMPRESA, int CODIGOPERCALCULO, int CODIGOFUNCCONTR, Date DATACARGO, Date DATAESCALA, Date DATALOCAL, Date DATASALARIO, Date DATAPGTOFOLHA, int SEQCALCULO, Date DATAHORALCTO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOPERCALCULO = CODIGOPERCALCULO;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATACARGO = DATACARGO;
        this.DATAESCALA = DATAESCALA;
        this.DATALOCAL = DATALOCAL;
        this.DATASALARIO = DATASALARIO;
        this.DATAPGTOFOLHA = DATAPGTOFOLHA;
        this.SEQCALCULO = SEQCALCULO;
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

    public int getCODIGOPERCALCULO() {
        return CODIGOPERCALCULO;
    }

    public void setCODIGOPERCALCULO(int CODIGOPERCALCULO) {
        this.CODIGOPERCALCULO = CODIGOPERCALCULO;
    }

    public int getCODIGOFUNCCONTR() {
        return CODIGOFUNCCONTR;
    }

    public void setCODIGOFUNCCONTR(int CODIGOFUNCCONTR) {
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
    }

    public Date getDATACARGO() {
        return DATACARGO;
    }

    public void setDATACARGO(Date DATACARGO) {
        this.DATACARGO = DATACARGO;
    }

    public Date getDATAESCALA() {
        return DATAESCALA;
    }

    public void setDATAESCALA(Date DATAESCALA) {
        this.DATAESCALA = DATAESCALA;
    }

    public Date getDATALOCAL() {
        return DATALOCAL;
    }

    public void setDATALOCAL(Date DATALOCAL) {
        this.DATALOCAL = DATALOCAL;
    }

    public Date getDATASALARIO() {
        return DATASALARIO;
    }

    public void setDATASALARIO(Date DATASALARIO) {
        this.DATASALARIO = DATASALARIO;
    }

    public Date getDATAPGTOFOLHA() {
        return DATAPGTOFOLHA;
    }

    public void setDATAPGTOFOLHA(Date DATAPGTOFOLHA) {
        this.DATAPGTOFOLHA = DATAPGTOFOLHA;
    }

    public int getSEQCALCULO() {
        return SEQCALCULO;
    }

    public void setSEQCALCULO(int SEQCALCULO) {
        this.SEQCALCULO = SEQCALCULO;
    }

    public Date getDATAHORALCTO() {
        return DATAHORALCTO;
    }

    public void setDATAHORALCTO(Date DATAHORALCTO) {
        this.DATAHORALCTO = DATAHORALCTO;
    }
    
    
    
}
