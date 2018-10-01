package br.questor.teste.ebs.control;


import br.questor.teste.ebs.model.FuncLocal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncLocalDAO extends FuncLocal{
      
    public void funclocalQuery() throws Exception{
        
        Connection con = DAO.getConnectionSQLServer();
        PreparedStatement ps = null;
        
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT	cd_empresa_origem AS CODIGOEMPRESA,\n" +
"		cd_funcionario_origem AS CODIGOFUNCCONTR,\n" +
"		dt_transferencia AS DATATRANSF,\n" +
"		CURRENT_TIMESTAMP AS DATAHORACADAST\n" +
"FROM CRHFunTransferenciaEmpresas\n" +
"ORDER BY CODIGOEMPRESA, CODIGOFUNCCONTR;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                System.out.print(".");
                
                setCODIGOEMPRESA(rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR(rs.getInt("CODIGOFUNCCONTR"));
                setDATATRANSF(rs.getDate("DATATRANSF"));
                setDATAHORACADAST(rs.getDate("DATAHORACADAST"));

                ps2 = con2.prepareStatement ("INSERT INTO FUNCLOCAL (CODIGOEMPRESA, CODIGOFUNCCONTR, DATATRANSF, CODIGOESTAB, CLASSIFORGAN, DATAHORACADAST,\n" +
"CODIGOMOTIVO, TIPOADMRAIS, TIPOADMCAGED, TIPOADM, TIPOTRANSF, INDICATADM)\n" +
"VALUES (?,?,?,1,'001',?,1,1,10,1,1,1);");
                    
                    ps2.setInt(1, getCODIGOEMPRESA());
                    ps2.setInt(2, getCODIGOFUNCCONTR());
                    ps2.setDate(3, getDATATRANSF());
                    ps2.setDate(4, getDATAHORACADAST());

                    ps2.executeUpdate();
            }
            
            
            
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