/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poa.principal;

import java.awt.HeadlessException;
import poa.calendario.Calendario;
import poa.beans.MakeActiv;
import poa.beans.JavaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import poa.beans.Key;
import poa.beans.UserDataBean;
import poa.database.Bd;
import poa.database.Conector;
import poa.vaciado.Vaciado;

/**
 *
 * @author machi
 */
public final class Actividades_crear extends javax.swing.JFrame {

    /**
     * Creates new form actividades_crear
     */
    public Actividades_crear() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icon1.png")).getImage());
        Esconder();
        setTitle("Nueva Actividad");
        jLabel12.setText(UserDataBean.getUsuario());
        AñoCombo();
        clear();
    }
    JavaBean JB = new JavaBean();
    int num = 0;
    private static Boolean SaveExito = false;
    DefaultTableModel model;
    MakeActiv MA = new MakeActiv();
    UserDataBean UDB = new UserDataBean();
    Key key = new Key();
    int master = 0;
    String nomb = "";
    static Connection con;
    PreparedStatement pst = null;
    ResultSet result = null;
    Calendar c = new GregorianCalendar();

    public void AñoCombo() {
        for (int i = c.get(Calendar.YEAR); i <= 2050; i++) {
            año.addItem(Integer.toString(i));
        }
    }

    /*metodo para cargar las tablas con los datos del poa su filtro es la clave
    el id usuario y el año*/
    void cargar() {
        clear();
        String[] registros = new String[5];
        try {
            con = Conector.getConnection();
            String query = "SELECT descripcion_act.actividad, fechas.mes, id_porcentaje, poa.id_fechas FROM poa "
                    + "INNER JOIN descripcion_act ON poa.id_actividad=descripcion_act.id_actividad "
                    + "INNER JOIN fechas ON poa.id_fechas=fechas.id_fechas "
                    + "where id_datos='" + MakeActiv.getIdclave() + "' AND anio='" + MakeActiv.getAnio() + "' "
                    + "AND id_usuario='" + UserDataBean.getId_usuario() + "' AND poa.id_actividad not IN(1,2,3,4,5,6)";
            System.out.println(query);
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            int number = 0;
            while (rs.next()) {
                number++;
                registros[0] = String.valueOf(number);
                registros[1] = rs.getString("descripcion_act.actividad").replace(",", "");
                registros[2] = rs.getString("poa.id_fechas");
                registros[3] = rs.getString("fechas.mes");
                MakeActiv.setIdpercent(rs.getInt("id_porcentaje"));
                percentsexp();
                registros[4] = MakeActiv.getPorcentaje();
                model.addRow(registros);
            }
            TabActs.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        }
    }

    private void clear() {
        model = ((DefaultTableModel) TabActs.getModel());
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        clave = new javax.swing.JTextField();
        jtext1 = new javax.swing.JLabel();
        jtext2 = new javax.swing.JLabel();
        jtext3 = new javax.swing.JLabel();
        jtext5 = new javax.swing.JLabel();
        jtext6 = new javax.swing.JLabel();
        año = new javax.swing.JComboBox<>();
        sitio = new javax.swing.JLabel();
        lmf = new javax.swing.JLabel();
        orden = new javax.swing.JLabel();
        plantacion = new javax.swing.JLabel();
        superficie = new javax.swing.JLabel();
        CClave = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ELote = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabActs = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        New = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Mes = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Actividad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Porcen = new javax.swing.JComboBox<>();
        exp = new javax.swing.JButton();
        Liberar = new javax.swing.JButton();
        cl = new javax.swing.JTextField();
        Id = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        Informe = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Clave:");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        clave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                claveKeyPressed(evt);
            }
        });
        panel1.add(clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 206, -1));

        jtext1.setText("Sitio:");
        panel1.add(jtext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jtext2.setText("LMF:");
        panel1.add(jtext2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jtext3.setText("Ord Prod:");
        panel1.add(jtext3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jtext5.setText("Fecha plantacion:");
        panel1.add(jtext5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jtext6.setText("superficie");
        panel1.add(jtext6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona el año"}));
        año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añoActionPerformed(evt);
            }
        });
        panel1.add(año, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 138, -1));

        sitio.setText("sitio x");
        panel1.add(sitio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        lmf.setText("lote x");
        panel1.add(lmf, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        orden.setText("orden x");
        panel1.add(orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        plantacion.setText("xxxx-xx-xx");
        panel1.add(plantacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        superficie.setText("superficie x");
        panel1.add(superficie, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        CClave.setBackground(new java.awt.Color(102, 102, 255));
        CClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-reemplazar-26.png"))); // NOI18N
        CClave.setText("Cambiar Clave");
        CClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CClaveActionPerformed(evt);
            }
        });
        panel1.add(CClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, -1, -1));

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-basura-26.png"))); // NOI18N
        jButton3.setText("Limpiar BD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-agregar-enlace-26.png"))); // NOI18N
        jButton5.setText("Restaurar BD");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 40));

        ELote.setBackground(new java.awt.Color(102, 0, 0));
        ELote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-basura-26.png"))); // NOI18N
        ELote.setText("Eliminar lote");
        ELote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELoteActionPerformed(evt);
            }
        });
        panel1.add(ELote, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, -1, -1));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1080, 130));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nombre");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 380, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabActs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Actividad", "#Mes", "Mes", "Porcentaje"
            }
        ));
        TabActs.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TabActs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabActsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabActs);
        if (TabActs.getColumnModel().getColumnCount() > 0) {
            TabActs.getColumnModel().getColumn(0).setMinWidth(50);
            TabActs.getColumnModel().getColumn(0).setPreferredWidth(50);
            TabActs.getColumnModel().getColumn(0).setMaxWidth(100);
            TabActs.getColumnModel().getColumn(1).setMinWidth(300);
            TabActs.getColumnModel().getColumn(1).setPreferredWidth(300);
            TabActs.getColumnModel().getColumn(1).setMaxWidth(350);
            TabActs.getColumnModel().getColumn(3).setMinWidth(160);
            TabActs.getColumnModel().getColumn(3).setPreferredWidth(160);
            TabActs.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 660, 280));

        jLabel3.setText("Guardar");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        jLabel5.setText("Eliminar");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        jLabel22.setText("Nuevo");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, -1, -1));

        New.setBackground(new java.awt.Color(0, 153, 51));
        New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-añadir-lista-26.png"))); // NOI18N
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        jPanel3.add(New, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, -1, 30));

        Eliminar.setBackground(new java.awt.Color(204, 0, 0));
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-basura-26.png"))); // NOI18N
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel3.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, -1, 30));

        Save.setBackground(new java.awt.Color(0, 102, 0));
        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-guardar-26.png"))); // NOI18N
        Save.setText("Guardar");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel3.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, 30));

        jLabel8.setText("Id actividad");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setText("Porcentaje");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre" ,"noviembre", "diciembre" }));
        jPanel3.add(Mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabel24.setText("Mes");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jLabel9.setText("Nombre de la actividad");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        Actividad.setText("nombre");
        jPanel3.add(Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 290, -1));

        jLabel4.setText("Actividades ya guardadas en este lote");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        Porcen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%","90%", "100%", }));
        jPanel3.add(Porcen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        exp.setBackground(new java.awt.Color(0, 102, 204));
        exp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-copiar-enlace-26.png"))); // NOI18N
        exp.setText("Copiar Programacion");
        exp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expActionPerformed(evt);
            }
        });
        jPanel3.add(exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 210, -1, -1));

        Liberar.setBackground(new java.awt.Color(0, 102, 102));
        Liberar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-desbloquear-24.png"))); // NOI18N
        Liberar.setText("liberar");
        Liberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiberarActionPerformed(evt);
            }
        });
        jPanel3.add(Liberar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, -1, -1));
        jPanel3.add(cl, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 130, 30));

        Id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IdKeyPressed(evt);
            }
        });
        jPanel3.add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1080, 480));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forestal.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 390));

        jMenu1.setText("Calendario");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem3.setText("Graficar Calendario");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        Informe.setText("Informe");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem2.setText("Nuevo Informe");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Informe.add(jMenuItem2);

        jMenuBar1.add(Informe);

        jMenu2.setText("Actividades");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem1.setText("Abrir Actividades");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Claves");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem4.setText("Abrir Claves");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*Metodo año habilita la entrada de clave, deja activo el metodo ifcl*/
    private void añoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añoActionPerformed
        int i = año.getSelectedIndex();
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "por favor seleccione un año");
        } else {
            año.setEnabled(false);
            clave.setEnabled(true);
            Key.setKey(true);
            MakeActiv.setAnio(Integer.parseInt((String) año.getSelectedItem()));
            JavaBean.setAnio(Integer.parseInt((String) año.getSelectedItem()));
        }
    }//GEN-LAST:event_añoActionPerformed
    /*metodo para cambiar la clave*/
    private void CClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CClaveActionPerformed
        Key.setKey(true);
        Esconder();
        clear();
        año.setEnabled(true);
    }//GEN-LAST:event_CClaveActionPerformed

    /*manda a llamar al metodo buscar para que actualize la informacion de los lotes*/
    private void claveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveKeyPressed
        if (evt.getKeyCode() == 10) {
            Key.setKey(false);
            Liberar();
            buscar();
            año.setEnabled(false);
        }
    }//GEN-LAST:event_claveKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Al oprimir YES su base de datos se eliminara y no sera recuperable", "Esta seguro de realizar este proceso?", 0);
        if (n == 0) {
            try {
                con = Conector.getConnection();
                PreparedStatement stmt = null;
                stmt = con.prepareStatement("TRUNCATE `poa`.`poa`");
                stmt.execute();
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            JOptionPane.showMessageDialog(null, "base de datos limpiada");
            clear();
            Liberar();
        } else if (n == 1) {
            JOptionPane.showMessageDialog(null, "operacion cancelada");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new Bd().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ELoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELoteActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Al oprimir YES se eliminara el lote y no sera recuperable", "Esta seguro de realizar este proceso?", 0);
        if (n == 0) {
            try {
                con = Conector.getConnection();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Statement st = con.createStatement();
                int res = st.executeUpdate("DELETE FROM `poa` WHERE id_usuario='" + UserDataBean.getId_usuario() + "' AND id_datos='" + MakeActiv.getIdclave() + "' "
                        + "AND anio='" + MakeActiv.getAnio() + "'");
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "lote eliminado");
                    clear();
                    Liberar();
                } else {
                    JOptionPane.showMessageDialog(null, "a ocurrido un error");
                }
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        } else if (n == 1) {
            JOptionPane.showMessageDialog(null, "operacion cancelada");
        }
    }//GEN-LAST:event_ELoteActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Calendario().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Vaciado().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Actividades().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new Claves().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void LiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiberarActionPerformed
        cl.setEnabled(true);
        cl.setText("");
        exp.setEnabled(false);
        Key.setKeyex(true);
    }//GEN-LAST:event_LiberarActionPerformed

    /*metodo exp sirve para pasar datos de actividades de un LMF a otro */
    private void expActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expActionPerformed
        MakeActiv.setClave(clave.getText());
        MakeActiv.setClavexp(cl.getText());
        verificadormaster();
        Exportar();
        MakeActiv.setClave(cl.getText());
    }//GEN-LAST:event_expActionPerformed

    /*Metodos guardar pasan parametros al bean, y mandan a llamar al metodo guardar
    y exito que en caso de funcionar se ejecutan gracias a que su variable cambio su valor a 1
    y luego la regresan a 0*/
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if (Id.getText().equals("") || Actividad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay una actividad");
        } else {
            MakeActiv.setId_mes(Mes.getSelectedIndex() + 1);
            MakeActiv.setIdpercent(Porcen.getSelectedIndex() + 1);
            MakeActiv.setId_actividad(Integer.parseInt(Id.getText()));
            GetIdMes();
            GetIdClave();
            guardar();
        }
    }//GEN-LAST:event_SaveActionPerformed

    /*este metodo sobre escribe los valores de las variables luego manda a llamar al metodo semi generico
    eliminar*/
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        MakeActiv.setId_actividad(Integer.parseInt(Id.getText()));
        MakeActiv.setId_mes(Mes.getSelectedIndex() + 1);
        MakeActiv.setIdpercent(Porcen.getSelectedIndex() + 1);
        GetIdMes();
        GetIdClave();
        borrar();
        cargar();
        Eliminar.setEnabled(false);
        Save.setEnabled(true);
    }//GEN-LAST:event_EliminarActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        GNuevo();
    }//GEN-LAST:event_NewActionPerformed

    private void TabActsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabActsMouseClicked
        int fil = TabActs.getSelectedRow();
        if (fil >= 0) {
            Save.setEnabled(false);
            Eliminar.setEnabled(true);
            New.setEnabled(true);
            Actividad.setText(TabActs.getValueAt(fil, 1).toString());
            GetIdAct(TabActs.getValueAt(fil, 1).toString());
            MakeActiv.setId_fechas(Integer.parseInt(TabActs.getValueAt(fil, 2).toString()));
            Mes.setEnabled(false);
            Porcen.setEnabled(false);
        }
    }//GEN-LAST:event_TabActsMouseClicked

    private void IdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdKeyPressed
        if (evt.getKeyCode() == 10) {
            GetNomAct();
        }
    }//GEN-LAST:event_IdKeyPressed

    void buscar() {
        try {
            con = Conector.getConnection();
            String query = "SELECT sitio.nombre_sitio, datos.id_sitio, lmf, codigo, fecha, tamanio,"
                    + " orden_erp FROM `datos` INNER JOIN sitio ON sitio.id_sitio=datos.id_sitio WHERE datos.clave='" + clave.getText() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                lmf.setText(rs.getString("lmf"));
                orden.setText(rs.getString("codigo"));
                plantacion.setText(rs.getString("fecha"));
                superficie.setText(rs.getString("tamanio"));
                MakeActiv.setSuperficie(rs.getFloat("tamanio"));
                sitio.setText(rs.getString("nombre_sitio"));
                MakeActiv.setId_sitio(rs.getInt("datos.id_sitio"));
                MakeActiv.setClave(clave.getText());
                JavaBean.setClave(clave.getText());
                verificadormaster();
            } else {
                JOptionPane.showMessageDialog(null, "No existe la clave entregada");
            }
            con.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }

    /*EL VERIFICADOR maestro revisa si existe la actividad cuota segun el sitio y en caso de ser cierto se apoya
    en si mismo para guardarlo en el poa y de presta los metodos del EXP para guardar
    datos del informe*/
    public void verificadormaster() {
        int verificador = 1;
        try {
            con = Conector.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String query = "SELECT * FROM `poa` WHERE id_datos='" + MakeActiv.getIdclave() + "' AND anio='" + MakeActiv.getAnio() + "' "
                    + "AND id_usuario='" + UserDataBean.getId_usuario() + "' AND id_actividad IN(1,2,3,4,5,6)";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            if (rs.next()) {
                cargar();
                verificador = 1;
            } else {
                verificador = 0;
            }
            con.close();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException localException1) {
            System.out.println(localException1);
        }
//        Inicio del verificador
        if (verificador == 0) {

            if ((MakeActiv.getId_sitio() == 1) || (MakeActiv.getId_sitio() == 2) || (MakeActiv.getId_sitio() == 3) || (MakeActiv.getId_sitio() == 4)) {
                MakeActiv.setIdmaster(1);
            } else if (MakeActiv.getId_sitio() == 5) {
                MakeActiv.setIdmaster(2);
            } else if (MakeActiv.getId_sitio() == 6) {
                MakeActiv.setIdmaster(3);
            } else if (MakeActiv.getId_sitio() == 7) {
                MakeActiv.setIdmaster(4);
            } else if (MakeActiv.getId_sitio() == 8) {
                MakeActiv.setIdmaster(5);
            } else if (MakeActiv.getId_sitio() == 9) {
                MakeActiv.setIdmaster(6);
            }
            try {
//              si no existe una actividad maestra la crea
                con = Conector.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO `poa` VALUES (null,?,?,?,?,?,?)");
                ps.setInt(1, MakeActiv.getIdmaster());
                ps.setInt(2, UserDataBean.getId_usuario());
                ps.setInt(3, MakeActiv.getAnio());
                ps.setInt(4, MakeActiv.getIdclave());
                ps.setInt(5, 999);
                ps.setInt(6, 10);
                int res = ps.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "se ha creado una actividad maestra\n para 12 meses");
                } else {
                    JOptionPane.showMessageDialog(null, "Error revisar datos");
                }
                con.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public int guardar() {
        int comp = 0;
        try {
            con = Conector.getConnection();
            String query = "SELECT * FROM poa where id_actividad=" + MakeActiv.getId_actividad() + " "
                    + "AND id_usuario=" + UserDataBean.getId_usuario() + " AND anio= " + MakeActiv.getAnio() + " "
                    + "AND id_datos=" + MakeActiv.getIdclave() + " AND id_fechas=" + MakeActiv.getId_fechas() + " ";
            System.out.println("Guardar paso 1 " + query);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Error no se puede guardar la misma actividad 2 veces en el mismo mes");
            } else {
                try {
                    con = Conector.getConnection();
                    String query2 = "SELECT id_porcentaje, mes FROM poa where id_actividad='" + MakeActiv.getId_actividad() + "' "
                            + "AND id_usuario='" + UserDataBean.getId_usuario() + "' AND anio= '" + MakeActiv.getAnio() + "' "
                            + "AND id_datos='" + MakeActiv.getIdclave() + "'";
                    Statement ps2 = con.createStatement();
                    ResultSet rs2 = ps2.executeQuery(query);
                    System.out.println("Guardar paso 2 " + query2);
                    while (rs.next()) {
                        comp = comp + rs2.getInt("id_porcentaje");
                    }
                    if (comp > 10) {
                        JOptionPane.showMessageDialog(null, "ya se excedio el 100% para esta actividad en este lote");
                    } else {
                        try {
                            GetIdMes();
                            con = Conector.getConnection();
                            PreparedStatement ps3 = con.prepareStatement("INSERT INTO `poa` VALUES (null,?,?,?,?,?,?)");
                            ps3.setInt(1, MakeActiv.getId_actividad());
                            ps3.setInt(2, UserDataBean.getId_usuario());
                            ps3.setInt(3, MakeActiv.getAnio());
                            ps3.setInt(4, MakeActiv.getIdclave());
                            ps3.setInt(5, MakeActiv.getId_fechas());
                            ps3.setInt(6, MakeActiv.getIdpercent());
                            int res = ps3.executeUpdate();
                            System.out.println("Guardar paso 3 " + ps3);
                            if (res > 0) {
                                Exito();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error revisar datos");
                            }
                            con.close();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public void borrar() {
        try {
            con = Conector.getConnection();
            String query = "DELETE FROM poa WHERE id_actividad='" + MakeActiv.getId_actividad() + "' "
                    + "AND id_usuario='" + UserDataBean.getId_usuario() + "' AND id_datos='" + MakeActiv.getIdclave() + "' "
                    + "AND id_fechas='" + MakeActiv.getId_fechas() + "' ";
            System.out.println(query);
            Statement st = con.createStatement();
            int res = st.executeUpdate(query);
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "actividad: " + Actividad.getText() + " eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "a ocurrido un error");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }

    public void percentsexp() {
        if (MakeActiv.getIdpercent() == 1) {
            JavaBean.setPercent(0.1F);
            MakeActiv.setPorcentaje("10%");
        }
        if (MakeActiv.getIdpercent() == 2) {
            JavaBean.setPercent(0.2F);
            MakeActiv.setPorcentaje("20%");
        }
        if (MakeActiv.getIdpercent() == 3) {
            JavaBean.setPercent(0.3F);
            MakeActiv.setPorcentaje("30%");
        }
        if (MakeActiv.getIdpercent() == 4) {
            JavaBean.setPercent(0.4F);
            MakeActiv.setPorcentaje("40%");
        }
        if (MakeActiv.getIdpercent() == 5) {
            JavaBean.setPercent(0.5F);
            MakeActiv.setPorcentaje("50%");
        }
        if (MakeActiv.getIdpercent() == 6) {
            JavaBean.setPercent(0.6F);
            MakeActiv.setPorcentaje("60%");
        }
        if (MakeActiv.getIdpercent() == 7) {
            JavaBean.setPercent(0.7F);
            MakeActiv.setPorcentaje("70%");
        }
        if (MakeActiv.getIdpercent() == 8) {
            JavaBean.setPercent(0.8F);
            MakeActiv.setPorcentaje("80%");
        }
        if (MakeActiv.getIdpercent() == 9) {
            JavaBean.setPercent(0.9F);
            MakeActiv.setPorcentaje("90%");
        }
        if (MakeActiv.getIdpercent() == 10) {
            JavaBean.setPercent(1.0F);
            MakeActiv.setPorcentaje("100%");
        }
    }

    public void GetIdMes() {
        int idyear = año.getSelectedIndex();
        int idmonth = MakeActiv.getId_mes();
        final int base = 8;
        int formula1 = base + idyear;
        int formula2 = formula1 + ((idyear - 2) * 10);
        MakeActiv.setId_fechas(idmonth + formula2 + idyear);
    }

    public void Exito() {
        JOptionPane.showMessageDialog(null, "exito al guardar");
        cargar();
        GExito();
    }

    public void GExito() {
        Id.setEnabled(false);
        Id.setText("");
        Actividad.setEnabled(false);
        Actividad.setText("");
        Mes.setEnabled(false);
        Porcen.setEnabled(false);
        Save.setEnabled(false);
        Eliminar.setEnabled(true);
        New.setEnabled(true);
    }

    public void GNuevo() {
        Id.setEnabled(true);
        Id.setEditable(true);
        Id.setText("");
        Actividad.setEnabled(true);
        Actividad.setText("");
        Mes.setEnabled(true);
        Porcen.setEnabled(true);
        Save.setEnabled(true);
        Eliminar.setEnabled(false);
        New.setEnabled(false);
    }

    public void Esconder() {
        clave.setText("");
        clave.setEnabled(false);
        cl.setText("");
        cl.setEnabled(false);
        exp.setEnabled(false);
        Id.setText("");
        Id.setEnabled(false);
        Actividad.setText("");
        Mes.setEnabled(false);
        Porcen.setSelectedIndex(9);
        Porcen.setEnabled(false);
        Save.setEnabled(false);
        CClave.setEnabled(false);
        ELote.setEnabled(false);
        Liberar.setEnabled(false);
        New.setEnabled(false);
        Eliminar.setEnabled(false);
        sitio.setText("sitio x");
        lmf.setText("lote x");
        orden.setText("orden x");
        plantacion.setText("xxxx-xx-xx");
        superficie.setText("superficie x");
    }

    public void Liberar() {
        clave.setEnabled(false);
        cl.setEnabled(false);
        exp.setEnabled(false);
        año.setEnabled(true);
        Id.setText("");
        Id.setEnabled(true);
        Actividad.setText("");
        Mes.setEnabled(true);
        Porcen.setSelectedIndex(9);
        Porcen.setEnabled(true);
        Save.setEnabled(true);
        CClave.setEnabled(true);
        ELote.setEnabled(true);
        Liberar.setEnabled(true);
        sitio.setText("sitio x");
        lmf.setText("lote x");
        orden.setText("orden x");
        plantacion.setText("xxxx-xx-xx");
        superficie.setText("superficie x");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Actividades_crear.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividades_crear.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividades_crear.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividades_crear.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividades_crear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Actividad;
    private javax.swing.JButton CClave;
    private javax.swing.JButton ELote;
    private javax.swing.JButton Eliminar;
    public static javax.swing.JTextField Id;
    private javax.swing.JMenu Informe;
    private javax.swing.JButton Liberar;
    public static javax.swing.JComboBox<String> Mes;
    private javax.swing.JButton New;
    public static javax.swing.JComboBox<String> Porcen;
    public static javax.swing.JButton Save;
    private javax.swing.JTable TabActs;
    public javax.swing.JComboBox<String> año;
    public static javax.swing.JTextField cl;
    public static javax.swing.JTextField clave;
    public static javax.swing.JButton exp;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jtext1;
    private javax.swing.JLabel jtext2;
    private javax.swing.JLabel jtext3;
    private javax.swing.JLabel jtext5;
    private javax.swing.JLabel jtext6;
    private javax.swing.JLabel lmf;
    private javax.swing.JLabel orden;
    private javax.swing.JPanel panel1;
    private javax.swing.JLabel plantacion;
    private javax.swing.JLabel sitio;
    private javax.swing.JLabel superficie;
    // End of variables declaration//GEN-END:variables

    private void Exportar() {
        GetIdClaveEx();
        GetIdClave();
        try {
            con = Conector.getConnection();
            String query = "SELECT id_actividad, anio, id_fechas, id_porcentaje FROM poa where id_usuario='" + UserDataBean.getId_usuario() + "' "
                    + "AND anio='" + MakeActiv.getAnio() + "' AND id_datos='" + MakeActiv.getIdclave() + "'  AND id_actividad NOT IN(1,2,3,4,5,6)";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Exportar data " + query);
            while (rs.next()) {
                MakeActiv.setId_actividad(rs.getInt("id_actividad"));
                MakeActiv.setAnio(rs.getInt("anio"));
                MakeActiv.setId_mes(rs.getInt("id_fechas"));
                System.out.println(rs.getInt("id_fechas"));
                MakeActiv.setIdpercent(rs.getInt("id_porcentaje"));
                try {
                    con = Conector.getConnection();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO `poa` VALUES (null,?,?,?,?,?,?)");
                    ps.setInt(1, MakeActiv.getId_actividad());
                    ps.setInt(2, UserDataBean.getId_usuario());
                    ps.setInt(3, MakeActiv.getAnio());
                    ps.setInt(4, MakeActiv.getIdclavexp());
                    ps.setInt(5, MakeActiv.getId_mes());
                    ps.setInt(6, MakeActiv.getIdpercent());
                    int res = ps.executeUpdate();
                    System.out.println(ps);
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Se a copiado su programacion a la clave \n" + cl.getText());
                        Key.setKeyex(false);
                        clave.setText(cl.getText());
                        cl.setText("");
                        buscar();
                        Liberar();
                    }
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void GetIdClaveEx() {
        try {
            con = Conector.getConnection();
            String query = "SELECT id_datos FROM datos where clave='" + cl.getText() + "' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                MakeActiv.setIdclavexp(rs.getInt("id_datos"));
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void GetNomAct() {
        try {
            con = Conector.getConnection();
            String query = "SELECT nombre_actividad FROM actividades where id_actividad='" + Id.getText() + "' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Actividad.setVisible(true);
                Id.setEditable(false);
                Actividad.setText(rs.getString("nombre_actividad"));
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void GetIdAct(String n) {
        try {
            con = Conector.getConnection();
            String query = "SELECT id_actividad FROM actividades where nombre_actividad='" + n + "' ";
            System.out.println(query);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Id.setEditable(false);
                Id.setText(rs.getString("id_actividad"));
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void GetIdClave() {
        try {
            con = Conector.getConnection();
            String query = "SELECT id_datos FROM datos where clave='" + clave.getText() + "' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                MakeActiv.setIdclave(rs.getInt("id_datos"));
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
