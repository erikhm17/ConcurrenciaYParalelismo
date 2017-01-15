package PuenteEstrecho;

/**
 * Created by hammer on 27/12/16.
 */
public class CCochesNorte extends Thread{
    CPuenteEstrecho puenteEstrecho;
    public CCochesNorte (CPuenteEstrecho puenteEstrecho){
        this.puenteEstrecho = puenteEstrecho;
    }

    public void run(){
        try {
            /** Entrar coche del norte */
            puenteEstrecho.entrarCocheDelNorte();
            System.out.println("Entro coche : "+getName());


            sleep((long) (Math.random() * 1100));
            puenteEstrecho.salirPuenteDelNorte();
            System.out.println("Salio el coche : "+getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
