package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncPerCalculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncPerCalculoDAO extends FuncPerCalculo{
      
    public void funcPerCalculoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	SEL.CODIGOEMPRESA, \n" +
"		QST.CODIGOPERCALCULO, \n" +
"		SEL.CODIGOFUNCCONTR, \n" +
"		SCG.DATAADM AS DATACARGO,\n" +
"		SCE.DATAINICIAL AS DATAESCALA, \n" +
"		SCG.DATAADM AS DATALOCAL, \n" +
"		SCS.DATAINICIAL AS DATASALARIO, \n" +
"		SEL.dt_pagamento AS DATAPGTOFOLHA, \n" +
"		ROW_NUMBER() OVER(PARTITION BY SEL.CODIGOEMPRESA, QST.CODIGOPERCALCULO, SEL.CODIGOFUNCCONTR ORDER BY SEL.CODIGOEMPRESA, QST.CODIGOPERCALCULO, SEL.CODIGOFUNCCONTR) AS SEQCALCULO, \n" +
"		1 AS EMITEENVEL, \n" +
"		0 AS CODIGOUSUARIO,\n" +
"		CURRENT_TIMESTAMP AS DATAHORALCTO, \n" +
"		3 AS ORIGEMDADO \n" +
"FROM SEL_FUNCPERCALCULO SEL\n" +
"JOIN QST_PERIODOCALCULO QST\n" +
"ON SEL.PERIODOCALC = QST.COMPET \n" +
"AND SEL.CODIGOEMPRESA = QST.CODIGOEMPRESA\n" +
"JOIN (SELECT  FUNFUNCIONAL.cd_empresa AS CODIGOEMPRESA,\n" +
"		FUNFUNCIONAL.cd_funcionario AS CODIGOFUNCCONTR,\n" +
"		ROW_NUMBER() OVER(ORDER BY FUNFUNCIONAL.cd_empresa, FUNFUNCIONAL.cd_funcionario) AS CODIGOFUNCPESSOA,\n" +
"		FUNFUNCIONAL.dt_admissao AS DATAADM\n" +
"FROM funfuncional FUNFUNCIONAL\n" +
"LEFT JOIN (SELECT  FUNCIONARIO.cd_funcionario AS CODIGOFUNCPESSOA, \n" +
"		RTRIM(LTRIM(FUNCIONARIO.nome)) AS NOMEFUNC, \n" +
"		FUNCIONARIO.cd_empresa AS CODIGOEMPRESA\n" +
"FROM funcionario AS FUNCIONARIO) as FC \n" +
"on FUNFUNCIONAL.cd_funcionario = FC.CODIGOFUNCPESSOA and FUNFUNCIONAL.cd_empresa = FC.CODIGOEMPRESA) AS SCG\n" +
"ON SEL.CODIGOEMPRESA = SCG.CODIGOEMPRESA\n" +
"AND SEL.CODIGOFUNCCONTR = SCG.CODIGOFUNCCONTR\n" +
"JOIN (SELECT	\n" +
"		ROW_NUMBER() OVER(partition by FUNSALARIO.cd_empresa,FUNQUERY.CODIGOFUNCCONTR ORDER BY FUNSALARIO.cd_empresa,FUNQUERY.CODIGOFUNCCONTR) AS LINHA,\n" +
"		FUNSALARIO.cd_empresa CODIGOEMPRESA,\n" +
"		FUNQUERY.CODIGOFUNCCONTR,\n" +
"		FUNSALARIO.dt_salario AS DATAINICIAL\n" +
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
"WHERE CODIGOFUNCCONTR IS NOT NULL) AS SCS\n" +
"ON SEL.CODIGOEMPRESA = SCS.CODIGOEMPRESA\n" +
"AND SEL.CODIGOFUNCCONTR = SCS.CODIGOFUNCCONTR\n" +
"JOIN (SELECT ROW_NUMBER() OVER(PARTITION BY cd_empresa, cd_funcionario ORDER BY cd_empresa, cd_funcionario) AS LINHA,\n" +
"		cd_empresa AS CODIGOEMPRESA,\n" +
"		cd_funcionario AS CODIGOFUNCCONTR,\n" +
"		dt_horario AS DATAINICIAL,\n" +
"		CASE WHEN ((cd_tabela)+9) IS NULL THEN 9999\n" +
"		ELSE ((cd_tabela)+9) END AS CODIGOESCALA\n" +
"FROM funhorario) AS SCE\n" +
"ON SEL.CODIGOEMPRESA = SCE.CODIGOEMPRESA\n" +
"AND SEL.CODIGOFUNCCONTR = SCE.CODIGOFUNCCONTR\n" +
"WHERE SCS.LINHA = 1 AND SCE.LINHA = 1");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOPERCALCULO (rs.getInt("CODIGOPERCALCULO"));
                setCODIGOFUNCCONTR (rs.getInt("CODIGOFUNCCONTR"));
                setDATACARGO (rs.getDate("DATACARGO"));
                setDATAESCALA (rs.getDate("DATAESCALA"));
                setDATALOCAL (rs.getDate("DATALOCAL"));
                setDATASALARIO (rs.getDate("DATASALARIO"));
                setDATAPGTOFOLHA (rs.getDate("DATAPGTOFOLHA"));
                setSEQCALCULO (rs.getInt("SEQCALCULO"));
                setDATAHORALCTO (rs.getDate("DATAHORALCTO"));

                ps2 = con2.prepareStatement ("INSERT INTO FUNCPERCALCULO (CODIGOEMPRESA, CODIGOPERCALCULO, \n" +
"CODIGOFUNCCONTR, DATACARGO, DATAESCALA, DATALOCAL, DATASALARIO, \n" +
"DATAPGTOFOLHA, SEQCALCULO, EMITEENVEL, CODIGOUSUARIO, DATAHORALCTO, ORIGEMDADO)\n" +
"VALUES (?,?,?,?,?,?,?,?,?,1,0,?,3);");
                    
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setInt(2, this.getCODIGOPERCALCULO());
                ps2.setInt(3, this.getCODIGOFUNCCONTR());
                ps2.setDate(4, this.getDATACARGO());
                ps2.setDate(5, this.getDATAESCALA());
                ps2.setDate(6, this.getDATALOCAL());
                ps2.setDate(7, this.getDATASALARIO());
                ps2.setDate(8, this.getDATAPGTOFOLHA());
                ps2.setInt(9, this.getSEQCALCULO());
                ps2.setDate(10, this.getDATAHORALCTO());
  
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