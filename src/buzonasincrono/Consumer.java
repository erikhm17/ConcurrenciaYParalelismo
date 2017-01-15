package buzonasincrono;

import java.util.*;
import java.util.concurrent.*;


public class Consumer implements Runnable
{
    private BlockingQueue<String> buzon;
    // inicio el consumidor
    public Consumer(BlockingQueue<String> d) { buzon = d; }

    public void run()
    {
        try
        {
            String msg = null;
		/* */
            while (!((msg = buzon.take()).equals("DONE")))
                System.out.println(msg);
        }
        catch (InterruptedException intEx)
        {
            System.out.println("Interrupted! " +
                    "Last one out, turn out the lights!");
        }
    }

}