public class Main{
    
    static char[] multiply(char[][] key, char[] text){
        char[] cypher = new char[key.length];
        int sum = 0;
        for(int i = 0; i<key.length; i++){
            sum = 0;
            for(int j = 0; j<key.length; j++){
                sum += key[i][j] * (text[j]-'A');
            }
            cypher[i] = (char)(sum%26 + 'A');
        }
        return cypher;
    }
    
    static String to_cypher(char[][] key, String plain){
        int times = plain.length()/key.length;
        String cypher = "";
        char[] temp_cypher = new char[key.length];
        
        for(int i = 0; i<times; i++){
            for(int j = 0; j<key.length; j++){
                temp_cypher[j] = plain.charAt(i*key.length + j);
            }
            multiply(key, temp_cypher);
            for(char ch: multiply(key, temp_cypher)){
                cypher += Character.toString(ch);
            }
        }
        
        return cypher;
    }
    
    public static void main(String[] args){
        char[][] key = {{6, 24, 1},{13, 16, 10}, {20, 17, 15}};
        String plain = "ACTGFG";
        String cypher = to_cypher(key, plain);
        System.out.println(cypher);
    }
}