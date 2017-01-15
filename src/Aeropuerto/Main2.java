package Aeropuerto;

/**
 * Created by hammer on 31/12/16.
 */
public class Main2 {
    public static void main(String arg[])
    {

//--CREAR EL MONITOR
        MonitorTorre puenteLevadizo = new MonitorTorre();
//--CREAR LOS HILOS A LOS QUE SE PASA COMO PARAMETRO EL MONITOR A UTILIZAR
        AvionEmergencia e1 = new AvionEmergencia(puenteLevadizo);
        AvionEmergencia e2 = new AvionEmergencia(puenteLevadizo);

        AvionAire a1 = new AvionAire(puenteLevadizo);
        AvionAire a2 = new AvionAire(puenteLevadizo);

        AvionSuperficie t1 = new AvionSuperficie(puenteLevadizo);
        AvionSuperficie t2 = new AvionSuperficie(puenteLevadizo);

//--PONER NOMBRE A LOS HILOS
        e1.setName("AvionEmergencia 01");
        e2.setName("AvionEmergencia 02");

        a1.setName("Avion aire 01");
        a2.setName("Avion aire 02");

        t1.setName("Avion tierra 01");
        t2.setName("Avion tierra 02");
//--EJECUTAR LOS HILOS
        t2.start();
        e2.start();
        a1.start();
        t1.start();
        e1.start();
        a2.start();




    }
}
