import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class DES{
    static String ALGORITHM = "DES";
    static String to_encript(String plain, String key) throws Exception{
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher =  Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return Base64.getEncoder().encodeToString(cipher.doFinal(plain.getBytes()));
    }

    static String to_decript(String cipher, String key) throws Exception{
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher decipher =  Cipher.getInstance(ALGORITHM);
        decipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decypher_bytes = decipher.doFinal(Base64.getDecoder().decode(cipher));
        return new String(decypher_bytes);
    }

    public static void main(String[] args){
        String plain = "god will help you";
        String key = "01234567";
        String ciphertext = "";
        String deciphertext = "";
        try{
            ciphertext = to_encript(plain, key);
            deciphertext = to_decript(ciphertext, key);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(ciphertext);
        System.out.println(deciphertext);
    }
}