package BarcosYCoches;

/**
 * Created by hammer on 27/12/16.
 */
public class CCoches extends Thread {

    CPuenteLevadizo puenteLevadizo;
    public CCoches(CPuenteLevadizo p_puenteLevadizo)
    {
        puenteLevadizo = p_puenteLevadizo;
    }
    public void run()
    {
        try
        {
            puenteLevadizo.entrarCoche(); //--tratar de pasar el puente
            System.out.println("ENTRO "+getName());
//---PASAR EL PUENTE
            sleep(100);
            puenteLevadizo.salirCoche();
            System.out.println("SALIO "+getName());
        }
        catch (InterruptedException e)
        {
        }
    }
}
