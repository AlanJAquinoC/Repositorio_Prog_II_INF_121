package Practica_4.ej_1;

public class EmpleadoTiempoHorario extends Empleado {
    // ? a) Los atributos: horas trabajadas y tarifa por hora de tipos doubles.
    private double horas_trabajadas;
    private double tarifa_por_hora;
    // ? b) Un constructor que crea un EmpleadoTiempoHorario con horas trabajadas y tarifa por hora como argumentos.
    public EmpleadoTiempoHorario(String nombre, double horas_trabajadas, double tarifa_por_hora){
        super(nombre);
        this.horas_trabajadas = horas_trabajadas;
        this.tarifa_por_hora = tarifa_por_hora;
    }
    // ? c) Un metodo llamado CalcularSalarioMensual que retorna el salario mensual.
    public double CalcularSalarioMensual(){
        return horas_trabajadas*tarifa_por_hora;
    }
    // ? d) Un metodo llamado toString() que retorna una descripcion de los atributos de la clase EmpleadoTiempoHorario.
    public String toString(){
        return super.toString() + "\nHoras trabajadas: "+ horas_trabajadas+"\nTarifa por hora: "+ tarifa_por_hora;
    }
}
