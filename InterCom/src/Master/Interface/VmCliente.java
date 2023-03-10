/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Master.Interface;

import Conexion.conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asistentedirprod
 */
public class VmCliente extends javax.swing.JFrame {

    /**
     * Creates new form VnCliente
     */
    public VmCliente() {
        initComponents();
        cargar();
        nombre.setEnabled(false);
        telefono.setEnabled(false);
        direccion.setEnabled(false);
        this.setExtendedState( JFrame.MAXIMIZED_BOTH );//maximizado
        this.toFront();
        this.getContentPane().setBackground(Color.white);
    }
    DefaultTableModel model;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        VmCliente.id = id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabClientes = new javax.swing.JTable();
        buscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Modificar cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 25, -1, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 276, -1));
        jPanel1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 276, -1));

        jLabel4.setText("Telefono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, -1, -1));

        jLabel5.setText("Direccion (opcional)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, -1, -1));
        jPanel1.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 276, -1));

        guardar.setBackground(new java.awt.Color(0, 153, 102));
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, 110, 30));

        TabClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabClientes);
        if (TabClientes.getColumnModel().getColumnCount() > 0) {
            TabClientes.getColumnModel().getColumn(0).setMinWidth(10);
            TabClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 100, 763, 251));

        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 74, 296, -1));

        jLabel6.setText("Buscar");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 48, -1, -1));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        actualizar();
    }//GEN-LAST:event_guardarActionPerformed

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            cargar();
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void TabClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabClientesMouseClicked
      int fil = TabClientes.getSelectedRow();
      if (fil >= 0)
      {
        nombre.setEnabled(true);
        telefono.setEnabled(true);
        direccion.setEnabled(true);
        setId(Integer.parseInt(TabClientes.getValueAt(fil, 0).toString()));
          System.out.println(getId());
        nombre.setText(this.TabClientes.getValueAt(fil, 1).toString());
        telefono.setText(this.TabClientes.getValueAt(fil, 2).toString());
        direccion.setText(this.TabClientes.getValueAt(fil, 3).toString());
        JOptionPane.showMessageDialog(null, TabClientes.getValueAt(fil, 1).toString() + " seleccionado");
    }
    }//GEN-LAST:event_TabClientesMouseClicked

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            cargar();
        }
    }//GEN-LAST:event_buscarKeyPressed

    private void Clear (){
        nombre.setText(null);
        telefono.setText(null);
        direccion.setText(null);
    } 
    
    void cargar()
  {
    clean();
    String[] registros = new String[4];
    try
    {
      con = conexion.getConnection();
      ps = con.prepareStatement("SELECT * FROM clientes where Nombre LIKE '"+"%"+buscar.getText()+"%"+"'");
      rs = ps.executeQuery();
      while (rs.next())
      {
        registros[0] = rs.getString("id_Cliente");
        registros[1] = rs.getString("Nombre");
        registros[2] = rs.getString("Telefono");
        registros[3] = rs.getString("Direccion");
        model.addRow(registros);
      }
      TabClientes.setModel(model);
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, ex);
    }
  }
    
    private void clean()
  {
    model = ((DefaultTableModel)TabClientes.getModel());
    while (model.getRowCount() > 0) {
      model.removeRow(0);
    }
  }
    
    public void actualizar(){
      try
      {
        con = conexion.getConnection();
        String Sql= "UPDATE clientes SET Nombre='"+ nombre.getText() +"', Telefono='"+telefono.getText().substring(0, 9)+"', "
                + "Direccion='"+direccion.getText()+"' where id_Cliente = '" + getId() + "' ";
        ps = con.prepareStatement(Sql);
        int res = ps.executeUpdate(); //si vas a usar un dato que no sea un valor escrito y sea pedido de una variable se usan '"+varible+"'
        if (res > 0) {
          JOptionPane.showMessageDialog(null, "Se Actualizo la infomacion del cliente");
          Clear();
          cargar();
        }
	else { JOptionPane.showMessageDialog(null, "revisa tus datos"); }
      }
      catch (Exception ex)
      {
        JOptionPane.showMessageDialog(null, ex);
      }
    }
    
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
            java.util.logging.Logger.getLogger(VmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabClientes;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
