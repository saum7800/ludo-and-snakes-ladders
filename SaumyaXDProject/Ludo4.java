package SaumyaXDProject;

import java.io.*;
class Ludo4
{
    int a[][]=new int[15][15];
    int dice_check=0;
    int r1=13,c1=5,r2=13,c2=4,a1=0,a2=0;
    int r3=1,c3=9,r4=1,c4=10,b1=0,b2=0;
    int player1_on_board=0,player=1,current_Move11=1,current_move12=1,cc1=1,cc2=2,counter_p1=0,a1ob=0;
    int player2_on_board=0,current_move21=1,current_move22=1,cc3=10,cc4=50,counter_p2=0,b1ob=0;
    public static void main()throws IOException
    {
        Ludo4 obj=new Ludo4();
        Home obj1=new Home();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        obj.initialize();
        int ch=0;
        int flag=0;
        do
        {
            System.out.println("\fWelcome to the game of Ludo.\n1.Play Game\n2.Instructions\n3.Exit to Game center\nEnter Choice(1-3)");
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
                System.out.println("Welcome to Ludo\nLudo is a game of strategy and luck.\nThis version of Ludo is a 2 player game.The 2 players are player A and player B.\nThe objective of the game is to get both coins of a player to HOME.\nTo start your coin you must roll a 6.\nIf you land directly on top of your opponent\'s coin, then opponent's coin is sent \nback to it\'s original position.\nIf you wish to exit game, enter e when you are asked to roll dice.\nEnjoy the game!To go back to main screen, enter e.");
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
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Ludo4 obj2=new Ludo4();
        while((counter_p1!=2)&&(counter_p2!=2))
            play();
        if(counter_p1==2)
        {
            System.out.println("Player 1 wins!Congratulations!!!");
        }
        else
        {
            System.out.println("Player 2 wins!Congratulations!!!");
        }
        System.out.println("Enter e to go back to main page.");
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

    void play()throws IOException
    {
        Ludo4 obj1=new Ludo4();
        display();

        System.out.println("Player "+(char)(player+64));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char ch;
        String che;
        System.out.println("Enter r to roll dice");
        do
        {
            che=br.readLine();
            if(che.length()==0)
            {
                System.out.println("Please enter a letter.");
            }
            else
            {
                ch=che.charAt(0);
                if(che.length()>1)
                {
                    System.out.println("Enter one letter only.");
                }
                else
                {
                    if(ch!='r'&&ch!='R'&&ch!='e'&&ch!='E')
                    {
                        System.out.println("Please enter r only");
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
        //int dice=Integer.parseInt(br.readLine());
        if(dice_check==1)
        {
            dice_check=0;
            if(dice==6)
                dice--;
        }
        System.out.println("You rolled:"+dice);
        pause();pause();
        if(player==1)
        {
            if(player1_on_board==0)
            {
                if(dice==6)
                {
                    if(a1==1)
                    {
                        a[r2][c2]-=cc2;
                        c2+=2;
                        a[r2][c2]+=cc2;
                        display();
                        pause();
                        player1_on_board++;
                    }
                    else
                    {
                        a[r1][c1]-=cc1;
                        c1++;
                        a[r1][c1]+=cc1;
                        display();
                        pause();
                        player1_on_board++;
                        a1ob++;
                    }
                }
                else
                {
                    System.out.println("You need a 6 to start rolling");
                    pause();pause();
                }
            }
            else if(player1_on_board==1)
            {
                if(counter_p1==1)
                {
                    if(a1==1)
                    {
                        move12(dice);
                    }
                    else if(a2==1)
                    {
                        move11(dice);
                    }
                }
                else
                {
                    if(dice==6)
                    {
                        System.out.println("Do you wish to start with a new coin?(y/n)");
                        char check_new;
                        String chec; 
                        do
                        {
                            chec=br.readLine();
                            if(chec.length()==0)
                                System.out.println("Please enter a letter.");
                            else
                            {
                                check_new=chec.charAt(0);
                                if(chec.length()>1)
                                {
                                    System.out.println("Enter one letter only");
                                }
                                else
                                {
                                    if(check_new!='y'&&check_new!='Y'&&check_new!='n'&&check_new!='N')
                                        System.out.println("Enter y or n only.");
                                    else
                                        break;
                                }
                            }
                        }while(true);
                        char x=check_new;
                        if(x=='n'||x=='N')
                        {
                            if(a1ob==1)
                                move11(dice);
                            else
                                move12(dice);
                        }
                        else if(x=='y'||x=='Y')
                        {
                            if(a1ob==1)
                            {
                                a[r2][c2]-=cc2;
                                c2+=2;
                                a[r2][c2]+=cc2;
                                display();
                                pause();
                                player1_on_board++;
                            }
                            else
                            {
                                a[r1][c1]-=cc1;
                                c1++;
                                a[r1][c1]+=cc1;
                                display();
                                pause();
                                player1_on_board++;
                            }
                        }
                    }
                    else
                    {
                        if(a1ob==1)
                            move11(dice);
                        else
                            move12(dice);
                    }
                }
            }
            else if(player1_on_board==2)
            {
                System.out.println("Enter the coin which you wish to move?(1 or 2)");
                int check_which=0;
                int flag=0;
                do
                {
                    try
                    {
                        check_which=Integer.parseInt(br.readLine());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Please enter only number");
                        flag=1;
                    }
                    if(flag==0)
                    {
                        if(check_which!=1&&check_which!=2)
                            System.out.println("Enter 1 or 2 only");
                        else
                            break;
                    }
                    flag=0;
                }while(true);
                if(check_which==1)
                    move11(dice);
                else if(check_which==2)
                    move12(dice);
            }
            if((r1==r3&&c1==c3)&&(r1==r4&&c1==c4))
            {
                remove_p2(1);
                dice_check++;
            }
            else if((r2==r4&&c2==c4)&&(r2==r3&&c2==c3))
            {
                remove_p2(1);
                dice_check++;
            }
            else if(r1==r3&&c1==c3)
            {
                remove_p2(1);
            }
            else if(r2==r4&&c2==c4)
            {
                remove_p2(2);
            }
            else if(r1==r4&&c1==c4)
            {
                remove_p2(3);
            }
            else if(r2==r3&&c2==c3)
            {
                remove_p2(4);
            }
            if(dice==6)
            {
                System.out.println("You get to roll again!");
                pause();
            }
            else
                player=2;   
        }
        else
        {
            if(player2_on_board==0)
            {
                if(dice==6)
                {
                    if(b1==1)
                    {
                        a[r4][c4]-=cc4;
                        c4-=2;
                        a[r4][c4]+=cc4;
                        display();
                        pause();
                        player2_on_board++;
                    }
                    else
                    {
                        a[r3][c3]-=cc3;
                        c3--;
                        a[r3][c3]+=cc3;
                        display();
                        pause();
                        player2_on_board++;
                        b1ob++;
                    }
                }
                else
                {
                    System.out.println("You need a 6 to start rolling");
                    pause();pause();
                }
            }
            else if(player2_on_board==1)
            {
                if(counter_p2==1)
                {
                    if(b1==1)
                    {
                        move22(dice);
                    }
                    else if(b2==1)
                    {
                        move21(dice);
                    }
                }
                else
                {
                    if(dice==6)
                    {
                        System.out.println("Do you wish to start with a new coin?(y/n)");
                        char check_new;
                        String chec;
                        do
                        {
                            chec=br.readLine();
                            if(chec.length()==0)
                            {
                                System.out.println("Please enter a letter.");
                            }
                            else
                            {
                                check_new=chec.charAt(0);
                                if(chec.length()>1)
                                {
                                    System.out.println("Enter one letter only");
                                }
                                else
                                {
                                    if(check_new!='y'&&check_new!='Y'&&check_new!='n'&&check_new!='N')
                                        System.out.println("Enter y or n only.");
                                    else
                                        break;
                                }
                            }
                        }while(true);
                        char x=check_new;
                        if(x=='n'||x=='N')
                        {
                            if(b1ob==1)
                                move21(dice);
                            else
                                move22(dice);
                        }
                        else if(x=='y'||x=='Y')
                        {
                            if(b1ob==1)
                            {
                                a[r4][c4]-=cc4;
                                c4-=2;
                                a[r4][c4]+=cc4;
                                display();
                                pause();
                                player2_on_board++;    
                            }
                            else
                            {
                                a[r3][c3]-=cc3;
                                c3--;
                                a[r3][c3]+=cc3;
                                display();
                                pause();
                                player2_on_board++;
                                b1ob++;
                            }
                        }
                    }
                    else
                    {
                        if(b1ob==1)
                            move21(dice);
                        else
                            move22(dice);
                    }
                }
            }
            else if(player2_on_board==2)
            {
                System.out.println("Enter the coin which you wish to move?(1 or 2)");
                int check_which=0;
                int flag=0;
                do
                {
                    try
                    {
                        check_which=Integer.parseInt(br.readLine());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Please enter only number");
                        flag=1;
                    }
                    if(flag==0)
                    {
                        if(check_which!=1&&check_which!=2)
                            System.out.println("Enter 1 or 2 only");
                        else
                            break;
                    }
                    flag=0;
                }while(true);
                if(check_which==1)
                    move21(dice);
                else if(check_which==2)
                    move22(dice);
            }
            if((r1==r3&&c1==c3)&&(r2==r3&&c2==c3))
            {
                remove_p1(1);
                dice_check++;
            }
            else if((r2==r4&&c2==c4)&&(r1==r4&&c1==c4))
            {
                remove_p1(1);
                dice_check++;
            }
            else if(r1==r3&&c1==c3)
            {
                remove_p1(1);
            }
            else if(r2==r4&&c2==c4)
            {
                remove_p1(2);
            }
            else if(r1==r4&&c1==c4)
            {
                remove_p1(3);
            }
            else if(r2==r3&&c2==c3)
            {
                remove_p1(4);
            }
            if(dice==6)
            {
                System.out.println("You get to roll again!");
                pause();
            }
            else
                player=1;   
        }
    }

    void remove_p2(int i)
    {
        if(i==1||i==4)
        {
            a[r3][c3]-=cc3;
            r3=1;c3=9;
            a[r3][c3]+=cc3;
            player2_on_board--;
            current_move21=1;
            display();
            pause();
            b1ob--;
        }
        else if(i==2||i==3)
        {
            a[r4][c4]-=cc4;
            r4=1;c4=10;
            a[r4][c4]+=cc4;
            player2_on_board--;
            current_move22=1;
            display();
            pause();
        }
    }

    void remove_p1(int i)
    {
        if(i==1||i==3)
        {
            a[r1][c1]-=cc1;
            r1=13;c1=5;
            a[r1][c1]+=cc1;
            player1_on_board--;
            current_Move11=1;
            a1ob--;
            display();
            pause();
        }
        else if(i==2||i==4)
        {
            a[r2][c2]-=cc2;
            r2=13;c2=4;
            a[r2][c2]+=cc2;
            player1_on_board--;
            current_move12=1;
            display();
            pause();
        }
    }

    void move11(int dice)
    {
        if(current_Move11==1||current_Move11==3||current_Move11==5)
        {
            move_Up11(dice);
        }
        else if(current_Move11==2||current_Move11==10)
        {
            move_Left11(dice);
        }
        else if(current_Move11==4||current_Move11==6||current_Move11==8)
        {
            move_Right11(dice);
        }
        else if(current_Move11==7||current_Move11==9||current_Move11==11)
        {
            move_Down11(dice);
        }
        else
        {
            move_Spec11(dice);
        }
    }

    void move_Up11(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(r1==0||a[r1-1][c1]==-1)
            {
                roll_left=shift11(roll_left);
                current_Move11++;
                move11(roll_left);
                break;
            }
            a[r1][c1]-=cc1;
            a[--r1][c1]+=cc1;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Left11(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(c1==9||c1==0||a[r1][c1-1]==-1)
            {
                roll_left=shift11(roll_left);
                current_Move11++;
                move11(roll_left);
                break;
            }
            a[r1][c1]-=cc1;
            a[r1][--c1]+=cc1;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Right11(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(c1==14||a[r1][c1+1]==-1)
            {
                roll_left=shift11(roll_left);
                current_Move11++;
                move11(roll_left);
                break;
            }
            a[r1][c1]-=cc1;
            a[r1][++c1]+=cc1;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Down11(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(r1==5||r1==14||a[r1+1][c1]==-1)
            {
                roll_left=shift11(roll_left);
                current_Move11++;
                move11(roll_left);
                break;
            }
            a[r1][c1]-=cc1;
            a[++r1][c1]+=cc1;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Spec11(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(a[r1-1][c1]==-1)
            {
                counter_p1++;
                player1_on_board--;
                a[r1][c1]=0;
                r1=0;c1=0;
                a1++;
                display();
                pause();
                break;
            }
            a[r1][c1]-=cc1;
            a[--r1][c1]+=cc1;
            display();
            pause();
            --roll_left;
        }
    }

    int shift11(int roll_left)
    {
        if(current_Move11==1)
        {
            a[r1][c1]-=cc1;
            r1--;
            c1--;
            a[r1][c1]+=cc1;
            display();
            pause();
            roll_left--;
        }
        else if(current_Move11==4)
        {
            a[r1][c1]-=cc1;
            r1--;
            c1++;
            a[r1][c1]+=cc1;
            display();
            pause();
            roll_left--;
        }
        else if(current_Move11==7)
        {
            a[r1][c1]-=cc1;
            r1++;
            c1++;
            a[r1][c1]+=cc1;
            display();
            pause();
            roll_left--;
        }
        else if(current_Move11==10)
        {
            a[r1][c1]-=cc1;
            r1++;
            c1--;
            a[r1][c1]+=cc1;
            display();
            pause();
            roll_left--;
        }
        else if(current_Move11==11)
        {
            a[r1][c1]-=cc1;
            c1--;
            a[r1][c1]+=cc1;
            display();
            pause();
            roll_left--;
        }
        return roll_left;
    }

    void move12(int dice)
    {
        if(current_move12==1||current_move12==3||current_move12==5)
        {
            move_Up12(dice);
        }
        else if(current_move12==2||current_move12==10)
        {
            move_Left12(dice);
        }
        else if(current_move12==4||current_move12==6||current_move12==8)
        {
            move_Right12(dice);
        }
        else if(current_move12==7||current_move12==9||current_move12==11)
        {
            move_Down12(dice);
        }
        else
        {
            move_Spec12(dice);
        }
    }

    void move_Up12(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(r2==0||a[r2-1][c2]==-1)
            {
                roll_left=shift12(roll_left);
                current_move12++;
                move12(roll_left);
                break;
            }
            a[r2][c2]-=cc2;
            a[--r2][c2]+=cc2;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Left12(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(c2==9||c2==0||a[r2][c2-1]==-1)
            {
                roll_left=shift12(roll_left);
                current_move12++;
                move12(roll_left);
                break;
            }
            a[r2][c2]-=cc2;
            a[r2][--c2]+=cc2;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Right12(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(c2==14||a[r2][c2+1]==-1)
            {
                roll_left=shift12(roll_left);
                current_move12++;
                move12(roll_left);
                break;
            }
            a[r2][c2]-=cc2;
            a[r2][++c2]+=cc2;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Down12(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(r2==5||r2==14||a[r2+1][c2]==-1)
            {
                roll_left=shift12(roll_left);
                current_move12++;
                move12(roll_left);
                break;
            }
            a[r2][c2]-=cc2;
            a[++r2][c2]+=cc2;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Spec12(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(a[r2-1][c2]==-1)
            {
                counter_p1++;
                player1_on_board--;
                a[r2][c2]=0;
                r2=1;c2=1;
                a2++;
                display();
                pause();
                break;
            }
            a[r2][c2]-=cc2;
            a[--r2][c2]+=cc2;
            display();
            pause();
            --roll_left;
        }
    }

    int shift12(int roll_left)
    {
        if(current_move12==1)
        {
            a[r2][c2]-=cc2;
            r2--;
            c2--;
            a[r2][c2]+=cc2;
            display();
            pause();
            roll_left--;
        }
        else if(current_move12==4)
        {
            a[r2][c2]-=cc2;
            r2--;
            c2++;
            a[r2][c2]+=cc2;
            display();
            pause();
            roll_left--;
        }
        else if(current_move12==7)
        {
            a[r2][c2]-=cc2;
            r2++;
            c2++;
            a[r2][c2]+=cc2;
            display();
            pause();
            roll_left--;
        }
        else if(current_move12==10)
        {
            a[r2][c2]-=cc2;
            r2++;
            c2--;
            a[r2][c2]+=cc2;
            display();
            pause();
            roll_left--;
        }
        else if(current_move12==11)
        {
            a[r2][c2]-=cc2;
            c2--;
            a[r2][c2]+=cc2;
            display();
            pause();
            roll_left--;
        }
        return roll_left;
    }

    void move21(int dice)
    {
        if(current_move21==1||current_move21==3||current_move21==5)
        {
            move_Down21(dice);
        }
        else if(current_move21==2||current_move21==10)
        {
            move_Right21(dice);
        }
        else if(current_move21==4||current_move21==6||current_move21==8)
        {
            move_Left21(dice);
        }
        else if(current_move21==7||current_move21==9||current_move21==11)
        {
            move_Up21(dice);
        }
        else
        {
            move_Spec21(dice);
        }
    }

    void move_Up21(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(r3==0||a[r3-1][c3]==-1)
            {
                roll_left=shift21(roll_left);
                current_move21++;
                move21(roll_left);
                break;
            }
            a[r3][c3]-=cc3;
            a[--r3][c3]+=cc3;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Left21(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(c3==6||c3==9||c3==0||a[r3][c3-1]==-1)
            {
                roll_left=shift21(roll_left);
                current_move21++;
                move21(roll_left);
                break;
            }
            a[r3][c3]-=cc3;
            a[r3][--c3]+=cc3;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Right21(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(c3==14||a[r3][c3+1]==-1)
            {
                roll_left=shift21(roll_left);
                current_move21++;
                move21(roll_left);
                break;
            }
            a[r3][c3]-=cc3;
            a[r3][++c3]+=cc3;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Down21(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(r3==5||r3==14||a[r3+1][c3]==-1)
            {
                roll_left=shift21(roll_left);
                current_move21++;
                move21(roll_left);
                break;
            }
            a[r3][c3]-=cc3;
            a[++r3][c3]+=cc3;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Spec21(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(a[r3+1][c3]==-1)
            {
                counter_p2++;
                player2_on_board--;
                a[r3][c3]=0;
                r3=2;c3=2;
                b1++;
                display();
                pause();
                break;
            }
            a[r3][c3]-=cc3;
            a[++r3][c3]+=cc3;
            display();
            pause();
            --roll_left;
        }
    }

    int shift21(int roll_left)
    {
        if(current_move21==1)
        {
            a[r3][c3]-=cc3;
            r3++;
            c3++;
            a[r3][c3]+=cc3;
            display();
            pause();
            roll_left--;
        }
        else if(current_move21==4)
        {
            a[r3][c3]-=cc3;
            r3++;
            c3--;
            a[r3][c3]+=cc3;
            display();
            pause();
            roll_left--;
        }
        else if(current_move21==7)
        {
            a[r3][c3]-=cc3;
            r3--;
            c3--;
            a[r3][c3]+=cc3;
            display();
            pause();
            roll_left--;
        }
        else if(current_move21==10)
        {
            a[r3][c3]-=cc3;
            r3--;
            c3++;
            a[r3][c3]+=cc3;
            display();
            pause();
            roll_left--;
        }
        else if(current_move21==11)
        {
            a[r3][c3]-=cc3;
            c3++;
            a[r3][c3]+=cc3;
            display();
            pause();
            roll_left--;
        }
        return roll_left;
    }

    void move22(int dice)
    {
        if(current_move22==1||current_move22==3||current_move22==5)
        {
            move_Down22(dice);
        }
        else if(current_move22==2||current_move22==10)
        {
            move_Right22(dice);
        }
        else if(current_move22==4||current_move22==6||current_move22==8)
        {
            move_Left22(dice);
        }
        else if(current_move22==7||current_move22==9||current_move22==11)
        {
            move_Up22(dice);
        }
        else
        {
            move_Spec22(dice);
        }
    }

    void move_Up22(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(r4==0||a[r4-1][c4]==-1)
            {
                roll_left=shift22(roll_left);
                current_move22++;
                move22(roll_left);
                break;
            }
            a[r4][c4]-=cc4;
            a[--r4][c4]+=cc4;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Left22(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(c4==6||c4==9||c4==0||a[r4][c4-1]==-1)
            {
                roll_left=shift22(roll_left);
                current_move22++;
                move22(roll_left);
                break;
            }
            a[r4][c4]-=cc4;
            a[r4][--c4]+=cc4;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Right22(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(c4==14||a[r4][c4+1]==-1)
            {
                roll_left=shift22(roll_left);
                current_move22++;
                move22(roll_left);
                break;
            }
            a[r4][c4]-=cc4;
            a[r4][++c4]+=cc4;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Down22(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(r4==5||r4==14||a[r4+1][c4]==-1)
            {
                roll_left=shift22(roll_left);
                current_move22++;
                move22(roll_left);
                break;
            }
            a[r4][c4]-=cc4;
            a[++r4][c4]+=cc4;
            display();
            pause();
            --roll_left;
        }
    }

    void move_Spec22(int dice)
    {
        int i,roll_left=dice;
        for(i=0;i<dice;i++)
        {
            if(a[r4+1][c4]==-1)
            {
                counter_p2++;
                player2_on_board--;
                a[r4][c4]=0;
                r4=3;c4=3;
                b2++;
                display();
                pause();
                break;
            }
            a[r4][c4]-=cc4;
            a[++r4][c4]+=cc4;
            display();
            pause();
            --roll_left;
        }
    }

    int shift22(int roll_left)
    {
        if(current_move22==1)
        {
            a[r4][c4]-=cc4;
            r4++;
            c4++;
            a[r4][c4]+=cc4;
            display();
            pause();
            roll_left--;
        }
        else if(current_move22==4)
        {
            a[r4][c4]-=cc4;
            r4++;
            c4--;
            a[r4][c4]+=cc4;
            display();
            pause();
            roll_left--;
        }
        else if(current_move22==7)
        {
            a[r4][c4]-=cc4;
            r4--;
            c4--;
            a[r4][c4]+=cc4;
            display();
            pause();
            roll_left--;
        }
        else if(current_move22==10)
        {
            a[r4][c4]-=cc4;
            r4--;
            c4++;
            a[r4][c4]+=cc4;
            display();
            pause();
            roll_left--;
        }
        else if(current_move22==11)
        {
            a[r4][c4]-=cc4;
            c4++;
            a[r4][c4]+=cc4;
            display();
            pause();
            roll_left--;
        }
        return roll_left;
    }

    void display()
    {
        int i,j;
        System.out.println("\f");
        System.out.println("                                  |----|----|----|                              ");
        for(i=0;i<15;i++)
        {
            if(i<6||i>8)
                System.out.print("     ");
            else
                System.out.print("    |");
            for(j=0;j<15;j++)
            {
                if(a[i][j]==-1)
                    System.out.print("     ");
                else if(a[i][j]==0)
                    System.out.print("    |");
                else if(a[i][j]==1)
                    System.out.print(" A1 |");
                else if(a[i][j]==2)
                    System.out.print(" A2 |");
                else if(a[i][j]==3)
                    System.out.print("A1A2|");
                else if(a[i][j]==10)
                    System.out.print(" B1 |");
                else if(a[i][j]==50)
                    System.out.print(" B2 |");
                else if(a[i][j]==60)
                    System.out.print("B1B2|");
                else if(a[i][j]==11)
                    System.out.print("AlB1|");
                else if(a[i][j]==12)
                    System.out.print("A2B1|");
                else if(a[i][j]==51)
                    System.out.print("A1B2|");
                else if(a[i][j]==52)
                    System.out.print("A2B2|");
                else if(a[i][j]==100)
                    System.out.print("HOME ");
                else if(a[i][j]==13||a[i][j]>=53)
                    System.out.print("....|");
            }
            System.out.println();
            if(i<5||i>8)
                System.out.println("                                  |----|----|----|                              ");
            else if(i==6||i==7)
                System.out.println("    |----|----|----|----|----|----|              |----|----|----|----|----|----|");
            else
                System.out.println("    |----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|");
        }

    }

    void initialize()
    {
        int i,j;
        for(i=0;i<15;i++)
        {
            for(j=0;j<15;j++)
            {
                if(i<6||i>8)
                {
                    if(j<5||j>8)
                    {
                        a[i][j]=-1;
                    }
                    else
                        a[i][j]=0;
                }
                else
                    a[i][j]=0;
            }
        }
        for(i=6;i<=8;i++)
        {
            for(j=6;j<8;j++)
            {
                a[i][j]=-1;
            }
        }
        a[13][5]=1;
        a[13][4]=2;
        a[1][9]=10;
        a[1][10]=50;
        a[7][7]=100;
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