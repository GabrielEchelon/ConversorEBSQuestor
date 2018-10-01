package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class HorarioDAO extends Horario{
      
    public void horarioQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT CODIGOHORARIO,\n" +
"       DATAINICIAL,\n" +
"       CASE\n" +
"			WHEN LEN(DESCRHORARIO) > 30\n" +
"			THEN CONCAT(LEFT(DESCRHORARIO,5),'...',RIGHT(DESCRHORARIO,5))\n" +
"			ELSE DESCRHORARIO\n" +
"	   END AS DESCRHORARIO\n" +
"FROM QST_HORARIO");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                
                
                System.out.print(".");
                
                setCODIGOHORARIO (rs.getInt("CODIGOHORARIO"));
                setDATAINICIAL (rs.getDate("DATAINICIAL"));
                setDESCRHORARIO (rs.getString("DESCRHORARIO"));

                
                ps2 = con2.prepareStatement ("INSERT INTO HORARIO (CODIGOHORARIO,DATAINICIAL,DESCRHORARIO,\n" +
"INTRAJORNADA,TIPOHORARIO,HORASINTRAJORDIURNA,PERMITEFLEX,\n" +
"TIPOINTERVAL,HORASINTRAJORNOTURNA,TIPOALTERACAOESOCIAL)\n" +
"VALUES (?,?,?,0,1,0,0,1,0,0);");
                ps2.setInt(1, this.getCODIGOHORARIO());
                ps2.setDate(2, this.getDATAINICIAL());
                ps2.setString(3, this.getDESCRHORARIO());
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