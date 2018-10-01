package br.questor.teste.ebs.test;

import br.questor.teste.ebs.control.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesteDAO {
    
      
    public void testeQuery() throws Exception{
        System.out.println("Iniciando conexão com o SQL Server...");
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            
            ps = con.prepareStatement("SELECT * FROM CRDEMPRESA;");
            ResultSet rs = ps.executeQuery();
            
            System.out.println("Conectado com sucesso.");
            
            System.out.println("\nIniciando conexão com o FireBird...");
            
            while(rs.next()){

                ps2 = con2.prepareStatement ("SELECT * FROM EMPRESA;");
                ResultSet rs2 = ps2.executeQuery();
            }
            System.out.println("Conectado com sucesso.");
            
        }
        catch(Exception ex){
            System.out.println("Conexão com um ou mais banco de dados falhou! Verifique o print abaixo: ");
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