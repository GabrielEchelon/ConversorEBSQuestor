package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncContrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncContratoDAO extends FuncContrato{
      
    public void funcContratoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT  FUNFUNCIONAL.cd_empresa AS CODIGOEMPRESA,\n" +
"		FUNFUNCIONAL.cd_funcionario AS CODIGOFUNCCONTR,\n" +
"		ROW_NUMBER() OVER(ORDER BY FUNFUNCIONAL.cd_empresa, FUNFUNCIONAL.cd_funcionario) AS CODIGOFUNCPESSOA,\n" +
"		FUNFUNCIONAL.tipo_admissao AS CODIGOTIPOCONTR,\n" +
"		FUNFUNCIONAL.dt_admissao AS DATAADM,\n" +
"		FUNFUNCIONAL.dt_admissao AS DATAOPCAOFGTS,\n" +
"		FUNFUNCIONAL.nr_conta_deposito AS CONTAFGTS,\n" +
"		FUNFUNCIONAL.vinculo_empregaticio_rais AS TIPOVINCULO,\n" +
"		CASE\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 1 THEN '01'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 3 THEN '03'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 4 THEN '04'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 5 THEN '05'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 6 THEN '06'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 7 THEN '07'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 11 THEN '11'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 12 THEN '12'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 13 THEN '13'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 17 THEN '17'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 18 THEN '18'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 19 THEN '19'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 20 THEN '20'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 21 THEN '21'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 24 THEN '24'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 25 THEN '25'\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.categoria)) = 26 THEN '26'\n" +
"			ELSE '01'\n" +
"		END AS CATEGORIA,\n" +
"		CASE\n" +
"			WHEN FUNFUNCIONAL.adto_13_ferias LIKE 'N' THEN 3\n" +
"			WHEN FUNFUNCIONAL.adto_13_ferias LIKE 'S' THEN 1\n" +
"			ELSE 2\n" +
"		END AS RECEBEADTO,\n" +
"		CASE\n" +
"			WHEN FUNFUNCIONAL.adto_13_ferias LIKE 'N' THEN 0\n" +
"			WHEN FUNFUNCIONAL.adto_13_ferias LIKE 'S' THEN 40\n" +
"			ELSE 40\n" +
"		END AS PERCADTO,\n" +
"		CASE\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.cd_banco_deposito)) IS NULL THEN 1\n" +
"			WHEN RTRIM(LTRIM(FUNFUNCIONAL.cd_banco_deposito)) LIKE ' ' THEN 1\n" +
"			ELSE 3\n" +
"		END AS MODOPGTO,\n" +
"		CASE\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) IS NULL THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) LIKE '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) LIKE '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) IS NULL THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) LIKE '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%X%' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%X%' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) LIKE '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%p%' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%p%' THEN NULL\n" +
"\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NOT NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) IS NULL THEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito))\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) <> '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '' THEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito))\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) <> '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) IS NULL THEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito))\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NOT NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '' THEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito))\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) <> '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%X%' THEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito))\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NOT NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%X%' THEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito))\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) <> '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%p%' THEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito))\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NOT NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%p%' THEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito))\n" +
"\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) IS NOT NULL THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) LIKE '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) <> '' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) LIKE '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) IS NOT NULL THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) <> '' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) LIKE '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%X%' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) <> '%X%' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) LIKE '' AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) LIKE '%p%' THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)) IS NULL AND LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito)) <> '%p%' THEN NULL\n" +
"\n" +
"			ELSE CONCAT(LTRIM(RTRIM(FUNFUNCIONAL.nr_agencia_deposito)),LTRIM(RTRIM(FUNFUNCIONAL.dv_agencia_deposito))) \n" +
"		END AS NUMEROAGENCIA, \n" +
"		FUNFUNCIONAL.nr_conta_deposito AS NUMEROCONTA, \n" +
"		CASE \n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.dv_conta_deposito)) IS NULL THEN NULL\n" +
"			WHEN LTRIM(RTRIM(FUNFUNCIONAL.dv_conta_deposito)) LIKE '' THEN NULL\n" +
"			ELSE LTRIM(RTRIM(FUNFUNCIONAL.dv_conta_deposito))\n" +
"		END AS DIGITOCONTA,\n" +
"		CASE\n" +
"			WHEN FUNFUNCIONAL.dias_experiencia IS NULL THEN 0\n" +
"			ELSE FUNFUNCIONAL.dias_experiencia \n" +
"		END AS DIACONTREXP,\n" +
"		CURRENT_TIMESTAMP AS DATAHORALCTO,\n" +
"		CASE\n" +
"			WHEN codigo_admissao_caged = 10 THEN 1\n" +
"			ELSE 0\n" +
"		END AS INDICATPRIMEMP\n" +
"FROM funfuncional FUNFUNCIONAL\n" +
"LEFT JOIN (SELECT  FUNCIONARIO.cd_funcionario AS CODIGOFUNCPESSOA, \n" +
"		RTRIM(LTRIM(FUNCIONARIO.nome)) AS NOMEFUNC, \n" +
"		FUNCIONARIO.cd_empresa AS CODIGOEMPRESA\n" +
"FROM funcionario AS FUNCIONARIO) as FC \n" +
"on FUNFUNCIONAL.cd_funcionario = FC.CODIGOFUNCPESSOA and FUNFUNCIONAL.cd_empresa = FC.CODIGOEMPRESA\n" +
"ORDER BY numeroagencia, numeroconta, digitoconta;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR (rs.getInt("CODIGOFUNCCONTR"));
                setCODIGOFUNCPESSOA (rs.getInt("CODIGOFUNCPESSOA"));
                setCODIGOTIPOCONTR (rs.getInt("CODIGOTIPOCONTR"));
                setDATAADM (rs.getDate("DATAADM"));
                setDATAOPCAOFGTS (rs.getDate("DATAOPCAOFGTS"));
                setCONTAFGTS (rs.getInt("CONTAFGTS"));
                setTIPOVINCULO (rs.getString("TIPOVINCULO"));
                setCATEGORIA (rs.getString("CATEGORIA"));
                setRECEBEADTO (rs.getInt("RECEBEADTO"));
                setPERCADTO (rs.getInt("PERCADTO"));
                setMODOPGTO (rs.getInt("MODOPGTO"));
                setNUMEROAGENCIA (rs.getInt("NUMEROAGENCIA"));
                setNUMEROCONTA (rs.getInt("NUMEROCONTA"));
                setDIGITOCONTA (rs.getString("DIGITOCONTA"));
                setDIACONTREXP (rs.getInt("DIACONTREXP"));
                setDATAHORALCTO (rs.getDate("DATAHORALCTO"));
                setINDICATPRIMEMP (rs.getInt("INDICATPRIMEMP"));

                ps2 = con2.prepareStatement ("INSERT INTO FUNCCONTRATO (CODIGOEMPRESA,CODIGOFUNCCONTR,CODIGOFUNCPESSOA,\n" +
"CODIGOTIPOCONTR,DATAADM,OPTANTEFGTS,DATAOPCAOFGTS,CONTAFGTS,CODIGOSIT,\n" +
"TIPOVINCULO,CATEGORIA,RECEBE13SAL,RECEBEADTO,PERCADTO,PERPGTO,MODOPGTO,\n" +
"TIPOCONTA,NUMEROAGENCIA,NUMEROCONTA,DIGITOCONTA,PREVTERMAFASTVT,EMITECARTAO,\n" +
"PARTICPAT,POSSUIALVARA,FORMACALCULO,DIACONTREXP,CODIGOUSUARIO,DATAHORALCTO,\n" +
"ORIGEMDADO,INDICATPRIMEMP,REGIMETRAB, MATRICULAESOCIAL)\n" +
"VALUES (?,?,?,?,?,1,?,?,1,?,?,1,?,?,1,?,1,?,?,?,0,0,0,0,1,?,0,?,3,?,1,?);");
                    
        ps2.setInt(1, this.getCODIGOEMPRESA());
        ps2.setInt(2, this.getCODIGOFUNCCONTR());
        ps2.setInt(3, this.getCODIGOFUNCPESSOA());
        ps2.setInt(4, this.getCODIGOTIPOCONTR());
        ps2.setDate(5, this.getDATAADM());
        ps2.setDate(6, this.getDATAOPCAOFGTS());
        ps2.setInt(7, this.getCONTAFGTS());
        ps2.setString(8, this.getTIPOVINCULO());
        ps2.setString(9, this.getCATEGORIA());
        ps2.setInt(10, this.getRECEBEADTO());
        ps2.setInt(11, this.getPERCADTO());
        ps2.setInt(12, this.getMODOPGTO());
        ps2.setInt(13, this.getNUMEROAGENCIA());
        ps2.setInt(14, this.getNUMEROCONTA());
        ps2.setString(15, this.getDIGITOCONTA());
        ps2.setInt(16, this.getDIACONTREXP());
        ps2.setDate(17, this.getDATAHORALCTO());
        ps2.setInt(18, this.getINDICATPRIMEMP());
        ps2.setInt(19, this.getCODIGOFUNCCONTR());
                    
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