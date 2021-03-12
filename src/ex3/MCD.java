package ex3;

import javax.management.MBeanAttributeInfo;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class MCD {

    public MCD(){}

    public static void main(String[] args) {
        int n1, n2;
        Scanner scanner = new Scanner(System.in);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        System.out.println("Introdueixi el primer numero: ");
        n1 = scanner.nextInt();

        System.out.println("Introdueixi el segon numero: ");
        n2 = scanner.nextInt();

        McdTask task = new McdTask(n1, n2);

        forkJoinPool.invoke(task);
        int resultat = task.join();

        System.out.println("Resultat: " + resultat);
    }
}
