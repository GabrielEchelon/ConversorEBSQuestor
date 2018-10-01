package br.questor.teste.ebs.model;


public class Escala {
    
    protected String TABELA = "ESCALA";
    
    protected int CODIGOESCALA;
    protected String DESCRESCALA;
    protected int CARGAHORMENSAL;
    protected int CARGAHORSEMANAL;
    protected int CARGAHORDIARIA;
    protected int TABELAFERIADO;
    protected int HORARIOVARIAVEL;
    protected int TURNO;

    public Escala(){
        CODIGOESCALA = 0;
        DESCRESCALA = "";
        CARGAHORMENSAL = 0;
        CARGAHORSEMANAL = 0;
        CARGAHORDIARIA = 0;
        TABELAFERIADO = 0;
        HORARIOVARIAVEL = 0;
        TURNO = 0;
    }
    
    public Escala(int CODIGOESCALA, String DESCRESCALA, int CARGAHORMENSAL, int CARGAHORSEMANAL, int CARGAHORDIARIA, int TABELAFERIADO, int HORARIOVARIAVEL, int TURNO) {
        this.CODIGOESCALA = CODIGOESCALA;
        this.DESCRESCALA = DESCRESCALA;
        this.CARGAHORMENSAL = CARGAHORMENSAL;
        this.CARGAHORSEMANAL = CARGAHORSEMANAL;
        this.CARGAHORDIARIA = CARGAHORDIARIA;
        this.TABELAFERIADO = TABELAFERIADO;
        this.HORARIOVARIAVEL = HORARIOVARIAVEL;
        this.TURNO = TURNO;
    }
    
    public String getTABELA(){
        return TABELA;
    }

    public int getCODIGOESCALA() {
        return CODIGOESCALA;
    }

    public void setCODIGOESCALA(int CODIGOESCALA) {
        this.CODIGOESCALA = CODIGOESCALA;
    }

    public String getDESCRESCALA() {
        return DESCRESCALA;
    }

    public void setDESCRESCALA(String DESCRESCALA) {
        this.DESCRESCALA = DESCRESCALA;
    }

    public int getCARGAHORMENSAL() {
        return CARGAHORMENSAL;
    }

    public void setCARGAHORMENSAL(int CARGAHORMENSAL) {
        this.CARGAHORMENSAL = CARGAHORMENSAL;
    }

    public int getCARGAHORSEMANAL() {
        return CARGAHORSEMANAL;
    }

    public void setCARGAHORSEMANAL(int CARGAHORSEMANAL) {
        this.CARGAHORSEMANAL = CARGAHORSEMANAL;
    }

    public int getCARGAHORDIARIA() {
        return CARGAHORDIARIA;
    }

    public void setCARGAHORDIARIA(int CARGAHORDIARIA) {
        this.CARGAHORDIARIA = CARGAHORDIARIA;
    }

    public int getTABELAFERIADO() {
        return TABELAFERIADO;
    }

    public void setTABELAFERIADO(int TABELAFERIADO) {
        this.TABELAFERIADO = TABELAFERIADO;
    }

    public int getHORARIOVARIAVEL() {
        return HORARIOVARIAVEL;
    }

    public void setHORARIOVARIAVEL(int HORARIOVARIAVEL) {
        this.HORARIOVARIAVEL = HORARIOVARIAVEL;
    }

    public int getTURNO() {
        return TURNO;
    }

    public void setTURNO(int TURNO) {
        this.TURNO = TURNO;
    }
    
}
