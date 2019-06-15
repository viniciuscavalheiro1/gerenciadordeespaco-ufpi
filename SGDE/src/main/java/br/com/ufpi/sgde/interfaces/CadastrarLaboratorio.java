/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpi.sgde.interfaces;

import br.com.ufpi.sgde.funcoes.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class CadastrarLaboratorio extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarLaboratorio
     */
    public CadastrarLaboratorio() {
        initComponents();
        capacidade.setDocument(new Apenasnumeros());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        n = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ac = new javax.swing.JLabel();
        capacidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        bloco = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Observacoes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Laboratório");
        getContentPane().setLayout(null);

        n.setText("Nome");
        getContentPane().add(n);
        n.setBounds(90, 220, 80, 16);

        jLabel2.setText("Bloco");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 180, 60, 16);
        getContentPane().add(nome);
        nome.setBounds(280, 210, 330, 33);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel3.setText("CADASTRO DE LABORATÓRIO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 140, 200, 16);

        ac.setText("Capacidade");
        getContentPane().add(ac);
        ac.setBounds(90, 260, 140, 16);
        getContentPane().add(capacidade);
        capacidade.setBounds(280, 250, 330, 33);

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(350, 390, 120, 40);

        bloco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administração", "Biologia/Nutricao", "Enfermagem/Pedagogia", "História/Educação do campo", "Sistemas de Informação/Letras", "Matemática", "Medicina" }));
        getContentPane().add(bloco);
        bloco.setBounds(280, 170, 330, 33);

        Observacoes.setColumns(20);
        Observacoes.setRows(5);
        jScrollPane1.setViewportView(Observacoes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 290, 330, 82);

        jLabel1.setText("Observações");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 320, 120, 16);

        jLabel4.setIcon(new javax.swing.ImageIcon("/home/vinicius/gerenciadordeespaco-ufpi/SGDE/src/main/java/br/com/ufpi/sgde/imagens/icons8-microscópio-100.png")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(320, 10, 148, 110);

        jButton2.setIcon(new javax.swing.ImageIcon("/home/vinicius/gerenciadordeespaco-ufpi/SGDE/src/main/java/br/com/ufpi/sgde/imagens/icons8-à-esquerda-dentro-de-um-círculo-24.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 390, 34, 34);

        setSize(new java.awt.Dimension(756, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 String verifica = null;
  String cadastra = null;
        try {
            verifica = Client.enviarServidor("3,"+"Sala,"+nome.getText());
        } catch (IOException ex) {
            Logger.getLogger(CadastrarLaboratorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarLaboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
           String[] achou = verifica.split(",");
            if(achou[0].equals("null")){
               
     try {
         cadastra = Client.enviarServidor("4,"+"Laboratorio,"+nome.getText()+","+capacidade.getText()+","+bloco.getSelectedItem()+","+Observacoes.getText());
     } catch (IOException | ClassNotFoundException ex) {
         Logger.getLogger(CadastrarLaboratorio.class.getName()).log(Level.SEVERE, null, ex);
     }
                    if (cadastra.equals("erro")){
                        JOptionPane.showMessageDialog(null,"Ocorreu algum erro, tente novamente");
                    }else{
                         JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
                    }
            }else{
                    JOptionPane.showMessageDialog(null,"Ja existe uma Laboratório com esse nome");
            }      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarLaboratorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Observacoes;
    private javax.swing.JLabel ac;
    private javax.swing.JComboBox<String> bloco;
    private javax.swing.JTextField capacidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel n;
    private javax.swing.JTextField nome;
    // End of variables declaration//GEN-END:variables
}
