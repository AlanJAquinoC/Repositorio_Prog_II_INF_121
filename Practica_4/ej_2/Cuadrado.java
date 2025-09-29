package Practica_4.ej_2;
//? c) Dise˜ne una clase llamada Cuadrado que extienda la clase Figura e implemente la interfaz Coloreado. Como implementaci´on de comoColorear retorne el mensaje Colorear los cuatro lados”.
public class Cuadrado extends Figura implements Coloreado {
    private double lado;
    public Cuadrado(double lado, String color){
        this.lado = lado;
        setColor(color);
    }
    @Override
    public double area(){
        return lado*lado;
    }
    @Override
    public double perimetro(){
        return 4*lado;
    }
    @Override
    public String comoColorear(){
        return "Colorear los cuatro lados";
    }
    public String toString(){
        return "Cuadrado de color: "+getColor()+"\nArea: "+area()+"\nPermietro: "+perimetro();
    }
}
