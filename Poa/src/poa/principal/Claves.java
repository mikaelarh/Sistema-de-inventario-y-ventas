/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poa.principal;

import poa.beans.JavaBean;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import poa.beans.Key;
import poa.beans.MakeActiv;
import poa.beans.UserDataBean;
import poa.database.Conector;

/**
 *
 * @author asistentedirprod
 */
public class Claves extends javax.swing.JFrame {

    /**
     * Creates new form Claves
     */
    public Claves() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icon1.png")).getImage());
        cargar2();
        cargartabcl();
    }
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    JavaBean bean = new JavaBean();
    MakeActiv MA = new MakeActiv();
    UserDataBean UDB = new UserDataBean();
    Key key = new Key();
    String codigo;
    DefaultTableModel model;
    DefaultTableModel model2;
    int site;
    int site2;
    String clave = "";

    /*tabla que muestra las diferentes claves almacenadas en la base de datos
    su segundo metodo sirve para llenarla con todas las actividades guardadas en la BD
    segun el valor que busques*/
    void cargar(int valor) {
        clear();
        String[] registros = new String[5];
        try {
            con = Conector.getConnection();
            String query="SELECT * FROM `datos` WHERE id_sitio='" + valor + "' AND lmf='" + lotes.getText() + "'";
            System.out.println(query);
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                registros[0] = rs.getString("id_datos");
                registros[1] = rs.getString("clave");
                registros[2] = rs.getString("id_sitio");
                registros[3] = rs.getString("lmf");
                registros[4] = rs.getString("orden_erp");
                model.addRow(registros);
            }
            con.close();
            jTable1.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }   

    void cargar2() {
        clear();
        String[] registros = new String[5];
        try {
            con = Conector.getConnection();
            String query="SELECT * FROM `datos`";
            System.out.println(query);
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                registros[0] = rs.getString("clave");
                registros[1] = rs.getString("id_sitio");
                registros[2] = rs.getString("lmf");
                registros[3] = rs.getString("orden_erp");
                model.addRow(registros);
            }
            con.close();
            jTable1.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void cargarsitio(int valor) {
        clear();
        String[] registros = new String[5];
        try {
            con = Conector.getConnection();
            String query="SELECT * FROM `datos` WHERE id_sitio='" + valor + "'";
            System.out.println(query);
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                registros[0] = rs.getString("clave");
                registros[1] = rs.getString("id_sitio");
                registros[2] = rs.getString("lmf");
                registros[3] = rs.getString("orden_erp");
                model.addRow(registros);
            }
            con.close();
            jTable1.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void cargartabcl() {
        clear2();
        String[] registros = new String[2];
        TableColumnModel columnModel = tabcl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(190);
        try {
            con = Conector.getConnection();
            String query="SELECT DISTINCT datos.clave, datos.id_datos from datos "
                    + "INNER JOIN poa ON poa.id_datos=datos.id_datos where poa.id_usuario='" + UDB.getId_usuario() + "'";
            System.out.println(query);
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                registros[0] = rs.getString("id_datos");
                registros[1] = rs.getString("clave");
                model2.addRow(registros);
            }
            con.close();
            tabcl.setColumnModel(columnModel);
            tabcl.setModel(model2);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void clear() {
        model = ((DefaultTableModel) jTable1.getModel());
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void clear2() {
        model2 = ((DefaultTableModel) tabcl.getModel());
        while (model2.getRowCount() > 0) {
            model2.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lotes = new javax.swing.JTextField();
        sitio = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabcl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Clave", "Sitio", "Lote", "Orden ERP"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 680, 367));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-ver-archivo-26.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 56, -1, -1));

        jLabel2.setText("lote");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 36, -1, -1));

        jLabel1.setText("Sitio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 36, -1, -1));
        jPanel1.add(lotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 63, 183, -1));

        sitio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        sitio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sitioActionPerformed(evt);
            }
        });
        jPanel1.add(sitio, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 63, -1, -1));

        tabcl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id","Claves usadas"
            }
        ));
        tabcl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabcl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabclMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabcl);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 230, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargar(Integer.parseInt((String) sitio.getSelectedItem()));
    }//GEN-LAST:event_jButton1ActionPerformed
    /*este metodo inicia al tocar una fila de la base de datos este manda el valor
    de una celda almacenada en la fila a el campo clave de Actividades_crear*/
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fil = jTable1.getSelectedRow();
        MA.setClave(jTable1.getValueAt(fil, 0).toString());
        recuperar();
        System.out.println(key.getKey());
            if (key.getKey()==true) {
                if (fil >= 0) {
                    Actividades_crear.clave.setText(jTable1.getValueAt(fil, 0).toString());
                    JOptionPane.showMessageDialog(null, jTable1.getValueAt(fil, 0).toString() + "se agrego como clave");
                }
            }else if (key.getKeyex()==true) {
                errata();
                if (site != site2) {
                    JOptionPane.showMessageDialog(null, "No Se puede copiar a un sitio diferente");
                } else {
                    if (Actividades_crear.clave.getText().equals(Actividades_crear.cl.getText())) {
                        JOptionPane.showMessageDialog(null, "No puede copiar su programacion al lote original");
                        Actividades_crear.cl.setText("");
                        Actividades_crear.cl.setEnabled(true);
                    }else if (fil >= 0) {
                        Actividades_crear.cl.setText(jTable1.getValueAt(fil, 0).toString());
                        Actividades_crear.cl.setEnabled(false);
                        Actividades_crear.exp.setEnabled(true);
                        key.setKeyex(false);
                        JOptionPane.showMessageDialog(null, jTable1.getValueAt(fil, 0).toString() + "se agrego como clave para exportar");
                    }
                    
                }
            }
    }//GEN-LAST:event_jTable1MouseClicked

    private void sitioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sitioActionPerformed
        cargarsitio(Integer.parseInt((String) sitio.getSelectedItem()));
    }//GEN-LAST:event_sitioActionPerformed

    private void tabclMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabclMouseClicked
        int fil = tabcl.getSelectedRow();
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection texto = new StringSelection(tabcl.getValueAt(fil, 1).toString());
        cb.setContents(texto, texto);
        if (key.getKey()==true) {
            if (fil >= 0) {
                MA.setIdclave(Integer.parseInt(tabcl.getValueAt(fil, 0).toString()));
                Actividades_crear.clave.setText(tabcl.getValueAt(fil, 1).toString());
                JOptionPane.showMessageDialog(null, tabcl.getValueAt(fil, 1).toString() + "se agrego como clave");
            }
        } else if (key.getKey()==false) {
            JOptionPane.showMessageDialog(null, "No hay campos disponibles");
        }
    }//GEN-LAST:event_tabclMouseClicked
// 

   private void errata() {
        String key = Actividades_crear.clave.getText();
        try {
            con = Conector.getConnection();
            String query="SELECT id_sitio FROM datos where clave='" + key + "'";
            System.out.println( "errata"+ query);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                site = rs.getInt("id_sitio");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
//  
//    

    private void recuperar() {
        try {
            con = Conector.getConnection();
            String query = "SELECT id_sitio, id_datos FROM datos where clave='" + MA.getClave() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                site2 = rs.getInt("id_sitio");
                MA.setIdclave(rs.getInt("id_datos"));
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
//    

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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Claves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Claves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Claves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Claves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Claves().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lotes;
    private javax.swing.JComboBox<String> sitio;
    private javax.swing.JTable tabcl;
    // End of variables declaration//GEN-END:variables
}
