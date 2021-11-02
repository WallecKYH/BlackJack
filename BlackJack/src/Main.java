import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        BlackJackGame mygame = new BlackJackGame();

        //Skapar variabler
        int [][] deckValue = new int[52][2];
        String [] deckName = new String[52];
        boolean svar;
        String kort;
        boolean kortFinns = false;
        int DarkCard;
        int Pengar;
        String SpelaIgen;
        int [][] CounterValue = new int[2][2];
        CounterValue[1][1] = 100;
        int PointAlt;
        int PointAltD;

        //Skapar Scanners
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);


        Random randGenerator = new Random();
        int randInt = randGenerator.nextInt (52);

        do {
            //Skriver ut test casen
            System.out.println();
            System.out.println("*************Test Case*************");
            mainTest.test(deckValue);
            svar = false;
            BlackJackGame.DeckFyll(deckValue);
            BlackJackGame.Namn(deckName);
            mainTest.test(deckValue);
            mainTest.TestValue(deckValue);
            mainTest.TestName(deckName);
            mainTest.TestPoint(CounterValue);
            mainTest.TestSaldo(CounterValue);
            System.out.println("*************Test Case*************");
            System.out.println();
            mygame.initializeGame();
            CounterValue[0][0] = 0;
            CounterValue[1][0] = 0;
            PointAlt = 0;
            PointAltD = 0;
            DarkCard = 0;

            System.out.println("Ditt saldo är " + CounterValue[1][1]);
            System.out.print("Hur mycket vill du satsa?");
            Pengar = scan2.nextInt();

            System.out.print("SPELARE");
            System.out.print("              ");
            System.out.println("DEALER");

            //Slump av spelarens första kort
            do {
                if (deckValue[randInt][0] == 0){
                    randInt = randGenerator.nextInt (52);
                    kortFinns = false;
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
                    kortFinns = true;
                }
            }
            while (kortFinns == false);

            //Slump av dealerns första kort
            do {
                kortFinns = false;
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
                    kortFinns = true;
                }
            }
            while (kortFinns == false);

            //Slump av spelarens andra kort
            do {
                kortFinns = false;
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
                    kortFinns = true;
                }
            }
            while (kortFinns == false);

            //Slump av dealerns andra kort (Det mörka kortet)
            do {
                kortFinns = false;
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
                    kortFinns = true;
                }
            }
            while (kortFinns == false);

            //Räknar ihop summan av spelarens kort
            do {
                svar = true;

                if (PointAlt != CounterValue[1][0]){
                    System.out.println("Spelare har " + CounterValue[1][0] + " eller " + PointAlt);
                }
                else {
                    System.out.println("Spelare har " + CounterValue[1][0]);
                }

                //Kollar om spelaren fick över 21
                if (CounterValue[1][0] > 21){

                    if (PointAlt > 21){
                        System.out.println("Spelare fick över 21 och är nu tjock!");
                        svar = false;
                    }
                    else {
                        CounterValue[1][0] = PointAlt;
                    }

                }

                //Ger dig valet om du vill ha fler kort eller inte
                else if (CounterValue[1][0] < 21){
                    System.out.print("Vill du ha fler kort?");
                    kort = scan.nextLine();

                    if (kort.equals("ja")) {
                        svar = true;

                        //Om du svarar ja så får du ett kort till
                        do {
                            kortFinns = false;
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
                                kortFinns = true;
                            }
                        }
                        while (kortFinns == false);

                    }
                    //Svarar du nej så stannar du på den summan du är på
                    else if (kort.equals("nej")) {
                        System.out.println("Spelare stannade på " + CounterValue[1][0]);
                        svar = false;
                    }

                }
            }
            while (svar == true);

            // Skriver ut dealerns mörka kort
            System.out.println("Dealerns mörka kort är " + deckName[DarkCard]);

            //Skriver ut summan av dealerns kort
            if (PointAltD != CounterValue[0][0]){
                System.out.println("Dealer har " + CounterValue[0][0] + " eller " + PointAltD);
            }
            else {
                System.out.println("Dealer har " + CounterValue[0][0]);
            }

            //Kollar om dealern har över 21 och skriver ut vad den fick
            do {
                svar = true;

                if (CounterValue[0][0] > 21){

                    if (PointAltD > 21){
                        System.out.println("Dealer fick " + CounterValue[0][0]);
                        System.out.println("Dealer fick över 21 och är nu tjock!");
                        svar = false;
                    }
                    else {
                        CounterValue[0][0] = PointAltD;
                    }

                }

                //Kollar om dealern hamnar över 17, om den inte är det så slumpar den dealerns tredje kort,
                else if (CounterValue[0][0] <= 21){

                    if (CounterValue[0][0] < 17) {

                        do {
                            kortFinns = false;
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
                                kortFinns = true;
                            }
                        }
                        while (kortFinns == false);
                    }
                    //Om dealern har över 17 så stannar den
                    else if (CounterValue[0][0] >= 17){
                        System.out.println("Dealer stannade på " + CounterValue[0][0]);
                        svar = false;
                    }
                }
            }
            while (svar == true);

            //Ett till test
            System.out.println("");
            System.out.println("*************Test Case*************");
            mainTest.test(deckValue);
            System.out.println("*************Test Case*************");
            System.out.println("");

            //Kollar om spelaren och dealern fick lika mycket poäng
            if (CounterValue[1][0] == CounterValue[0][0]){
                System.out.println("Det blev lika!");
            }

            //Kollar om spelaren och dealern fick över 21
            if (CounterValue[1][0] > CounterValue[0][0]){
                if (CounterValue[1][0] > 21){
                    if (CounterValue[0][0] > 21){
                        System.out.println("Båda blev tjocka, det blev lika!");
                    }
                    else if (CounterValue[0][0] <= 21){
                        System.out.println("Dealer vann!");
                        CounterValue[1][1] = CounterValue[1][1] - Pengar;
                    }
                }
                else if (CounterValue[1][0] <= 21){
                    System.out.println("Spelare vann!");
                    CounterValue[1][1] = CounterValue[1][1] + Pengar;
                }
            }
            //Kollar om spelaren och dealern fick över 21
            else if (CounterValue[1][0] < CounterValue[0][0]){
                if (CounterValue[0][0] > 21){
                    if (CounterValue[1][0] > 21){
                        System.out.println("Båda blev tjocka, det blev lika!");
                    }
                    else if (CounterValue[1][0] <= 21){
                        System.out.println("Spelare vann!!");
                        CounterValue[1][1] = CounterValue[1][1] + Pengar;
                    }
                }
                else if (CounterValue[0][0] <= 21){
                    System.out.println("Dealer vann!");
                    CounterValue[1][1] = CounterValue[1][1] - Pengar;
                }
            }

            //Skriver ut ditt saldo
            if (CounterValue[1][1] > 0){
                System.out.println("Ditt saldo är " + CounterValue[1][1]);
                System.out.print("Vill du spela igen?");
                SpelaIgen = scan.nextLine();

                if (SpelaIgen.equals("ja")) {
                    svar = true;

                }

            }

            else if (CounterValue[1][1] <= 0){
                System.out.println("Du har slut på pengar, GAME OVER!");
                svar = false;
            }
        }
        while (svar == true);

    }
}

