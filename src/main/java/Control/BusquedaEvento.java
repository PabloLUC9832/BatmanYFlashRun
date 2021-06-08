package Control;

import Model.Tabla;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class BusquedaEvento implements ActionListener{
    
    Ventana v;
    Connection c;
    TableRowSorter trs, trsFiltro;
    
    public BusquedaEvento(Ventana v){
        this.v = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        v.campoBusqueda.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e){
                String cadena = v.campoBusqueda.getText();
                v.campoBusqueda.setText(cadena);
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(v.tablaBusqueda.getModel());
        v.tablaBusqueda.setRowSorter(trsFiltro);
        
        Tabla t = new Tabla(v);
        t.tablaBd();
        v.campoBusqueda.setText("");               
    }
    
    public void filtro(){
        trsFiltro.setRowFilter(RowFilter.regexFilter(v.campoBusqueda.getText(), 0));
    }
}

