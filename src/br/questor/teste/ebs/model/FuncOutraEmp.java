package br.questor.teste.ebs.model;

import java.sql.Date;

public class FuncOutraEmp {
    
    protected String TABELA = "FUNCOUTRAEMP";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATAINICIAL;
    protected Date DATAFINAL;
    protected int CODIGOOUTEMP;
    protected int CODIGOMOTIVO;

    public FuncOutraEmp(){
        CODIGOEMPRESA = 0;
        CODIGOFUNCCONTR = 0;
        DATAINICIAL = DATAINICIAL;
        DATAFINAL = DATAFINAL;
        CODIGOOUTEMP = 0;
        CODIGOMOTIVO = 0;
    }
    
    public FuncOutraEmp(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATAINICIAL, Date DATAFINAL, int CODIGOOUTEMP, int CODIGOMOTIVO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATAINICIAL = DATAINICIAL;
        this.DATAFINAL = DATAFINAL;
        this.CODIGOOUTEMP = CODIGOOUTEMP;
        this.CODIGOMOTIVO = CODIGOMOTIVO;
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

    public int getCODIGOOUTEMP() {
        return CODIGOOUTEMP;
    }

    public void setCODIGOOUTEMP(int CODIGOOUTEMP) {
        this.CODIGOOUTEMP = CODIGOOUTEMP;
    }

    public int getCODIGOMOTIVO() {
        return CODIGOMOTIVO;
    }

    public void setCODIGOMOTIVO(int CODIGOMOTIVO) {
        this.CODIGOMOTIVO = CODIGOMOTIVO;
    }
    
    
    
}
