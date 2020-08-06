package AssociativeArrayPackage_Exercice;

import java.util.*;

//Description
//Write a program which counts all characters in a string except space (' ').
//
//Print all occurrences in the following format:
//
//{char} -> {occurrences}
//
//Example
//Input	                                    Output
//text                                      t -> 2
//                                          e -> 1
//                                          x -> 1
//
//Example
//Input	                                    Output
//text text text                            t -> 6
//                                          e -> 3
//                                          x -> 3
//
//
public class CountCharsInAString {

    public static void main(String[] args) {

        Scanner  scanner =  new Scanner(System.in);
        String[] words =scanner.nextLine().split("\\s+");
        Map<Character, Integer> pairs = new LinkedHashMap<>();

        for (String word : words) {
            for (char symbol: word.toCharArray()) {
                if(!pairs.containsKey(symbol)){
                    pairs.put(symbol, 0);
                }

                pairs.put(symbol, pairs.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : pairs.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(),entry.getValue());
        }


    }
}
