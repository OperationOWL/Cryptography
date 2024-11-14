class Ceaser{
    
    static String to_cypher(String plain, int key){
        String cypher = "";
        for(char i: plain.toCharArray()){
            if(Character.isUpperCase(i)){
                cypher += Character.toString((i-'A'+key)%26 + 'A');
            }
            else if(Character.isLowerCase(i)){
                cypher += Character.toString((i-'a'+key)%26 + 'a');
            }
            else{
                cypher += i;
            }
        }
        
        return cypher;
    }
    
    public static void main(String[] args){
        String plain = "God Will Help You";
        int key = 5;
        String cypher = to_cypher(plain, key);
        System.out.println(cypher);
    }
}