package br.questor.teste.ebs.model;

import br.questor.teste.ebs.view.Conectar;

public class Principal {

    public static void main(String[] args) {
       //<editor-fold defaultstate="collapsed" desc="Look and feel">
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Windows".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } 
       //</editor-fold>
       
       java.awt.EventQueue.invokeLater(new Runnable(){
           public void run(){
               new Conectar().setVisible(true);
           }
       });
    }
}