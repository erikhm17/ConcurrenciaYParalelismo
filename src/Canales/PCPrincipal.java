package Canales;

import csp.lang.*;
import csp.lang.Process; //redefine java.lang.Process
import csp.lang.Integer; //redefine java.lang.Integer

public class PCPrincipal {
    public static void main(String[] args) {
        new PCPrincipal();
    }

    public PCPrincipal() {
        final Channel_of_Integer canal = new Channel_of_Integer();

        //crearse una construccion paralela con una lista de procesos

        // arreglo de procesos
        Process par = new Parallel(new Process[]{
                new Productor(canal),
                new Consumidor(canal)
        });
        //ejecutar la composicion paralela
        par.run();
    }
}

