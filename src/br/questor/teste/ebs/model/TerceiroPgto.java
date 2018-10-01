package br.questor.teste.ebs.model;

import java.sql.Date;

public class TerceiroPgto {

    protected String TABELA = "TERCEIROPGTO";
    protected int AUXILIAR = 0;
    protected int AUXILIAR2 = 0;
    protected Date AUXILIAR3;
    
    protected int CODIGOEMPRESA;
    protected int CODIGOTERC;
    protected Date COMPET;
    protected double VALORBRUTO;
    protected double VALORISS;
    protected double BASEIRRF;
    protected double DEDUCAOINSS;
    protected Date DATAPGTO;

    public TerceiroPgto(){
        CODIGOEMPRESA = 0;
        CODIGOTERC = 0;
        COMPET = COMPET;
        VALORBRUTO = 0;
        VALORISS = 0;
        BASEIRRF = 0;
        DEDUCAOINSS = 0;
        DATAPGTO = DATAPGTO;
    }
    
    public TerceiroPgto(int CODIGOEMPRESA, int CODIGOTERC, Date COMPET, double VALORBRUTO, double VALORISS, double BASEIRRF, double DEDUCAOINSS, Date DATAPGTO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOTERC = CODIGOTERC;
        this.COMPET = COMPET;
        this.VALORBRUTO = VALORBRUTO;
        this.VALORISS = VALORISS;
        this.BASEIRRF = BASEIRRF;
        this.DEDUCAOINSS = DEDUCAOINSS;
        this.DATAPGTO = DATAPGTO;
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

    public int getAUXILIAR2() {
        return AUXILIAR2;
    }

    public void setAUXILIAR2(int AUXILIAR2) {
        this.AUXILIAR2 = AUXILIAR2;
    }

    public Date getAUXILIAR3() {
        return AUXILIAR3;
    }

    public void setAUXILIAR3(Date AUXILIAR3) {
        this.AUXILIAR3 = AUXILIAR3;
    }
    
    
    
    public int getCODIGOEMPRESA() {
        return CODIGOEMPRESA;
    }

    public void setCODIGOEMPRESA(int CODIGOEMPRESA) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
    }

    public int getCODIGOTERC() {
        return CODIGOTERC;
    }

    public void setCODIGOTERC(int CODIGOTERC) {
        this.CODIGOTERC = CODIGOTERC;
    }

    public Date getCOMPET() {
        return COMPET;
    }

    public void setCOMPET(Date COMPET) {
        this.COMPET = COMPET;
    }

    public double getVALORBRUTO() {
        return VALORBRUTO;
    }

    public void setVALORBRUTO(double VALORBRUTO) {
        this.VALORBRUTO = VALORBRUTO;
    }

    public double getVALORISS() {
        return VALORISS;
    }

    public void setVALORISS(double VALORISS) {
        this.VALORISS = VALORISS;
    }

    public double getBASEIRRF() {
        return BASEIRRF;
    }

    public void setBASEIRRF(double BASEIRRF) {
        this.BASEIRRF = BASEIRRF;
    }

    public double getDEDUCAOINSS() {
        return DEDUCAOINSS;
    }

    public void setDEDUCAOINSS(double DEDUCAOINSS) {
        this.DEDUCAOINSS = DEDUCAOINSS;
    }

    public Date getDATAPGTO() {
        return DATAPGTO;
    }

    public void setDATAPGTO(Date DATAPGTO) {
        this.DATAPGTO = DATAPGTO;
    }

    
    
}
