package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.CFGEmpresaFPAOpcao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CFGEmpresaFPAOpcaoDAO extends CFGEmpresaFPAOpcao{
      
    public void CFGEmpresaFPAOpcaoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT CD_EMPRESA AS CODIGOEMPRESA \n" +
"FROM CRDEMPRESA\n" +
"WHERE CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999)"
                    + "ORDER BY CODIGOEMPRESA;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                

                    ps2 = con2.prepareStatement ("INSERT INTO CFGEMPRESAFPAOPCAO \n" +
"(CODIGOEMPRESA, DATAOPCAO, PORTEEMP, QUEBRAGPS, ATIVCOMCOMITANTE, COMPETRECSIMPLES, REGIMESSIMPLES)\n" +
"VALUES\n" +
"(?, '1900-01-01', 1, 1, 0, 1, 1);");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
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