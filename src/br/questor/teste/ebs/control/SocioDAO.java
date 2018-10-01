package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SocioDAO extends Socio{
      
    public void socioQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT 	CRDESTABELECIMENTO.cd_empresa AS CODIGOEMPRESA,\n" +
"		CRDESTABELECIMENTO.cd_estabelecimento AS CODIGOSOCIO,\n" +
"		LTRIM(RTRIM(CRDESTABELECIMENTO.nome_titular)) AS NOMESOCIO,\n" +
"		CASE\n" +
"			WHEN LEN(LTRIM(RTRIM(CRDESTABELECIMENTO.cpf_titular))) = 14 THEN 1\n" +
"			WHEN LEN(LTRIM(RTRIM(CRDESTABELECIMENTO.cpf_titular))) = 18 THEN 2\n" +
"			WHEN LEN(LTRIM(RTRIM(CRDESTABELECIMENTO.cpf_titular))) = 16 THEN 3\n" +
"			ELSE 1\n" +
"		END AS TIPOINSCR,\n" +
"		CASE \n" +
"			WHEN CRDESTABELECIMENTO.cpf_titular IS NULL THEN '00.100.000/0001-19'\n" +
"			ELSE CRDESTABELECIMENTO.cpf_titular\n" +
"		END AS INSCRFEDERAL,\n" +
"		LTRIM(RTRIM(CRDESTABELECIMENTO.rg_titular)) AS NUMERORG,\n" +
"		CASE\n" +
"			WHEN QST_MUNICIPIO.CODIGOMUNIC IS NULL AND CRDESTABELECIMENTO.uf_titular LIKE '%PR%' THEN 94\n" +
"			WHEN QST_MUNICIPIO.CODIGOMUNIC IS NULL AND CRDESTABELECIMENTO.uf_titular NOT LIKE '%PR%' THEN 1\n" +
"			WHEN QST_MUNICIPIO.CODIGOMUNIC IS NULL AND CRDESTABELECIMENTO.uf_titular IS NULL THEN 1\n" +
"			ELSE QST_MUNICIPIO.CODIGOMUNIC\n" +
"		END AS CODIGOMUNIC,\n" +
"		CASE\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'AER%' THEN 1\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'AL%' THEN 2\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'A%' THEN 3\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'AV%' THEN 4\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'CPO%' THEN 5\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'CH%' THEN 6\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'COL%' THEN 7\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'CON%' THEN 8\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'CJ%' THEN 9\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'DT%' THEN 10\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'ESP%' THEN 11\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'ETC%' THEN 12\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'EST%' THEN 13\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'FAV%' THEN 14\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'FAZ%' THEN 15\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'FRA%' THEN 16\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'JD%' THEN 17\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'LD%' THEN 18\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'LG%' THEN 19\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'LGA%' THEN 20\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'LRG%' THEN 21\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'LOT%' THEN 22\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'MRO%' THEN 23\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'NUC%' THEN 24\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'PRQ%' THEN 25\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'PSA%' THEN 26\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'PAT%' THEN 27\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'PC%' THEN 28\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'Q%' THEN 29\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'REC%' THEN 30\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'RES%' THEN 31\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'ROD%' THEN 32\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'R%' THEN 33\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'ST%' THEN 34\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'SIT%' THEN 35\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'TV%' THEN 36\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'TR%' THEN 37\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'TRV%' THEN 38\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'VLE%' THEN 39\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'VER%' THEN 40\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'V%' THEN 41\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'VD%' THEN 42\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'VLA%' THEN 43\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'VL%' THEN 44\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'O%' THEN 99\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'BC%' THEN 100\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'CA%' THEN 101\n" +
"			WHEN CRDESTABELECIMENTO.endereco LIKE 'NR%' THEN 102\n" +
"			ELSE 37\n" +
"		END AS CODIGOTIPOLOGRAD,\n" +
"		CASE \n" +
"		WHEN LTRIM(RTRIM(CRDESTABELECIMENTO.endereco_titular)) IS NULL THEN 'Importação / Inválido'\n" +
"		ELSE LTRIM(RTRIM(CRDESTABELECIMENTO.endereco_titular))\n" +
"		END AS ENDERECOSOCIO,\n" +
"		CRDESTABELECIMENTO.numero_titular AS NUMENDERSOCIO,\n" +
"		CASE\n" +
"		WHEN LTRIM(RTRIM(CRDESTABELECIMENTO.bairro_titular)) IS NULL THEN 'Importação / Inválido'\n" +
"		ELSE LTRIM(RTRIM(CRDESTABELECIMENTO.bairro_titular))\n" +
"		END AS BAIRROENDERSOCIO,\n" +
"		LTRIM(RTRIM(CRDESTABELECIMENTO.complemento_titular)) AS COMPLENDERSOCIO,\n" +
"		CASE\n" +
"			WHEN LTRIM(RTRIM(CRDESTABELECIMENTO.uf_titular)) LIKE ' %' AND CODIGOMUNIC < 400 THEN 'PR'\n" +
"			WHEN LTRIM(RTRIM(CRDESTABELECIMENTO.uf_titular)) LIKE '' THEN 'PR'\n" +
"			WHEN LTRIM(RTRIM(CRDESTABELECIMENTO.uf_titular)) IS NULL AND CODIGOMUNIC < 400 THEN 'PR'\n" +
"			WHEN LTRIM(RTRIM(CRDESTABELECIMENTO.uf_titular)) LIKE ' %' AND CODIGOMUNIC > 400 THEN 'SP'\n" +
"			WHEN LTRIM(RTRIM(CRDESTABELECIMENTO.uf_titular)) LIKE '' AND CODIGOMUNIC > 400 THEN 'SP'\n" +
"			WHEN LTRIM(RTRIM(CRDESTABELECIMENTO.uf_titular)) IS NULL AND CODIGOMUNIC > 400 THEN 'SP'\n" +
"			WHEN LTRIM(RTRIM(CRDESTABELECIMENTO.uf_titular)) IS NULL THEN 'PR'\n" +
"			ELSE CRDESTABELECIMENTO.uf_titular\n" +
"		END AS SIGLAESTADO,\n" +
"		CASE\n" +
"		WHEN CRDESTABELECIMENTO.cep_titular IS NULL THEN '11.111-111'\n" +
"        ELSE CONCAT(LEFT(CRDESTABELECIMENTO.cep_titular,2), '.',RIGHT(LEFT(CRDESTABELECIMENTO.cep_titular,5),3), '-', RIGHT(CRDESTABELECIMENTO.cep_titular,3)) \n" +
"        END AS CEPENDERSOCIO,\n" +
"		CRDESTABELECIMENTO.ddd_telefone_titular AS DDDFONE,\n" +
"		CRDESTABELECIMENTO.telefone_titular AS NUMEROFONE,\n" +
"		LTRIM(RTRIM(CRDESTABELECIMENTO.email_titular)) AS EMAIL,\n" +
"		CASE\n" +
"			WHEN CRDESTABELECIMENTO.denom_titular LIKE 'SOCIO' THEN 1\n" +
"			WHEN CRDESTABELECIMENTO.denom_titular LIKE '%ADM%' THEN 2\n" +
"			WHEN CRDESTABELECIMENTO.denom_titular LIKE '%TITU%' THEN 4\n" +
"			WHEN CRDESTABELECIMENTO.denom_titular LIKE '%PRESI%' THEN 5\n" +
"            ELSE 1\n" +
"		END AS TIPOSOCIO\n" +
"FROM CRDESTABELECIMENTO AS CRDESTABELECIMENTO\n" +
"LEFT JOIN QST_MUNICIPIO QST_MUNICIPIO \n" +
"ON CRDESTABELECIMENTO.CIDADE = QST_MUNICIPIO.NOMEMUNIC AND CRDESTABELECIMENTO.UF_TITULAR = QST_MUNICIPIO.SIGLAESTADO\n" +
"WHERE CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999)\n" +
"ORDER BY SIGLAESTADO;");
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA(rs.getInt("CODIGOEMPRESA"));
                setCODIGOSOCIO(rs.getInt("CODIGOSOCIO"));
                setNOMESOCIO(rs.getString("NOMESOCIO"));
                setTIPOINSCR(rs.getInt("TIPOINSCR"));
                setINSCRFEDERAL(rs.getString("INSCRFEDERAL"));
                setNUMERORG(rs.getString("NUMERORG"));
                setCODIGOMUNIC(rs.getInt("CODIGOMUNIC"));
                setCODIGOTIPOLOGRAD(rs.getInt("CODIGOTIPOLOGRAD"));
                setENDERECOSOCIO(rs.getString("ENDERECOSOCIO"));
                setNUMENDERSOCIO(rs.getInt("NUMENDERSOCIO"));
                setBAIRROENDERSOCIO(rs.getString("BAIRROENDERSOCIO"));
                setCOMPLENDERSOCIO(rs.getString("COMPLENDERSOCIO"));
                setSIGLAESTADO(rs.getString("SIGLAESTADO"));
                setCEPENDERSOCIO(rs.getString("CEPENDERSOCIO"));
                setDDDFONE(rs.getInt("DDDFONE"));
                setNUMEROFONE(rs.getInt("NUMEROFONE"));
                setEMAIL(rs.getString("EMAIL"));
                setTIPOSOCIO(rs.getInt("TIPOSOCIO"));
                
                ps2 = con2.prepareStatement ("INSERT INTO SOCIO (\n" +
"		CODIGOEMPRESA,\n" +
"		CODIGOSOCIO,\n" +
"		DATAINICIAL,\n" +
"		NOMESOCIO,\n" +
"		TIPOINSCR,\n" +
"		INSCRFEDERAL,\n" +
"		NUMERORG,\n" +
"		CODIGOMUNIC,\n" +
"		CODIGOTIPOLOGRAD,\n" +
"		ENDERECOSOCIO,\n" +
"		NUMENDERSOCIO,\n" +
"		BAIRROENDERSOCIO,\n" +
"		COMPLENDERSOCIO,\n" +
"		SIGLAESTADO,\n" +
"		CEPENDERSOCIO,\n" +
"		DDDFONE,\n" +
"		NUMEROFONE,\n" +
"		EMAIL,\n" +
"		RESPLEGAL,\n" +
"		TIPOSOCIO,\n" +
"		DESCRCARGO,\n" +
"		VALORNOMINALCOTAS,\n" +
"		DECLARAFISICAESCRIT,\n" +
"		QUALIFICACAOSOCIO,\n" +
"		SOCIOOSTENSIVO,\n" +
"		DATAINICIOSOCIO,\n" +
"		DATAFIMSOCIO\n" +
"		)\n" +
"               VALUES (?,?,\n" +
"		'1900-01-01',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,\n" +
"		1,?,'Sócio',0,1,1,0,'1900-01-01','2100-01-01');");
                    
                    ps2.setInt(1, getCODIGOEMPRESA());
                    ps2.setInt(2, getCODIGOSOCIO());
                    ps2.setString(3, getNOMESOCIO());
                    ps2.setInt(4, getTIPOINSCR());
                    ps2.setString(5,getINSCRFEDERAL());
                    ps2.setString(6, getNUMERORG());
                    ps2.setInt(7, getCODIGOMUNIC());
                    ps2.setInt(8, getCODIGOTIPOLOGRAD());
                    ps2.setString(9, getENDERECOSOCIO());
                    ps2.setInt(10, getNUMENDERSOCIO());
                    ps2.setString(11, getBAIRROENDERSOCIO());
                    ps2.setString(12, getCOMPLENDERSOCIO());
                    ps2.setString(13, getSIGLAESTADO());
                    ps2.setString(14, getCEPENDERSOCIO());
                    ps2.setInt(15, getDDDFONE());
                    ps2.setInt(16, getNUMEROFONE());
                    ps2.setString(17, getEMAIL());
                    ps2.setInt(18, getTIPOSOCIO());
                    
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