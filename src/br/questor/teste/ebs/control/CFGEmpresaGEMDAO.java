package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.CFGEmpresaGEM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CFGEmpresaGEMDAO extends CFGEmpresaGEM{
      
    public void CFGEmpresaGEMQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT \n" +
"	CRDESTABELECIMENTO.cd_empresa AS CODIGOEMPRESA,\n" +
"	CASE\n" +
"		WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.cd_estabelecimento)) IS NULL THEN 999\n" +
"		WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.cd_estabelecimento)) = 0 THEN 999\n" +
"		WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.cd_estabelecimento)) > 10 THEN 999\n" +
"		ELSE RTRIM(LTRIM(CRDESTABELECIMENTO.cd_estabelecimento))\n" +
"    END AS SOCIORESPCNPJ,\n" +
"	CASE\n" +
"		WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.cd_responsavel_caged)) IS NULL THEN 999\n" +
"		WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.cd_responsavel_caged)) = 0 THEN 999\n" +
"		WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.cd_responsavel_caged)) > 10 THEN 999\n" +
"		ELSE RTRIM(LTRIM(CRDESTABELECIMENTO.cd_responsavel_caged))\n" +
"    END AS CONTADORRESPCNPJ,\n" +
"    CASE\n" +
"		WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.cd_responsavel_sefip)) IS NULL THEN 999\n" +
"		WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.cd_responsavel_sefip)) = 0 THEN 999\n" +
"		WHEN RTRIM(LTRIM(CRDESTABELECIMENTO.cd_responsavel_sefip)) > 10 THEN 999\n" +
"		ELSE RTRIM(LTRIM(CRDESTABELECIMENTO.cd_responsavel_sefip))\n" +
"    END AS CONTADORRESPPREENCHFEDERAL\n" +
"FROM CRDESTABELECIMENTO CRDESTABELECIMENTO\n" +
"WHERE CRDESTABELECIMENTO.cd_empresa NOT IN (9991,9992,9993,9994,9995,9996,9997,9998,9999) \n" +
"AND CRDESTABELECIMENTO.cd_estabelecimento = 1\n" +
"ORDER BY CODIGOEMPRESA;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA (rs.getInt("CODIGOEMPRESA"));
                setCONTADORRESPCNPJ(rs.getInt("CONTADORRESPCNPJ"));
                setCONTADORRESPPREENCHFEDERAL(rs.getInt("CONTADORRESPPREENCHFEDERAL"));
                setSOCIORESPCNPJ(rs.getInt("SOCIORESPCNPJ"));

                    ps2 = con2.prepareStatement ("INSERT INTO CFGEMPRESAGEM (\n" +
"	CODIGOEMPRESA,\n" +
"	CONTADORRESPCNPJ,\n" +
"	CONTADORRESPPREENCHFEDERAL,\n" +
"	SOCIORESPCNPJ,\n" +
"	TIPOENQUAD,\n" +
"	INICIOFOLHALIVRO,\n" +
"	TIPOASSINATURA,\n" +
"	DESCRLIVRO,\n" +
"	LIMITEFOLHALIVRO,\n" +
"	DESCRFOLHALIVRO,\n" +
"	TIPOINFCABECALHO,\n" +
"	USAGRUPESSOAPADRAO,\n" +
"	USAPESSOACONTACTBAUTO,\n" +
"	MASCGRUPOPRODUTO,\n" +
"	USAREFERENCIAPROD,\n" +
"	LIVROMODELO7,\n" +
"	MASCCLASSIFFISCALPROD,\n" +
"	USALINHAASSINATURA)\n" +
"VALUES(?,?,?,?,1,2,1,'livro',500,'Folha',1,1,1,'99.999',1,1,'9999.99.99',0);");
                    
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.setInt(2, this.getCONTADORRESPCNPJ());
                    ps2.setInt(3, this.getCONTADORRESPPREENCHFEDERAL());
                    ps2.setInt(4, this.getSOCIORESPCNPJ());
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