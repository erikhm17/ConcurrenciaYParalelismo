package PuenteEstrecho;

/**
 * Created by hammer on 27/12/16.
 */
public class CCochesSur extends Thread{
    CPuenteEstrecho puenteEstrecho;
    public CCochesSur(CPuenteEstrecho puenteEstrecho){
        this.puenteEstrecho = puenteEstrecho;
    }

    public void run(){
        try {
            /** Entrar coche del sur */
            puenteEstrecho.entrarCocheDelSur();
            System.out.println("Entro coche del  : "+getName());
            sleep((long) (Math.random() * 1000));
            puenteEstrecho.salirPuenteDelSur();
            System.out.println("Salio el coche : "+getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
