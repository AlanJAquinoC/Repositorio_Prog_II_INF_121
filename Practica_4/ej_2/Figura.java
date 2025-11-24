package Practica_4.ej_2;

//? b) Disene la clase abstracta Figura (atributo: color; metodos no abstractos: setColor, getColor, toString; metodos abstractos: area y perimetro).
public abstract class Figura {
    private String color;
    // * Metodos no abstractos
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    // * Metodos abstractos
    public abstract double area();
    public abstract double perimetro();
}