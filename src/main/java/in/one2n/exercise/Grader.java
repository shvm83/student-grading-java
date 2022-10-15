package in.one2n.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grader {

    public List<Student> parseCSV(String filepath) {
        // returns the list of students after parsing the csv file

        // create a variable to store the list of students
        List<Student> students = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            String[] headers = br.readLine().trim().split(",");

            // start reading from the 2nd line as the first line is stored in the headers
            String line = br.readLine();

            while (line != null) {
                // store the values read in string array
                String[] stds = line.split(",");

                // create a student object
                Student student = new Student(stds[0], stds[1], stds[2], Double.parseDouble(stds[3]),
                        Double.parseDouble(stds[4]),
                        Double.parseDouble(stds[5]), Double.parseDouble(stds[6]));

                // add the student object to the list
                students.add(student);

                line = br.readLine();
            }

        } catch (IOException io) {
            // print exception to console
            io.printStackTrace();
        }
        // return the list of students
        return students;
    }

    // return the calculated grade of the students
    public List<Student> calculateGrade(List<Student> students) {

        if (students.isEmpty()) {
            System.out.println("Students list is empty");
            return Collections.emptyList();
        } else {
            // iterate through the list of students and set the final score and grade for
            // each student
            for (Student stud : students) {
                stud.setFinalScore();
                stud.setGrade();
            }
            return students;
        }
    }

    // returns the topper among all the students
    public Student findOverallTopper(List<Student> gradedStudents) {

        // set final_score to the minimum value possible
        double max_score = Double.MIN_VALUE;

        // creating the student object to store teh overall_topper
        Student Overall_topper = null;

        // iterate through all the student object and compare
        // the current max_score with the current student final_score
        for (Student std : gradedStudents) {
            if (max_score < std.getFinalScore()) {
                max_score = std.getFinalScore();
                Overall_topper = std;
            }
        }
        return Overall_topper;
    }

    // returns the topper for each university
    public Map<String, Student> findTopperPerUniversity(List<Student> gradedStudents) {

        // creating a hashmap to store the university_topper
        Map<String, Student> university_topper = new HashMap<>();

        for (Student stud : gradedStudents) {
            if (university_topper.get(stud.getUniversity()) == null) {
                // add the university into the map if it not present already
                university_topper.put(stud.getUniversity(), stud);
            } else {
                // update the map with the student having the greater final score for the
                // corresponding university
                if (university_topper.get(stud.getUniversity()).getFinalScore() < stud.getFinalScore()) {
                    university_topper.put(stud.getUniversity(), stud);
                }
            }
        }
        return university_topper;
    }
}