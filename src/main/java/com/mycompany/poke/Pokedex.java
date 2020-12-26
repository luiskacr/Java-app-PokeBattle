package com.mycompany.poke;

import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Pokedex extends JPanel implements ActionListener {

    JButton PokedexAnterior, PokedexSiguente;
    JLabel nombre ;
    int numSeleccion = 1;
    String etiqueta;
    Font pokeletra;

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        try {
            imagen = ImageIO.read(new File("Imagenes/Fondo2.jpg"));
        } catch (IOException e) {
            System.out.println("La imagen no se encuentra");
        }
        g.drawImage(imagen, 0, 0, null);

    }
    private Image imagen;

    public Pokedex(){
        setLayout(null);
        seleccion();

        JLabel FondoPokedex = new JLabel(new ImageIcon("Imagenes/marco.png"));
        FondoPokedex.setBounds(0, -25, 1200, 800);
        add(FondoPokedex);

    }

    public void seleccion() {
        int ancho = 150;
        int alto = 50;
        String ruta;

        //Carga la "base de datos" con la informacion de los pokemons
        List<String[]> rowList = new ArrayList<String[]>();
        try ( BufferedReader br = new BufferedReader(new FileReader("pokemonDB.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineItems = line.split(";");
                rowList.add(lineItems);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Un error al cargar la base de datos");
        }
        String[][] DataBase = new String[rowList.size()][];
        for (int i = 0; i < rowList.size(); i++) {
            String[] row = rowList.get(i);
            DataBase[i] = row;
        }
        
        //Botones de anterior y siguente 
        PokedexAnterior = new JButton();
        PokedexAnterior.setBounds(150, 500, ancho, alto);
        PokedexAnterior.addActionListener(this);

        this.add(PokedexAnterior);

        PokedexSiguente = new JButton();
        PokedexSiguente.setBounds(375, 500, ancho, alto);
        PokedexSiguente.addActionListener(this);

        this.add(PokedexSiguente);
        
        
        //Etiqueta de Imagen del pokemon
        //Se creo como un boton por que solo asi se puede excalar el tamaño
        ruta = "pokemones/"+ numSeleccion+".png";
  
        JButton imagenPokemon = new JButton();
        //imagenPokemon.setBounds(100, 250, ancho, alto);
        ImageIcon icono1 = new ImageIcon(ruta);
        imagenPokemon.setLocation(220, 190);
        imagenPokemon.setSize(240, 240);
        imagenPokemon.setVisible(true); 
        imagenPokemon.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(240, 240, Image.SCALE_SMOOTH)));
        imagenPokemon.setLayout(null);
        imagenPokemon.setBorderPainted(false);
        imagenPokemon.setContentAreaFilled(false);
        imagenPokemon.setFocusPainted(false);
        imagenPokemon.setOpaque(false);
        this.add(imagenPokemon);
        
        //Etiqueta del nombre del pokemon
        etiqueta =DataBase[numSeleccion][1];
        nombre = new JLabel(etiqueta,SwingConstants.CENTER);
        nombre.setBounds(185,535, 300, 200);
        nombre.setForeground(Color.white);
        nombre.setFont(new Font("Arial", Font.PLAIN, 40));
        this.add(nombre);
        
        //Texto con la informacion del pokemon
        String informacionPokemon = "\nTipo1: " + DataBase[numSeleccion][2] + "\n\nTipo2: " + DataBase[numSeleccion][3] + "\n\nAtaque1: " + DataBase[numSeleccion][10] 
                + "\n\nAtaque2: " + DataBase[numSeleccion][11]
                ;

        JTextArea textoinfo = new JTextArea();
        textoinfo.setBounds(675,220, 300, 300);
        textoinfo.setText(informacionPokemon);
        textoinfo.setForeground(Color.green);
        textoinfo.setEditable(false);
        textoinfo.setBackground(Color.black);
        textoinfo.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(textoinfo);

        //Marco del pokedex 
        JLabel FondoPokedex = new JLabel(new ImageIcon("Imagenes/marco.png"));
        FondoPokedex.setBounds(0, -25, 1200, 800);
        add(FondoPokedex);
        
        //Cuadro negro de fondo
        JLabel cuadroNegro = new JLabel(new ImageIcon("Imagenes/cuadonegro.png"));
        cuadroNegro.setBounds(0, -40, 1200, 800);
        add(cuadroNegro); 
    }
    //Metodo para dar uso a los botos 
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Si funciona");
        Object botonPokedex = e.getSource();

        if (botonPokedex == PokedexAnterior) {
            if (numSeleccion -1 ==0){
                numSeleccion = 151;
            }else{
                numSeleccion = numSeleccion - 1;
            }
            //Comando para reiniciar el panel
            removeAll();
            revalidate();
            updateUI();       
            seleccion(); 
        } 
        
        if(botonPokedex == PokedexSiguente){
            //System.out.println("Boton de Siguente");
            if (numSeleccion +1 ==152){
                numSeleccion = 1;
            }else{
            
            numSeleccion = numSeleccion + 1;
           
            }
            //Comando para reiniciar el panel
            removeAll();
            revalidate();
            updateUI();       
            seleccion(); 

        }

    }

}
