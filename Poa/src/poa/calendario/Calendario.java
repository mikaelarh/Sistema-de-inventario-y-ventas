/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poa.calendario;

import poa.beans.MakeActiv;
import poa.beans.JavaBean;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import poa.beans.UserDataBean;
import poa.database.Conector;

/**
 *
 * @author machi
 */
public class Calendario extends javax.swing.JFrame implements Printable {

    /**
     * este metodo crea 3 tablas: Actividades, fechas y el informe para saber el
     * costo por lote este metodo da formato al costo como millones, cientos de
     * miles, miles y decimales
     */
    public Calendario() {
        initComponents();
        setTitle("Calendario");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icon1.png")).getImage());
        clave.setEnabled(false);
        textoenc.setText(UDB.getUsuario());
        textoenc.setEnabled(false);
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        clave.setText(bean.getClave());
        tab_calendario.setCellSelectionEnabled(false);
        tab_calendario.setDragEnabled(false);
        AñoCombo();
    }
    static DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    static DecimalFormat formateador = new DecimalFormat("###,###,###.##", simbolo);
    static float dinero = 0;
    static Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    JavaBean bean = new JavaBean();
    MakeActiv MA = new MakeActiv();
    UserDataBean UDB = new UserDataBean();
    String codigo;
    DefaultTableModel model;
    CalMetodos CM = new CalMetodos();
    Calendar c = new GregorianCalendar();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScroll1 = new javax.swing.JScrollPane();
        tab_calendario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        clave = new javax.swing.JTextField();
        jtext1 = new javax.swing.JLabel();
        jtext2 = new javax.swing.JLabel();
        jtext3 = new javax.swing.JLabel();
        jtext5 = new javax.swing.JLabel();
        jtext6 = new javax.swing.JLabel();
        sitio = new javax.swing.JLabel();
        lmf = new javax.swing.JLabel();
        orden = new javax.swing.JLabel();
        plantacion = new javax.swing.JLabel();
        superficie = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        anio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoenc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        imprimir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(880, 640));
        setName("Calendario"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAutoscrolls(true);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScroll1.setBackground(new java.awt.Color(255, 255, 255));

        tab_calendario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tab_calendario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
            }
        ));
        tab_calendario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tab_calendario.setColumnSelectionAllowed(true);
        jScroll1.setViewportView(tab_calendario);
        tab_calendario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jPanel3.add(jScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 1150, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Clave:");

        clave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                claveKeyPressed(evt);
            }
        });

        jtext1.setText("Sitio:");

        jtext2.setText("LMF:");

        jtext3.setText("Ord Prod:");

        jtext5.setText("Fecha plantacion:");

        jtext6.setText("superficie");

        sitio.setText("sitio x");

        lmf.setText("lote x");

        orden.setText("orden x");

        plantacion.setText("plantacion");

        superficie.setText("superficie");

        jLabel2.setText("AÑO:");

        anio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona el año" }));
        anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtext1)
                                        .addGap(43, 43, 43)
                                        .addComponent(sitio))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtext3)
                                            .addComponent(jtext2))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lmf)
                                            .addComponent(orden))))
                                .addGap(147, 147, 147)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtext5)
                                    .addComponent(jtext6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(superficie)
                            .addComponent(plantacion))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtext1)
                            .addComponent(sitio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtext2)
                            .addComponent(lmf)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtext5)
                            .addComponent(plantacion))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtext3)
                    .addComponent(jtext6)
                    .addComponent(orden)
                    .addComponent(superficie))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 500, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.jpg"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 40, -1, 83));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Encargado:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Programacíon de ACTIVIDADES");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("AGROPECUARIA SANTA GENOVEVA S.A.P.I. DE C.V.");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        textoenc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(textoenc, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 280, 30));

        jLabel7.setText("TOTAL ACOMULADO POR LOTE: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 130, 10));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1220, 740));

        imprimir.setBackground(new java.awt.Color(255, 255, 255));
        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        imprimir.setText("Imprimir");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, -1, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forestal.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 720));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void cargardatos(String valor) {
        clear();
        String[] registros = new String[13];
        TableColumnModel columnModel = tab_calendario.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(270);
        try {
            con = Conector.getConnection();
            String query = "SELECT fechas.mes_id,poa.id_fechas, poa.id_porcentaje, descripcion_act.actividad "
                    + "FROM poa INNER JOIN fechas ON poa.id_fechas=fechas.id_fechas "
                    + "INNER JOIN descripcion_act ON descripcion_act.id_actividad=poa.id_actividad "
                    + "where id_datos='"+MA.getIdclave()+"' AND anio='" +MA.getAnio()+"' "
                    + " AND id_usuario='"+UDB.getId_usuario()+"'";
            System.out.println(query);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            for (; rs.next(); registros[12] = null) {
                registros[0] = rs.getString("descripcion_act.actividad");
                if (rs.getInt("fechas.mes_id")==1) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[1] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 2) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[2] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 3) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[3] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 4) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[4] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 5) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[5] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 6) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[6] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 7) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[7] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 8) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[8] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 9) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[9] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 10) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[10] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 11) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[11] = String.valueOf(MA.getPorcentaje());
                }
                if (rs.getInt("fechas.mes_id")== 12) {
                    MA.setIdpercent(rs.getInt("id_porcentaje"));
                    CM.percentsexp();
                    registros[12] = String.valueOf(MA.getPorcentaje());
                }
                
                if (rs.getInt("id_fechas")==999) {
                    registros[1] = "100%";
                    registros[2] = "100%";
                    registros[3] = "100%";
                    registros[4] = "100%";
                    registros[5] = "100%";
                    registros[6] = "100%";
                    registros[7] = "100%";
                    registros[8] = "100%";
                    registros[9] = "100%";
                    registros[10] = "100%";
                    registros[11] = "100%";
                    registros[12] = "100%";
                }
                model.addRow(registros);
                registros[0] = null;
                registros[1] = null;
                registros[2] = null;
                registros[3] = null;
                registros[4] = null;
                registros[5] = null;
                registros[6] = null;
                registros[7] = null;
                registros[8] = null;
                registros[9] = null;
                registros[10] = null;
                registros[11] = null;
            }
            con.close();
            tab_calendario.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void clear() {
        model = ((DefaultTableModel) tab_calendario.getModel());
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    /*para poder ver los datos hay que seleccionar un año*/
    private void anioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioActionPerformed

        int i = anio.getSelectedIndex();
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "por favor seleccione un año");
        } else {
            anio.setEnabled(false);
            clave.setEnabled(true);
        }
    }//GEN-LAST:event_anioActionPerformed
    /*para mostrar los datos hay que darle al metodo una clave del lote y un año*/
    private void claveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            MA.setClave(clave.getText());
            MA.setAnio(Integer.parseInt(String.valueOf(anio.getSelectedItem())));
            buscar();
        }
    }//GEN-LAST:event_claveKeyPressed
    /*crea un nuevo trabajo de impresion*/
    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            if (job.printDialog()) {
                job.print();
            }
            JOptionPane.showMessageDialog(null, "Agregado a cola de impresion");
        } catch (PrinterException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_imprimirActionPerformed
// 

    void buscar() {
        try {
            con = Conector.getConnection();
            String query="SELECT id_datos, id_sitio, lmf, codigo, fecha, tamanio FROM datos "
                    + "WHERE datos.clave='"+clave.getText()+"'";
            System.out.println(query);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                String id_sitio2 = rs.getString("id_sitio");
                lmf.setText(rs.getString("lmf"));
                int lote = Integer.parseInt(rs.getString("lmf"));
                orden.setText(rs.getString("codigo"));
                plantacion.setText(rs.getString("fecha"));
                MA.setIdclave(rs.getInt("id_datos"));
                codigo = rs.getString("codigo");
                superficie.setText(rs.getString("tamanio"));
                JavaBean.setSitio(Integer.parseInt(rs.getString("id_sitio")));
                con.close();
                try {
                    con = Conector.getConnection();
                    Statement st2 = con.createStatement();
                    ResultSet rs2 = st2.executeQuery("SELECT `nombre_sitio` FROM `sitio` WHERE `id_sitio`='" + bean.getSitio() + "'");
                    if (rs2.next()) {
                        sitio.setText(rs2.getString("nombre_sitio"));
                        cargardatos(clave.getText());
                        CM.ResetVar();
                        CM.Paso1();
                        con.close();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                    System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe la clave entregada");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
//       
    
        public void AñoCombo() {
        for (int i = c.get(Calendar.YEAR); i <= 2050; i++) {
            anio.addItem(Integer.toString(i));
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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calendario().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> anio;
    private javax.swing.JTextField clave;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScroll1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jtext1;
    private javax.swing.JLabel jtext2;
    private javax.swing.JLabel jtext3;
    private javax.swing.JLabel jtext5;
    private javax.swing.JLabel jtext6;
    private javax.swing.JLabel lmf;
    private javax.swing.JLabel orden;
    private javax.swing.JLabel plantacion;
    private javax.swing.JLabel sitio;
    private javax.swing.JLabel superficie;
    public javax.swing.JTable tab_calendario;
    private javax.swing.JTextField textoenc;
    // End of variables declaration//GEN-END:variables
    /*selecciona las opciones de impresion y retorna si existen paginas*/
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        // set dimension to scale panel to print
        g2d.scale(0.60, 0.60);
        tab_calendario.printAll(graphics);
        return PAGE_EXISTS;
    }
}
