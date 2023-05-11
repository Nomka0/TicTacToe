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
public class VentanaOpciones extends JFrame {

    private JLabel jlMensaje;
    private JLabel jlMensaje2;
    private JPanel jpContenido;   
    private JButton btnModo1; 
    private JButton btnModo2;
    private JButton btnRondas1; 
    private JButton btnRondas2;
    private JButton btnRondas3; 
    private JButton btnRondas4;
    private JLabel lblFondo;
    private JLabel lblTitulo;
    private int numeroRounds;
    private int modoJuego;
    
    public VentanaOpciones(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes() {
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
        
        jlMensaje = new JLabel("Por favor, seleccione un modo de juego");
        jlMensaje.setBounds(150,-100, 700,500);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlMensaje);
        
        ImageIcon Modo1 = new ImageIcon("img/modo1.png");    
        btnModo1 = new JButton();
        btnModo1.setBounds(230,180, 80,80);
        btnModo1.setIcon(new ImageIcon(Modo1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        jpContenido.add(btnModo1);
        
        ImageIcon Modo2 = new ImageIcon("img/modo2.png");
        btnModo2 = new JButton();
        btnModo2.setBounds(360,180, 80,80);
        btnModo2.setIcon(new ImageIcon(Modo2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        jpContenido.add(btnModo2);
        
        jlMensaje2 = new JLabel("Por favor, seleccione un número de rondas");
        jlMensaje2.setBounds(130,40, 700,500);
        jlMensaje2.setForeground(Color.WHITE);
        jlMensaje2.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlMensaje2);
        
        btnRondas1 = new JButton("1");
        btnRondas1.setBounds(150,330, 60,60);
        jpContenido.add(btnRondas1);
        
        btnRondas2 = new JButton("2");
        btnRondas2.setBounds(250,330, 60,60);
        jpContenido.add(btnRondas2);
        
        btnRondas3 = new JButton("3");
        btnRondas3.setBounds(350,330, 60,60);
        jpContenido.add(btnRondas3);
        
        btnRondas4 = new JButton("4");
        btnRondas4.setBounds(450,330, 60,60);
        jpContenido.add(btnRondas4);
        
        ImageIcon fondo = new ImageIcon("img/fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 700, 500);
        lblFondo.setIcon(fondo);
        jpContenido.add(lblFondo);
        
        ManejadorDeModos manejadorModos = new ManejadorDeModos();
        ManejadorDeRondas manejadorRondas = new ManejadorDeRondas();
        
        
        btnModo1.addActionListener(manejadorModos);
        btnModo2.addActionListener(manejadorModos);
        btnRondas1.addActionListener(manejadorRondas);
        btnRondas2.addActionListener(manejadorRondas);
        btnRondas3.addActionListener(manejadorRondas);
        btnRondas4.addActionListener(manejadorRondas);
        
        
    }
    
    private void ObtenerNombres() {
        if (modoJuego == 1) {
            VentanaNombres ventana = new VentanaNombres(modoJuego, numeroRounds);
            dispose();
        } else if (modoJuego == 2) {
            VentanaNombres ventana = new VentanaNombres(modoJuego, numeroRounds);
            dispose();
        }
    }
    
    class ManejadorDeRondas implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnRondas1){                
               numeroRounds = 0;
               ObtenerNombres();
            } 
            else if (evento.getSource() == btnRondas2) {
               numeroRounds = 1;
               ObtenerNombres();
            }          
            else if (evento.getSource() == btnRondas3){
               numeroRounds = 2;
               ObtenerNombres();
            }
            else if (evento.getSource() == btnRondas4){
               numeroRounds = 3;
               ObtenerNombres();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
        class ManejadorDeModos implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnModo1){                
               modoJuego = 1;
               System.out.println(modoJuego);
            } else if (evento.getSource() == btnModo2) {
               modoJuego = 2;
            }
        }
        
        

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        }
    }

