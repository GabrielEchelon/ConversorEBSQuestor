package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.PeriodoCalculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QST_PeriodoCalculoDAO extends PeriodoCalculo{
      
    public void periodoCalculoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        Connection con3 = DAO.getConnectionSQLServer();
        PreparedStatement ps3 = null;
        
        try{
            ps = con.prepareStatement("SELECT	EPMA.cd_empresa AS CODIGOEMPRESA,\n" +
"		CASE \n" +
"			WHEN LEN(EPMA.mes) = 1 THEN CONCAT(EPMA.ano,'-0',EPMA.mes,'-01')\n" +
"			ELSE CONCAT(EPMA.ano,'-',EPMA.mes,'-01')\n" +
"		END AS COMPET,\n" +
"		CASE\n" +
"			WHEN LEN(EPMA.mes) = 1 THEN CONCAT(EPMA.ano,'-0',EPMA.mes,'-01') \n" +
"			ELSE CONCAT(EPMA.ano,'-',EPMA.mes,'-01')\n" +
"		END AS DATAINICIALFOLHA,\n" +
"		CASE\n" +
"			WHEN LEN(EPMA.mes) = 1 THEN CONCAT(EPMA.ano,'-0',EPMA.mes,'-28') \n" +
"			ELSE CONCAT(EPMA.ano,'-',EPMA.mes,'-28')\n" +
"		END AS DATAFINALFOLHA,\n" +
"		CASE	\n" +
"		WHEN CRDE.pagamento_mes like '%S%' THEN \n" +
"		CASE\n" +
"					WHEN LEN(EPMA.mes) = 1 THEN CONCAT(EPMA.ano,'-0',EPMA.mes,'-28')\n" +
"					ELSE CONCAT(EPMA.ano,'-',EPMA.mes,'-28')\n" +
"		END\n" +
"		WHEN CRDE.pagamento_mes like '%N%' THEN  \n" +
"			CASE\n" +
"			WHEN LEN(EPMA.mes) = 1 THEN\n" +
"				CASE\n" +
"					WHEN LEN(EPMA.mes+1) = 1 THEN CONCAT(EPMA.ano,'-0',EPMA.mes+1,'-05')\n" +
"					ELSE CONCAT(EPMA.ano,'-',EPMA.mes+1,'-05')\n" +
"				END\n" +
"			ELSE\n" +
"				CASE\n" +
"					WHEN EPMA.mes = 12 THEN CONCAT(EPMA.ano+1,'-0',EPMA.mes-11,'-05')\n" +
"					ELSE CONCAT(EPMA.ano,'-',EPMA.mes+1,'-05') \n" +
"				END\n" +
"			END \n" +
"		END AS DATAPGTO,\n" +
"		\n" +
"	CASE	\n" +
"		WHEN CRDE.pagamento_mes like '%S%' THEN \n" +
"		CASE\n" +
"					WHEN LEN(EPMA.mes) = 1 THEN CONCAT(EPMA.ano,'-0',EPMA.mes,'-28')\n" +
"					ELSE CONCAT(EPMA.ano,'-',EPMA.mes,'-28')\n" +
"		END\n" +
"		WHEN CRDE.pagamento_mes like '%N%' THEN  \n" +
"			CASE\n" +
"			WHEN LEN(EPMA.mes) = 1 THEN\n" +
"				CASE\n" +
"					WHEN LEN(EPMA.mes+1) = 1 THEN CONCAT(EPMA.ano,'-0',EPMA.mes+1,'-05')\n" +
"					ELSE CONCAT(EPMA.ano,'-',EPMA.mes+1,'-05')\n" +
"				END\n" +
"			ELSE\n" +
"				CASE\n" +
"					WHEN EPMA.mes = 12 THEN CONCAT(EPMA.ano+1,'-0',EPMA.mes-11,'-05')\n" +
"					ELSE CONCAT(EPMA.ano,'-',EPMA.mes+1,'-05') \n" +
"				END\n" +
"			END \n" +
"		END AS DATAPGTODIRET\n" +
"FROM CRDEmpresaParametroMesAno EPMA\n" +
"JOIN CRDEmpresa CRDE\n" +
"ON EPMA.cd_empresa = CRDE.cd_empresa\n" +
"ORDER BY CODIGOEMPRESA, COMPET");
            ResultSet rs = ps.executeQuery();
            
            int SEQ = 1;
            
            while(rs.next()){
                                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCOMPET (rs.getDate("COMPET"));
                setDATAINICIALFOLHA (rs.getDate("DATAINICIALFOLHA"));
                setDATAFINALFOLHA (rs.getDate("DATAFINALFOLHA"));
                setDATAPGTO (rs.getDate("DATAPGTO"));
                setDATAPGTODIRET (rs.getDate("DATAPGTODIRET"));

                if(getCODIGOEMPRESA() == getAUXILIAR()){
                    SEQ++;
                } else {
                    SEQ = 1;
                }
                
                ps3 = con3.prepareStatement ("INSERT INTO QST_PERIODOCALCULO (CODIGOEMPRESA, CODIGOPERCALCULO, \n" +
"CODIGOTIPOCALC, COMPET, DATAINICIALFOLHA, DATAFINALFOLHA, DATAPGTO,\n" +
"SEQ, DATAPGTODIRET, POSSUIPARCELAMENTO)\n" +
"VALUES (?,?,1,?,?,?,?,?,?,0);");
                    
                ps3.setInt(1, this.getCODIGOEMPRESA());
                ps3.setInt(2, SEQ);
                ps3.setDate(3, this.getCOMPET());
                ps3.setDate(4, this.getDATAINICIALFOLHA());
                ps3.setDate(5, this.getDATAFINALFOLHA());
                ps3.setDate(6, this.getDATAPGTO());
                ps3.setInt(7, SEQ);
                ps3.setDate(8, this.getDATAPGTODIRET());
                  
                ps3.executeUpdate();
                
                setAUXILIAR (rs.getInt("CODIGOEMPRESA"));
            }
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
            if(ps3 != null){
                ps3.close();
            }
            if(con3 != null){
                con3.close();
            }
        }      
    }
}