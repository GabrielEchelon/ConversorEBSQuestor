package br.questor.teste.ebs.model;

import java.sql.Date;

public class FuncLocal {
    
    protected String TABELA = "FUNCLOCAL";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATATRANSF;
    protected Date DATAHORACADAST;

    public FuncLocal(){
        CODIGOEMPRESA = 0;
        CODIGOFUNCCONTR = 0;
        DATATRANSF = DATATRANSF;
        DATAHORACADAST = DATAHORACADAST;
    }
    
    public FuncLocal(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATATRANSF, Date DATAHORACADAST) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATATRANSF = DATATRANSF;
        this.DATAHORACADAST = DATAHORACADAST;
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

    public Date getDATATRANSF() {
        return DATATRANSF;
    }

    public void setDATATRANSF(Date DATATRANSF) {
        this.DATATRANSF = DATATRANSF;
    }

    public Date getDATAHORACADAST() {
        return DATAHORACADAST;
    }

    public void setDATAHORACADAST(Date DATAHORACADAST) {
        this.DATAHORACADAST = DATAHORACADAST;
    }
}
