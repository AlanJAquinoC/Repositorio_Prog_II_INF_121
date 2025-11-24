package Practica_4.ej_1;

public class EmpleadoTiempoCompleto extends Empleado{
    // ? a) El atributo: salario anual de tipo double.
    private double salarioAnual;
    // ? b) Un constructor que crea un EmpleadoTiempoCompleto con el salario anual como argumento.
    public EmpleadoTiempoCompleto(String nombre, double salarioAnual){
        super(nombre);
        this.salarioAnual = salarioAnual;
    }
    // ? c) Un metodo llamado CalcularSalarioMensual que retorna el salario mensual.
    public double CalcularSalarioMensual(){
        return salarioAnual/12;
    }
    // ? d) Un metodo llamado toString() que retorna una descripcion de los atributos de la clase EmpleadoTiempoCompleto.
    public String toString(){
        return super.toString() + "\nSalario Anual: "+ salarioAnual;
    }
}
