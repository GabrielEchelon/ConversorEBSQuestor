package br.questor.teste.ebs.model;

public class Sindicato {
    
    protected String TABELA = "SINDICATO";
    
    protected int CODIGOSIND;
    protected String NOMESIND;
    protected String SIGLASIND;
    protected String CODIGOENTID;
    protected String ENDERSIND;
    protected int NUMEROENDER;
    protected String COMPLENDER;
    protected String BAIRROSIND;
    protected String SIGLAESTADO;
    protected int CODIGOMUNIC;
    protected String CEPSIND;
    protected int DDDFONE;
    protected int NUMEROFONE;
    protected String ENDERELETR;
    protected String PAGINAINTER;
    protected String INSCRFEDERAL;
    protected int TIPOENTID;
    protected int NUMEROAGENCIA;

    public Sindicato(){
        this.CODIGOSIND = 0;
        this.NOMESIND = "";
        this.SIGLASIND = "";
        this.CODIGOENTID = "";
        this.ENDERSIND = "";
        this.NUMEROENDER = 0;
        this.COMPLENDER = "";
        this.BAIRROSIND = "";
        this.SIGLAESTADO = "";
        this.CODIGOMUNIC = 0;
        this.CEPSIND = "";
        this.DDDFONE = 0;
        this.NUMEROFONE = 0;
        this.ENDERELETR = "";
        this.PAGINAINTER = "";
        this.INSCRFEDERAL = "";
        this.TIPOENTID = 0;
        this.NUMEROAGENCIA = 0;
    }
    
    public Sindicato(int CODIGOSIND, String NOMESIND, String SIGLASIND, String CODIGOENTID, String ENDERSIND, int NUMEROENDER, String COMPLENDER, String BAIRROSIND, String SIGLAESTADO, int CODIGOMUNIC, String CEPSIND, int DDDFONE, int NUMEROFONE, String ENDERELETR, String PAGINAINTER, String INSCRFEDERAL, int TIPOENTID, int NUMEROAGENCIA) {
        this.CODIGOSIND = CODIGOSIND;
        this.NOMESIND = NOMESIND;
        this.SIGLASIND = SIGLASIND;
        this.CODIGOENTID = CODIGOENTID;
        this.ENDERSIND = ENDERSIND;
        this.NUMEROENDER = NUMEROENDER;
        this.COMPLENDER = COMPLENDER;
        this.BAIRROSIND = BAIRROSIND;
        this.SIGLAESTADO = SIGLAESTADO;
        this.CODIGOMUNIC = CODIGOMUNIC;
        this.CEPSIND = CEPSIND;
        this.DDDFONE = DDDFONE;
        this.NUMEROFONE = NUMEROFONE;
        this.ENDERELETR = ENDERELETR;
        this.PAGINAINTER = PAGINAINTER;
        this.INSCRFEDERAL = INSCRFEDERAL;
        this.TIPOENTID = TIPOENTID;
        this.NUMEROAGENCIA = NUMEROAGENCIA;
    }
    
    public String getTABELA(){
        return TABELA;
    }

    public int getCODIGOSIND() {
        return CODIGOSIND;
    }

    public void setCODIGOSIND(int CODIGOSIND) {
        this.CODIGOSIND = CODIGOSIND;
    }

    public String getNOMESIND() {
        return NOMESIND;
    }

    public void setNOMESIND(String NOMESIND) {
        this.NOMESIND = NOMESIND;
    }

    public String getSIGLASIND() {
        return SIGLASIND;
    }

    public void setSIGLASIND(String SIGLASIND) {
        this.SIGLASIND = SIGLASIND;
    }

    public String getCODIGOENTID() {
        return CODIGOENTID;
    }

    public void setCODIGOENTID(String CODIGOENTID) {
        this.CODIGOENTID = CODIGOENTID;
    }

    public String getENDERSIND() {
        return ENDERSIND;
    }

    public void setENDERSIND(String ENDERSIND) {
        this.ENDERSIND = ENDERSIND;
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

    public String getBAIRROSIND() {
        return BAIRROSIND;
    }

    public void setBAIRROSIND(String BAIRROSIND) {
        this.BAIRROSIND = BAIRROSIND;
    }

    public String getSIGLAESTADO() {
        return SIGLAESTADO;
    }

    public void setSIGLAESTADO(String SIGLAESTADO) {
        this.SIGLAESTADO = SIGLAESTADO;
    }

    public String getCEPSIND() {
        return CEPSIND;
    }

    public void setCEPSIND(String CEPSIND) {
        this.CEPSIND = CEPSIND;
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

    public String getENDERELETR() {
        return ENDERELETR;
    }

    public void setENDERELETR(String ENDERELETR) {
        this.ENDERELETR = ENDERELETR;
    }

    public String getPAGINAINTER() {
        return PAGINAINTER;
    }

    public void setPAGINAINTER(String PAGINAINTER) {
        this.PAGINAINTER = PAGINAINTER;
    }

    public String getINSCRFEDERAL() {
        return INSCRFEDERAL;
    }

    public void setINSCRFEDERAL(String INSCRFEDERAL) {
        this.INSCRFEDERAL = INSCRFEDERAL;
    }

    public int getTIPOENTID() {
        return TIPOENTID;
    }

    public void setTIPOENTID(int TIPOENTID) {
        this.TIPOENTID = TIPOENTID;
    }

    public int getNUMEROAGENCIA() {
        return NUMEROAGENCIA;
    }

    public void setNUMEROAGENCIA(int NUMEROAGENCIA) {
        this.NUMEROAGENCIA = NUMEROAGENCIA;
    }

    public int getCODIGOMUNIC() {
        return CODIGOMUNIC;
    }

    public void setCODIGOMUNIC(int CODIGOMUNIC) {
        this.CODIGOMUNIC = CODIGOMUNIC;
    }
    
    
    
}
