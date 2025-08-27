package Practica_1.ej1;
public class EcuacionLineal{
    // ? Ejercicio 1: Algebra: ecuaci´on lineal 2 x 2. Dise˜ne la clase EcuacionLineal para un sistema de ecuaciones de 2 x 2.
    // * La clase contiene:
    // * atributos privados a, b, c, d, e y f.
    private double a;
    private double b;
    private double c;
    private double d;
    private double f;
    private double e;
    // * un constructor que recibe los valores de a, b, c, d y f.
    public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
        this.a = a; this.b = b;
        this.c = c; this.d = d;this.f = f;
        this.e = e;
    }
    // * Método tieneSolucion() que devuelve true si ad − bc no es cero.
    public boolean tieneSolucion(){
        if ((a*d)-(b*c) !=0){
                return true;
        }else {
            return false;
        }
    }
    // * Métodos getX() y getY() que devuelven la solución de la ecuación.
    public double getX(){
            return ((e*d)-(b*f))/((a*d)-(b*c));
    }
    public double getY(){
            return ((a*f)-(e*c))/((a*d)-(b*c));
    }
}