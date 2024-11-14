import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

class AES {
    private static final String ALGORITHM = "AES";
    private static final String key = "ThisIsASecretKey";

    static String to_cipher(String plain, String key) throws Exception {
        SecretKeySpec secretkey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);
        byte[] cipherBytes = cipher.doFinal(plain.getBytes()); // Specify character encoding
        return Base64.getEncoder().encodeToString(cipherBytes);
    }

    static String to_decipher(String cipherText, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText)); // Decode Base64
        return new String(decryptedBytes); // Specify character encoding
    }

    public static void main(String[] args) {
        String plain = "hello world";

        try {
            String cipher = to_cipher(plain, key);
            System.out.println("Cipher: " + cipher);

            String decipher = to_decipher(cipher, key);
            System.out.println("Decipher: " + decipher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
