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
public class VentanaNombres extends JFrame {
    private JLabel jlMensaje;
    private JLabel jlMensaje2;
    private JTextField txtNombre1;
    private JTextField txtNombre2;
    private JPanel jpContenido;   
    private JButton btnJugar;
    private JButton btnAtras;
    private JLabel lblFondo;
    private JLabel lblTitulo;
    private int numeroRondas;
    private int modoJuego;
    
    public VentanaNombres(){
    }
       
    public VentanaNombres(int modo){
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
        Font fDialog = new Font(Font.DIALOG_INPUT, Font.BOLD,  20);
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
        lblTitulo.setBounds(180,-150, 700,500);
        lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(320, 65, Image.SCALE_SMOOTH)));
        jpContenido.add(lblTitulo);
        
        jlMensaje = new JLabel("Por favor, escriba el nombre del Jugador 1 ");
        jlMensaje.setBounds(100,-100, 700,500);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(fDialog);
        jpContenido.add(jlMensaje);
        
        txtNombre1 = new JTextField("");
        txtNombre1.setHorizontalAlignment(JTextField.CENTER);
        txtNombre1.setForeground(Color.BLACK);
        txtNombre1.setFont(fDialog); 
        txtNombre1.setBounds(150,190,400, 30);
        jpContenido.add(txtNombre1);
               
        jlMensaje2 = new JLabel("Por favor, escriba el nombre del Jugador 2");
        jlMensaje2.setBounds(100,20, 700,500);
        jlMensaje2.setForeground(Color.WHITE);
        jlMensaje2.setFont(fDialog);
        jpContenido.add(jlMensaje2);
        
        txtNombre2 = new JTextField("");
        txtNombre2.setHorizontalAlignment(JTextField.CENTER);
        txtNombre2.setForeground(Color.BLACK);
        txtNombre2.setFont(fDialog); 
        txtNombre2.setBounds(150,310,400, 30);
        jpContenido.add(txtNombre2);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(350,370, 120,35);
        jpContenido.add(btnJugar);
        
        btnAtras = new JButton("Atrás");
        btnAtras.setBounds(200,370, 120,35);
        jpContenido.add(btnAtras);
        
        ImageIcon fondo = new ImageIcon("img/fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 700, 500);
        lblFondo.setIcon(fondo);
        jpContenido.add(lblFondo);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnJugar.addActionListener(manejadorEventos);
        btnAtras.addActionListener(manejadorEventos);
        
}
    
    private void iniciarComponentesModo2() {
        Font fDialog = new Font(Font.DIALOG_INPUT, Font.BOLD,  20);
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
        lblTitulo.setBounds(180,-150, 700,500);
        lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(320, 65, Image.SCALE_SMOOTH)));
        jpContenido.add(lblTitulo);
        
        jlMensaje = new JLabel("Por favor, escriba el nombre del Jugador ");
        jlMensaje.setBounds(150,-30, 700,500);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(fDialog);
        jpContenido.add(jlMensaje);
        
        txtNombre1 = new JTextField("");
        txtNombre1.setHorizontalAlignment(JTextField.CENTER);
        txtNombre1.setForeground(Color.BLACK);
        txtNombre1.setFont(fDialog); 
        txtNombre1.setBounds(145,250,400, 30);
        jpContenido.add(txtNombre1);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(350,370, 120,35);
        jpContenido.add(btnJugar);
        
        btnAtras = new JButton("Atrás");
        btnAtras.setBounds(200,370, 120,35);
        jpContenido.add(btnAtras);
        
        ImageIcon fondo = new ImageIcon("img/fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 700, 500);
        lblFondo.setIcon(fondo);
        jpContenido.add(lblFondo);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnJugar.addActionListener(manejadorEventos);
        btnAtras.addActionListener(manejadorEventos);
        
}
    
    protected void obtenerNombre(){
        if(modoJuego == 1) {
           String nombre1 =txtNombre1.getText();
           String nombre2 =txtNombre2.getText();
        if((!nombre1.trim().isEmpty() || nombre1.trim().length() > 0) && (!nombre2.trim().isEmpty() || nombre2.trim().length() > 0 )){
            Jugador jugador1 = new Jugador(nombre1);
            Jugador jugador2 = new Jugador(nombre2);
            System.out.println(nombre1);
            System.out.println(nombre2);
            VentanaJuego ventanaJuego = new VentanaJuego(jugador1,jugador2, modoJuego);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese el nombre de ambos jugadores", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
        } else if (modoJuego == 2) {
            String nombre =txtNombre1.getText();
            if(!nombre.trim().isEmpty() || nombre.trim().length() > 0 ) {
                Jugador jugador = new Jugador(nombre);
                System.out.println(nombre);
                VentanaJuego ventanaJuego = new VentanaJuego(jugador, modoJuego);
                dispose();
            } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese el nombre del jugador", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
        }
        
    }
    
    class ManejadorDeEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento){
            if (evento.getSource() == btnJugar) {
                obtenerNombre();
            } 
            else if (evento.getSource() == btnAtras) {
                VentanaOpciones ventana = new VentanaOpciones();
                dispose();
            }
            
        }
    }
}
