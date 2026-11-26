package com.mycompany.proyectodb;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class jdlCotizacion extends JDialog {
    private final JTextField txtNumCotizacion=new JTextField(14), txtDescripcion=new JTextField(24), txtPrecio=new JTextField(14);
    private final JSpinner spnPorcentaje=new JSpinner(new SpinnerNumberModel(0.0,0.0,100.0,1.0));
    private final JDateChooser jdcFecha=new JDateChooser();
    private final JRadioButton rdb12=new JRadioButton("12 meses"), rdb24=new JRadioButton("24 meses"), rdb36=new JRadioButton("36 meses"), rdb48=new JRadioButton("48 meses");
    private final JLabel lblPagoInicial=new JLabel("$ 0.00"), lblTotalFin=new JLabel("$ 0.00"), lblPagoMensual=new JLabel("$ 0.00");
    private final JButton btnBuscar=new JButton("Buscar"), btnNuevo=new JButton("Nuevo"), btnGuardar=new JButton("Guardar"), btnHabilitar=new JButton("Habilitar"), btnDeshabilitar=new JButton("Deshabilitar"), btnLimpiar=new JButton("Limpiar"), btnCancelar=new JButton("Cancelar"), btnCerrar=new JButton("Cerrar");
    private final JComboBox<String> cmbStatus=new JComboBox<>(new String[]{"Activas","Inactivas"});
    private final DefaultTableModel modelo=new DefaultTableModel(new String[]{"ID","Número","Descripción","Precio","Fecha"},0) { public boolean isCellEditable(int r,int c){return false;} };
    private final JTable tbDatos=new JTable(modelo);
    private final CotizacionDb db=new CotizacionDb();
    private Cotizacion cotizacion=new Cotizacion();
    private boolean editando=false;
    public jdlCotizacion() {
        super((Frame)null,"Cotización",true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        construir(); limpiar(); deshabilitar();
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){cerrarVentana();}});
        pack(); setMinimumSize(new Dimension(760,520)); setLocationRelativeTo(null); cargarTabla();
    }
    private void construir() {
        JPanel raiz=new JPanel(new BorderLayout(12,12)); raiz.setBorder(BorderFactory.createEmptyBorder(16,16,16,16)); setContentPane(raiz);
        JPanel superior=new JPanel(new BorderLayout(12,8)); JPanel campos=new JPanel(new GridLayout(0,2,8,8));
        JPanel numero=new JPanel(new BorderLayout(5,0)); numero.add(txtNumCotizacion); numero.add(btnBuscar,BorderLayout.EAST);
        campos.add(new JLabel("Num. Cotización")); campos.add(numero); campos.add(new JLabel("Descripción")); campos.add(txtDescripcion); campos.add(new JLabel("Porcentaje (%)")); campos.add(spnPorcentaje); campos.add(new JLabel("Precio")); campos.add(txtPrecio); campos.add(new JLabel("Fecha")); campos.add(jdcFecha); jdcFecha.setDateFormatString("dd/MM/yyyy");
        JPanel plazos=new JPanel(new FlowLayout(FlowLayout.LEFT,3,0)); ButtonGroup grupo=new ButtonGroup(); for(JRadioButton b:new JRadioButton[]{rdb12,rdb24,rdb36,rdb48}) {grupo.add(b);plazos.add(b);b.addActionListener(e->calcular());} campos.add(new JLabel("Plazos")); campos.add(plazos);
        superior.add(campos); JPanel acciones=new JPanel(new GridLayout(0,1,5,8)); for(JButton b:new JButton[]{btnNuevo,btnGuardar,btnDeshabilitar,btnHabilitar}) acciones.add(b); superior.add(acciones,BorderLayout.EAST);
        JPanel resultados=new JPanel(new GridLayout(2,3,8,8)); resultados.setBackground(new Color(218,211,250)); resultados.setBorder(BorderFactory.createEmptyBorder(12,12,12,12)); for(String s:new String[]{"Pago Inicial","Total a Financiar","Pago Mensual"}) resultados.add(new JLabel(s,SwingConstants.CENTER)); for(JLabel l:new JLabel[]{lblPagoInicial,lblTotalFin,lblPagoMensual}) {l.setHorizontalAlignment(SwingConstants.CENTER); resultados.add(l);} superior.add(resultados,BorderLayout.SOUTH); raiz.add(superior,BorderLayout.NORTH);
        JPanel centro=new JPanel(new BorderLayout(4,4)); JPanel filtro=new JPanel(); filtro.add(new JLabel("Mis Cotizaciones")); filtro.add(cmbStatus); centro.add(filtro,BorderLayout.NORTH); centro.add(new JScrollPane(tbDatos)); raiz.add(centro);
        JPanel inferior=new JPanel(); for(JButton b:new JButton[]{btnLimpiar,btnCancelar,btnCerrar}) inferior.add(b); raiz.add(inferior,BorderLayout.SOUTH);
        btnNuevo.addActionListener(e->{limpiar();habilitar();txtNumCotizacion.requestFocusInWindow();});
        btnLimpiar.addActionListener(e->{limpiar(); if(!editando) deshabilitar();});
        btnCancelar.addActionListener(e->{limpiar();deshabilitar();}); btnCerrar.addActionListener(e->cerrarVentana());
        btnGuardar.addActionListener(e->guardar()); btnBuscar.addActionListener(e->buscar()); btnHabilitar.addActionListener(e->cambiarEstado(true)); btnDeshabilitar.addActionListener(e->cambiarEstado(false));
        cmbStatus.addActionListener(e->{limpiar();deshabilitar();cargarTabla();});
        tbDatos.getSelectionModel().addListSelectionListener(e->{if(!e.getValueIsAdjusting() && tbDatos.getSelectedRow()>=0){int id=(Integer)modelo.getValueAt(tbDatos.getSelectedRow(),0); Cotizacion c=(Cotizacion)db.buscarId(id); if(c!=null) mostrarDatos(c); else mostrarMensaje(db.getError());}});
        spnPorcentaje.addChangeListener(e->calcular()); txtPrecio.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){public void insertUpdate(javax.swing.event.DocumentEvent e){calcular();}public void removeUpdate(javax.swing.event.DocumentEvent e){calcular();}public void changedUpdate(javax.swing.event.DocumentEvent e){calcular();}});
    }
    private int plazo(){return rdb48.isSelected()?48:rdb36.isSelected()?36:rdb24.isSelected()?24:12;}
    private void calcular(){try{Cotizacion c=new Cotizacion();c.setPrecio(Float.parseFloat(txtPrecio.getText().trim()));c.setPorcentaje(((Number)spnPorcentaje.getValue()).floatValue());c.setPlazos(plazo()); mostrarCalculos(c);}catch(NumberFormatException e){mostrarCalculos(new Cotizacion());}}
    private void mostrarCalculos(Cotizacion c){lblPagoInicial.setText(String.format("$ %.2f",c.calcularPagoInicial()));lblTotalFin.setText(String.format("$ %.2f",c.calcularTotalFin()));lblPagoMensual.setText(String.format("$ %.2f",c.calcularPagoMensual()));}
    public void limpiar(){cotizacion=new Cotizacion();txtNumCotizacion.setText("");txtDescripcion.setText("");txtPrecio.setText("");spnPorcentaje.setValue(0.0);rdb12.setSelected(true);jdcFecha.setDate(new java.util.Date());mostrarCalculos(cotizacion);tbDatos.clearSelection();btnHabilitar.setEnabled(false);btnDeshabilitar.setEnabled(false);}
    private void controles(boolean b){for(JComponent c:new JComponent[]{txtDescripcion,txtPrecio,spnPorcentaje,jdcFecha,rdb12,rdb24,rdb36,rdb48,btnGuardar}) c.setEnabled(b);txtNumCotizacion.setEnabled(true);editando=b;}
    public void habilitar(){controles(true);btnNuevo.setEnabled(false);btnCancelar.setEnabled(true);}
    public void deshabilitar(){controles(false);btnNuevo.setEnabled(true);btnCancelar.setEnabled(false);btnHabilitar.setEnabled(false);btnDeshabilitar.setEnabled(false);}
    public boolean validar(){try{spnPorcentaje.commitEdit();float p=Float.parseFloat(txtPrecio.getText().trim());float porcentaje=((Number)spnPorcentaje.getValue()).floatValue();if(txtNumCotizacion.getText().trim().isEmpty()||txtDescripcion.getText().trim().isEmpty()||!Float.isFinite(p)||p<=0||porcentaje<0||porcentaje>100||jdcFecha.getDate()==null)throw new IllegalArgumentException();return true;}catch(Exception e){mostrarMensaje("Completa los campos. El precio debe ser positivo y el porcentaje de 0 a 100.");return false;}}
    public Cotizacion llenarObjeto(){return new Cotizacion(cotizacion.getIdCotizacion(),txtNumCotizacion.getText().trim(),txtDescripcion.getText().trim(),((Number)spnPorcentaje.getValue()).floatValue(),Float.parseFloat(txtPrecio.getText().trim()),plazo(),new java.sql.Date(jdcFecha.getDate().getTime()),cotizacion.getStatus());}
    public void mostrarDatos(Cotizacion c){cotizacion=c;txtNumCotizacion.setText(c.getNumCotizacion());txtDescripcion.setText(c.getDescripcion());txtPrecio.setText(Float.toString(c.getPrecio()));spnPorcentaje.setValue((double)c.getPorcentaje());jdcFecha.setDate(c.getFecha());(c.getPlazos()==48?rdb48:c.getPlazos()==36?rdb36:c.getPlazos()==24?rdb24:rdb12).setSelected(true);mostrarCalculos(c);habilitar();btnHabilitar.setEnabled(c.getStatus()==1);btnDeshabilitar.setEnabled(c.getStatus()==0);}
    public void mostrarMensaje(String mensaje){JOptionPane.showMessageDialog(this,mensaje);}
    private void guardar(){if(!validar())return;Cotizacion c=llenarObjeto();int r=c.getIdCotizacion()==0?db.insertar(c):db.actualizar(c);if(r>0){mostrarMensaje("Cotización guardada.");limpiar();deshabilitar();cargarTabla();}else mostrarMensaje(r<0?db.getError():"No se guardaron cambios.");}
    private void buscar(){String n=txtNumCotizacion.getText().trim();if(n.isEmpty()){mostrarMensaje("Escribe el número de cotización.");return;}Cotizacion c=(Cotizacion)db.buscar(n);if(c!=null)mostrarDatos(c);else mostrarMensaje(db.getError().isEmpty()?"Cotización no encontrada.":db.getError());}
    private void cambiarEstado(boolean activo){if(cotizacion.getIdCotizacion()==0)return;int r=activo?db.habilitar(cotizacion.getIdCotizacion()):db.deshabilitar(cotizacion.getIdCotizacion());if(r>0){limpiar();deshabilitar();cargarTabla();}else mostrarMensaje(r<0?db.getError():"Sin cambios.");}
    private void cargarTabla(){modelo.setRowCount(0);try(ResultSet r=cmbStatus.getSelectedIndex()==0?db.buscarActivos():db.buscarNoActivos()){if(r==null){mostrarMensaje("No se pudo consultar MySQL: "+db.getError());return;}while(r.next()){Cotizacion c=CotizacionDb.leer(r);modelo.addRow(new Object[]{c.getIdCotizacion(),c.getNumCotizacion(),c.getDescripcion(),c.getPrecio(),c.getFecha()});}}catch(SQLException e){mostrarMensaje(e.getMessage());}}
    private void cerrarVentana(){if(JOptionPane.showConfirmDialog(this,"¿Deseas cerrar la ventana?","Confirmar",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){db.cerrar();dispose();}}
    public static void main(String[] args){SwingUtilities.invokeLater(()->new jdlCotizacion().setVisible(true));}
}
