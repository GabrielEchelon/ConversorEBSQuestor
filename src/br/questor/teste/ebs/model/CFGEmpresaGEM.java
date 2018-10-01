package br.questor.teste.ebs.model;

public class CFGEmpresaGEM {
    
    protected String TABELA = "CFGEMPRESAGEM";
    
    protected int CODIGOEMPRESA;
    protected int CONTADORRESPCNPJ;
    protected int CONTADORRESPPREENCHFEDERAL;
    protected int SOCIORESPCNPJ;    

    public CFGEmpresaGEM(){
        CODIGOEMPRESA = 0;
        CONTADORRESPCNPJ = 0;
        CONTADORRESPPREENCHFEDERAL = 0;
        SOCIORESPCNPJ = 0;
    }
    
    public CFGEmpresaGEM(int CODIGOEMPRESA, int CONTADORRESPCNPJ, int CONTADORRESPPREENCHFEDERAL, int SOCIORESPCNPJ) {
        this.CODIGOEMPRESA = CODIGOEMPRESA;
        this.CONTADORRESPCNPJ = CONTADORRESPCNPJ;
        this.CONTADORRESPPREENCHFEDERAL = CONTADORRESPPREENCHFEDERAL;
        this.SOCIORESPCNPJ = SOCIORESPCNPJ;
    }

    public int getCODIGOEMPRESA() {
        return CODIGOEMPRESA;
    }

    public void setCODIGOEMPRESA(int CODIGOEMPRESA) {
        if((CODIGOEMPRESA >= 32767)&&(CODIGOEMPRESA <= 99999)){
            this.CODIGOEMPRESA = (CODIGOEMPRESA / 10);
        }else if (CODIGOEMPRESA >= 100000){
            this.CODIGOEMPRESA = (CODIGOEMPRESA / 1000);
        }else {
            this.CODIGOEMPRESA = CODIGOEMPRESA;
        }
    }

    public int getCONTADORRESPCNPJ() {
        return CONTADORRESPCNPJ;
    }

    public void setCONTADORRESPCNPJ(int CONTADORRESPCNPJ) {
        if((CONTADORRESPCNPJ >= 32767)&&(CONTADORRESPCNPJ <= 99999)){
            this.CONTADORRESPCNPJ = (CONTADORRESPCNPJ / 10);
        }else if (CONTADORRESPCNPJ >= 100000){
            this.CONTADORRESPCNPJ = (CONTADORRESPCNPJ / 1000);
        }else {
            this.CONTADORRESPCNPJ = CONTADORRESPCNPJ;
        }
        
    }

    public int getCONTADORRESPPREENCHFEDERAL() {
        return CONTADORRESPPREENCHFEDERAL;
    }

    public void setCONTADORRESPPREENCHFEDERAL(int CONTADORRESPPREENCHFEDERAL) {
        if((CONTADORRESPPREENCHFEDERAL >= 32767)&&(CONTADORRESPPREENCHFEDERAL <= 99999)){
            this.CONTADORRESPPREENCHFEDERAL = (CONTADORRESPPREENCHFEDERAL / 10);
        }else if (CONTADORRESPPREENCHFEDERAL >= 100000){
            this.CONTADORRESPPREENCHFEDERAL = (CONTADORRESPPREENCHFEDERAL / 1000);
        }else {
            this.CONTADORRESPPREENCHFEDERAL = CONTADORRESPPREENCHFEDERAL;
        }
        
    }

    public int getSOCIORESPCNPJ() {
        return SOCIORESPCNPJ;
    }

    public void setSOCIORESPCNPJ(int SOCIORESPCNPJ) {
        if((SOCIORESPCNPJ >= 32767)&&(SOCIORESPCNPJ <= 99999)){
            this.SOCIORESPCNPJ = (SOCIORESPCNPJ / 10);
        }else if (SOCIORESPCNPJ >= 100000){
            this.SOCIORESPCNPJ = (SOCIORESPCNPJ / 1000);
        }else {
            this.SOCIORESPCNPJ = SOCIORESPCNPJ;
        }
    }

    public String getTABELA() {
        return TABELA;
    }
}
