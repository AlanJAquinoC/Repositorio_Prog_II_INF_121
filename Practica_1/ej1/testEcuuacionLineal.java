package Practica_1.ej1;
import java.util.Scanner;
public class testEcuuacionLineal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a,b,c,d,e,f;
        System.out.println("Inggrese los valores de a, b, c, d, e, f, separaddos por un espacio: ");a=sc.nextDouble();b=sc.nextDouble();c=sc.nextDouble();d=sc.nextDouble();e=sc.nextDouble();f=sc.nextDouble();
        EcuacionLineal ecu1=new EcuacionLineal(a, b, c, d, e, f);
        if (ecu1.tieneSolucion()==true){
            System.out.println("Valor de x: "+ecu1.getX());
            System.out.println("Valor de y: "+ecu1.getY());
        }else {
            System.out.println("La ecuacion no tiene solucion");
        }
        sc.close();
    }
}
        // EcuacionLineal ecuacion1 = new EcuacionLineal(2, 3, 4, 5, 6, 7);
        // if (ecuacion1.tieneSolucion()) {
        //     System.out.println("La ecuación tiene solución.");
        //     System.out.println("X: " + ecuacion1.getX());
        //     System.out.println("Y: " + ecuacion1.getY());
        // } else {
        //     System.out.println("La ecuación no tiene solución.");
        // }

        // EcuacionLineal ecuacion2 = new EcuacionLineal(1, 2, 2, 4, 3, 6);
        // if (ecuacion2.tieneSolucion()) {
        //     System.out.println("La ecuación tiene solución.");
        //     System.out.println("X: " + ecuacion2.getX());
        //     System.out.println("Y: " + ecuacion2.getY());
        // } else {
        //     System.out.println("La ecuación no tiene solución.");
        // }