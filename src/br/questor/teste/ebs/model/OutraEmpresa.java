package br.questor.teste.ebs.model;

public class OutraEmpresa {
    
    protected String TABELA = "OUTRAEMPRESA";
    protected int AUXILIAR = 0;
    
    protected int CODIGOEMPRESA;
    protected int CODIGOOUTEMP;
    protected String NOMEOUTEMP;
    protected String ENDEROUTEMP;
    protected int NUMEROENDER;
    protected String COMPLENDER;
    protected String BAIRROOUTEMP;
    protected String CEP;
    protected String SIGLAESTADO;
    protected int CODIGOMUNIC;
    protected String INSCRFEDERAL;
    protected int TIPOINSCR;
    protected int TIPOOUTEMP;

    public OutraEmpresa(){
        this.CODIGOEMPRESA = 0;
        this.CODIGOOUTEMP = 0;
        this.NOMEOUTEMP = " ";
        this.ENDEROUTEMP = " ";
        this.NUMEROENDER = 0;
        this.COMPLENDER = " ";
        this.BAIRROOUTEMP = " ";
        this.CEP = " ";
        this.SIGLAESTADO = " ";
        this.CODIGOMUNIC = 0;
        this.INSCRFEDERAL = " ";
        this.TIPOINSCR = 0;
        this.TIPOOUTEMP = 0;
    }
    
    public OutraEmpresa(int CODIGOEMPRESA,int CODIGOOUTEMP, String NOMEOUTEMP, String ENDEROUTEMP, int NUMEROENDER, String COMPLENDER, String BAIRROOUTEMP, String CEP, String SIGLAESTADO, int CODIGOMUNIC, String INSCRFEDERAL, int TIPOINSCR, int TIPOOUTEMP) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOOUTEMP = CODIGOOUTEMP;
        this.NOMEOUTEMP = NOMEOUTEMP;
        this.ENDEROUTEMP = ENDEROUTEMP;
        this.NUMEROENDER = NUMEROENDER;
        this.COMPLENDER = COMPLENDER;
        this.BAIRROOUTEMP = BAIRROOUTEMP;
        this.CEP = CEP;
        this.SIGLAESTADO = SIGLAESTADO;
        this.CODIGOMUNIC = CODIGOMUNIC;
        this.INSCRFEDERAL = INSCRFEDERAL;
        this.TIPOINSCR = TIPOINSCR;
        this.TIPOOUTEMP = TIPOOUTEMP;
    }

    public int getAUXILIAR() {
        return AUXILIAR;
    }

    public void setAUXILIAR(int AUXILIAR) {
        this.AUXILIAR = AUXILIAR;
    }
    
    
    
    public String getTABELA(){
        return TABELA;
    }
    
    public int getTIPOOUTEMP(){
        return TIPOOUTEMP;
    }
    
    public void setTIPOOUTEMP(int TIPOOUTEMP){
        this.TIPOOUTEMP = TIPOOUTEMP;
    }
    
    public int getCODIGOEMPRESA(){
        return CODIGOEMPRESA;
    }
    
    public void setCODIGOEMPRESA(int CODIGOEMPRESA){
        this.CODIGOEMPRESA = CODIGOEMPRESA;
    }

    public int getCODIGOOUTEMP() {
        return CODIGOOUTEMP;
    }

    public void setCODIGOOUTEMP(int CODIGOOUTEMP) {
        this.CODIGOOUTEMP = CODIGOOUTEMP;
    }

    public String getNOMEOUTEMP() {
        return NOMEOUTEMP;
    }

    public void setNOMEOUTEMP(String NOMEOUTEMP) {
        this.NOMEOUTEMP = NOMEOUTEMP;
    }

    public String getENDEROUTEMP() {
        return ENDEROUTEMP;
    }

    public void setENDEROUTEMP(String ENDEROUTEMP) {
        this.ENDEROUTEMP = ENDEROUTEMP;
    }

    public int getNUMEROENDER() {
        return NUMEROENDER;
    }

    public void setNUMEROENDER(int NUMEROENDER) {
        this.NUMEROENDER = NUMEROENDER;
    }

    public String getCOMPLENDER() {
        return COMPLENDER;
    }

    public void setCOMPLENDER(String COMPLENDER) {
        this.COMPLENDER = COMPLENDER;
    }

    public String getBAIRROOUTEMP() {
        return BAIRROOUTEMP;
    }

    public void setBAIRROOUTEMP(String BAIRROOUTEMP) {
        this.BAIRROOUTEMP = BAIRROOUTEMP;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getSIGLAESTADO() {
        return SIGLAESTADO;
    }

    public void setSIGLAESTADO(String SIGLAESTADO) {
        this.SIGLAESTADO = SIGLAESTADO;
    }

    public int getCODIGOMUNIC() {
        return CODIGOMUNIC;
    }

    public void setCODIGOMUNIC(int CODIGOMUNIC) {
        this.CODIGOMUNIC = CODIGOMUNIC;
    }

    public String getINSCRFEDERAL() {
        return INSCRFEDERAL;
    }

    public void setINSCRFEDERAL(String INSCRFEDERAL) {
        this.INSCRFEDERAL = INSCRFEDERAL;
    }

    public int getTIPOINSCR() {
        return TIPOINSCR;
    }

    public void setTIPOINSCR(int TIPOINSCR) {
        this.TIPOINSCR = TIPOINSCR;
    } 
}
