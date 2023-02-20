package poa.usuario;
import poa.principal.Actividades_crear;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import poa.beans.MakeActiv;
import poa.beans.UserDataBean;
import poa.database.Conector;

/**
 *
 * @author machi
 */
public class Usuario extends javax.swing.JFrame {

    /**
     * Creates new form Usuario
     */
    public Usuario() {
        
    initComponents();
    setTitle("Iniciar sesion");
    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icon1.png")).getImage());
    try
    {
      con = Conector.getConnection();
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("Select usuario, contrasenia, save from usuarios where save='1'");
      if (rs.next())
      {
        int checkp = Integer.parseInt(rs.getString("save"));
        String nombre = rs.getString("usuario");
        String credencial = rs.getString("contrasenia");
        if (checkp == 1)
        {
          usuario.setText(nombre);
          pass.setText(credencial);
          check.setSelected(true);
        }
      }
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, "Error " + e);
    }
    }
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    UserDataBean UDB = new UserDataBean();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        check = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 189, -1));

        jButton1.setBackground(new java.awt.Color(51, 102, 0));
        jButton1.setText("Iniciar sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 189, -1));

        check.setText("Recordar");
        getContentPane().add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/name.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 50, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forgot-password.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("¿a olvidado su Contraseña?");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 220, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*Metodo para inicio de Sesion, lo primero que hace es consultar a la base de datos si
    existe un usuario con el nombre dado en el campo de texto y si la contraseña coincide con este
    en caso de que no, nos retorna un error, pero si existe nos mandara el acceso a la pantalla principal*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Revisar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
//        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
    if (evt.getKeyCode() == 10) {
      Revisar();
    }
    }//GEN-LAST:event_passKeyPressed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        new Cambiar_Clave().setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked
//**
    void Revisar()
  {
   try
    {
      con = Conector.getConnection();
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("Select save from usuarios where usuario = '" + usuario.getText() + "' and contrasenia  = '" + pass.getText() + "'");
      if (rs.next())
      {
        int checador = Integer.parseInt(rs.getString("save"));
        if (checador != 1) {
          if (check.isSelected()) {
            try
            {
              con = Conector.getConnection();
              Class.forName("com.mysql.jdbc.Driver").newInstance();
              PreparedStatement ps = con.prepareStatement("UPDATE `usuarios` SET save='1' where usuario = '" + usuario.getText() + "' and contrasenia  = '" + pass.getText() + "'");
              int res = ps.executeUpdate();
              if (res > 0) {}
            }
            catch (Exception ex)
            {
              JOptionPane.showMessageDialog(null, ex);
            }
          }
        }
      }
      
      try
      {
        con = Conector.getConnection();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement st2 = con.createStatement();
        ResultSet rs2 = st2.executeQuery("Select nombre, id_usuario from usuarios where usuario = '"+usuario.getText()+"' and contrasenia  = '" +pass.getText()+ "'");
        if (rs2.next())
        {
          UDB.setId_usuario(rs2.getInt("id_usuario"));
          UDB.setUsuario(rs2.getString("nombre"));
          JOptionPane.showMessageDialog(null, "bienvenido al sistema "+rs2.getString("nombre")+"");
          setVisible(false);
          dispose();
          new Actividades_crear().setVisible(true);
        }
        else
        {
          JOptionPane.showMessageDialog(null, "No existe el usuario, porfavor revise sus datos");
        }
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(null, "Error " + e);
      }
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, "Error " + e);
    }
  }
//**    
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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
