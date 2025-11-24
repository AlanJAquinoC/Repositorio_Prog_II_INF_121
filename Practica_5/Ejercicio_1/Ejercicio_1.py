# Clase Pagina: Representa una página física del libro.
class Pagina:
    def __init__(self, numero, contenido):
        self.numero = numero
        self.contenido = contenido

    # Muestra el contenido (corregí nombre, en doc error).
    def mostrar_pagina(self):
        print(f"Página {self.numero}: {self.contenido}")

# Clase Horario: Representa el horario de atención.
class Horario:
    def __init__(self, dias, hora_apertura, hora_cierre):
        self.dias_apertura = dias
        self.hora_apertura = hora_apertura
        self.hora_cierre = hora_cierre

    # Método de f
    def mostrar_horario(self):
        print(f"Horario: {self.dias_apertura} de {self.hora_apertura} a {self.hora_cierre}")

# Clase Libro: Representa un libro físico.
class Libro:
    def __init__(self, titulo, isbn, contenidos_paginas):
        self.titulo = titulo
        self.isbn = isbn
        self.paginas = []  # COMPOSICIÓN: Páginas no existen sin libro 
        for i, cont in enumerate(contenidos_paginas):
            self.paginas.append(Pagina(i + 1, cont))

    def get_titulo(self):
        return self.titulo

    # Muestra todas las páginas 
    def leer(self):
        print(f"Leyendo libro: {self.titulo}")
        for p in self.paginas:
            p.mostrar_pagina()

# Clase Autor: Representa al escritor. 
class Autor:
    def __init__(self, nombre, nacionalidad):
        self.nombre = nombre
        self.nacionalidad = nacionalidad

    # Método de c
    def mostrar_info(self):
        print(f"Autor: {self.nombre} ({self.nacionalidad})")

    def get_nombre(self):
        return self.nombre

# Clase Estudiante: Representa a los usuarios.
class Estudiante:
    def __init__(self, codigo, nombre):
        self.codigo = codigo
        self.nombre = nombre

    # Método de d
    def mostrar_info(self):
        print(f"Estudiante: {self.nombre} (Código: {self.codigo})")

    def get_nombre(self):
        return self.nombre

# Clase Prestamo: Representa el préstamo. 
class Prestamo:
    def __init__(self, estudiante, libro, fecha_prestamo, fecha_devolucion):
        self.fecha_prestamo = fecha_prestamo
        self.fecha_devolucion = fecha_devolucion
        self.estudiante = estudiante  # ASOCIACIÓN: Referencia a estudiante 
        self.libro = libro  # ASOCIACIÓN: Referencia a libro 

    # Método de e
    def mostrar_info(self):
        print(f"Préstamo: {self.libro.get_titulo()} a {self.estudiante.get_nombre()} "
            f"desde {self.fecha_prestamo} hasta {self.fecha_devolucion}")

# Clase Biblioteca: Representa la biblioteca. 
class Biblioteca:
    def __init__(self, nombre, dias, hora_apertura, hora_cierre):
        self.nombre = nombre
        self.libros = []  # AGREGACIÓN: Libros existen independientemente 
        self.autores = []  # AGREGACIÓN: Autores existen independientemente 
        self.prestamos = []  # ASOCIACIÓN: Préstamos se destruyen al cerrar 
        self.horario = Horario(dias, hora_apertura, hora_cierre)  # COMPOSICIÓN: Horario no existe sin biblioteca 

    # Agregar libro (agregación)
    def agregar_libro(self, libro):
        self.libros.append(libro)
        print(f"Libro agregado: {libro.get_titulo()}")

    # Agregar autor (agregación)
    def agregar_autor(self, autor):
        self.autores.append(autor)
        print(f"Autor agregado: {autor.get_nombre()}")

    # Prestar libro (asociación)
    def prestar_libro(self, estudiante, libro, fecha_prestamo, fecha_devolucion):
        if libro in self.libros:
            prestamo = Prestamo(estudiante, libro, fecha_prestamo, fecha_devolucion)
            self.prestamos.append(prestamo)
            print(f"Préstamo creado para {estudiante.get_nombre()}")
        else:
            print("El libro no está disponible.")

    # Mostrar estado
    def mostrar_estado(self):
        print(f"\nEstado de la Biblioteca {self.nombre}:")
        self.horario.mostrar_horario()
        print("Libros disponibles:")
        for l in self.libros:
            print(f"- {l.get_titulo()}")
        print("Autores registrados:")
        for a in self.autores:
            print(f"- {a.get_nombre()}")
        print("Préstamos activos:")
        for p in self.prestamos:
            p.mostrar_info()

    # Cerrar biblioteca (destruye préstamos, pero no libros/autores)
    def cerrar_biblioteca(self):
        print(f"Cerrando biblioteca {self.nombre}")
        self.prestamos = []  # Destruye préstamos 
        print("Préstamos eliminados.")

# * Main 
if __name__ == "__main__":
    # Crear autor y libro independientemente (agregación )
    autor1 = Autor("Gabriel García Márquez", "Colombiano")
    contenidos_paginas = ["Contenido página 1", "Contenido página 2"]
    libro1 = Libro("Cien Años de Soledad", "123456789", contenidos_paginas)

    # Crear biblioteca 
    biblio = Biblioteca("Biblioteca UMSA", "Lunes a Viernes", "08:00", "18:00")

    # Agregar 
    biblio.agregar_autor(autor1)
    biblio.agregar_libro(libro1)

    # Crear estudiante
    est1 = Estudiante("E001", "Juan Pérez")

    # Prestar 
    biblio.prestar_libro(est1, libro1, "2025-11-10", "2025-11-20")

    # Mostrar estado 
    biblio.mostrar_estado()

    # Demostrar composición: Leer libro 
    print("\nDemostrando composición en Libro-Pagina (inciso a de relaciones):")
    libro1.leer()

    # Cerrar: Préstamos se destruyen, libros/autores siguen 
    biblio.cerrar_biblioteca()
    biblio.mostrar_estado()  # Préstamos vacíos

    # Demostrar agregación: Siguen existiendo 
    print("\nDemostrando agregación: Objetos siguen existiendo fuera de biblioteca (inciso b de relaciones)")
    autor1.mostrar_info()
    libro1.leer()