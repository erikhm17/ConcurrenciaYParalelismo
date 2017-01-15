package Test;

import csp.lang.Thread;

import java.util.concurrent.BlockingQueue;


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
            while (!((msg = buzon.take()).equals("DONE"))){
                System.out.println(msg);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException intEx)
        {
            System.out.println("Interrupted! " +
                    "Last one out, turn out the lights!");
        }
    }

}