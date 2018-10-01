package br.questor.teste.ebs.model;

public class Cbo {
    
    protected String TABELA = "CBO";
    
    protected int CBO; 
    protected String DESCRCBO;

    public Cbo(){
        CBO = 0;
        DESCRCBO = "";
    }
    
    public Cbo(int CBO, String DESCRCBO) {
        this.CBO = CBO;
        this.DESCRCBO = DESCRCBO;
    }

    public String getTABELA(){
        return TABELA;
    }
    
    public int getCBO() {
        return CBO;
    }

    public void setCBO(int CBO) {
        this.CBO = CBO;
    }

    public String getDESCRCBO() {
        return DESCRCBO;
    }

    public void setDESCRCBO(String DESCRCBO) {
        this.DESCRCBO = DESCRCBO;
    }
    
    
    
}
