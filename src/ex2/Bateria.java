package ex2;

public class Bateria {
    private int nivell;
    boolean plena, buida;

    public Bateria(int i) {
        nivell = i;
        if(i < 100) plena = false;
        else plena = true;
        if(i == 0) buida = true;
        else buida = false;
    }

    public int getNivell() {
        return nivell;
    }

    public void carregar() {
        if(!plena) {
            nivell++;
            buida = false;
        }
        if(nivell == 100) plena = true;
    }

    public void descarregar() {
        if(!buida) {
            nivell--;
            plena = false;
        }
        if(nivell == 0) buida = true;
    }

    public boolean carregada() {
        return plena;
    }
}