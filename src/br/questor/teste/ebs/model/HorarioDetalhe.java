package br.questor.teste.ebs.model;

public class HorarioDetalhe {
    
    protected String TABELA = "HORARIODETALHE";
 
    protected int CODIGOHORARIO;
    protected int HORAENTRADA;
    protected int HORASAIDA;
    protected int NUMEROHORAS;
    protected int TIPOALTERACAOESOCIAL;

    public HorarioDetalhe(){
        CODIGOHORARIO = 0;
        HORAENTRADA = 0;
        HORASAIDA = 0;
        NUMEROHORAS = 0;
        TIPOALTERACAOESOCIAL =0;
    }
    
    public HorarioDetalhe(int CODIGOHORARIO, int HORAENTRADA, int HORASAIDA, int NUMEROHORAS, int TIPOALTERACAOESOCIAL) {
        this.CODIGOHORARIO = CODIGOHORARIO;
        this.HORAENTRADA = HORAENTRADA;
        this.HORASAIDA = HORASAIDA;
        this.NUMEROHORAS = NUMEROHORAS;
        this.TIPOALTERACAOESOCIAL = TIPOALTERACAOESOCIAL;
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

    public int getHORAENTRADA() {
        return HORAENTRADA;
    }

    public void setHORAENTRADA(int HORAENTRADA) {
        this.HORAENTRADA = HORAENTRADA;
    }

    public int getHORASAIDA() {
        return HORASAIDA;
    }

    public void setHORASAIDA(int HORASAIDA) {
        this.HORASAIDA = HORASAIDA;
    }

    public int getNUMEROHORAS() {
        return NUMEROHORAS;
    }

    public void setNUMEROHORAS(int NUMEROHORAS) {
        this.NUMEROHORAS = NUMEROHORAS;
    }

    public int getTIPOALTERACAOESOCIAL() {
        return TIPOALTERACAOESOCIAL;
    }

    public void setTIPOALTERACAOESOCIAL(int TIPOALTERACAOESOCIAL) {
        this.TIPOALTERACAOESOCIAL = TIPOALTERACAOESOCIAL;
    }

}