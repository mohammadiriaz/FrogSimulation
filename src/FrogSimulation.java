public class FrogSimulation
{
    private int goalDistance;
    private int maxHops;
    
    public FrogSimulation(int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }
    private int hopDistance()
    {
        boolean neg = false;
        int dist = 0;
        if (Math.random() < 0.05) dist = 25;
        if (Math.random() < 0.2) neg = !neg;
        if (neg) dist -= (int) (Math.random() * 7);
        else dist += (int) (Math.random() * 11);
        return dist;
    }
    public boolean simulate(boolean print)
    {
        int pos = 0;
        for (int i = 0; i <= maxHops; i++)
        {
            pos += hopDistance();
            if (pos < 0)
            {
                if (print) System.out.println("The final position of the frog is " + pos);
                return false;
            }
        }
        if (print) System.out.println("The final position of the frog is " + pos);
        if (pos >= goalDistance) return true;
        else return false;
    }
    public double runSimulations(int num, boolean print)
    {
        double wins = 0;
        for (int i = 0; i < num; i++)
        {
            if (simulate(print)) wins++;
        }
        return wins / num;
    }
}
