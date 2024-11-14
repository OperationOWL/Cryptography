import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class AES_DES{

    static String ALGORITHM = "AES";
    public static void main(String[] args){
        String plain = "hello";
        String key = "0123456789012345"; //16 letter key, 8 letter key for DES
        String encryption = "";
        String decryption = "";
        try{
            encryption = encrypt(plain, key);
            decryption = decrypt(encryption, key);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("encrypted: " + encryption);
        System.out.println("decrypted: " + decryption);
    }

    static String encrypt(String plain, String key) throws Exception{
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plain.getBytes()));
    }

    static String decrypt(String plain, String key) throws Exception{
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(plain)));
    }
}