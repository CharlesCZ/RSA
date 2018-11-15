import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args){




        RSA rsa=new RSA();
        rsa.setN(7741,7727);
     //  rsa.setN(19,	31);
        rsa.setE(7);
        rsa.encripion("wiadomosc");
        System.out.println(rsa.decripion());


    }
}
