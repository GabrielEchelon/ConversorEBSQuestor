package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Afastamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AfastamentoDAO extends Afastamento{
      
    public void afastamentoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	cd_empresa AS CODIGOEMPRESA,\n" +
"		cd_funcionario AS CODIGOFUNCCONTR,\n" +
"		dt_movimentacao AS DATAAFAST,\n" +
"		ROW_NUMBER() OVER(ORDER BY cd_empresa,cd_funcionario) AS SEQ,\n" +
"		CASE\n" +
"			WHEN tipo_movimentacao = 2 THEN 7\n" +
"			WHEN tipo_movimentacao = 1 THEN\n" +
"				CASE\n" +
"					WHEN tipo_afastamento like '%ACI%' THEN 4\n" +
"					WHEN tipo_afastamento like '%ADO%' THEN 25\n" +
"					WHEN tipo_afastamento like '%APO%' THEN 28\n" +
"					WHEN tipo_afastamento like '%DIV%' THEN 34\n" +
"					WHEN tipo_afastamento like '%DOE%' THEN 3\n" +
"					WHEN tipo_afastamento like '%EXE%' THEN 5\n" +
"					WHEN tipo_afastamento like '%LIC%' THEN 8\n" +
"					WHEN tipo_afastamento like '%MAT%' THEN 6\n" +
"					WHEN tipo_afastamento like '%PAT%' THEN 31\n" +
"					WHEN tipo_afastamento like '%SIN%' THEN 11\n" +
"				END \n" +
"		END AS CODIGOSIT,\n" +
"		CURRENT_TIMESTAMP AS DATAHORALCTO\n" +
"FROM FUNMOVIMENTACAO ORDER BY CODIGOEMPRESA, CODIGOFUNCCONTR");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR (rs.getInt("CODIGOFUNCCONTR"));
                setDATAAFAST (rs.getDate("DATAAFAST"));
                setSEQ (rs.getInt("SEQ"));
                setCODIGOSIT (rs.getInt("CODIGOSIT"));
                setDATAHORALCTO (rs.getDate("DATAHORALCTO"));
                

                    ps2 = con2.prepareStatement ("INSERT INTO AFASTAMENTO (CODIGOEMPRESA, CODIGOFUNCCONTR, DATAAFAST,\n" +
"SEQ, CODIGOSIT, PERDEVALETRANSP, PERDEDSR, PERDEFERIAS, EXAMERETORNO,\n" +
"ORIGEMDADO, DATAHORALCTO)\n" +
"VALUES (?,?,?,?,?,0,0,0,0,3,?);");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.setInt(2, this.getCODIGOFUNCCONTR());
                    ps2.setDate(3, this.getDATAAFAST());
                    ps2.setInt(4, this.getSEQ());
                    ps2.setInt(5, this.getCODIGOSIT());
                    ps2.setDate(6, this.getDATAHORALCTO());
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