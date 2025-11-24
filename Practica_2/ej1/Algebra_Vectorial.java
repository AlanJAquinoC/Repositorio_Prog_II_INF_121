package Practica_2.ej1;

public class Algebra_Vectorial {
    // Atributos privados: representan las componentes del vector (encapsulación).
    private double x;
    private double y;
    private double z;

    // Constructor sobrecargado 1: sin parámetros, crea vector cero.
    public Algebra_Vectorial() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // Constructor sobrecargado 2: con tres doubles para componentes.
    public Algebra_Vectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getters y Setters: acceso controlado a atributos.
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    // Método auxiliar: suma de vectores.
    public Algebra_Vectorial add(Algebra_Vectorial b) {
        return new Algebra_Vectorial(this.x + b.x, this.y + b.y, this.z + b.z);
    }

    // Método auxiliar: resta de vectores.
    public Algebra_Vectorial subtract(Algebra_Vectorial b) {
        return new Algebra_Vectorial(this.x - b.x, this.y - b.y, this.z - b.z);
    }

    // Método auxiliar: multiplicación por escalar.
    public Algebra_Vectorial multiply(double scalar) {
        return new Algebra_Vectorial(scalar * this.x, scalar * this.y, scalar * this.z);
    }

    // Método auxiliar: magnitud (longitud).
    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    // Método auxiliar: producto escalar.
    public double dot(Algebra_Vectorial b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }

    // Método auxiliar: producto vectorial.
    public Algebra_Vectorial cross(Algebra_Vectorial b) {
        return new Algebra_Vectorial(
                this.y * b.z - this.z * b.y,
                this.z * b.x - this.x * b.z,
                this.x * b.y - this.y * b.x
        );
    }

    // Método isPerpendicularA: forma a) |a + b| == |a - b|.
    public boolean isPerpendicularA(Algebra_Vectorial b) {
        double magAdd = this.add(b).magnitude();
        double magSub = this.subtract(b).magnitude();
        return Math.abs(magAdd - magSub) < 1e-10;
    }

    // Método isPerpendicularB: forma b) |a - b| == |b - a|.
    public boolean isPerpendicularB(Algebra_Vectorial b) {
        double magSub1 = this.subtract(b).magnitude();
        double magSub2 = b.subtract(this).magnitude();
        return Math.abs(magSub1 - magSub2) < 1e-10;  // Siempre true.
    }

    // Método isPerpendicularC: forma c) a · b == 0.
    public boolean isPerpendicularC(Algebra_Vectorial b) {
        return Math.abs(this.dot(b)) < 1e-10;
    }

    // Método isPerpendicularD: forma d) |a + b|^2 == |a|^2 + |b|^2.
    public boolean isPerpendicularD(Algebra_Vectorial b) {
        double left = Math.pow(this.add(b).magnitude(), 2);
        double right = Math.pow(this.magnitude(), 2) + Math.pow(b.magnitude(), 2);
        return Math.abs(left - right) < 1e-10;
    }

    // Método isParallelE: forma e) a == r * b para algún r.cero para evitar div/0).
    public boolean isParallelE(Algebra_Vectorial b) {
        if (b.magnitude() == 0) return this.magnitude() == 0;  // Ambos cero: paralelos.
        double rx = (b.x != 0) ? this.x / b.x : Double.NaN;
        double ry = (b.y != 0) ? this.y / b.y : Double.NaN;
        double rz = (b.z != 0) ? this.z / b.z : Double.NaN;
        // Verificar si todos los r definidos son iguales, ignorando NaN si componente cero coincide.
        boolean matchX = (b.x == 0) ? (this.x == 0) : true;
        boolean matchY = (b.y == 0) ? (this.y == 0) : (Math.abs(rx - ry) < 1e-10);
        boolean matchZ = (b.z == 0) ? (this.z == 0) : (Math.abs(rx - rz) < 1e-10);
        return matchX && matchY && matchZ && !Double.isNaN(rx);
    }

    // Método isParallelF: forma f) a × b == 0.
    public boolean isParallelF(Algebra_Vectorial b) {
        Algebra_Vectorial cr = this.cross(b);
        return Math.abs(cr.x) < 1e-10 && Math.abs(cr.y) < 1e-10 && Math.abs(cr.z) < 1e-10;
    }

    // Método projection: forma g) Proj_b a = (a · b / |b|^2) * b.
    public Algebra_Vectorial projection(Algebra_Vectorial b) {
        double magB = b.magnitude();
        if (magB == 0) {
            throw new IllegalArgumentException("No se puede proyectar sobre vector cero.");
        }
        double scalar = this.dot(b) / (magB * magB);
        return b.multiply(scalar);
    }

    // Método component: forma h) Comp_b a = a · b / |b|.
        public double component(Algebra_Vectorial b) {
        double magB = b.magnitude();
        if (magB == 0) {
            throw new IllegalArgumentException("No se puede calcular componente sobre vector cero.");
        }
        return this.dot(b) / magB;
    }

    // Sobrescrito equals: compara si vectores iguales.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Algebra_Vectorial)) return false;
        Algebra_Vectorial that = (Algebra_Vectorial) o;
        return Math.abs(that.x - x) < 1e-10 &&
        Math.abs(that.y - y) < 1e-10 &&
        Math.abs(that.z - z) < 1e-10;
    }

    // Sobrescrito toString: representación como cadena.
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
}

