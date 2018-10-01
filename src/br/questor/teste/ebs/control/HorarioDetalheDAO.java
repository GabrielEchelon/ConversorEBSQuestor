package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.HorarioDetalhe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HorarioDetalheDAO extends HorarioDetalhe{
      
    public void horarioDetalheQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("/*--- MANHÃ ---*/\n" +
"SELECT DISTINCT QST_HORARIO.CODIGOHORARIO,\n" +
"((convert(int,(datepart(hour, FUNHORARIO.entrada_manha))))*60) + (convert(int,(datepart(minute, FUNHORARIO.entrada_manha)))) AS HORAENTRADA,\n" +
"((convert(int,(datepart(hour, FUNHORARIO.saida_manha))))*60) + (convert(int,(datepart(minute, FUNHORARIO.saida_manha)))) AS HORASAIDA,\n" +
"CASE\n" +
"	WHEN ((((convert(int,(datepart(hour, FUNHORARIO.saida_manha))))*60) + (convert(int,(datepart(minute, FUNHORARIO.saida_manha))))) - \n" +
"		(((convert(int,(datepart(hour, FUNHORARIO.entrada_manha))))*60) + (convert(int,(datepart(minute, FUNHORARIO.entrada_manha)))))) < 0 \n" +
"	THEN ((((convert(int,(datepart(hour, FUNHORARIO.entrada_manha))))*60) +	(convert(int,(datepart(minute, FUNHORARIO.entrada_manha)))) - \n" +
"		((convert(int,(datepart(hour, FUNHORARIO.saida_manha))))*60) + (convert(int,(datepart(minute, FUNHORARIO.saida_manha))))))\n" +
"	ELSE ((((convert(int,(datepart(hour, FUNHORARIO.saida_manha))))*60) + (convert(int,(datepart(minute, FUNHORARIO.saida_manha))))) - \n" +
"		(((convert(int,(datepart(hour, FUNHORARIO.entrada_manha))))*60) + (convert(int,(datepart(minute, FUNHORARIO.entrada_manha))))))\n" +
"END AS NUMEROHORAS,\n" +
"0 AS TIPOALTERACAOESOCIAL\n" +
"FROM FUNhorario FUNHORARIO\n" +
"JOIN QST_HORARIO QST_HORARIO \n" +
"ON QST_HORARIO.DESCRHORARIO = CASE\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NULL AND FUNHORARIO.ENTRADA_TARDE IS NULL AND FUNHORARIO.ENTRADA_NOITE IS NULL\n" +
"		THEN NULL\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NOT NULL \n" +
"		THEN CONCAT(SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_MANHA,121),12,5),\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.SAIDA_MANHA IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_MANHA,121),12,5))\n" +
"			 END,\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.ENTRADA_TARDE IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('-',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_TARDE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_TARDE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_TARDE,121),12,5))\n" +
"					 END)\n" +
"			 END,\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.ENTRADA_NOITE IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('-',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_NOITE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_NOITE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_NOITE,121),12,5))\n" +
"					 END)\n" +
"			 END)\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NULL AND FUNHORARIO.ENTRADA_TARDE IS NOT NULL\n" +
"		THEN CONCAT(SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_TARDE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_TARDE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_TARDE,121),12,5))\n" +
"					 END,\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.ENTRADA_NOITE IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('-',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_NOITE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_NOITE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_NOITE,121),12,5))\n" +
"					 END)\n" +
"			 END)\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NULL AND FUNHORARIO.ENTRADA_TARDE IS NULL AND FUNHORARIO.ENTRADA_NOITE IS NOT NULL\n" +
"		THEN CONCAT(SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_NOITE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_NOITE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_NOITE,121),12,5))\n" +
"					 END)\n" +
"END\n" +
"WHERE FUNHORARIO.ENTRADA_MANHA IS NOT NULL AND FUNHORARIO.saida_manha IS NOT NULL\n" +
"\n" +
"UNION\n" +
"/*--- TARDE ---*/\n" +
"SELECT DISTINCT QST_HORARIO.CODIGOHORARIO,\n" +
"((convert(int,(datepart(hour, FUNHORARIO.entrada_tarde))))*60) + (convert(int,(datepart(minute, FUNHORARIO.entrada_tarde)))) AS HORAENTRADA,\n" +
"((convert(int,(datepart(hour, FUNHORARIO.saida_tarde))))*60) + (convert(int,(datepart(minute, FUNHORARIO.saida_tarde)))) AS HORASAIDA,\n" +
"CASE\n" +
"	WHEN ((((convert(int,(datepart(hour, FUNHORARIO.saida_tarde))))*60) + (convert(int,(datepart(minute, FUNHORARIO.saida_tarde))))) - \n" +
"		(((convert(int,(datepart(hour, FUNHORARIO.entrada_tarde))))*60) + (convert(int,(datepart(minute, FUNHORARIO.entrada_tarde)))))) < 0 \n" +
"	THEN ((((convert(int,(datepart(hour, FUNHORARIO.entrada_tarde))))*60) +	(convert(int,(datepart(minute, FUNHORARIO.entrada_tarde)))) - \n" +
"		((convert(int,(datepart(hour, FUNHORARIO.saida_tarde))))*60) + (convert(int,(datepart(minute, FUNHORARIO.saida_tarde))))))\n" +
"	ELSE ((((convert(int,(datepart(hour, FUNHORARIO.saida_tarde))))*60) + (convert(int,(datepart(minute, FUNHORARIO.saida_tarde))))) - \n" +
"		(((convert(int,(datepart(hour, FUNHORARIO.entrada_tarde))))*60) + (convert(int,(datepart(minute, FUNHORARIO.entrada_tarde))))))\n" +
"END AS NUMEROHORAS,\n" +
"0 AS TIPOALTERACAOESOCIAL\n" +
"FROM FUNhorario FUNHORARIO\n" +
"JOIN QST_HORARIO QST_HORARIO \n" +
"ON QST_HORARIO.DESCRHORARIO = CASE\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NULL AND FUNHORARIO.ENTRADA_TARDE IS NULL AND FUNHORARIO.ENTRADA_NOITE IS NULL\n" +
"		THEN NULL\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NOT NULL \n" +
"		THEN CONCAT(SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_MANHA,121),12,5),\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.SAIDA_MANHA IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_MANHA,121),12,5))\n" +
"			 END,\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.ENTRADA_TARDE IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('-',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_TARDE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_TARDE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_TARDE,121),12,5))\n" +
"					 END)\n" +
"			 END,\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.ENTRADA_NOITE IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('-',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_NOITE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_NOITE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_NOITE,121),12,5))\n" +
"					 END)\n" +
"			 END)\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NULL AND FUNHORARIO.ENTRADA_TARDE IS NOT NULL\n" +
"		THEN CONCAT(SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_TARDE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_TARDE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_TARDE,121),12,5))\n" +
"					 END,\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.ENTRADA_NOITE IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('-',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_NOITE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_NOITE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_NOITE,121),12,5))\n" +
"					 END)\n" +
"			 END)\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NULL AND FUNHORARIO.ENTRADA_TARDE IS NULL AND FUNHORARIO.ENTRADA_NOITE IS NOT NULL\n" +
"		THEN CONCAT(SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_NOITE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_NOITE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_NOITE,121),12,5))\n" +
"					 END)\n" +
"END\n" +
"WHERE FUNHORARIO.entrada_tarde IS NOT NULL AND FUNHORARIO.saida_tarde IS NOT NULL\n" +
"\n" +
"UNION\n" +
"/*--- NOITE ---*/\n" +
"SELECT DISTINCT QST_HORARIO.CODIGOHORARIO,\n" +
"((convert(int,(datepart(hour, FUNHORARIO.entrada_noite))))*60) + (convert(int,(datepart(minute, FUNHORARIO.entrada_noite)))) AS HORAENTRADA,\n" +
"((convert(int,(datepart(hour, FUNHORARIO.saida_noite))))*60) + (convert(int,(datepart(minute, FUNHORARIO.saida_noite)))) AS HORASAIDA,\n" +
"CASE\n" +
"	WHEN ((((convert(int,(datepart(hour, FUNHORARIO.saida_noite))))*60) + \n" +
"		(convert(int,(datepart(minute, FUNHORARIO.saida_noite)))) - \n" +
"		((convert(int,(datepart(hour, FUNHORARIO.entrada_noite))))*60) + \n" +
"		(convert(int,(datepart(minute, FUNHORARIO.entrada_noite)))))) < 0 \n" +
"	THEN ((((convert(int,(datepart(hour, FUNHORARIO.entrada_noite))))*60) + \n" +
"		(convert(int,(datepart(minute, FUNHORARIO.entrada_noite)))) - \n" +
"		((convert(int,(datepart(hour, FUNHORARIO.saida_noite))))*60) + \n" +
"		(convert(int,(datepart(minute, FUNHORARIO.saida_noite))))))\n" +
"	ELSE ((((convert(int,(datepart(hour, FUNHORARIO.saida_noite))))*60) + \n" +
"		(convert(int,(datepart(minute, FUNHORARIO.saida_noite)))) - \n" +
"		((convert(int,(datepart(hour, FUNHORARIO.entrada_noite))))*60) + \n" +
"		(convert(int,(datepart(minute, FUNHORARIO.entrada_noite))))))\n" +
"END AS NUMEROHORAS,\n" +
"0 AS TIPOALTERACAOESOCIAL\n" +
"FROM FUNhorario FUNHORARIO\n" +
"JOIN QST_HORARIO QST_HORARIO \n" +
"ON QST_HORARIO.DESCRHORARIO = CASE\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NULL AND FUNHORARIO.ENTRADA_TARDE IS NULL AND FUNHORARIO.ENTRADA_NOITE IS NULL\n" +
"		THEN NULL\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NOT NULL \n" +
"		THEN CONCAT(SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_MANHA,121),12,5),\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.SAIDA_MANHA IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_MANHA,121),12,5))\n" +
"			 END,\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.ENTRADA_TARDE IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('-',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_TARDE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_TARDE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_TARDE,121),12,5))\n" +
"					 END)\n" +
"			 END,\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.ENTRADA_NOITE IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('-',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_NOITE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_NOITE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_NOITE,121),12,5))\n" +
"					 END)\n" +
"			 END)\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NULL AND FUNHORARIO.ENTRADA_TARDE IS NOT NULL\n" +
"		THEN CONCAT(SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_TARDE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_TARDE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_TARDE,121),12,5))\n" +
"					 END,\n" +
"			 CASE\n" +
"				WHEN FUNHORARIO.ENTRADA_NOITE IS NULL \n" +
"					THEN NULL\n" +
"				ELSE CONCAT('-',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_NOITE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_NOITE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_NOITE,121),12,5))\n" +
"					 END)\n" +
"			 END)\n" +
"	WHEN FUNHORARIO.ENTRADA_MANHA IS NULL AND FUNHORARIO.ENTRADA_TARDE IS NULL AND FUNHORARIO.ENTRADA_NOITE IS NOT NULL\n" +
"		THEN CONCAT(SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.ENTRADA_NOITE,121),12,5),\n" +
"					 CASE\n" +
"						WHEN FUNHORARIO.SAIDA_NOITE IS NULL \n" +
"							THEN NULL\n" +
"						ELSE CONCAT('/',SUBSTRING(CONVERT(VARCHAR(16),FUNHORARIO.SAIDA_NOITE,121),12,5))\n" +
"					 END)\n" +
"END\n" +
"WHERE FUNHORARIO.entrada_noite IS NOT NULL AND FUNHORARIO.saida_noite IS NOT NULL");
            ResultSet rs = ps.executeQuery();

            int seq = 0;
            
            while(rs.next()){

                seq++;
                
                System.out.print(".");
                
                setCODIGOHORARIO (rs.getInt("CODIGOHORARIO"));
                setHORAENTRADA (rs.getInt("HORAENTRADA"));
                setHORASAIDA (rs.getInt("HORASAIDA"));
                setNUMEROHORAS (rs.getInt("NUMEROHORAS"));
                setTIPOALTERACAOESOCIAL (rs.getInt("TIPOALTERACAOESOCIAL"));

                ps2 = con2.prepareStatement ("INSERT INTO HORARIODETALHE (CODIGOHORARIO,HORAENTRADA,HORASAIDA,\n" +
"NUMEROHORAS, TIPOALTERACAOESOCIAL,SEQ,DATAINICIAL)\n" +
"VALUES (?,?,?,?,?,?,'1900-01-01');");
                ps2.setInt(1, this.getCODIGOHORARIO());
                ps2.setInt(2, this.getHORAENTRADA());
                ps2.setInt(3, this.getHORASAIDA());
                ps2.setInt(4, this.getNUMEROHORAS());
                ps2.setInt(5, this.getTIPOALTERACAOESOCIAL());
                ps2.setInt(6, seq);
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