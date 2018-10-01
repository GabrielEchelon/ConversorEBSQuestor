package br.questor.teste.ebs.model;

import java.sql.Date;

public class Dependente {
    
    protected String TABELA = "DEPENDENTE";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected int CODIGODEPEND;
    protected String CPFDEPEND;
    protected String NOMEDEPEND;
    protected Date DATANASC;
    protected String PARENTESCO;
    protected int SEXO;

    public Dependente(){
        this.CODIGOEMPRESA = 0;
        this.CODIGOFUNCCONTR = 0;
        this.CODIGODEPEND = 0;
        this.CPFDEPEND = "";
        this.NOMEDEPEND = "";
        this.DATANASC = DATANASC;
        this.PARENTESCO = "";
        this.SEXO = 0;
    }
    
    public Dependente(int CODIGOEMPRESA, int CODIGOFUNCCONTR, int CODIGODEPEND, String CPFDEPEND, String NOMEDEPEND, Date DATANASC, String PARENTESCO, int SEXO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.CODIGODEPEND = CODIGODEPEND;
        this.CPFDEPEND = CPFDEPEND;
        this.NOMEDEPEND = NOMEDEPEND;
        this.DATANASC = DATANASC;
        this.PARENTESCO = PARENTESCO;
        this.SEXO = SEXO;
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

    public int getCODIGODEPEND() {
        return CODIGODEPEND;
    }

    public void setCODIGODEPEND(int CODIGODEPEND) {
        this.CODIGODEPEND = CODIGODEPEND;
    }

    public String getCPFDEPEND() {
        return CPFDEPEND;
    }

    public void setCPFDEPEND(String CPFDEPEND) {
        this.CPFDEPEND = CPFDEPEND;
    }

    public String getNOMEDEPEND() {
        return NOMEDEPEND;
    }

    public void setNOMEDEPEND(String NOMEDEPEND) {
        this.NOMEDEPEND = NOMEDEPEND;
    }

    public Date getDATANASC() {
        return DATANASC;
    }

    public void setDATANASC(Date DATANASC) {
        this.DATANASC = DATANASC;
    }

    public String getPARENTESCO() {
        return PARENTESCO;
    }

    public void setPARENTESCO(String PARENTESCO) {
        this.PARENTESCO = PARENTESCO;
    }

    public int getSEXO() {
        return SEXO;
    }

    public void setSEXO(int SEXO) {
        this.SEXO = SEXO;
    }
    
    
}
