from multipledispatch import dispatch
class MiTeleferico:
    def __init__(self):
        self.__lineas = []
        self.__cantidadIngresos = 0
    def ingresoTotal(self):
        pasajeRegular = 0
        pasajePreferencial = 0
        for i in self.__lineas:
            for j in i.getFilasPersonas():
                for per in j.getPersonasAbordo():
                    if per.getEdad() <= 25 and per.getEdad() >= 60:
                        pasajePreferencial += 1.5
                    else:
                        pasajeRegular += 3
        self.__cantidadIngresos = self.__cantidadIngresos + (pasajeRegular + pasajePreferencial)
        print(f"El ingreso total es: {self.__cantidadIngresos}")
        print(f"La linea con tarifa preferencial con mas ingresos es la linea de color: {self.__lineas[0].getColor()}")

    #* INICIO DE LA CLASE LINEA
    class Linea:
        def __init__(self, color):
            self.__color = color
            self.__filasPersonas = []
            self.__cabinas = []
            self.__cantidadCabinas = len(self.__cantidadCabinas)
        #*Getters
        def getFilasPersonas(self):
            return self.__filasPersonas
        def getColor(self):
            return self.__color
        #* Clase Cabina
        class Cabina:
            def __init__(self, nroCabina):
                self.__nroCabina = nroCabina
                self.__personasAbordo = []
            #* Getters
            def getPersonasAbordo(self):
                return self.__personasAbordo
            def getNroCabina(self):
                return self.__nroCabina
            @dispatch(Persona,int)
            def agregarPersona(self, persona, cabinaX):
                cantPersonas = len(self.__personasAbordo)
                for i in persona:
                    if i.getPesoPersona() <= 850 or cantPersonas<=10:
                        if cabinaX == self.__nroCabina:
                            self.personasAbordo.append(persona)
        #* Fin de clase Cabina
        @dispatch(Persona,int)
        def agregarPersona(self, persona, cabinaX):
            cantPersonas = len(self.getPersonaAbordo())
            for j in self.__cabinas:
                for i in j.getPersonasAbordo():
                    if i.getPesoPersona() <= 850 or cantPersonas<=10:
                        if cabinaX == self.__getNroCabina():
                            self.__getPersonasAbordo().append(persona)
        #? Inciso b) 
        def verifReglas(self):
            for i in self.__cabinas:
                cantPersonas = len(i)
                if i.getPesoPersona() <= 850 or cantPersonas<=10:
                    print("Esta cabina SI cumple con las reglas")
                    return True
                else:
                    print("Esta cabina NO cumple con las reglas")
                    return False
        #* FIN DE LA CLASE LINEA

class Persona:
    def __init__(self, nombre, edad, pesoPersona):
        self.__nombre = nombre
        self.__edad = edad
        self.__pesoPersona = pesoPersona
    #* Getters
    def getPesoPersona(self):
        return self.__pesoPersona
    def getEdad(self):
        return self.__edad