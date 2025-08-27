package Practica_1.ej3;
import java.util.Scanner;
public class test_est {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese 10 numeros: ");
        double a=sc.nextDouble(); double b=sc.nextDouble(); double c=sc.nextDouble();
        double d=sc.nextDouble(); double e=sc.nextDouble(); double f=sc.nextDouble();
        double g=sc.nextDouble(); double h=sc.nextDouble(); double i=sc.nextDouble();
        double j=sc.nextDouble();
        Estadistica est_1=new Estadistica(10,a,b,c,d,e,f,g,h,i,j);
        System.out.println("El promedio es: "+String.format("%.2f",est_1.promedio()));
        System.out.println("La desviacion estandar es: "+String.format("%.5f",est_1.desviacion()));
        sc.close();
    }
}
