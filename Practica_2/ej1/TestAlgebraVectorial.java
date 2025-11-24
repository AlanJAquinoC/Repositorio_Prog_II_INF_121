package Practica_2.ej1;
public class TestAlgebraVectorial {
    public static void main(String[] args) {
        Algebra_Vectorial a=new Algebra_Vectorial(1, 0, 0);  // Vector a = (1, 0, 0)
        Algebra_Vectorial b = new Algebra_Vectorial(0, 1, 0);  // Vector b = (0, 1, 0), perpendicular a a
        Algebra_Vectorial c = new Algebra_Vectorial(2, 0, 0);  // Vector c = (2, 0, 0), paralelo a a
        Algebra_Vectorial d = new Algebra_Vectorial(3, 4, 0); // Vector d = (3, 4, 0), para proyección

        // Imprimir vectores
        System.out.println("Vector a: " + a);
        System.out.println("Vector b: " + b);
        System.out.println("Vector c: " + c);
        System.out.println("Vector d: " + d);

        // Pruebas de perpendicularidad (todas las formas a-d)
        System.out.println("\nPruebas de Perpendicularidad entre a y b:");
        System.out.println("Forma A (|a+b| == |a-b|): " + a.isPerpendicularA(b));
        System.out.println("Forma B (|a-b| == |b-a|): " + a.isPerpendicularB(b));  // Siempre true
        System.out.println("Forma C (a · b == 0): " + a.isPerpendicularC(b));
        System.out.println("Forma D (|a+b|^2 == |a|^2 + |b|^2): " + a.isPerpendicularD(b));

        // Pruebas de paralelismo (formas e-f)
        System.out.println("\nPruebas de Paralelismo:");
        System.out.println("Entre a y c (deben ser paralelos):");
        System.out.println("Forma E (a == r*c): " + a.isParallelE(c));
        System.out.println("Forma F (a × c == 0): " + a.isParallelF(c));
        System.out.println("Entre a y b (no paralelos):");
        System.out.println("Forma E: " + a.isParallelE(b));
        System.out.println("Forma F: " + a.isParallelF(b));

        // Prueba de proyección (g)
        System.out.println("\nProyección de d sobre b: " + d.projection(b));

        // Prueba de componente (h)
        System.out.println("Componente de d en dirección de b: " + d.component(b));
    }
}