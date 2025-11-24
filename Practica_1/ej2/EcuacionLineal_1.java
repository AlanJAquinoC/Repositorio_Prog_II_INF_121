package Practica_1.ej2;

public class EcuacionLineal_1 {
    // ? Diseñe la clase EcuacionLineal para la ecuación cuadrática ax^2 + bx + c = 0.   La clase contiene:
    // * Los atributos privados a, b y c, que representan a los 3 coeficientes.
    private double a;
    private double b;
    private double c;
    // * Un constructor para los argumentos o coeficientes para a, b y c.
    public EcuacionLineal_1(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // * Un método getDiscriminante() que develve el discriminante b^2 − 4ac.
    public double getDiscriminante(){
        return Math.pow(b, 2) - (4*a*c);
    }
    // * Dos métodos getRaiz1() y getRaiz2() que retornan las dos ra´ıces de la ecuación.
    public double getRaiz1(){
        return (-b + Math.sqrt(getDiscriminante()))/(2*a);
    }
    public double getRaiz2(){
        return (-b - Math.sqrt(getDiscriminante()))/(2*a);
    }
    // // * Un método tieneRaices() que devuelve verdadero si el discriminante es mayor o igual que 0 (tiene dos soluciones), y falso en caso contrario.
    // public boolean tieneRaices(){
    //     return getDiscriminante() >= 0;
    // }
    // // * Un método tieneRaiz() que devuelve verdadero si el discriminante es igual a 0 (tiene una sola solución), y falso en caso contrario.
    // public boolean tieneRaiz(){
    //     return getDiscriminante() == 0;
    // }
    // // * Un método calcular() que llama a tieneRaices() y a tieneRaiz(), y muestra por pantalla las dos posibles soluciones que tiene la ecuación con 2 decimales de precisión, o una única solución si tiene una sola raíz.
    // public void calcular(){
    //     if(tieneRaices()){
    //         System.out.printf("La ecuacion tiene dos raices: %.2f y %.2f%n", getRaiz1(), getRaiz2());
    //     } else if(tieneRaiz()){
    //         System.out.printf("La ecuacion tiene una raiz: %.2f%n", getRaiz1());
    //     } else {
    //         System.out.println("La ecuacion no tiene raices reales.");
    //     }
    // }
}
