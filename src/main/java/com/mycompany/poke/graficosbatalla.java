package com.mycompany.poke;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class graficosbatalla extends JPanel implements ActionListener {

    Pokemon pokemon1;
    Pokemon pokemon2;
    JLabel P1nombre, P2nombre, P1nivel, P2nivel, MuestraNivelPoke1, MuestraNivelPoke2;
    JButton ataque1, ataque2, finalizar, botonBatalla, Poke1Anterior, Poke1Siguente, Poke2Anterior, Poke2Siguente, BotonRamdom, poke1SiguenteNivel, poke1anteriorNivel, poke2SiguenteNivel, poke2anteriorNivel;
    int seleccionPoke1 = 1, seleccionPoke2 = 1;
    int vidaP1Inicial, vidaP2Inicial, nivelPoke1 = 30, Nivelpoke2 = 30, OpcionArranque = 1;

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        try {
            imagen = ImageIO.read(new File("Imagenes/battle_bg_1.png"));
        } catch (IOException e) {
            System.out.println("La imagen no se encuentra");
        }
        g.drawImage(imagen.getScaledInstance(getWidth(), getHeight(), WIDTH), 0, 0, this);

    }
    private Image imagen;

    public graficosbatalla() {
        setLayout(null);

        if (OpcionArranque == 1) {
            Seleccion();

        } else if (OpcionArranque == 2) {
            IniciaBatalla();
        }
    }

    private void Seleccion() {
        pokemon1 = new Pokemon(seleccionPoke1, nivelPoke1);
        pokemon2 = new Pokemon(seleccionPoke2, Nivelpoke2);

        int ancho = 150, alto = 50;

        String ruta1 = "pokemones/" + seleccionPoke1 + ".png";
        String ruta2 = "pokemones/" + seleccionPoke2 + ".png";

        //Pokemon del juegador 
        //Etiqueta de nombre de pokemon jugardor
        String NombreP1 = pokemon1.nombre;
        JLabel EtiquetaP1 = new JLabel("Pokemon Jugador: " + NombreP1, SwingConstants.CENTER);
        EtiquetaP1.setBounds(100 - 20, 60, 400, 75);
        EtiquetaP1.setForeground(Color.WHITE);
        EtiquetaP1.setFont(new Font("Arial", Font.PLAIN, 30));
        add(EtiquetaP1);

        //
        JButton pokemon1 = new JButton();
        ImageIcon Seleccion1 = new ImageIcon(ruta1);
        pokemon1.setLocation(100 - 20, 75);
        pokemon1.setSize(400, 400);
        pokemon1.setVisible(true);
        pokemon1.setIcon(new ImageIcon(Seleccion1.getImage().getScaledInstance(400, 400 - 20, Image.SCALE_SMOOTH)));
        pokemon1.setLayout(null);
        pokemon1.setBorderPainted(false);
        pokemon1.setContentAreaFilled(false);
        pokemon1.setFocusPainted(false);
        pokemon1.setOpaque(false);
        add(pokemon1);

        //
        Poke1Anterior = new JButton();
        Poke1Anterior.setBounds(100 - 20, 450, ancho, alto);
        Poke1Anterior.setText("Anterior");
        Poke1Anterior.addActionListener(this);
        add(Poke1Anterior);

        //
        Poke1Siguente = new JButton();
        Poke1Siguente.setBounds(350 - 20, 450, ancho, alto);
        Poke1Siguente.setText("Siguente");
        Poke1Siguente.addActionListener(this);
        add(Poke1Siguente);

        //Muestra el nivel del pokemon 1
        MuestraNivelPoke1 = new JLabel("Nivel: " + nivelPoke1);
        MuestraNivelPoke1.setForeground(Color.WHITE);
        MuestraNivelPoke1.setBounds(230 - 20, 500, 275, 50);
        MuestraNivelPoke1.setFont(new Font("Arial", Font.PLAIN, 30));
        add(MuestraNivelPoke1);

        //Poke 1 nivel anterior
        poke1SiguenteNivel = new JButton();
        poke1SiguenteNivel.setBounds(350 - 20, 560, ancho, alto);
        poke1SiguenteNivel.setText("Nivel Anterior");
        poke1SiguenteNivel.addActionListener(this);
        add(poke1SiguenteNivel);

        //Poke 1 nivel siguente
        poke1anteriorNivel = new JButton();
        poke1anteriorNivel.setBounds(100 - 20, 560, ancho, alto);
        poke1anteriorNivel.setText("Siguente Nivel");
        poke1anteriorNivel.addActionListener(this);
        add(poke1anteriorNivel);

        //Pokemon2 seleccion enemigo
        String NombreP2 = pokemon2.nombre;
        JLabel EtiquetaP2 = new JLabel("Pokemon Enemigo: " + NombreP2, SwingConstants.CENTER);
        EtiquetaP2.setBounds(100 + 575, 60, 450, 75);
        EtiquetaP2.setForeground(Color.WHITE);
        EtiquetaP2.setFont(new Font("Arial", Font.PLAIN, 30));
        add(EtiquetaP2);

        JButton pokemon2 = new JButton();
        ImageIcon Seleccion2 = new ImageIcon(ruta2);
        pokemon2.setLocation(115 + 575, 75);
        pokemon2.setSize(400, 400);
        pokemon2.setVisible(true);
        pokemon2.setIcon(new ImageIcon(Seleccion2.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
        pokemon2.setLayout(null);
        pokemon2.setBorderPainted(false);
        pokemon2.setContentAreaFilled(false);
        pokemon2.setFocusPainted(false);
        pokemon2.setOpaque(false);
        add(pokemon2);

        //
        Poke2Anterior = new JButton();
        Poke2Anterior.setBounds(100 + 600, 450, ancho, alto);
        Poke2Anterior.setText("Anterior");
        Poke1Anterior.addActionListener(this);
        add(Poke2Anterior);

        //
        Poke2Siguente = new JButton();
        Poke2Siguente.setBounds(350 + 600, 450, ancho, alto);
        Poke2Siguente.setText("Siguente");
        Poke2Siguente.addActionListener(this);
        add(Poke2Siguente);

        //Muestra el nivel del pokemon 2
        MuestraNivelPoke2 = new JLabel("Nivel: " + Nivelpoke2);
        MuestraNivelPoke2.setForeground(Color.WHITE);
        MuestraNivelPoke2.setBounds(230 + 600, 500, 275, 50);
        MuestraNivelPoke2.setFont(new Font("Arial", Font.PLAIN, 30));
        add(MuestraNivelPoke2);

        //Poke 2 nivel anterior
        poke2SiguenteNivel = new JButton();
        poke2SiguenteNivel.setBounds(350 + 600, 560, ancho, alto);
        poke2SiguenteNivel.setText("Nivel Anterior");
        poke2SiguenteNivel.addActionListener(this);
        add(poke2SiguenteNivel);

        //Poke 2 nivel siguente
        poke2anteriorNivel = new JButton();
        poke2anteriorNivel.setBounds(100 + 600, 560, ancho, alto);
        poke2anteriorNivel.setText("Siguente Nivel");
        poke2anteriorNivel.addActionListener(this);
        add(poke2anteriorNivel);

        //Botones de opciones extra 
        //Boton Ramdom
        BotonRamdom = new JButton();
        BotonRamdom.setBounds(520, 150, ancho, alto);
        BotonRamdom.setText("Seleccion Random");
        BotonRamdom.addActionListener(this);
        add(BotonRamdom);

        //Boton de pasar a la batalla 
        botonBatalla = new JButton();
        botonBatalla.setBounds(520, 625, ancho, alto);
        botonBatalla.setText("Vamos a la batalla");
        botonBatalla.addActionListener(this);
        add(botonBatalla);

        //Fondo a utilizar en este seccion seleccion 
        JLabel fondoSeleccion = new JLabel(new ImageIcon("Imagenes/fondo seleccion.jpg"));
        fondoSeleccion.setBounds(-5, -20, 1200, 800);
        add(fondoSeleccion);

    }

    private void IniciaBatalla() {
        pokemon1 = new Pokemon(seleccionPoke1, nivelPoke1);
        pokemon2 = new Pokemon(seleccionPoke2, Nivelpoke2);
        vidaP1Inicial = pokemon1.vida;
        vidaP2Inicial = pokemon2.vida;

        setLayout(null);

        vida(vidaPorcentaje(pokemon1.vida, vidaP1Inicial), vidaPorcentaje(pokemon2.vida, vidaP2Inicial));
        pokemons(seleccionPoke1, seleccionPoke2);
        mensaje("Empieza la batalla.... \nQue ataque deseas hacer?");
    }

    private void vida(int vidaFinalP1, int vidaFinalP2) {

        Image img1 = new ImageIcon("Imagenes/life_bar_player.png").getImage();
        ImageIcon vida1 = new ImageIcon(img1.getScaledInstance(534, 147, Image.SCALE_SMOOTH));

        JLabel vidaPokemon1 = new JLabel(vida1);
        vidaPokemon1.setBounds(630, 570 - 125, 534, 147);
        add(vidaPokemon1);

        //barras de vida de los pokemon
        JProgressBar barravidaPokemon1 = new JProgressBar();
        barravidaPokemon1.setBounds(790, 570 - 125, 327, 30);
        barravidaPokemon1.setValue(vidaFinalP1);
        if (vidaFinalP1 < 25) {
            barravidaPokemon1.setForeground(Color.RED);
        } else {
            barravidaPokemon1.setForeground(Color.GREEN);
        }
        add(barravidaPokemon1);

        //Barras del enemigo 
        Image img2 = new ImageIcon("Imagenes/life_bar_enemy.png").getImage();
        ImageIcon vida2 = new ImageIcon(img2.getScaledInstance(534, 147, Image.SCALE_SMOOTH));

        JLabel vidaPokemon2 = new JLabel(vida2);
        vidaPokemon2.setBounds(10, 120, 534, 147);
        add(vidaPokemon2);

        JProgressBar barravidaPokemon2 = new JProgressBar();
        barravidaPokemon2.setBounds(170, 130, 345, 45);
        barravidaPokemon2.setValue(vidaFinalP2);
        if (vidaFinalP2 < 25) {
            barravidaPokemon2.setForeground(Color.RED);
        } else {
            barravidaPokemon2.setForeground(Color.GREEN);
        }
        add(barravidaPokemon2);

    }

    public int vidaPorcentaje(int vidaActual, int vidaInicial) {
        //Funcion para convertir la vida actual en un porcentaje
        int resultado = (vidaActual * 100) / vidaInicial;
        return resultado;
    }

    private void pokemons(int pokemonPlayer, int pokemonEnemigo) {

        String player = "pokemones/" + pokemonPlayer + "_back.png";
        String enemigo = "pokemones/" + pokemonEnemigo + ".png";

        //Pokemon del jugador 
        JButton PokemonPlayer = new JButton();
        ImageIcon icono1 = new ImageIcon(player);
        PokemonPlayer.setLocation(-75, 225);
        PokemonPlayer.setSize(800, 800);
        PokemonPlayer.setVisible(true);
        PokemonPlayer.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH)));
        PokemonPlayer.setLayout(null);
        PokemonPlayer.setBorderPainted(false);
        PokemonPlayer.setContentAreaFilled(false);
        PokemonPlayer.setFocusPainted(false);
        PokemonPlayer.setOpaque(false);
        this.add(PokemonPlayer);

        //Etiqueta con el nombre del pokemon
        P1nombre = new JLabel(pokemon1.nombre);
        P1nombre.setForeground(Color.white);
        P1nombre.setBounds(680, 450 - 125, 200, 200);
        P1nombre.setFont(new Font("Arial", Font.PLAIN, 40));
        add(P1nombre);

        //Etiqueta con el nivel 
        P1nivel = new JLabel("Nivel:" + pokemon1.nivel);
        P1nivel.setForeground(Color.white);
        P1nivel.setBounds(995, 450 - 125, 200, 200);
        P1nivel.setFont(new Font("Arial", Font.PLAIN, 40));
        add(P1nivel);

        //Boton de ataque 1
        ataque1 = new JButton();
        ataque1.setBounds(680, 620 - 125, 150, 40);
        ataque1.setText(pokemon1.Ataque1);
        ataque1.addActionListener(this);
        add(ataque1);

        //Boton de Ataque 2
        ataque2 = new JButton();
        ataque2.setBounds(850, 620 - 125, 150, 40);
        ataque2.setText(pokemon1.Ataque2);
        ataque2.addActionListener(this);
        add(ataque2);

        //Pokemon del enemigo 
        JButton PokemonEnemigo = new JButton();
        ImageIcon icono2 = new ImageIcon(enemigo);
        PokemonEnemigo.setLocation(780, -100);
        PokemonEnemigo.setSize(500, 500);
        PokemonEnemigo.setVisible(true); //a evolv3cr 
        PokemonEnemigo.setIcon(new ImageIcon(icono2.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        PokemonEnemigo.setLayout(null);
        PokemonEnemigo.setBorderPainted(false);
        PokemonEnemigo.setContentAreaFilled(false);
        PokemonEnemigo.setFocusPainted(false);
        PokemonEnemigo.setOpaque(false);
        this.add(PokemonEnemigo);

        P2nombre = new JLabel(pokemon2.nombre);
        P2nombre.setForeground(Color.white);
        P2nombre.setBounds(60, -25, 250, 250);
        P2nombre.setFont(new Font("Arial", Font.PLAIN, 40));
        add(P2nombre);

        //Etiqueta con el nivel 
        P2nivel = new JLabel("Nivel:" + pokemon2.nivel);
        P2nivel.setForeground(Color.white);
        P2nivel.setBounds(400, -25, 250, 250);
        P2nivel.setFont(new Font("Arial", Font.PLAIN, 35));
        add(P2nivel);

    }

    public void mensaje(String mensaje) {

        JTextArea textoinfo = new JTextArea();

        textoinfo.setBounds(680, 600, 450, 150);
        textoinfo.setText(mensaje);
        textoinfo.setForeground(Color.white);
        textoinfo.setEditable(false);
        textoinfo.setBackground(Color.black);
        textoinfo.setFont(new Font("Arial", Font.PLAIN, 20));
        add(textoinfo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object bontonesbatalla = e.getSource();

        if (bontonesbatalla == ataque1) {
            turno(1);
        } else if (bontonesbatalla == ataque2) {
            turno(2);
        } else if (bontonesbatalla == botonBatalla) {

            OpcionArranque = 2;
            removeAll();
            revalidate();
            updateUI();
            IniciaBatalla();

        } else if (bontonesbatalla == finalizar) {
            //this.setVisible(false);
            //System.exit(0); //Cierra todas las ventanas

            seleccionPoke1 = 1;
            seleccionPoke2 = 1;
            nivelPoke1 = 30;
            Nivelpoke2 = 30;
            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();

            //Botones de selccion pokemon1    
        } else if (bontonesbatalla == Poke1Anterior) {
            if (seleccionPoke1 - 1 == 0) {
                seleccionPoke1 = 151;
            } else {
                seleccionPoke1 = seleccionPoke1 - 1;
            }
            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();

        } else if (bontonesbatalla == Poke1Siguente) {
            if (seleccionPoke1 + 1 == 152) {
                seleccionPoke1 = 1;
            } else {
                seleccionPoke1 = seleccionPoke1 + 1;
            }
            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();

            //Botones de seleccion Pokemon2   
        } else if (bontonesbatalla == Poke2Anterior) {
            if (seleccionPoke2 - 1 == 0) {
                seleccionPoke2 = 151;
            } else {
                seleccionPoke2 = seleccionPoke2 - 1;
            }
            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();

        } else if (bontonesbatalla == Poke2Siguente) {
            if (seleccionPoke2 + 1 == 152) {
                seleccionPoke2 = 1;
            } else {
                seleccionPoke2 = seleccionPoke2 + 1;
            }
            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();
        } else if (bontonesbatalla == poke1SiguenteNivel) {
            if (nivelPoke1 + 1 == 100) {
                nivelPoke1 = 1;
            } else {
                nivelPoke1++;
            }
            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();
        } else if (bontonesbatalla == poke1anteriorNivel) {
            if (nivelPoke1 - 1 == 0) {
                nivelPoke1 = 99;
            } else {
                nivelPoke1--;
            }
            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();
        } else if (bontonesbatalla == poke2SiguenteNivel) {
            if (Nivelpoke2 + 1 == 100) {
                Nivelpoke2 = 1;
            } else {
                Nivelpoke2++;
            }
            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();
        } else if (bontonesbatalla == poke2anteriorNivel) {

            if (Nivelpoke2 - 1 == 0) {
                Nivelpoke2 = 99;
            } else {
                Nivelpoke2--;
            }
            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();

        } else if (bontonesbatalla == BotonRamdom) {
            seleccionPoke1 = (int) (Math.random() * 151);
            seleccionPoke2 = (int) (Math.random() * 151);
            nivelPoke1 = 30;
            Nivelpoke2 = 30;

            OpcionArranque = 1;
            removeAll();
            revalidate();
            updateUI();
            Seleccion();
        }
    }

    public void finalBatalla(int PokemonGanador) {

        String imagen = "pokemones/" + PokemonGanador + ".png";

        JLabel ganador = new JLabel("El Pokemon ganador es ");
        ganador.setForeground(Color.black);
        ganador.setBounds(325, -175, 600, 600);
        ganador.setFont(new Font("Arial", Font.PLAIN, 45));
        add(ganador);

        JButton ImagenGanador = new JButton();
        ImageIcon icono1 = new ImageIcon(imagen);
        ImagenGanador.setLocation(265, 50);
        ImagenGanador.setSize(600, 600);
        ImagenGanador.setVisible(true);
        ImagenGanador.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
        ImagenGanador.setLayout(null);
        ImagenGanador.setBorderPainted(false);
        ImagenGanador.setContentAreaFilled(false);
        ImagenGanador.setFocusPainted(false);
        ImagenGanador.setOpaque(false);
        this.add(ImagenGanador);

        finalizar = new JButton("Terminar");
        finalizar.setBounds(475, ImagenGanador.getWidth() - 25, 200, 200);
        ImageIcon iconoSalir = new ImageIcon("Imagenes/salir.png");
        finalizar.setIcon(new ImageIcon(iconoSalir.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        finalizar.setLayout(null);
        finalizar.setBorderPainted(false);
        finalizar.setContentAreaFilled(false);
        finalizar.setFocusPainted(true);
        finalizar.setOpaque(false);
        finalizar.addActionListener(this);

        finalizar.setPressedIcon(new ImageIcon(iconoSalir.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
        add(finalizar);
    }

    public void turno(int ataque) {

        if (ataque == 1) {
            if ((pokemon2.vida == 0 || pokemon1.vida == 0) || ((pokemon2.vida - pokemon1.dano) <= 0) || ((pokemon1.vida - pokemon2.dano) <= 0)) {
                //System.out.println("Finaliza la batalla");
                removeAll();
                revalidate();
                updateUI();
                if (pokemon2.vida <= 0 || (pokemon2.vida - pokemon1.dano) <= 0) {
                    finalBatalla(seleccionPoke1);
                } else if (pokemon1.vida <= 0 || (pokemon1.vida - pokemon2.dano) <= 0) {
                    finalBatalla(seleccionPoke2);
                }
            } else {

                pokemon2.vida = pokemon2.vida - pokemon1.dano;
                pokemon1.vida = pokemon1.vida - pokemon2.dano;

                removeAll();
                revalidate();
                updateUI();

                mensaje(pokemon1.nombre + " ataco a " + pokemon2.nombre + " con " + pokemon1.Ataque1
                        + "\n" + pokemon2.nombre + " recibe un daño de " + pokemon1.dano
                        + "\n" + pokemon2.nombre + " ataco a " + pokemon1.nombre + " con " + pokemon2.Ataque1
                        + "\n" + pokemon1.nombre + " recibe un daño de " + pokemon2.dano
                        + "\nQue ataque deseas hacer?");
                vida(vidaPorcentaje(pokemon1.vida, vidaP1Inicial), vidaPorcentaje(pokemon2.vida, vidaP2Inicial));
                pokemons(seleccionPoke1, seleccionPoke2);

            }
        } else if (ataque == 2) {
            if ((pokemon2.vida == 0 || pokemon1.vida == 0) || ((pokemon2.vida - pokemon1.dano) <= 0) || ((pokemon1.vida - pokemon2.dano) <= 0)) {

                removeAll();
                revalidate();
                updateUI();
                if (pokemon2.vida <= 0 || (pokemon2.vida - pokemon1.dano) <= 0) {
                    finalBatalla(seleccionPoke1);

                } else if (pokemon1.vida <= 0 || (pokemon1.vida - pokemon2.dano) <= 0) {

                    finalBatalla(seleccionPoke2);
                }

            } else {

                pokemon2.vida = pokemon2.vida - pokemon1.dano;
                pokemon1.vida = pokemon1.vida - pokemon2.dano;

                removeAll();
                revalidate();
                updateUI();

                mensaje(pokemon1.nombre + " ataco a " + pokemon2.nombre + " con " + pokemon1.Ataque2
                        + "\n" + pokemon2.nombre + " recibe un daño de " + pokemon1.dano
                        + "\n" + pokemon2.nombre + " ataco a " + pokemon1.nombre + " con " + pokemon2.Ataque2
                        + "\n" + pokemon1.nombre + " recibe un daño de " + pokemon2.dano
                        + "\nQue ataque deseas hacer?");
                vida(vidaPorcentaje(pokemon1.vida, vidaP1Inicial), vidaPorcentaje(pokemon2.vida, vidaP2Inicial));
                pokemons(seleccionPoke1, seleccionPoke2);

            }
        }
    }

}
