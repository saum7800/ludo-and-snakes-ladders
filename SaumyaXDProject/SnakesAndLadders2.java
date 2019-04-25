package SaumyaXDProject;

import java.io.*;
class SnakesAndLadders2
{
    int a[][]=new int[10][10];
    int who=1,r_dol=9,c_dol=0,r_has=9,c_has=0,turn_dol=1,turn_has=1,fhs=1,lad=0;

    public static void main()throws IOException
    {
        Home obj1=new Home();
        SnakesAndLadders2 obj=new SnakesAndLadders2();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        obj.initialize();
        int ch=0;
        int flag=0;
        do
        {
            System.out.println("\fWelcome to the game of Snakes And Ladders.\n1.Play Game\n2.Instructions\n3.Exit to Game center\nEnter Choice(1-3)");
            try
            {
                ch=Integer.parseInt(br.readLine());
            }
            catch(NumberFormatException nfe)
            {

                System.out.println("Please enter only number");
                obj.pause();
                flag=1;
            }
            if(flag==0)
            {
                if(ch!=1&&ch!=2&&ch!=3)
                {
                    System.out.println("Enter number between 1 and 3 only");
                    obj.pause();
                }   
            }
            flag=0;
            int chyo=ch;

            if(chyo==1)
            {
                System.out.println("Enjoy the game");
                obj.pause();
                System.out.println("\fIf you wish to exit during the game, enter e");
                obj.pause();
                obj.pause();
                obj.begin();

            }
            else if(chyo==2)
            {
                obj.display();
                System.out.println("Welcome to the game of Snakes And Ladders\nThis version of Snakes And Ladders is a 2 player game. The 2 players are player A and player B.\nThe objective of the game is to get your player to HOME.\nYou must move according to what you roll.\nIf you land directly on top of a lower ladder(depicted by LL),\nyou will be transported to the corresponding upper ladder(depicted by UL).\nExample:If you land on LL1, you will be transported to UL1.\nIf you land directly on top of a upper snake(depicted by US),\nyou will be transported to the corresponding lower snake(depicted by LS).\nExample:If you land on US1, you will be transported to LS1.\nIf you wish to exit game, enter e when you are asked to roll dice.\nEnjoy the game!To go back to main screen, enter e.");
                String che;
                char chec;
                do
                {
                    che=br.readLine();
                    chec=che.charAt(0);
                    if(che.length()>1)
                    {
                        System.out.println("Enter one letter only.");
                    }
                    else
                    {
                        if(chec!='e'&&chec!='E')
                        {
                            System.out.println("Please enter e only");
                        }
                        else
                            break;
                    }
                }while(true);
                obj.main();
            }
            else if(chyo==3)
            {
                obj1.main();
                break;
            }

        }while(true);

    }

    void begin()throws IOException
    {
        SnakesAndLadders2 obj2=new SnakesAndLadders2();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        SpecDisplay();
        while(a[0][0]==0)
            play();
        if(a[0][0]==1)
            System.out.println("Player A wins!Congratulations!!!");
        else
            System.out.println("Player B wins!Congratulations!!!");
        System.out.println("Enter e to exit to main screen");
        char ch;
        String che;
        do
        {
            che=br.readLine();
            ch=che.charAt(0);
            if(che.length()>1)
            {
                System.out.println("Enter one letter only.");
            }
            else
            {
                if(ch!='e'&&ch!='E')
                {
                    System.out.println("Please enter e only");
                }
                else
                {
                    break;
                }
            }
        }while(true);
        obj2.main();
    }

    void initialize()
    {
        int i,j;
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
            {
                a[i][j]=0;
            }
        }
    }

    void play()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        SnakesAndLadders2 obj1=new SnakesAndLadders2();
        System.out.println("                         Player "+(char)(who+64));
        char ch;
        String che;
        System.out.print("                         Enter r to roll dice:");
        do
        {
            che=br.readLine();
            if(che.length()==0)
            {
                System.out.print("                         Please enter a letter:");
            }
            else
            {
                ch=che.charAt(0);
                if(che.length()>1)
                {
                    System.out.println();
                    System.out.print("                         Enter one letter only:");
                }
                else
                {
                    if(ch!='r'&&ch!='R'&&ch!='e'&&ch!='E')
                    {
                        System.out.println();
                        System.out.print("                         Please enter r only:");
                    }
                    else
                    {
                        if(ch=='e'||ch=='E')
                            obj1.main();
                        break;
                    }
                }
            }
        }while(true);
        int dice=(int)(Math.random()*5.9)+1;
        /*System.out.println();
        System.out.print("                                        enter number:");
        int dice=Integer.parseInt(br.readLine());*/
        if((turn_dol==1||turn_has==1)&&dice==1)
            dice=2;
        System.out.println("                         You rolled:"+dice);
        pause();
        pause();
        int i,diff;
        if(who==1)
        {
            if((r_dol%2)!=0)
            {
                diff=moveRightDol(dice);
                if(diff>0)
                {
                    a[r_dol][9]-=who;
                    r_dol--;
                    a[r_dol][9]+=who;
                    display();
                    pause();
                    c_dol=9;
                    diff--;
                    diff=moveLeftDol(diff);
                }
                else if(diff==0)
                    r_dol--;
            }
            else if(r_dol%2==0)
            {
                diff=moveLeftDol(dice);
                if(diff>0)
                {
                    if(r_dol==0)
                    {
                    }
                    else
                    {
                        a[r_dol][0]-=who;
                        r_dol--;
                        a[r_dol][0]+=who;
                        display();
                        pause();
                        c_dol=0;
                        diff--;
                        diff=moveRightDol(diff);
                    }
                }
                else if(diff==0)
                {
                    if(r_dol==0)
                    {}
                    else
                        r_dol--;
                }
            }
            if(dice==6)
            {
                System.out.println("                         You get to roll again!");
                pause();
                pause();
            }
            else
                who=2;
        }
        else if(who==2)
        {
            if((r_has%2)!=0)
            {
                fhs++;
                diff=moveRightHas(dice);
                if(diff>0)
                {
                    a[r_has][9]-=who;
                    r_has--;
                    a[r_has][9]+=who;
                    display();
                    pause();
                    c_has=9;
                    diff--;
                    diff=moveLeftHas(diff);
                }
                else if(diff==0)
                    r_has--;
            }
            else if(r_has%2==0)
            {
                diff=moveLeftHas(dice);
                if(diff>0)
                {
                    if(r_has==0)
                    {}
                    else
                    {
                        a[r_has][0]-=who;
                        r_has--;
                        a[r_has][0]+=who;
                        display();
                        pause();
                        c_has=0;
                        diff--;
                        diff=moveRightHas(diff);
                    }
                }
                else if(diff==0)
                {
                    if(r_has==0)
                    {}
                    else
                        r_has--;
                }
            }
            if(dice==6)
            {
                System.out.println("                         You get to roll again!");
                pause();
                pause();
            }
            else
                who=1;
        }
        display();
    }

    int moveRightDol(int dice)
    {
        SnakesAndLadders2 obj2=new SnakesAndLadders2();
        int i;
        if(turn_dol==1)
            dice--;
        for(i=c_dol;i<c_dol+dice;i++)
        {
            if(i==9)
                return c_dol+dice-9;
            if(turn_dol==1)
            {i--;}
            else
                a[r_dol][i]-=who;
            a[r_dol][i+1]+=who;
            display();
            turn_dol++;
            pause();
        }
        c_dol=i;
        if(r_dol==9&&c_dol==5)
        {
            lad=1;
            sna_lad_dol(6,7);
        }
        else if(r_dol==7&&c_dol==2)
        {
            lad=1;
            sna_lad_dol(3,1);
        }
        else if(r_dol==3&&c_dol==3)
            sna_lad_dol(6,3);
        return -1;
    }

    int moveLeftDol(int dice)
    {
        int i;
        for(i=c_dol;i>c_dol-dice;i--)
        {
            if(i==0)
                return dice-c_dol;
            a[r_dol][i]-=who;
            a[r_dol][i-1]+=who;
            display();
            pause();
        }
        c_dol=i;
        if(r_dol==8&&c_dol==7)
        {
            lad=1;
            sna_lad_dol(5,4);
        }
        else if(r_dol==0&&c_dol==7)
            sna_lad_dol(6,6);
        else if(r_dol==0&&c_dol==2)
            sna_lad_dol(5,1);
        return -1;
    }

    int moveRightHas(int dice)
    {
        SnakesAndLadders2 obj2=new SnakesAndLadders2();
        int i;
        if(turn_has==1)
            dice--;
        for(i=c_has;i<c_has+dice;i++)
        {
            if(i==9)
                return c_has+dice-9;
            if(turn_has==1)
            {i--;}
            else
                a[r_has][i]-=who;
            a[r_has][i+1]+=who;
            display();
            turn_has++;
            pause();
        }
        c_has=i;
        if(r_has==9&&c_has==5)
        {
            lad=1;
            sna_lad_has(6,7);
        }
        else if(r_has==7&&c_has==2)
        {
            lad=1;
            sna_lad_has(3,1);
        }
        else if(r_has==3&&c_has==3)
            sna_lad_has(6,3);
        return -1;
    }

    int moveLeftHas(int dice)
    {
        int i;
        for(i=c_has;i>c_has-dice;i--)
        {
            if(i==0)
                return dice-c_has;
            a[r_has][i]-=who;
            a[r_has][i-1]+=who;
            display();
            pause();
        }
        c_has=i;
        if(r_has==8&&c_has==7)
        {
            lad=1;
            sna_lad_has(5,4);
        }
        else if(r_has==0&&c_has==7)
            sna_lad_has(6,6);
        else if(r_has==0&&c_has==2)
            sna_lad_has(5,1);
        return -1;
    }

    void sna_lad_dol(int i,int j)
    {
        if(lad==1)
        {
            lad=0;
            System.out.println("                         Congratulations!!!You Stepped on a ladder!You will be transported."); 
        }
        else
            System.out.println("                         Ohh no!!!You Stepped on a snake!You will be tansported");
        pause();
        pause();
        a[r_dol][c_dol]-=who;
        display();
        System.out.print("                         Transporting");
        pause();
        System.out.print(".");
        pause();
        System.out.print(".");
        pause();
        System.out.print(".");
        pause();
        r_dol=i;
        c_dol=j;
        a[r_dol][c_dol]+=who;
        display();
        pause();
    }

    void sna_lad_has(int i,int j)
    {
        if(lad==1)
        {
            lad=0;
            System.out.println("                         Congratulations!!!You Stepped on a ladder!You will be transported."); 
        }
        else
            System.out.println("                         Ohh no!!!You Stepped on a snake!You will be tansported");
        pause();
        pause();
        a[r_has][c_has]-=who;
        display();
        System.out.print("                         Transporting");
        pause();
        System.out.print(".");
        pause();
        System.out.print(".");
        pause();
        System.out.print(".");
        pause();
        r_has=i;
        c_has=j;
        a[r_has][c_has]+=who;
        display();
        pause();
    }

    void display()
    {

        int i,j;
        System.out.println("\f");

        for(i=0;i<10;i++)
        {
            System.out.println("                         |-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
            if(fhs==1&&i==9)
                System.out.print("                       B |");
            else
                System.out.print("                         |");
            for(j=0;j<10;j++)
            {
                if(a[i][j]==0)
                {
                    if(i==8&&j==7)
                        System.out.print(" LL1 |");
                    else if(i==5&&j==4)
                        System.out.print(" UL1 |");
                    else if(i==9&&j==5)
                        System.out.print(" LL2 |");
                    else if(i==6&&j==7)
                        System.out.print(" UL2 |");
                    else if(i==7&&j==2)
                        System.out.print(" LL3 |");
                    else if(i==3&&j==1)
                        System.out.print(" UL3 |");
                    else if(i==6&&j==3)
                        System.out.print(" LS1 |");
                    else if(i==3&&j==3)
                        System.out.print(" US1 |");
                    else if(i==6&&j==6)
                        System.out.print(" LS2 |");
                    else if(i==0&&j==7)
                        System.out.print(" US2 |");
                    else if(i==5&&j==1)
                        System.out.print(" LS3 |");
                    else if(i==0&&j==2)
                        System.out.print(" US3 |");
                    else if(i==0&&j==0)
                        System.out.print("HOME |");
                    else
                        System.out.print("     |");
                }
                else if(a[i][j]==1)
                {
                    System.out.print("  A  |");
                }
                else if(a[i][j]==2)
                {
                    System.out.print("  B  |");
                }
                else if(a[i][j]==3)
                {
                    System.out.print(" A B |");
                }
            }
            System.out.println();
        }
        System.out.println("                         |-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
    }

    void SpecDisplay()
    {

        int i,j;
        System.out.println("\f");

        for(i=0;i<10;i++)
        {

            System.out.println("                         |-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");

            if(i==9)
                System.out.print("                     A B |");
            else
                System.out.print("                         |");
            for(j=0;j<10;j++)
            {
                if(a[i][j]==0)
                {
                    if(i==8&&j==7)
                        System.out.print(" LL1 |");
                    else if(i==5&&j==4)
                        System.out.print(" UL1 |");
                    else if(i==9&&j==5)
                        System.out.print(" LL2 |");
                    else if(i==6&&j==7)
                        System.out.print(" UL2 |");
                    else if(i==7&&j==2)
                        System.out.print(" LL3 |");
                    else if(i==3&&j==1)
                        System.out.print(" UL3 |");
                    else if(i==6&&j==3)
                        System.out.print(" LS1 |");
                    else if(i==3&&j==3)
                        System.out.print(" US1 |");
                    else if(i==6&&j==6)
                        System.out.print(" LS2 |");
                    else if(i==0&&j==7)
                        System.out.print(" US2 |");
                    else if(i==5&&j==1)
                        System.out.print(" LS3 |");
                    else if(i==0&&j==2)
                        System.out.print(" US3 |");
                    else if(i==0&&j==0)
                        System.out.print("HOME |");
                    else
                        System.out.print("     |");
                }
                else if(a[i][j]==1)
                {
                    System.out.print("  A  |");
                }
                else if(a[i][j]==2)
                {
                    System.out.print("  B  |");
                }
                else if(a[i][j]==3)
                {
                    System.out.print(" A B |");
                }
            }
            System.out.println();
        }
        System.out.println("                         |-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
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

