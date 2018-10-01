package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncCargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncCargoDAO extends FuncCargo{
      
    public void funcCargoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	FUNF.cd_empresa AS CODIGOEMPRESA,\n" +
"		FUNF.cd_funcionario AS CODIGOFUNCCONTR,\n" +
"		/*FUNF.cd_funcionario,*/\n" +
"		FUNF.dt_funcao AS DATAINICIAL,\n" +
"		SEL.CODIGOCARGO AS CODIGOCARGO,\n" +
"		3 AS CODIGOMOTIVO,\n" +
"		0 AS CODIGOFUNCAO\n" +
"FROM funfuncao funf \n" +
"JOIN SEL_QST_FUNCAO sel \n" +
"ON funf.cd_empresa = SEL.enterprise_id \n" +
"AND FUNF.cd_funcao = SEL.cd_funcao\n" +
"ORDER BY CODIGOEMPRESA, CODIGOFUNCCONTR");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR (rs.getInt("CODIGOFUNCCONTR"));
                setDATAINICIAL (rs.getDate("DATAINICIAL"));
                setCODIGOCARGO (rs.getInt("CODIGOCARGO"));

                ps2 = con2.prepareStatement ("INSERT INTO FUNCCARGO (CODIGOEMPRESA, CODIGOFUNCCONTR, DATAINICIAL, CODIGOCARGO, CODIGOMOTIVO, CODIGOFUNCAO)\n" +
"               VALUES (?,?,?,?,3,0);");
                    
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setInt(2, this.getCODIGOFUNCCONTR());
                ps2.setDate(3, this.getDATAINICIAL());
                ps2.setInt(4, this.getCODIGOCARGO());
                    
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