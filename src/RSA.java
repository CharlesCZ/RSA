import java.math.BigDecimal;

import static java.lang.Math.pow;

public class RSA {

    private long p,q;
    private long N,fi;
    private long e;
    private long d;
    private char[] M;
    private int[] C;
    public long getN() {
        return N;
    }

    public void setN(long p,long q) {
        this.p=p;
        this.q=q;
        N = p*q;
        setFi();
    }

    public void setFi() {
        this.fi = (p-1)*(q-1);
    }

    public long getFi() {
        return fi;
    }

    public long getE() {
        return e;
    }

    public void setE(long e) {
       try {
           if(NWD.nwd(e, fi)!=1)
               throw new IllegalArgumentException("NWD powinno byc 1"+NWD.nwd(e, fi));
       } catch (IllegalArgumentException ex){

           System.out.println(ex.getMessage());
       }
        this.e = e;

       d=NWD.odwr_modulo(e,fi);
    }

    public void encripion(String message){
        M=new char[message.length()];
        for(int i=0;i<message.length();++i)
            M[i]=message.charAt(i);

        C=new int[M.length];

        for(int i=0;i<message.length();++i) {
            BigDecimal decimalCtemp=new BigDecimal(M[i]);
            C[i] = decimalCtemp.pow((int) e).remainder(new BigDecimal(N)).intValue();

        }
    }

    public String decripion(){

        char[] temp=new char[C.length];
        for(int i=0;i<C.length;++i) {
            BigDecimal decimalCtemp=new BigDecimal(C[i]);
            temp[i] = (char) decimalCtemp.pow((int) d).remainder(new BigDecimal(N)).intValue();


        }

        return new String(temp);
    }





}
