import java.util.Random;

public class Main
{
    public static void main (String [] args)
    {
        MonteCarlo mtc = new MonteCarlo (1000000);
        MonteCarlo mtc2 = new MonteCarlo (10000000);
        MonteCarlo mtc3 = new MonteCarlo (100000000);
        mtc.start ();
        mtc2.start ();
        mtc3.start ();
        try
        {
            mtc.join ();
            mtc2.join ();
            mtc3.join ();
        }
        catch (InterruptedException e)
        {
        }
        System.out.println("-------------------------------------------------");
        System.out.println ("Dla precyzji "+mtc.precyzja+" pi = " + mtc.pi);
        System.out.println ("Dla precyzji "+mtc2.precyzja+" pi = " + mtc2.pi);
        System.out.println ("Dla precyzji "+mtc3.precyzja+" pi = " + mtc3.pi);
    }
}
class MonteCarlo extends Thread
{
    int precyzja;
    MonteCarlo(int precyzja){
        this.precyzja = precyzja;
    }
    double ranx, randy, pi=0;
    int hit = 0, total = 0;
    Random rand = new Random();
    public void run ()
    {
        for (int i = 0; i < precyzja; i++) {
            ranx = rand.nextDouble();
            randy = rand.nextDouble();
            if (Math.pow(ranx,2)+Math.pow(randy,2)<=1){
                hit++;
            }
            total++;

            pi = (double)(4 * hit) / total;
        }
    System.out.println("Zakończono obliczanie pola koła dla precyzji: "+precyzja);
    }
}