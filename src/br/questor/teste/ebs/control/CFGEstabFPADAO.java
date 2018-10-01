package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.CFGEstabFPA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CFGEstabFPADAO extends CFGEstabFPA{
      
    public void CFGEmpresaFPAQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT  EMPRESA.cd_empresa AS CODIGOEMPRESA,\n" +
"		ESTAB.cd_estabelecimento AS CODIGOESTAB\n" +
"               FROM crdempresa EMPRESA\n" +
"               JOIN crdestabelecimento ESTAB\n" +
"               ON EMPRESA.cd_empresa = ESTAB.cd_empresa\n" +
"               WHERE EMPRESA.CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999)\n" +
"               ORDER BY CODIGOEMPRESA, CODIGOESTAB;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOESTAB (rs.getInt("CODIGOESTAB"));
                

                    ps2 = con2.prepareStatement ("INSERT INTO CFGESTABFPA(\n" +
"	CODIGOEMPRESA,\n" +
"	CODIGOESTAB,\n" +
"	DATAINICIAL,\n" +
"	CODIGOTABFERESCALA,\n" +
"	CENTRALFGTS,\n" +
"	CATEGFGTS,\n" +
"	CONTAFGTS,\n" +
"	CODIGOIMPOSTO,\n" +
"	VARIACAOIMPOSTO,\n" +
"	CODIGOTABGPS,\n" +
"	CODIGOESTABCTB,\n" +
"	CODIGOTABGPSOUTEMP,\n" +
"	CENTRALRECOLHSIND,\n" +
"	SINDICALIZADA,\n" +
"	PARTICPAT,\n" +
"	PERCADIANTAMENTO,\n" +
"	TIPOCONTROLEPONTO,\n" +
"	INDMENAPRENDIZ,\n" +
"	TIPOALTERACAOESOCIAL)\n" +
"VALUES (?,?,'1900-01-01',1,1,7,0,115,71,1,1,1,0,0,0,40,0,0,0);");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.setInt(2, this.getCODIGOESTAB());
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