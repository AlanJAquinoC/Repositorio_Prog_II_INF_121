package Practica_1.ej3;
public class Estadistica {
    // ? Estad´ısticas: calcular el promedio y la desviaci´on est´andar. En las aplicaciones comerciales, a menudo se le pide que calcule el promedio y la desviaci´on est´andar de los datos. Ladesviaci´on est´andar es una estad´ıstica que le indica cu´an estrechamente se agrupan todos los diversos datos alrededor de la media en un conjunto de datos. Por ejemplo, ¿cu´al es la edad promedio de los estudiantes en una clase? ¿Qu´e tan cerca est´an las edades? Si todos los estudiantes tienen la misma edad, la desviaci´on es 0.
    private double a; private double b; private double c; private double d; private double 
    e; private double f; private double g; private double h;private double i; private 
    double j; private double n;
    public Estadistica(double n, double a, double b, double c, double d, double e, double 
    f, double g, double h, double i, double j){
        this.n=n;
        this.a=a; this.b=b; this.c=c; this.d=d; this.e=e; this.f=f; this.g=g; this.h=h;
        this.i=i; this.j=j;
    }
    // * Metodos: promedio() obtiene el promedio de los valores en punto flotante
    public double promedio(){
        double suma=0;
        suma=a+b+c+d+e+f+g+h+i+j;
        return suma/n;
    }
    // * desviacion() devuelve la desviacion estandar de los valores en punto flotante
    public double desviacion(){
        double prom=promedio();
        double desvi=((Math.pow((a-prom),2))+(Math.pow((b-prom),2))+(Math.pow((c-prom),2))+(Math.pow((d-prom),2))+(Math.pow((e-prom),2))+(Math.pow((f-prom),2))+(Math.pow((g-prom),2))+(Math.pow((h-prom),2))+(Math.pow((i-prom),2))+(Math.pow((j-prom),2)));
        return Math.sqrt(desvi/(n-1));
    }
}