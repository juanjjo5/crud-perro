package Controller;

import Model.Rico;
import Model.RicoDAO;
import Vista.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    RicoDAO dao = new RicoDAO();
    Rico rico = new Rico();
    vista vista = new vista();
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(vista v) {
        this.vista = v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnDelete.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);

    }

    void nuevo() {
        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.txtEdad.setText("");
        vista.txtOrigen.setText("");
        vista.txtFortuna.setText("");

    }

    void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void delete() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "seleccione un registro");
        } else {
            int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
            dao.delete(id);
            JOptionPane.showMessageDialog(vista, "registro eliminado");
        }
        limpiarTabla();

    }

    public void add() {
        String nom = vista.txtNombre.getText();
        int edad = Integer.parseInt(vista.txtEdad.getText());
        String origen = vista.txtOrigen.getText();
        int fortuna = Integer.parseInt(vista.txtFortuna.getText());
        rico.setNombre(nom);
        rico.setEdad(edad);
        rico.setOrigen(origen);
        rico.setFortuna(fortuna);
        int r = dao.agregar(rico);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "si lo pudo agregar");
        } else {
            JOptionPane.showMessageDialog(vista, "no lo pudo agregar");
        }
        limpiarTabla();

    }

    public void actualizar() {
        if (vista.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(vista, "seleccione primero");
        } else {
            int id = Integer.parseInt(vista.txtId.getText());
            String nom = vista.txtNombre.getText();
            int edad = Integer.parseInt(vista.txtEdad.getText());
            String origen = vista.txtOrigen.getText();
            int fortuna = Integer.parseInt(vista.txtFortuna.getText());
            rico.setId(id);
            rico.setNombre(nom);
            rico.setEdad(edad);
            rico.setOrigen(origen);
            rico.setFortuna(fortuna);
            int r = dao.actualizar(rico);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "si lo pudo actualizar");
            } else {
                JOptionPane.showMessageDialog(vista, "no lo pudo actualizar");
            }
        }
        limpiarTabla();

    }

    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Rico> lista = dao.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getEdad();
            objeto[3] = lista.get(i).getOrigen();
            objeto[4] = lista.get(i).getFortuna();
            modelo.addRow(objeto);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnListar) {
            limpiarTabla();
            listar(vista.tabla);
            nuevo();
            if (e.getSource() == vista.btnAgregar) {
                add();
                listar(vista.tabla);
                nuevo();
            }
            if (e.getSource() == vista.btnEditar) {
                int fila = vista.tabla.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(vista, "seleccione uno ");

                } else {
                    int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                    String nom = (String) vista.tabla.getValueAt(fila, 1);
                    int edad = Integer.parseInt(vista.tabla.getValueAt(fila, 2).toString());
                    String origen = (String) vista.tabla.getValueAt(fila, 3);
                    int fortuna = Integer.parseInt(vista.tabla.getValueAt(fila, 4).toString());
                    vista.txtId.setText("" + id);
                    vista.txtNombre.setText(nom);
                    vista.txtEdad.setText("" + edad);
                    vista.txtOrigen.setText(origen);
                    vista.txtFortuna.setText("" + fortuna);
                }
            }
            if (e.getSource() == vista.btnActualizar) {
                actualizar();
                listar(vista.tabla);
                nuevo();
            }
            if (e.getSource() == vista.btnDelete) {
                delete();
                listar(vista.tabla);
                nuevo();
            }
            if (e.getSource() == vista.btnNuevo) {
                nuevo();
            }
        }

    }

}
