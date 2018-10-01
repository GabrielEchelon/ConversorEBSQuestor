package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.TerceiroPgto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TerceiroPgtoDAO extends TerceiroPgto{
      
    public void terceiroPgtoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	DISTINCT EBS.cd_empresa AS CODIGOEMPRESA,\n" +
"		EBS.cd_autonomo AS CODIGOTERC,\n" +
"		EBS.dt_emissao AS COMPET,\n" +
"		EBS.vl_servico AS VALORBRUTO,\n" +
"		EBS.vl_base_inss AS VALORISS,\n" +
"		EBS.vl_base_irrf AS BASEIRRF,\n" +
"		EBS.vl_inss_retido AS DEDUCAOINSS,\n" +
"		EBS.dt_pagamento AS DATAPGTO\n" +
"FROM PagamentoAutonomo EBS\n" +
"JOIN ESTRUTURA EST\n" +
"ON EBS.CD_EMPRESA = EST.CD_EMPRESA\n" +
"ORDER BY codigoempresa");
            ResultSet rs = ps.executeQuery();
            
            int SEQ = 1;
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOTERC (rs.getInt("CODIGOTERC"));
                setCOMPET (rs.getDate("COMPET"));
                setVALORBRUTO (rs.getDouble("VALORBRUTO"));
                setVALORISS (rs.getDouble("VALORISS"));
                setBASEIRRF (rs.getDouble("BASEIRRF"));
                setDEDUCAOINSS (rs.getDouble("DEDUCAOINSS"));
                setDATAPGTO (rs.getDate("DATAPGTO"));

                if((getCODIGOEMPRESA() == getAUXILIAR())
                    &&(getCODIGOTERC() == getAUXILIAR2())
                    &&(getAUXILIAR3().compareTo(getCOMPET()) == 0)){
                    SEQ++;
                } else {
                    SEQ = 1;
                }
                
                ps2 = con2.prepareStatement ("INSERT INTO TERCEIROPGTO (CODIGOEMPRESA, CODIGOTERC, COMPET,\n" +
"SEQ, CODIGOESTAB, CLASSIFORGAN, VALORBRUTO, ORIGEMDADO, VALORISS,\n" +
"BASEGPS, ACRESSAT, BASEIRRF, RENDIMENTOISENTO, DEDUCAOINSS,\n" +
"CONTRIBTERC, DATAPGTO, CODIGOIMPOSTOIRRF, VARIACAOIMPOSTOIRRF,\n" +
"NUMERODEPENDIR)\n" +
"VALUES (?,?,?,?,1,'001',?,3,?,1,0,?,0,?,0,?,588,61,0);");
                    
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setInt(2, this.getCODIGOTERC());
                ps2.setDate(3, this.getCOMPET());
                ps2.setInt(4, SEQ);
                ps2.setDouble(5, this.getVALORBRUTO());
                ps2.setDouble(6, this.getVALORISS());
                ps2.setDouble(7, this.getBASEIRRF());
                ps2.setDouble(8, this.getDEDUCAOINSS());
                ps2.setDate(9, this.getDATAPGTO());
                ps2.executeUpdate();
                
                setAUXILIAR (rs.getInt("CODIGOEMPRESA"));
                setAUXILIAR2 (rs.getInt("CODIGOTERC"));
                setAUXILIAR3 (rs.getDate("COMPET"));
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