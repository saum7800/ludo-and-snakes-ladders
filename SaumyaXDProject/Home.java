package SaumyaXDProject;

import java.io.*;
class Home
{
    public static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Ludo4 obj=new Ludo4();
        SnakesAndLadders2 obj1=new SnakesAndLadders2();
        int ch=0,flag=0;

        do
        {
            System.out.println("\fWelcome to the game centre!!!ENJOY!!!\n1.Ludo\n2.Snakes and Ladders\n3.Exit");
            try
            {
                ch=Integer.parseInt(br.readLine());
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Enter number only");
                obj.pause();
                obj.pause();
                flag=1;
            }
            if(flag==0)
            {
                switch(ch)
                {
                    case 1:obj.main();
                    break;
                    case 2:obj1.main();
                    break;
                    case 3:System.out.println("Hope you enjoyed the game center");
                    obj.pause();
                    obj.pause();
                    System.exit(0);
                    break;
                    default:System.out.println("Enter number between 1 and 3 only");
                    obj.pause();
                }
            }
            flag=0;
        }while(ch!=3);
    }

    void pause()
    {
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException ie)
        {}
    }
}

    