package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.ReciboFerias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Calendar;

public class ReciboFeriasDAO extends ReciboFerias{
      
    public void reciboFeriasQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	CURRENT_TIMESTAMP AS AUXILIAR,\n" +
"		FERIAS.cd_empresa AS CODIGOEMPRESA,\n" +
"		FERIAS.cd_funcionario AS CODIGOFUNCCONTR,\n" +
"		FERIAS.dt_inicio_aquisicao AS DATAINICIAL,\n" +
"		FERIAS.dt_inicio_gozo AS DATAINICIALFERIAS,\n" +
"		FERIAS.dt_fim_gozo AS DATAFINALFERIAS,\n" +
"		FERIAS.dt_inicio_abono AS DATAABONO,\n" +
"		FERIAS.dt_pagamento AS DATAPGTO,\n" +
"		CASE\n" +
"			WHEN FERIAS.tipo_ferias like '%c%' THEN 2\n" +
"			ELSE 1\n" +
"		END AS TIPORECIBO,\n" +
"		CASE\n" +
"			WHEN FERIAS.dt_inicio_abono IS NULL THEN 0\n" +
"			WHEN DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1) > 90 THEN 30\n" +
"			ELSE DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1) \n" +
"		END AS DIASABONO,\n" +
"		CASE \n" +
"			WHEN ((FERIAS.dias_ferias - FERIAS.saldo_ferias) - (CASE\n" +
"				WHEN DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1) IS NULL THEN 0\n" +
"				ELSE DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1)\n" +
"				END)) < 0\n" +
"			THEN 0\n" +
"			ELSE ((FERIAS.dias_ferias - FERIAS.saldo_ferias) - (CASE\n" +
"				WHEN DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1) IS NULL THEN 0\n" +
"				ELSE DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1)\n" +
"				END))\n" +
"		END AS DIASFERIAS,\n" +
"		CURRENT_TIMESTAMP AS DATAHORALCTO\n" +
"FROM ferias FERIAS \n" +
"WHERE FERIAS.dt_inicio_aquisicao IS NOT NULL \n" +
"AND FERIAS.dt_fim_aquisicao IS NOT NULL\n" +
"AND FERIAS.dt_inicio_gozo IS NOT NULL\n" +
"ORDER BY CODIGOEMPRESA, CODIGOFUNCCONTR, DATAINICIAL;");
            ResultSet rs = ps.executeQuery();
            
            int count = 0;
            int count2 = 0;
            
            Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            java.sql.Date date = new java.sql.Date(currentDate.getTime());
            
            setAUXILIAR(date);
            
            while(rs.next()){
                
                count++;
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR (rs.getInt("CODIGOFUNCCONTR"));
                setDATAINICIAL (rs.getDate("DATAINICIAL"));
                setDATAINICIALFERIAS (rs.getDate ("DATAINICIALFERIAS"));
                setDATAFINALFERIAS (rs.getDate ("DATAFINALFERIAS"));
                setDATAABONO (rs.getDate ("DATAABONO"));
                setDATAPGTO (rs.getDate ("DATAPGTO"));
                setTIPORECIBO (rs.getInt ("TIPORECIBO"));
                setDIASABONO (rs.getInt ("DIASABONO"));
                setDIASFERIAS (rs.getInt ("DIASFERIAS"));
                setDATAHORALCTO (rs.getDate ("DATAHORALCTO"));

                if((getAUXILIAR().compareTo(getDATAINICIAL()) == 0)&&(getAUXILIAR2() == getCODIGOFUNCCONTR())&&(getAUXILIAR3() == getCODIGOEMPRESA())){
                    
                    ps2 = con2.prepareStatement("DELETE FROM RECIBOFERIAS WHERE CODIGOFUNCCONTR = ? AND DATAINICIAL = ? AND CODIGOEMPRESA = ?");

                    ps2.setInt(1, this.getCODIGOFUNCCONTR());
                    ps2.setDate(2, this.getDATAINICIAL());
                    ps2.setInt(3, this.getCODIGOEMPRESA());

                    ps2.executeUpdate();

                    count2++;
                }
                
                ps2 = con2.prepareStatement ("INSERT INTO RECIBOFERIAS (CODIGOEMPRESA, CODIGOFUNCCONTR, DATAINICIAL,\n" +
"DATAINICIALFERIAS, DATAFINALFERIAS, DATAABONO, PAGAADTO13, DATAPGTO,\n" +
"DESCADTO, FORMAGERACAO, DIASDOBROFERIAS, DIASDOBROABONO, TIPORECIBO, DIASABONO, DIASFERIAS,\n" +
"DIASREMUN, DESCONTPARCELA, NUMEROPARCELA, DIASPREMIO, CODIGOUSUARIO,\n" +
"DATAHORALCTO, ORIGEMDADO)\n" +
"VALUES (?,?,?,?,?,?,0,?,0,0,0,0,?,?,?,0,0,0,0,0,?,3);");
                
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setInt(2, this.getCODIGOFUNCCONTR());
                ps2.setDate(3, this.getDATAINICIAL());
                ps2.setDate(4, this.getDATAINICIALFERIAS());
                ps2.setDate(5, this.getDATAFINALFERIAS());
                ps2.setDate(6, this.getDATAABONO());
                ps2.setDate(7, this.getDATAPGTO());
                ps2.setInt(8, this.getTIPORECIBO());
                ps2.setInt(9, this.getDIASABONO());
                ps2.setInt(10, this.getDIASFERIAS());
                ps2.setDate(11, this.getDATAHORALCTO());
                
                ps2.executeUpdate();
                
                setAUXILIAR (rs.getDate("DATAINICIAL"));
                setAUXILIAR2 (rs.getInt("CODIGOFUNCCONTR"));
            }
            System.out.println("\n\nTabela finalizada. (" + getTABELA() + ") Inseridos: " + (count-count2) + " Não Inseridos: " + count2);
            
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