package ex3;

import java.util.concurrent.RecursiveTask;

public class McdTask extends RecursiveTask<Integer> {

    private final int LLINDAR = 20;
    private int num1, num2;

    public McdTask(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    //metode recursiu
    public int mcdRecursion(int num1, int num2){
        if (num2 == 0) return num1;
        McdTask mcd1 = new McdTask(num2, num1%num2);
        mcd1.fork();
        return mcd1.join();
    }

    //metode iteratiu
    public int mcdIterative(int num1, int num2){
        int max = 1;

        for (int i = 1; i <= num1 && i<= num2; i++) {
            if(num1 % i == 0 && num2 % i == 0) max = i;
        }
        return max;
    }

    @Override
    protected Integer compute() {
        //Si els numeros son més grans que el llindar llençar el mètode recursiu
        if(num1 >= LLINDAR && num2 >= LLINDAR) return mcdRecursion(num1, num2);
        //sinó llençar el mètode iteratiu
        else return mcdIterative(num1, num2);
    }
}
