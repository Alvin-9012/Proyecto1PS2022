package com.mycompany.proyecto2ipc1.Swing.Damas;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Seleccion_de_modo extends JFrame implements ActionListener{

	private Label rojas,negras,vs,manual;
	
	private JButton boton1,boton2;
	
	private JComboBox<Object> combo1;
	
	private Principal principal;
	
	private PanelDeJuego panelDeJuego;
	
	public void iniciar() {
		
		boton1= new JButton("Cambiar Modo");
		boton1.setBounds(50,70,140,30);
		boton1.addActionListener(this);
		
		boton2= new JButton("Salir");
		boton2.setBounds(220,70,100,30);
		boton2.addActionListener(this);
		
		rojas = new Label("Rojas");
		rojas.setBounds(120,10,35,20);
		negras = new Label("Azules");
		negras.setBounds(230,10,50,20);
		vs = new Label("VS");
		vs.setBounds(185, 35, 30, 20);
                manual = new Label("Manual");
                manual.setBounds(220,35,70,20);
		
		combo1 = new JComboBox<>();
		combo1.addItem("");
		combo1.addItem("Automatico");
		combo1.addItem("Manual");
//		combo2 = new JComboBox<>();
//		combo2.addItem("");
//		combo2.addItem("Automatico");
//		combo2.addItem("Manual");
		
		combo1.setBounds(100,35,70,20);
		//combo2.setBounds(220,35,70,20);
	}
	
	public Seleccion_de_modo(Principal Pprincipal,PanelDeJuego juego) {
		iniciar();
		principal = Pprincipal;
		panelDeJuego = juego;
		setLayout(null);
		getContentPane().add(rojas);
		getContentPane().add(negras);
		getContentPane().add(combo1);
		//getContentPane().add(combo2);
		getContentPane().add(vs);
		getContentPane().add(manual);
		getContentPane().add(boton1);
		getContentPane().add(boton2);
		setResizable(false);
		setSize(400,150);
		setLocationRelativeTo(principal);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void abrir() {
		
	}
	
	@SuppressWarnings("null")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			if(combo1.getSelectedIndex() == 0 /**|| combo2.getSelectedIndex() == 0*/) {
				JOptionPane.showMessageDialog(principal,"Los Campos No Pueden Estar Vacios");
			}else {
				panelDeJuego.cambiar(combo1.getSelectedIndex(), 2/*combo2.getSelectedIndex()*/);
                                principal.IniciarCronometro();
				dispose();
			}
		}else {
			dispose();
		}
		
	}
}
