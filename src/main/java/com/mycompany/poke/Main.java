package com.mycompany.poke;

public class Main {

    public static void main(String[] args) {

        String consulta;
        int numero, nivel1 = 0, nivel2 = 0, seleccion1 = 0, seleccion2 = 0;
        boolean terminar = false;

        while (terminar != true){
            System.out.println();
            System.out.println("Bienvenido al Juego de Pokemon");
            System.out.println("Menu:");
            System.out.println("1:Elegir Pokemon \n2:Empezar la Batalla \n3:Pokedex\n4:Salir");
            consulta = Batalla.Comando("Favor Seleccionar la opcion la opcion:");
            numero = Integer.parseInt(consulta);

            switch (numero) {
                case 1:
                    Pokemon.ConsultarPokemon();

                    consulta = Batalla.Comando("Cual pokemon desea para Pokemon 1");
                    seleccion1 = Integer.parseInt(consulta);
                    consulta = Batalla.Comando("Desea seleccionar el nivel: (si/no)");
                    while (true) {
                        if (("si".equals(consulta.toLowerCase()))) {

                            consulta = Batalla.Comando("Favor indique el nivel");
                            nivel1 = Integer.parseInt(consulta);
                            break;
                        } else if ("no".equals(consulta.toLowerCase())) {
                            System.out.println("Se asignara un nivel de 30 a Pokemon 1");
                            nivel1 = 30;
                            break;
                        } else {
                            consulta = Batalla.Comando("Desea seleccionar el nivel: (si/no)");
                        }
                    }
                    consulta = Batalla.Comando("Cual pokemon desea para Pokemon 2");
                    seleccion2 = Integer.parseInt(consulta);
                    consulta = Batalla.Comando("Desea seleccionar el nivel: (si/no)");
                    while (true) {
                        if (("si".equals(consulta.toLowerCase()))) {
                            consulta = Batalla.Comando("Favor indique el nivel");
                            nivel2 = Integer.parseInt(consulta);
                            break;
                        } else if ("no".equals(consulta.toLowerCase())) {
                            System.out.println("Se asignara un nivel de 30 a Pokemon 2");
                            nivel2 = 30;
                            break;
                        } else {
                            consulta = Batalla.Comando("Desea seleccionar el nivel: (si/no)");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Vamos a la Batalla");
                    boolean finalizar = false;
                    if (seleccion1 == 0 & seleccion2 == 0 & nivel1 == 0 & nivel2 == 0) {
                        seleccion1 = (int) (Math.random() * 150);
                        seleccion2 = (int) (Math.random() * 150);
                        Batalla batalla = new Batalla(seleccion1, 30, seleccion2, 30);
                        consulta = batalla.pokemon1.Datos();
                        System.out.println(consulta);
                        consulta = batalla.pokemon2.Datos();
                        System.out.println(consulta);

                        int CuentaTurno = 0;
                        while (finalizar != true) {
                            finalizar = batalla.TurnoAtaque(CuentaTurno);
                            CuentaTurno++;
                        }
                        
                    } else {
                        Batalla batalla = new Batalla(seleccion1, nivel1, seleccion2, nivel2);
                        consulta = batalla.pokemon1.Datos();
                        System.out.println(consulta);
                        consulta = batalla.pokemon2.Datos();
                        System.out.println(consulta);

                        int CuentaTurno = 0;
                        while (finalizar != true) {
                            finalizar = batalla.TurnoAtaque(CuentaTurno);
                            CuentaTurno++;
                        }    
                    }
                    break;
                case 3:
                    Pokemon.Pokedex();
                    break;
                case 4:
                    terminar = true;
                    break;
            }
        }
        //sale del juego
        System.out.println("Gracias por jugar");

    }

}
