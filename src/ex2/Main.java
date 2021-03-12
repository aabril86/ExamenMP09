package ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bateria bateria = new Bateria(0);
        Joc joc = new Joc(bateria);
        int opcio;

        do {
            System.out.println("1- Carregar la bateria");
            System.out.println("2- Jugar");
            System.out.println("3- Info bateria");
            System.out.println("0- Sortir");

            opcio = scanner.nextInt();

            switch(opcio){
                case 1:
                    if(bateria.carregada()) System.out.println("La bateria ja es al 100%");
                    else{
                        System.out.println("Inicia carregar");
                        joc.charge();
                    }
                    break;
                case 2:
                    if(bateria.carregada()) {
                        System.out.println("Jugant!");
                        joc.play();
                    } else System.out.println("No hi ha prou bateria: " + bateria.getNivell());
                    break;
                case 3:
                    System.out.println("El nivell de la bateria es " + bateria.getNivell());
                    break;
            }
        }while(opcio != 0);

        joc.executor.shutdown();
    }
}
