package br.questor.teste.ebs.model;

import java.sql.Date;

public class FuncCargo {

    protected String TABELA = "FUNCCARGO";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOFUNCCONTR;
    protected Date DATAINICIAL;
    protected int CODIGOCARGO;
    
    public FuncCargo(){
        this.CODIGOEMPRESA = 0;
        this.CODIGOFUNCCONTR = 0;
        this.DATAINICIAL = DATAINICIAL;
        this.CODIGOCARGO = 0;
    }

    public FuncCargo(int CODIGOEMPRESA, int CODIGOFUNCCONTR, Date DATAINICIAL, int CODIGOCARGO) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOFUNCCONTR = CODIGOFUNCCONTR;
        this.DATAINICIAL = DATAINICIAL;
        this.CODIGOCARGO = CODIGOCARGO;
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

    public int getCODIGOCARGO() {
        return CODIGOCARGO;
    }

    public void setCODIGOCARGO(int CODIGOCARGO) {
        this.CODIGOCARGO = CODIGOCARGO;
    }
    
    
    
    
}
