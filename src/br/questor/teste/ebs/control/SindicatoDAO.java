package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.Sindicato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SindicatoDAO extends Sindicato{
      
    public void sindicatoQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY SINDICATO.cd_sindicato ASC)AS CODIGOSIND,\n" +
"	LEFT(RTRIM(LTRIM(SINDICATO.descricao)),50) AS NOMESIND,\n" +
"	RTRIM(LTRIM(SINDICATO.sigla)) AS SIGLASIND,\n" +
"	RTRIM(LTRIM(SINDICATO.codigo_entidade)) AS CODIGOENTID,\n" +
"	RTRIM(LTRIM(SINDICATO.endereco)) AS ENDERSIND,\n" +
"	RTRIM(LTRIM(SINDICATO.nr_endereco)) AS NUMEROENDER,\n" +
"	RTRIM(LTRIM(SINDICATO.compl_endereco)) AS COMPLENDER,\n" +
"	RTRIM(LTRIM(SINDICATO.bairro)) AS BAIRROSIND,\n" +
"	RTRIM(LTRIM(SINDICATO.estado)) AS SIGLAESTADO,\n" +
"	QST_MUNICIPIO.CODIGOMUNIC AS CODIGOMUNIC,\n" +
"	CONCAT(LEFT(SINDICATO.cep,2), '.',RIGHT(LEFT(SINDICATO.cep,5),3), '-', RIGHT(SINDICATO.cep,3)) AS CEPSIND,\n" +
"	RTRIM(LTRIM(SINDICATO.ddd_fone)) AS DDDFONE,\n" +
"	RTRIM(LTRIM(SINDICATO.telefone)) AS NUMEROFONE,\n" +
"	RTRIM(LTRIM(SINDICATO.email)) AS ENDERELETR,\n" +
"	RTRIM(LTRIM(SINDICATO.site)) AS PAGINAINTER,\n" +
"	CASE \n" +
"		WHEN RTRIM(LTRIM(SINDICATO.cgc)) IS NULL THEN '11.111.111/1111-11'\n" +
"		WHEN RTRIM(LTRIM(SINDICATO.cgc)) LIKE ' ' THEN '11.111.111/1111-11'\n" +
"		ELSE RTRIM(LTRIM(SINDICATO.cgc))\n" +
"	END AS INSCRFEDERAL,\n" +
"	RTRIM(LTRIM(SINDICATO.tipo_entidade)) AS TIPOENTID,\n" +
"	RTRIM(LTRIM(SINDICATO.agencia)) AS NUMEROAGENCIA\n" +
"FROM sindicato AS SINDICATO\n" +
"LEFT JOIN QST_MUNICIPIO QST_MUNICIPIO \n" +
"ON SINDICATO.CIDADE = QST_MUNICIPIO.NOMEMUNIC;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOSIND (rs.getInt("CODIGOSIND"));
                setNOMESIND (rs.getString("NOMESIND"));
                setSIGLASIND (rs.getString("SIGLASIND"));
                setCODIGOENTID (rs.getString("CODIGOENTID"));
                setENDERSIND (rs.getString("ENDERSIND"));
                setNUMEROENDER (rs.getInt("NUMEROENDER"));
                setCOMPLENDER (rs.getString("COMPLENDER"));
                setBAIRROSIND (rs.getString("BAIRROSIND"));
                setSIGLAESTADO (rs.getString("SIGLAESTADO"));
                setCODIGOMUNIC (rs.getInt("CODIGOMUNIC"));
                setCEPSIND (rs.getString("CEPSIND"));
                setDDDFONE (rs.getInt("DDDFONE"));
                setNUMEROFONE (rs.getInt("NUMEROFONE"));
                setENDERELETR (rs.getString("ENDERELETR"));
                setPAGINAINTER (rs.getString("PAGINAINTER"));
                setINSCRFEDERAL (rs.getString("INSCRFEDERAL"));
                setTIPOENTID (rs.getInt("TIPOENTID"));
                setNUMEROAGENCIA (rs.getInt("NUMEROAGENCIA"));

                    ps2 = con2.prepareStatement ("INSERT INTO SINDICATO (CODIGOSIND, NOMESIND, DATAINICIAL, SIGLASIND, \n" +
"CODIGOENTID, ENDERSIND, NUMEROENDER, COMPLENDER, BAIRROSIND, SIGLAESTADO, \n" +
"CEPSIND, DDDFONE, NUMEROFONE, ENDERELETR, PAGINAINTER, PATRONAL, INSCRFEDERAL, \n" +
"TIPOENTID, NUMEROAGENCIA)\n" +
"VALUES (?,?,'1900-01-01',?,?,?,?,?,?,?,?,?,?,?,?,0,?,?,?);");
                    ps2.setInt(1, this.getCODIGOSIND());
                    ps2.setString(2, this.getNOMESIND());
                    ps2.setString(3, this.getSIGLASIND());
                    ps2.setString(4, this.getCODIGOENTID());
                    ps2.setString(5, this.getENDERSIND());
                    ps2.setInt(6, this.getNUMEROENDER());
                    ps2.setString(7, this.getCOMPLENDER());
                    ps2.setString(8, this.getBAIRROSIND());
                    ps2.setString(9, this.getSIGLAESTADO());
                    ps2.setInt(10, this.getCODIGOMUNIC());
                    ps2.setString(11, this.getCEPSIND());
                    ps2.setInt(12, this.getDDDFONE());
                    ps2.setInt(13, this.getNUMEROFONE());
                    ps2.setString(14, this.getENDERELETR());
                    ps2.setString(15, this.getPAGINAINTER());
                    ps2.setString(16, this.getINSCRFEDERAL());
                    ps2.setInt(17, this.getTIPOENTID());
                    ps2.setInt(18, this.getNUMEROAGENCIA());
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