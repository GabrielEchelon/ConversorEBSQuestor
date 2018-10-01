package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncSalario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncSalarioDAO extends FuncSalario{
      
    public void funcSalarioQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	FUNSALARIO.cd_empresa CODIGOEMPRESA,\n" +
"		FUNQUERY.CODIGOFUNCCONTR,\n" +
"		FUNSALARIO.dt_salario AS DATAINICIAL,\n" +
"		CASE\n" +
"			WHEN FUNSALARIO.tipo_salario LIKE '%M%' THEN 1\n" +
"			WHEN FUNSALARIO.tipo_salario LIKE '%H%' THEN 5\n" +
"			ELSE 1\n" +
"		END AS TIPOSALARIO,\n" +
"		CASE\n" +
"			WHEN FUNSALARIO.vl_salario IS NULL THEN 0\n" +
"			ELSE FUNSALARIO.vl_salario\n" +
"		END AS VALORSAL,\n" +
"		CASE\n" +
"			WHEN FUNSALARIO.vl_adiantamento IS NULL THEN 0\n" +
"			ELSE FUNSALARIO.vl_adiantamento\n" +
"		END AS ANTECSAL\n" +
"FROM FunSalario FUNSALARIO\n" +
"LEFT JOIN (SELECT  FUNFUNCIONAL.cd_empresa AS CODIGOEMPRESA,\n" +
"			FUNFUNCIONAL.cd_funcionario AS CODIGOFUNCCONTR,\n" +
"			FUNFUNCIONAL.cd_funcionario AS CODIGOFUNCPESSOA\n" +
"			FROM funfuncional FUNFUNCIONAL\n" +
"			LEFT JOIN (SELECT  FUNCIONARIO.cd_funcionario AS CODIGOFUNCPESSOA, \n" +
"			RTRIM(LTRIM(FUNCIONARIO.nome)) AS NOMEFUNC, \n" +
"			FUNCIONARIO.cd_empresa AS CODIGOEMPRESA\n" +
"			FROM funcionario AS FUNCIONARIO) as FC \n" +
"			ON FUNFUNCIONAL.cd_funcionario = FC.CODIGOFUNCPESSOA and FUNFUNCIONAL.cd_empresa = FC.CODIGOEMPRESA) AS FUNQUERY\n" +
"ON FUNQUERY.CODIGOEMPRESA = FUNSALARIO.cd_empresa AND FUNQUERY.CODIGOFUNCPESSOA = FUNSALARIO.cd_funcionario\n" +
"WHERE CODIGOFUNCCONTR IS NOT NULL;");
            ResultSet rs = ps.executeQuery();
            
            ps2 = con2.prepareStatement("INSERT INTO MOTIVO (CODIGOMOTIVO, TIPOALTERACAO, DESCRMOTIVO) VALUES (3,0,'Importação / Inválido');");
            ps2.executeUpdate();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR (rs.getInt("CODIGOFUNCCONTR"));
                setDATAINICIAL (rs.getDate("DATAINICIAL"));
                setTIPOSALARIO (rs.getInt("TIPOSALARIO"));
                setVALORSAL (rs.getDouble("VALORSAL"));
                setANTECSAL (rs.getInt("ANTECSAL"));

                ps2 = con2.prepareStatement ("INSERT INTO FUNCSALARIO (CODIGOEMPRESA, CODIGOFUNCCONTR, DATAINICIAL, \n" +
"CODIGOMOTIVO, TIPOSALARIO,VALORSAL, COMPLSAL, ANTECSAL, SALCARNE)\n" +
"VALUES (?,?,?,3,?,?,0,?,0);");
                    
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setInt(2, this.getCODIGOFUNCCONTR());
                ps2.setDate(3, this.getDATAINICIAL());
                ps2.setInt(4, this.getTIPOSALARIO());
                ps2.setDouble(5, this.getVALORSAL());
                ps2.setDouble(6, this.getANTECSAL());
                    
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