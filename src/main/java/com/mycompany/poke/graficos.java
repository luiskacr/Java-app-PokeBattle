package com.mycompany.poke;

import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;

public class graficos extends JFrame {

    Toolkit pantalla = Toolkit.getDefaultToolkit();
    //boolean opcion = true;
    static int NuevaVentana = 0;

    public graficos() {

        iniciar();

        setSize(1200, 800);  //tamaño
        setVisible(true); //Hacemos visible la ventana
        setResizable(false);  //Si se puede agrandar o hacer mas pequeña
        setLocationRelativeTo(null); // Comando para que abra en el centro
        setTitle("Poke Batallas"); // Nombre que muestra la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si la ventana se cierra con la X del menu
        //Comandos para seleccionar el icono del programa
        Image Icono = pantalla.getImage("Imagenes/pokedex-icon-21.jpg");
        setIconImage(Icono);
        setBackground(null);
        setLayout(null);

    }

    public void iniciar() {

        menu menu = new menu();
        add(menu);

        if (NuevaVentana == 1) {
            menu.setVisible(false);
            menu.remove(menu);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            Pokedex Pokedex = new Pokedex();
            this.getContentPane().add(Pokedex);

        } else if(NuevaVentana ==2) {
            menu.setVisible(false);
            menu.remove(menu);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            graficosbatalla batallar = new graficosbatalla();
            this.getContentPane().add(batallar);
        }

    }
   
}
