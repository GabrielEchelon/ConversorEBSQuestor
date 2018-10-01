package br.questor.teste.ebs.control;

import br.questor.teste.ebs.model.QST_FuncLocal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QST_FuncLocalDAO extends QST_FuncLocal{
    
   public void qstfunclocalQuery() throws Exception{
        
        Connection con = DAO.getConnectionISQL();
        PreparedStatement ps = null;
        
        Connection con2 = DAO.getConnectionISQL();
        PreparedStatement ps2 = null;
        
        try{
            ps = con.prepareStatement("SELECT CODIGOEMPRESA, CODIGOFUNCCONTR, DATAADM,\n" +
                "CURRENT_TIMESTAMP AS DATAHORACADAST\n" +
                "FROM FUNCCONTRATO\n" +
                "ORDER BY CODIGOEMPRESA, CODIGOFUNCCONTR;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.print("-");
                
                setCODIGOEMPRESA(rs.getInt("CODIGOEMPRESA"));
                setCODIGOFUNCCONTR(rs.getInt("CODIGOFUNCCONTR"));
                setDATAADM(rs.getDate("DATAADM"));
                setDATAHORACADAST(rs.getDate("DATAHORACADAST"));
                
                ps2 = con2.prepareStatement("SELECT CLASSIFORGAN FROM ORGANOGRAMA\n" +
                "WHERE CODIGOEMPRESA = ?");
                ps2.setInt(1, getCODIGOEMPRESA());
                
                ResultSet rs3 = ps2.executeQuery();
                if (!rs3.next()){
                    System.out.print("+");
                    ps2 = con2.prepareStatement ("INSERT INTO ORGANOGRAMA (CODIGOEMPRESA, CODIGOESTAB, CLASSIFORGAN, DESCRORGAN, TIPOCONTA, ATIVIDADESIMPLES)\n" +
                    "VALUES (?,1,'001','Geral',2,0);");
                    ps2.setInt(1, this.getCODIGOEMPRESA());
                    ps2.executeUpdate();
                    setCLASSIFORGAN("001");
                } else{
                    setCLASSIFORGAN(rs3.getString("CLASSIFORGAN"));
                }
                
                ps2 = con2.prepareStatement ("SELECT CODIGOEMPRESA, CODIGOFUNCCONTR, DATATRANSF,\n" +
                    "CURRENT_TIMESTAMP AS DATAHORACADAST\n" +
                    "FROM FUNCLOCAL \n" +
                    "WHERE CODIGOEMPRESA = ?\n" +
                    "AND CODIGOFUNCCONTR = ?;");
                ps2.setInt(1, getCODIGOEMPRESA());
                ps2.setInt(2, getCODIGOFUNCCONTR());
                
                ResultSet rs2 = ps2.executeQuery();
                
                if (!rs2.next()) { 
                    System.out.print(">");
                    
                    ps2 = con2.prepareStatement("INSERT INTO FUNCLOCAL (CODIGOEMPRESA, CODIGOFUNCCONTR, DATATRANSF,\n" +
                        " CODIGOESTAB, CLASSIFORGAN, DATAHORACADAST,\n" +
                        "CODIGOMOTIVO, TIPOADMRAIS, TIPOADMCAGED, TIPOADM, TIPOTRANSF, INDICATADM)\n" +
                        "VALUES (?,?,?,1,?,?,1,1,10,1,1,1);");
                        
                    ps2.setInt(1, getCODIGOEMPRESA());
                    ps2.setInt(2, getCODIGOFUNCCONTR());
                    ps2.setDate(3, getDATAADM());
                    ps2.setString(4, getCLASSIFORGAN());
                    ps2.setDate(5, getDATAHORACADAST());
                    
                    ps2.executeUpdate();
                    
                }
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
            if(ps2 != null){
                ps2.close();
            }
            if(con2 != null){
                con2.close();
            }
        }
    } 
    
}
