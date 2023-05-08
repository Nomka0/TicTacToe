/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import modelo.Jugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 *
 * @author jhon
 */
public class VentanaJuego extends JFrame {
    private JLabel jlMensaje;
    private JLabel jlMensaje2;
    private JTextField txtNombre1;
    private JTextField txtNombre2;
    private JPanel jpContenido;   
    private JButton btnJugar;
    private JLabel lblFondo;
    private JLabel lblTitulo;
    private int numeroRondas;
    private int modoJuego;
    private String nombreJugador;
    private String nombreJugador1;
    private String nombreJugador2;
    
    public VentanaJuego(Jugador jugador1, Jugador jugador2, int modo){
        nombreJugador1 = jugador1.getNombre();
        nombreJugador2 = jugador2.getNombre();
        modoJuego = modo;
        VerificarModo();
    }
       
    public VentanaJuego(Jugador jugador,int modo){
        nombreJugador = jugador.getNombre();
        modoJuego = modo;
        VerificarModo();
    }
    
    private void VerificarModo () {
        if (modoJuego == 1){
            iniciarComponentesModo1();
        } else if (modoJuego == 2) {
            iniciarComponentesModo2();
        }
    }
    
    private void iniciarComponentesModo1() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.magenta);
        setResizable(false);
        setLayout(null);
        
        jpContenido = new JPanel();
        jpContenido.setSize(700,500);        
        jpContenido.setBounds(0,0, 700, 500);
        jpContenido.setLayout(null);
        jpContenido.setBackground(Color.magenta);
        add(jpContenido);
        
        ImageIcon titulo = new ImageIcon("img/titulo.png");
        lblTitulo = new JLabel();
        lblTitulo.setBounds(180,-190, 700,500);
        lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(320, 65, Image.SCALE_SMOOTH)));
        jpContenido.add(lblTitulo);
     
        jlMensaje = new JLabel("Jugador 1 : " + nombreJugador1);
        jlMensaje.setBounds(0,-240, 700,500);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlMensaje);
                      
        jlMensaje2 = new JLabel("Jugador 2 : " +nombreJugador2);
        jlMensaje2.setBounds(0,-215, 700,500);
        jlMensaje2.setForeground(Color.WHITE);
        jlMensaje2.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlMensaje2);
        
        
        
        ImageIcon fondo = new ImageIcon("img/fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 700, 500);
        lblFondo.setIcon(fondo);
        jpContenido.add(lblFondo);
        
}
    
    private void iniciarComponentesModo2() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.magenta);
        setResizable(false);
        setLayout(null);
        
        jpContenido = new JPanel();
        jpContenido.setSize(700,500);        
        jpContenido.setBounds(0,0, 700, 500);
        jpContenido.setLayout(null);
        jpContenido.setBackground(Color.magenta);
        add(jpContenido);
        
        ImageIcon titulo = new ImageIcon("img/titulo.png");
        lblTitulo = new JLabel();
        lblTitulo.setBounds(180,-190, 700,500);
        lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(320, 65, Image.SCALE_SMOOTH)));
        jpContenido.add(lblTitulo);
        
        jlMensaje = new JLabel("Jugador : " + nombreJugador);
        jlMensaje.setBounds(0,-240, 700,500);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlMensaje);

        
        ImageIcon fondo = new ImageIcon("img/fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 700, 500);
        lblFondo.setIcon(fondo);
        jpContenido.add(lblFondo);
        

        
}
    
    class ManejadorDeEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento){
            if (evento.getSource() == btnJugar) {
               
            }
            
        }
    }
}  