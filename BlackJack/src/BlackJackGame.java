public class BlackJackGame {

    //Skriver ut spelregler
    public void initializeGame(){
        System.out.println("");
        System.out.println("     Hej och välkommen till blackjack!");
        System.out.println("");
        System.out.println("     BLACKJACK Regler: ");
        System.out.println("    -Varje spelare får 2 kort. Dealern får 2 kort, ett med framsidan upp och ett med framsidan nedåt.");
        System.out.println("	-Kort är lika med deras värde, kort med ansikte är 10 och ett ess är 1 eller 11.");
        System.out.println("    -Spelarkorten läggs ihop för sin totala summa.");
        System.out.println("    -Målet är att ha en högre kortsumma än dealern utan att gå över 21.");
        System.out.println("");
        System.out.println("");
    }

    //Skapar Kortnamn, Arrayen deckName skickas upp tom och returneras med kortnamn
    public static String[] Namn(String[] d) {

        d[0] = "HJärter Ess";
        d[1] = "HJärter 2";
        d[2] = "HJärter 3";
        d[3] = "HJärter 4";
        d[4] = "HJärter 5";
        d[5] = "HJärter 6";
        d[6] = "HJärter 7";
        d[7] = "HJärter 8";
        d[8] = "HJärter 9";
        d[9] = "HJärter 10";
        d[10] = "HJärter Knekt";
        d[11] = "HJärter Dam";
        d[12] = "HJärter Kung";

        d[13] = "Spader Ess";
        d[14] = "Spader 2";
        d[15] = "Spader 3";
        d[16] = "Spader 4";
        d[17] = "Spader 5";
        d[18] = "Spader 6";
        d[19] = "Spader 7";
        d[20] = "Spader 8";
        d[21] = "Spader 9";
        d[22] = "Spader 10";
        d[23] = "Spader Knekt";
        d[24] = "Spader Dam";
        d[25] = "Spader Kung";

        d[26] = "Ruter Ess";
        d[27] = "Ruter 2";
        d[28] = "Ruter 3";
        d[29] = "Ruter 4";
        d[30] = "Ruter 5";
        d[31] = "Ruter 6";
        d[32] = "Ruter 7";
        d[33] = "Ruter 8";
        d[34] = "Ruter 9";
        d[35] = "Ruter 10";
        d[36] = "Ruter Knekt";
        d[37] = "Ruter Dam";
        d[38] = "Ruter Kung";

        d[39] = "Klöver Ess";
        d[40] = "Klöver 2";
        d[41] = "Klöver 3";
        d[42] = "Klöver 4";
        d[43] = "Klöver 5";
        d[44] = "Klöver 6";
        d[45] = "Klöver 7";
        d[46] = "Klöver 8";
        d[47] = "Klöver 9";
        d[48] = "Klöver 10";
        d[49] = "Klöver Knekt";
        d[50] = "Klöver Dam";
        d[51] = "Klöver Kung";
        return d;
    }

    //Skapar Kortlek och gör den klar med ettor (kort finns) och kortvärden, Arrayen deckValue skickas upp tom och returneras färdig
    public static int[][] DeckFyll(int c[][]) {

        //Skapar ettor
        for (int i = 0; i < 52; i++) {
            c[i][0]=1;
        }

        //Skapar kortvärdena
        for (int i = 0; i < 4; i++) {
            c[13*i+0][1] = 11;
            c[13*i + 1][1] = 2;
            c[13*i + 2][1] = 3;
            c[13*i + 3][1] = 4;
            c[13*i + 4][1] = 5;
            c[13*i + 5][1] = 6;
            c[13*i + 6][1] = 7;
            c[13*i + 7][1] = 8;
            c[13*i + 8][1] = 9;
            c[13*i + 9][1] = 10;
            c[13*i + 10][1] = 10;
            c[13*i + 11][1] = 10;
            c[13*i + 12][1] = 10;
        }
        return c;
    }
}