package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LotacaoDAO extends Empresa{
      
    public void lotacaoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT  CD_EMPRESA AS CODIGOEMPRESA" +
"           FROM CRDEMPRESA\n" +
"           WHERE CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999)\n"+
"           ORDER BY CODIGOEMPRESA;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));

                    ps2 = con2.prepareStatement ("INSERT INTO LOTACAO \n" +
"                         (CODIGOEMPRESA, \n"+
"                         DATAINICIAL, \n"+
"                         CODIGOLOTACAO, \n"+
"                         DESCRLOTACAO, \n"+
"                         TIPOLOTACAO, \n"+
"                         CODIGOOUTEMP, \n"+
"                         CODIGOTABGPS, \n"+
"                         TIPOALTERACAOESOCIAL)\n" +
"                         VALUES (?,'1900-01-01',1,'GPS Normal','00',null,1,0);");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
            }
            System.out.println("\n\n\n\nAtenção! Verificar o Tipo de Lotação, pois o e-Social não aceita o 00!");
            System.out.println("\n\nTabela finalizada. (LOTACAO)");
            
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