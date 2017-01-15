package PuenteEstrecho;

/**
 * Created by hammer on 27/12/16.
 */
public class AppCochesNorteYSur {
    public static void main(String[] args) {
        /** creamos el monitor */
        CPuenteEstrecho puenteEstrecho = new CPuenteEstrecho();

        /** creamos los hilos de cada coche q pasa , norte o sur*/


        CCochesSur b1 = new CCochesSur(puenteEstrecho);
        CCochesNorte c1 = new CCochesNorte(puenteEstrecho);
        CCochesNorte c2 = new CCochesNorte(puenteEstrecho);
        CCochesSur b2 = new CCochesSur(puenteEstrecho);
        CCochesNorte c3 = new CCochesNorte(puenteEstrecho);
        CCochesSur b3 = new CCochesSur(puenteEstrecho);
        CCochesNorte c4 = new CCochesNorte(puenteEstrecho);
        CCochesSur b4 = new CCochesSur(puenteEstrecho);
        CCochesNorte c5 = new CCochesNorte(puenteEstrecho);
        CCochesSur b5 = new CCochesSur(puenteEstrecho);

        /** asignamos nombre a los hilos */

        c1.setName("norte 01");
        c2.setName("norte 02");
        c3.setName("norte 03");
        c4.setName("norte 04");
        c5.setName("norte 05");

        b1.setName("sur 01");
        b2.setName("sur 02");
        b3.setName("sur 03");
        b5.setName("sur 05");
        b4.setName("sur 04");

/** ejecutamos los hilos */
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