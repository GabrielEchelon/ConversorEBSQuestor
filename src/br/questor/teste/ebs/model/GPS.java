package br.questor.teste.ebs.model;

import java.sql.Date;
import java.util.Calendar;

public class GPS {
    
    protected String TABELA = "GPS";
    protected Date AUXILIAR;
    protected int AUXILIAR2 = 0;
    protected int AUXILIAR3 = 0;
    
    protected int CODIGOEMPRESA;
    protected int CODIGOIMPOSTO;
    protected int CODIGOIMPOSTO13;
    protected int CODIGOFPAS;
    protected int TERCEIROS;
    protected double PERCPARTETERC;
    protected Date DATAINICIAL;

    public GPS(){
        CODIGOEMPRESA = 0;
        CODIGOIMPOSTO = 0;
        CODIGOIMPOSTO13 = 0;
        CODIGOFPAS = 0;
        TERCEIROS = 0;
        PERCPARTETERC = 0.0;
        DATAINICIAL = DATAINICIAL;
    }
    
    public GPS(int CODIGOEMPRESA, int CODIGOIMPOSTO, int CODIGOIMPOSTO13, int CODIGOFPAS, int TERCEIROS, double PERCPARTETERC, Date DATAINICIAL) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOIMPOSTO = CODIGOIMPOSTO;
        this.CODIGOIMPOSTO13 = CODIGOIMPOSTO13;
        this.CODIGOFPAS = CODIGOFPAS;
        this.TERCEIROS = TERCEIROS;
        this.PERCPARTETERC = PERCPARTETERC;
        this.DATAINICIAL = DATAINICIAL;
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

    public int getCODIGOIMPOSTO() {
        return CODIGOIMPOSTO;
    }

    public void setCODIGOIMPOSTO(int CODIGOIMPOSTO) {
        this.CODIGOIMPOSTO = CODIGOIMPOSTO;
    }

    public int getCODIGOIMPOSTO13() {
        return CODIGOIMPOSTO13;
    }

    public void setCODIGOIMPOSTO13(int CODIGOIMPOSTO13) {
        this.CODIGOIMPOSTO13 = CODIGOIMPOSTO13;
    }

    public int getCODIGOFPAS() {
        return CODIGOFPAS;
    }

    public void setCODIGOFPAS(int CODIGOFPAS) {
        this.CODIGOFPAS = CODIGOFPAS;
    }

    public int getTERCEIROS() {
        return TERCEIROS;
    }

    public void setTERCEIROS(int TERCEIROS) {
        this.TERCEIROS = TERCEIROS;
    }

    public double getPERCPARTETERC() {
        return PERCPARTETERC;
    }

    public void setPERCPARTETERC(double PERCPARTETERC) {
        this.PERCPARTETERC = PERCPARTETERC;
    }
    
    public Date getDATAINICIAL() {
        return DATAINICIAL;
    }
    
    public void setDATAINICIAL(Date DATAINICIAL){
        this.DATAINICIAL = DATAINICIAL;
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
