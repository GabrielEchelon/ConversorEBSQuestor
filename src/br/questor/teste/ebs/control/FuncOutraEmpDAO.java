package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncOutraEmp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncOutraEmpDAO extends FuncOutraEmp{
      
    public void funcOutraEmpQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT DISTINCT cd_empresa AS CODIGOEMPRESA,\n" +
"       cd_funcionario AS CODIGOFUNCCONTR,\n" +
"       dt_lotacao AS DATAINICIAL,\n" +
"       dt_final AS DATAFINAL,\n" +
"       cd_tomador AS CODIGOOUTEMP\n" +
"FROM FunTomador");
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA(rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR(rs.getInt("CODIGOFUNCCONTR"));
                setDATAINICIAL(rs.getDate("DATAINICIAL"));
                setDATAFINAL(rs.getDate("DATAFINAL"));
                setCODIGOOUTEMP(rs.getInt("CODIGOOUTEMP"));

                
                ps2 = con2.prepareStatement ("INSERT INTO FUNCOUTRAEMP (CODIGOEMPRESA, CODIGOFUNCCONTR, DATAINICIAL,"
                        + "DATAFINAL, CODIGOOUTEMP, CODIGOMOTIVO)"
                        + "VALUES (?,?,?,?,?,1);");
                    
                    ps2.setInt(1, getCODIGOEMPRESA());
                    ps2.setInt(2, getCODIGOFUNCCONTR());
                    ps2.setDate(3, getDATAINICIAL());
                    ps2.setDate(4, getDATAFINAL());
                    ps2.setInt(5, getCODIGOOUTEMP());
                    
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