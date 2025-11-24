package Practica_1.ej2;
import java.util.Scanner;
public class test_ecuLine {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese a, b, c:");
        double a,b,c;
        a=sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();
        EcuacionLineal_1 ecu1_1=new EcuacionLineal_1(a, b, c);
        if (ecu1_1.getDiscriminante()>0) {
            System.out.println("La ecuacion tiene dos raices: "+String.format("%.6f", ecu1_1.getRaiz1())+" y "+String.format("%.5f", ecu1_1.getRaiz2()));
        } else if (ecu1_1.getDiscriminante()==0) {
            System.out.println("La ecuacion tiene una raiz: "+String.format("%.0f", ecu1_1.getRaiz1()));
        } else{
            System.out.println("La ecuacion no tiene raices reales.");
        }
        sc.close();
    }
}