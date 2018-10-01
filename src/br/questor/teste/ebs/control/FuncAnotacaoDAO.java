package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncAnotacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class FuncAnotacaoDAO extends FuncAnotacao{
      
    public void funcAnotacaoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps2 = con2.prepareStatement ("INSERT INTO ANOTACAO (CODIGOANOT, DESCRANOT, CONSIDFICHAREG) VALUES (4, 'Comissionado', '1');");
            
            ps2.executeUpdate();
            
            ps2 = con2.prepareStatement ("INSERT INTO ANOTACAO (CODIGOANOT, DESCRANOT, CONSIDFICHAREG) VALUES (5, 'Transferência', '1');");
            
            ps2.executeUpdate();
            
            System.out.println("Inserida duas novas anotações no sistema.");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        
        try{
            ps = con.prepareStatement("SELECT	cd_empresa AS CODIGOEMPRESA, \n" +
"		cd_funcionario AS CODIGOFUNCCONTR, \n" +
"		dt_observacao AS DATAANOT, \n" +
"		sequencia AS SEQ, \n" +
"		CASE\n" +
"			WHEN descricao IS NULL THEN 1\n" +
"			WHEN descricao LIKE '%adve%' THEN 2\n" +
"			WHEN descricao LIKE '%suspe%' THEN 3\n" +
"			WHEN descricao LIKE '%trans%' THEN 5\n" +
"			ELSE 1\n" +
"		END AS CODIGOANOT, \n" +
"		CONCAT((CASE WHEN LTRIM(RTRIM(descricao)) IS NULL THEN ' ' ELSE LTRIM(RTRIM(descricao)) END), ' - ',\n" +
"			(CASE WHEN observacao IS NULL THEN ' ' ELSE observacao END))\n" +
"		AS OBSERV\n" +
"FROM FunObservacao");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR (rs.getInt("CODIGOFUNCCONTR"));
                setDATAANOT (rs.getDate("DATAANOT"));
                setSEQ (rs.getInt("SEQ"));
                setCODIGOANOT (rs.getInt("CODIGOANOT"));
                setOBSERV (rs.getString("OBSERV"));

                ps2 = con2.prepareStatement ("INSERT INTO FUNCANOTACAO(CODIGOEMPRESA, CODIGOFUNCCONTR, DATAANOT, SEQ, CODIGOANOT, OBSERV) \n" +
"VALUES (?,?,?,?,?,?);");
                
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setInt(2, this.getCODIGOFUNCCONTR());
                ps2.setDate(3, this.getDATAANOT());
                ps2.setInt(4, this.getSEQ());
                ps2.setInt(5, this.getCODIGOANOT());
                ps2.setString(6, this.getOBSERV());

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