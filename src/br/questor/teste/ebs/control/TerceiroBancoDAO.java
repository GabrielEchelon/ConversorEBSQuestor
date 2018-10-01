package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.TerceiroBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TerceiroBancoDAO extends TerceiroBanco{
      
    public void terceiroBancoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT DISTINCT cd_empresa AS CODIGOEMPRESA,\n" +
"		cd_autonomo AS CODIGOTERC\n" +
"FROM PagamentoAutonomo");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOTERC (rs.getInt("CODIGOTERC"));

                
                ps2 = con2.prepareStatement("INSERT INTO TERCEIROBANCO (CODIGOEMPRESA, CODIGOTERC, MODOPGTO,TIPOCONTA"
                        + ", AGENTENOCIVO,CALCULOMENSAL)"
                        + "VALUES (?,?,1,1,'00',1)");
                
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setInt(2, this.getCODIGOTERC());
                
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