package Vista;

import Control.ActualizarEvento;
import Control.BusquedaEvento;
import Control.EliminarEvento;
import Control.ReporteEvento;
import Model.Tabla;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Ventana extends JFrame {
    
    public JTextField campoBusqueda,campoUsuario,campoPuntaje,campoHora,campoFecha;
    public JButton btnEditar, btnActualizar,btnImprimir;
    public JTable tablaBusqueda;
    public JScrollPane jp;
    
    JPopupMenu jmp;
    JMenuItem eliminar;
  
    public Ventana(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));

        JPanel panel1 = new JPanel();
	panel1.setLayout(new GridLayout(5,1));
	this.add(panel1);
        
        panel1.add(new JLabel("Ingresa tu busqueda "));
        campoBusqueda = new JTextField(20);
        panel1.add(campoBusqueda);
        BusquedaEvento be = new BusquedaEvento(this);
        campoBusqueda.addActionListener(be);
        
        panel1.add(new JLabel("Ingresa el nuevo nombre "));
        campoUsuario = new JTextField(20);
        panel1.add(campoUsuario);
        
        panel1.add(new JLabel("Ingresa el nuevo puntaje "));
        campoPuntaje = new JTextField(20);
        panel1.add(campoPuntaje);
        
        panel1.add(new JLabel("Ingresa la nueva hora "));
        campoHora = new JTextField(20);
        panel1.add(campoHora);        

        panel1.add(new JLabel("Ingresa la nueva fecha"));
        campoFecha = new JTextField(20);
        panel1.add(campoFecha);
        
        JPanel panel2 = new JPanel();
        this.add(panel2, new FlowLayout());
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        btnActualizar = new JButton ("Actualizar Datos");
        panel2.add(btnActualizar);
        ActualizarEvento ae = new ActualizarEvento(this);
        btnActualizar.addActionListener(ae);
        
        btnEditar = new JButton("Editar");
        panel2.add(btnEditar);
        btnEditar.addActionListener(ae);
        
        btnImprimir = new JButton("Imprimir");
        panel2.add(btnImprimir);
        ReporteEvento rep = new ReporteEvento(this);
        btnImprimir.addActionListener(rep);
        
        JPanel panel3 = new JPanel();
        this.add(panel3, new FlowLayout());
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        tablaBusqueda = new JTable();
        Tabla t = new Tabla(this);
        t.tablaBd();
        
        jp = new JScrollPane(tablaBusqueda);
        jp.setViewportView(tablaBusqueda);
        panel3.add(jp);
        
        jmp = new JPopupMenu();
        eliminar = new JMenuItem();      
        eliminar.setText("Eliminar");
        jmp.add(eliminar);
        panel3.add(jmp);
        tablaBusqueda.setComponentPopupMenu(jmp);
        
        EliminarEvento ee = new EliminarEvento(this);
        eliminar.addActionListener(ee);               
        
        visibilidad(false);
        this.setSize(500,620);
        this.setTitle("CRUD");
	this.setVisible(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);

    }
      
    public void visibilidad(boolean vs){
        
        campoUsuario.setEnabled(vs);
        campoPuntaje.setEnabled(vs);
        campoHora.setEnabled(vs);
        campoFecha.setEnabled(vs);        
    }
}


