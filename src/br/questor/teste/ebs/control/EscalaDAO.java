package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Escala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EscalaDAO extends Escala{
      
    public void escalaQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT (ROW_NUMBER() OVER(ORDER BY DESCRESCALA)+9) AS CODIGOESCALA,\n" +
"		SUBSTRING(DESCRESCALA,1,50) AS DESCRESCALA,\n" +
"		CARGAHORMENSAL,\n" +
"		CARGAHORSEMANAL,\n" +
"		CARGAHORDIARIA,\n" +
"		TABELAFERIADO AS TABELAFERIADO,\n" +
"		HORARIOVARIAVEL AS HORARIOVARIAVEL,\n" +
"		TURNO AS TURNO\n" +
"FROM SEL_QST_ESCALA");
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOESCALA(rs.getInt("CODIGOESCALA"));
                setDESCRESCALA(rs.getString("DESCRESCALA"));
                setCARGAHORMENSAL(rs.getInt("CARGAHORMENSAL"));
                setCARGAHORSEMANAL(rs.getInt("CARGAHORSEMANAL"));
                setCARGAHORDIARIA(rs.getInt("CARGAHORDIARIA"));
                setTABELAFERIADO(rs.getInt("TABELAFERIADO"));
                setHORARIOVARIAVEL(rs.getInt("HORARIOVARIAVEL"));
                setTURNO(rs.getInt("TURNO"));

                
                ps2 = con2.prepareStatement ("INSERT INTO ESCALA (CODIGOESCALA, DESCRESCALA, CARGAHORMENSAL,"
                        + "CARGAHORSEMANAL, CARGAHORDIARIA, TABELAFERIADO, HORARIOVARIAVEL, TURNO)"
                        + "VALUES (?,?,?,?,?,?,?,?);");
                    
                    ps2.setInt(1, getCODIGOESCALA());
                    ps2.setString(2, getDESCRESCALA());
                    ps2.setInt(3, getCARGAHORMENSAL());
                    ps2.setInt(4, getCARGAHORSEMANAL());
                    ps2.setInt(5, getCARGAHORDIARIA());
                    ps2.setInt(6, getTABELAFERIADO());
                    ps2.setInt(7, getHORARIOVARIAVEL());
                    ps2.setInt(8, getTURNO());
                    
                    ps2.executeUpdate();
            }
            ps2 = con2.prepareStatement ("INSERT INTO ESCALA (CODIGOESCALA, DESCRESCALA, CARGAHORMENSAL,"
                + "CARGAHORSEMANAL, CARGAHORDIARIA, TABELAFERIADO, HORARIOVARIAVEL, TURNO)"
                + "VALUES (9999,'Não possuia jornada', 0,0,0,2,0,1)");
            ps2.executeUpdate();
            
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