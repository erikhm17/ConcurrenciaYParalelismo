package BarcosYCoches;

/**
 * Created by hammer on 27/12/16.
 */
public class CBarcos extends Thread
{
    CPuenteLevadizo puenteLevadizo;
    public CBarcos(CPuenteLevadizo p_puenteLevadizo)
    {
        puenteLevadizo = p_puenteLevadizo;
    }
    public void run()
    {
        try
        {
            puenteLevadizo.entrarBarco(); //--tratar de pasar el puente
            System.out.println("ENTRO "+getName());
//---PASAR EL PUENTE
            sleep(200);
            puenteLevadizo.salirBarco();
            System.out.println("SALIO "+getName());
        }
        catch (InterruptedException e)
        {
        }
    }
}
