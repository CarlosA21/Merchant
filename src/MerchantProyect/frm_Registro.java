/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MerchantProyect;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santiago
 */
public class frm_Registro extends javax.swing.JFrame {

    /**
     * Creates new form frm_Registro
     */
    DefaultTableModel Empleado;

    public frm_Registro() {
        initComponents();
        this.Empleado = (DefaultTableModel) tablaemp.getModel();
         Mostrardatos("");
    }
    public void RefrescarTabla(){
        //Funcion encargada de Refrescar la tabla utilizando Revalidate
        Empleado.setColumnCount(0);
        Empleado.setRowCount(0);
        tablaemp.revalidate();
    }
    public void Comprobar(){
        //Funcion encargada de comprobar si existe informacion en los text fields para activar los botones de Agregar, Modificar y Borrar
        if(txt_Usuario.getText().isEmpty()) {
        btn_Reg.setEnabled(false);
        btn_Actualizar.setEnabled(false);
        btn_Borrar.setEnabled(false);    
        }
        else {
        btn_Reg.setEnabled(true);
        btn_Actualizar.setEnabled(true);
        btn_Borrar.setEnabled(true);
        }
    }
    
    public final void Mostrardatos(String valor){
        //Funcion para llenar la jtable de productos desde la BD
        MyConnection cc=new MyConnection();
        Connection cn=MyConnection.getConnection();
        RefrescarTabla();
        Empleado.addColumn("ID");
        Empleado.addColumn("Nombre");
        Empleado.addColumn("Apellido");
        Empleado.addColumn("Usuario");
        Empleado.addColumn("Contraseña");
 
        this.tablaemp.setModel(Empleado);
        String sql;
        if (valor.equals(""))
        {
        sql="SELECT * FROM Usuario";
        }
            else{
            sql="SELECT * FROM Usuario WHERE (Usuario='"+valor+"')";
            } 
        String []datos=new String [5];
        try{
            
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        
        while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
        
        Empleado.addRow(datos);
        }
        tablaemp.setModel(Empleado);
        }catch(SQLException ex){
        Logger.getLogger(frm_Registro.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void RestriccionLetras(java.awt.event.KeyEvent evt){
        //Funcion que solo te permite escribir numeros en un text field predeterminado
        try{
            boolean doBeep;
    final char c = evt.getKeyChar();
    switch (c) {
        case KeyEvent.VK_BACK_SPACE: 
        case KeyEvent.VK_DELETE:
            doBeep = false;
            break;
        default:
            doBeep = !Character.isDigit(c);
    }
    if (doBeep){
        getToolkit().beep();
        evt.consume();
}
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
    public void RestriccionNumeros(java.awt.event.KeyEvent evt){
        //Funcion que solo te permite escribir letras en un text field predeterminado
        try{
            boolean doBeep;
    final char c = evt.getKeyChar();
    switch (c) {
        case KeyEvent.VK_BACK_SPACE: 
        case KeyEvent.VK_DELETE:
        case KeyEvent.VK_SPACE:
            doBeep = false;
            break;
        default:
            doBeep = !Character.isLetter(c);
    }
    if (doBeep){
        getToolkit().beep();
        evt.consume();
}
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
    
    public void Limpiar (){
        //Funcion para limpiar los text fields
        txt_Nom.setText("");
        txt_Ape.setText("");
        txt_Usuario.setText("");
        txtp_Contra.setText("");
    }
    public boolean revisarUsuario(String usuario) {
        //Funcion para revisar si el usuario existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean revisar = false;
        String query = "SELECT * FROM `Usuario` WHERE `Usuario` =?";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, usuario);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                revisar = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(frm_Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
         return revisar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtp_Contra = new javax.swing.JPasswordField();
        lbl_Usuario = new javax.swing.JLabel();
        txt_Usuario = new javax.swing.JTextField();
        lbl_Contra = new javax.swing.JLabel();
        lbl_Nom = new javax.swing.JLabel();
        txt_Nom = new javax.swing.JTextField();
        lbl_Ape = new javax.swing.JLabel();
        txt_Ape = new javax.swing.JTextField();
        btn_Reg = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaemp = new javax.swing.JTable();
        btn_Nuevo = new javax.swing.JButton();
        lbl_Bienvenido = new javax.swing.JLabel();
        lbl_Mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Merchant Registro");
        setName("Registro"); // NOI18N
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Bloquear(evt);
            }
        });

        lbl_Usuario.setText("Usuario:");

        txt_Usuario.setToolTipText("Buscar Usuario");
        txt_Usuario.setNextFocusableComponent(txtp_Contra);
        txt_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Busqueda(evt);
            }
        });

        lbl_Contra.setText("Contraseña:");

        lbl_Nom.setText("Nombre:");

        txt_Nom.setNextFocusableComponent(txt_Ape);
        txt_Nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NomKeyTyped(evt);
            }
        });

        lbl_Ape.setText("Apellido:");

        txt_Ape.setNextFocusableComponent(txt_Usuario);
        txt_Ape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ApeKeyTyped(evt);
            }
        });

        btn_Reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/save_64.png"))); // NOI18N
        btn_Reg.setToolTipText("Registrar");
        btn_Reg.setEnabled(false);
        btn_Reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegActionPerformed(evt);
            }
        });

        btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/home_64.png"))); // NOI18N
        btn_Salir.setToolTipText("Salir");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });

        btn_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/trash_64.png"))); // NOI18N
        btn_Borrar.setToolTipText("Borrar");
        btn_Borrar.setEnabled(false);
        btn_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BorrarActionPerformed(evt);
            }
        });

        btn_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/pencil_64.png"))); // NOI18N
        btn_Actualizar.setToolTipText("Actualizar");
        btn_Actualizar.setEnabled(false);
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });

        tablaemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rellenar(evt);
            }
        });
        jScrollPane2.setViewportView(tablaemp);

        btn_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/document_64.png"))); // NOI18N
        btn_Nuevo.setToolTipText("Nuevo");
        btn_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NuevoActionPerformed(evt);
            }
        });

        lbl_Bienvenido.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lbl_Bienvenido.setText("Bienvenido:");

        lbl_Mensaje.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lbl_Mensaje.setForeground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Contra)
                            .addComponent(lbl_Usuario)
                            .addComponent(lbl_Nom)
                            .addComponent(lbl_Ape))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Usuario)
                            .addComponent(txtp_Contra, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txt_Nom)
                            .addComponent(txt_Ape))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Reg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Actualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Borrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Salir))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_Bienvenido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_Nom)
                                .addComponent(txt_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_Bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Ape)
                            .addComponent(txt_Ape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Usuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Contra)
                            .addComponent(txtp_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_Salir)
                    .addComponent(btn_Nuevo)
                    .addComponent(btn_Reg)
                    .addComponent(btn_Actualizar)
                    .addComponent(btn_Borrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegActionPerformed
        //Boton para registrar datos nuevos a la BD
        String nom = txt_Nom.getText();
        String ape = txt_Ape.getText();
        String usu = txt_Usuario.getText();
        String cont = String.valueOf(txtp_Contra.getPassword());
                
        if(usu.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un Usuario");
        }
        
        else if(cont.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega una Contraseña");
        }      
        else if(revisarUsuario(usu))
        {
            JOptionPane.showMessageDialog(null, "Este Usuario ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `Usuario`(`Nombre`, `Apellido`, `Usuario`, `Contraseña`) VALUES (?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, nom);
            ps.setString(2, ape);
            ps.setString(3, usu);
            ps.setString(4, cont);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo Usuario Agregado");
                Limpiar();
                Mostrardatos("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    }//GEN-LAST:event_btn_RegActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        //Boton para actualizar los datos de la tabla en la BD
        String id = (String) Empleado.getValueAt(tablaemp.getSelectedRow(),0);
        String nom = txt_Nom.getText();
        String ape = txt_Ape.getText();
        String usu = txt_Usuario.getText();
        String cont = String.valueOf(txtp_Contra.getPassword());
        PreparedStatement ps;
        String query = "UPDATE Usuario SET Nombre=?, Apellido=?, Usuario=?, Contraseña=? WHERE idUsuario=?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            
            ps.setString(5, id);
            ps.setString(1, nom);
            ps.setString(2, ape);
            ps.setString(3, usu);
            ps.setString(4, cont);
           
            ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario a sido modificado");
                Limpiar();
                Mostrardatos("");
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        //Boton para borrar un dato de la tabla en la BD
        String id = (String) Empleado.getValueAt(tablaemp.getSelectedRow(),0);   
        PreparedStatement ps;
        String query = "DELETE FROM Usuario WHERE idUsuario=?";
            try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, id);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Usuario Eliminado!");
                Limpiar();
                Mostrardatos("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
    }//GEN-LAST:event_btn_BorrarActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
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
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void txt_NomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NomKeyTyped
        //Evento utilizando la funcion RestriccionNumeros
        RestriccionNumeros(evt);
    }//GEN-LAST:event_txt_NomKeyTyped

    private void txt_ApeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ApeKeyTyped
        //Evento utilizando la funcion RestriccionLetras
        RestriccionNumeros(evt);
    }//GEN-LAST:event_txt_ApeKeyTyped

    private void Rellenar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rellenar
        //Evento dentro de la tabla que llena los datos de los text field con los de la tabla
        try {
        //int ID = (int) Empleado.getValueAt(tablaemp.getSelectedRow(),0);  
        String Nombre = (String) Empleado.getValueAt(tablaemp.getSelectedRow(),1);
        String Apellido = (String) Empleado.getValueAt(tablaemp.getSelectedRow(),2);
        String Usuario = (String) Empleado.getValueAt(tablaemp.getSelectedRow(),3);
        String Contraseña = (String) Empleado.getValueAt(tablaemp.getSelectedRow(),4);
        txt_Nom.setText(Nombre);
        txt_Ape.setText(Apellido);
        txt_Usuario.setText(Usuario);
        txtp_Contra.setText(Contraseña);
        }
        catch (Exception ex){
        JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }//GEN-LAST:event_Rellenar

    private void Busqueda(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Busqueda
        //Evento Busquedad para buscar los datos del producto escribiendo el nombre
        try {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String B = txt_Usuario.getText();
        Mostrardatos(B);
            }
        }
        catch (Exception ex){
        JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }//GEN-LAST:event_Busqueda

    private void Bloquear(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bloquear
        //Evento utilizando la funcion Comprobar
        Comprobar();
    }//GEN-LAST:event_Bloquear

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
        //Boton con la funcion Limpiar, La Funcion Mostardatos, La Funcion Comprobar
        Limpiar();
        Mostrardatos("");
        Comprobar();
    }//GEN-LAST:event_btn_NuevoActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frm_Registro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_Reg;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Ape;
    private javax.swing.JLabel lbl_Bienvenido;
    private javax.swing.JLabel lbl_Contra;
    public javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_Nom;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JTable tablaemp;
    private javax.swing.JTextField txt_Ape;
    private javax.swing.JTextField txt_Nom;
    private javax.swing.JTextField txt_Usuario;
    private javax.swing.JPasswordField txtp_Contra;
    // End of variables declaration//GEN-END:variables
}
