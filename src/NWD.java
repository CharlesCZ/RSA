public class NWD {

    public static long nwd(long a,long b){

        long naj=1;
        if(a>b)
            for(int i=2;i<a;++i)
            {
                if(a%i==0 && b%i==0)
                    naj=i;
            }
        else
            for(int i=2;i<b;++i)
            {
                if(a%i==0 && b%i==0)
                    naj=i;
            }

        // System.out.println(naj);
        return naj;
    }

    //  return array [d, a, b] such that d = gcd(p, q), ap + bq = d
    static int[] gcd(int p, int q) {
        if (q == 0)
            return new int[] { p, 1, 0 };

        int[] vals = gcd(q, p % q);
        int d = vals[0];
        int a = vals[2];
        int b = vals[1] - (p / q) * vals[2];
        return new int[] { d, a, b };
    }



    // a	 –  	liczba, której odwrotność modulo obliczamy,
   static long odwr_modulo(long a, long b) {
        long u, w, x, z, q;


        u = 1;
        w = a;
        x = 0;
        z = b;
        while (w>0) {
            if (w < z) {
                q = u;
                u = x;
                x = q;
                q = w;
                w = z;
                z = q;
            }
            q = w / z;
            u -= q * x;
            w -= q * z;
        }
        if (z == 1) {
            if (x < 0) x += b;
            return x;
        } else throw new RuntimeException("Brak odwortnej");



    }
}