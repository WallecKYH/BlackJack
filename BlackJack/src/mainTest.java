import org.junit.Test;

public class mainTest {

    @Test
    public static void test(int e[][]) {

        System.out.println("Test av vilka kort som är använda!");
        for (int i = 0; i < 52; i++) {
            System.out.print(e[i][0]);
        }
        System.out.println("");
    }

    @Test
    public static void TestValue(int b[][]) {

        System.out.println("Test av vilka kortvärden som finns!");
        for (int i = 0; i < 52; i++) {
            System.out.print(b[i][1]);
        }
        System.out.println("");
    }

    @Test
    public static void TestName(String c[]) {

        System.out.println("Test av vilka kortnamn som finns!");
        for (int i = 0; i < 52; i++) {
            System.out.print(c[i] + " / ");
        }
        System.out.println("");
    }
    @Test
    public static void TestPoint(int f[][]) {

        System.out.println("Test av poäng!");
        for (int i = 0; i < 2; i++) {
            System.out.print(f[i][0]);
        }
        System.out.println("");
    }

    @Test
    public static void TestSaldo(int d[][]) {

        System.out.println("Test av saldo!");
        for (int i = 0; i < 2; i++) {
            System.out.print(d[i][1]);
        }
        System.out.println("");
    }

}