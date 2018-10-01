package br.questor.teste.ebs.model;

public class Socio {
    
    protected String TABELA = "SOCIO";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOSOCIO;
    //protected String DATAINICIAL;
    protected String NOMESOCIO;
    protected int TIPOINSCR;
    protected String INSCRFEDERAL;
    protected String NUMERORG;
    protected int CODIGOMUNIC;
    protected int CODIGOTIPOLOGRAD;
    protected String ENDERECOSOCIO;
    protected int NUMENDERSOCIO;
    protected String BAIRROENDERSOCIO;
    protected String COMPLENDERSOCIO;
    protected String SIGLAESTADO;
    protected String CEPENDERSOCIO;
    protected int DDDFONE;
    protected int NUMEROFONE;
    protected String EMAIL;
    //protected int RESPLEGAL;
    protected int TIPOSOCIO;
    //protected String DESCRCARGO;
    //protected int VALORNOMINALCOTAS;
    //protected int DECLARAFISICAESCRIT;
    //protected int QUALIFICACAOSOCIO;
    //protected int SOCIOOSTENSIVO;
    //protected String DATAINICIOSOCIO;
    //protected String DATAFIMSOCIO;
    
    public Socio(){
        CODIGOEMPRESA = 0;
	CODIGOSOCIO = 0;
	//DATAINICIAL = " ";
	NOMESOCIO = " ";
	TIPOINSCR = 0;
	INSCRFEDERAL = " ";
	NUMERORG = " ";
	CODIGOMUNIC = 0;
	CODIGOTIPOLOGRAD = 0;
	ENDERECOSOCIO = " ";
	NUMENDERSOCIO = 0;
	BAIRROENDERSOCIO = " "; 
	COMPLENDERSOCIO = " ";
	SIGLAESTADO = " ";
	CEPENDERSOCIO = " ";
	DDDFONE = 0;
	NUMEROFONE = 0; 
	EMAIL = " ";
	//RESPLEGAL = 0;
	TIPOSOCIO = 0;
	//DESCRCARGO = " ";
	//VALORNOMINALCOTAS = 0;
	//DECLARAFISICAESCRIT = 0;
	//QUALIFICACAOSOCIO = 0;
	//SOCIOOSTENSIVO = 0;
	//DATAINICIOSOCIO = " ";
	//DATAFIMSOCIO = " ";
    }

    public Socio(int CODIGOEMPRESA, int CODIGOSOCIO, /*String DATAINICIAL, */String NOMESOCIO, int TIPOINSCR, String INSCRFEDERAL, String NUMERORG, int CODIGOMUNIC, int CODIGOTIPOLOGRAD, String ENDERECOSOCIO, int NUMENDERSOCIO, String BAIRROENDERSOCIO, String COMPLENDERSOCIO, String SIGLAESTADO, String CEPENDERSOCIO, int DDDFONE, int NUMEROFONE, String EMAIL, /*int RESPLEGAL,*/ int TIPOSOCIO/*, String DESCRCARGO, int VALORNOMINALCOTAS, int DECLARAFISICAESCRIT, int QUALIFICACAOSOCIO, int SOCIOOSTENSIVO, String DATAINICIOSOCIO, String DATAFIMSOCIO*/) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOSOCIO = CODIGOSOCIO;
        //this.DATAINICIAL = DATAINICIAL;
        this.NOMESOCIO = NOMESOCIO;
        this.TIPOINSCR = TIPOINSCR;
        this.INSCRFEDERAL = INSCRFEDERAL;
        this.NUMERORG = NUMERORG;
        this.CODIGOMUNIC = CODIGOMUNIC;
        this.CODIGOTIPOLOGRAD = CODIGOTIPOLOGRAD;
        this.ENDERECOSOCIO = ENDERECOSOCIO;
        this.NUMENDERSOCIO = NUMENDERSOCIO;
        this.BAIRROENDERSOCIO = BAIRROENDERSOCIO;
        this.COMPLENDERSOCIO = COMPLENDERSOCIO;
        this.SIGLAESTADO = SIGLAESTADO;
        this.CEPENDERSOCIO = CEPENDERSOCIO;
        this.DDDFONE = DDDFONE;
        this.NUMEROFONE = NUMEROFONE;
        this.EMAIL = EMAIL;
        //this.RESPLEGAL = RESPLEGAL;
        this.TIPOSOCIO = TIPOSOCIO;
        //this.DESCRCARGO = DESCRCARGO;
        //this.VALORNOMINALCOTAS = VALORNOMINALCOTAS;
        //this.DECLARAFISICAESCRIT = DECLARAFISICAESCRIT;
        //this.QUALIFICACAOSOCIO = QUALIFICACAOSOCIO;
        //this.SOCIOOSTENSIVO = SOCIOOSTENSIVO;
        //this.DATAINICIOSOCIO = DATAINICIOSOCIO;
        //this.DATAFIMSOCIO = DATAFIMSOCIO;
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

    public int getCODIGOSOCIO() {
        return CODIGOSOCIO;
    }

    public void setCODIGOSOCIO(int CODIGOSOCIO) {
        if((CODIGOSOCIO >= 32767)&&(CODIGOSOCIO <= 99999)){
            this.CODIGOSOCIO = (CODIGOSOCIO / 10);
        }else if (CODIGOSOCIO >= 100000){
            this.CODIGOSOCIO = (CODIGOSOCIO / 1000);
        }else {
            this.CODIGOSOCIO = CODIGOSOCIO;
        }
    }

    /*public String getDATAINICIAL() {
        return DATAINICIAL;
    }

    public void setDATAINICIAL(String DATAINICIAL) {
        this.DATAINICIAL = DATAINICIAL;
    }*/

    public String getNOMESOCIO() {
        return NOMESOCIO;
    }

    public void setNOMESOCIO(String NOMESOCIO) {
        this.NOMESOCIO = NOMESOCIO;
    }

    public int getTIPOINSCR() {
        return TIPOINSCR;
    }

    public void setTIPOINSCR(int TIPOINSCR) {
        this.TIPOINSCR = TIPOINSCR;
    }

    public String getINSCRFEDERAL() {
        return INSCRFEDERAL;
    }

    public void setINSCRFEDERAL(String INSCRFEDERAL) {
        this.INSCRFEDERAL = INSCRFEDERAL;
    }

    public String getNUMERORG() {
        return NUMERORG;
    }

    public void setNUMERORG(String NUMERORG) {
        this.NUMERORG = NUMERORG;
    }

    public int getCODIGOMUNIC() {
        return CODIGOMUNIC;
    }

    public void setCODIGOMUNIC(int CODIGOMUNIC) {
        this.CODIGOMUNIC = CODIGOMUNIC;
    }

    public int getCODIGOTIPOLOGRAD() {
        return CODIGOTIPOLOGRAD;
    }

    public void setCODIGOTIPOLOGRAD(int CODIGOTIPOLOGRAD) {
        this.CODIGOTIPOLOGRAD = CODIGOTIPOLOGRAD;
    }

    public String getENDERECOSOCIO() {
        return ENDERECOSOCIO;
    }

    public void setENDERECOSOCIO(String ENDERECOSOCIO) {
        this.ENDERECOSOCIO = ENDERECOSOCIO;
    }

    public int getNUMENDERSOCIO() {
        return NUMENDERSOCIO;
    }

    public void setNUMENDERSOCIO(int NUMENDERSOCIO) {
        this.NUMENDERSOCIO = NUMENDERSOCIO;
    }

    public String getBAIRROENDERSOCIO() {
        return BAIRROENDERSOCIO;
    }

    public void setBAIRROENDERSOCIO(String BAIRROENDERSOCIO) {
        this.BAIRROENDERSOCIO = BAIRROENDERSOCIO;
    }

    public String getCOMPLENDERSOCIO() {
        return COMPLENDERSOCIO;
    }

    public void setCOMPLENDERSOCIO(String COMPLENDERSOCIO) {
        this.COMPLENDERSOCIO = COMPLENDERSOCIO;
    }

    public String getSIGLAESTADO() {
        return SIGLAESTADO;
    }

    public void setSIGLAESTADO(String SIGLAESTADO) {
        this.SIGLAESTADO = SIGLAESTADO;
    }

    public String getCEPENDERSOCIO() {
        return CEPENDERSOCIO;
    }

    public void setCEPENDERSOCIO(String CEPENDERSOCIO) {
        this.CEPENDERSOCIO = CEPENDERSOCIO;
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

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    /*public int getRESPLEGAL() {
        return RESPLEGAL;
    }

    public void setRESPLEGAL(int RESPLEGAL) {
        this.RESPLEGAL = RESPLEGAL;
    }*/

    public int getTIPOSOCIO() {
        return TIPOSOCIO;
    }

    public void setTIPOSOCIO(int TIPOSOCIO) {
        this.TIPOSOCIO = TIPOSOCIO;
    }

    /*public String getDESCRCARGO() {
        return DESCRCARGO;
    }

    public void setDESCRCARGO(String DESCRCARGO) {
        this.DESCRCARGO = DESCRCARGO;
    }

    public int getVALORNOMINALCOTAS() {
        return VALORNOMINALCOTAS;
    }

    public void setVALORNOMINALCOTAS(int VALORNOMINALCOTAS) {
        this.VALORNOMINALCOTAS = VALORNOMINALCOTAS;
    }

    public int getDECLARAFISICAESCRIT() {
        return DECLARAFISICAESCRIT;
    }

    public void setDECLARAFISICAESCRIT(int DECLARAFISICAESCRIT) {
        this.DECLARAFISICAESCRIT = DECLARAFISICAESCRIT;
    }

    public int getQUALIFICACAOSOCIO() {
        return QUALIFICACAOSOCIO;
    }

    public void setQUALIFICACAOSOCIO(int QUALIFICACAOSOCIO) {
        this.QUALIFICACAOSOCIO = QUALIFICACAOSOCIO;
    }

    public int getSOCIOOSTENSIVO() {
        return SOCIOOSTENSIVO;
    }

    public void setSOCIOOSTENSIVO(int SOCIOOSTENSIVO) {
        this.SOCIOOSTENSIVO = SOCIOOSTENSIVO;
    }

    public String getDATAINICIOSOCIO() {
        return DATAINICIOSOCIO;
    }

    public void setDATAINICIOSOCIO(String DATAINICIOSOCIO) {
        this.DATAINICIOSOCIO = DATAINICIOSOCIO;
    }

    public String getDATAFIMSOCIO() {
        return DATAFIMSOCIO;
    }

    public void setDATAFIMSOCIO(String DATAFIMSOCIO) {
        this.DATAFIMSOCIO = DATAFIMSOCIO;
    } */  
}
