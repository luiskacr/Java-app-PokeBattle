package com.mycompany.poke;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class Pokemon {

    String nombre;
    int nivel, vida;
    String tipo1, tipo2, estado, Ataque1, Ataque2;
    int BVida, BAtaque, BDefensa, Bvelocidad;//Elementos base se un pokemon
    int IVvida = (int) (Math.random() * 15); //Este dato lo vamos a calcular como un aleatorio entre 0 16.
    int ev = (int) (Math.sqrt(Math.random() * 65535) / 4); //Esta es la experiencia del pokemon

    public Pokemon(int Indice, int nivel) {
        // Este siguente codigo lee la "Base de Datos" y lo asigna a una variable tipo Matrix = DataBase[][]
        List<String[]> rowList = new ArrayList<String[]>();
        try ( BufferedReader br = new BufferedReader(new FileReader("pokemonDB.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineItems = line.split(";");
                rowList.add(lineItems);
            }
            br.close();
        } catch (Exception e) {
            // Handle any I/O problems
        }
        String[][] DataBase = new String[rowList.size()][];
        for (int i = 0; i < rowList.size(); i++) {
            String[] row = rowList.get(i);
            DataBase[i] = row;
        }
        //Esta variable matriz la usaremos para cargar los datos que nececitamos para construir un pokemon
        nombre = DataBase[Indice][1];
        estado = "normal";
        this.nivel = nivel;
        tipo1 = DataBase[Indice][2];
        tipo2 = DataBase[Indice][3];
        BVida = Integer.parseInt(DataBase[Indice][4]);
        BAtaque = Integer.parseInt(DataBase[Indice][5]);
        BDefensa = Integer.parseInt(DataBase[Indice][6]);
        Bvelocidad = Integer.parseInt(DataBase[Indice][9]);
        Ataque1 = DataBase[Indice][10];
        Ataque2 = DataBase[Indice][11];

        vida = Calcular(BVida, IVvida);

    }

    //Se crea la funcion para calcular en vez de hacerlo en el constructor ya que la misma se utiliza para caulcular otro valores.
    public int Calcular(int base, int _IVvida) {

        int resultado = ((((base + _IVvida) * 2 + (ev)) * nivel) / 100) + nivel + 10;

        return resultado;
    }

    //Metodo getter para hacer pruebas de los constructores
    public String Datos() {

        String respuesta = "Nombre:" + nombre + " Nivel:" + nivel + " Vida Final:" + vida + " Tipo1:" + tipo1 + " Tipo2:" + tipo2 + " Vida_Base:" + BVida + " Ataque_Base:" + BAtaque
                + " Ataque1:" + Ataque1 + " Ataque2:" + Ataque2;

        return respuesta;
    }

    public static void ConsultarPokemon() {

        List<String[]> rowList = new ArrayList<String[]>();
        try ( BufferedReader br = new BufferedReader(new FileReader("pokemonDB.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineItems = line.split(";");
                rowList.add(lineItems);
            }
            br.close();
        } catch (Exception e) {
            // Handle any I/O problems
        }
        String[][] DataBase = new String[rowList.size()][];
        for (int i = 0; i < rowList.size(); i++) {
            String[] row = rowList.get(i);
            DataBase[i] = row;
        }
        for (int c = 1; c < 152; c++) {
            System.out.println(c + ":" + DataBase[c][1]);
        }
    }

    public static void Pokedex() {
        List<String[]> rowList = new ArrayList<String[]>();
        try ( BufferedReader br = new BufferedReader(new FileReader("pokemonDB.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineItems = line.split(";");
                rowList.add(lineItems);
            }
            br.close();
        } catch (Exception e) {
            // Handle any I/O problems
        }
        String[][] DataBase = new String[rowList.size()][];
        for (int i = 0; i < rowList.size(); i++) {
            String[] row = rowList.get(i);
            DataBase[i] = row;
        }
        for(int c=0;c<150;c++){
            System.out.println();
            for(int j=0;j<12;j++){
                System.out.printf("%-15s",DataBase[c][j] + " ");
            }
        }

    }
}

