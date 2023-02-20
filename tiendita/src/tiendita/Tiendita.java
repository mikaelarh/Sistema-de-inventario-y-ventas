/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita;

import java.awt.Color;
import java.io.IOException;
import tiendita.Productos.Modificar;
import tiendita.Productos.Nuevo;
import tiendita.Productos.Eliminar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tiendita.Guardado.Actualizar;
import tiendita.Beans.Bean;
import tiendita.Conexiones.conexion;
import tiendita.Guardado.Guardar;
import tiendita.Productos.NuevaUm;
import tiendita.Usuarios.AgregarUsuario;
import tiendita.Usuarios.ModUser;
import tiendita.Usuarios.UserNameBeans;

/**
 *
 * @author asistentedirprod
 */
public class Tiendita extends javax.swing.JFrame {

    public Tiendita() {
        initComponents();
        setTitle("Punto de Ventas");
        cargar();
        OnSesionStart();
        unb.setSesion(1);
        this.setExtendedState( JFrame.MAXIMIZED_BOTH );//maximizado
        this.toFront();
        this.getContentPane().setBackground(Color.white);
        maintab.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 14));
    }
    Bean bean = new Bean();
    UserNameBeans unb = new UserNameBeans();
    Paint p = new Paint();
    Guardar guardar = new Guardar();
    Actualizar update = new Actualizar();
    DefaultTableModel model;
    static Connection con;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    DateFormat hour = new SimpleDateFormat("HH:mm");
    Calendar calendar = Calendar.getInstance();
    int idsesion=getid1();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        maintab = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Nuevo = new javax.swing.JMenuItem();
        Modificar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscarKeyTyped(evt);
            }
        });
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 200, 30));

        maintab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maintab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Unidad de Medida", "Precio", "Cantidad en Almacen"
            }
        ));
        maintab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(maintab);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 830, 300));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Buscar:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("@ADMINISTRADOR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 160, 40));

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Eliminar Inventario");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 180, 40));

        getContentPane().add(jPanel1);

        jMenu1.setText("Productos");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        Nuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nuevo.setText("Agregar nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        jMenu1.add(Nuevo);

        Modificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        Modificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        jMenu1.add(Modificar);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem3.setText("Eliminar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem6.setText("Administrar UM");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Usuarios");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem4.setText("Agregar Nuevo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem1.setText("Modificar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem7.setText("Registros");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Vender");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem2.setText("Abrir Gestor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Imprimir");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem5.setText("Imprimir Reporte");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maintabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintabMouseClicked

    }//GEN-LAST:event_maintabMouseClicked

    private void BuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyPressed
        if (evt.getKeyCode() == 10) {
            bean.setNombre(Buscar.getText());
            TB();
        }
    }//GEN-LAST:event_BuscarKeyPressed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        new Modificar().setVisible(true);
    }//GEN-LAST:event_ModificarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Eliminar().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new AgregarUsuario().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        new Nuevo().setVisible(true);
    }//GEN-LAST:event_NuevoActionPerformed

    private void BuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyTyped
        bean.setNombre(Buscar.getText());
        TB();
    }//GEN-LAST:event_BuscarKeyTyped

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new PanelVentas().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new Reporte().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "¿Desea eliminar todos los registros actuales?", "Elige una opcion", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            try {
                con = conexion.getConnection();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                PreparedStatement ps = con.prepareStatement("TRUNCATE `pvdb`.`inventario`");
                int res = ps.executeUpdate();
            } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Tiendita.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Toda la informacion fue eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "Proceso Cancelado");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ModUser().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new NuevaUm().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "Desea finalizar la sesion", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            OnSesionEnd();
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "La Sesion no Finalizo");
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       new Registros().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /*Llenar datos de la tabla*/
    public void TB() {
        buscarcargar();
    }

    private void cargar() {
        clear();
//        titulos();
        String[] registros = new String[4];
        try {
            con = conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `inventario` ORDER BY Producto ASC");
            while (rs.next()) {
                registros[0] = rs.getString("Producto");
                registros[1] = rs.getString("Um1");
                registros[2] = "$ " + rs.getString("P1");
                registros[3] = rs.getString("C1");
                model.addRow(registros);
            }
            maintab.setModel(model);
            maintab.setDefaultRenderer(Object.class, new Paint());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void buscarcargar() {
        clear();
        String[] registros = new String[4];
        try {
            con = conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `inventario` where Producto LIKE '" + bean.getNombre() + "%" + "' ORDER BY Producto ASC");
            while (rs.next()) {
                registros[0] = rs.getString("Producto");
                registros[1] = rs.getString("Um1");
                registros[2] = "$ " + rs.getString("P1");
                registros[3] = rs.getString("C1");
                model.addRow(registros);
            }
            maintab.setModel(model);
            maintab.setDefaultRenderer(Object.class, new Paint());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

//    private void titulos() {
//        try {
//            con = conexion.getConnection();
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM `inventario`");
//            while (rs.next()) {
//                //Para obtener esta información, hay que pedirle los MetaDatos al ResulSet.
//                ResultSetMetaData metaDatos = rs.getMetaData();
//                // Se obtiene el número de columnas.
//                int numeroColumnas = metaDatos.getColumnCount();
//                // Se crea un array de etiquetas para rellenar
//                Object[] etiquetas = new Object[numeroColumnas];
//                // Se obtiene cada una de las etiquetas para cada columna
//                for (int i = 0; i < numeroColumnas; i++) {
//                    // Nuevamente, para ResultSetMetaData la primera columna es la 1.
//                    etiquetas[i] = metaDatos.getColumnLabel(i + 1);
//                }
//                model.setColumnIdentifiers(etiquetas);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
    private void clear() {
        model = ((DefaultTableModel) maintab.getModel());
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
    
    private void OnSesionStart(){
        int nowy = calendar.get(Calendar.WEEK_OF_YEAR);
    try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `registros` VALUES (? ,?, ?, ?, null,null,null,null,?,'Administrador')"); //siempre poner el primer dato NULL
            ps.setInt(1, getid1());
            ps.setInt(2, unb.getIduser());
            ps.setString(3, dateFormat.format(date));
            ps.setString(4, hour.format(date));
            ps.setInt(5, nowy);
            int res = ps.executeUpdate();
            if (res > 0) { // cuando es mayor que cero significa que se inserto un dato en la base
            } else {
                JOptionPane.showMessageDialog(null, "A ocurrido un error");
            }
            con.close(); //siempre cerrar las conexiones despues de usarlas
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex); // imprime el error si hay
        }
    }
    
    private void OnSesionEnd(){
    try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("UPDATE `registros` SET `FechaDeCierre`=?,"
                    + "`HoraDeCierre`=? WHERE Id='" + idsesion + "'");
            ps.setString(1, dateFormat.format(date));
            ps.setString(2, hour.format(date));
            int res = ps.executeUpdate();
            if (res > 0) {
                UpdateSesion();
            } else {
                JOptionPane.showMessageDialog(null, "A ocurrido un error");
            }
            con.close(); //siempre cerrar las conexiones despues de usarlas
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex); // imprime el error si hay
        }
    }
    
    public void UpdateSesion() {
        try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("UPDATE `usuarios` SET `Sesion`=0 WHERE IdUsuario='"+unb.getIduser()+"'");
            int res = ps.executeUpdate();
            con.close(); //siempre cerrar las conexiones despues de usarlas
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex); // imprime el error si hay
        }
    }
    
    public int getid1() {
        try {
            con = conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Id FROM `registros` ORDER BY Id DESC LIMIT 1");
            if (rs.next()) {
                return rs.getInt("Id") + 1;
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 1;
    }
    
    /**/
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tiendita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JMenuItem Nuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable maintab;
    // End of variables declaration//GEN-END:variables
}
