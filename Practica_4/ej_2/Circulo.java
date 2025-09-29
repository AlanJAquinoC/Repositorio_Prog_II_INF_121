package Practica_4.ej_2;

public class Circulo extends Figura{
    double radio;
    public Circulo(double radio, String color){
        this.radio = radio;
        setColor(color);
    }
    @Override
    public double area(){
        return Math.PI*radio*radio;
    }
    @Override
    public double perimetro(){
        return 2*Math.PI*radio;
    }
    public String toString(){
        return "Circulo de color: "+getColor()+"\nArea: "+area()+"\nPerimetro: "+perimetro();
    }
}
