package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.PeriodoAquis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Calendar;

public class PeriodoAquisDAO extends PeriodoAquis{
      
    public void periodoAquisQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	CURRENT_TIMESTAMP AS AUXILIAR,\n" +
"		FERIAS.cd_empresa AS CODIGOEMPRESA,\n" +
"		FERIAS.cd_funcionario AS CODIGOFUNCCONTR,\n" +
"		FERIAS.dt_inicio_aquisicao AS DATAINICIAL,\n" +
"		FERIAS.dt_fim_aquisicao AS DATAFINAL,\n" +
"		CASE\n" +
"			WHEN ((FERIAS.dias_ferias - FERIAS.saldo_ferias) + (CASE\n" +
"			WHEN DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1) IS NULL THEN 0\n" +
"			ELSE DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1)	END)) < 30 THEN 1\n" +
"			WHEN ((FERIAS.dias_ferias - FERIAS.saldo_ferias) + (CASE\n" +
"			WHEN DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1) IS NULL THEN 0\n" +
"			ELSE DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1)	END)) >= 30 THEN 2\n" +
"		END AS SITPERIODO,\n" +
"		((FERIAS.dias_ferias - FERIAS.saldo_ferias) - (CASE\n" +
"			WHEN DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1) IS NULL THEN 0\n" +
"			ELSE DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1)\n" +
"		END)) AS DIASJAPAGOS,\n" +
"		CASE\n" +
"			WHEN DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1) IS NULL THEN 0\n" +
"			ELSE DATEDIFF(DAY, FERIAS.dt_inicio_abono, FERIAS.dt_fim_abono + 1)\n" +
"		END AS DIASABONO,\n" +
"		CASE \n" +
"			WHEN CAST(FERIAS.nr_faltas AS INT) IS NULL THEN 0\n" +
"			ELSE CAST(FERIAS.nr_faltas AS INT)\n" +
"		END AS DIASFALTAS,\n" +
"		(FERIAS.dt_fim_aquisicao + 336) AS DATALIMPGTO,\n" +
"		CURRENT_TIMESTAMP AS DATAHORALCTO\n" +
"FROM ferias FERIAS \n" +
"WHERE FERIAS.dt_inicio_aquisicao IS NOT NULL \n" +
"AND FERIAS.dt_fim_aquisicao IS NOT NULL\n" +
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
                setDATAFINAL (rs.getDate("DATAFINAL"));
                setSITPERIODO (rs.getInt("SITPERIODO"));
                setDIASJAPAGOS (rs.getInt("DIASJAPAGOS"));
                setDIASABONO (rs.getInt("DIASABONO"));
                setDIASFALTAS (rs.getInt("DIASFALTAS"));
                setDATALIMPGTO (rs.getDate("DATALIMPGTO"));
                setDATAHORALCTO (rs.getDate("DATAHORALCTO"));

                if((getAUXILIAR().compareTo(getDATAINICIAL()) == 0)&&(getAUXILIAR2() == getCODIGOFUNCCONTR())&&(getAUXILIAR3() == getCODIGOEMPRESA())){
                    
                    ps2 = con2.prepareStatement("DELETE FROM PERIODOAQUIS WHERE CODIGOFUNCCONTR = ? AND DATAINICIAL = ? AND CODIGOEMPRESA = ?");

                    ps2.setInt(1, this.getCODIGOFUNCCONTR());
                    ps2.setDate(2, this.getDATAINICIAL());
                    ps2.setInt(3, this.getCODIGOEMPRESA());

                    ps2.executeUpdate();

                    count2++;
                }
                
                ps2 = con2.prepareStatement ("INSERT INTO PERIODOAQUIS (CODIGOEMPRESA, CODIGOFUNCCONTR, DATAINICIAL,\n" +
"               DATAFINAL, SITPERIODO, DIASJAPAGOS, DIASABONO, DIASFALTAS, DIASAFAST,\n" +
"               DIASLICREM, DIASLICMATERN,DIASSERVMILIT, DATALIMPGTO, CODIGOUSUARIO, DATAHORALCTO, ORIGEMDADO)\n" +
"               VALUES (?,?,?,?,?,?,?,?,0,0,0,0,?,0,?,3);");
                
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setInt(2, this.getCODIGOFUNCCONTR());
                ps2.setDate(3, this.getDATAINICIAL());
                ps2.setDate(4, this.getDATAFINAL());
                ps2.setInt(5, this.getSITPERIODO());
                ps2.setInt(6, this.getDIASJAPAGOS());
                ps2.setInt(7, this.getDIASABONO());
                ps2.setInt(8, this.getDIASFALTAS());
                ps2.setDate(9, this.getDATALIMPGTO());
                ps2.setDate(10, this.getDATAHORALCTO());
                ps2.executeUpdate();
                
                setAUXILIAR (rs.getDate("DATAINICIAL"));
                setAUXILIAR2 (rs.getInt("CODIGOFUNCCONTR"));
                setAUXILIAR3 (rs.getInt("CODIGOEMPRESA"));
                
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