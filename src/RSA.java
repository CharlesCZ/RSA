import java.math.BigInteger;



public class RSA {

    private long p,q;
    private long N,fi;
    private long e;
    private long d;
    private char[] M;
    private long[] C;
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

        C=new long[M.length];


        for(int i=0;i<message.length();++i) {


            BigInteger integerCtemp=new BigInteger(Integer.toString(M[i]));
            C[i] = integerCtemp.modPow(new BigInteger(Long.toString(e)),new BigInteger(Long.toString(N))).longValue();
        }
    }

    public String decripion(){

        char[] temp=new char[C.length];
        for(int i=0;i<C.length;++i) {
            BigInteger integerCtemp=new BigInteger(Long.toString(C[i]));
            temp[i] = (char) integerCtemp.modPow(new BigInteger(Long.toString(d)),new BigInteger(Long.toString(N))).intValue();
        }

        return new String(temp);
    }

}
