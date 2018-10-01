package br.questor.teste.ebs.model;

public class Estab {
    
    protected String TABELA = "ESTAB";
    
    protected int CODIGOEMPRESA;
    protected int CODIGOESTAB;
    protected String NOMEESTAB;
    protected String NOMEESTABCOMPLETO;
    protected String APELIDOESTAB;
    protected int CODIGOTIPOLOGRAD;
    protected String ENDERECOESTAB;
    protected int NUMENDERESTAB;
    protected String COMPLENDERESTAB;
    protected String BAIRROENDERESTAB;
    protected String SIGLAESTADO;
    protected int CODIGOMUNIC;
    protected String CEPENDERESTAB;
    protected int DDDFONE;
    protected int NUMEROFONE;
    protected int DDDFAX;
    protected int NUMEROFAX;
    protected String EMAIL;
    protected String PAGINAINTERNET;
    protected int TIPOINSCR;
    protected String NUMEROREGIST;
    protected String INSCRFEDERAL;
    protected String DATAREGIST;
    protected String CODIGOATIVFEDERAL;
    protected String INSCRESTAD;
    protected String INSCRMUNIC;
    
    public Estab(){
        this.CODIGOEMPRESA = 0;
        this.CODIGOESTAB = 0;
        this.NOMEESTAB = " ";
        this.NOMEESTABCOMPLETO = " ";
        this.APELIDOESTAB = " ";
        this.CODIGOTIPOLOGRAD = 0;
        this.ENDERECOESTAB = " ";
        this.NUMENDERESTAB = 0;
        this.COMPLENDERESTAB = " ";
        this.BAIRROENDERESTAB = " ";
        this.SIGLAESTADO = " ";
        this.CODIGOMUNIC = 0;
        this.CEPENDERESTAB = " ";
        this.DDDFONE = 0;
        this.NUMEROFONE = 0; 
        this.DDDFAX = 0;
        this.NUMEROFAX = 0;
        this.EMAIL = " ";
        this.PAGINAINTERNET = " ";
        this.TIPOINSCR = 0;
        this.NUMEROREGIST = " ";
        this.INSCRFEDERAL = " ";
        this.DATAREGIST = " ";
        this.CODIGOATIVFEDERAL = " ";
        this.INSCRESTAD = " ";
        this.INSCRMUNIC = " ";
    }
    
    public Estab(int CODIGOEMPRESA,int CODIGOESTAB,String NOMEESTAB,String NOMEESTABCOMPLETO,String APELIDOESTAB,int CODIGOTIPOLOGRAD,String ENDERECOESTAB,int NUMENDERESTAB,String COMPLENDERESTAB,String BAIRROENDERESTAB,String SIGLAESTADO,int CODIGOMUNIC,String CEPENDERESTAB,int DDDFONE,int NUMEROFONE,int DDDFAX,int NUMEROFAX,String EMAIL,String PAGINAINTERNET,int TIPOINSCR,String NUMEROREGIST,String INSCRFEDERAL,String DATAREGIST,String CODIGOATIVFEDERAL,String INSCRESTAD,String INSCRMUNIC) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CODIGOESTAB = CODIGOESTAB;
        this.NOMEESTAB = NOMEESTAB;
        this.NOMEESTABCOMPLETO = NOMEESTABCOMPLETO;
        this.APELIDOESTAB = APELIDOESTAB;
        this.CODIGOTIPOLOGRAD = CODIGOTIPOLOGRAD;
        this.ENDERECOESTAB = ENDERECOESTAB;
        this.NUMENDERESTAB = NUMENDERESTAB;
        this.COMPLENDERESTAB = COMPLENDERESTAB;
        this.BAIRROENDERESTAB = BAIRROENDERESTAB;
        this.SIGLAESTADO = SIGLAESTADO;
        this.CODIGOMUNIC = CODIGOMUNIC;
        this.CEPENDERESTAB = CEPENDERESTAB;
        this.DDDFONE = DDDFONE;
        this.NUMEROFONE = NUMEROFONE;
        this.DDDFAX = DDDFAX;
        this.NUMEROFAX = NUMEROFAX;
        this.EMAIL = EMAIL;
        this.PAGINAINTERNET = PAGINAINTERNET;
        this.TIPOINSCR = TIPOINSCR;
        this.NUMEROREGIST = NUMEROREGIST;
        this.INSCRFEDERAL = INSCRFEDERAL;
        this.DATAREGIST = DATAREGIST;
        this.CODIGOATIVFEDERAL = CODIGOATIVFEDERAL;
        this.INSCRESTAD = INSCRESTAD;
        this.INSCRMUNIC = INSCRMUNIC;
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

    public int getCODIGOESTAB() {
        return CODIGOESTAB;
    }

    public void setCODIGOESTAB(int CODIGOESTAB) {
        if((CODIGOESTAB >= 32767)&&(CODIGOESTAB <= 99999)){
            this.CODIGOESTAB = (CODIGOESTAB / 10);
        }else if (CODIGOESTAB >= 100000){
            this.CODIGOESTAB = (CODIGOESTAB / 1000);
        }else {
            this.CODIGOESTAB = CODIGOESTAB;
        }
    }

    public String getNOMEESTAB() {
        return NOMEESTAB;
    }

    public void setNOMEESTAB(String NOMEESTAB) {
        this.NOMEESTAB = NOMEESTAB;
    }

    public String getNOMEESTABCOMPLETO() {
        return NOMEESTABCOMPLETO;
    }

    public void setNOMEESTABCOMPLETO(String NOMEESTABCOMPLETO) {
        this.NOMEESTABCOMPLETO = NOMEESTABCOMPLETO;
    }

    public String getAPELIDOESTAB() {
        return APELIDOESTAB;
    }

    public void setAPELIDOESTAB(String APELIDOESTAB) {
        this.APELIDOESTAB = APELIDOESTAB;
    }

    public int getCODIGOTIPOLOGRAD() {
        return CODIGOTIPOLOGRAD;
    }

    public void setCODIGOTIPOLOGRAD(int CODIGOTIPOLOGRAD) {
        this.CODIGOTIPOLOGRAD = CODIGOTIPOLOGRAD;
    }

    public String getENDERECOESTAB() {
        return ENDERECOESTAB;
    }

    public void setENDERECOESTAB(String ENDERECOESTAB) {
        this.ENDERECOESTAB = ENDERECOESTAB;
    }

    public int getNUMENDERESTAB() {
        return NUMENDERESTAB;
    }

    public void setNUMENDERESTAB(int NUMENDERESTAB) {
        this.NUMENDERESTAB = NUMENDERESTAB;
    }

    public String getCOMPLENDERESTAB() {
        return COMPLENDERESTAB;
    }

    public void setCOMPLENDERESTAB(String COMPLENDERESTAB) {
        this.COMPLENDERESTAB = COMPLENDERESTAB;
    }

    public String getBAIRROENDERESTAB() {
        return BAIRROENDERESTAB;
    }

    public void setBAIRROENDERESTAB(String BAIRROENDERESTAB) {
        this.BAIRROENDERESTAB = BAIRROENDERESTAB;
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

    public String getCEPENDERESTAB() {
        return CEPENDERESTAB;
    }

    public void setCEPENDERESTAB(String CEPENDERESTAB) {
        this.CEPENDERESTAB = CEPENDERESTAB;
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

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPAGINAINTERNET() {
        return PAGINAINTERNET;
    }

    public void setPAGINAINTERNET(String PAGINAINTERNET) {
        this.PAGINAINTERNET = PAGINAINTERNET;
    }

    public int getTIPOINSCR() {
        return TIPOINSCR;
    }

    public void setTIPOINSCR(int TIPOINSCR) {
        this.TIPOINSCR = TIPOINSCR;
    }
    
    public String getNUMEROREGIST(){
        return NUMEROREGIST;
    }
    
    public void setNUMEROREGIST(String NUMEROREGIST){
        this.NUMEROREGIST = NUMEROREGIST;
    }

    public String getINSCRFEDERAL() {
        return INSCRFEDERAL;
    }

    public void setINSCRFEDERAL(String INSCRFEDERAL) {
        this.INSCRFEDERAL = INSCRFEDERAL;
    }

    /*public String getDATAREGIST() {
        String pattern = "yyyy-MM-dd";
        SimpleStringFormat format = new SimpleStringFormat(pattern);
        System.out.println(format.format(DATAREGIST));
        return "'"+format.format(DATAREGIST)+"'";
    }*/

    public String getDATAREGIST(){
        //System.out.println(DATAREGIST);
        return DATAREGIST;
    }
    
    public void setDATAREGIST(String DATAREGIST) {
        //System.out.println(DATAREGIST);
        this.DATAREGIST = DATAREGIST;
    }
    
    public String getCODIGOATIVFEDERAL(){
        return CODIGOATIVFEDERAL;
    }
    
    public void setCODIGOATIVFEDERAL(String CODIGOATIVFEDERAL){
        this.CODIGOATIVFEDERAL = CODIGOATIVFEDERAL;
    }

    public String getINSCRESTAD() {
        return INSCRESTAD;
    }

    public void setINSCRESTAD(String INSCRESTAD) {
        this.INSCRESTAD = INSCRESTAD;
    }

    public String getINSCRMUNIC() {
        return INSCRMUNIC;
    }

    public void setINSCRMUNIC(String INSCRMUNIC) {
        this.INSCRMUNIC = INSCRMUNIC;
    }
    
    /*public void convertString(){
        String pattern = "dd-MM-yyyy";
        SimpleStringFormat format = new SimpleStringFormat(pattern);
        System.out.println(format.format(DATAREGIST));
    }*/
}
