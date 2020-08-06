package AssociativeArrayPackage_Exercice;
import java.lang.reflect.Array;
import java.util.*;

//Description
//Write a program, which keeps information about students and their grades.
//You will receive n pair of rows.
//First you will receive the student's name, after that you will receive his/her grade.
//Check if the student already exists, and if not, add him/her.
//Keep track of all grades for each student.
//When you finish reading data, keep the students with average grade higher or equal to 4.50.
//Order filtered students by average grade in descending.
//Print the students and their average grade in format:
//"{name} –> {averageGrade}"
//Format the average grade to the second decimal place.
//Examples
//Input	                                        Output
//5                                             John -> 5.00
//John                                          George -> 5.00
//5.5                                           Alice -> 4.50
//John
//4.5
//Alice
//6
//Alice
//3
//George
//5
//
//
public class StudentAcademy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<Double>> studentGrade = new LinkedHashMap<>();

        int numberOfStudent = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <=numberOfStudent-1; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if(!studentGrade.containsKey(name)){
                studentGrade.put(name, new ArrayList<>());
            }

            studentGrade.get(name).add(grade);


        }

        LinkedHashMap<String, Double> averageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, ArrayList<Double>> s : studentGrade.entrySet()) {
            double sum = 0;
            for (int i = 0; i <=s.getValue().size()-1; i++) {
                sum += s.getValue().get(i);
            }
            double average = sum / s.getValue().size();
            if(average>=4.50){
                averageGrade.put(s.getKey(), average);
            }
        }

        averageGrade
                .entrySet()
                .stream()
                .sorted((s1,s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(s ->{
                    System.out.printf("%s -> %.2f%n", s.getKey(), s.getValue());
                });


    }
}
