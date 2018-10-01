package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.INSSComp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class INSSCompDAO extends INSSComp{
      
    public void inssCompQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT cd_empresa AS CODIGOEMPRESA,\n" +
"       cd_filial AS CODIGOESTAB,\n" +
"       CASE \n" +
"		WHEN dt_recolhimento IS NULL THEN CONCAT(ano,'-',mes,'-01')\n" +
"		ELSE dt_recolhimento\n" +
"	   END AS COMPET,\n" +
"       vl_tributo AS VALORORIG,\n" +
"       CASE \n" +
"		WHEN dt_recolhimento IS NULL THEN CONCAT(ano,'-',mes,'-01')\n" +
"		ELSE dt_recolhimento\n" +
"	   END AS COMPETINISEFIP,\n" +
"       CASE \n" +
"		WHEN dt_recolhimento IS NULL THEN CONCAT(ano,'-',mes,'-01')\n" +
"		ELSE dt_recolhimento\n" +
"	   END AS COMPETFINSEFIP\n" +
"FROM CRHRecolhimentoTributo");
            ResultSet rs = ps.executeQuery();
            
            int SEQ = 1;
            
            while(rs.next()){
                
                System.out.print(".");

                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCODIGOESTAB (rs.getInt("CODIGOESTAB"));
                setCOMPET (rs.getDate("COMPET"));
                setVALORORIG (rs.getDouble("VALORORIG"));
                setCOMPETINISEFIP (rs.getDate("COMPETINISEFIP"));
                setCOMPETFINSEFIP (rs.getDate("COMPETFINSEFIP"));

                
                if((getCODIGOEMPRESA() == getAUXILIAR())&&(getCODIGOESTAB() == getAUXILIAR2())){
                    SEQ++;
                } else {
                    SEQ = 1;
                }

                    ps2 = con2.prepareStatement ("INSERT INTO INSSCOMP (CODIGOEMPRESA, CODIGOESTAB, SEQ, CLASSIFORGAN,\n" +
"CODIGOOUTEMP, COMPET, VALORORIG, OBS, COMPETINISEFIP, COMPETFINSEFIP,\n" +
"PERCCOMPENS, FORMACORRECAO, COMPENSREALIZ, CHAVEORIGEM, ORIGEMDADO)\n" +
"VALUES (?,?,?,NULL,NULL,?,?,'Importado por Conversão',?,?,30,0,0,NULL,3);");
                    
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.setInt(2, this.getCODIGOESTAB());
                    ps2.setInt(3, SEQ);
                    ps2.setDate(4, this.getCOMPET());
                    ps2.setDouble(5, this.getVALORORIG());
                    ps2.setDate(6, this.getCOMPETINISEFIP());
                    ps2.setDate(7, this.getCOMPETFINSEFIP());

                    
                    ps2.executeUpdate();
                    
                    setAUXILIAR (rs.getInt("CODIGOEMPRESA"));
                    setAUXILIAR2 (rs.getInt("CODIGOESTAB"));
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