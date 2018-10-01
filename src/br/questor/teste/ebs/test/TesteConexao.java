package br.questor.teste.ebs.test;

import br.questor.teste.ebs.control.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesteConexao {
	
    public void testeEBS() throws Exception{
        System.out.println("Iniciando conexão com o SQL Server...");
		
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
		
        try{
            ps = con.prepareStatement("SELECT * FROM CRDEMPRESA;");
            ResultSet rs = ps.executeQuery();
			
            System.out.println("Conectado com sucesso.");
	}
	catch(Exception ex){
            System.out.println("Conexão com o SQL Server falhou.");
            ex.printStackTrace();
	}
	finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
	}
    }
    public void testeQST() throws Exception{
        System.out.println("Iniciando conexão com o FireBird...");
		
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
		
        try{
            ps2 = con2.prepareStatement("SELECT * FROM EMPRESA;");
            ResultSet rs2 = ps2.executeQuery();
			
            System.out.println("Conectado com sucesso.");
	}
	catch(Exception ex){
            System.out.println("Conexão com o FireBird falhou.");
            ex.printStackTrace();
	}
	finally{
            if(ps2 != null){
                ps2.close();
            }
            if(con2 != null){
                con2.close();
            }
	}
    }
}