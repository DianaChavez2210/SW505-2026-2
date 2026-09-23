import numpy as np

def balistica( x ):
    return - x*x - 4*x -4

def cubica ( x ):
    return x*x*x -5*x*x

def graficar(fun_graf, msj):
    print(msj)
    x = np.arange(-10,10,0.1)
    y = []
    for xd in x: 
        y.append(fun_graf(xd))
        