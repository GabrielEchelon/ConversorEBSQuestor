package br.questor.teste.ebs.model;

public class Contador {
    
    protected String TABELA = "CONTADOR";
    
    protected int CODIGOCONT;
    protected String NOMECONT;
    protected String ENDERECOCONT;
    protected int NUMENDERCONT;
    protected String BAIRROENDERCONT;
    protected String SIGLAESTADO;
    protected int CODIGOMUNIC;
    protected String CEPENDERCONT;
    protected int DDDFONE;
    protected int NUMEROFONE;
    protected int DDDFAX;
    protected int NUMEROFAX;
    protected int TIPOINSCR;
    protected String INSCRFEDERAL;
    protected String NUMEROREG;
    protected String TITULOPROFIS;
    protected String UFCRC;
    
    public Contador(){
        CODIGOCONT = 0;
        NOMECONT = " ";
        ENDERECOCONT = " ";
        NUMENDERCONT = 0;
        BAIRROENDERCONT = " ";
        SIGLAESTADO = " ";
        CODIGOMUNIC = 0;
        CEPENDERCONT = " ";
        DDDFONE = 0;
        NUMEROFONE = 0;
        DDDFAX = 0;
        NUMEROFAX = 0;
        TIPOINSCR = 1;
        INSCRFEDERAL = " ";
        NUMEROREG = " ";
        TITULOPROFIS = " ";
        UFCRC = " ";
    }

    public Contador(int CODIGOCONT, String NOMECONT, String ENDERECOCONT, int NUMENDERCONT, String BAIRROENDERCONT, String SIGLAESTADO, int CODIGOMUNIC, String CEPENDERCONT, int DDDFONE, int NUMEROFONE, int DDDFAX, int NUMEROFAX, int TIPOINSCR,String INSCRFEDERAL, String NUMEROREG, String TITULOPROFIS, String UFCRC) {
        this.CODIGOCONT = CODIGOCONT;
        this.NOMECONT = NOMECONT;
        this.ENDERECOCONT = ENDERECOCONT;
        this.NUMENDERCONT = NUMENDERCONT;
        this.BAIRROENDERCONT = BAIRROENDERCONT;
        this.SIGLAESTADO = SIGLAESTADO;
        this.CODIGOMUNIC = CODIGOMUNIC;
        this.CEPENDERCONT = CEPENDERCONT;
        this.DDDFONE = DDDFONE;
        this.NUMEROFONE = NUMEROFONE;
        this.DDDFAX = DDDFAX;
        this.NUMEROFAX = NUMEROFAX;
        this.TIPOINSCR = TIPOINSCR;
        this.INSCRFEDERAL = INSCRFEDERAL;
        this.NUMEROREG = NUMEROREG;
        this.TITULOPROFIS = TITULOPROFIS;
        this.UFCRC = UFCRC;
    }

    public String getTABELA() {
        return TABELA;
    }

    public void setTABELA(String TABELA) {
        this.TABELA = TABELA;
    }

    public int getCODIGOCONT() {
        return CODIGOCONT;
    }

    public void setCODIGOCONT(int CODIGOCONT) {
        if((CODIGOCONT >= 32767)&&(CODIGOCONT <= 99999)){
            this.CODIGOCONT = (CODIGOCONT / 10);
        }else if (CODIGOCONT >= 100000){
            this.CODIGOCONT = (CODIGOCONT / 1000);
        }else {
            this.CODIGOCONT = CODIGOCONT;
        }
    }

    public String getNOMECONT() {
        return NOMECONT;
    }

    public void setNOMECONT(String NOMECONT) {
        this.NOMECONT = NOMECONT;
    }

    public String getENDERECOCONT() {
        return ENDERECOCONT;
    }

    public void setENDERECOCONT(String ENDERECOCONT) {
        this.ENDERECOCONT = ENDERECOCONT;
    }

    public int getNUMENDERCONT() {
        return NUMENDERCONT;
    }

    public void setNUMENDERCONT(int NUMENDERCONT) {
        this.NUMENDERCONT = NUMENDERCONT;
    }

    public String getBAIRROENDERCONT() {
        return BAIRROENDERCONT;
    }

    public void setBAIRROENDERCONT(String BAIRROENDERCONT) {
        this.BAIRROENDERCONT = BAIRROENDERCONT;
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

    public String getCEPENDERCONT() {
        return CEPENDERCONT;
    }

    public void setCEPENDERCONT(String CEPENDERCONT) {
        this.CEPENDERCONT = CEPENDERCONT;
    }

    public int getDDDFONE() {
        return DDDFONE;
    }

    public void setDDDFONE(int DDDFONE) {
        this.DDDFONE = DDDFONE;
    }

    public int getNUMEROFONE() {
        return NUMEROFONE;
    }

    public void setNUMEROFONE(int NUMEROFONE) {
        this.NUMEROFONE = NUMEROFONE;
    }

    public int getDDDFAX() {
        return DDDFAX;
    }

    public void setDDDFAX(int DDDFAX) {
        this.DDDFAX = DDDFAX;
    }

    public int getNUMEROFAX() {
        return NUMEROFAX;
    }

    public void setNUMEROFAX(int NUMEROFAX) {
        this.NUMEROFAX = NUMEROFAX;
    }

    public int getTIPOINSCR() {
        return TIPOINSCR;
    }

    public void setTIPOINSCR(int TIPOINSCR) {
        this.TIPOINSCR = TIPOINSCR;
    }

    public String getNUMEROREG() {
        return NUMEROREG;
    }

    public void setNUMEROREG(String NUMEROREG) {
        this.NUMEROREG = NUMEROREG;
    }

    public String getTITULOPROFIS() {
        return TITULOPROFIS;
    }

    public void setTITULOPROFIS(String TITULOPROFIS) {
        this.TITULOPROFIS = TITULOPROFIS;
    }

    public String getUFCRC() {
        return UFCRC;
    }

    public void setUFCRC(String UFCRC) {
        this.UFCRC = UFCRC;
    }

    public String getINSCRFEDERAL() {
        return INSCRFEDERAL;
    }

    public void setINSCRFEDERAL(String INSCRFEDERAL) {
        this.INSCRFEDERAL = INSCRFEDERAL;
    }
    
}
