package br.questor.teste.ebs.model;

import java.sql.Date;


public class FuncPessoa {
    
    protected String TABELA = "FUNCPESSOA";
    
    protected int CODIGOFUNCPESSOA;
    protected String NOMEFUNC;
    protected int CODIGOTIPOLOGRAD;
    protected String ENDERFUNC;
    protected int NUMEROENDER;
    protected String COMPLENDER;
    protected String BAIRROFUNC;
    protected int CODIGOMUNIC;
    protected String SIGLAESTADO;
    protected String CEPFUNC;
    protected int SEXO;
    protected int ESTADOCIVIL;
    protected int NACIONALIDADE;
    protected int GRAUINSTR;
    protected Date DATANASC;
    protected int DDDFONE;
    protected int NUMEROFONE;
    protected String APELIDOFUNC;
    protected int RACACOR;
    protected int DEFFISICA;
    protected int CODIGOMUNICNASC;
    protected String SIGLAESTADONASC;
    protected int DDDCELULAR;
    protected int NUMEROCELULAR;
    protected String ENDERELETR;
    protected Date DATACHEGADA;
    protected String PISFUNC;
    protected String CPFFUNC;
    protected String NUMERORG;
    protected int CODIGOORGAOEMISSORRG;
    protected String SIGLAESTADORG;
    protected String TITELEIT;
    protected int ZONATITELEIT;
    protected int SECAOTITELEIT;
    protected Date EMISSRG;
    protected Date DATACADPIS;

    public FuncPessoa(int CODIGOFUNCPESSOA, String NOMEFUNC, int CODIGOTIPOLOGRAD, String ENDERFUNC, int NUMEROENDER, String COMPLENDER, String BAIRROFUNC, int CODIGOMUNIC, String SIGLAESTADO, String CEPFUNC, int SEXO, int ESTADOCIVIL, int NACIONALIDADE, int GRAUINSTR, Date DATANASC, int DDDFONE, int NUMEROFONE, String APELIDOFUNC, int RACACOR, int DEFFISICA, int CODIGOMUNICNASC, String SIGLAESTADONASC, int DDDCELULAR, int NUMEROCELULAR, String ENDERELETR, Date DATACHEGADA, String PISFUNC, String CPFFUNC, String NUMERORG, int CODIGOORGAOEMISSORRG, String SIGLAESTADORG, String TITELEIT, int ZONATITELEIT, int SECAOTITELEIT, Date EMISSRG, Date DATACADPIS) {
        this.CODIGOFUNCPESSOA = CODIGOFUNCPESSOA;
        this.NOMEFUNC = NOMEFUNC;
        this.CODIGOTIPOLOGRAD = CODIGOTIPOLOGRAD;
        this.ENDERFUNC = ENDERFUNC;
        this.NUMEROENDER = NUMEROENDER;
        this.COMPLENDER = COMPLENDER;
        this.BAIRROFUNC = BAIRROFUNC;
        this.CODIGOMUNIC = CODIGOMUNIC;
        this.SIGLAESTADO = SIGLAESTADO;
        this.CEPFUNC = CEPFUNC;
        this.SEXO = SEXO;
        this.ESTADOCIVIL = ESTADOCIVIL;
        this.NACIONALIDADE = NACIONALIDADE;
        this.GRAUINSTR = GRAUINSTR;
        this.DATANASC = DATANASC;
        this.DDDFONE = DDDFONE;
        this.NUMEROFONE = NUMEROFONE;
        this.APELIDOFUNC = APELIDOFUNC;
        this.RACACOR = RACACOR;
        this.DEFFISICA = DEFFISICA;
        this.CODIGOMUNICNASC = CODIGOMUNICNASC;
        this.SIGLAESTADONASC = SIGLAESTADONASC;
        this.DDDCELULAR = DDDCELULAR;
        this.NUMEROCELULAR = NUMEROCELULAR;
        this.ENDERELETR = ENDERELETR;
        this.DATACHEGADA = DATACHEGADA;
        this.PISFUNC = PISFUNC;
        this.CPFFUNC = CPFFUNC;
        this.NUMERORG = NUMERORG;
        this.CODIGOORGAOEMISSORRG = CODIGOORGAOEMISSORRG;
        this.SIGLAESTADORG = SIGLAESTADORG;
        this.TITELEIT = TITELEIT;
        this.ZONATITELEIT = ZONATITELEIT;
        this.SECAOTITELEIT = SECAOTITELEIT;
        this.EMISSRG = EMISSRG;
        this.DATACADPIS = DATACADPIS;
    }
    
    public FuncPessoa() {
        this.CODIGOFUNCPESSOA = 0;
        this.NOMEFUNC = "";
        this.CODIGOTIPOLOGRAD = 0;
        this.ENDERFUNC = "";
        this.NUMEROENDER = 0;
        this.COMPLENDER = "";
        this.BAIRROFUNC = "";
        this.CODIGOMUNIC = 0;
        this.SIGLAESTADO = "";
        this.CEPFUNC = "";
        this.SEXO = 0;
        this.ESTADOCIVIL = 0;
        this.NACIONALIDADE = 0;
        this.GRAUINSTR = 0;
        this.DATANASC = DATANASC;
        this.DDDFONE = 0;
        this.NUMEROFONE = 0;
        this.APELIDOFUNC = "";
        this.RACACOR = 0;
        this.DEFFISICA = 0;
        this.CODIGOMUNICNASC = 0;
        this.SIGLAESTADONASC = "";
        this.DDDCELULAR = 0;
        this.NUMEROCELULAR = 0;
        this.ENDERELETR = "";
        this.DATACHEGADA = DATACHEGADA;
        this.PISFUNC = "";
        this.CPFFUNC = "";
        this.NUMERORG = "";
        this.CODIGOORGAOEMISSORRG = 0;
        this.SIGLAESTADORG = "";
        this.TITELEIT = "";
        this.ZONATITELEIT = 0;
        this.SECAOTITELEIT = 0;
        this.EMISSRG = EMISSRG;
        this.DATACADPIS = DATACADPIS;
    }

    public String getTABELA(){
        return TABELA;
    }
    
    public int getCODIGOFUNCPESSOA() {
        return CODIGOFUNCPESSOA;
    }

    public void setCODIGOFUNCPESSOA(int CODIGOFUNCPESSOA) {
        this.CODIGOFUNCPESSOA = CODIGOFUNCPESSOA;
    }

    public String getNOMEFUNC() {
        return NOMEFUNC;
    }

    public void setNOMEFUNC(String NOMEFUNC) {
        this.NOMEFUNC = NOMEFUNC;
    }

    public int getCODIGOTIPOLOGRAD() {
        return CODIGOTIPOLOGRAD;
    }

    public void setCODIGOTIPOLOGRAD(int CODIGOTIPOLOGRAD) {
        this.CODIGOTIPOLOGRAD = CODIGOTIPOLOGRAD;
    }

    public String getENDERFUNC() {
        return ENDERFUNC;
    }

    public void setENDERFUNC(String ENDERFUNC) {
        this.ENDERFUNC = ENDERFUNC;
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

    public String getBAIRROFUNC() {
        return BAIRROFUNC;
    }

    public void setBAIRROFUNC(String BAIRROFUNC) {
        this.BAIRROFUNC = BAIRROFUNC;
    }

    public int getCODIGOMUNIC() {
        return CODIGOMUNIC;
    }

    public void setCODIGOMUNIC(int CODIGOMUNIC) {
        this.CODIGOMUNIC = CODIGOMUNIC;
    }

    public String getSIGLAESTADO() {
        return SIGLAESTADO;
    }

    public void setSIGLAESTADO(String SIGLAESTADO) {
        this.SIGLAESTADO = SIGLAESTADO;
    }

    public String getCEPFUNC() {
        return CEPFUNC;
    }

    public void setCEPFUNC(String CEPFUNC) {
        this.CEPFUNC = CEPFUNC;
    }

    public int getSEXO() {
        return SEXO;
    }

    public void setSEXO(int SEXO) {
        this.SEXO = SEXO;
    }

    public int getESTADOCIVIL() {
        return ESTADOCIVIL;
    }

    public void setESTADOCIVIL(int ESTADOCIVIL) {
        this.ESTADOCIVIL = ESTADOCIVIL;
    }

    public int getNACIONALIDADE() {
        return NACIONALIDADE;
    }

    public void setNACIONALIDADE(int NACIONALIDADE) {
        this.NACIONALIDADE = NACIONALIDADE;
    }

    public int getGRAUINSTR() {
        return GRAUINSTR;
    }

    public void setGRAUINSTR(int GRAUINSTR) {
        this.GRAUINSTR = GRAUINSTR;
    }

    public Date getDATANASC() {
        return DATANASC;
    }

    public void setDATANASC(Date DATANASC) {
        this.DATANASC = DATANASC;
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

    public String getAPELIDOFUNC() {
        return APELIDOFUNC;
    }

    public void setAPELIDOFUNC(String APELIDOFUNC) {
        this.APELIDOFUNC = APELIDOFUNC;
    }

    public int getRACACOR() {
        return RACACOR;
    }

    public void setRACACOR(int RACACOR) {
        this.RACACOR = RACACOR;
    }

    public int getDEFFISICA() {
        return DEFFISICA;
    }

    public void setDEFFISICA(int DEFFISICA) {
        this.DEFFISICA = DEFFISICA;
    }

    public int getCODIGOMUNICNASC() {
        return CODIGOMUNICNASC;
    }

    public void setCODIGOMUNICNASC(int CODIGOMUNICNASC) {
        this.CODIGOMUNICNASC = CODIGOMUNICNASC;
    }

    public String getSIGLAESTADONASC() {
        return SIGLAESTADONASC;
    }

    public void setSIGLAESTADONASC(String SIGLAESTADONASC) {
        this.SIGLAESTADONASC = SIGLAESTADONASC;
    }

    public int getDDDCELULAR() {
        return DDDCELULAR;
    }

    public void setDDDCELULAR(int DDDCELULAR) {
        this.DDDCELULAR = DDDCELULAR;
    }

    public int getNUMEROCELULAR() {
        return NUMEROCELULAR;
    }

    public void setNUMEROCELULAR(int NUMEROCELULAR) {
        this.NUMEROCELULAR = NUMEROCELULAR;
    }

    public String getENDERELETR() {
        return ENDERELETR;
    }

    public void setENDERELETR(String ENDERELETR) {
        this.ENDERELETR = ENDERELETR;
    }

    public Date getDATACHEGADA() {
        return DATACHEGADA;
    }

    public void setDATACHEGADA(Date DATACHEGADA) {
        this.DATACHEGADA = DATACHEGADA;
    }

    public String getPISFUNC() {
        return PISFUNC;
    }

    public void setPISFUNC(String PISFUNC) {
        this.PISFUNC = PISFUNC;
    }

    public String getCPFFUNC() {
        return CPFFUNC;
    }

    public void setCPFFUNC(String CPFFUNC) {
        this.CPFFUNC = CPFFUNC;
    }

    public String getNUMERORG() {
        return NUMERORG;
    }

    public void setNUMERORG(String NUMERORG) {
        this.NUMERORG = NUMERORG;
    }

    public int getCODIGOORGAOEMISSORRG() {
        return CODIGOORGAOEMISSORRG;
    }

    public void setCODIGOORGAOEMISSORRG(int CODIGOORGAOEMISSORRG) {
        this.CODIGOORGAOEMISSORRG = CODIGOORGAOEMISSORRG;
    }

    public String getSIGLAESTADORG() {
        return SIGLAESTADORG;
    }

    public void setSIGLAESTADORG(String SIGLAESTADORG) {
        this.SIGLAESTADORG = SIGLAESTADORG;
    }

    public String getTITELEIT() {
        return TITELEIT;
    }

    public void setTITELEIT(String TITELEIT) {
        this.TITELEIT = TITELEIT;
    }

    public int getZONATITELEIT() {
        return ZONATITELEIT;
    }

    public void setZONATITELEIT(int ZONATITELEIT) {
        this.ZONATITELEIT = ZONATITELEIT;
    }

    public int getSECAOTITELEIT() {
        return SECAOTITELEIT;
    }

    public void setSECAOTITELEIT(int SECAOTITELEIT) {
        this.SECAOTITELEIT = SECAOTITELEIT;
    }

    public Date getEMISSRG() {
        return EMISSRG;
    }

    public void setEMISSRG(Date EMISSRG) {
        this.EMISSRG = EMISSRG;
    }

    public Date getDATACADPIS() {
        return DATACADPIS;
    }

    public void setDATACADPIS(Date DATACADPIS) {
        this.DATACADPIS = DATACADPIS;
    }   
}