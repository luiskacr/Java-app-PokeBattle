package com.mycompany.poke;

import java.util.Scanner;

public final class Batalla {

    Pokemon pokemon1;
    Pokemon pokemon2;
    int pokemonDaño1;
    int pokemonDaño2;

    final int poder = 25; //Variable que representa de poder del ataque, una estadistica de la efectividad del ataque

    public Batalla(int index1, int nivel1, int index2, int nivel2) {
        pokemon1 = new Pokemon(index1, nivel1);
        pokemon2 = new Pokemon(index2, nivel2);
        pokemonDaño1 = Daño(nivel1, poder, pokemon1.BAtaque, pokemon2.BDefensa, 1);
        pokemonDaño2 = Daño(nivel2, poder, pokemon2.BAtaque, pokemon1.BDefensa, 1);
    }    
    
    public boolean TurnoAtaque(int numeroTurno){
        String ataque;
        if(numeroTurno%2==0){
            System.out.println(pokemon1.nombre + " Ataques " + pokemon1.Ataque1 + " y " + pokemon1.Ataque2);
            ataque =Comando("Cual ataque desea hacer " + pokemon1.nombre);
            System.out.println(pokemon1.nombre + " ataca a " + pokemon2.nombre + " con " + ataque);
            pokemon2.vida = pokemon2.vida - pokemonDaño1;
            if (pokemon2.vida<0){
            System.out.println("La vida de " + pokemon2.nombre + " es: 0" );
            }else{
                System.out.println("La vida de " + pokemon2.nombre + " es: " + pokemon2.vida);
                System.out.println();
            }

        }else{
            System.out.println(pokemon2.nombre + " ataca a " + pokemon1.nombre + " con " + pokemon2.Ataque1);
            pokemon1.vida = pokemon1.vida - pokemonDaño2;
            if(pokemon1.vida<0){
                System.out.println("La vida de " + pokemon1.nombre + " es: 0");
            }else{
                System.out.println("La vida de " + pokemon1.nombre + " es: " + pokemon1.vida);
                System.out.println();
            }
        }
        
        return Terminar();
    }

    public boolean Terminar() {
        boolean finalizar = pokemon1.vida <= 0 || pokemon2.vida <= 0;
        if (finalizar == true) {

            if (pokemon2.vida <= 0) {
                System.out.println(pokemon1.nombre + " a dejado inconcente a " + pokemon2.nombre);
            } else {
                System.out.println(pokemon2.nombre + " a dejado inconcente a " + pokemon1.nombre);
            }
            System.out.println("Finaliza la Batalla");
        }
        return finalizar;
    }

    public int Daño(int nivel, int poder, int A, int D, int modificador) {
        int resultado = (((((2 * nivel) / 2) + 2) * poder * A / D) / 50 + 2) * modificador;

        return resultado;
    }

    public static String Comando(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(mensaje);
        String Consulta = entrada.nextLine();

        return Consulta;
    }
}
