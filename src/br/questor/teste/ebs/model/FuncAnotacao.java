package br.questor.teste.ebs.model;

import java.sql.Date;

public class FuncAnotacao {
    
    protected String TABELA = "FUNCANOTACAO";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATAANOT;
    protected int SEQ;
    protected int CODIGOANOT;
    protected String OBSERV;
    
    public FuncAnotacao(){
        this.CODIGOEMPRESA = 0;
        this.CODIGOFUNCCONTR = 0;
        this.DATAANOT = DATAANOT;
        this.SEQ = 0;
        this.CODIGOANOT = 0;
        this.OBSERV = ""; 
    }

    public FuncAnotacao(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATAANOT, int SEQ, int CODIGOANOT, String OBSERV) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATAANOT = DATAANOT;
        this.SEQ = SEQ;
        this.CODIGOANOT = CODIGOANOT;
        this.OBSERV = OBSERV;
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

    public Date getDATAANOT() {
        return DATAANOT;
    }

    public void setDATAANOT(Date DATAANOT) {
        this.DATAANOT = DATAANOT;
    }

    public int getSEQ() {
        return SEQ;
    }

    public void setSEQ(int SEQ) {
        this.SEQ = SEQ;
    }

    public int getCODIGOANOT() {
        return CODIGOANOT;
    }

    public void setCODIGOANOT(int CODIGOANOT) {
        this.CODIGOANOT = CODIGOANOT;
    }

    public String getOBSERV() {
        return OBSERV;
    }

    public void setOBSERV(String OBSERV) {
        this.OBSERV = OBSERV;
    }
}
