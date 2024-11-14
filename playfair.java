import java.util.*;


class Playfair{

    static char[][] create_matrix(String key, String plain){
        String matrix_string = key;
        char[][] matrix = new char[5][5];
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char ignore = 'J';
        if(plain.contains("J")){
            ignore = 'I';
        }
        for(char ch: alph.toCharArray()){
            if(ch != ignore && !key.contains(Character.toString(ch))){
                matrix_string += ch;
            }
        }
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                matrix[i][j] = matrix_string.charAt(i*5 + j);
            }
        }

        return matrix;
    }
    
    static String to_decypher(String plain, char[][] matrix){
        String cypher = "";
        for(int i = 0; i<plain.length(); i+=2){
            cypher += unchange(plain.charAt(i), plain.charAt(i + 1), matrix);
        }
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        return cypher;
    }
    
    static String unchange(char a, char b, char[][] matrix){
        int a_x = 0; int a_y = 0;
        int b_x = 0; int b_y = 0;
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(matrix[i][j] == a){
                    a_x = j;
                    a_y = i;
                }
                if(matrix[i][j] == b){
                    b_x = j;
                    b_y = i;
                }
            }
        }
        
        if(a_x != b_x && a_y != b_y){
            int temp;
            temp = a_x;
            a_x = b_x;
            b_x = temp;
        }
        if(a_y == b_y && a_x != b_x){
            a_x = (a_x-1)%5;
            b_x = (b_x-1)%5;
        }
        if(a_x == b_x && a_y != b_y){
            a_y = (a_y-1)%5;
            b_y = (b_y-1)%5;
        }
        else if(a_x == b_x && a_y == b_y){
            a_x = (a_x-1)%5;
            b_x = (b_x-1)%5;
        }
        return Character.toString(matrix[a_y][a_x]) + Character.toString(matrix[b_y][b_x]);
    }
    
    static String to_cypher(String plain, char[][] matrix){
        String cypher = "";
        for(int i = 0; i<plain.length(); i+=2){
            cypher += change(plain.charAt(i), plain.charAt(i + 1), matrix);
        }
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        return cypher;
    }
    
    static String change(char a, char b, char[][] matrix){
        int a_x = 0; int a_y = 0;
        int b_x = 0; int b_y = 0;
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(matrix[i][j] == a){
                    a_x = j;
                    a_y = i;
                }
                if(matrix[i][j] == b){
                    b_x = j;
                    b_y = i;
                }
            }
        }
        
        if(a_x != b_x && a_y != b_y){
            int temp;
            temp = a_x;
            a_x = b_x;
            b_x = temp;
        }
        if(a_y == b_y && a_x != b_x){
            a_x = (a_x+1)%5;
            b_x = (b_x+1)%5;
        }
        if(a_x == b_x && a_y != b_y){
            a_y = (a_y+1)%5;
            b_y = (b_y+1)%5;
        }
        else if(a_x == b_x && a_y == b_y){
            a_x = (a_x+1)%5;
            b_x = (b_x+1)%5;
        }
        return Character.toString(matrix[a_y][a_x]) + Character.toString(matrix[b_y][b_x]);
    }

    public static void main(String[] args){
        String plain = "GodWillHelpYou";
        plain = plain.toUpperCase();
        String key = "word";
        key = key.toUpperCase();
        char[][] matrix = create_matrix(key, plain);
        String cypher = to_cypher(plain, matrix);
        System.out.println(cypher);
        String decypher = to_decypher(cypher, matrix);
        System.out.println(decypher);
    }
}