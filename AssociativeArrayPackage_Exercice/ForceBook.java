package AssociativeArrayPackage_Exercice;
//Description
//The force users are struggling to remember which side are the different force users from, because they switch them too often.
//So you are tasked to create a program to manage their profiles.
//You should store information for every unique force user, registered in the application.
//You will receive several input lines in one of the following formats:
//{forceSide} | {forceUser}
//{forceUser} -> {forceSide}
//The force user and force side are strings, containing any character.
//If you receive force side | force user you should check if such force user already exists, and if not, add him/her to the corresponding side.
//If you receive a force user -> force side you should check if there is such force user already and if so, change his/her side.
//If there is no such force user, add him/her to the corresponding force side, treating the command as new registered force user.
//Then you should print on the console:
//"{forceUser} joins the {forceSide} side!"
//You should end your program when you receive the command "End".
//At that point you should print each force side, ordered descending by force users count, than ordered by name.
//For each side print the force users, ordered by name.
//In case there are no force users in a side, you shouldn't print the side information.
//Input
//The input comes in the form of commands in one of the formats specified above.
//The input ends when you receive the command "End".
//Output
//As output for each force side, ordered descending by force users count, then by name, you must print all the force users, ordered by name alphabetically.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

//The output format is:
//Side: {forceSide}, Members: {forceUsersCount}
//! {forceUser}
//! {forceUser}
//! {forceUser}
//
//In case there are NO force users, don't print this side.
//
//Examples
//Input	                                        Output
//Light | George                                Side: Dark, Members: 1
//Dark | Peter                                  ! Peter
//End                                           Side: Light, Members: 1
//                                              ! George
//
//Comments
//We register George in the Light side and Peter in the Dark side.
//After receiving "End" we print both sides, ordered by membersCount and then by name.
//
//Examples
//Input                                        	Output
//Lighter | Ronn                                John joins the Lighter side!
//Darker | Dean                                 Dean joins the Lighter side!
//John -> Lighter                               Side: Lighter, Members: 3
//Dean -> Lighter                               ! Dean
//End                                           ! John
//                                              ! Ronn
//Comments
//Although John doesn't have a profile, we register him and add him to the Lighter side.
//We remove Dean from Darker side and add him to Lighter side.
//We print only Lighter side because Darker side has no members.
public class ForceBook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        HashMap<String, ArrayList<String>> facebook = new HashMap<>();



        while(!input.equals("End")){
            if(input.contains("|")){
                String[] tockens = input.split(" \\| ");
                if(!facebook.containsKey(tockens[0])) {
                    boolean isRegisted = false;
                    for (String s : facebook.keySet()) {
                        if(facebook.get(s).contains(tockens[1])){
                            isRegisted = true;
                            break;
                        }
                    }
                    if(!isRegisted){
                        facebook.put(tockens[0], new ArrayList<>(){{
                            add(tockens[1]);
                        }});
                    }

                }else if(!facebook.get(tockens[0]).contains(tockens[1])){
                    facebook.get(tockens[0]).add(tockens[1]);
                }

            }else{
                String[] tockens = input.split(" -> ");
                for (String s : facebook.keySet()) {
                    if(facebook.get(s).contains(tockens[0])){
                        facebook.get(s).remove(tockens[0]);
                        break;
                    }
                }

                if(!facebook.containsKey(tockens[1])){
                    facebook.put(tockens[1], new ArrayList<>(){{
                        add(tockens[0]);
                    }});
                }else {
                    facebook.get( tockens[1]).add(tockens[0]);
                }
                System.out.printf("%s joins the %s side!%n", tockens[0], tockens[1]);
            }

            input = scanner.nextLine();
        }

        facebook
                .entrySet()
                .stream()
                .sorted((a, b) ->{
                    if(b.getValue().size()- a.getValue().size() ==0){
                        return a.getKey().compareTo(b.getKey());
                    }else{
                        return b.getValue().size() - a.getValue().size();
                    }
                }).forEach(entry -> {
            if(entry.getValue().size()!=0){
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());

                entry
                        .getValue()
                        .stream()
                        .sorted(String::compareTo)
                        .forEach(s -> {
                            System.out.printf("! %s%n", s);
                        });
            }
        });

    }
}
