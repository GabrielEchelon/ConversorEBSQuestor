package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncPessoaDAO extends FuncPessoa{
      
    public void funcPessoaQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT  FUNCIONARIO.cd_empresa AS CODIGOEMPRESA,\n" +
"		ROW_NUMBER() OVER(ORDER BY FUNCIONARIO.cd_empresa, FUNCIONARIO.cd_funcionario ASC) AS CODIGOFUNCPESSOA, \n" +
"		RTRIM(LTRIM(FUNCIONARIO.nome)) AS NOMEFUNC, \n" +
"		CASE\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'AER%' THEN 1\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'AL%' THEN 2\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'A%' THEN 3\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'AV%' THEN 4\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'CPO%' THEN 5\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'CH%' THEN 6\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'COL%' THEN 7\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'CON%' THEN 8\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'CJ%' THEN 9\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'DT%' THEN 10\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'ESP%' THEN 11\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'ETC%' THEN 12\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'EST%' THEN 13\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'FAV%' THEN 14\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'FAZ%' THEN 15\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'FRA%' THEN 16\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'JD%' THEN 17\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'LD%' THEN 18\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'LG%' THEN 19\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'LGA%' THEN 20\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'LRG%' THEN 21\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'LOT%' THEN 22\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'MRO%' THEN 23\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'NUC%' THEN 24\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'PRQ%' THEN 25\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'PSA%' THEN 26\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'PAT%' THEN 27\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'PC%' THEN 28\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'Q%' THEN 29\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'REC%' THEN 30\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'RES%' THEN 31\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'ROD%' THEN 32\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'R%' THEN 33\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'ST%' THEN 34\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'SIT%' THEN 35\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'TV%' THEN 36\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'TR%' THEN 37\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'TRV%' THEN 38\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'VLE%' THEN 39\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'VER%' THEN 40\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'V%' THEN 41\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'VD%' THEN 42\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'VLA%' THEN 43\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'VL%' THEN 44\n" +
"			WHEN FUNCIONARIO.endereco LIKE 'O%' THEN 99\n" +
"			ELSE 37\n" +
"		END AS CODIGOTIPOLOGRAD,\n" +
"		CASE \n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.endereco)) LIKE '' THEN 'Importação / Inválido'\n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.endereco)) IS NULL THEN 'Importação / Inválido'\n" +
"			ELSE RTRIM(LTRIM(FUNCIONARIO.endereco))\n" +
"		END AS ENDERFUNC,\n" +
"        CASE\n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.nr_endereco)) IS NULL THEN 0\n" +
"            ELSE RTRIM(LTRIM(FUNCIONARIO.nr_endereco))\n" +
"		END AS NUMEROENDER, \n" +
"		CASE\n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.compl_endereco)) = '' THEN NULL\n" +
"			ELSE RTRIM(LTRIM(FUNCIONARIO.compl_endereco)) \n" +
"		END AS COMPLENDER, \n" +
"        CASE\n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.bairro)) LIKE '' THEN 'Importação / Inválido'\n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.bairro)) IS NULL THEN 'Importação / Inválido'\n" +
"            ELSE RTRIM(LTRIM(FUNCIONARIO.bairro))\n" +
"		END AS BAIRROFUNC,\n" +
"        CASE\n" +
"			WHEN FUNCIONARIO.cidade IS NULL THEN '1'\n" +
"            ELSE \n" +
"				CASE \n" +
"					WHEN QST_MUNICIPIO.CODIGOMUNIC IS NULL THEN '1'\n" +
"                    ELSE QST_MUNICIPIO.CODIGOMUNIC\n" +
"				END\n" +
"        END AS CODIGOMUNIC,\n" +
"        CASE\n" +
"			WHEN UPPER(RTRIM(LTRIM(FUNCIONARIO.estado))) LIKE '' THEN 'PR'\n" +
"			WHEN UPPER(RTRIM(LTRIM(FUNCIONARIO.estado))) IS NULL THEN 'PR'\n" +
"            ELSE UPPER(RTRIM(LTRIM(FUNCIONARIO.estado)))\n" +
"		END AS SIGLAESTADO,\n" +
"                CASE \n" +
"			WHEN FUNCIONARIO.cep IS NULL THEN '11.111-111' \n" +
"			ELSE CONCAT(LEFT(FUNCIONARIO.cep,2), '.',RIGHT(LEFT(FUNCIONARIO.cep,5),3), '-', RIGHT(FUNCIONARIO.cep,3)) \n" +
"                END AS CEPFUNC, \n" +
"		CASE \n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.sexo)) = 'M' THEN 1\n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.sexo)) = 'F' THEN 2\n" +
"            ELSE 'M'\n" +
"		END AS SEXO,\n" +
"		RTRIM(LTRIM(FUNCIONARIO.estado_civil)) AS ESTADOCIVIL,\n" +
"		RTRIM(LTRIM(FUNCIONARIO.nacionalidade)) AS NACIONALIDADE,\n" +
"		FUNCIONARIO.grau_instrucao AS GRAUINSTR,\n" +
"		FUNCIONARIO.dt_nascimento AS DATANASC,\n" +
"		FUNCIONARIO.ddd_fone AS DDDFONE,\n" +
"		FUNCIONARIO.telefone AS NUMEROFONE,\n" +
"		CASE\n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.apelido)) = '' THEN NULL\n" +
"			ELSE RTRIM(LTRIM(FUNCIONARIO.apelido))\n" +
"		END AS APELIDOFUNC,\n" +
"		FUNCIONARIO.raca AS RACACOR,\n" +
"		FUNCIONARIO.deficiente AS DEFFISICA,\n" +
"		CASE\n" +
"			WHEN FUNCIONARIO.cidade_nascimento IS NULL THEN '1'\n" +
"            ELSE \n" +
"				CASE \n" +
"					WHEN (SELECT COUNT(NOMEMUNIC) AS CONTAGEM\n" +
"					FROM QST_MUNICIPIO_NASC\n" +
"					WHERE NOMEMUNIC LIKE FUNCIONARIO.cidade_nascimento) >1 THEN '1'\n" +
"					WHEN QST_MUNICIPIO_NASC.CODIGOMUNIC IS NULL THEN '1'\n" +
"                    ELSE QST_MUNICIPIO_NASC.CODIGOMUNIC\n" +
"				END\n" +
"        END AS CODIGOMUNICNASC,\n" +
"        CASE\n" +
"			WHEN UPPER(RTRIM(LTRIM(FUNCIONARIO.estado_nascimento))) LIKE '' THEN 'PR'\n" +
"			WHEN UPPER(RTRIM(LTRIM(FUNCIONARIO.estado_nascimento))) IS NULL THEN 'PR'\n" +
"            ELSE UPPER(RTRIM(LTRIM(FUNCIONARIO.estado_nascimento)))\n" +
"		END AS SIGLAESTADONASC,\n" +
"		FUNCIONARIO.ddd_celular AS DDDCELULAR,\n" +
"		FUNCIONARIO.celular AS NUMEROCELULAR,\n" +
"		CASE\n" +
"			WHEN RTRIM(LTRIM(FUNCIONARIO.email)) = '' THEN NULL\n" +
"			ELSE RTRIM(LTRIM(FUNCIONARIO.email))\n" +
"		END AS ENDERELETR,\n" +
"		CASE\n" +
"			WHEN FUNCIONARIO.data_chegada LIKE '% %' THEN NULL\n" +
"			ELSE FUNCIONARIO.data_chegada \n" +
"		END AS DATACHEGADA,\n" +
"		RTRIM(LTRIM(FUNDOCUMENTO.pis)) AS PISFUNC,\n" +
"        CASE\n" +
"			WHEN RTRIM(LTRIM(FUNDOCUMENTO.cpf)) LIKE '' THEN '999.999.999-99'\n" +
"			WHEN RTRIM(LTRIM(FUNDOCUMENTO.cpf)) IS NULL THEN '999.999.999-99'\n" +
"            ELSE RTRIM(LTRIM(FUNDOCUMENTO.cpf)) \n" +
"        END AS CPFFUNC,\n" +
"		RTRIM(LTRIM(FUNDOCUMENTO.nr_identidade)) AS NUMERORG,\n" +
"		CASE\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%DETRAN%' THEN 8\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%IFP%' THEN 9\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%SSP%' THEN 10\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%TRE%' THEN 20\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%EXT%' THEN 21\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%DRT%' THEN 30\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%M MILITAR%' THEN 40\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%MIN AER%' THEN 41\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%MIN EXER%' THEN 42\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%MIN MAR%' THEN 43\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%DPF%' THEN 44\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%INSS%' THEN 56\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%SRF%' THEN 57\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CLASSISTAS%' THEN 60\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRA%' THEN 61\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRAS%' THEN 62\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRB%' THEN 63\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRC%' THEN 64\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRECI%' THEN 65\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%COREN%' THEN 66\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CREA%' THEN 67\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CONRE%' THEN 68\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRF%' THEN 69\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CREFITO%' THEN 70\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRM%' THEN 71\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRMV%' THEN 72\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%OMB%' THEN 73\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRN%' THEN 74\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRO%' THEN 75\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CONRERP%' THEN 76\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRP%' THEN 77\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRQ%' THEN 78\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CORE%' THEN 79\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%OAB%' THEN 80\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%OE%' THEN 81\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%DOC ESTR%' THEN 82\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%CRE%' THEN 83\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%REG CIVIL%' THEN 91\n" +
"			WHEN FUNDOCUMENTO.orgao_identidade LIKE '%DETRAN%' THEN 92\n" +
"			ELSE 10\n" +
"		END AS CODIGOORGAOEMISSORRG,\n" +
"		CASE\n" +
"			WHEN UPPER(RTRIM(LTRIM(FUNDOCUMENTO.uf_identidade))) LIKE '' THEN 'PR'\n" +
"			WHEN UPPER(RTRIM(LTRIM(FUNDOCUMENTO.uf_identidade))) IS NULL THEN 'PR'\n" +
"            ELSE UPPER(RTRIM(LTRIM(FUNDOCUMENTO.uf_identidade)))\n" +
"		END AS SIGLAESTADORG,\n" +
"		RTRIM(LTRIM(FUNDOCUMENTO.nr_titulo)) AS TITELEIT,\n" +
"		RTRIM(LTRIM(FUNDOCUMENTO.zona_titulo)) AS ZONATITELEIT,\n" +
"		RTRIM(LTRIM(FUNDOCUMENTO.secao_titulo)) AS SECAOTITELEIT,\n" +
"		FUNDOCUMENTO.dt_emissao_identidade AS EMISSRG,\n" +
"		FUNDOCUMENTO.dt_emissao_pis AS DATACADPIS\n" +
"FROM funcionario AS FUNCIONARIO\n" +
"JOIN fundocumento AS FUNDOCUMENTO \n" +
"	ON FUNCIONARIO.cd_funcionario = FUNDOCUMENTO.cd_funcionario \n" +
"	AND FUNCIONARIO.cd_empresa = FUNDOCUMENTO.cd_empresa\n" +
"LEFT JOIN QST_MUNICIPIO QST_MUNICIPIO\n" +
"	ON FUNCIONARIO.cidade = QST_MUNICIPIO.NOMEMUNIC\n" +
"	AND FUNCIONARIO.estado LIKE QST_MUNICIPIO.SIGLAESTADO\n" +
"LEFT JOIN QST_MUNICIPIO_NASC QST_MUNICIPIO_NASC\n" +
"	ON FUNCIONARIO.cidade_nascimento = QST_MUNICIPIO_NASC.NOMEMUNIC \n" +
"	AND FUNCIONARIO.estado_nascimento LIKE QST_MUNICIPIO_NASC.SIGLAESTADO\n" +
"ORDER BY CODIGOEMPRESA, CODIGOFUNCPESSOA;");
            ResultSet rs = ps.executeQuery();
            
            ps2 = con2.prepareStatement("INSERT INTO ORGAOEMISSOR (codigoorgaoemissor, siglaorgaoemissor, descrorgaoemissor)\n" +
"VALUES (8, 'DETRAN', 'Departamento de Trânsito');");
            ps2.executeUpdate();
            ps2 = con2.prepareStatement("INSERT INTO ORGAOEMISSOR (codigoorgaoemissor, siglaorgaoemissor, descrorgaoemissor)\n" +
"VALUES (9, 'IFP', 'Instituto Félix Pacheco');");
            ps2.executeUpdate();
            
            while(rs.next()){
                
                System.out.print(".");
                
    setCODIGOFUNCPESSOA (rs.getInt("CODIGOFUNCPESSOA"));    setNOMEFUNC (rs.getString("NOMEFUNC"));
    setAPELIDOFUNC (rs.getString("APELIDOFUNC"));           setCODIGOTIPOLOGRAD (rs.getInt("CODIGOTIPOLOGRAD"));
    setENDERFUNC (rs.getString("ENDERFUNC"));               setCOMPLENDER (rs.getString("COMPLENDER"));
    setNUMEROENDER (rs.getInt("NUMEROENDER"));              setBAIRROFUNC (rs.getString("BAIRROFUNC"));
    setSIGLAESTADO (rs.getString("SIGLAESTADO"));           setCODIGOMUNIC (rs.getInt("CODIGOMUNIC"));
    setCEPFUNC (rs.getString("CEPFUNC"));                   setDDDFONE (rs.getInt("DDDFONE"));
    setNUMEROFONE (rs.getInt("NUMEROFONE"));                setDDDCELULAR (rs.getInt("DDDCELULAR"));
    setNUMEROCELULAR (rs.getInt("NUMEROCELULAR"));          setENDERELETR (rs.getString("ENDERELETR"));
    setDATANASC (rs.getDate("DATANASC"));                   setSIGLAESTADONASC (rs.getString("SIGLAESTADONASC"));
    setCODIGOMUNICNASC (rs.getInt("CODIGOMUNICNASC"));      setSEXO (rs.getInt("SEXO"));
    setRACACOR (rs.getInt("RACACOR"));                      setDEFFISICA (rs.getInt("DEFFISICA"));
    setESTADOCIVIL (rs.getInt("ESTADOCIVIL"));              setPISFUNC (rs.getString("PISFUNC"));
    setDATACADPIS (rs.getDate("DATACADPIS"));               setCODIGOORGAOEMISSORRG (rs.getInt("CODIGOORGAOEMISSORRG"));
    setCPFFUNC (rs.getString("CPFFUNC"));                   setNUMERORG (rs.getString("NUMERORG"));
    setSIGLAESTADORG (rs.getString("SIGLAESTADORG"));       setEMISSRG (rs.getDate("EMISSRG"));
    setTITELEIT (rs.getString("TITELEIT"));                 setZONATITELEIT (rs.getInt("ZONATITELEIT"));
    setSECAOTITELEIT (rs.getInt("SECAOTITELEIT"));          setNACIONALIDADE (rs.getInt("NACIONALIDADE"));
    setGRAUINSTR (rs.getInt("GRAUINSTR"));                  setDATACHEGADA (rs.getDate("DATACHEGADA"));

                    ps2 = con2.prepareStatement ("INSERT INTO FUNCPESSOA (CODIGOFUNCPESSOA,NOMEFUNC,APELIDOFUNC,\n" +
"CODIGOTIPOLOGRAD,ENDERFUNC,COMPLENDER,NUMEROENDER,BAIRROFUNC,SIGLAESTADO,CODIGOMUNIC,CEPFUNC,DDDFONE,\n" +
"NUMEROFONE,DDDCELULAR,NUMEROCELULAR,ENDERELETR,DATANASC,SIGLAESTADONASC,CODIGOMUNICNASC,\n" +
"SEXO,RACACOR,DEFFISICA,DEFVISUAL,BRPDHPPP,DEFMENTAL,DEFAUDITIVA,DEFCOTA,DEFREABILITADO,\n" +
"DEFINTELECTUAL,ESTADOCIVIL,GRAUINSTR,NACIONALIDADE,DATACHEGADA,PISFUNC,\n" +
"DATACADPIS,CODIGOORGAOEMISSORRG,CPFFUNC,NUMERORG,SIGLAESTADORG,EMISSRG,TITELEIT,ZONATITELEIT,SECAOTITELEIT)\n" +
"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,3,0,0,0,0,0,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                    
        ps2.setInt(1, this.getCODIGOFUNCPESSOA());
	ps2.setString(2, this.getNOMEFUNC());
	ps2.setString(3, this.getAPELIDOFUNC());
	ps2.setInt(4, this.getCODIGOTIPOLOGRAD());
	ps2.setString(5, this.getENDERFUNC());
	ps2.setString(6, this.getCOMPLENDER());
	ps2.setInt(7, this.getNUMEROENDER());
	ps2.setString(8, this.getBAIRROFUNC());
	ps2.setString(9, this.getSIGLAESTADO());
        ps2.setInt(10, this.getCODIGOMUNIC());
	ps2.setString(11, this.getCEPFUNC());
	ps2.setInt(12, this.getDDDFONE());
	ps2.setInt(13, this.getNUMEROFONE());
	ps2.setInt(14, this.getDDDCELULAR());
	ps2.setInt(15, this.getNUMEROCELULAR());
	ps2.setString(16, this.getENDERELETR());
	ps2.setDate(17, this.getDATANASC());
	ps2.setString(18, this.getSIGLAESTADONASC());
	ps2.setInt(19, this.getCODIGOMUNICNASC());
	ps2.setInt(20, this.getSEXO());
	ps2.setInt(21, this.getRACACOR());
	ps2.setInt(22, this.getDEFFISICA());
	ps2.setInt(23, this.getESTADOCIVIL());
	ps2.setInt(24, this.getGRAUINSTR());
	ps2.setInt(25, this.getNACIONALIDADE());
	ps2.setDate(26, this.getDATACHEGADA());
	ps2.setString(27, this.getPISFUNC());
	ps2.setDate(28, this.getDATACADPIS());
	ps2.setInt(29, this.getCODIGOORGAOEMISSORRG());
	ps2.setString(30, this.getCPFFUNC());
	ps2.setString(31, this.getNUMERORG());
	ps2.setString(32, this.getSIGLAESTADORG());
	ps2.setDate(33, this.getEMISSRG());
	ps2.setString(34, this.getTITELEIT());
	ps2.setInt(35, this.getZONATITELEIT());
	ps2.setInt(36, this.getSECAOTITELEIT());
                    
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