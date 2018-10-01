package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Organograma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrganogramaDAO extends Organograma{
      
    public void OrganogramaQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT DISTINCT CD_EMPRESA AS CODIGOEMPRESA,\n" +
"		CD_FILIAL AS CODIGOESTAB,\n" +
"		CASE\n" +
"	WHEN CD_NIVEL1 <> 0 AND LEN(CD_NIVEL1) <= 1 THEN\n" +
"		CONCAT('00',CD_NIVEL1,  \n" +
"			CASE \n" +
"				WHEN CD_NIVEL2 <> 0 AND LEN(CD_NIVEL2) <=1 THEN\n" +
"				CONCAT('.00',CD_NIVEL2, \n" +
"					CASE\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) <=1 THEN\n" +
"						CONCAT('.00',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 2 THEN\n" +
"						CONCAT('.0',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"						CONCAT('.',CD_NIVEL3)\n" +
"					END\n" +
"				)\n" +
"				WHEN CD_NIVEL2 <> 0 AND LEN(CD_NIVEL2) = 2 THEN\n" +
"				CONCAT('.0',CD_NIVEL2,\n" +
"					CASE\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) <=1 THEN\n" +
"						CONCAT('.00',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 2 THEN\n" +
"						CONCAT('.0',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"						CONCAT('.',CD_NIVEL3)\n" +
"					END\n" +
"				)\n" +
"				WHEN CD_NIVEL2 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"				CONCAT('.',CD_NIVEL2,\n" +
"					CASE\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) <=1 THEN\n" +
"						CONCAT('.00',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 2 THEN\n" +
"						CONCAT('.0',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"						CONCAT('.',CD_NIVEL3)\n" +
"					END\n" +
"				)\n" +
"			END\n" +
"		)\n" +
"	WHEN CD_NIVEL1 <> 0 AND LEN(CD_NIVEL1) = 2 THEN\n" +
"		CONCAT('0',CD_NIVEL1,  \n" +
"			CASE \n" +
"				WHEN CD_NIVEL2 <> 0 AND LEN(CD_NIVEL2) <=1 THEN\n" +
"				CONCAT('.00',CD_NIVEL2, \n" +
"					CASE\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) <=1 THEN\n" +
"						CONCAT('.00',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 2 THEN\n" +
"						CONCAT('.0',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"						CONCAT('.',CD_NIVEL3)\n" +
"					END\n" +
"				)\n" +
"				WHEN CD_NIVEL2 <> 0 AND LEN(CD_NIVEL2) = 2 THEN\n" +
"				CONCAT('.0',CD_NIVEL2,\n" +
"					CASE\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) <=1 THEN\n" +
"						CONCAT('.00',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 2 THEN\n" +
"						CONCAT('.0',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"						CONCAT('.',CD_NIVEL3)\n" +
"					END\n" +
"				)\n" +
"				WHEN CD_NIVEL2 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"				CONCAT('.',CD_NIVEL2,\n" +
"					CASE\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) <=1 THEN\n" +
"						CONCAT('.00',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 2 THEN\n" +
"						CONCAT('.0',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"						CONCAT('.',CD_NIVEL3)\n" +
"					END\n" +
"				)\n" +
"			END\n" +
"		)\n" +
"	WHEN CD_NIVEL1 <> 0 AND LEN(CD_NIVEL1) = 3 THEN\n" +
"		CONCAT(CD_NIVEL1,  \n" +
"			CASE \n" +
"				WHEN CD_NIVEL2 <> 0 AND LEN(CD_NIVEL2) <=1 THEN\n" +
"				CONCAT('.00',CD_NIVEL2, \n" +
"					CASE\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) <=1 THEN\n" +
"						CONCAT('.00',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 2 THEN\n" +
"						CONCAT('.0',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"						CONCAT('.',CD_NIVEL3)\n" +
"					END\n" +
"				)\n" +
"				WHEN CD_NIVEL2 <> 0 AND LEN(CD_NIVEL2) = 2 THEN\n" +
"				CONCAT('.0',CD_NIVEL2,\n" +
"					CASE\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) <=1 THEN\n" +
"						CONCAT('.00',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 2 THEN\n" +
"						CONCAT('.0',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"						CONCAT('.',CD_NIVEL3)\n" +
"					END\n" +
"				)\n" +
"				WHEN CD_NIVEL2 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"				CONCAT('.',CD_NIVEL2,\n" +
"					CASE\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) <=1 THEN\n" +
"						CONCAT('.00',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 2 THEN\n" +
"						CONCAT('.0',CD_NIVEL3)\n" +
"						WHEN CD_NIVEL3 <> 0 AND LEN(CD_NIVEL3) = 3 THEN\n" +
"						CONCAT('.',CD_NIVEL3)\n" +
"					END\n" +
"				)\n" +
"			END\n" +
"		)\n" +
"END AS CLASSIFORGAN,\n" +
"		LTRIM(RTRIM(LEFT(DESCRICAO,30))) AS DESCRORGAN\n" +
"FROM ESTRUTURA\n" +
"WHERE CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999)\n" +
"ORDER BY CODIGOEMPRESA;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOESTAB (rs.getInt("CODIGOESTAB"));
                setCLASSIFORGAN (rs.getString("CLASSIFORGAN"));
                setDESCRORGAN (rs.getString("DESCRORGAN"));


                ps2 = con2.prepareStatement ("INSERT INTO ORGANOGRAMA (CODIGOEMPRESA, CODIGOESTAB, CLASSIFORGAN, DESCRORGAN, TIPOCONTA, ATIVIDADESIMPLES)\n" +
"               VALUES (?,?,?,?,2,0);");
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setInt(2, this.getCODIGOESTAB());
                ps2.setString(3, this.getCLASSIFORGAN());
                ps2.setString(4, this.getDESCRORGAN());

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