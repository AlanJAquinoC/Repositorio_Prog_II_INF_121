package Practica_4.ej_1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // ? Escriba un programa de prueba que solicite al usuario que introduzca los datos de tres empleados a tiempo completo y dos empleados de tiempo horario, almacene los cinco en un arreglo de tipo Empleado, posteriormente muestre el nombre y salario de cada empleado.
        Scanner scanner = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];
        // ? Solicitar datos de empleados a tiempo completo
        for(int i=0; i<3; i++){
            System.out.println("Ingrese el nombre del empleado a tiempo completo "+(i+1)+": ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el salario anual del empleado a tiempo completo "+(i+1)+": ");
            double salarioAnual = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salarioAnual);
        }
        System.out.println("----------------------------------");
        // ? Solicitar datos de empleados a tiempo horario
        for (int i=3; i<5; i++){
            System.out.println("Ingrese el nombre del empleado a tiempo horario "+(i-2)+": ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese las horas trabajadas del empleado a tiempo horario "+(i-2)+": ");
            double horas_trabajadas = scanner.nextDouble();
            System.out.println("Ingrese la tarifa por hora del empleado a tiempo horario "+(i-2)+": ");
            double tarifa_por_hora = scanner.nextDouble();
            scanner.nextLine();
            empleados[i] = new EmpleadoTiempoHorario(nombre, horas_trabajadas, tarifa_por_hora);
        }
        // ? Mostrar nombre y salario de cada empleado
        System.out.println("\n--- Informacion de los empleados ---");
        for (Empleado empleado: empleados){
            System.out.println(empleado.toString());
            System.out.println("-------------------------------");
        }
        scanner.close();
    }
}
