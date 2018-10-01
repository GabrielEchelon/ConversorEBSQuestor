package br.questor.teste.ebs.control;

import br.questor.teste.ebs.model.Feriado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FeriadoDAO extends Feriado{
      
    public void feriadoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT * FROM (SELECT DISTINCT (CONCAT('2018-',\n" +
"	SUBSTRING(CONVERT(VARCHAR(10),dt_calendario,112),5,2),'-',\n" +
"	SUBSTRING(CONVERT(VARCHAR(10),dt_calendario,112),7,2)))\n" +
"	AS DATAFERIADO\n" +
"FROM calendario WHERE situacao LIKE '%f%') AS TESTE WHERE DATAFERIADO NOT LIKE '2018-03-01'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setDATAFERIADO(rs.getDate("DATAFERIADO"));
                
                ps2 = con2.prepareStatement ("INSERT INTO FERIADO (CODIGOTABFERIADO, DATAFERIADO, NOMEFERIADO) \n" +
"VALUES(1, ?, 'Importado/Não definido');");
                ps2.setDate(1, this.getDATAFERIADO());
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