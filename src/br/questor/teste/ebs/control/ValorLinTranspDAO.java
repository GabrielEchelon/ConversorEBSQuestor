package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.ValorLinTransp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValorLinTranspDAO extends ValorLinTransp{
      
    public void valorLinTranspQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT cd_linha AS CODIGOLINHAVT,\n" +
"	   RTRIM(LTRIM(descricao)) AS NOMELINHAVT,\n" +
"	   CURRENT_TIMESTAMP AS DATA,\n" +
"	   vl_vale AS VALOR\n" +
"FROM LinhaG");
            ResultSet rs = ps.executeQuery();
                        
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOLINHAVT (rs.getInt("CODIGOLINHAVT"));
                setDATA (rs.getDate("DATA"));
                setVALOR (rs.getDouble("VALOR"));

                ps2 = con2.prepareStatement ("INSERT INTO VALORLINTRANSP (CODIGOLINHAVT, DATA, VALOR)\n" +
"VALUES (?,?,?);");
                    
                ps2.setInt(1, this.getCODIGOLINHAVT());
                ps2.setDate(2, this.getDATA());
                ps2.setDouble(3, this.getVALOR());

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