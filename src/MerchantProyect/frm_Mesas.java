/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MerchantProyect;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author santiago
 */
public class frm_Mesas extends javax.swing.JFrame {

    /**
     * Creates new form frm_Mesas
     */
    DefaultTableModel Mesas;
    public frm_Mesas() {
        initComponents();
        this.Mesas = (DefaultTableModel) TablaMesa.getModel();
        Combo();
    }
        public final void Combo(){
        TableColumn Pro = TablaMesa.getColumnModel().getColumn(1);
        TableColumn Can = TablaMesa.getColumnModel().getColumn(2);
        JComboBox Productos = new JComboBox();
        JComboBox Cantidad = new JComboBox();
        //        Productos.addItem("");
        //        Productos.addItem("");
        //        Productos.addItem("");
        //        Productos.addItem("");
        //        Productos.addItem("");
        //        Productos.addItem("");
        Pro.setCellEditor(new DefaultCellEditor(Productos));
        Can.setCellEditor(new DefaultCellEditor(Cantidad));
        TablaMesa.revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_AgregarM = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMesa = new javax.swing.JTable();
        lbl_Fondo = new javax.swing.JLabel();
        btn_BorrarM = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        btn_Regresar = new javax.swing.JButton();
        lbl_Mensaje = new javax.swing.JLabel();
        lbl_Bienvenido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_AgregarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/plus_64.png"))); // NOI18N
        btn_AgregarM.setToolTipText("Agregar Mesa");
        btn_AgregarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarMActionPerformed(evt);
            }
        });

        TablaMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Mesas", "Productos", "Cantidad", "Total", "Mesero/a"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaMesa);
        if (TablaMesa.getColumnModel().getColumnCount() > 0) {
            TablaMesa.getColumnModel().getColumn(0).setResizable(false);
            TablaMesa.getColumnModel().getColumn(1).setResizable(false);
            TablaMesa.getColumnModel().getColumn(2).setResizable(false);
            TablaMesa.getColumnModel().getColumn(3).setResizable(false);
            TablaMesa.getColumnModel().getColumn(4).setResizable(false);
        }

        lbl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/food.png"))); // NOI18N

        btn_BorrarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/delete_64.png"))); // NOI18N
        btn_BorrarM.setToolTipText("Borrar Mesa");
        btn_BorrarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BorrarMActionPerformed(evt);
            }
        });

        btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/key_64.png"))); // NOI18N
        btn_Salir.setToolTipText("Salir");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });

        btn_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/buy_64.png"))); // NOI18N
        btn_Regresar.setToolTipText("Regresar");
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });

        lbl_Mensaje.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lbl_Mensaje.setForeground(new java.awt.Color(51, 51, 255));

        lbl_Bienvenido.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lbl_Bienvenido.setText("Bienvenido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_AgregarM)
                            .addComponent(btn_BorrarM)
                            .addComponent(btn_Salir))
                        .addGap(204, 204, 204)
                        .addComponent(lbl_Fondo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Regresar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_Bienvenido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btn_AgregarM)
                        .addGap(12, 12, 12)
                        .addComponent(btn_BorrarM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Salir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_Fondo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Regresar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AgregarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarMActionPerformed
        try{
        String dato[] = new String[5];
               dato[0] = JOptionPane.showInputDialog(null, "Coloque la Mesa");
               dato[1] = "";
               dato[2] = "";
               dato[3] = "";
               dato[4] = lbl_Mensaje.getText();
               Mesas.addRow(dato);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "error "+ex);
            
        }
    }//GEN-LAST:event_btn_AgregarMActionPerformed

    private void btn_BorrarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarMActionPerformed
        
    }//GEN-LAST:event_btn_BorrarMActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        //Boton para salir a la pantalla de Accesso
        try{
        this.setVisible(false); // Esconde el formulario
        new frm_Acceso().setVisible(true); // Abre el formulario objetivo
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "error "+ex);
            
        }
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed
        //Boton para salir a la pantalla principal de venta
        String usu = lbl_Mensaje.getText();
        try{
        frm_Main mf = new frm_Main();
                    mf.setVisible(true);
                    mf.pack();
                    mf.setLocationRelativeTo(null);
                    mf.lbl_Mensaje.setText(usu);
                    this.dispose();
                    }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }//GEN-LAST:event_btn_RegresarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frm_Mesas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaMesa;
    private javax.swing.JButton btn_AgregarM;
    private javax.swing.JButton btn_BorrarM;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Bienvenido;
    private javax.swing.JLabel lbl_Fondo;
    public javax.swing.JLabel lbl_Mensaje;
    // End of variables declaration//GEN-END:variables
}
