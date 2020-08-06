package AssociativeArrayPackage_Exercice;

//Description
//Write a program, which validates parking for an online service.
//Users can register to park and unregister to leave.
//The program receives 2 commands:
//"register {username} {licensePlateNumber}":
//The system only supports one car per user at the moment, so if a user tries to register another license plate, using the same username, the system should print: "ERROR: already registered with plate number {licensePlateNumber}"
//If the aforementioned checks pass successfully, the plate can be registered, so the system should print: "{username} registered {licensePlateNumber} successfully"
//"unregister {username}":
//If the user is not present in the database, the system should print: "ERROR: user {username} not found"
//If the aforementioned check passes successfully, the system should print: "{username} unregistered successfully"
//After you execute all of the commands, print all the currently registered users and their license plates in the format:
//"{username} => {licensePlateNumber}"
//Input
//First line: n – number of commands – integer
//Next n lines: commands in one of two possible formats:
//Register: "register {username} {licensePlateNumber}"
//Unregister: "unregister {username}"

//Examples
//Input	                                    Output
//5                                         John registered CS1234JS successfully
//register John CS1234JS                    George registered JAVA123S successfully
//register George JAVA123S                  Andy registered AB4142CD successfully
//register Andy AB4142CD                    Jesica registered VR1223EE successfully
//register Jesica VR1223EE                  Andy unregistered successfully
//unregister Andy                           John => CS1234JS
//                                          George => JAVA123S
//                                          Jesica => VR1223EE

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//Examples
//Input	                                    Output
//4                                         Jony registered AA4132BB successfully
//register Jony AA4132BB                    ERROR: already registered with plate number AA4132BB
//register Jony AA4132BB                    Linda registered AA9999BB successfully
//register Linda AA9999BB                   Jony unregistered successfully
//unregister Jony                           Linda => AA9999BB
//
//
//
public class Parking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> registerMap = new LinkedHashMap<>();



        for (int i = 1; i <=n ; i++) {
            String[] input = scanner.nextLine().split(" ");
            String comamnd = input[0];
            String userName = input[1];

            if(comamnd.equals("register")){
                String licensePlateNumber = input[2];
                if(!registerMap.containsKey(userName)){
                    registerMap.put(userName, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", userName, licensePlateNumber);
                }else{
                    System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                }

            }else if(comamnd.equals("unregister")){
                if(!registerMap.containsKey(userName)){
                    System.out.printf("ERROR: user %s not found%n", userName);
                }else{
                    System.out.printf("%s unregistered successfully%n", userName);
                    registerMap.remove(userName);
                }
            }


        }

        for (Map.Entry<String, String> entry : registerMap.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }


    }
}
