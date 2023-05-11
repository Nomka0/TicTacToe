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
    private JLabel jlNombre1;
    private JLabel jlNombre2;
    private JLabel txtScore1;
    private JLabel txtScore2;
    private JPanel jpContenido;
    private JButton btnJugar;
    private JLabel lblFondo;
    private JLabel lblTitulo;
    private JLabel lblIconoJugador;
    public int numeroRounds;
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
   

    public VentanaJuego(Jugador jugador1, Jugador jugador2, int modo, int numeroRondas) {
        manejadorEventos = new ManejadorDeEventos();
        nombreJugador1 = jugador1.getNombre();
        nombreJugador2 = jugador2.getNombre();
        modoJuego = modo;
        tableroSize = 3;
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        player1 = true;
        numeroRounds = numeroRondas;
        System.out.println(numeroRounds);
        gameOver = false;
        buttons = new JButton[tableroSize][tableroSize];
        VerificarModo();
        
    }
    
        public VentanaJuego(Jugador jugador1, Jugador jugador2, int modo, int numeroRondas, int score1, int score2) {
        manejadorEventos = new ManejadorDeEventos();
        nombreJugador1 = jugador1.getNombre();
        nombreJugador2 = jugador2.getNombre();
        modoJuego = modo;
        tableroSize = 3;
        scorePlayer1 = score1;
        scorePlayer2 = score2;
        numeroRounds = numeroRondas;
        System.out.println(numeroRounds);
        gameOver = false;
        buttons = new JButton[tableroSize][tableroSize];
        /**if(scorePlayer1 != 0){
            scorePlayer1 -= 1;
        }
        else if(scorePlayer2 != 0){
            scorePlayer2 -= 1;
        }*/
        VerificarModo();
        
    }

    public VentanaJuego(Jugador jugador, int modo) {
        manejadorEventos = new ManejadorDeEventos();
        nombreJugador = jugador.getNombre();
        modoJuego = modo;
        tableroSize = 3;
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        buttons = new JButton[tableroSize][tableroSize];
        VerificarModo();
    }

    private void VerificarModo() {
        if (modoJuego == 1) {
            iniciarComponentesModo1();
        } else if (modoJuego == 2) {
            iniciarComponentesModo2();
        }
    }

    private boolean VerificarColumnas() {
        boolean enColumna = true;
        String valorGrid = "";
        for (int i = 0; i < buttons.length; i++) {
            enColumna = true;//si gana en fila
            valorGrid = buttons[i][0].getText();
            if ("".equals(valorGrid)) {
                enColumna = false;
            } else {
                for (int j = 1; j < buttons[i].length; j++) {
                    if (!buttons[i][j].getText().equals(valorGrid)) {
                        enColumna = false;
                        break;
                    }
                }
            }

            if (enColumna) {
                if ("X".equals(valorGrid)) {
                    scorePlayer1 += 1;
                    break;
                } else if ("O".equals(valorGrid)) {
                    scorePlayer2 += 1;
                    break;
                }
                System.out.println(valorGrid);
                System.out.println(enColumna);
                break;
            }
        }
        //System.out.println("player 1 score: " + scorePlayer1 );
        //System.out.println("player 2 score: " + scorePlayer2 );
        return enColumna;
    }

    private boolean VerificarFilas() {
        boolean enFila = true;
        String valorGrid = "";
        for (int i = 0; i < buttons[0].length; i++) {
            enFila = true;//si gana en fila
            valorGrid = buttons[0][i].getText();
            if ("".equals(valorGrid)) {
                enFila = false;
            } else {
                for (int j = 1; j < buttons.length; j++) {
                    if (!buttons[j][i].getText().equals(valorGrid)) {
                        enFila = false;
                        break;
                    }
                }
            }

            if (enFila) {
                if ("X".equals(valorGrid)) {
                    scorePlayer1 += 1;
                    break;
                } else if ("O".equals(valorGrid)) {
                    scorePlayer2 += 1;
                    break;
                }
                System.out.println(valorGrid);
                break;
            }
        }
        //System.out.println("player 1 score: " + scorePlayer1 );
        //System.out.println("player 2 score: " + scorePlayer2 );
        return enFila;
    }

    private boolean VerificarDiagonal() {
        boolean enDiagonal = true;
        String valorGrid = buttons[0][0].getText();
        if ("".equals(valorGrid)) {
            enDiagonal = false;
        } else {
            for (int i = 1; i < buttons.length; i++) {
                if (!buttons[i][i].getText().equals(valorGrid)) {
                    enDiagonal = false;
                    break;
                }
            }
        }
        if (enDiagonal) {
            if ("X".equals(valorGrid)) {
                scorePlayer1 += 1;
                
            } else if ("O".equals(valorGrid)) {
                scorePlayer2 += 1;
            }
            System.out.println(valorGrid);
        }
        //System.out.println("player 1 score: " + scorePlayer1 );
        //System.out.println("player 2 score: " + scorePlayer2 );
        return enDiagonal;
    }

    private boolean VerificarDiagonalR() {//DiagonalReversa
        boolean enDiagonalR = true;
        String valorGrid = buttons[0][buttons.length - 1].getText();
        if ("".equals(valorGrid)) {
            enDiagonalR = false;
        } else {
            for (int i = 1; i < buttons.length; i++) {
                if (!buttons[i][buttons.length - 1 - i].getText().equals(valorGrid)) {
                    enDiagonalR = false;
                    break;
                }
            }
        }
        if (enDiagonalR) {
            if ("X".equals(valorGrid)) {
                scorePlayer1 += 1;
            } else if ("O".equals(valorGrid)) {
                scorePlayer2 += 1;
            }
            System.out.println(valorGrid);
        }
        //System.out.println("player 1 score: " + scorePlayer1 );
        //System.out.println("player 2 score: " + scorePlayer2 );
        return enDiagonalR;
    }

    private Boolean TableroLleno() {
        Boolean Lleno = true;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getText() == "") {
                    Lleno = false;
                }
            }
        }
        return Lleno;
    }
    
    private String Ganador(){
        String ganador ="";
        if(scorePlayer1 > scorePlayer2){
            ganador = nombreJugador1;
        }
        else if(scorePlayer1 < scorePlayer2){
            ganador = nombreJugador2;
        }
        else if (TableroLleno() == true || scorePlayer1 == scorePlayer2){
            ganador = "ninguno, empate";
        } 
        return ganador;
    }
    
    private void TerminarJuego(){
        if(TableroLleno() || VerificarFilas() || VerificarColumnas() 
        || VerificarDiagonal() || VerificarDiagonalR() == true){
            gameOver = true;
        }
        if(gameOver == true && numeroRounds == 0){
            int respuesta;
            respuesta = JOptionPane.showConfirmDialog(
                    null,"El ganador es: " + " " + Ganador() + " ¿Deseas volver a jugar?", "GAME OVER",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
            if(respuesta == JOptionPane.YES_OPTION){
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                dispose();
        }   else { 
                System.exit(0);
            }
        }
        else if(gameOver == true && numeroRounds != 0){
            SiguienteRonda(numeroRounds);
            if(scorePlayer1 != 0 && player1 == false){
                scorePlayer1 -= 1;
            }
            else if(scorePlayer2 != 0 & player1 == true){
                scorePlayer2 -= 1;
            }
            VentanaJuego nuevaRonda;
            Jugador jugador1Copia= new Jugador(nombreJugador1);
            Jugador jugador2Copia= new Jugador(nombreJugador2);
            nuevaRonda = new VentanaJuego(jugador1Copia, jugador2Copia, modoJuego, numeroRounds, scorePlayer1,scorePlayer2);
            dispose();
        } 
    }

    private void EstadoGanar() {
        VerificarFilas();
        VerificarColumnas();
        VerificarDiagonal();
        VerificarDiagonalR();
        System.out.println("player 1 score: " + scorePlayer1);
        System.out.println("player 2 score: " + scorePlayer2);
    }

    private void DibujarTablero() {
        //dibuja tablero
        int x;
        int y = 140;
        for (int i = 0; i < tableroSize; i++) {
            x = 240;
            for (int j = 0; j < tableroSize; j++) {
                buttons[j][i] = new JButton();
                buttons[j][i].setBounds(x, y, 70, 70);
                jpContenido.add(buttons[j][i]);
                buttons[j][i].addActionListener(manejadorEventos);
                x += 70;
            }
            y += 70;
        }
    }
    
    private void SiguienteRonda(int numeroRondas){
        numeroRounds -= 1;
    }

    private void iniciarComponentesModo1() {

        Font fDialog = new Font(Font.DIALOG_INPUT, Font.BOLD, 15);
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.magenta);
        setResizable(false);
        setLayout(null);

        jpContenido = new JPanel();
        jpContenido.setSize(700, 500);
        jpContenido.setBounds(0, 0, 700, 500);
        jpContenido.setLayout(null);
        jpContenido.setBackground(Color.magenta);
        add(jpContenido);

        ImageIcon titulo = new ImageIcon("img/titulo.png");
        lblTitulo = new JLabel();
        lblTitulo.setBounds(180, -190, 700, 500);
        lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(320, 65, Image.SCALE_SMOOTH)));
        jpContenido.add(lblTitulo);

        jlMensaje = new JLabel("Jugador 1");
        jlMensaje.setBounds(15, -60, 700, 500);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(fDialog);
        jpContenido.add(jlMensaje);
        
        jlNombre1 = new JLabel(nombreJugador1);
        jlNombre1.setBounds(15, 40, 700, 500);
        jlNombre1.setForeground(Color.WHITE);
        jlNombre1.setFont(fDialog);
        jpContenido.add(jlNombre1);

        jlMensaje2 = new JLabel("Jugador 2");
        jlMensaje2.setBounds(570, -60, 700, 500);
        jlMensaje2.setForeground(Color.WHITE);
        jlMensaje2.setFont(fDialog);
        jpContenido.add(jlMensaje2);
        
        txtScore1 = new JLabel(Integer.toString(scorePlayer1));
        txtScore1.setBounds(115, 190, 100, 100);
        txtScore1.setForeground(Color.WHITE);
        txtScore1.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 30));
        jpContenido.add(txtScore1);
        
        txtScore2 = new JLabel(Integer.toString(scorePlayer2));
        txtScore2.setBounds(550, 190, 100, 100);
        txtScore2.setForeground(Color.WHITE);
        txtScore2.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 30));
        jpContenido.add(txtScore2);
        
        jlNombre2 = new JLabel(nombreJugador2);
        jlNombre2.setBounds(610, 40, 700, 500);
        jlNombre2.setForeground(Color.WHITE);
        jlNombre2.setFont(fDialog);
        jpContenido.add(jlNombre2);

        DibujarTablero();

        ImageIcon jugador1 = new ImageIcon("img/jugador.png");
        Image imagenTransformar = jugador1.getImage();
        Image nuevaImagen = imagenTransformar.getScaledInstance(49, 64, java.awt.Image.SCALE_SMOOTH);
        jugador1 = new ImageIcon(nuevaImagen);
        lblIconoJugador = new JLabel();
        lblIconoJugador.setBounds(20, 180, 98, 128);
        lblIconoJugador.setIcon(jugador1);
        jpContenido.add(lblIconoJugador);

        ImageIcon jugador2 = new ImageIcon(nuevaImagen);
        lblIconoJugador = new JLabel();
        lblIconoJugador.setBounds(600, 180, 98, 128);
        lblIconoJugador.setIcon(jugador2);
        jpContenido.add(lblIconoJugador);

        ImageIcon fondo = new ImageIcon("img/fondo.jpg");
        lblFondo = new JLabel();
        lblFondo.setBounds(0, 0, 700, 500);
        lblFondo.setIcon(fondo);
        jpContenido.add(lblFondo);
        
        

    }

    private void iniciarComponentesModo2() {
        Font fDialog = new Font(Font.DIALOG_INPUT, Font.BOLD, 15);
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.magenta);
        setResizable(false);
        setLayout(null);

        jpContenido = new JPanel();
        jpContenido.setSize(700, 500);
        jpContenido.setBounds(0, 0, 700, 500);
        jpContenido.setLayout(null);
        jpContenido.setBackground(Color.magenta);
        add(jpContenido);

        DibujarTablero();

        ImageIcon titulo = new ImageIcon("img/titulo.png");
        lblTitulo = new JLabel();
        lblTitulo.setBounds(180, -190, 700, 500);
        lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(320, 65, Image.SCALE_SMOOTH)));
        jpContenido.add(lblTitulo);

        jlMensaje = new JLabel("Jugador : " + nombreJugador);
        jlMensaje.setBounds(0, -240, 700, 500);
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

    private void comportamientoModo(int x, int y) {
        if (modoJuego == 1) {
            if (player1 == true) {
                buttons[x][y].setText("X");
                player1 = false;
            } else {
                buttons[x][y].setText("O");
                player1 = true;
            }
        } else if (modoJuego == 2) {
            buttons[x][y].setText("X");
        }
    }

    class ManejadorDeEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            for (int i = 0; i < tableroSize; i++) {
                for (int j = 0; j < tableroSize; j++) {
                    if ("".equals(buttons[i][j].getText())) {
                        if (evento.getSource() == buttons[i][j]) {
                            comportamientoModo(i, j);
                            //VerificarColumnas();
                            EstadoGanar();
                            System.out.println(numeroRounds);
                            System.out.println(scorePlayer1);
                            TerminarJuego();
                            //jpContenido.add(txtScore1);
                            
                            //System.out.println(gameOver);
                        }
                    }
                }
            }
        }
    }
}
