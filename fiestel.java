import java.util.*;

public class fiestel{
    
    static String xor(char right, String key){
        return Integer.toBinaryString((right) ^ Integer.parseInt(key, 2));
    }
    
    static char rcs(String bytes){
        return (char)(Integer.parseInt(bytes.substring(bytes.length()-1, bytes.length()) + bytes.substring(0, bytes.length()-1), 2));
    }
    
    static String to_cypher(String plain, String key){
        String cypher = "";
        char left = plain.charAt(0);
        char right = plain.charAt(1);
        
        char temp = left;
        left = right;
        right = (char)(Integer.parseInt(xor(rcs(xor(right, key)), Integer.toBinaryString(temp)), 2));
        cypher = Character.toString(left) + Character.toString(right);
        return cypher;
    }
    
    static String to_decypher(String plain, String key){
        String cypher = "";
        char right = plain.charAt(0);
        char left = plain.charAt(1);
        char temp = left;
        left = right;
        right = (char)(Integer.parseInt(xor(rcs(xor(right, key)), Integer.toBinaryString(temp)), 2));
        cypher = Character.toString(right) + Character.toString(left);
        return cypher;
    }

    public static void main(String[] args){
        String plain = "AB";
        String cypher = to_cypher(plain, "01001001");
        System.out.println(cypher);
        String decypher = to_decypher(cypher, "01001001");
        System.out.println(decypher);
    }
}