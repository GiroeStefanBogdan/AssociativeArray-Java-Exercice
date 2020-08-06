package AssociativeArrayPackage_Exercice;

//Description
//You are given a sequence of strings, each on a new line until the command "stop".
//Every odd line on the console is representing a resource (e.g. Gold, Silver, Copper, and so on).
//And every even - quantity.
//Your task is to collect the resources and print them each on a new line.
//Print the resources and their quantities in format:
//{resource} -> {quantity}

//Example
//Input                             Output
//Gold                              Gold -> 155
//155                               Silver -> 10
//Silver                            Gold -> 17
//10
//Copper
//17
//stop


//Example
//Input                             Output
//gold                              Gold -> 170
//155                               Silver -> 10
//silver                            Gold -> 17
//10
//copper
//17
//gold
//15
//stop

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new HashMap<>();

        String resourcesLine = "";

        while(!resourcesLine.equals("stop") ){
            resourcesLine = scanner.nextLine();
            if(resourcesLine.equals("stop")){
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());
            if(!resources.containsKey(resourcesLine)){
                resources.put(resourcesLine, quantity);
            }else{
                resources.put(resourcesLine,resources.get(resourcesLine) + quantity );
            }



        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }


    }
}
