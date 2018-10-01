package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CargoDAO extends Cargo{
      
    public void cargoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	ROW_NUMBER() OVER(ORDER BY FUNCAO.cd_funcao) AS CODIGOCARGO,\n" +
"		CASE\n" +
"			WHEN FUNCAO.data_hora_alteracao IS NULL THEN CURRENT_TIMESTAMP\n" +
"			ELSE FUNCAO.data_hora_alteracao\n" +
"		END AS DATAINICIAL,\n" +
"		FUNCAO.descricao AS DESCRCARGO,\n" +
"		CASE\n" +
"			WHEN FUNCAO.cbo2002 NOT IN (SELECT CBO FROM QST_CBO) THEN '999999'\n" +
"			WHEN FUNCAO.cbo2002 = 0 THEN '999999'\n" +
"			WHEN FUNCAO.cbo2002 LIKE '0' THEN '999999'\n" +
"			ELSE FUNCAO.cbo2002\n" +
"		END AS CBO,\n" +
"		FUNCAO.cbo AS CBO94,\n" +
"		FUNCAO.enterprise_id,\n" +
"		FUNCAO.cd_funcao\n" +
"FROM funcao FUNCAO \n" +
"ORDER BY CODIGOCARGO");
            ResultSet rs = ps.executeQuery();
                        
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOCARGO (rs.getInt("CODIGOCARGO"));
                setDATAINICIAL (rs.getDate("DATAINICIAL"));
                setDESCRCARGO (rs.getString("DESCRCARGO"));
                setCBO (rs.getString("CBO"));
                setCBO94 (rs.getString("CBO94"));

                ps2 = con2.prepareStatement ("INSERT INTO CARGO (CODIGOCARGO, DATAINICIAL, DESCRCARGO, CBO, CBO94)\n" +
"VALUES (?,?,?,?,?);");
                    
                ps2.setInt(1, this.getCODIGOCARGO());
                ps2.setDate(2, this.getDATAINICIAL());
                ps2.setString(3, this.getDESCRCARGO());
                ps2.setString(4, this.getCBO());
                ps2.setString(5, this.getCBO94());

                    
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