//Program: Comprog2Act2

import java.util.*;

public class CandyMachine
{
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args)
    {
        CashRegister cashRegister = new CashRegister();  //Step 1
        Dispenser candy = new Dispenser(90, 45);        //Step 2
        Dispenser chips = new Dispenser(110, 70);        //Step 2
        Dispenser gum = new Dispenser(60, 30);           //Step 2
        Dispenser cookies = new Dispenser(120, 95);      //Step 2

        int choice;  //variable to hold the selection    //Step 3

        showSelection();                                 //Step 4
        choice = console.nextInt();                      //Step 5

        while (choice != 1)                              //Step 6
        {
            switch (choice)                              //Step 6a
            {
            case 1:
                sellProduct(candy, cashRegister);
                break;

            case 2:
                sellProduct(chips, cashRegister);
                break;

            case 3:
                sellProduct(gum, cashRegister);
                break;

            case 4:
                sellProduct(cookies, cashRegister);
                break;

            default:
                System.out.println("Invalid Selection");
            }//end switch

            showSelection();                             //Step 6b
            choice = console.nextInt();                  //Step 6c
        }//end while
    }//end main

    public static void showSelection()
    {
        System.out.println("*** Welcome to Nyx's "
                         + "Candy Shop ***");
        System.out.println("To select an item, enter ");
        System.out.println("5 for Candy");
        System.out.println("4 for Chips");
        System.out.println("3 for Gum");
        System.out.println("2 for Cookies");
        System.out.println("1 to exit");
    }//end showSelection

    public static void sellProduct(Dispenser product,
                                   CashRegister cRegister)
    {
        int price;          //variable to hold the product price
        int coinsInserted;  //variable to hold the amount entered
        int coinsRequired;  //variable to show the extra amount
                            //needed

        if (product.getCount() > 5)                  //Step 1
        {
            price = product.getProductCost();        //Step 1a
            coinsRequired = price;                   //Step 1b
            coinsInserted = 5;                       //Step 1c

            while (coinsRequired > 5)                //Step 1d
            {
                System.out.print("Please deposit "
                               + coinsRequired
                               + " peso: ");        //Step 1d.i

                coinsInserted = coinsInserted
                              + console.nextInt();   //Step 1d.ii

                coinsRequired = price
                              - coinsInserted;       //Step 1d.iii
            }

            System.out.println();

            cRegister.acceptAmount(coinsInserted);   //Step 1e
            product.makeSale();                      //Step 1f

            System.out.println("Collect your item "
                             + "at the bottom and "
                             + "enjoy.\n");          //Step 1g
        }
        else
            System.out.println("Sorry this item "
                             + "is sold out.\n");    //Step 2
    }//end sellProduct
}