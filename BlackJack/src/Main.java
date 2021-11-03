import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        BlackJackGame mygame = new BlackJackGame();
        Image image = new Image();

        //Creates variables
        int [][] deckValue = new int[52][2];
        String [] deckName = new String[52];
        boolean Answer;
        String Card;
        boolean CardsAreAvailable = false;
        int DarkCard;
        int Money;
        String PlayAgain;
        int [][] CounterValue = new int[2][2];
        CounterValue[1][1] = 100;
       //these variables are for an alternative calculation of whether the ace should be 1 or 11
        int PointAlt;
        int PointAltD;

        //Creates Scanners
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        //Creates a variable that randomizes the cards
        Random randGenerator = new Random();
        int randInt = randGenerator.nextInt (52);

        image.picture();

        do {
            //Prints test cases
            System.out.println();
            System.out.println("*************Test Case*************");
            mainTest.test(deckValue);
            Answer = false;
            BlackJackGame.CreateCardValue(deckValue);
            BlackJackGame.Namn(deckName);
            mainTest.test(deckValue);
            mainTest.TestValue(deckValue);
            mainTest.TestName(deckName);
            mainTest.TestPoint(CounterValue);
            mainTest.TestBalance(CounterValue);
            System.out.println("*************Test Case*************");
            System.out.println();
            mygame.initializeGame();
            CounterValue[0][0] = 0;
            CounterValue[1][0] = 0;
            PointAlt = 0;
            PointAltD = 0;
            DarkCard = 0;

            //Prints a question to the player how much he wants to bet
            System.out.println("Ditt saldo är " + CounterValue[1][1]);
            System.out.print("Hur mycket vill du satsa?");
            Money = scan2.nextInt();

            System.out.print("SPELARE");
            System.out.print("              ");
            System.out.println("DEALER");

            //Random player's first card
            do {
                if (deckValue[randInt][0] == 0){
                    randInt = randGenerator.nextInt (52);
                    CardsAreAvailable = false;
                }
                else if (deckValue[randInt][0] == 1){
                    deckValue[randInt][0] = 0;
                    System.out.print(deckName[randInt]);
                    if (deckValue[randInt][1] == 11){
                        CounterValue[1][0] = Counter.getSum(CounterValue[1][0], deckValue[randInt][1]);
                        PointAlt = Counter.getSum(PointAlt, 1);
                    }
                    else {
                        CounterValue[1][0] = Counter.getSum(CounterValue[1][0], deckValue[randInt][1]);
                        PointAlt = Counter.getSum(PointAlt, deckValue[randInt][1]);
                    }
                    CardsAreAvailable = true;
                }
            }
            while (CardsAreAvailable == false);

            //Random of the dealer's first card
            do {
                CardsAreAvailable = false;
                if (deckValue[randInt][0] == 0){
                    randInt = randGenerator.nextInt (52);
                }
                else if (deckValue[randInt][0] == 1){
                    deckValue[randInt][0] = 0;
                    System.out.print("                ");
                    System.out.println(deckName[randInt]);

                    if (deckValue[randInt][1] == 11){
                        CounterValue[0][0] = Counter.getSum(CounterValue[0][0], deckValue[randInt][1]);
                        PointAltD = Counter.getSum(PointAltD, 1);
                    }
                    else {
                        CounterValue[0][0] = Counter.getSum(CounterValue[0][0], deckValue[randInt][1]);
                        PointAltD = Counter.getSum(PointAltD, deckValue[randInt][1]);
                    }
                    CardsAreAvailable = true;
                }
            }
            while (CardsAreAvailable == false);

            //Random player's second card
            do {
                CardsAreAvailable = false;
                if (deckValue[randInt][0] == 0){
                    randInt = randGenerator.nextInt (52);
                }
                else if (deckValue[randInt][0] == 1){
                    deckValue[randInt][0] = 0;
                    System.out.print(deckName[randInt]);

                    if (deckValue[randInt][1] == 11){
                        CounterValue[1][0] = Counter.getSum(CounterValue[1][0], deckValue[randInt][1]);
                        PointAlt = Counter.getSum(PointAlt, 1);
                    }
                    else {
                        CounterValue[1][0] = Counter.getSum(CounterValue[1][0], deckValue[randInt][1]);
                        PointAlt = Counter.getSum(PointAlt, deckValue[randInt][1]);
                    }
                    CardsAreAvailable = true;
                }
            }
            while (CardsAreAvailable == false);

            //Random of the dealer's second card (The dark card)
            do {
                CardsAreAvailable = false;
                if (deckValue[randInt][0] == 0){
                    randInt = randGenerator.nextInt (52);
                }
                else if (deckValue[randInt][0] == 1){
                    deckValue[randInt][0] = 0;
                    System.out.print("                ");
                    System.out.println("Mörkt kort");
                    DarkCard = randInt;

                    if (deckValue[randInt][1] == 11){
                        CounterValue[0][0] = Counter.getSum(CounterValue[0][0], deckValue[randInt][1]);
                        PointAltD = Counter.getSum(PointAltD, 1);
                    }
                    else {
                        CounterValue[0][0] = Counter.getSum(CounterValue[0][0], deckValue[randInt][1]);
                        PointAltD = Counter.getSum(PointAltD, deckValue[randInt][1]);
                    }
                    CardsAreAvailable = true;
                }
            }
            while (CardsAreAvailable == false);

            //Counts the sum of the player's cards
            do {
                Answer = true;

                if (PointAlt != CounterValue[1][0]){
                    System.out.println("Spelare har " + CounterValue[1][0] + " eller " + PointAlt);
                }
                else {
                    System.out.println("Spelare har " + CounterValue[1][0]);
                }

                //Check if the player got over 21
                if (CounterValue[1][0] > 21){

                    if (PointAlt > 21){
                        System.out.println("Spelare fick över 21 och är nu tjock!");
                        Answer = false;
                    }
                    else {
                        CounterValue[1][0] = PointAlt;
                    }

                }

                //Gives you the choice of whether you want more cards or not
                else if (CounterValue[1][0] < 21){
                    System.out.print("Vill du ha fler kort?");
                    Card = scan.nextLine();

                    if (Card.equals("ja")) {
                        Answer = true;

                        //If you answer yes, you will receive another card
                        do {
                            CardsAreAvailable = false;
                            if (deckValue[randInt][0] == 0){
                                randInt = randGenerator.nextInt (52);
                            }
                            else if (deckValue[randInt][0] == 1){
                                deckValue[randInt][0] = 0;
                                System.out.println(deckName[randInt]);
                                if (deckValue[randInt][1] == 11){
                                    CounterValue[1][0] = Counter.getSum(CounterValue[1][0], deckValue[randInt][1]);
                                    PointAlt = Counter.getSum(PointAlt, 1);
                                }
                                else {
                                    CounterValue[1][0] = Counter.getSum(CounterValue[1][0], deckValue[randInt][1]);
                                    PointAlt = Counter.getSum(PointAlt, deckValue[randInt][1]);
                                }
                                CardsAreAvailable = true;
                            }
                        }
                        while (CardsAreAvailable == false);

                    }
                    //If you answer no, you will stay on the amount you are on
                    else if (Card.equals("nej")) {
                        System.out.println("Spelare stannade på " + CounterValue[1][0]);
                        Answer = false;
                    }

                }
            }
            while (Answer == true);

            // Prints the dealer's dark cards
            System.out.println("Dealerns mörka kort är " + deckName[DarkCard]);


            //Prints the sum of the dealer's cards
            if (PointAltD != CounterValue[0][0]){
                System.out.println("Dealer har " + CounterValue[0][0] + " eller " + PointAltD);
            }
            else {
                System.out.println("Dealer har " + CounterValue[0][0]);
            }

            //Check if the dealer is over 21 and print out what it got
            do {
                Answer = true;

                if (CounterValue[0][0] > 21){

                    //
                    if (PointAltD > 21){
                        System.out.println("Dealer fick " + CounterValue[0][0]);
                        System.out.println("Dealer fick över 21 och är nu tjock!");
                        Answer = false;
                    }
                    else {
                        CounterValue[0][0] = PointAltD;
                    }

                }

                //Check if the dealer ends up over 17, if it does not, that dealer randomly gets a new card until it ends up over 17
                else if (CounterValue[0][0] <= 21){

                    if (CounterValue[0][0] < 17) {

                        do {
                            CardsAreAvailable = false;
                            if (deckValue[randInt][0] == 0){
                                randInt = randGenerator.nextInt (52);
                            }
                            else if (deckValue[randInt][0] == 1){
                                deckValue[randInt][0] = 0;
                                System.out.print("                ");
                                System.out.println(deckName[randInt]);
                                if (deckValue[randInt][1] == 11){
                                    CounterValue[0][0] = Counter.getSum(CounterValue[0][0], deckValue[randInt][1]);
                                    PointAltD = Counter.getSum(PointAltD, 1);
                                }
                                else {
                                    CounterValue[0][0] = Counter.getSum(CounterValue[0][0], deckValue[randInt][1]);
                                    PointAltD = Counter.getSum(PointAltD, deckValue[randInt][1]);
                                }
                                System.out.println("Dealer har " + CounterValue[0][0]);
                                CardsAreAvailable = true;
                            }
                        }
                        while (CardsAreAvailable == false);
                    }
                    //If the dealer has over 17, it stops
                    else if (CounterValue[0][0] >= 17){
                        System.out.println("Dealer stannade på " + CounterValue[0][0]);
                        Answer = false;
                    }
                }
            }
            while (Answer == true);

            //Check if the player and the dealer got the same number of points
            if (CounterValue[1][0] == CounterValue[0][0]){
                System.out.println("Det blev lika!");
            }

            //Check if the player and dealer got over 21
            if (CounterValue[1][0] > CounterValue[0][0]){
                if (CounterValue[1][0] > 21){
                    if (CounterValue[0][0] > 21){
                        System.out.println("Båda blev tjocka, det blev lika!");
                    }
                    else if (CounterValue[0][0] <= 21){
                        System.out.println("Dealer vann!");
                        CounterValue[1][1] = CounterValue[1][1] - Money;
                    }
                }
                else if (CounterValue[1][0] <= 21){
                    System.out.println("Spelare vann!");
                    CounterValue[1][1] = CounterValue[1][1] + Money;
                }
            }
            //Check if the player and dealer got over 21
            else if (CounterValue[1][0] < CounterValue[0][0]){
                if (CounterValue[0][0] > 21){
                    if (CounterValue[1][0] > 21){
                        System.out.println("Båda blev tjocka, det blev lika!");
                    }
                    else if (CounterValue[1][0] <= 21){
                        System.out.println("Spelare vann!!");
                        CounterValue[1][1] = CounterValue[1][1] + Money;
                    }
                }
                else if (CounterValue[0][0] <= 21){
                    System.out.println("Dealer vann!");
                    CounterValue[1][1] = CounterValue[1][1] - Money;
                }
            }

            //Another test
            System.out.println("");
            System.out.println("*************Test Case*************");
            mainTest.test(deckValue);
            System.out.println("*************Test Case*************");
            System.out.println("");

            //Prints your balance
            if (CounterValue[1][1] > 0){
                System.out.println("Ditt saldo är " + CounterValue[1][1]);
                System.out.print("Vill du spela igen?");
                PlayAgain = scan.nextLine();

                if (PlayAgain.equals("ja")) {
                    Answer = true;

                }

            }
            //Prints this if the player runs out of money
            else if (CounterValue[1][1] <= 0){
                System.out.println("Du har slut på pengar, GAME OVER!");
                Answer = false;
            }
        }
        while (Answer == true);

    }
}

