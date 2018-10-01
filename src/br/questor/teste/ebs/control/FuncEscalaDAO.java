package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncEscala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncEscalaDAO extends FuncEscala{
      
    public void funcescalaQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	cd_empresa AS CODIGOEMPRESA,\n" +
"		cd_funcionario AS CODIGOFUNCCONTR,\n" +
"		dt_horario AS DATAINICIAL,\n" +
"		CASE WHEN ((cd_tabela)+9) IS NULL THEN 9999\n" +
"		ELSE ((cd_tabela)+9) END AS CODIGOESCALA\n" +
"FROM funhorario\n" +
"ORDER BY CODIGOEMPRESA, CODIGOFUNCCONTR;");
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA(rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR(rs.getInt("CODIGOFUNCCONTR"));
                setDATAINICIAL(rs.getDate("DATAINICIAL"));
                setCODIGOESCALA(rs.getInt("CODIGOESCALA"));

                ps2 = con2.prepareStatement ("INSERT INTO FUNCESCALA (CODIGOEMPRESA,CODIGOFUNCCONTR,"
                        + "DATAINICIAL,CODIGOESCALA,CODIGOMOTIVO,REGIMEJOR,TEMPOPARCIAL)"
                        + "VALUES (?,?,?,?,1,1,0)");
                    
                    ps2.setInt(1, getCODIGOEMPRESA());
                    ps2.setInt(2, getCODIGOFUNCCONTR());
                    ps2.setDate(3, getDATAINICIAL());
                    ps2.setInt(4, getCODIGOESCALA());

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