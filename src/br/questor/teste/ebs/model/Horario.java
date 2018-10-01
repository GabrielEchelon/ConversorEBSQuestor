package br.questor.teste.ebs.model;

import java.sql.Date;

public class Horario {
    
    protected String TABELA = "HORARIO";
    
    protected int CODIGOHORARIO;
    protected Date DATAINICIAL;
    protected String DESCRHORARIO;
    protected int SEQ = 0;
    
    public Horario(){
        this.CODIGOHORARIO = 0;
        this.DATAINICIAL = DATAINICIAL;
        this.DESCRHORARIO = "";
    }

    public Horario(int CODIGOHORARIO, Date DATAINICIAL, String DESCRHORARIO) {
        this.CODIGOHORARIO = CODIGOHORARIO;
        this.DATAINICIAL = DATAINICIAL;
        this.DESCRHORARIO = DESCRHORARIO;
    }
    
    public String getTABELA(){
        return TABELA;
    }

    public int getCODIGOHORARIO() {
        return CODIGOHORARIO;
    }

    public void setCODIGOHORARIO(int CODIGOHORARIO) {
        this.CODIGOHORARIO = CODIGOHORARIO;
    }

    public Date getDATAINICIAL() {
        return DATAINICIAL;
    }

    public void setDATAINICIAL(Date DATAINICIAL) {
        this.DATAINICIAL = DATAINICIAL;
    }

    public String getDESCRHORARIO() {
        return DESCRHORARIO;
    }

    public void setDESCRHORARIO(String DESCRHORARIO) {
        this.DESCRHORARIO = DESCRHORARIO;
    }

    public int getSEQ() {
        return SEQ;
    }

    public void setSEQ(int SEQ) {
        this.SEQ = SEQ;
    }

    
    
}
