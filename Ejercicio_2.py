import json

class Consultorio:
    def __init__(self, consultas, medicos):
        self.consultas = consultas
        self.medicos = medicos
    def __str__(self):
        return f"Consulta: {self.consultas}, Medico: {self.medicos}"
    def to_dict(self):
        return {
            "consultas": self.consultas,
            "medicos": self.medicos
        }
    def guardar(self, ruta):
        datos_guardados_consultas = [i.to_dict() for i in self.consultas]
        datos_guardados_medicos = [p.to_dict() for p in self.medicos]
        datos_guardados = [datos_guardados_consultas, datos_guardados_medicos]
        try:
            with open(ruta,"w") as f:
                json.dump(datos_guardados, f)
                print("GUardado con exito")
        except Exception:
            print(f"Error al guardar")
    def cargar(self, ruta):
        try:
            with open(ruta, "r") as f:
                datos = json.load(f)
                print("Cargado con exito")
        except Exception:
            print("Error al guardar")
    def dar_Alta(self):
        med = self.medicos
        for p in self.consultas:
            med.append(p.idMed)
        return med
    def dar_Baja(self):
        med = self.medicos
        for p in self.consultas:
            med.remove(p.idMed)
        return med


class Consulta:
    def __init__(self, ci, nombrePaciente, apellidoPaciente, idMed, dia, mes, anio):
        self.ci = ci
        self.nombrePaciente = nombrePaciente
        self.apellidoPaciente = apellidoPaciente
        self.idMed = idMed
        self.dia = dia
        self.mes = mes
        self.anio = anio
    def __str__(self):
        return f"ci: {self.ci},nombrePaciente: {self.nombrePaciente}, apellidoPaciente: {self.apellidoPaciente}, idMed: {self.idMed}, dia: {self.dia}, mes: {self.mes}, anio: {self.anio}"
    def to_dict(self):
        return {
            "ci": self.ci,
            "nombrePaciente": self.nombrePaciente,
            "apellidoPaciente": self.apellidoPaciente,
            "idMed": self.idMed,
            "dia": self.dia, 
            "mes": self.mes,
            "anio": self.anio
        }
    def guardar_consulta(self, ruta):
        datos = self.to_dict()
        try:
            with open(ruta,"w") as f:
                json.dump(datos, f)
                print("GUardado con exito")
        except Exception:
            print(f"Error al guardar")
    def cargar_consulta(self, ruta):
        try:
            with open(ruta, "r") as f:
                datos = json.load(f)
                print("Cargado con exito")
        except Exception:
            print("Error al guardar")
    def dar_Alta(self):
        med = self.idMed
        return med
    def dar_Baja(self):
        med = self.idMed
        return med

class Medico:
    def __init__(self, idMed, nombreMed, apellidoMed, aniosExperiencia):
        self.idMed = idMed
        self.nombreMed = nombreMed
        self.apellidoMed = apellidoMed
        self.aniosExperiencia = aniosExperiencia
    def __str__(self):
        return f"idMed: {self.idMed}, nombreMed: {self.nombreMed}, apellidoMed: {self.apellidoMed}, aniosExperiencia: {self.aniosExperiencia}"
    def to_dict(self):
        return {
            "idMed": self.idMed,
            "nombreMed": self.nombreMed,
            "apellidoMed": self.apellidoMed,
            "aniosExperiencia": self.aniosExperiencia
        }
    def guardar(self, ruta):
        datos = self.to_dict()
        try:
            with open(ruta,"w") as f:
                json.dump(datos, f)
                print("GUardado con exito")
        except Exception:
            print(f"Error al guardar")
    def cargar(self, ruta):
        try:
            with open(ruta, "r") as f:
                datos = json.load(f)
                print("Cargado con exito")
        except Exception:
            print("Error al guardar")


#* MAIN
consulta_1 = Consulta(12345678, "Alan", "Aquino", 1885, "Lunes", "Diciembre", 2025)
consulta_2 = Consulta(87654321, "Camilo", "Montaner", 1885, "martes", "Diciembre", 2025)
consulta_3 = Consulta(23456789, "Sandra", "Chuquimia", 1885, "miercoles", "Diciembre", 2024)
consulta_4 = Consulta(98765432, "Ana", "Melo", 1885, "jueves", "Diciembre", 2023)
consulta_5 = Consulta(11223344, "Pablo", "Condori", 1885, "viernes", "Diciembre", 2025)
consulta_6 = Consulta(44332211, "Pedro", "Rojas", 1885, "sabado", "Diciembre", 2024)
consulta_7 = Consulta(55667788, "Juan", "Chester", 1885, "domingo", "Diciembre", 2025)
consulta_8 = Consulta(88776655, "Leonel", "Baltazar", 1885, "Lunes", "Diciembre", 2026)
consulta_9 = Consulta(13579135, "Christian", "Aviles", 1885, "martes", "Diciembre", 2025)
medico_1 = Medico(1885, "Pablo", "Mamani", 12)
medico_2 = Medico(1234, "Juana", "Alarcon", 7)
medico_3 = Medico(4321, "Pablo", "Escobar", 20)
medico_4 = Medico(2345, "Pedro", "Salome", 5)

ruta_1 = r"Ejercicio_1/Archivos/medicos.json"
ruta_2 = r"Ejercicio_1/Archivos/consultas.json"
consultas = [consulta_1, consulta_2, consulta_3, consulta_4, consulta_5, consulta_6, consulta_7, consulta_8, consulta_9]
for i in consultas:
    # i.guardar_consulta(ruta_2)
    i.cargar_consulta(ruta_2)
    print(i)
medicos = [medico_1, medico_2, medico_3, medico_4]
for i in medicos:
    i.guardar(ruta_1)
    i.cargar(ruta_1)
    print(i)


consulta_1.
