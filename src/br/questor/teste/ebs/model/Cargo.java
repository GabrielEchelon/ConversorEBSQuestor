package br.questor.teste.ebs.model;

import java.sql.Date;

public class Cargo {
    
    protected String TABELA = "CARGO";
    
    protected int CODIGOCARGO;
    protected Date DATAINICIAL;
    protected String DESCRCARGO;
    protected String CBO;
    protected String CBO94;

    public Cargo(){
        this.CODIGOCARGO = 0;
        this.DATAINICIAL = DATAINICIAL;
        this.DESCRCARGO = "";
        this.CBO = "";
        this.CBO94 = "";
    }
    
    public Cargo(int CODIGOCARGO, Date DATAINICIAL, String DESCRCARGO, String CBO, String CBO94) {
        this.CODIGOCARGO = CODIGOCARGO;
        this.DATAINICIAL = DATAINICIAL;
        this.DESCRCARGO = DESCRCARGO;
        this.CBO = CBO;
        this.CBO94 = CBO94;
    }
    
    public String getTABELA(){
        return TABELA;
    }

    public int getCODIGOCARGO() {
        return CODIGOCARGO;
    }

    public void setCODIGOCARGO(int CODIGOCARGO) {
        this.CODIGOCARGO = CODIGOCARGO;
    }

    public Date getDATAINICIAL() {
        return DATAINICIAL;
    }

    public void setDATAINICIAL(Date DATAINICIAL) {
        this.DATAINICIAL = DATAINICIAL;
    }

    public String getDESCRCARGO() {
        return DESCRCARGO;
    }

    public void setDESCRCARGO(String DESCRCARGO) {
        this.DESCRCARGO = DESCRCARGO;
    }

    public String getCBO() {
        return CBO;
    }

    public void setCBO(String CBO) {
        this.CBO = CBO;
    }

    public String getCBO94() {
        return CBO94;
    }

    public void setCBO94(String CBO94) {
        this.CBO94 = CBO94;
    }
}
