import java.util.HashMap;
import java.util.Map;

public class StringOperations {

    public static void main(String[] args) {

        printRepetitives("Hello world!", "Tuncay");

    }

    /*
    * Search a string's characters in a bigger string text.
    * Then prints the count of repetation for each character.
    */
    public static void printRepetitives(String first, String second){
        String bigger = (first.length() > second.length()) ? first : second;
        String smaller = (first.length() > second.length()) ? second : first;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < smaller.length(); i++){
            map.put(String.valueOf(smaller.charAt(i)),0);
        }

        for (int i = 0; i < bigger.length(); i++) {
            try {
                if(map.get(String.valueOf(bigger.charAt(i))) >= 0){
                    map.put(String.valueOf(bigger.charAt(i)), map.get(String.valueOf(bigger.charAt(i)))+1);
                }
            } catch (Exception e) {
                //System.out.println("NullPointer!");
            }
        }

        map.forEach((key,value) -> System.out.println(key + " => " + value));
    }
}
