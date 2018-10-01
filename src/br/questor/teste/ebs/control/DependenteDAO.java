package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Dependente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DependenteDAO extends Dependente{
      
    public void dependenteQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT FUNDEPENDENTE.cd_empresa AS CODIGOEMPRESA,\n" +
"	   FUNQUERY.CODIGOFUNCCONTR,\n" +
"	   FUNDEPENDENTE.cd_dependente AS CODIGODEPEND,\n" +
"	   CASE \n" +
"			WHEN RTRIM(LTRIM(FUNDEPENDENTE.cpf_dependente)) IS NULL THEN NULL\n" +
"			WHEN RTRIM(LTRIM(FUNDEPENDENTE.cpf_dependente)) LIKE ' ' THEN NULL\n" +
"			WHEN RTRIM(LTRIM(FUNDEPENDENTE.cpf_dependente)) LIKE '' THEN NULL\n" +
"			ELSE LEFT(RTRIM(LTRIM(FUNDEPENDENTE.cpf_dependente)),14)\n" +
"	   END AS CPFDEPEND,\n" +
"	   LEFT(RTRIM(LTRIM(FUNDEPENDENTE.nome)),70) AS NOMEDEPEND,\n" +
"	   FUNDEPENDENTE.dt_nascimento AS DATANASC,\n" +
"	   CASE\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 1 THEN '02'\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 2 THEN '01'\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 3 THEN '18'\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 4 THEN '17'\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 5 THEN '01'\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 6 THEN '14'\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 7 THEN '14'\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 8 THEN '14'\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 9 THEN '14' \n" +
"	   END AS PARENTESCO,\n" +
"	   CASE\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 2 THEN 1\n" +
"			WHEN FUNDEPENDENTE.tipo_parentesco = 5 THEN 2\n" +
"			WHEN FUNCIONARIO.SEXO LIKE '%M%' AND FUNDEPENDENTE.tipo_parentesco = 1 THEN 2 \n" +
"			WHEN FUNCIONARIO.SEXO LIKE '%F%' AND FUNDEPENDENTE.tipo_parentesco = 1 THEN 1 \n" +
"			ELSE 1\n" +
"	   END AS SEXO\n" +
"FROM fundependente FUNDEPENDENTE\n" +
"LEFT JOIN funcionario AS FUNCIONARIO\n" +
"ON FUNDEPENDENTE.cd_empresa = FUNCIONARIO.cd_empresa \n" +
"AND FUNDEPENDENTE.cd_funcionario = FUNCIONARIO.cd_funcionario\n" +
"LEFT JOIN (SELECT  FUNFUNCIONAL.cd_empresa AS CODIGOEMPRESA,\n" +
"			FUNFUNCIONAL.cd_funcionario AS CODIGOFUNCCONTR,\n" +
"			FUNFUNCIONAL.cd_funcionario AS CODIGOFUNCPESSOA\n" +
"			FROM funfuncional FUNFUNCIONAL\n" +
"			LEFT JOIN (SELECT  FUNCIONARIO.cd_funcionario AS CODIGOFUNCPESSOA, \n" +
"			RTRIM(LTRIM(FUNCIONARIO.nome)) AS NOMEFUNC, \n" +
"			FUNCIONARIO.cd_empresa AS CODIGOEMPRESA\n" +
"			FROM funcionario AS FUNCIONARIO) as FC \n" +
"			ON FUNFUNCIONAL.cd_funcionario = FC.CODIGOFUNCPESSOA and FUNFUNCIONAL.cd_empresa = FC.CODIGOEMPRESA) AS FUNQUERY\n" +
"ON FUNQUERY.CODIGOEMPRESA = FUNDEPENDENTE.cd_empresa AND FUNQUERY.CODIGOFUNCPESSOA = FUNDEPENDENTE.cd_funcionario\n" +
"ORDER BY codigoempresa, CODIGOFUNCCONTR;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR (rs.getInt("CODIGOFUNCCONTR"));
                setCODIGODEPEND (rs.getInt("CODIGODEPEND")); 
                setCPFDEPEND (rs.getString("CPFDEPEND"));
                setNOMEDEPEND (rs.getString("NOMEDEPEND"));
                setDATANASC (rs.getDate("DATANASC"));
                setPARENTESCO (rs.getString("PARENTESCO"));
                setSEXO (rs.getInt("SEXO"));

                ps2 = con2.prepareStatement ("INSERT INTO DEPENDENTE (CODIGOEMPRESA, CODIGOFUNCCONTR, CODIGODEPEND,\n" +
"CPFDEPEND, NOMEDEPEND, DATANASC, PARENTESCO, SEXO, GRAUINSTR, ESTADOCIVIL,\n" +
"FORMACONTROLEIR, NACIONALIDADE, FUMANTE, CONSOMEALCOOL)\n" +
"VALUES (?,?,?,?,?,?,?,?,'03',6,1,10,0,0);");
                    
        ps2.setInt(1, this.getCODIGOEMPRESA());
        ps2.setInt(2, this.getCODIGOFUNCCONTR());
        ps2.setInt(3, this.getCODIGODEPEND());
        ps2.setString(4, this.getCPFDEPEND());
        ps2.setString(5, this.getNOMEDEPEND());
        ps2.setDate(6, this.getDATANASC());
        ps2.setString(7, this.getPARENTESCO());
        ps2.setInt(8, this.getSEXO());

                    
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