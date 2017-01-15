package Canales;

import csp.lang.*;
import csp.lang.Process; //redefine java.lang.Process
import csp.lang.Integer; //redefine java.lang.Integer

class Productor implements Process{ // implementa un procesos
// definido en CTJ

    // Canal de enteros
    ChannelOutput_of_Integer canal;
    Integer objeto;

    // canal de salida como parametro
    public Productor(ChannelOutput_of_Integer out){
        canal= out;
        objeto= new Integer(); //objeto preasignado
    }

    public void run(){
        objeto.value = 100; // dar un valor al objeto
        canal.write(objeto); // y lo envia por el canal al consumidor
    }
}
