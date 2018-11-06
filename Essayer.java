abstract class Essayer
{
    public static void main(String arg[])
    {
       Essai e = new Essai();
       e = null;
       System.gc();
    }
}
