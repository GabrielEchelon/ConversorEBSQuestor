package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LocalContabilDAO extends Empresa{
      
    public void localContabilQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT  CD_EMPRESA AS CODIGOEMPRESA" +
"           FROM CRDEMPRESA\n" +
"           WHERE CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999)\n"+
"           ORDER BY CODIGOEMPRESA;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));

                    ps2 = con2.prepareStatement ("insert into localcontabil (CODIGOEMPRESA, CODIGOLOCALCTB, DESCRLOCALCTB) values (?, 0, 'Nenhum');");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
                    
                    ps2 = con2.prepareStatement ("insert into localcontabil (CODIGOEMPRESA, CODIGOLOCALCTB, DESCRLOCALCTB) values (?, 1, 'DO - Administrativas');");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
                    
                    ps2 = con2.prepareStatement ("insert into localcontabil (CODIGOEMPRESA, CODIGOLOCALCTB, DESCRLOCALCTB) values (?, 2, 'DO - Vendas');");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
                    
                    ps2 = con2.prepareStatement ("insert into localcontabil (CODIGOEMPRESA, CODIGOLOCALCTB, DESCRLOCALCTB) values (?, 3, 'CP - Mão de Obra Direta');");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
                    
                    ps2 = con2.prepareStatement ("insert into localcontabil (CODIGOEMPRESA, CODIGOLOCALCTB, DESCRLOCALCTB) values (?, 4, 'CP - Mão de Obra Indireta');");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
                    
                    ps2 = con2.prepareStatement ("insert into localcontabil (CODIGOEMPRESA, CODIGOLOCALCTB, DESCRLOCALCTB) values (?, 5, 'CS - Mão de Obra Direta');");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
                    
                    ps2 = con2.prepareStatement ("insert into localcontabil (CODIGOEMPRESA, CODIGOLOCALCTB, DESCRLOCALCTB) values (?, 6, 'CS - Mão de Obra Indireta');");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
            }
            System.out.println("\n\nTabela finalizada. (LOCALCONTABIL)");
            
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