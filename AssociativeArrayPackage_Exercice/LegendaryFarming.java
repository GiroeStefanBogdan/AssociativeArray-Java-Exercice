package AssociativeArrayPackage_Exercice;

//Description
//Your task is to obtain a legendary item, which requires collecting materials.
//The possible items are:
//Shadowmourne - requires 250 Shards;
//Valanyr - requires 250 Fragments;
//Dragonwrath - requires 250 Motes;
//Shards, Fragments and Motes are the key materials, everything else is junk.
//Keep track of the key materials - the first that reaches the 250 mark wins the race.
//At that point, print the corresponding legendary item obtained.
//Then, print the remaining shards, fragments, motes, ordered by quantity in descending order, then by name in ascending order, each on a new line.
//Finally, print the collected junk items, in alphabetical order.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//Input
//Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}
//Output
//On the first line, print the obtained item in format "{Legendary item} obtained!"
//On the next three lines, print the remaining key materials in descending order by quantity
//If two key materials have the same quantity, print them in alphabetical order
//On the final several lines, print the junk items in alphabetical order
//All materials are printed in format: "{material}: {quantity}"
//All output should be lowercase, except the first letter of the legendary
//
//Examples
//Input                                             	Output
//3 Motes 5 stones 5 Shards                             Valanyr obtained!
//6 leathers 255 fragments 7 Shards                     fragments: 5
//                                                      shards: 5
//                                                      motes: 3
//                                                      leathers: 6
//                                                      stones: 5
//
//Examples
//Input                                             	Output
//123 silver 6 shards 8 shards 5 motes                  Dragonwrath obtained!
//9 fangs 75 motes 103 MOTES 8 Shards                   shards: 22
//86 Motes 7 stones 19 silver                           motes: 19
//                                                      fragments: 0
//                                                      fangs: 9
//                                                      silver: 123
//
//
public class LegendaryFarming {

    public static void main(String[] args) {

        Scanner  scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean itemIsObteined = false;

        Map<String, Integer> regants = new HashMap<>();
        Map<String, Integer> trash = new TreeMap<>();

        regants.put("shards", 0);
        regants.put("fragments", 0);
        regants.put("motes", 0);

        while(!itemIsObteined){
            String[] loot = input.split("\\s+");
            for (int i = 0; i <=loot.length-1; i+=2) {
                int quantity = Integer.parseInt(loot[i]);
                String regant = loot[i+1].toLowerCase();

                if(regant.equals("shards") || regant.equals("fragments") || regant.equals("motes")){
                    regants.put(regant, regants.get(regant) + quantity);
                }else{
                    if(!trash.containsKey(regant)){
                        trash.put(regant, quantity);
                    }else{
                        trash.put(regant, trash.get(regant) + quantity);
                    }
                }

                if(regants.containsKey("motes") && regants.get("motes") >=250){
                    regants.put("motes", regants.get("motes")-250);
                    System.out.println("Dragonwrath obtained!");
                    itemIsObteined = true;
                    break;
                }else if(regants.containsKey("fragments") && regants.get("fragments") >=250){
                    regants.put("fragments", regants.get("fragments") - 250);
                    System.out.println("Valanyr obtained!");
                    itemIsObteined = true;
                    break;
                }else if(regants.containsKey("shards") && regants.get("shards") >=250){
                    regants.put("shards", regants.get("shards") -250);
                    System.out.println("Shadowmourne obtained!");
                    itemIsObteined = true;
                    break;
                }
            }
            if(!itemIsObteined){
                input = scanner.nextLine();
            }

        }
        regants
                .entrySet()
                .stream()
                .sorted((a,b) ->{
                    if(b.getValue() - a.getValue()==0){
                        return a.getKey().compareTo(b.getKey());
                    }else{
                        return b.getValue().compareTo(a.getValue());
                    }
                })
                .forEach((entry) ->{
                    System.out.printf("%s: %d%n",entry.getKey(), entry.getValue());
                });

        trash
                .entrySet()
                .stream()
                .sorted((a,b) -> a.getKey().compareTo(b.getKey()))
                .forEach((entry) ->{
                    System.out.printf("%s: %d%n",entry.getKey(), entry.getValue());
                });
    }
}
