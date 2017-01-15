package Fumadores;

/**
 * Created by hammer on 03/01/17.
 */
public class AgenteFumadores {
    public static void main(String[] args){
        SalaFumadores sala = new SalaFumadores();
        Fumador fumador1 = new Fumador(1,sala);
        Fumador fumador2 = new Fumador(2,sala);
        Fumador fumador3 = new Fumador(3,sala);
        Agente agente = new Agente(sala);
        fumador1.start();
        fumador2.start();
        fumador3.start();
        agente.start();
    }
}
