import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args){




        RSA rsa=new RSA();
        rsa.setN(31,19);
        rsa.setE(7);
        rsa.encripion("wiadomosc");
        System.out.println(rsa.decripion());


    }
}
