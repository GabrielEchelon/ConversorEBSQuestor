package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncAdicional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncAdicionalDAO extends FuncAdicional{
      
    public void funcAdicionalQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	cd_empresa AS CODIGOEMPRESA,\n" +
"		cd_funcionario AS CODIGOFUNCCONTR,\n" +
"		dt_exposicao AS DATAINICIAL,\n" +
"		CASE \n" +
"			WHEN ocorrencia = 0 THEN 0\n" +
"		ELSE 1 \n" +
"		END AS JAEXPOSTO\n" +
"FROM Exposicao");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR (rs.getInt("CODIGOFUNCCONTR"));
                setDATAINICIAL (rs.getDate("DATAINICIAL"));
                setJAEXPOSTO (rs.getInt("JAEXPOSTO"));

                    ps2 = con2.prepareStatement ("INSERT INTO FUNCADICIONAL (CODIGOEMPRESA, CODIGOFUNCCONTR, "
                            + "DATAINICIAL, AGENTENOCIVO, JAEXPOSTO)"
                            + "VALUES (?,?,?,1,?);");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.setInt(2, this.getCODIGOFUNCCONTR());
                    ps2.setDate(3, this.getDATAINICIAL());
                    ps2.setInt(4, this.getJAEXPOSTO());

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