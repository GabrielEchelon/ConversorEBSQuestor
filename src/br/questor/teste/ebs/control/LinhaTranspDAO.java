package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.LinhaTransp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LinhaTranspDAO extends LinhaTransp{
      
    public void linhaTranspQuery() throws Exception{
        
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
            
            ps2 = con2.prepareStatement ("INSERT INTO MEIOTRANSP (CODIGOMEIOVT, NOMEMEIOVT)\n" +
"VALUES (1,'Importado da Conversão');");
            ps2.executeUpdate();
                        
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOLINHAVT (rs.getInt("CODIGOLINHAVT"));
                setNOMELINHAVT (rs.getString("NOMELINHAVT"));

                ps2 = con2.prepareStatement ("INSERT INTO LINHATRANSP (CODIGOLINHAVT, NOMELINHAVT, CODIGOMEIOVT, CODIGOOUTEMP)\n" +
"VALUES (?,?,1,9999);");
                    
                ps2.setInt(1, this.getCODIGOLINHAVT());
                ps2.setString(2, this.getNOMELINHAVT());

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