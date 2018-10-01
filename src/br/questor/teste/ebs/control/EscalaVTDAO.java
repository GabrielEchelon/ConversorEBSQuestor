package br.questor.teste.ebs.control;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EscalaVTDAO{
      
    public void motivoDemissaoQuery() throws Exception{
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{               
            System.out.print(".");
                               
            ps2 = con2.prepareStatement ("INSERT INTO MOTIVODEMISSAO (CODIGOMOTDEM, DESCRMOTDEM) \n" +
"VALUES (2, 'Rescisão');");
                         
            ps2.executeUpdate();
            
            System.out.println("\nTabela finalizada. (MOTIVODEMISSAO)");
        }
        catch(Exception ex){
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