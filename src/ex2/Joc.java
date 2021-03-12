package ex2;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Joc extends Thread {

    Bateria bateria;
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    public Joc(Bateria b){
        this.bateria = b;
    }

    void play() {
        //començar el proces
        executor.submit(descarregar);
    }

    Runnable descarregar = new Runnable() {
        @Override
        public void run() {
            //mentre la bateria no baixi a 0 seguir jugant
                while (bateria.getNivell() != 0) {
                    bateria.descarregar();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    };

    void charge() {
        //començar el proces
        executor.submit(carregar);
    }
    Runnable carregar = new Runnable() {
        @Override
        public void run() {
            //mentre la bateria no estigui carregada seguir carregant
            while(!bateria.carregada()){
                bateria.carregar();
                try{
                    Thread.sleep(200);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    };

}
