package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Terceiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TerceiroDAO extends Terceiro{
      
    public void terceiroQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT 	ROW_NUMBER() OVER(ORDER BY AUTONOMO.cd_empresa, AUTONOMO.cd_autonomo) AS CODIGOTERC,\n" +
"		AUTONOMO.nome AS NOMETERC,\n" +
"		CASE \n" +
"			WHEN RTRIM(LTRIM(AUTONOMO.sexo)) = 'M' THEN 1\n" +
"			WHEN RTRIM(LTRIM(AUTONOMO.sexo)) = 'F' THEN 2\n" +
"            ELSE 'M'\n" +
"		END AS SEXO,\n" +
"		AUTONOMO.pis AS PISTERC,\n" +
"		CASE \n" +
"			WHEN RTRIM(LTRIM(AUTONOMO.cpf)) = '' THEN NULL\n" +
"			WHEN RTRIM(LTRIM(AUTONOMO.cpf)) = ' ' THEN NULL\n" +
"			ELSE RTRIM(LTRIM(AUTONOMO.cpf))\n" +
"		END AS CPFTERC,\n" +
"		CASE \n" +
"			WHEN RTRIM(LTRIM(AUTONOMO.identidade)) = '' THEN NULL\n" +
"			WHEN RTRIM(LTRIM(AUTONOMO.identidade)) = ' ' THEN NULL\n" +
"			ELSE RTRIM(LTRIM(AUTONOMO.identidade))\n" +
"		END AS NUMERORG,\n" +
"		CASE \n" +
"			WHEN RTRIM(LTRIM(AUTONOMO.orgao_identidade)) = '' THEN NULL \n" +
"			WHEN RTRIM(LTRIM(AUTONOMO.orgao_identidade)) = ' ' THEN NULL\n" +
"			ELSE RTRIM(LTRIM(AUTONOMO.orgao_identidade))\n" +
"		END AS ORGEMISRG,\n" +
"		CASE \n" +
"			WHEN AUTONOMO.dt_admissao IS NULL THEN CURRENT_TIMESTAMP \n" +
"			ELSE AUTONOMO.dt_admissao \n" +
"		END AS DATAHORACADAST \n" +
"FROM autonomo AUTONOMO");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOTERC (rs.getInt("CODIGOTERC"));
                setNOMETERC (rs.getString("NOMETERC"));
                setSEXO (rs.getInt("SEXO"));
                setPISTERC (rs.getString("PISTERC"));
                setCPFTERC (rs.getString("CPFTERC"));
                setNUMERORG (rs.getString("NUMERORG"));
                setORGEMISRG (rs.getString("ORGEMISRG"));
                setDATAHORACADAST (rs.getDate("DATAHORACADAST"));

                    ps2 = con2.prepareStatement ("INSERT INTO TERCEIRO (CODIGOTERC, NOMETERC, SEXO, ESTADOCIVIL, GRAUINSTR,\n" +
"NACIONALIDADE, PISTERC, CPFTERC, NUMERORG, ORGEMISRG, DATAHORACADAST,\n" +
"EMITIRCARNE, CODIGOCARGO, CATEGORIA, SALCARNE, MULTVINCTERC, FORMACALCULOIRRF,\n" +
"PRODUTRURAL)\n" +
"VALUES (?,?,?,1,7,10,?,?,?,?,?,1,0,'02',0,0,0,0);");
                    
                    ps2.setInt(1, this.getCODIGOTERC());
                    ps2.setString(2, this.getNOMETERC());
                    ps2.setInt(3, this.getSEXO());
                    ps2.setString(4, this.getPISTERC());
                    ps2.setString(5, this.getCPFTERC());
                    ps2.setString(6, this.getNUMERORG());
                    ps2.setString(7, this.getORGEMISRG());
                    ps2.setDate(8, this.getDATAHORACADAST());
                    
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