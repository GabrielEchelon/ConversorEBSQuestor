package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.OutraEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OutraEmpresaDAO extends OutraEmpresa{
      
    public void OutraEmpresaQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY CODIGOEMPRESA ASC) AS CODIGOOUTEMP, \n" +
"	CODIGOEMPRESA, \n" +
"	NOMEOUTEMP, \n" +
"	ENDEROUTEMP, \n" +
"	NUMEROENDER,\n" +
"	COMPLENDER,\n" +
"	BAIRROOUTEMP,\n" +
"	CEP,\n" +
"	SIGLAESTADO,\n" +
"	CASE\n" +
"		WHEN CODIGOMUNIC IS NULL AND SIGLAESTADO <> 'PR' AND CODIGOMUNIC IS NULL AND SIGLAESTADO <> 'DF' THEN 1\n" +
"		WHEN CODIGOMUNIC IS NULL AND SIGLAESTADO = 'PR' THEN 94\n" +
"		WHEN CODIGOMUNIC IS NULL AND SIGLAESTADO = 'DF' THEN 1\n" +
"		ELSE CODIGOMUNIC \n" +
"	END AS CODIGOMUNIC,\n" +
"	INSCRFEDERAL,\n" +
"	TIPOINSCR,\n" +
"	CASE\n" +
"		WHEN NOMEOUTEMP LIKE '%banco%' THEN 2\n" +
"		WHEN NOMEOUTEMP LIKE '%saude%' THEN 7\n" +
"		WHEN NOMEOUTEMP LIKE '%vale%' THEN 9\n" +
"		WHEN NOMEOUTEMP LIKE '%constru%' THEN 1\n" +
"		ELSE 2\n" +
"	END AS TIPOOUTEMP\n" +
"FROM (SELECT DISTINCT TOMADOR.cd_empresa AS CODIGOEMPRESA,\n" +
"	TOMADOR.CD_TOMADOR, \n" +
"	TOMADOR.NOME AS NOMEOUTEMP, \n" +
"	TOMADOR.ENDERECO AS ENDEROUTEMP, \n" +
"	TOMADOR.NR_ENDERECO AS NUMEROENDER,\n" +
"	TOMADOR.COMPL_ENDERECO AS COMPLENDER,\n" +
"	TOMADOR.BAIRRO AS BAIRROOUTEMP,\n" +
"	CONCAT(LEFT(TOMADOR.CEP,2), '.',RIGHT(LEFT(TOMADOR.CEP,5),3), '-', RIGHT(TOMADOR.CEP,3)) AS CEP,\n" +
"	TOMADOR.ESTADO AS SIGLAESTADO,\n" +
"	QST_MUNICIPIO.CODIGOMUNIC AS CODIGOMUNIC,\n" +
"	CASE \n" +
"		WHEN LEN(LTRIM(RTRIM(CGC))) <> 18 THEN '11.111.111/1111-11'\n" +
"		WHEN CGC IS NULL THEN '11.111.111/1111-11'\n" +
"		ELSE CGC\n" +
"	END AS INSCRFEDERAL,\n" +
"	CASE \n" +
"		WHEN LEN(CGC) = 18 THEN 1\n" +
"		ELSE 1\n" +
"	END AS TIPOINSCR\n" +
"	FROM TOMADOR TOMADOR\n" +
"	LEFT JOIN QST_MUNICIPIO QST_MUNICIPIO \n" +
"	ON TOMADOR.CIDADE = QST_MUNICIPIO.NOMEMUNIC AND TOMADOR.ESTADO = QST_MUNICIPIO.SIGLAESTADO\n" +
"	WHERE cd_tomador <> 0\n" +
"	AND cd_empresa NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999)) AS TESTE\n" +
"	ORDER BY CODIGOEMPRESA;");
            ResultSet rs = ps.executeQuery();
            
            int SEQ = 1;
            
            ps2 = con2.prepareStatement ("INSERT INTO OUTRAEMPRESA (CODIGOOUTEMP, DATAINICIAL, NOMEOUTEMP, ENDEROUTEMP, NUMEROENDER, COMPLENDER, \n" +
"BAIRROOUTEMP, SIGLAESTADO, CODIGOMUNIC, CEP, TIPOINSCR, INSCRFEDERAL, PORTEEMP)\n" +
"VALUES (9999,'1900-01-01','AUXILIAR VALE TRANSPORTE','Importado',0,\n" +
"'Auxilio a cadastros','Importado', 'PR',94,'81.000-888',2,'00.000.000/0001-24',1);");
            
            ps2.executeUpdate();
            System.out.println("Adicionada empresa '9999' para auxiliar as linhas de transporte.");
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOOUTEMP (rs.getInt("CODIGOOUTEMP"));
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setNOMEOUTEMP (rs.getString("NOMEOUTEMP"));
                setENDEROUTEMP (rs.getString("ENDEROUTEMP"));
                setNUMEROENDER (rs.getInt("NUMEROENDER"));
                setCOMPLENDER (rs.getString("COMPLENDER"));
                setBAIRROOUTEMP (rs.getString("BAIRROOUTEMP"));
                setSIGLAESTADO (rs.getString("SIGLAESTADO"));
                setCODIGOMUNIC (rs.getInt("CODIGOMUNIC"));
                setCEP (rs.getString("CEP"));
                setTIPOINSCR (rs.getInt("TIPOINSCR"));
                setINSCRFEDERAL(rs.getString("INSCRFEDERAL"));
                setTIPOOUTEMP (rs.getInt("TIPOOUTEMP"));
                
                if(getCODIGOEMPRESA() == getAUXILIAR()){
                    SEQ++;
                } else {
                    SEQ = 1;
                }

                    ps2 = con2.prepareStatement ("INSERT INTO OUTRAEMPRESA (\n" +
"CODIGOOUTEMP, DATAINICIAL, NOMEOUTEMP, ENDEROUTEMP, NUMEROENDER, COMPLENDER, BAIRROOUTEMP, SIGLAESTADO,\n" +
"CODIGOMUNIC, CEP, TIPOINSCR, INSCRFEDERAL, PORTEEMP)\n" +
"VALUES (?,'1900-01-01',?,?,?,?,?,?,?,?,?,?,1);");
                    
                    ps2.setInt(1, this.getCODIGOOUTEMP());
                    ps2.setString(2, this.getNOMEOUTEMP());
                    ps2.setString(3, this.getENDEROUTEMP());
                    ps2.setInt(4, this.getNUMEROENDER());
                    ps2.setString(5, this.getCOMPLENDER());
                    ps2.setString(6, this.getBAIRROOUTEMP());
                    ps2.setString(7, this.getSIGLAESTADO());
                    ps2.setInt(8, this.getCODIGOMUNIC());
                    ps2.setString(9, this.getCEP());
                    ps2.setInt(10, this.getTIPOINSCR());
                    ps2.setString(11, this.getINSCRFEDERAL());
                    
                    ps2.executeUpdate();
                    
                    ps2 = con2.prepareStatement ("INSERT INTO OUTRAEMPEMP (\n" +
"CODIGOEMPRESA, CODIGOOUTEMP, DATAINICIAL, TIPOOUTEMP, POSSUIGPS, CODIGOLOCALCTB, GPSRECEBIMENTOS)\n" +
"VALUES (?, ?, '1900-01-01', ?, 1, 0, 1);");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.setInt(2, SEQ);
                    ps2.setInt(3, this.getTIPOOUTEMP());
                    
                    ps2.executeUpdate();
                    setAUXILIAR (rs.getInt("CODIGOEMPRESA"));
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