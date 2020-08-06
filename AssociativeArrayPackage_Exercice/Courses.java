package AssociativeArrayPackage_Exercice;
//Description
//Write a program, which keeps information about courses.
//Each course has a name and registered students.
//You will receive course name and student name, until you receive the command "end".
//Check if such course already exists, and if not, add the course.
//Register the user into the course.
//When you do receive the command "end", print the courses with their names and total registered users, ordered by the count of registered users in descending order.
//For each contest print registered users ordered by name in ascending order.
//Input
//Until you receive "end", the input come in the format:
//"{courseName} : {studentName}".
//The product data is always delimited by " : ".
//Output
//Print information about each course, following the format:
//"{courseName}: {registeredStudents}"
//Print information about each student, following the format:
//"-- {studentName}"
//
//Examples
//Input                         	                        Output
//Programming Fundamentals : John Smith                     Programming Fundamentals: 2
//Programming Fundamentals : Linda Johnson                  -- John Smith
//JS Core : Will Wilson                                     -- Linda Johnson
//Java Advanced : Harrison White                            JS Core: 1
//                                                       -- Will Wilson
//                                                          Java Advanced: 1
//                                                          -- Harrison White

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.*;

public class Courses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<String>> coursesMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")){
            ArrayList<String> userAtCourses = new ArrayList<>();
            ArrayList<String> check = new ArrayList<>();

            String[] tockens = input.split(" : ");
            String curentCursesName = tockens[0];
            String userName = tockens[1];

            if(!coursesMap.containsKey(curentCursesName)){
                check.add(userName);
                coursesMap.put(curentCursesName, check);
            }else {
                int sizeCurntCurses = coursesMap.get(curentCursesName).size();
                for (int i = 0; i <=sizeCurntCurses-1 ; i++) {
                    userAtCourses.add(coursesMap.get(curentCursesName).get(i));
                }
                userAtCourses.add(userName);
                coursesMap.put(curentCursesName, userAtCourses);
            }

            input = scanner.nextLine();

        }


        coursesMap
                .entrySet()
                .stream()
                .sorted((a,b) ->
                        b.getValue().size() - a.getValue().size()
                ).forEach(entry ->{
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());


            entry
                    .getValue()
                    .stream()
                    .sorted(String::compareTo)//DOAR AICI VREAU SA IMI EXPLICI CARE E FAZA
                    .forEach(e -> System.out.printf("-- %s%n",e));

        });

    }
}
