package com.mycompany.proyecto2ipc1.Swing.Damas;

import com.mycompany.proyecto2ipc1.Swing.Damas.Users.MainWindow;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class PanelBarraDeHerramientas extends JPanel implements ActionListener{

        private boolean tiempo;
        
        private Cronometro cronometro;
        
        private int minutos, segundos;
        
	private JMenu menu;
	
	private JMenuBar barra;
	
	private JMenuItem nuevapartida,salir,cambiar_modo, guardarPartida;
	
	private Principal principal;
	
	private PanelDeJuego panelDeJuego;
        
        private MainWindow mainWindow;
        
        private String directorioPartidasGuardadas = "/home/alvin/NetBeansProjects/Proyecto2Ipc1/ArchivosJuegos/PartidasGuardadas/Damas/";
	
        private String directorioPartidasCronometros = "/home/alvin/NetBeansProjects/Proyecto2Ipc1/ArchivosJuegos/PartidasGuardadas/Cronometros/";
	
	private void iniciar() {
            //Aqui colocar el Cronometro
		nuevapartida = new JMenuItem("Nueva partida");
		cambiar_modo = new JMenuItem("Cambiar Modo");
		guardarPartida = new JMenuItem("Guardar Partida");
		salir = new JMenuItem("Salir");
		menu = new JMenu("Elija Opcion");
		menu.add(nuevapartida);
		menu.add(cambiar_modo);
                menu.add(guardarPartida);
		menu.add(salir);
		cambiar_modo.addActionListener(this);
		nuevapartida.addActionListener(this);
                guardarPartida.addActionListener(this);
		salir.addActionListener(this);
		barra = new JMenuBar();
		barra.add(menu);
	}
	
	private void alinear() {
		setLayout(new BorderLayout());
		add(barra,BorderLayout.CENTER);
	}
	
	public PanelBarraDeHerramientas(Principal Pprincipal,PanelDeJuego juego, MainWindow mainWindow, boolean tiempo, int minutos, int segundos) {
                this.mainWindow = mainWindow;
                this.tiempo = tiempo;
                this.minutos = minutos;
                this.segundos = segundos;
		iniciar();
		alinear();
		panelDeJuego = juego;
		principal = Pprincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nuevapartida) {
			new NuevaPartida(principal,panelDeJuego).abrir();
                        cronometro = new Cronometro();
                        
		}
		if(e.getSource() == salir) {
                        cronometro.stop();
                        cronometro.dispose();
			principal.dispose();
                        mainWindow.setVisible(true);
		}
		if(e.getSource() == cambiar_modo) {
			new Seleccion_de_modo(principal,panelDeJuego).abrir();
                        if (tiempo) {
                        cronometro = new Cronometro(this.minutos, this.segundos);
                    }else{
                        }
		}
		if(e.getSource() == guardarPartida) {
                        cronometro.stop();
                        new SaveGame(this).writeFiles(directorioPartidasGuardadas, principal.getUsers().getFirstName().trim(),".txt", panelDeJuego.getDamas());
                        new SaveMinutos(this).writeFiles(directorioPartidasCronometros, "Cronometro"+principal.getUsers().getFirstName().trim(), ".txt", cronometro.getMinutos(), cronometro.getSegundos());
			cronometro.dispose();
                        principal.dispose();
                        mainWindow.setVisible(true);
		}
	}
        
        public int getMinuts(){
            return  this.minutos;
        }
        
        
        public int getSeconds(){
            return  this.segundos;
        }
        
        public void IniciarCronometro(){
            cronometro.Iniciar();
        }
        
        public void DetenerCronometro(){
            cronometro.stop();
        }
        
        public void CerrarCronometro(){
            cronometro.cerrarCronometro();
        }
}
