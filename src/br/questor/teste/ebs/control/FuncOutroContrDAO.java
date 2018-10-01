package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncOutroContr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncOutroContrDAO extends FuncOutroContr{
      
    public void funcoutrocontrQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT cd_empresa AS CODIGOEMPRESA,\n" +
"	cd_funcionario AS CODIGOFUNCCONTR,\n" +
"	cd_vinculo AS SEQ,\n" +
"	SUBSTRING(razao,1,50) AS NOMEEMPRESA,\n" +
"	CASE \n" +
"		WHEN LEN(LTRIM(RTRIM(cnpj_cpf))) = 18 THEN 2\n" +
"		ELSE 1 \n" +
"	END AS TIPOINSCR,\n" +
"	RTRIM(LTRIM(cnpj_cpf)) AS INSCRFEDERAL\n" +
"FROM CRHFunMultiplosVinculos");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA(rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR(rs.getInt("CODIGOFUNCCONTR"));
                setSEQ(rs.getInt("SEQ"));
                setNOMEEMPRESA(rs.getString("NOMEEMPRESA"));
                setTIPOINSCR(rs.getInt("TIPOINSCR"));
                setINSCRFEDERAL(rs.getString("INSCRFEDERAL"));

                ps2 = con2.prepareStatement ("INSERT INTO FUNCOUTROCONTR (CODIGOEMPRESA, CODIGOFUNCCONTR, SEQ, TIPOOUTRO,"
                        + "NOMEEMPRESA, TIPOINSCR, INSCRFEDERAL) VALUES (?,?,?,2,?,?,?);");
                    
                    ps2.setInt(1, getCODIGOEMPRESA());
                    ps2.setInt(2, getCODIGOFUNCCONTR());
                    ps2.setInt(3, getSEQ());
                    ps2.setString(4, getNOMEEMPRESA());
                    ps2.setInt(5, getTIPOINSCR());
                    ps2.setString(6, getINSCRFEDERAL());

                    ps2.executeUpdate();
            }
            
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