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
    private JLabel lblIconoJugador;
    private int numeroRondas;
    private int modoJuego;
    private int tableroSize;
    private int scorePlayer1;
    private int scorePlayer2;
    private ManejadorDeEventos manejadorEventos;
    private boolean player1;//si el player1 es true, entonces es su turno, si es false, es turno del player 2
    private boolean gameOver;
    private JButton[][] buttons; //coordenadas grids
    private String nombreJugador;
    private String nombreJugador1;
    private String nombreJugador2;
    
    public VentanaJuego(Jugador jugador1, Jugador jugador2, int modo){
        manejadorEventos = new ManejadorDeEventos();
        nombreJugador1 = jugador1.getNombre();
        nombreJugador2 = jugador2.getNombre();
        modoJuego = modo;
        tableroSize = 3;
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        player1 = true;
        gameOver = false;
        buttons = new JButton[tableroSize][tableroSize];
        VerificarModo();
    }
       
    public VentanaJuego(Jugador jugador,int modo){
        manejadorEventos = new ManejadorDeEventos();
        nombreJugador = jugador.getNombre();
        modoJuego = modo;
        tableroSize = 3;
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        buttons = new JButton[tableroSize][tableroSize];
        VerificarModo();
    }
    
    private void VerificarModo () {
        if (modoJuego == 1){
            iniciarComponentesModo1();
        } else if (modoJuego == 2) {
            iniciarComponentesModo2();
        }
    }
    
    public void EstadoGanar(){
        for(int i = 0; i < buttons.length; i++){
            boolean enFila = true;//si gana en fila
            String valorGrid = buttons[i][0].getText();
            if("".equals(valorGrid)){
                enFila = false;
            }
            else{
                for(int j = 1; j < buttons[i].length; j++){
                    if(buttons[i][j].getText() != valorGrid){
                        enFila = false;
                        break;
                    }
                }
            }
            
            if(enFila){
                System.out.println(valorGrid);
            }
            
            System.out.println(enFila);
        }
    }
    
    private void DibujarTablero(){
        //dibuja tablero
        int x;
        int y = 140;
        for(int i = 0; i < tableroSize; i++){
            x = 240;
            for(int j = 0; j < tableroSize; j++){
                buttons[j][i] = new JButton();
                buttons[j][i].setBounds(x,y, 70,70);
                jpContenido.add(buttons[j][i]);
                buttons[j][i].addActionListener(manejadorEventos);
                x += 70;
            }
            y += 70;
        }
    }
    
    private void iniciarComponentesModo1() {
        
        Font fDialog = new Font(Font.DIALOG_INPUT, Font.BOLD,  15);
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
        jlMensaje.setFont(fDialog);
        jpContenido.add(jlMensaje);
                      
        jlMensaje2 = new JLabel("Jugador 2 : " +nombreJugador2);
        jlMensaje2.setBounds(0,-215, 700,500);
        jlMensaje2.setForeground(Color.WHITE);
        jlMensaje2.setFont(fDialog);
        jpContenido.add(jlMensaje2);
        
        DibujarTablero();
        
        ImageIcon jugador1 = new ImageIcon("img/jugador.png");
        Image imagenTransformar = jugador1.getImage();
        Image nuevaImagen = imagenTransformar.getScaledInstance(49, 64,  java.awt.Image.SCALE_SMOOTH);
        jugador1 = new ImageIcon(nuevaImagen);
        lblIconoJugador = new JLabel();  
        lblIconoJugador.setBounds(270,340 , 98, 128);
        lblIconoJugador.setIcon(jugador1);
        jpContenido.add(lblIconoJugador);
        
        ImageIcon jugador2 = new ImageIcon(nuevaImagen);
        lblIconoJugador = new JLabel();  
        lblIconoJugador.setBounds(370,340 , 98, 128);
        lblIconoJugador.setIcon(jugador2);
        jpContenido.add(lblIconoJugador);
        
                           
        
        ImageIcon fondo = new ImageIcon("img/fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 700, 500);
        lblFondo.setIcon(fondo);
        jpContenido.add(lblFondo);
        
}
    
    private void iniciarComponentesModo2() {
        Font fDialog = new Font(Font.DIALOG_INPUT, Font.BOLD,  15);
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
        
        DibujarTablero();
        
        ImageIcon titulo = new ImageIcon("img/titulo.png");
        lblTitulo = new JLabel();
        lblTitulo.setBounds(180,-190, 700,500);
        lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(320, 65, Image.SCALE_SMOOTH)));
        jpContenido.add(lblTitulo);
        
        jlMensaje = new JLabel("Jugador : " + nombreJugador);
        jlMensaje.setBounds(0,-240, 700,500);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(fDialog);
        jpContenido.add(jlMensaje);

        
        ImageIcon fondo = new ImageIcon("img/fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 700, 500);
        lblFondo.setIcon(fondo);
        jpContenido.add(lblFondo);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
}
    
    private void comportamientoModo(int x, int y){      
        if(modoJuego == 1){
            if(player1 == true){
                buttons[x][y].setText("X");
                player1 = false;
            }
            else{
                buttons[x][y].setText("O");
                player1 = true;
            } 
        }
        else if(modoJuego == 2){
            buttons[x][y].setText("X");
        }
    }
    
    class ManejadorDeEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento){
            for(int i = 0; i < tableroSize; i++){
                for(int j = 0; j < tableroSize; j++){
                    if (evento.getSource() == buttons[i][j]) {
                        comportamientoModo(i,j);
                        EstadoGanar();
                    }
                }
            }     
        }
    }
}  