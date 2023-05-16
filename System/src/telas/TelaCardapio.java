
package telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class TelaCardapio extends javax.swing.JFrame {

 
    public TelaCardapio() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRodizio = new javax.swing.JLabel();
        cmbRodizio = new javax.swing.JComboBox<>();
        btnPedido = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblRodizio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRodizio.setText("Escolha seu rodízio:");
        getContentPane().add(lblRodizio);
        lblRodizio.setBounds(10, 10, 200, 50);

        cmbRodizio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "    ", "Rodízio Individual", "Rodízio Especial", "Rodízio Premium" }));
        cmbRodizio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRodizioActionPerformed(evt);
            }
        });
        getContentPane().add(cmbRodizio);
        cmbRodizio.setBounds(40, 50, 120, 60);

        btnPedido.setText("Confirmar Pedido");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPedido);
        btnPedido.setBounds(530, 310, 130, 70);

        setSize(new java.awt.Dimension(756, 430));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbRodizioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRodizioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRodizioActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto", "root", "1910");
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM cardapio WHERE nome = ? ");
            
            st.setString(1, cmbRodizio.getSelectedItem().toString());

            ResultSet resultado = st.executeQuery();

            if (resultado.next()) {
                                JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso");


            } else {
                JOptionPane.showMessageDialog(null, "Matricula de funcionário não encontrada, tente novamente");
            }

        } catch (ClassNotFoundException x) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado " + x.getMessage());
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados " + x.getMessage());
        }
    }//GEN-LAST:event_btnPedidoActionPerformed


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
            java.util.logging.Logger.getLogger(TelaCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCardapio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnPedido;
    private javax.swing.JComboBox<String> cmbRodizio;
    private javax.swing.JLabel lblRodizio;
    // End of variables declaration//GEN-END:variables
}
