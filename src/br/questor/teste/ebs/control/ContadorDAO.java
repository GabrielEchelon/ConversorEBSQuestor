package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Contador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContadorDAO extends Contador{
      
    public void contadorQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT\n" +
"	RTRIM(LTRIM(RESPONSAVELG.cd_responsavel)) AS CODIGOCONT,\n" +
"	RTRIM(LTRIM(RESPONSAVELG.nome)) AS NOMECONT,\n" +
"	CASE \n" +
"		WHEN RTRIM(LTRIM(RESPONSAVELG.endereco)) IS NULL THEN 'Importação / Inválido'\n" +
"		WHEN RTRIM(LTRIM(RESPONSAVELG.endereco)) LIKE '' THEN 'Importação / Inválido'\n" +
"		ELSE RTRIM(LTRIM(RESPONSAVELG.endereco))\n" +
"	END AS ENDERECOCONT,\n" +
"	RTRIM(LTRIM(RESPONSAVELG.nr_endereco)) AS NUMENDERCONT,\n" +
"	RTRIM(LTRIM(RESPONSAVELG.bairro)) AS BAIRROENDERCONT,\n" +
"	RTRIM(LTRIM(RESPONSAVELG.estado)) AS SIGLAESTADO,\n" +
"	QST_MUNICIPIO.CODIGOMUNIC AS CODIGOMUNIC,\n" +
"	CASE \n" +
"		WHEN RESPONSAVELG.cep IS NULL THEN '11.111-111' \n" +
"		ELSE CONCAT(LEFT(RESPONSAVELG.cep,2), '.',RIGHT(LEFT(RESPONSAVELG.cep,5),3), '-', RIGHT(RESPONSAVELG.cep,3)) \n" +
"    END AS CEPENDERCONT, \n" +
"	CASE\n" +
"		WHEN RESPONSAVELG.ddd_fone IS NULL THEN 41\n" +
"		WHEN RESPONSAVELG.ddd_fone LIKE '' THEN 41\n" +
"		ELSE RESPONSAVELG.ddd_fone\n" +
"	END AS DDDFONE,\n" +
"	CASE\n" +
"		WHEN RESPONSAVELG.telefone IS NULL THEN 11111111\n" +
"		WHEN RESPONSAVELG.telefone LIKE '' THEN 11111111\n" +
"		ELSE RESPONSAVELG.telefone\n" +
"	END AS NUMEROFONE,\n" +
"	RESPONSAVELG.ddd_fax AS DDDFAX,\n" +
"	RESPONSAVELG.fax AS NUMEROFAX,\n" +
"	CASE\n" +
"		WHEN LEN(RTRIM(LTRIM(RESPONSAVELG.cpfcontato))) = 14 THEN 1\n" +
"		WHEN LEN(RTRIM(LTRIM(RESPONSAVELG.cpfcontato))) = 18 THEN 2\n" +
"		WHEN LEN(RTRIM(LTRIM(RESPONSAVELG.cpfcontato))) = 16 THEN 3\n" +
"		ELSE 1\n" +
"	END AS TIPOINSCR,\n" +
"	CASE\n" +
"		WHEN RTRIM(LTRIM(RESPONSAVELG.cpfcontato)) IS NULL THEN '111.111.111-11'\n" +
"		WHEN RTRIM(LTRIM(RESPONSAVELG.cpfcontato)) LIKE '' THEN '111.111.111-11'\n" +
"		ELSE RTRIM(LTRIM(RESPONSAVELG.cpfcontato))\n" +
"	END AS INSCRFEDERAL,\n" +
"	CONCAT('1-PR-999999','/O-9') AS NUMEROREG,\n" +
"	CASE\n" +
"	WHEN RTRIM(LTRIM(RESPONSAVELG.denominacao)) IS NULL THEN 'Contador'\n" +
"	WHEN RTRIM(LTRIM(RESPONSAVELG.denominacao)) LIKE '' THEN 'Contador'\n" +
"	ELSE RTRIM(LTRIM(RESPONSAVELG.denominacao))\n" +
"	END AS TITULOPROFIS,\n" +
"	CASE\n" +
"		WHEN RTRIM(LTRIM(RESPONSAVELG.uf_crc)) IS NULL THEN 'PR'\n" +
"		WHEN RTRIM(LTRIM(RESPONSAVELG.uf_crc)) LIKE '' THEN 'PR'\n" +
"		ELSE RTRIM(LTRIM(RESPONSAVELG.uf_crc))\n" +
"	END AS UFCRC\n" +
"FROM RESPONSAVELG RESPONSAVELG\n" +
"JOIN QST_MUNICIPIO QST_MUNICIPIO \n" +
"ON RESPONSAVELG.cidade = QST_MUNICIPIO.NOMEMUNIC\n" +
"WHERE cd_responsavel != 999;");
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOCONT(rs.getInt("CODIGOCONT"));
                setNOMECONT(rs.getString("NOMECONT"));
                setENDERECOCONT(rs.getString("ENDERECOCONT"));
                setNUMENDERCONT(rs.getInt("NUMENDERCONT"));
                setBAIRROENDERCONT(rs.getString("BAIRROENDERCONT"));
                setSIGLAESTADO(rs.getString("SIGLAESTADO"));
                setCODIGOMUNIC(rs.getInt("CODIGOMUNIC"));
                setCEPENDERCONT(rs.getString("CEPENDERCONT"));
                setDDDFONE(rs.getInt("DDDFONE"));
                setNUMEROFONE(rs.getInt("NUMEROFONE"));
                setDDDFAX(rs.getInt("DDDFAX"));
                setNUMEROFAX(rs.getInt("NUMEROFAX"));
                setTIPOINSCR(rs.getInt("TIPOINSCR"));
                setINSCRFEDERAL(rs.getString("INSCRFEDERAL"));
                setNUMEROREG(rs.getString("NUMEROREG"));
                setTITULOPROFIS(rs.getString("TITULOPROFIS"));
                setUFCRC(rs.getString("UFCRC"));
                
                ps2 = con2.prepareStatement ("INSERT INTO CONTADOR (\n" +
"	CODIGOCONT,\n" +
"	DATAINICIAL,\n" +
"	NOMECONT,\n" +
"	ENDERECOCONT,\n" +
"	NUMENDERCONT,\n" +
"	BAIRROENDERCONT,\n" +
"	SIGLAESTADO,\n" +
"	CODIGOMUNIC,\n" +
"	CEPENDERCONT,\n" +
"	DDDFONE,\n" +
"	NUMEROFONE,\n" +
"	DDDFAX,\n" +
"	NUMEROFAX,\n" +
"	TIPOINSCR,\n" +
"	INSCRFEDERAL,\n" +
"	NUMEROREG,\n" +
"	TITULOPROFIS,\n" +
"	UFCRC)\n" +
"VALUES (?,'1900-01-01',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                    
                    ps2.setInt(1, getCODIGOCONT());
                    ps2.setString(2, getNOMECONT());
                    ps2.setString(3, getENDERECOCONT());
                    ps2.setInt(4, getNUMENDERCONT());
                    ps2.setString(5, getBAIRROENDERCONT());
                    ps2.setString(6, getSIGLAESTADO());
                    ps2.setInt(7, getCODIGOMUNIC());
                    ps2.setString(8, getCEPENDERCONT());
                    ps2.setInt(9, getDDDFONE());
                    ps2.setInt(10, getNUMEROFONE());
                    ps2.setInt(11, getDDDFAX());
                    ps2.setInt(12, getNUMEROFAX());
                    ps2.setInt(13, getTIPOINSCR());
                    ps2.setString(14, getINSCRFEDERAL());
                    ps2.setString(15, getNUMEROREG());
                    ps2.setString(16, getTITULOPROFIS());
                    ps2.setString(17, getUFCRC());
                    
                    ps2.executeUpdate();
                    
            }
            
            System.out.println("\n\nAtenção! Verifique os códigos CRC ao final da conversão!");
            
            System.out.println("\nTabela finalizada. (" + getTABELA() + ")");
             
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