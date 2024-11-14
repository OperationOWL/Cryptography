import java.util.*;
 
class RSA {
    static long e_calc(long phi, long n){
        long e = 0;
        for(int i = 2; i<phi; i++){
            if(phi%i != 1 && n%i != 1){
                e = i;
            }
        }
        System.out.println(e);
        return e;
    }
    public static void main(String[] args){
        long p = 2, q = 7;
        long n = p*q
        long phi = (p-1)*(q-1);
        long e = e;

        String plain = 'B';
        String cipher = (Math.pow(plain-'A', e)%n)%26;
        System.out.println(cipher);
    }
}