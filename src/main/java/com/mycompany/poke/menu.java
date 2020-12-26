
package com.mycompany.poke;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class menu extends JPanel implements ActionListener {

    JButton BotonPokedex,BotonBatalla;
    
    //metodo para cargar el fonde pantalla
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            imagen = ImageIO.read(new File("Imagenes/Fondo.jpg"));
        } catch (IOException e) {
            System.out.println("La imagen no se encuentra");
        }
        g.drawImage(imagen, 0, 0, null);
     
    }
    private Image imagen;

    //Constructor
    public menu() {
        setLayout(null); // Desactiva la regilla que viene por defecto
        botones();

    }
    //Aqui se crean los botones
    private void botones() {
        int alto = 200;
        int ancho = 200;

        //Boton Pokedeex
        BotonPokedex = new JButton();
        BotonPokedex.setBounds(100, 250, ancho, alto);
        //BotonPokedex.setSize(ancho, alto);
        ImageIcon icono1 = new ImageIcon("Imagenes/pokedex.png");
        BotonPokedex.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(BotonPokedex.getWidth(), BotonPokedex.getHeight(), Image.SCALE_SMOOTH)));
        BotonPokedex.setLayout(null); 
        BotonPokedex.setBorderPainted(false);
        BotonPokedex.setContentAreaFilled(false);
        BotonPokedex.setFocusPainted(false);
        BotonPokedex.setOpaque(false);
        BotonPokedex.addActionListener(this);
        //Animacion de boton uno nuevo con un tamaño major
        BotonPokedex.setPressedIcon(new ImageIcon(icono1.getImage().getScaledInstance(BotonPokedex.getWidth()+5, BotonPokedex.getHeight()+5, Image.SCALE_FAST)));
        add(BotonPokedex);
        
        //Boton Batalla
        BotonBatalla= new JButton();
        BotonBatalla.setBounds(100, 400, ancho, alto);
        ImageIcon icono2 = new ImageIcon("Imagenes/batalla.png");
        BotonBatalla.setIcon(new ImageIcon(icono2.getImage().getScaledInstance(BotonPokedex.getWidth(), BotonPokedex.getHeight(), Image.SCALE_SMOOTH)));    
        BotonBatalla.setLayout(null);
        BotonBatalla.setBorderPainted(false);
        BotonBatalla.setContentAreaFilled(false);
        BotonBatalla.setFocusPainted(false);
        BotonBatalla.setOpaque(false);
        BotonBatalla.addActionListener(this);
        BotonBatalla.setPressedIcon(new ImageIcon(icono2.getImage().getScaledInstance(BotonPokedex.getWidth()+5, BotonPokedex.getHeight()+5, Image.SCALE_FAST)));
        add(BotonBatalla);
        
    }
    //Metodo para darle uso a los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        Object botonPulsado = e.getSource();
        
        if (botonPulsado == BotonPokedex) {
            //System.out.println("Boton de Pokedex");
            graficos.NuevaVentana = 1;
            graficos graficos = new graficos();
            graficos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            
        } else if(botonPulsado == BotonBatalla){
            //System.out.println("Boton de Batalla");
            graficos.NuevaVentana = 2;
            graficos graficos = new graficos();
            graficos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

}
