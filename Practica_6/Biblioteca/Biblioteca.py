import json
from tkinter import messagebox

class Biblioteca:
    def __init__(self, nombre, dias, hora_apertura, hora_cierre):
        self.nombre = nombre
        self.libros = []
        self.autores = []
        self.prestamos = []
        self.horario = Horario(dias, hora_apertura, hora_cierre)

    def agregar_libro(self, libro):
        self.libros.append(libro)

    def agregar_autor(self, autor):
        self.autores.append(autor)

    def prestar_libro(self, estudiante, libro, fecha_prestamo, fecha_devolucion):
        if libro in self.libros:
            prestamo = Prestamo(estudiante, libro, fecha_prestamo, fecha_devolucion)
            self.prestamos.append(prestamo)
            return True
        return False

    def mostrar_estado(self):
        res = f"Estado de la Biblioteca {self.nombre}:\n"
        res += self.horario.mostrar_horario() + "\n"
        res += "Libros disponibles:\n"
        for l in self.libros:
            res += f"- {l.get_titulo()}\n"
        res += "Autores registrados:\n"
        for a in self.autores:
            res += f"- {a.get_nombre()}\n"
        res += "Préstamos activos:\n"
        for p in self.prestamos:
            res += p.mostrar_info() + "\n"
        return res

    def cerrar_biblioteca(self):
        self.prestamos = []

    # Persistencia JSON como en el ejemplo: convert to dict
    def to_dict(self):
        return {
            'nombre': self.nombre,
            'horario': self.horario.to_dict(),
            'libros': [l.to_dict() for l in self.libros],
            'autores': [a.to_dict() for a in self.autores],
            'prestamos': [p.to_dict() for p in self.prestamos]
        }

    @classmethod
    def from_dict(cls, d):
        bib = cls(d['nombre'], '', '', '')  # Temp, set horario after
        bib.horario = Horario.from_dict(d['horario'])
        bib.libros = [Libro.from_dict(ld) for ld in d['libros']]
        bib.autores = [Autor.from_dict(ad) for ad in d['autores']]
        bib.prestamos = [Prestamo.from_dict(pd) for pd in d['prestamos']]
        return bib

    def guardar(self):
        with open('biblioteca.json', 'w') as archivo:
            json.dump(self.to_dict(), archivo, indent=4)  # Como en page 24

    @classmethod
    def cargar(cls):
        try:
            with open('biblioteca.json', 'r') as archivo:
                d = json.load(archivo)
            return cls.from_dict(d)
        except FileNotFoundError:
            return None

        bib.horario = Horario.from_dict(d['horario'])
        bib.libros = [Libro.from_dict(ld) for ld in d['libros']]
        bib.autores = [Autor.from_dict(ad) for ad in d['autores']]
        bib.prestamos = [Prestamo.from_dict(pd) for pd in d['prestamos']]
        return bib

    def guardar(self):
        with open('biblioteca.json', 'w') as archivo:
            json.dump(self.to_dict(), archivo, indent=4)  # Como en page 24

    @classmethod
    def cargar(cls):
        try:
            with open('biblioteca.json', 'r') as archivo:
                d = json.load(archivo)
            return cls.from_dict(d)
        except FileNotFoundError:
            return None

# *clases auxiliares
class Pagina:
    def __init__(self, numero, contenido):
        self.numero = numero
        self.contenido = contenido

    def mostrar_pagina(self):
        return f"Página {self.numero}: {self.contenido}"

    def to_dict(self):
        return {'numero': self.numero, 'contenido': self.contenido}

    @classmethod
    def from_dict(cls, d):
        return cls(d['numero'], d['contenido'])

class Horario:
    def __init__(self, dias, hora_apertura, hora_cierre):
        self.dias_apertura = dias
        self.hora_apertura = hora_apertura
        self.hora_cierre = hora_cierre

    def mostrar_horario(self):
        return f"Horario: {self.dias_apertura} de {self.hora_apertura} a {self.hora_cierre}"

    def to_dict(self):
        return {'dias_apertura': self.dias_apertura, 'hora_apertura': self.hora_apertura, 'hora_cierre': self.hora_cierre}

    @classmethod
    def from_dict(cls, d):
        return cls(d['dias_apertura'], d['hora_apertura'], d['hora_cierre'])

class Libro:
    def __init__(self, titulo, isbn, contenidos_paginas):
        self.titulo = titulo
        self.isbn = isbn
        self.paginas = [Pagina(i+1, cont) for i, cont in enumerate(contenidos_paginas)]

    def get_titulo(self):
        return self.titulo

    def leer(self):
        res = f"Leyendo libro: {self.titulo}\n"
        for p in self.paginas:
            res += p.mostrar_pagina() + "\n"
        return res

    def to_dict(self):
        return {'titulo': self.titulo, 'isbn': self.isbn, 'paginas': [p.to_dict() for p in self.paginas]}

    @classmethod
    def from_dict(cls, d):
        contenidos = [pd['contenido'] for pd in d['paginas']]  # Solo necesitamos contenidos para recrear
        return cls(d['titulo'], d['isbn'], contenidos)

class Autor:
    def __init__(self, nombre, nacionalidad):
        self.nombre = nombre
        self.nacionalidad = nacionalidad

    def mostrar_info(self):
        return f"Autor: {self.nombre} ({self.nacionalidad})"

    def get_nombre(self):
        return self.nombre

    def to_dict(self):
        return {'nombre': self.nombre, 'nacionalidad': self.nacionalidad}

    @classmethod
    def from_dict(cls, d):
        return cls(d['nombre'], d['nacionalidad'])

class Estudiante:
    def __init__(self, codigo, nombre):
        self.codigo = codigo
        self.nombre = nombre

    def mostrar_info(self):
        return f"Estudiante: {self.nombre} (Código: {self.codigo})"

    def get_nombre(self):
        return self.nombre

    def to_dict(self):
        return {'codigo': self.codigo, 'nombre': self.nombre}

    @classmethod
    def from_dict(cls, d):
        return cls(d['codigo'], d['nombre'])

class Prestamo:
    def __init__(self, estudiante, libro, fecha_prestamo, fecha_devolucion):
        self.estudiante = estudiante
        self.libro = libro
        self.fecha_prestamo = fecha_prestamo
        self.fecha_devolucion = fecha_devolucion

    def mostrar_info(self):
        return f"Préstamo: {self.libro.get_titulo()} a {self.estudiante.get_nombre()} desde {self.fecha_prestamo} hasta {self.fecha_devolucion}"

    def to_dict(self):
        return {'estudiante': self.estudiante.to_dict(), 'libro': self.libro.to_dict(),
                'fecha_prestamo': self.fecha_prestamo, 'fecha_devolucion': self.fecha_devolucion}

    @classmethod
    def from_dict(cls, d):
        est = Estudiante.from_dict(d['estudiante'])
        lib = Libro.from_dict(d['libro'])
        return cls(est, lib, d['fecha_prestamo'], d['fecha_devolucion'])

# *Tkinter
import tkinter as tk
from tkinter import simpledialog, Text, Scrollbar

class Menu(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("MENU")
        self.geometry("450x300")

        # Header azul
        header = tk.Frame(self, bg="blue", height=57)
        header.pack(fill="x")

        lbl = tk.Label(header, text="MENU", fg="white", font=("Times New Roman", 25))
        lbl.place(x=163, y=11)

        # Panel principal
        panel = tk.Frame(self, height=207)
        panel.pack(fill="x")

        btn_biblio = tk.Button(panel, text="Biblioteca", command=self.open_biblioteca)
        btn_biblio.place(x=27, y=22)

        # Otros botones placeholder
        tk.Button(panel, text="Libro").place(x=27, y=60)
        tk.Button(panel, text="Autor").place(x=27, y=104)
        tk.Button(panel, text="Estudiante").place(x=27, y=146)

        # Logo
        try:
            img = tk.PhotoImage(file="C:\\Users\\ASUS\\Desktop\\ALAN 2025\\IMAGENES\\Imagenes_para_informatica\\logo_biblioteca_1.png")
            lbl_img = tk.Label(panel, image=img)
            lbl_img.image = img  # Keep reference
            lbl_img.place(x=208, y=32)
        except:
            pass  # Si no carga, ignora

    def open_biblioteca(self):
        biblio_win = BibliotecaWindow()
        biblio_win.mainloop()

class BibliotecaWindow(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Gestión de Biblioteca")
        self.geometry("500x400")

        self.biblio = Biblioteca.cargar()
        if self.biblio is None:
            self.biblio = Biblioteca("Biblioteca UMSA", "Lunes a Viernes", "08:00", "18:00")
            messagebox.showinfo("Info", "No se encontró archivo. Creando nueva.")

        # Header azul claro
        header = tk.Frame(self, bg="#ADD8E6", height=50)
        header.pack(fill="x")

        lbl = tk.Label(header, text="Gestión de Biblioteca", font=("Times New Roman", 20))
        lbl.place(x=150, y=10)

        # Panel botones gris claro
        panel_botones = tk.Frame(self, bg="#F0F0F0", width=150)
        panel_botones.pack(side="left", fill="y")

        tk.Button(panel_botones, text="Agregar Libro", command=self.agregar_libro_ui).pack(pady=5)
        tk.Button(panel_botones, text="Agregar Autor", command=self.agregar_autor_ui).pack(pady=5)
        tk.Button(panel_botones, text="Prestar Libro", command=self.prestar_libro_ui).pack(pady=5)
        tk.Button(panel_botones, text="Mostrar Estado", command=self.mostrar_estado_ui).pack(pady=5)
        tk.Button(panel_botones, text="Guardar", command=self.guardar_ui).pack(pady=5)
        tk.Button(panel_botones, text="Cargar", command=self.cargar_ui).pack(pady=5)
        tk.Button(panel_botones, text="Cerrar Biblio", command=self.cerrar_biblio_ui).pack(pady=5)

        # Text area
        scroll = Scrollbar(self)
        self.text_area = Text(self, wrap="word", yscrollcommand=scroll.set)
        scroll.config(command=self.text_area.yview)
        self.text_area.pack(side="left", fill="both", expand=True)
        scroll.pack(side="right", fill="y")

        # Imagen estantería al pie (asume path)
        try:
            img_shelves = tk.PhotoImage(file="library_shelves.jpg")
            lbl_shelves = tk.Label(self, image=img_shelves)
            lbl_shelves.image = img_shelves
            lbl_shelves.pack(side="bottom")
        except:
            pass

    def agregar_libro_ui(self):
        titulo = simpledialog.askstring("Agregar Libro", "Título:")
        if not titulo: return
        isbn = simpledialog.askstring("Agregar Libro", "ISBN:")
        if not isbn: return
        num_pag = simpledialog.askinteger("Agregar Libro", "Número de páginas:")
        if not num_pag: return
        contenidos = [f"Contenido página {i+1}" for i in range(num_pag)]
        libro = Libro(titulo, isbn, contenidos)
        self.biblio.agregar_libro(libro)
        messagebox.showinfo("Éxito", "Libro agregado.")

    def agregar_autor_ui(self):
        nombre = simpledialog.askstring("Agregar Autor", "Nombre:")
        if not nombre: return
        nacionalidad = simpledialog.askstring("Agregar Autor", "Nacionalidad:")
        if not nacionalidad: return
        autor = Autor(nombre, nacionalidad)
        self.biblio.agregar_autor(autor)
        messagebox.showinfo("Éxito", "Autor agregado.")

    def prestar_libro_ui(self):
        cod_est = simpledialog.askstring("Prestar", "Código estudiante:")
        if not cod_est: return
        nom_est = simpledialog.askstring("Prestar", "Nombre estudiante:")
        if not nom_est: return
        est = Estudiante(cod_est, nom_est)
        tit_lib = simpledialog.askstring("Prestar", "Título libro:")
        if not tit_lib: return
        libro = next((l for l in self.biblio.libros if l.get_titulo() == tit_lib), None)
        if libro and self.biblio.prestar_libro(est, libro, "2025-11-10", "2025-11-20"):
            messagebox.showinfo("Éxito", "Préstamo creado.")
        else:
            messagebox.showerror("Error", "Libro no encontrado.")

    def mostrar_estado_ui(self):
        self.text_area.delete(1.0, tk.END)
        self.text_area.insert(tk.END, self.biblio.mostrar_estado())

    def guardar_ui(self):
        self.biblio.guardar()
        messagebox.showinfo("Éxito", "Guardado en JSON.")

    def cargar_ui(self):
        loaded = Biblioteca.cargar()
        if loaded:
            self.biblio = loaded
            messagebox.showinfo("Éxito", "Cargado.")
            self.mostrar_estado_ui()
        else:
            messagebox.showerror("Error", "No se pudo cargar.")

    def cerrar_biblio_ui(self):
        self.biblio.cerrar_biblioteca()
        messagebox.showinfo("Éxito", "Préstamos eliminados.")
        self.mostrar_estado_ui()

if __name__ == "__main__":
    menu = Menu()
    menu.mainloop()