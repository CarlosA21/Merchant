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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santiago
 */
public class frm_Productos extends javax.swing.JFrame {

    /**
     * Creates new form frm_Productos
     */
    DefaultTableModel Producto;
    
    public frm_Productos() {
        initComponents();
        this.Producto = (DefaultTableModel) tablaprod.getModel();
         Mostrardatos("");
         LlenarCombo();
    }
    
    public final void LlenarCombo(){
        try {
        // Create an array list to be filled with group names
        ArrayList<String> Categorias = new ArrayList<>();
        String query = "SELECT Nombre_Cat FROM Categoria"; 
        PreparedStatement stm = MyConnection.getConnection().prepareStatement(query);

        try (ResultSet rs = stm.executeQuery(query)) {
            while (rs.next()) {
                String categoria = rs.getString("Nombre_Cat");
                // add group names to the array list
                Categorias.add(categoria);
                        }
        } 
        // Populate the combo box
        DefaultComboBoxModel model = new DefaultComboBoxModel(Categorias.toArray());
        cmb_Cat.setModel(model);
    }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
    
    public void RefrescarTabla(){
        //Funcion encargada de Refrescar la tabla utilizando Revalidate
        try {
        Producto.setColumnCount(0);
        Producto.setRowCount(0);
        tablaprod.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
    public void Comprobar(){
        //Funcion encargada de comprobar si existe informacion en los text fields para activar los botones de Agregar, Modificar y Borrar        
        if(txt_Pro.getText().isEmpty()) {
        btn_Agregar.setEnabled(false);
        btn_Mod.setEnabled(false);
        btn_Borrar.setEnabled(false);
        cmb_Cat.setEnabled(false);
        }
        else {
        btn_Agregar.setEnabled(true);
        btn_Mod.setEnabled(true);
        btn_Borrar.setEnabled(true);
        cmb_Cat.setEnabled(true);
        }
    }
    
    public final void Mostrardatos(String valor){
        //Funcion para llenar la jtable de productos desde la BD
        MyConnection cc=new MyConnection();
        Connection cn=MyConnection.getConnection();
        RefrescarTabla();
        Producto.addColumn("ID");
        Producto.addColumn("Producto");
        Producto.addColumn("Precio");
        Producto.addColumn("Cantidad");
        Producto.addColumn("Categoria");
 
        this.tablaprod.setModel(Producto);
        String sql;
        if (valor.equals(""))
        {
        sql="SELECT * FROM Producto";
        }
        else{
        sql="SELECT * FROM Producto WHERE Producto='"+valor+"'";
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
 
        Producto.addRow(datos);
        }
        tablaprod.setModel(Producto);
        }catch(SQLException ex){
        Logger.getLogger(frm_Productos.class.getName()).log(Level.SEVERE,null,ex);
        JOptionPane.showMessageDialog(null, "error "+ex);
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
    public void Limpiar(){
        //Funcion para limpiar los text field existentes
        try{
        txt_Pro.setText("");
        txt_Precio.setText("");
        txt_Can.setText("");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
    
     public boolean revisarProducto(String producto) {
        //Funcion que retorna los productos para revisarlos
        PreparedStatement ps;
        ResultSet rs;
        boolean revisar = false;
        String query = "SELECT * FROM `Producto` WHERE `Producto` =?";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, producto);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                revisar = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(frm_Productos.class.getName()).log(Level.SEVERE, null, ex);
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

        lbl_Pro = new javax.swing.JLabel();
        txt_Pro = new javax.swing.JTextField();
        lbl_Precio = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaprod = new javax.swing.JTable();
        lbl_Can = new javax.swing.JLabel();
        txt_Can = new javax.swing.JTextField();
        btn_Nuevo = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();
        btn_Mod = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        btn_Regresar = new javax.swing.JButton();
        lbl_Cat = new javax.swing.JLabel();
        cmb_Cat = new javax.swing.JComboBox<>();
        lbl_Bienvenido = new javax.swing.JLabel();
        lbl_Mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Merchant Productos");
        setName("Productos"); // NOI18N
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Comprobar(evt);
            }
        });

        lbl_Pro.setText("Producto:");

        txt_Pro.setToolTipText("Busqueda Producto");
        txt_Pro.setNextFocusableComponent(txt_Precio);
        txt_Pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ProKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Busqueda(evt);
            }
        });

        lbl_Precio.setText("Precio:");

        txt_Precio.setNextFocusableComponent(txt_Can);
        txt_Precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PrecioKeyTyped(evt);
            }
        });

        tablaprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaprod.setName("Producto"); // NOI18N
        tablaprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RellenarT(evt);
            }
        });
        jScrollPane1.setViewportView(tablaprod);

        lbl_Can.setText("Cantidad:");

        txt_Can.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CanKeyTyped(evt);
            }
        });

        btn_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/document_64.png"))); // NOI18N
        btn_Nuevo.setToolTipText("Nuevo");
        btn_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NuevoActionPerformed(evt);
            }
        });

        btn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/save_64.png"))); // NOI18N
        btn_Agregar.setToolTipText("Agregar");
        btn_Agregar.setEnabled(false);
        btn_Agregar.setNextFocusableComponent(btn_Borrar);
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        btn_Mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/pencil_64.png"))); // NOI18N
        btn_Mod.setToolTipText("Modificar");
        btn_Mod.setEnabled(false);
        btn_Mod.setNextFocusableComponent(btn_Agregar);
        btn_Mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModActionPerformed(evt);
            }
        });

        btn_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/trash_64.png"))); // NOI18N
        btn_Borrar.setToolTipText("Borrar");
        btn_Borrar.setEnabled(false);
        btn_Borrar.setNextFocusableComponent(btn_Regresar);
        btn_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BorrarActionPerformed(evt);
            }
        });

        btn_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MerchantProyect/Icons/home_64.png"))); // NOI18N
        btn_Regresar.setToolTipText("Regresar");
        btn_Regresar.setNextFocusableComponent(jScrollPane1);
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });

        lbl_Cat.setText("Categoria:");

        cmb_Cat.setEnabled(false);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Cat)
                            .addComponent(lbl_Pro)
                            .addComponent(lbl_Can)
                            .addComponent(lbl_Precio))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_Can, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmb_Cat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btn_Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn_Mod, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Regresar))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_Bienvenido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_Pro)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Precio)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Can)
                            .addComponent(txt_Can, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Cat)
                            .addComponent(cmb_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Nuevo)
                            .addComponent(btn_Mod, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btn_Regresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Borrar, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
        //Boton con la funcion Limpiar, La Funcion Mostardatos, La Funcion Comprobar
        Limpiar();
        Mostrardatos("");
        Comprobar();
    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        //Boton Agregar comprueba si estan llenos los campos necesarios o si esta repetido el producto y lo agrega en la BD
        String pro = txt_Pro.getText();
        String pre = txt_Precio.getText();
        String can = txt_Can.getText();
        String cat = String.valueOf(cmb_Cat.getSelectedIndex());
                
        if(pro.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un Producto");
        }
        
        else if(pre.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un Precio");
        }      
        else if(revisarProducto(pro))
        {
            JOptionPane.showMessageDialog(null, "Este Producto ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `Producto`(`Producto`, `Precio`, `Cantidad`, `Categoria_idCategoria`) VALUES (?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, pro);
            ps.setString(2, pre);
            ps.setString(3, can);
            ps.setString(4, cat);
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo Producto Agregado");
                Limpiar();
                Mostrardatos("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_ModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModActionPerformed
        // Boton Modificar encargado de modificar el producto existente en la BD
        String id = (String) Producto.getValueAt(tablaprod.getSelectedRow(),0);
        String pro = txt_Pro.getText();
        String pre = txt_Precio.getText();
        String can = txt_Can.getText();
                
        PreparedStatement ps;
        String query = "UPDATE Producto SET Producto=?, Precio=?, Cantidad=? WHERE idProducto=?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(4, id);
            ps.setString(1, pro);
            ps.setString(2, pre);
            ps.setString(3, can);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Producto Actualizado");
                Limpiar();
                Mostrardatos("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
    }//GEN-LAST:event_btn_ModActionPerformed

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        //Boton Borrar Encargado de Eliminar el valor seleccionado en la BD
        String id = (String) Producto.getValueAt(tablaprod.getSelectedRow(),0);        
        PreparedStatement ps;
        String query = "DELETE FROM Producto WHERE idProducto=?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, id);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Producto Eliminado!");
                Limpiar();
                Mostrardatos("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
    }//GEN-LAST:event_btn_BorrarActionPerformed

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed
        //Boton Regresar para volver a la pantalla principal de venta
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

    private void txt_ProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ProKeyTyped
        //Evento para no permitir al usuario escribir numeros
        RestriccionNumeros(evt);
    }//GEN-LAST:event_txt_ProKeyTyped

    private void txt_PrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PrecioKeyTyped
        //Evento para no permitir al usuario escribir letras
        RestriccionLetras(evt);
    }//GEN-LAST:event_txt_PrecioKeyTyped

    private void RellenarT(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RellenarT
        //Evento dentro de la tabla que llena los datos de los text field con los de la tabla
        try {
        //int ID = (int) Producto.getValueAt(tablaprod.getSelectedRow(),0);  
        String producto = (String) Producto.getValueAt(tablaprod.getSelectedRow(),1);
        String precio = (String) Producto.getValueAt(tablaprod.getSelectedRow(),2);
        String cantidad = (String) Producto.getValueAt(tablaprod.getSelectedRow(),3);
        txt_Pro.setText(producto);
        txt_Precio.setText(precio);
        txt_Can.setText(cantidad);
        }
        catch (Exception ex){
        JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }//GEN-LAST:event_RellenarT

    private void Busqueda(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Busqueda
        //Evento Busquedad para buscar los datos del producto escribiendo el nombre
        try {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String B = txt_Pro.getText()+"";
        Mostrardatos(B);
            }
        }
        catch (Exception ex){
        JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }//GEN-LAST:event_Busqueda

    private void txt_CanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CanKeyTyped
        //Evento para no permitir escribir letras
        RestriccionLetras(evt);
    }//GEN-LAST:event_txt_CanKeyTyped

    private void Comprobar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Comprobar
        //Evento utilizando la funcion Comprobar
        Comprobar();
    }//GEN-LAST:event_Comprobar

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
            java.util.logging.Logger.getLogger(frm_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frm_Productos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Mod;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JComboBox<String> cmb_Cat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Bienvenido;
    private javax.swing.JLabel lbl_Can;
    private javax.swing.JLabel lbl_Cat;
    public javax.swing.JLabel lbl_Mensaje;
    private javax.swing.JLabel lbl_Precio;
    private javax.swing.JLabel lbl_Pro;
    private javax.swing.JTable tablaprod;
    private javax.swing.JTextField txt_Can;
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_Pro;
    // End of variables declaration//GEN-END:variables
}
