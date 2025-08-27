import math
# * Funciones: 
def desviacion():
    suma=0.0
    for i in range(1,n+1):
        x=numeros[i-1]
        prom1=(x-prom)**2
        suma+=prom1
    return math.sqrt(suma/(n-1))

# * Main o programa principal
print("Ingrese los 10 numeros: ")
numeros = []; n=10; suma=0.0
for i in range(1,n+1):
    x=float(input())
    numeros.append(x)
    suma+=x
prom=suma/n
print("El promedio es: %.2f" % prom)
print("La desviacion estandar es: %.5f" % desviacion())