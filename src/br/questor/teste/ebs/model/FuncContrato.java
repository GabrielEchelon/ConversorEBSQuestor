package br.questor.teste.ebs.model;

import java.sql.Date;

public class FuncContrato {
    
    protected String TABELA = "FUNCCONTRATO";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected int CODIGOFUNCPESSOA;
    protected int CODIGOTIPOCONTR;
    protected Date DATAADM;
    protected Date DATAOPCAOFGTS;
    protected int CONTAFGTS;
    protected String TIPOVINCULO;
    protected String CATEGORIA;
    protected int RECEBEADTO;
    protected int PERCADTO;
    protected int MODOPGTO;
    protected int NUMEROAGENCIA;
    protected int NUMEROCONTA;
    protected String DIGITOCONTA;
    protected int DIACONTREXP;
    protected Date DATAHORALCTO;
    protected int INDICATPRIMEMP;

    public FuncContrato(){
        this.CODIGOEMPRESA = 0;
        this.CODIGOFUNCCONTR = 0;
        this.CODIGOFUNCPESSOA = 0;
        this.CODIGOTIPOCONTR = 0;
        this.DATAADM = DATAADM;
        this.DATAOPCAOFGTS = DATAOPCAOFGTS;
        this.CONTAFGTS = 0;
        this.TIPOVINCULO = "";
        this.CATEGORIA = "";
        this.RECEBEADTO = 0;
        this.PERCADTO = 0;
        this.MODOPGTO = 0;
        this.NUMEROAGENCIA = 0;
        this.NUMEROCONTA = 0;
        this.DIGITOCONTA = "";
        this.DIACONTREXP = 0;
        this.DATAHORALCTO = DATAHORALCTO;
        this.INDICATPRIMEMP = 0;
    }
    
    public FuncContrato(int CODIGOEMPRESA, int CODIGOFUNCCONTR, int CODIGOFUNCPESSOA, int CODIGOTIPOCONTR, Date DATAADM, Date DATAOPCAOFGTS, int CONTAFGTS, String TIPOVINCULO, String CATEGORIA, int RECEBEADTO, int PERCADTO, int MODOPGTO, int NUMEROAGENCIA, int NUMEROCONTA, String DIGITOCONTA, int DIACONTREXP, Date DATAHORALCTO, int INDICATPRIMEMP) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.CODIGOFUNCPESSOA = CODIGOFUNCPESSOA;
        this.CODIGOTIPOCONTR = CODIGOTIPOCONTR;
        this.DATAADM = DATAADM;
        this.DATAOPCAOFGTS = DATAOPCAOFGTS;
        this.CONTAFGTS = CONTAFGTS;
        this.TIPOVINCULO = TIPOVINCULO;
        this.CATEGORIA = CATEGORIA;
        this.RECEBEADTO = RECEBEADTO;
        this.PERCADTO = PERCADTO;
        this.MODOPGTO = MODOPGTO;
        this.NUMEROAGENCIA = NUMEROAGENCIA;
        this.NUMEROCONTA = NUMEROCONTA;
        this.DIGITOCONTA = DIGITOCONTA;
        this.DIACONTREXP = DIACONTREXP;
        this.DATAHORALCTO = DATAHORALCTO;
        this.INDICATPRIMEMP = INDICATPRIMEMP;
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

    public int getCODIGOFUNCPESSOA() {
        return CODIGOFUNCPESSOA;
    }

    public void setCODIGOFUNCPESSOA(int CODIGOFUNCPESSOA) {
        this.CODIGOFUNCPESSOA = CODIGOFUNCPESSOA;
    }

    public int getCODIGOTIPOCONTR() {
        return CODIGOTIPOCONTR;
    }

    public void setCODIGOTIPOCONTR(int CODIGOTIPOCONTR) {
        this.CODIGOTIPOCONTR = CODIGOTIPOCONTR;
    }

    public Date getDATAADM() {
        return DATAADM;
    }

    public void setDATAADM(Date DATAADM) {
        this.DATAADM = DATAADM;
    }

    public Date getDATAOPCAOFGTS() {
        return DATAOPCAOFGTS;
    }

    public void setDATAOPCAOFGTS(Date DATAOPCAOFGTS) {
        this.DATAOPCAOFGTS = DATAOPCAOFGTS;
    }

    public int getCONTAFGTS() {
        return CONTAFGTS;
    }

    public void setCONTAFGTS(int CONTAFGTS) {
        this.CONTAFGTS = CONTAFGTS;
    }

    public String getTIPOVINCULO() {
        return TIPOVINCULO;
    }

    public void setTIPOVINCULO(String TIPOVINCULO) {
        this.TIPOVINCULO = TIPOVINCULO;
    }

    public String getCATEGORIA() {
        return CATEGORIA;
    }

    public void setCATEGORIA(String CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    public int getRECEBEADTO() {
        return RECEBEADTO;
    }

    public void setRECEBEADTO(int RECEBEADTO) {
        this.RECEBEADTO = RECEBEADTO;
    }

    public int getPERCADTO() {
        return PERCADTO;
    }

    public void setPERCADTO(int PERCADTO) {
        this.PERCADTO = PERCADTO;
    }

    public int getMODOPGTO() {
        return MODOPGTO;
    }

    public void setMODOPGTO(int MODOPGTO) {
        this.MODOPGTO = MODOPGTO;
    }

    public int getNUMEROAGENCIA() {
        return NUMEROAGENCIA;
    }

    public void setNUMEROAGENCIA(int NUMEROAGENCIA) {
        this.NUMEROAGENCIA = NUMEROAGENCIA;
    }

    public String getDIGITOCONTA() {
        return DIGITOCONTA;
    }

    public void setDIGITOCONTA(String DIGITOCONTA) {
        this.DIGITOCONTA = DIGITOCONTA;
    }

    public int getDIACONTREXP() {
        return DIACONTREXP;
    }

    public void setDIACONTREXP(int DIACONTREXP) {
        this.DIACONTREXP = DIACONTREXP;
    }

    public Date getDATAHORALCTO() {
        return DATAHORALCTO;
    }

    public void setDATAHORALCTO(Date DATAHORALCTO) {
        this.DATAHORALCTO = DATAHORALCTO;
    }

    public int getINDICATPRIMEMP() {
        return INDICATPRIMEMP;
    }

    public void setINDICATPRIMEMP(int INDICATPRIMEMP) {
        this.INDICATPRIMEMP = INDICATPRIMEMP;
    }

    public int getNUMEROCONTA() {
        return NUMEROCONTA;
    }

    public void setNUMEROCONTA(int NUMEROCONTA) {
        this.NUMEROCONTA = NUMEROCONTA;
    }
    
    
}
