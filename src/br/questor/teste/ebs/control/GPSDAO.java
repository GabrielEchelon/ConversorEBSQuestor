package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.GPS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class GPSDAO extends GPS{
      
    public void gpsQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT DISTINCT CRDEMPRESA.cd_empresa AS CODIGOEMPRESA,\n" +
"		CASE\n" +
"			WHEN CRDESTABELECIMENTO.aliq_terceiros IS NULL THEN \n" +
"				CASE\n" +
"					WHEN CONVERT (date, CRDESTABELECIMENTO.data_hora_alteracao) IS NULL THEN CONVERT (date, CURRENT_TIMESTAMP)\n" +
"					ELSE CONVERT (date, CRDESTABELECIMENTO.data_hora_alteracao)\n" +
"				END\n" +
"			ELSE\n" +
"				CASE\n" +
"					WHEN CONVERT (date, CRDESTABELECIMENTO.data_hora_alteracao) IS NULL THEN CONVERT (date, CURRENT_TIMESTAMP)\n" +
"					ELSE CONVERT (date, CRDESTABELECIMENTO.data_hora_alteracao) \n" +
"				END\n" +
"		END AS DATAINICIAL,\n" +
"		CASE\n" +
"		WHEN CRDEMPRESA.cd_pagamento_gps IS NULL or CRDEMPRESA.cd_pagamento_gps = 2203 THEN \n" +
"			CASE\n" +
"				WHEN CRDEMPRESA.codigo_pagamento_gps IS NULL THEN 2100\n" +
"				WHEN CRDEMPRESA.codigo_pagamento_gps = 0 THEN 2100\n" +
"				WHEN CRDEMPRESA.codigo_pagamento_gps = 2203 THEN 2208\n" +
"				ELSE CRDEMPRESA.codigo_pagamento_gps \n" +
"			END\n" +
"		WHEN CRDEMPRESA.cd_pagamento_gps = 0 or CRDEMPRESA.cd_pagamento_gps = 2203 THEN \n" +
"			CASE\n" +
"				WHEN CRDEMPRESA.codigo_pagamento_gps IS NULL THEN 2100\n" +
"				WHEN CRDEMPRESA.codigo_pagamento_gps = 0 THEN 2100\n" +
"				WHEN CRDEMPRESA.codigo_pagamento_gps = 2203 THEN 2208\n" +
"				ELSE CRDEMPRESA.codigo_pagamento_gps \n" +
"			END\n" +
"			ELSE CRDEMPRESA.cd_pagamento_gps \n" +
"		END AS CODIGOIMPOSTO,\n" +
"		CASE\n" +
"			WHEN CRDEMPRESA.cd_pagamento_gps IS NULL or CRDEMPRESA.cd_pagamento_gps = 2203 THEN \n" +
"				CASE\n" +
"					WHEN CRDEMPRESA.codigo_pagamento_gps IS NULL THEN 2100\n" +
"					WHEN CRDEMPRESA.codigo_pagamento_gps = 0 THEN 2100\n" +
"					WHEN CRDEMPRESA.codigo_pagamento_gps = 2203 THEN 2208\n" +
"					ELSE CRDEMPRESA.codigo_pagamento_gps \n" +
"				END\n" +
"			WHEN CRDEMPRESA.cd_pagamento_gps = 0 or CRDEMPRESA.cd_pagamento_gps = 2203 THEN \n" +
"				CASE\n" +
"					WHEN CRDEMPRESA.codigo_pagamento_gps IS NULL THEN 2100\n" +
"					WHEN CRDEMPRESA.codigo_pagamento_gps = 0 THEN 2100\n" +
"					WHEN CRDEMPRESA.codigo_pagamento_gps = 2203 THEN 2208\n" +
"					ELSE CRDEMPRESA.codigo_pagamento_gps \n" +
"				END\n" +
"			ELSE CRDEMPRESA.cd_pagamento_gps \n" +
"		END AS CODIGOIMPOSTO13,\n" +
"		CASE \n" +
"			WHEN CRDESTABELECIMENTO.codigo_fpas IS NULL THEN 515\n" +
"			WHEN CRDESTABELECIMENTO.codigo_fpas = 0 THEN 515\n" +
"			ELSE CRDESTABELECIMENTO.codigo_fpas  \n" +
"		END AS CODIGOFPAS,\n" +
"		CASE\n" +
"			WHEN CRDESTABELECIMENTO.codigo_terceiros IS NULL THEN 115\n" +
"			WHEN CRDESTABELECIMENTO.codigo_terceiros = 0 THEN 115\n" +
"			ELSE CRDESTABELECIMENTO.codigo_terceiros \n" +
"		END AS TERCEIROS,\n" +
"		CASE \n" +
"			WHEN CRDESTABELECIMENTO.aliq_terceiros IS NULL THEN 0\n" +
"			ELSE CRDESTABELECIMENTO.aliq_terceiros \n" +
"		END AS PERCPARTETERC\n" +
"FROM crdempresa CRDEMPRESA\n" +
"JOIN crdestabelecimento CRDESTABELECIMENTO\n" +
"ON CRDEMPRESA.cd_empresa = CRDESTABELECIMENTO.cd_empresa\n" +
"WHERE CRDEMPRESA.CD_EMPRESA NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999) \n" +
"ORDER BY CODIGOIMPOSTO;");
            ResultSet rs = ps.executeQuery();
            
            int count = 0;
            int count2 = 0;
            int count3 = 0;
            
            Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            java.sql.Date date = new java.sql.Date(currentDate.getTime());
            
            setAUXILIAR(date);
       
            while(rs.next()){
                
                count++;
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOIMPOSTO (rs.getInt("CODIGOIMPOSTO"));
                setDATAINICIAL (rs.getDate("DATAINICIAL"));
                setCODIGOIMPOSTO13 (rs.getInt("CODIGOIMPOSTO13"));
                setCODIGOFPAS (rs.getInt("CODIGOFPAS"));
                setTERCEIROS (rs.getInt("TERCEIROS"));
                setPERCPARTETERC (rs.getDouble("PERCPARTETERC"));
                
                if((getAUXILIAR().compareTo(getDATAINICIAL()) == 0)&&(getAUXILIAR2() == getCODIGOEMPRESA())&&(getAUXILIAR3() != getPERCPARTETERC())){
                    
                    calendar.setTime(AUXILIAR);
                    calendar.add(Calendar.DATE, +1);
                    currentDate = calendar.getTime();
                    date = new java.sql.Date(currentDate.getTime());
                    setDATAINICIAL(date);
                    
                    count3++;
 
                }else if((getAUXILIAR().compareTo(getDATAINICIAL()) == 0)&&(getAUXILIAR2() == getCODIGOEMPRESA())&&(getAUXILIAR3() == getPERCPARTETERC())) {
                                        
                    ps2 = con2.prepareStatement("DELETE FROM GPS WHERE CODIGOEMPRESA = ? AND DATAINICIAL = ? AND PERCPARTETERC = ?");

                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.setDate(2, this.getDATAINICIAL());
                    ps2.setDouble(3, this.getPERCPARTETERC());

                    ps2.executeUpdate();
                    
                    count2++;
                }

                ps2 = con2.prepareStatement ("INSERT INTO GPS (\n" +
"               CODIGOEMPRESA,\n" +
"               CODIGOTABGPS,\n" +
"               DATAINICIAL,\n" +
"               CODIGOIMPOSTO,\n" +
"               VARIACAOIMPOSTO,\n" +
"               CODIGOIMPOSTO13,\n" +
"               VARIACAOIMPOSTO13,\n" +
"               CODIGOFPAS,\n" +
"               CODIGOACIDTRAB,\n" +
"               TERCEIROS,\n" +
"               PERCPARTEEMP,\n" +
"               PERCENTFINANC,\n" +
"               PERCPRODRURAIS,\n" +
"               PERCPARTESAT,\n" +
"               PERCPARTETERC,\n" +
"               PERCDIRAUTON,\n" +
"               PERCISENCAOFILANT,\n" +
"               PERCCOOPTRAB, \n" +
"               PERCACRESCFAP)\n" +
"               VALUES (?,1,?,?,51,?,52,?,1,?,0,0,0,0,?,0,0,0,0);");
                ps2.setInt(1, this.getCODIGOEMPRESA());
                ps2.setDate(2, this.getDATAINICIAL());
                ps2.setInt(3, this.getCODIGOIMPOSTO());
                ps2.setInt(4, this.getCODIGOIMPOSTO13());
                ps2.setInt(5, this.getCODIGOFPAS());
                ps2.setInt(6, this.getTERCEIROS());
                ps2.setDouble(7, this.getPERCPARTETERC());
                ps2.executeUpdate();
                
                setAUXILIAR (rs.getDate("DATAINICIAL"));
                setAUXILIAR2 (rs.getInt("CODIGOEMPRESA"));
                setAUXILIAR3 (rs.getInt("PERCPARTETERC"));
            }
            System.out.println("\n\nTabela finalizada. (" + getTABELA() + ")");
            System.out.println("Inseridos: " + (count-count2) + " Não Inseridos: " + count2);
            System.out.println("Adicionado um dia na data inicial: " + count3);
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