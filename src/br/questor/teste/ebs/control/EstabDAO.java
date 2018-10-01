package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Estab;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstabDAO extends Estab{
      
    public void estabQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT 	DISTINCT CRDESTABELECIMENTO.cd_empresa AS CODIGOEMPRESA,\n" +
"		CRDESTABELECIMENTO.cd_estabelecimento AS CODIGOESTAB,\n" +
"		RTRIM(LTRIM(CRDESTABELECIMENTO.razao)) AS NOMEESTABCOMPLETO,\n" +
"		RTRIM(LTRIM(CRDESTABELECIMENTO.fantasia)) AS NOMEESTAB,\n" +
"        CASE\n" +
"			WHEN CRDESTABELECIMENTO.cd_estabelecimento = 1 THEN 'Matriz'\n" +
"			ELSE 'Filial' \n" +
"		END AS APELIDOESTAB,\n" +
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
"			ELSE 99\n" +
"		END AS CODIGOTIPOLOGRAD,\n" +
"		CASE \n" +
"			WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.endereco)) IS NULL THEN 'IMPORTAÇÃO/CONVERSÃO'\n" +
"			ELSE RTRIM(LTRIM(CRDESTABELECIMENTO.endereco)) \n" +
"		END AS ENDERECOESTAB,\n" +
"		CRDESTABELECIMENTO.numero AS NUMENDERESTAB,\n" +
"		RTRIM(LTRIM(CRDESTABELECIMENTO.complemento)) AS COMPLENDERESTAB,\n" +
"		RTRIM(LTRIM(CRDESTABELECIMENTO.bairro)) AS BAIRROENDERESTAB,\n" +
"		/*CASE\n" +
"			WHEN QST_MUNICIPIO.CODIGOMUNIC IS NULL THEN 1\n" +
"			ELSE QST_MUNICIPIO.CODIGOMUNIC \n" +
"		END*/ 33 AS CODIGOMUNIC,\n" +
"		CASE \n" +
"			WHEN CRDESTABELECIMENTO.cep IS NULL THEN '11.111-111' \n" +
"			ELSE CONCAT(LEFT(CRDESTABELECIMENTO.cep,2), '.',RIGHT(LEFT(CRDESTABELECIMENTO.cep,5),3), '-', RIGHT(CRDESTABELECIMENTO.cep,3)) \n" +
"        END AS CEPENDERESTAB, \n" +
"		CASE \n" +
"			WHEN CRDESTABELECIMENTO.uf IS NULL THEN 'PR'\n" +
"			ELSE CRDESTABELECIMENTO.uf \n" +
"		END AS SIGLAESTADO,\n" +
"		CRDESTABELECIMENTO.ddd_telefone AS DDDFONE,\n" +
"		CRDESTABELECIMENTO.telefone AS NUMEROFONE,\n" +
"		CRDESTABELECIMENTO.ddd_telefone2 AS DDDFAX,\n" +
"		CRDESTABELECIMENTO.telefone2 AS NUMEROFAX,\n" +
"		RTRIM(LTRIM(CRDESTABELECIMENTO.email)) AS EMAIL,\n" +
"		RTRIM(LTRIM(CRDESTABELECIMENTO.site)) AS PAGINAINTERNET,\n" +
"        CASE\n" +
"			WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.registro)) IS NULL THEN '0'\n" +
"            ELSE RTRIM(LTRIM(CRDESTABELECIMENTO.registro))\n" +
"        END AS NUMEROREGIST,\n" +
"		CASE\n" +
"			WHEN LEN(CRDESTABELECIMENTO.cnpj_cpf) = 14 THEN 1\n" +
"			WHEN LEN(CRDESTABELECIMENTO.cnpj_cpf) = 18 THEN 2\n" +
"			WHEN LEN(CRDESTABELECIMENTO.cnpj_cpf) = 16 THEN 3\n" +
"			ELSE 2\n" +
"		END AS TIPOINSCR,\n" +
"		CASE \n" +
"			WHEN CRDESTABELECIMENTO.cnpj_cpf IS NULL THEN '11.111.111/1111-11'\n" +
"			ELSE CRDESTABELECIMENTO.cnpj_cpf\n" +
"		END AS INSCRFEDERAL,\n" +
"		CRDESTABELECIMENTO.inscricao_est AS INSCRESTAD,                             \n" +
"		CRDESTABELECIMENTO.inscricao_mun AS INSCRMUNIC,\n" +
"		CASE \n" +
"			WHEN CONCAT(LEFT(CRDESTABELECIMENTO.cnae,4),'-',\n" +
"			  LEFT(RIGHT(CRDESTABELECIMENTO.cnae, 5),1),'/',\n" +
"			  RIGHT(CRDESTABELECIMENTO.cnae,2)) NOT IN (SELECT CODIGOATIVFEDERAL FROM QST_CNAE) THEN '9999-9/99'\n" +
"			WHEN CRDESTABELECIMENTO.cnae IS NULL THEN '9999-9/99'\n" +
"			ELSE\n" +
"			CONCAT(LEFT(CRDESTABELECIMENTO.cnae,4),'-',\n" +
"			  LEFT(RIGHT(CRDESTABELECIMENTO.cnae, 5),1),'/',\n" +
"			  RIGHT(CRDESTABELECIMENTO.cnae,2)) \n" +
"		END AS CODIGOATIVFEDERAL,\n" +
"		CRDESTABELECIMENTO.data_registro AS DATAREGIST,\n" +
"		RTRIM(LTRIM(CRDESTABELECIMENTO.atividades)) AS DESCRATIVFEDESTAB,\n" +
"		RTRIM(LTRIM(CRDESTABELECIMENTO.capital_social)) AS CAPITALSOCIAL\n" +
"FROM crdestabelecimento AS CRDESTABELECIMENTO\n" +
"LEFT JOIN QST_MUNICIPIO QST_MUNICIPIO \n" +
"ON CRDESTABELECIMENTO.CIDADE = QST_MUNICIPIO.NOMEMUNIC\n" +
"WHERE CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999) /*and CRDESTABELECIMENTO.razao like 'sul special service%'*/\n" +
"ORDER BY CODIGOEMPRESA;");
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA(rs.getInt("CODIGOEMPRESA"));
                setCODIGOESTAB(rs.getInt("CODIGOESTAB"));
                setNOMEESTAB(rs.getString("NOMEESTAB"));
                setNOMEESTABCOMPLETO(rs.getString("NOMEESTABCOMPLETO"));
                setAPELIDOESTAB(rs.getString("APELIDOESTAB"));
                setCODIGOTIPOLOGRAD(rs.getInt("CODIGOTIPOLOGRAD"));
                setENDERECOESTAB(rs.getString("ENDERECOESTAB"));
                setNUMENDERESTAB(rs.getInt("NUMENDERESTAB"));
                setCOMPLENDERESTAB(rs.getString("COMPLENDERESTAB"));
                setBAIRROENDERESTAB(rs.getString("BAIRROENDERESTAB"));
                setSIGLAESTADO(rs.getString("SIGLAESTADO"));
                setCODIGOMUNIC(rs.getInt("CODIGOMUNIC"));
                setCEPENDERESTAB(rs.getString("CEPENDERESTAB"));
                setDDDFONE(rs.getInt("DDDFONE"));
                setNUMEROFONE(rs.getInt("NUMEROFONE"));
                setDDDFAX(rs.getInt("DDDFAX"));
                setNUMEROFAX(rs.getInt("NUMEROFAX"));
                setEMAIL(rs.getString("EMAIL"));
                setPAGINAINTERNET(rs.getString("PAGINAINTERNET"));
                setTIPOINSCR(rs.getInt("TIPOINSCR"));
                setINSCRFEDERAL(rs.getString("INSCRFEDERAL"));
                setNUMEROREGIST(rs.getString("NUMEROREGIST"));
                //setDATAREGIST(rs.getString("DATAREGIST"));
                setCODIGOATIVFEDERAL(rs.getString("CODIGOATIVFEDERAL"));
                setINSCRESTAD(rs.getString("INSCRESTAD"));
                setINSCRMUNIC(rs.getString("INSCRMUNIC"));
                
                ps2 = con2.prepareStatement ("INSERT INTO ESTAB (\n" +
"		CODIGOEMPRESA,\n" +
"		CODIGOESTAB,\n" +
"		DATAINICIAL,\n" +
"		NOMEESTAB,\n" +
"		NOMEESTABCOMPLETO,\n" +
"		APELIDOESTAB,\n" +
"		CODIGOTIPOLOGRAD,\n" +
"		ENDERECOESTAB,\n" +
"		NUMENDERESTAB,\n" +
"		COMPLENDERESTAB,\n" +
"		BAIRROENDERESTAB,\n" +
"		SIGLAESTADO,\n" +
"		CODIGOMUNIC,\n" +
"		CEPENDERESTAB,\n" +
"		DDDFONE,\n" +
"		NUMEROFONE,\n" +
"		DDDFAX,\n" +
"		NUMEROFAX,\n" +
"		EMAIL,\n" +
"		PAGINAINTERNET,\n" +
"		DATAINICIOATIV,\n" +
"		DATAENCERATIV,\n" +
"		SOCIEDADECONTAPARTICIPACAO,\n" +
"		TIPOINSCR,\n" +
"		INSCRFEDERAL,\n" +
"		CODIGONATURJURID,\n" +
"		CODIGOATIVFEDERAL,\n" +
"		TIPOREGIST,\n" +
"               NUMEROREGIST, \n" +
"		DATAREGIST,\n" +
"		INSCRESTAD,\n" +
"		INSCRMUNIC,\n" +
"		PORTEEMPRESA,\n" +
"		CODIGOTABFERIADO,\n" +
"		VALORNOMINALCOTAS,\n" +
"		CAPITALSOCIAL\n" +
"		)\n" +
"               VALUES (?,\n" +
"               ?,\n" +
"               '1900-01-01',\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               ?,\n" +
"               '1900-01-01',\n" +
"               '2050-01-01',\n" +
"               0,\n" +
"               ?,\n" +
"               ?,\n" +
"               9999,\n" +
"               ?,\n" +
"               1,\n" +
"               ?,\n" +
"               '1900-01-01',\n" +
"               ?,\n" +
"               ?,\n" +
"               0,\n" +
"               1,\n" +
"               100,\n" +
"               100000);");
                    
                    ps2.setInt(1, getCODIGOEMPRESA());
                    ps2.setInt(2, getCODIGOESTAB());
                    ps2.setString(3, getNOMEESTAB());
                    ps2.setString(4, getNOMEESTABCOMPLETO());
                    ps2.setString(5, getAPELIDOESTAB());
                    ps2.setInt(6, getCODIGOTIPOLOGRAD());
                    ps2.setString(7, getENDERECOESTAB());
                    ps2.setInt(8, getNUMENDERESTAB());
                    ps2.setString(9, getCOMPLENDERESTAB());
                    ps2.setString(10, getBAIRROENDERESTAB());
                    ps2.setString(11, getSIGLAESTADO());
                    ps2.setInt(12, getCODIGOMUNIC());
                    ps2.setString(13, getCEPENDERESTAB());
                    ps2.setInt(14, getDDDFONE());
                    ps2.setInt(15, getNUMEROFONE());
                    ps2.setInt(16, getDDDFAX());
                    ps2.setInt(17, getNUMEROFAX());
                    ps2.setString(18, getEMAIL());
                    ps2.setString(19, getPAGINAINTERNET());
                    ps2.setInt(20, getTIPOINSCR());
                    ps2.setString(21, getINSCRFEDERAL());
                    ps2.setString(22, getCODIGOATIVFEDERAL());
                    ps2.setString(23, getNUMEROREGIST());
                    //ps2.setString(21, getDATAREGIST());
                    ps2.setString(24, getINSCRESTAD());
                    ps2.setString(25, getINSCRMUNIC());
                    ps2.executeUpdate();
                    
            }
            
            ps = null;
            ps = con.prepareStatement("SELECT cd_empresa AS CODIGOEMPRESA, razao AS NOMEEMPRESA \n" +
"               FROM crdempresa \n" +
"               WHERE cd_empresa \n" +
"               NOT IN (SELECT cd_empresa \n" +
"		FROM crdestabelecimento) \n" +
"               ORDER BY CODIGOEMPRESA");
            ResultSet rs2 = ps.executeQuery();
            
            System.out.println("\n\nAtenção! Empresas abaixo não contiam estabelecimentos cadastrados: \n");
            
            while(rs2.next()){
            System.out.println("Código: "+rs2.getInt("CODIGOEMPRESA")+" Empresa: "+rs2.getString("NOMEEMPRESA"));
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