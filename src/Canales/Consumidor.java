package Canales;


import csp.lang.*;
import csp.lang.Process; //redefine java.lang.Process
import csp.lang.Integer; //redefine java.lang.Integer

class Consumidor implements Process{
    ChannelInput_of_Integer canal; // el canal para el consumidor
    Integer objeto;

    public Consumidor(ChannelInput_of_Integer in){
        canal= in;
        objeto= new Integer(); //preasignar el objeto
    }
    public void run(){

        canal.read(objeto);
        //System.out.println(objeto); debe ser reemplazado por
        //java.lang.System.out.println(objeto); o por
        //csp.lang.System.out.println(objeto);
        //si no la instruccion de salida seria ambigua!!!
        //java.lang.System.out.println(objeto);
        java.lang.System.out.println(objeto);
    }
}