package poa.principal;

import poa.beans.JavaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import poa.beans.Key;
import poa.database.Conector;

/**
 *
 * @author asistentedirprod
 */
public class Actividades extends javax.swing.JFrame {

    /**
     * Creates new form Actividades
     */
    public Actividades() {
        initComponents();
        setIconImage (new ImageIcon(getClass().getResource("/Imagenes/icon1.png")).getImage());
        cargar();
    }
    DefaultTableModel model;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    JavaBean bean = new JavaBean();
    Key KEY = new Key();
/*este metodo funciona cargando las actividades por medio un id o parentesco de nombre
    tambien carga todas las actividades en general*/
void cargar()
  {
    clear();
    String[] registros = new String[2];
    try
    {
      this.con = Conector.getConnection();
      this.ps = this.con.prepareStatement("SELECT * FROM actividades");
      this.rs = this.ps.executeQuery();
      while (this.rs.next())
      {
        registros[0] = this.rs.getString("id_actividad");
        registros[1] = this.rs.getString("nombre_actividad");
        this.model.addRow(registros);
      }
      this.jTable1.setModel(this.model);
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, ex);
    }
  }
  
  void cargar2(int valor)
  {
    clear();
    String[] registros = new String[2];
    try
    {
      this.con = Conector.getConnection();
      this.ps = this.con.prepareStatement("SELECT * FROM actividades where id_actividad='" + valor + "'");
      this.rs = this.ps.executeQuery();
      while (this.rs.next())
      {
        registros[0] = this.rs.getString("id_actividad");
        registros[1] = this.rs.getString("nombre_actividad");
        this.model.addRow(registros);
      }
      this.jTable1.setModel(this.model);
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, ex);
    }
  }
  
  void cargar3(String valor)
  {
    clear();
    String[] registros = new String[2];
    try
    {
      this.con = Conector.getConnection();
      this.ps = this.con.prepareStatement("SELECT * FROM `actividades` WHERE nombre_actividad LIKE '" + valor + "'");
      this.rs = this.ps.executeQuery();
      while (this.rs.next())
      {
        registros[0] = this.rs.getString("id_actividad");
        registros[1] = this.rs.getString("nombre_actividad");
        this.model.addRow(registros);
      }
      this.jTable1.setModel(this.model);
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, ex);
    }
  }
  
  private void clear()
  {
    this.model = ((DefaultTableModel)this.jTable1.getModel());
    while (this.model.getRowCount() > 0) {
      this.model.removeRow(0);
    }
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        palabra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Buscar por id");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 204, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID Actividad", "Nombre De La Actividad"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 670, 240));

        jLabel3.setText("buscar por palabra");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        palabra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                palabraKeyPressed(evt);
            }
        });
        jPanel1.add(palabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*ambos metodos keyPressed funcionan invocando los metodos de rellenar con condicion
    al presionar la tecla enter*/
    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            cargar2(Integer.parseInt(buscar.getText()));
        }
    }//GEN-LAST:event_buscarKeyPressed

    private void palabraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_palabraKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            cargar3("%" + (palabra.getText()) + "%");
        }
    }//GEN-LAST:event_palabraKeyPressed
    /*este metodo lee un valor de variable almacenado en la clase Actividades_crear
    el cual a travez de un if comprara si el campo esta activo o bloqueado
    y en caso de estar bloqueado el primer campo recorre todos los posibles eventos
    hasta encontrar un campo que este disponible, en caso de estar bloqueados todos
    el metodo avisa que no existe algun campo disponible*/
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fil = this.jTable1.getSelectedRow();
    if (Actividades_crear.Id.isEnabled())
    {
      if (fil >= 0)
      {
        Actividades_crear.Id.setText(this.jTable1.getValueAt(fil, 0).toString());
        JOptionPane.showMessageDialog(null, this.jTable1.getValueAt(fil, 0).toString() + " seleccionado");
        Actividades_crear.Id.setEnabled(true);
        Actividades_crear.Actividad.setEnabled(true);
        Actividades_crear.Mes.setEnabled(true);
        Actividades_crear.Porcen.setEnabled(true);
      }
    }
    else {
      JOptionPane.showMessageDialog(null, "No hay campos disponibles");
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField palabra;
    // End of variables declaration//GEN-END:variables
}
