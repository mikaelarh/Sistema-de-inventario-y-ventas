/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import tiendita.Conexiones.conexion;
import tiendita.Usuarios.UserNameBeans;

/**
 *
 * @author Mikaela Estefania Ramirez Herrera <Estefania_mikaela@hotmail.com>
 */
public class PanelVentas extends javax.swing.JFrame {

    /**
     * Creates new form PanelVentas
     */
    public PanelVentas() {
        initComponents();
        setTitle("Punto de Ventas");
        TP();
        TablaProd.setDefaultEditor(Object.class, null);
        clear2();
        user.setText(unb.getNombre());
        calendar.setTime(date);
        OnSesionStart();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximizado
        this.toFront();
        this.getContentPane().setBackground(Color.white);
        TabVenta.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 14));
        TablaProd.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 14));

    }

    DefaultTableModel model;
    DefaultTableModel model2;
    static Connection con;
    UserNameBeans unb = new UserNameBeans();
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    DateFormat hour = new SimpleDateFormat("HH:mm");
    DateFormat day = new SimpleDateFormat("dd");
    DateFormat month = new SimpleDateFormat("MM");
    DateFormat year = new SimpleDateFormat("yyyy");
    Calendar calendar = Calendar.getInstance();
    double total = 0;
    double caja = 0;
    int delfil = 0;
    int idsesion = getid1();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProd = new javax.swing.JTable();
        buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        producto = new javax.swing.JLabel();
        presentacion = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabVenta = new javax.swing.JTable();
        vender = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        ttl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TablaProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Presentacion", "Precio total", "Total en inventario"
            }
        ));
        TablaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProd);
        if (TablaProd.getColumnModel().getColumnCount() > 0) {
            TablaProd.getColumnModel().getColumn(0).setMinWidth(50);
            TablaProd.getColumnModel().getColumn(0).setPreferredWidth(50);
            TablaProd.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar:");

        producto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        producto.setText("Null");

        presentacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presentacion.setText("Null");

        precio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precio.setText("Null");

        agregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        TabVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TabVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Producto", "Presentacion", "Precio", "Cantidad"
            }
        ));
        TabVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabVentaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabVenta);
        if (TabVenta.getColumnModel().getColumnCount() > 0) {
            TabVenta.getColumnModel().getColumn(0).setMinWidth(50);
            TabVenta.getColumnModel().getColumn(0).setPreferredWidth(50);
            TabVenta.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        vender.setBackground(new java.awt.Color(0, 153, 102));
        vender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vender.setText("Finalizar Venta");
        vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Usuario: @");

        cantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("$");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Producto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Presentacion:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Precio:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cantidad:");

        user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user.setText("jLabel8");

        eliminar.setBackground(new java.awt.Color(255, 102, 102));
        eliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminar.setText("Eliminar Seleccionado");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        ttl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ttl.setText("Total: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ttl, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(eliminar)
                                .addGap(67, 67, 67)
                                .addComponent(vender))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(agregar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(user))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(producto)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(presentacion)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(precio)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ttl))
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProdMouseClicked
        int fil = TablaProd.getSelectedRow();
        if (fil >= 0) {
            id.setText(TablaProd.getValueAt(fil, 0).toString());
            producto.setText(TablaProd.getValueAt(fil, 1).toString());
            presentacion.setText(TablaProd.getValueAt(fil, 2).toString());
            precio.setText(TablaProd.getValueAt(fil, 3).toString());
        } else {
            JOptionPane.showMessageDialog(null, "No Se A Seleccionado Una Fila");
        }
    }//GEN-LAST:event_TablaProdMouseClicked

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        int fil = TablaProd.getSelectedRow();
        if (isNumeric(cantidad.getText()) == false) {
            JOptionPane.showMessageDialog(null, "ingrese un numero");
        } else {
            if (cantidad.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "ingrese un numero");
            } else {
                if (producto.getText().equals("Null")) {
                    JOptionPane.showMessageDialog(null, "No existe un producto");
                } else {
                    if (Double.parseDouble(cantidad.getText()) > Double.parseDouble(TablaProd.getValueAt(fil, 4).toString())) {
                        JOptionPane.showMessageDialog(null, "La cantidad que desea vender excede el inventario total");
                    } else {
                        double preciof = Double.parseDouble(precio.getText());
                        double factor = Double.parseDouble(cantidad.getText());
                        total = total + (preciof * factor);
                        ttl.setText("Total: $" + total);
                        String[] registros = new String[5];
                        TableColumnModel columnModel = TabVenta.getColumnModel();
                        registros[0] = id.getText();
                        registros[1] = producto.getText();
                        registros[2] = presentacion.getText();
                        registros[3] = String.valueOf(preciof * factor);
                        registros[4] = cantidad.getText();
                        model2.addRow(registros);
                        TabVenta.setModel(model2);
                        producto.setText("Null");
                        presentacion.setText("Null");
                        precio.setText("Null");
                        cantidad.setText("");
                    }
                }
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        TB();
    }//GEN-LAST:event_buscarKeyTyped

    private void venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderActionPerformed
        if (!(TabVenta.getValueAt(0, 1).toString()).equals(null)) {
            GuardarDV(getid());
            for (int i = 0; i < TabVenta.getRowCount(); i++) {
                GuardarProd(getid2(), getlastid(), Integer.parseInt(TabVenta.getValueAt(i, 0).toString()), TabVenta.getValueAt(i, 1).toString(), TabVenta.getValueAt(i, 2).toString(),
                        Float.parseFloat(TabVenta.getValueAt(i, 3).toString()), Float.parseFloat(TabVenta.getValueAt(i, 4).toString()));
                caja = caja + total;
            }
            TP();
            Double Cambio = Double.parseDouble(JOptionPane.showInputDialog("Inserte la cantidad con la que se Paga"));
            JOptionPane.showMessageDialog(null, "El Cambio es de $" + (Cambio - total), "Alerta", JOptionPane.WARNING_MESSAGE);
            total = 0;
            ttl.setText("Total: $0");
            clear2();
        } else {
            JOptionPane.showMessageDialog(null, "Tabla vacia");
        }
    }//GEN-LAST:event_venderActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        double resta = Double.parseDouble(TabVenta.getValueAt(delfil, 3).toString());
        total = total - resta;
        ttl.setText("Total: $" + total);
        model2 = ((DefaultTableModel) TabVenta.getModel());
        model2.removeRow(TabVenta.getSelectedRow());
        TabVenta.setModel(model2);
    }//GEN-LAST:event_eliminarActionPerformed

    private void TabVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabVentaMouseClicked
        delfil = TabVenta.getSelectedRow();
    }//GEN-LAST:event_TabVentaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "Desea finalizar la sesion", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            OnSesionEnd();
            if (unb.getSesion() == 1) {
                this.setVisible(false);
            } else {
                UpdateSesion();
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La Sesion no Finalizo");
        }
    }//GEN-LAST:event_formWindowClosing
    public void TP() {
        cargar();
    }

    public void TB() {
        buscarcargar();
    }

    private void cargar() {
        clear();
//        titulos();
        String[] registros = new String[5];
        TableColumnModel columnModel = TablaProd.getColumnModel();
        try {
            con = conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT `Id`,`Producto`,`Um1`,`P1`,`C1` FROM `inventario` WHERE C1>0 ORDER BY Producto ASC");
            while (rs.next()) {
                registros[0] = rs.getString("Id");
                registros[1] = rs.getString("Producto");
                registros[2] = rs.getString("Um1");
                registros[3] = rs.getString("P1");
                registros[4] = rs.getString("C1");
                model.addRow(registros);
            }
            TablaProd.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void buscarcargar() {
        clear();
//        titulos();
        String[] registros = new String[5];
        TableColumnModel columnModel = TablaProd.getColumnModel();
        try {
            con = conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT `Id`,`Producto`,`Um1`,`P1`,`C1` FROM `inventario` where producto LIKE '" + buscar.getText() + "%" + "' ORDER BY Producto ASC");
            while (rs.next()) {
                registros[0] = rs.getString("Id");
                registros[1] = rs.getString("Producto");
                registros[2] = rs.getString("Um1");
                registros[3] = rs.getString("P1");
                registros[4] = rs.getString("C1");
                model.addRow(registros);
            }
            TablaProd.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void clear() {
        model = ((DefaultTableModel) TablaProd.getModel());
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void clear2() {
        model2 = ((DefaultTableModel) TabVenta.getModel());
        while (model2.getRowCount() > 0) {
            model2.removeRow(0);
        }
    }

    public void GuardarProd(int id, int id2, int idp, String prod, String pre, float tprod, double cant) {
        try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `reporte_venta` VALUES (?,?, ?, ?, ?, ?, ?)"); //siempre poner el primer dato NULL
            ps.setInt(1, id);
            ps.setInt(2, id2);
            ps.setInt(3, idp);
            ps.setString(4, prod);
            ps.setString(5, pre);
            ps.setFloat(6, tprod);
            ps.setDouble(7, cant);
            int res = ps.executeUpdate();
            if (res > 0) { // cuando es mayor que cero significa que se inserto un dato en la base
                Restar(idp, cant);
            } else {
                JOptionPane.showMessageDialog(null, "A ocurrido un error");
            }
            con.close(); //siempre cerrar las conexiones despues de usarlas
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex); // imprime el error si hay
        }
    }

    public void GuardarDV(int id) {
        try {
            int nowy = calendar.get(Calendar.WEEK_OF_YEAR);
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `reporte_info` VALUES ('" + id + "',?,?, ?, ?, ?, ? ,? ,?)"); //siempre poner el primer dato NULL
            ps.setInt(1, unb.getIduser());
            ps.setDouble(2, total);
            ps.setString(3, dateFormat.format(date));
            ps.setString(4, hour.format(date));
            ps.setInt(5, Integer.parseInt(day.format(date)));
            ps.setInt(6, nowy);
            ps.setInt(7, Integer.parseInt(month.format(date)));
            ps.setInt(8, Integer.parseInt(year.format(date)));
            int res = ps.executeUpdate();
            if (res > 0) { // cuando es mayor que cero significa que se inserto un dato en la base
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "A ocurrido un error");
            }
            con.close(); //siempre cerrar las conexiones despues de usarlas
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex); // imprime el error si hay
        }
    }

    public void Restar(int id, Double cant) {
        try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("UPDATE `inventario` SET C1=C1-" + cant + " WHERE `Id`='" + id + "'"); //siempre poner el primer dato NULL
            int res = ps.executeUpdate();
            con.close(); //siempre cerrar las conexiones despues de usarlas
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex); // imprime el error si hay
        }
    }

    public int getid() {
        try {
            con = conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Id FROM `reporte_info` ORDER BY Id DESC LIMIT 1");
            if (rs.next()) {
                return rs.getInt("Id") + 1;
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 1;
    }

    public int getid2() {
        try {
            con = conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Id FROM `reporte_venta` ORDER BY Id DESC LIMIT 1");
            if (rs.next()) {
                return rs.getInt("Id") + 1;
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 1;
    }

    public int getlastid() {
        try {
            con = conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Id FROM `reporte_info` ORDER BY Id DESC LIMIT 1");
            if (rs.next()) {
                return rs.getInt("Id");
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 1;
    }

    private static boolean isNumeric(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private void OnSesionStart() {
        caja = Double.parseDouble(JOptionPane.showInputDialog("Inserte la cantidad En la Caja"));
        int nowy = calendar.get(Calendar.WEEK_OF_YEAR);
        try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `registros` VALUES (? ,?, ?, ?, ?,null,null,null,?,'Vendedor')"); //siempre poner el primer dato NULL
            ps.setInt(1, idsesion);
            ps.setInt(2, unb.getIduser());
            ps.setString(3, dateFormat.format(date));
            ps.setString(4, hour.format(date));
            ps.setDouble(5, caja);
            ps.setInt(6, nowy);
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

    private void OnSesionEnd() {
        try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("UPDATE `registros` SET `FechaDeCierre`=?,"
                    + "`HoraDeCierre`=?,`CajaFinal`=? WHERE Id='" + idsesion + "'");
            ps.setString(1, dateFormat.format(date));
            ps.setString(2, hour.format(date));
            ps.setDouble(3, caja);
            int res = ps.executeUpdate();
            if (res > 0) {
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
            PreparedStatement ps = con.prepareStatement("UPDATE `usuarios` SET `Sesion`=0 WHERE IdUsuario='" + unb.getIduser() + "'");
            int res = ps.executeUpdate();
            con.close(); //siempre cerrar las conexiones despues de usarlas
        } catch (Exception ex) {
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
            java.util.logging.Logger.getLogger(PanelVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabVenta;
    private javax.swing.JTable TablaProd;
    private javax.swing.JButton agregar;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel presentacion;
    private javax.swing.JLabel producto;
    private javax.swing.JLabel ttl;
    private javax.swing.JLabel user;
    private javax.swing.JButton vender;
    // End of variables declaration//GEN-END:variables
}
