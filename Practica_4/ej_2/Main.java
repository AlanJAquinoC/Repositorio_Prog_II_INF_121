package Practica_4.ej_2;

public class Main {
    // ? f ) Escriba un programa de prueba que cree un arreglo para cinco figuras. Estas figuras deben ser solo cuadrados o circulos (genere un numero aleatorio 1-Cuadrado o 2- Circulo para agregar al arreglo; los lados y las radios tambien seran generados de manera aleatoria).
    public static void main(String[] args){
        Figura[] figuras = new Figura[5];
        for(int i=0; i<figuras.length; i++){
            int tipoFigura = (int)(Math.random()*2)+1; // 1-Cuadrado, 2-Circulo
            if(tipoFigura == 1){
                double lado = Math.random()*10+1; // Lado entre 1 y 10
                figuras[i] = new Cuadrado(lado, "Rojo");
            } else {
                double radio = Math.random()*10+1; // Radio entre 1 y 10
                figuras[i] = new Circulo(radio, "Azul");
            }
        }
        // ? Posteriormente para cada objeto del arreglo muestre el ´area, el per´ımetro e invoque al m´etodo comoColorear si ´este objeto tiene ´este m´etodo.
        for(Figura figura : figuras){
            System.out.println(figura);
            if(figura instanceof Coloreado){
                System.out.println(((Coloreado) figura).comoColorear());
            }
            System.out.println();
        }
    }
}
