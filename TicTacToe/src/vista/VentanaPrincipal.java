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
public class VentanaPrincipal extends JFrame {

    private JLabel jlMensaje;
    private JPanel jpContenido;   
    private JButton btnJugar; 
    private JButton btnInstrucciones;
    private JLabel lblFondo;
    private JLabel lblTitulo;
    
    public VentanaPrincipal(){
        iniciarComponentes();
        jpContenido.revalidate();
        jpContenido.repaint(); 
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
        lblTitulo.setBounds(40,-120, 700,500);
        lblTitulo.setIcon(titulo);
        jpContenido.add(lblTitulo);
              
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(250,220, 180,35);
        jpContenido.add(btnJugar);
        
        btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setBounds(250,290, 180,35);
        jpContenido.add(btnInstrucciones);
        
        ImageIcon fondo = new ImageIcon("img/fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 700, 500);
        lblFondo.setIcon(fondo);
        jpContenido.add(lblFondo);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnJugar.addActionListener(manejadorEventos);
        btnInstrucciones.addActionListener(manejadorEventos);
        
        
    }
    
    
    class ManejadorDeEventos implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnJugar){                
               VentanaOpciones ventana = new VentanaOpciones();
               dispose();
            } else if (evento.getSource() == btnInstrucciones) {
               JOptionPane.showMessageDialog(null, "El clásico Triqui", "Instrucciones", JOptionPane.PLAIN_MESSAGE);
            }
        }
        
       
        
        
        @Override
        public void keyReleased(KeyEvent e) {
           /* System.out.println("Se liberó la tecla " + e.getKeyChar() +
                    " Con codigo " + e.getKeyCode());*/
            //if(e.getKeyCode() == e.VK_ENTER){
               // btnJugar.doClick();
            //}
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println("Se presionó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
            
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            /*System.out.println("Se digitó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
        }
    }
}