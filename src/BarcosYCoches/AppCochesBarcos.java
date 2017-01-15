package BarcosYCoches;

/**
 * Created by hammer on 27/12/16.
 */
public class AppCochesBarcos
{
    public static void main(String arg[])
    {
//--CREAR EL MONITOR
        CPuenteLevadizo puenteLevadizo = new CPuenteLevadizo();
//--CREAR LOS HILOS A LOS QUE SE PASA COMO PARAMETRO EL MONITOR A UTILIZAR
        CCoches c1 = new CCoches(puenteLevadizo);
        CBarcos b1 = new CBarcos(puenteLevadizo);
        CCoches c2 = new CCoches(puenteLevadizo);
        CBarcos b2 = new CBarcos(puenteLevadizo);
        CCoches c3 = new CCoches(puenteLevadizo);
        CBarcos b3 = new CBarcos(puenteLevadizo);
        CCoches c4 = new CCoches(puenteLevadizo);
        CBarcos b4 = new CBarcos(puenteLevadizo);
        CCoches c5 = new CCoches(puenteLevadizo);
        CBarcos b5 = new CBarcos(puenteLevadizo);
//--PONER NOMBRE A LOS HILOS
        c1.setName("Coche 01");
        c2.setName("Coche 02");
        c3.setName("Coche 03");
        c4.setName("Coche 04");
        c5.setName("Coche 05");
        b1.setName("Barco 01");
        b2.setName("Barco 02");
        b3.setName("Barco 03");
        b4.setName("Barco 04");
        b5.setName("Barco 05");
//--EJECUTAR LOS HILOS
        c1.start();
        b1.start();
        c2.start();
        b2.start();
        c3.start();
        b3.start();
        c4.start();
        b4.start();
        c5.start();
        b5.start();
    }
}
