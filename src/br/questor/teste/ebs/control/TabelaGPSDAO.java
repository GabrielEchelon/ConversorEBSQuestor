package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.TabelaGPS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TabelaGPSDAO extends TabelaGPS{
      
    public void tabelaGPSQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT  DISTINCT CD_EMPRESA AS CODIGOEMPRESA, \n" +
"		LEFT(RTRIM(LTRIM(RAZAO)),30) AS DESCRTABGPS \n" +
"               FROM CRDEMPRESA\n" +
"               WHERE CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999)\n" +
"               ORDER BY CODIGOEMPRESA;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setDESCRTABGPS (rs.getString("DESCRTABGPS"));
                

                    ps2 = con2.prepareStatement ("INSERT INTO TABELAGPS (CODIGOEMPRESA, CODIGOTABGPS, DESCRTABGPS)\n" +
"                   VALUES (?,1,?);");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.setString(2, this.getDESCRTABGPS());
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