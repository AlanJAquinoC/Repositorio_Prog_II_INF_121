import math

class Vector:
    # Constructor: inicializa componentes.
    def __init__(self, a1, a2, a3):
        self.a1 = a1
        self.a2 = a2
        self.a3 = a3

    # Sobrecarga +: suma de vectores.
    def __add__(self, other):
        if not isinstance(other, Vector):
            raise ValueError("Operando debe ser Vector")
        return Vector(self.a1 + other.a1, self.a2 + other.a2, self.a3 + other.a3)

    # Sobrecarga -: resta de vectores (auxiliar, aunque no listada explícitamente).
    def __sub__(self, other):
        if not isinstance(other, Vector):
            raise ValueError("Operando debe ser Vector")
        return Vector(self.a1 - other.a1, self.a2 - other.a2, self.a3 - other.a3)

    # Sobrecarga *: vector * escalar (derecha).
    def __mul__(self, other):
        if isinstance(other, (int, float)):
            return Vector(self.a1 * other, self.a2 * other, self.a3 * other)
        raise ValueError("Operando debe ser escalar para *")

    # Sobrecarga * desde izquierda: escalar * vector.
    def __rmul__(self, other):
        return self.__mul__(other)

    # Sobrecarga /: vector / escalar.
    def __truediv__(self, other):
        if isinstance(other, (int, float)) and other != 0:
            return Vector(self.a1 / other, self.a2 / other, self.a3 / other)
        raise ValueError("Operando debe ser escalar no cero para /")

    # Sobrecarga abs: magnitud.
    def __abs__(self):
        return math.sqrt(self.a1**2 + self.a2**2 + self.a3**2)

    # Método dot: producto escalar.
    def dot(self, other):
        if not isinstance(other, Vector):
            raise ValueError("Operando debe ser Vector")
        return self.a1 * other.a1 + self.a2 * other.a2 + self.a3 * other.a3

    # Método cross: producto vectorial.
    def cross(self, other):
        if not isinstance(other, Vector):
            raise ValueError("Operando debe ser Vector")
        return Vector(
            self.a2 * other.a3 - self.a3 * other.a2,
            self.a3 * other.a1 - self.a1 * other.a3,
            self.a1 * other.a2 - self.a2 * other.a1
        )

    # Método normal: vector unitario.
    def normal(self):
        mag = abs(self)
        if mag == 0:
            raise ValueError("No se puede normalizar vector cero")
        return self / mag

    # Sobrecarga str: representación.
    def __str__(self):
        return f"({self.a1}, {self.a2}, {self.a3})"

    # Sobrecarga ==: comparación.
    def __eq__(self, other):
        if not isinstance(other, Vector):
            return False
        return (abs(self.a1 - other.a1) < 1e-10 and
                abs(self.a2 - other.a2) < 1e-10 and
                abs(self.a3 - other.a3) < 1e-10)


a = Vector(1, 2, 3)
b = Vector(4, 5, 6)
print("a =", a)
print("b =", b)
c = a + b  # Sobrecarga de +
print("Suma a + b =", c)
d = 2 * a  # Sobrecarga de * (rmul)
print("Multiplicación por escalar 2 * a =", d)
mag_a = abs(a)  # Sobrecarga de abs
print("Longitud de a =", mag_a)
norm_a = a.normal()  # Usa / y abs internamente
print("Normal de a =", norm_a)
dot_ab = a.dot(b)  # Método para ·
print("Producto escalar a · b =", dot_ab)
cross_ab = a.cross(b)  # Método para ×
print("Producto vectorial a × b =", cross_ab)