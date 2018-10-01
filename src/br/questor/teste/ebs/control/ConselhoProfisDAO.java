package br.questor.teste.ebs.control;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConselhoProfisDAO{
      
    public void conselhorProfisQuery() throws Exception{
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{           
            ps2 = con2.prepareStatement ("insert into conselhoprofis (CODIGOCONSELHO, NOMECONSELHO, SIGLACONSELHO, ENDERCONSELHO, NUMEROENDER, COMPLENDER, BAIRROCONSELHO, SIGLAESTADO, CODIGOMUNIC, CEPCONSELHO, DDDFONE, NUMEROFONE, ENDERELETR, PAGINAINTER, CODIGOTIPOLOGRAD) values (2, 'Conselho Regional de Enfermagem do Paraná', 'COREN', null, null, null, null, 'PR', null, null, null, null, null, null, null);");
            ps2.executeUpdate();
            
            ps2 = con2.prepareStatement ("insert into conselhoprofis (CODIGOCONSELHO, NOMECONSELHO, SIGLACONSELHO, ENDERCONSELHO, NUMEROENDER, COMPLENDER, BAIRROCONSELHO, SIGLAESTADO, CODIGOMUNIC, CEPCONSELHO, DDDFONE, NUMEROFONE, ENDERELETR, PAGINAINTER, CODIGOTIPOLOGRAD) values (3, 'Conselho Regional de Medicina/PR', 'CRM/PR', 'VICTORIO VIEZZER', 84, null, 'VISTA ALEGRE', 'PR', 94, '80.810-340', null, null, null, 'http://www.crmpr.org.br/', 33);");
            ps2.executeUpdate();
            
            ps2 = con2.prepareStatement ("insert into conselhoprofis (CODIGOCONSELHO, NOMECONSELHO, SIGLACONSELHO, ENDERCONSELHO, NUMEROENDER, COMPLENDER, BAIRROCONSELHO, SIGLAESTADO, CODIGOMUNIC, CEPCONSELHO, DDDFONE, NUMEROFONE, ENDERELETR, PAGINAINTER, CODIGOTIPOLOGRAD) values (4, 'Conselho Regional de Medicina/SP', 'CREMESP', 'Rua Frei Caneca', 1282, null, null, 'SP', 563, '01.000-000', null, null, null, null, 33);");
            ps2.executeUpdate();
            
            System.out.println("\n\nTabela finalizada. (CONSELHORPROFIS)");
            
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