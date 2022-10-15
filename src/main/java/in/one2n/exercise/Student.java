package in.one2n.exercise;

import java.util.Objects;

public class Student {

    private String firstname;
    private String lastname;
    private String university;
    private Double test1Score;
    private Double test2Score;
    private Double test3Score;
    private Double test4Score;

    // computed fields
    private Double finalScore;
    private Grade grade;

    // initialize the student class fields
    public Student(String firstname, String lastname, String university) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.university = university;
    }

    public Student(String firstname, String lastname, String university, Double test1Score, Double test2Score,
            Double test3Score, Double test4Score) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.university = university;
        this.test1Score = test1Score;
        this.test2Score = test2Score;
        this.test3Score = test3Score;
        this.test4Score = test4Score;
    }

    // getter method to return the university of a student
    public String getUniversity() {
        return this.university;
    }

    // setter method to calculate final score
    public void setFinalScore() {
        this.finalScore = (this.test1Score + this.test2Score + this.test3Score + this.test4Score) / 4;
    }

    // setter method to calculate and set grade
    public void setGrade() {
        if (this.finalScore < 35) {
            this.grade = Grade.F;
        } else if (this.finalScore >= 35 && this.finalScore < 50) {
            this.grade = Grade.C;
        } else if (this.finalScore >= 50 && this.finalScore < 70) {
            this.grade = Grade.B;
        } else {
            this.grade = Grade.A;
        }
    }

    // returns the average of the four test scores
    public Double getFinalScore() {
        return this.finalScore;
    }

    // returns the grade based on finalscore
    public Grade getGrade() {
        return this.grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return Objects.equals(firstname, student.firstname) && Objects.equals(lastname, student.lastname)
                && Objects.equals(university, student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, university);
    }
}