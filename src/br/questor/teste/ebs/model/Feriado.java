package br.questor.teste.ebs.model;

import java.sql.Date;

public class Feriado {
    
    protected String TABELA = "FERIADO";
    
    protected Date DATAFERIADO; 

    public Feriado(){
        this.DATAFERIADO = DATAFERIADO;
    }
    
    public Feriado(Date DATAFERIADO) {
        this.DATAFERIADO = DATAFERIADO;
    }

    public String getTABELA(){
        return TABELA;
    }

    public Date getDATAFERIADO() {
        return DATAFERIADO;
    }

    public void setDATAFERIADO(Date DATAFERIADO) {
        this.DATAFERIADO = DATAFERIADO;
    }
}
