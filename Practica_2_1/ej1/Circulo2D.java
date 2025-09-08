package Practica_2_1.ej1;
public class Circulo2D {
    public double x;
    public double y;
    public double radio;
    // ? Dos campos de datos dobles llamados x e y que especifican el centro del círculo con los métodos get.
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    // ? Un campo de datos radio con un método get.
    public double getRadio(){
        return radio;
    }
    // ? Un constructor sin argumentos que crea un círculo predeterminado con (0, 0) para (x, y) y 1 para el radio.
    public Circulo2D(){
        this.x=0; 
        this.y=0; 
        this.radio=1;
    }
    // ? Un constructor que crea un círculo con los valores x, y y radio especificados.
    public Circulo2D(double x, double y, double radio){
        this.x=x;
        this.y=y;
        this.radio=radio;
    }
    // ? Un método getArea() que devuelve el área del círculo.
    public double getArea(){
        return Math.PI*Math.pow(radio, 2);
    }
    //? Un método getPerimetro() que devuelve el perímetro del círculo.
    public double getPerimetro(){
        return 2*Math.PI*radio;
    }
    //? Un método contiene(double x, double y) que devuelve verdadero si el punto especificado (x, y) está dentro de este círculo y falso en caso contrario.
    public boolean contiene(double x, double y){
        double distancia= Math.sqrt((Math.pow(x-this.x, 2)) + (Math.pow(y-this.y, 2)));
        return distancia < radio;
    }
    //? Un método contiene(Circulo2D circulo) que devuelve true si el círculo especificado está dentro de este círculo
    public boolean contiene(Circulo2D otrocirculo){
        double distancia= Math.sqrt((Math.pow(otrocirculo.x-this.x, 2)) + (Math.pow(otrocirculo.y-this.y, 2)));
        return distancia+otrocirculo.radio<this.radio;
    }
    //? Un método sobrepone(Circulo2D circulo) que devuelve true si el círculo especificado se sobrepone al circulo de entrada
    public boolean sobrepone(Circulo2D otrocirculo){
        double distancia= Math.sqrt((Math.pow(otrocirculo.x-this.x, 2)) + (Math.pow(otrocirculo.y-this.y, 2)));
        double sumRadios=otrocirculo.radio+this.radio;
        double resRadios=Math.abs(this.radio-otrocirculo.radio);
        return distancia<resRadios && distancia>sumRadios;
    }
    public static void main(String[] arg){
        Circulo2D c1=new Circulo2D(2,0,1);
        System.out.println("AREA: "+c1.getArea());
        System.out.println("PERIMETRO: "+c1.getPerimetro());
        if (c1.contiene((2.5),0)) {
            System.out.println("El punto dado esta dentro del circulo");
        } else{
        System.out.println("El punto dado no esta dentro del circulo");
        }
        Circulo2D c2=new Circulo2D(2,0,(0.5));
        System.out.println("Segundo circulo");
        if (c1.contiene(c2)){
            System.out.println("El circulo dado esta dentro del circulo inicial");
        } else{
            System.out.println("El circulo dado no esta dentro del circulo inicial");
        }
        Circulo2D c3=new Circulo2D(0, 0, 2);
        System.out.println("Tercer circulo");
        if (c1.sobrepone(c3)) {
            System.out.println("Un circulo se sobrepone al otro");
        } else{
            System.out.println("Un circulo no se sobrepone al otro");
        }
    }
}
