/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author JoseGuerra
 */
public class Update_New_View extends javax.swing.JFrame {

    /**
     * Creates new form Save_New_View
     */
    public Update_New_View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txt_desc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        panelBtn2 = new javax.swing.JPanel();
        btn_editar = new javax.swing.JButton();
        panelBtn3 = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        panelBtn4 = new javax.swing.JPanel();
        btn_actualizar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        label_gif = new javax.swing.JLabel();
        cbm_palabra = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(54, 33, 89));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("EcuSign");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, 40));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 220, 10));

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 270, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Gif Configuration");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 40));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8_Sign_Language_100px.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 120, 160));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 430));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(54, 33, 89));
        jLabel4.setText("Update Gif");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(54, 33, 89));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8_Comments_20px.png"))); // NOI18N
        jLabel6.setText("Description");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jSeparator6.setBackground(new java.awt.Color(54, 33, 89));
        jSeparator6.setForeground(new java.awt.Color(54, 33, 89));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 270, 10));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(54, 33, 89));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8_GIF_20px.png"))); // NOI18N
        jLabel11.setText("Gif");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jSeparator7.setBackground(new java.awt.Color(54, 33, 89));
        jSeparator7.setForeground(new java.awt.Color(54, 33, 89));
        jPanel5.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 270, 10));

        txt_desc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_desc.setForeground(new java.awt.Color(54, 33, 89));
        txt_desc.setBorder(null);
        txt_desc.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txt_desc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_descFocusGained(evt);
            }
        });
        jPanel5.add(txt_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 270, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(54, 33, 89));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8_Dictionary_20px.png"))); // NOI18N
        jLabel12.setText("Word");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 270, 0));

        jSeparator10.setBackground(new java.awt.Color(54, 33, 89));
        jSeparator10.setForeground(new java.awt.Color(54, 33, 89));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 270, 10));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBtn2.setBackground(new java.awt.Color(54, 33, 89));
        panelBtn2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_editar.setBackground(new java.awt.Color(54, 33, 89));
        btn_editar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_editar.setForeground(new java.awt.Color(204, 204, 204));
        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8_Edit_20px_2.png"))); // NOI18N
        btn_editar.setText("Update Gif");
        btn_editar.setContentAreaFilled(false);
        btn_editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelBtn2.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jPanel6.add(panelBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 40));

        panelBtn3.setBackground(new java.awt.Color(54, 33, 89));
        panelBtn3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cancelar.setBackground(new java.awt.Color(255, 165, 0));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(204, 204, 204));
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8_Cancel_20px.png"))); // NOI18N
        btn_cancelar.setText("Cancel");
        btn_cancelar.setContentAreaFilled(false);
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelBtn3.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jPanel6.add(panelBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 120, 40));

        panelBtn4.setBackground(new java.awt.Color(54, 33, 89));
        panelBtn4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_actualizar.setBackground(new java.awt.Color(54, 33, 89));
        btn_actualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(204, 204, 204));
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8_Save_20px_1.png"))); // NOI18N
        btn_actualizar.setText("Save Gif");
        btn_actualizar.setContentAreaFilled(false);
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelBtn4.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jPanel6.add(panelBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 120, 40));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 440, 70));

        btn_buscar.setBackground(new java.awt.Color(54, 33, 89));
        btn_buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(54, 33, 89));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8_Open_20px.png"))); // NOI18N
        btn_buscar.setText("Select Gif");
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 270, 30));

        label_gif.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gif", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(54, 33, 89))); // NOI18N
        jPanel5.add(label_gif, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 190, 210));

        cbm_palabra.setForeground(new java.awt.Color(54, 33, 89));
        cbm_palabra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbm_palabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbm_palabraActionPerformed(evt);
            }
        });
        jPanel5.add(cbm_palabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 270, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 540, 430));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void txt_descFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_descFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descFocusGained

    private void cbm_palabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbm_palabraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbm_palabraActionPerformed

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
            java.util.logging.Logger.getLogger(Update_New_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_New_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_New_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_New_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_New_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_actualizar;
    public static javax.swing.JButton btn_buscar;
    public static javax.swing.JButton btn_cancelar;
    public static javax.swing.JButton btn_editar;
    public static javax.swing.JComboBox<String> cbm_palabra;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    public static javax.swing.JLabel label_gif;
    private javax.swing.JPanel panelBtn2;
    private javax.swing.JPanel panelBtn3;
    private javax.swing.JPanel panelBtn4;
    public static javax.swing.JTextField txt_desc;
    // End of variables declaration//GEN-END:variables
}
