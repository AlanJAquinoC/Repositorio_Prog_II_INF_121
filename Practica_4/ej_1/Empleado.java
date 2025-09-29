package Practica_4.ej_1;

public abstract class Empleado {
    // ? El atributo: nombre de tipo String
    private String nombre;
    // ? Un constructor que crea un objeto de Empleado con el argumento nombre
    public Empleado(String nombre){
        this.nombre = nombre;
    }
    // ? Un metodo abstracto llamado CalcularSalarioMensual
    // * Metodo abstracto que sera implementado por las clases hijas
    public abstract double CalcularSalarioMensual();
    // ? Un metodo llamado toString() que devuelve una descripcion de los atributos de Empleado.
    public String toString(){
        return "Nombre: " + nombre+"\nSalario Mensual: " + CalcularSalarioMensual();
    }
}
