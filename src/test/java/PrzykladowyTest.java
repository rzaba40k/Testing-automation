import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrzykladowyTest {
    //zadanie1
    @Test
    void printHello() {
        System.out.println("hello");
    }

    //zadanie2
    @Test
    void isEqual() {
        int a = 10;
        Assertions.assertEquals(a, a);
    }

    //zadanie3
    @Test
    void isEqualTrue() {
        boolean a = true;
        Assertions.assertTrue(a == true);
    }

    //zadanie4
    @Test
    void stringsEqual() {
        String a = "1234";
        String b = "1234";
        Assertions.assertTrue(a.equals(b));
    }
    //zadanie5
    @Test
    void isStringUpperCase(){
        String a = "duzelitery";
        Assertions.assertEquals(a.toUpperCase(),"DUZELITERY");
    }
    //zadanie6
    static int dodawanie (int a, int b){
        return a + b;
    }
    @Test
    void isSumaWorking (){
        Assertions.assertEquals(10, dodawanie(5,6), "Incorrect result" );
    }
    //zadanie7
    static double polekola(int r){
        double R = r*r;
        return R * 3.14;
    }
    @Test
    void isPoleKolaCorrect(){
        Assertions.assertEquals(polekola(3),(3*3*3.14));
        System.out.println(polekola(3));
    }
    //zadanie8
    static String removeSpaces(String s){
        String s1 = s.trim();
        return s1.toUpperCase();
    }
    @Test
    void isStringTrimUpperCaseWorks(){
        Assertions.assertEquals("TEST",removeSpaces("  test  "));
        System.out.println(removeSpaces("  test  "));
    }

}

