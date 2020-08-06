package AssociativeArrayPackage_Exercice;

//Description
//Write a program which keeps information about companies and their employees.
//You will receive company name and employee's id, until you receive the command "End".
//Add each employee to the given company.
//Keep in mind that a company cannot have two employees with the same id.
//When you finish reading data, order the companies by the name in ascending order.
//Print the company name and each employee's id in the following format:
//{companyName}
//-- {id1}
//-- {id2}
//-- {idN}
//Input
//Until you receive "End", the input come in the format:
//"{companyName} -> {employeeId}".

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

//Examples
//Input                                             	Output
//SoftUni -> AA12345                                    HP
//SoftUni -> BB12345                                    -- BB12345
//Microsoft -> CC12345                                  Microsoft
//HP -> BB12345                                         -- CC12345
//End                                                   SoftUni
//                                                      -- AA12345
//                                                      -- BB12345
//
public class CompanyUsers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<String>> companyMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] tockens  = input.split(" -> ");
            String company = tockens[0];
            String employeeId = tockens[1];
            ArrayList<String> employCurent = new ArrayList<>();
            ArrayList<String> employExistentInMap = new ArrayList<>();

            if(companyMap.get(company)==null){
                employCurent.add(employeeId);
                companyMap.put(company, employCurent);
            }else {
                int i=0;
                int sizeOfEmployAtCurentCompany = companyMap.get(company).size();
                for (i = 0; i <=sizeOfEmployAtCurentCompany-1; i++) {
                    employExistentInMap.add(companyMap.get(company).get(i));
                }
                int ok = 0;
                for (int j = 0; j <=employExistentInMap.size()-1; j++) {
                    if(employExistentInMap.get(j).equals(employeeId)){
                        ok=1;
                    }
                }
                if(ok==0) {
                    employExistentInMap.add(employeeId);
                }
                companyMap.put(company, employExistentInMap);

            }



            input = scanner.nextLine();
        }


        for (String nameCompany : companyMap.keySet()){
            System.out.println(nameCompany);

            ArrayList<String> printList = companyMap.get(nameCompany);

            for (String employerID : printList){

                System.out.printf("-- %s%n",employerID);

            }
        }



    }
}
