package br.questor.teste.ebs.model;

import java.sql.Date;

public class INSSComp {
    
    protected String TABELA = "INSSCOMP";
    protected int AUXILIAR = 0;
    protected int AUXILIAR2 = 0;
    
    protected int CODIGOEMPRESA;
    protected int CODIGOESTAB;
    protected Date COMPET;
    protected double VALORORIG;
    protected Date COMPETINISEFIP;
    protected Date COMPETFINSEFIP;

    public INSSComp(){
        CODIGOEMPRESA = 0;
        CODIGOESTAB = 0;
        COMPET = COMPET;
        VALORORIG = 0;
        COMPETINISEFIP = COMPETINISEFIP;
        COMPETFINSEFIP = COMPETFINSEFIP;
    }
    
    public INSSComp(int CODIGOEMPRESA, int CODIGOESTAB, Date COMPET, double VALORORIG, Date COMPETINISEFIP, Date COMPETFINSEFIP) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOESTAB = CODIGOESTAB;
        this.COMPET = COMPET;
        this.VALORORIG = VALORORIG;
        this.COMPETINISEFIP = COMPETINISEFIP;
        this.COMPETFINSEFIP = COMPETFINSEFIP;
    }
    
    public String getTABELA(){
        return TABELA;
    }

    public int getAUXILIAR2() {
        return AUXILIAR2;
    }

    public void setAUXILIAR2(int AUXILIAR2) {
        this.AUXILIAR2 = AUXILIAR2;
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

    public int getCODIGOESTAB() {
        return CODIGOESTAB;
    }

    public void setCODIGOESTAB(int CODIGOESTAB) {
        this.CODIGOESTAB = CODIGOESTAB;
    }

    public Date getCOMPET() {
        return COMPET;
    }

    public void setCOMPET(Date COMPET) {
        this.COMPET = COMPET;
    }

    public double getVALORORIG() {
        return VALORORIG;
    }

    public void setVALORORIG(double VALORORIG) {
        this.VALORORIG = VALORORIG;
    }

    public Date getCOMPETINISEFIP() {
        return COMPETINISEFIP;
    }

    public void setCOMPETINISEFIP(Date COMPETINISEFIP) {
        this.COMPETINISEFIP = COMPETINISEFIP;
    }

    public Date getCOMPETFINSEFIP() {
        return COMPETFINSEFIP;
    }

    public void setCOMPETFINSEFIP(Date COMPETFINSEFIP) {
        this.COMPETFINSEFIP = COMPETFINSEFIP;
    }
    
    
    
}
