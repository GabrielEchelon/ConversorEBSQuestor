package br.questor.teste.ebs.model;

import java.sql.Date;

public class PensaoJud {
    
    protected String TABELA = "PENSAOJUD";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected int CODIGOBENEF;
    protected String NOMEBENEF;
    protected double PERCVALOR;
    protected Date DATANASC;
    protected String CPFBENEF;
    protected int PARENTESCO;

    public PensaoJud(){
        CODIGOEMPRESA = 0;
        CODIGOFUNCCONTR = 0;
        CODIGOBENEF = 0;
        NOMEBENEF = "";
        PERCVALOR = 0;
        DATANASC = DATANASC;
        CPFBENEF = "";
        PARENTESCO = 0;
    }
    
    public PensaoJud(int CODIGOEMPRESA, int CODIGOFUNCCONTR, int CODIGOBENEF, String NOMEBENEF, double PERCVALOR, Date DATANASC, String CPFBENEF, int PARENTESCO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.CODIGOBENEF = CODIGOBENEF;
        this.NOMEBENEF = NOMEBENEF;
        this.PERCVALOR = PERCVALOR;
        this.DATANASC = DATANASC;
        this.CPFBENEF = CPFBENEF;
        this.PARENTESCO = PARENTESCO;
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

    public int getCODIGOBENEF() {
        return CODIGOBENEF;
    }

    public void setCODIGOBENEF(int CODIGOBENEF) {
        this.CODIGOBENEF = CODIGOBENEF;
    }

    public String getNOMEBENEF() {
        return NOMEBENEF;
    }

    public void setNOMEBENEF(String NOMEBENEF) {
        this.NOMEBENEF = NOMEBENEF;
    }

    public double getPERCVALOR() {
        return PERCVALOR;
    }

    public void setPERCVALOR(double PERCVALOR) {
        this.PERCVALOR = PERCVALOR;
    }

    public Date getDATANASC() {
        return DATANASC;
    }

    public void setDATANASC(Date DATANASC) {
        this.DATANASC = DATANASC;
    }

    public String getCPFBENEF() {
        return CPFBENEF;
    }

    public void setCPFBENEF(String CPFBENEF) {
        this.CPFBENEF = CPFBENEF;
    }

    public int getPARENTESCO() {
        return PARENTESCO;
    }

    public void setPARENTESCO(int PARENTESCO) {
        this.PARENTESCO = PARENTESCO;
    }
    
    
    
}
