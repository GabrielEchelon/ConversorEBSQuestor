package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.CFGEmpresaFPA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CFGEmpresaFPADAO extends CFGEmpresaFPA{
      
    public void CFGEmpresaFPAQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT CD_EMPRESA AS CODIGOEMPRESA \n" +
"FROM CRDEMPRESA\n" +
"WHERE CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999)"
                    + "ORDER BY CODIGOEMPRESA;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                

                    ps2 = con2.prepareStatement ("INSERT INTO CFGEMPRESAFPA\n" +
"(CODIGOEMPRESA, DATAINICIAL, PROCESSOCONTRISOCIALRESC, FOLHAHORADIA, HORASNOT5230, VALORARRED, VACINFREQ, PGTOFOLHAMENSALADTO,\n" +
"PGTOADMMENS, EVENTOINIESOCIAL, PGTODEMMENS, SEPDSRHRMENSFER, SEPDSRMENS, PAGASALFAMINTERMITENTE, CALCULOFALTAS, PERDEDSRFALTAS,\n" +
"UTILESTRUTSAL, CODIGOESTRUTSAL, UTILBENEFICIO, PAGAFERIADO, UTILVALETRANSP, UTILREFEICAO, UTILSINCHIST, ORGANOGRAMA, HORACENT,\n" +
"UTILRATEIO, CODIGOGRUPOTABELACONTABIL, CONTABILIZA, CODIGOEMPCTB, RATEIOGERENCIAL, INSSSEPAR, ESCALAMENSALHOR, CODIGOASSIDUIDADE,\n" +
"REGISTROINFORMAT, PERCPIS, SALFAMADMDEM, ESCALAMENSALPROF, UTILCALCPROF, CODIGOPERCALCULO, UTILPPP, GERARAIS, NUMEROCONVENIO,\n" +
"GPSCOMPENSARPRIM, HORANORMALCRITRAT, DEPEND13DIRFINFORME, COMPENSACAOGPS, FORMAGERACAODARF, DATAINICIALCALCMOVUSU, DATAFINALCALCMOVUSU,\n" +
"DATAINICIALPROVUSU, DATAFINALPROVUSU, DATAINICIALCALCVTRUSU, UTILOBRATOMADORTABFERIADO, SISTEMAANUIDADE, DATAFINALCALCVTRUSU, CODIGOANUIDADE,\n" +
"SEPARARHORASAPT, SEPARARFERIASIND, DIVERSASATIVCNAE, PAGAFASTMENSALISTA, PRORROGALICMAT, CODIGOUSUARIOCALCULANDO, GERARDEBITOFOLHACTR,\n" +
"UTILFUNCAO, CODIGOLAYOUTCONTABILIZACAO, ANUIDADETEMPOSERVICO, PONTOTOLERAN, PONTOTOLERANDIA, PONTOCONTROLE, UTILFAIXAREMUN, TIPOALTERACAOESOCIAL," +
"UTILLIMITEMINFERIAS)\n" +
"VALUES \n" +
"(?,'1900-01-01', null,1,1,0,0,2,1,null,1,7,0,1,1,1,0,null,1,1,1,1,0,'999.999.999.999',0,0,0,1,null,0,0,2,null,0,0.00,2,2,0,null,\n" +
"0,1,null,2,0,1,0,1,null,null,null,null,null,0,2,null,null,0,0,0,1,0,null,0,0,null,null,5,10,1,0,0,1);");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
            }
            System.out.println("\n\nTabela finalizada. (" + getTABELA() + ")");
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
              con.close();
            }
            if(ps2 != null){
                ps2.close();
            }
            if(con2 != null){
                con2.close();
            }
        }      
    }
}