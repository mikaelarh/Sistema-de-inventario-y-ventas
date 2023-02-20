package poa.vaciado;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import poa.beans.UserDataBean;
import poa.beans.VaciadoBeans;
import poa.make_excel_file.ToExcel;

/**
 *
 * @author machi
 */
public class Vaciado extends javax.swing.JFrame implements Printable {

    /**
     * Creates new form Vaciado
     */
    public Vaciado() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icon1.png")).getImage());
        setTitle("Informe General");
        jLabel4.setText(UDB.getUsuario());
        tabinf.setCellSelectionEnabled(false);
        tabinf.setDragEnabled(false);
        AñoCombo();
    }
    Calendar c = new GregorianCalendar();
    UserDataBean UDB = new UserDataBean();
    static DefaultTableModel model;
    VaciadoMetodos VM = new VaciadoMetodos();
    GetVar GV = new GetVar();
    VaciadoBeans VB = new VaciadoBeans();
    boolean first=false;
    /*carga la tabla maestra solo necesitando el año, aqui se muestran las actividades acomuladas en total
    y el costo de estas tambien cuenta con la opcion de imprimir y exportar como excel
    como extra hace un respaldo de la base de datos en la tabla del poa*/
    void cargarinforme() {
        clear();
        GV.ResetVar();
        TableColumnModel columnModel = tabinf.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(35);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(35);
        columnModel.getColumn(6).setPreferredWidth(70);
        columnModel.getColumn(7).setPreferredWidth(140);
        columnModel.getColumn(8).setPreferredWidth(150);
        columnModel.getColumn(11).setPreferredWidth(60);
        columnModel.getColumn(12).setPreferredWidth(100);
        columnModel.getColumn(13).setPreferredWidth(30);
        columnModel.getColumn(14).setPreferredWidth(70);
        columnModel.getColumn(15).setPreferredWidth(70);
        columnModel.getColumn(16).setPreferredWidth(100);
        columnModel.getColumn(17).setPreferredWidth(100);
        VM.Paso1();
    }

    private void clear() {
        model = (DefaultTableModel) tabinf.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        año = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabinf = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-ms-excel-48.png"))); // NOI18N
        jButton1.setText("Exportar a Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 170, 40));

        año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añoActionPerformed(evt);
            }
        });
        getContentPane().add(año, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabinf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de actividad", "Sitio", "BD", "Lote", "LMF", "Unidad med", "Superficie", "Receta", "Código receta", "Inicio", "Fin", "Almacén", "Código Actividad", "UM", "Precio ERP", "UM/HA", "Total UM", "$ Total"
            }
        ));
        tabinf.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabinf.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tabinf);
        tabinf.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1070, 450));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("INFORME TOTAL DE ACTIVIDADES ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        jLabel3.setText("SUPERVISOR: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        jLabel5.setText("AÑO: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 50, 10));

        jLabel7.setText("TOTAL ACOMULADO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 140, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1110, 610));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 120, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forestal.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añoActionPerformed
        if (first==true){
        int i = año.getSelectedIndex();
        VB.setAnio(Integer.valueOf(año.getSelectedItem().toString()));
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "por favor seleccione un aÑo");
        } else {
            año.setEnabled(false);
            jLabel6.setText((String) año.getSelectedItem());
            cargarinforme();
        }
        }
        first=true;
    }//GEN-LAST:event_añoActionPerformed
    /*crea una nueva tarea de impresion*/
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        utilJTablePrint(tabinf, getTitle(), "Supervisor: " + UDB.getUsuario(), true);
    }//GEN-LAST:event_jButton3ActionPerformed
    /*se encarga de pasarle la informacion al metodo que convierte la tabla a formato excel
    y guarda el resultado tratado por el metodo exportar con extencion XLS*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

ToExcel.Exportar();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void AñoCombo() {
        año.addItem("selecciona un año");
        for (int i = c.get(Calendar.YEAR); i <= 2050; i++) {
            año.addItem(Integer.toString(i));
        }
    }

    public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog) {
        boolean fitWidth = true;
        boolean interactive = true;

        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
        try {
            boolean complete = jTable.print(mode, new MessageFormat(header), new MessageFormat(footer), showPrintDialog, null, interactive);
            if (complete) {
                JOptionPane.showMessageDialog(jTable, "Print complete (Impresion completa)", "Print result (Resultado de la impresion)", 1);
            } else {
                JOptionPane.showMessageDialog(jTable, "Print canceled (Impresion cancelada)", "Print result (Resultado de la impresion)", 2);
            }
        } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(jTable, "Print fail (Fallo de impresion): " + pe
                    .getMessage(), "Print result (Resultado de la impresion)", 0);
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
            java.util.logging.Logger.getLogger(Vaciado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vaciado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vaciado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vaciado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vaciado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> año;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabinf;
    // End of variables declaration//GEN-END:variables
    /*metodo que configura las opciones de impresion*/
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        // set dimension to scale panel to print
        g2d.scale(0.70, 0.70);
        jScrollPane1.printAll(graphics);
        return PAGE_EXISTS;
    }
}
