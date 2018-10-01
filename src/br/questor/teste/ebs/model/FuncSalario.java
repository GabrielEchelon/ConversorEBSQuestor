package br.questor.teste.ebs.model;

import java.sql.Date;

public class FuncSalario {
    
    protected String TABELA = "FUNCSALARIO";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATAINICIAL;
    protected int TIPOSALARIO;
    protected double VALORSAL;
    protected double ANTECSAL;

    public FuncSalario(){
        this.CODIGOEMPRESA = 0;
        this.CODIGOFUNCCONTR = 0;
        this.DATAINICIAL = DATAINICIAL;
        this.TIPOSALARIO = 0;
        this.VALORSAL = 0.0;
        this.ANTECSAL = 0;
    }

    public FuncSalario(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATAINICIAL, int TIPOSALARIO, double VALORSAL, double ANTECSAL) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATAINICIAL = DATAINICIAL;
        this.TIPOSALARIO = TIPOSALARIO;
        this.VALORSAL = VALORSAL;
        this.ANTECSAL = ANTECSAL;
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

    public int getTIPOSALARIO() {
        return TIPOSALARIO;
    }

    public void setTIPOSALARIO(int TIPOSALARIO) {
        this.TIPOSALARIO = TIPOSALARIO;
    }

    public double getVALORSAL() {
        return VALORSAL;
    }

    public void setVALORSAL(double VALORSAL) {
        this.VALORSAL = VALORSAL;
    }

    public double getANTECSAL() {
        return ANTECSAL;
    }

    public void setANTECSAL(double ANTECSAL) {
        this.ANTECSAL = ANTECSAL;
    } 
}
