package br.questor.teste.ebs.model;

import java.sql.Date;

public class QST_FuncLocal {
    
    protected int CODIGOEMPRESA = 0;
    protected int CODIGOFUNCCONTR = 0;
    protected Date DATAADM = null;
    protected Date DATAHORACADAST = null;
    protected String CLASSIFORGAN = "";

    public String getCLASSIFORGAN() {
        return CLASSIFORGAN;
    }

    public void setCLASSIFORGAN(String CLASSIFORGAN) {
        this.CLASSIFORGAN = CLASSIFORGAN;
    }

    public Date getDATAHORACADAST() {
        return DATAHORACADAST;
    }

    public void setDATAHORACADAST(Date DATAHORACADAST) {
        this.DATAHORACADAST = DATAHORACADAST;
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

    public Date getDATAADM() {
        return DATAADM;
    }

    public void setDATAADM(Date DATAADM) {
        this.DATAADM = DATAADM;
    }
    
        
}
