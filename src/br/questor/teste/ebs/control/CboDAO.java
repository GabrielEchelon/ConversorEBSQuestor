package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Cbo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CboDAO extends Cbo{
      
    public void cboQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT CBO, DESCRCBO FROM QST_CBO_NEW;");
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()){
                
                System.out.print(".");
                
                setCBO(rs.getInt("CBO"));
                setDESCRCBO(rs.getString("DESCRCBO"));

                
                ps2 = con2.prepareStatement ("INSERT INTO CBO (CBO, DESCRCBO) VALUES (?,?);");
                    
                    ps2.setInt(1, getCBO());
                    ps2.setString(2, getDESCRCBO());
                    
                    ps2.executeUpdate();
                    
            }
            
            System.out.println("\nTabela finalizada. (" + getTABELA() + ")");
             
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