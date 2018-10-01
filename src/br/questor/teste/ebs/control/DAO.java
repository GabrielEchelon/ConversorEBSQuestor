package br.questor.teste.ebs.control;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    
    protected static String enderecoSQL = null;
    protected static String portaSQL = null;
    protected static String nomeSQL = null;
    protected static String usernameSQL = null;
    protected static String passwordSQL = null;
    protected static String conexaoSQL = null;
    
    protected static String enderecoQST = null;
    protected static String portaQST = null;
    protected static String aliaseQST = null;
    protected static String usernameQST = null;
    protected static String passwordQST = null;
    protected static String conexaoQST = null;
       
    public static Connection getConnectionSQLServer() throws Exception{

        conexaoSQL = "jdbc:sqlserver://" + enderecoSQL + ":" + portaSQL + ";databaseName=" + nomeSQL;
                
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        return DriverManager.getConnection(conexaoSQL, usernameSQL, passwordSQL);
    }
    
    public static Connection getConnectionISQL() throws Exception{
        if(enderecoQST == null){
            conexaoQST = "jdbc:firebirdsql:localhost/" + portaQST + ":" + aliaseQST + "?encoding=ISO8859_1";
        
            Class.forName("org.firebirdsql.jdbc.FBDriver");
        } else {
            conexaoQST = "jdbc:firebirdsql:localhost/" + portaQST + ":" + enderecoQST + "?encoding=ISO8859_1";
        
            Class.forName("org.firebirdsql.jdbc.FBDriver");
        }
        return DriverManager.getConnection(conexaoQST, usernameQST, passwordQST);
    }
    
    public static String formatException (Throwable thr) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter (sw);
        thr.printStackTrace (pw);
        return sw.toString();
    }

    public static String getEnderecoSQL() {
        return enderecoSQL;
    }

    public static void setEnderecoSQL(String enderecoSQL) {
        DAO.enderecoSQL = enderecoSQL;
    }

    public static String getPortaSQL() {
        return portaSQL;
    }

    public static void setPortaSQL(String portaSQL) {
        DAO.portaSQL = portaSQL;
    }

    public static String getNomeSQL() {
        return nomeSQL;
    }

    public static void setNomeSQL(String nomeSQL) {
        DAO.nomeSQL = nomeSQL;
    }

    public static String getUsernameSQL() {
        return usernameSQL;
    }

    public static void setUsernameSQL(String usernameSQL) {
        DAO.usernameSQL = usernameSQL;
    }

    public static String getPasswordSQL() {
        return passwordSQL;
    }

    public static void setPasswordSQL(String passwordSQL) {
        DAO.passwordSQL = passwordSQL;
    }

    public static String getConexaoSQL() {
        return conexaoSQL;
    }

    public static void setConexaoSQL(String conexaoSQL) {
        DAO.conexaoSQL = conexaoSQL;
    }

    public static String getEnderecoQST() {
        return enderecoQST;
    }

    public static void setEnderecoQST(String enderecoQST) {
        DAO.enderecoQST = enderecoQST;
    }

    public static String getPortaQST() {
        return portaQST;
    }

    public static void setPortaQST(String portaQST) {
        DAO.portaQST = portaQST;
    }

    public static String getAliaseQST() {
        return aliaseQST;
    }

    public static void setAliaseQST(String aliaseQST) {
        DAO.aliaseQST = aliaseQST;
    }

    public static String getUsernameQST() {
        return usernameQST;
    }

    public static void setUsernameQST(String usernameQST) {
        DAO.usernameQST = usernameQST;
    }

    public static String getPasswordQST() {
        return passwordQST;
    }

    public static void setPasswordQST(String passwordQST) {
        DAO.passwordQST = passwordQST;
    }

    public static String getConexaoQST() {
        return conexaoQST;
    }

    public static void setConexaoQST(String conexaoQST) {
        DAO.conexaoQST = conexaoQST;
    }
    
    
    
}