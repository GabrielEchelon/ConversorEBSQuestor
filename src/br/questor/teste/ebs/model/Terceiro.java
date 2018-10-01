package br.questor.teste.ebs.model;

import java.sql.Date;

public class Terceiro {
    
    protected String TABELA = "TERCEIRO";
    
    protected int CODIGOTERC;
    protected String NOMETERC;
    protected int SEXO;
    protected String PISTERC;
    protected String CPFTERC;
    protected String NUMERORG;
    protected String ORGEMISRG;
    protected Date DATAHORACADAST;

    public Terceiro(){
        CODIGOTERC = 0;
        NOMETERC = "";
        SEXO = 0;
        PISTERC = "";
        CPFTERC = "";
        NUMERORG = "";
        ORGEMISRG = "";
        DATAHORACADAST = DATAHORACADAST;
    }
    
    public Terceiro(int CODIGOTERC, String NOMETERC, int SEXO, String PISTERC, String CPFTERC, String NUMERORG, String ORGEMISRG, Date DATAHORACADAST) {
        this.CODIGOTERC = CODIGOTERC;
        this.NOMETERC = NOMETERC;
        this.SEXO = SEXO;
        this.PISTERC = PISTERC;
        this.CPFTERC = CPFTERC;
        this.NUMERORG = NUMERORG;
        this.ORGEMISRG = ORGEMISRG;
        this.DATAHORACADAST = DATAHORACADAST;
    }

    public String getTABELA(){
        return TABELA;
    }

    public int getCODIGOTERC() {
        return CODIGOTERC;
    }

    public void setCODIGOTERC(int CODIGOTERC) {
        this.CODIGOTERC = CODIGOTERC;
    }

    public String getNOMETERC() {
        return NOMETERC;
    }

    public void setNOMETERC(String NOMETERC) {
        this.NOMETERC = NOMETERC;
    }

    public int getSEXO() {
        return SEXO;
    }

    public void setSEXO(int SEXO) {
        this.SEXO = SEXO;
    }

    public String getPISTERC() {
        return PISTERC;
    }

    public void setPISTERC(String PISTERC) {
        this.PISTERC = PISTERC;
    }

    public String getCPFTERC() {
        return CPFTERC;
    }

    public void setCPFTERC(String CPFTERC) {
        this.CPFTERC = CPFTERC;
    }

    public String getNUMERORG() {
        return NUMERORG;
    }

    public void setNUMERORG(String NUMERORG) {
        this.NUMERORG = NUMERORG;
    }

    public String getORGEMISRG() {
        return ORGEMISRG;
    }

    public void setORGEMISRG(String ORGEMISRG) {
        this.ORGEMISRG = ORGEMISRG;
    }

    public Date getDATAHORACADAST() {
        return DATAHORACADAST;
    }

    public void setDATAHORACADAST(Date DATAHORACADAST) {
        this.DATAHORACADAST = DATAHORACADAST;
    }
    
}