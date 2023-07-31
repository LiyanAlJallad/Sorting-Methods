package LA2Q2;

import java.util.Comparator;
public class StudentGrade implements Comparable<StudentGrade> {

    //Fields
        private String firstName;
        private String lastName;
        private Integer grade;

    //Constructor with no Arguments
    public StudentGrade(){}

    //Constructor with no Arguments
    public StudentGrade (String firstName, String lastName, Integer grade){
            this.firstName=firstName;
            this.lastName=lastName;
            this.grade=grade;
        }

        //setter and getter for first name
        public void setFirstName(String firstName){
            this.firstName=firstName;
        }
        public String getFirstName (){
            return firstName;
        }

        //Setter and getter for last name
        public void setLastName(String lastName){
        this.lastName=lastName;
        }
        public String getLastName (){
            return lastName;
        }

        //Setter and getter for grades
        public void setGrade(Integer grade){
            this.grade=grade;
        }
        public Integer getGrade () {
            return grade;
        }


        public int compareTo(StudentGrade grd){
        //Ascending order
        return this.grade.compareTo(grd.getGrade());
        }

        //prints format as the output
        public String toString (){
        String fullName = firstName + " " + lastName;
            String formatText;
            formatText=String.format("\b\b%16s: \t%d",fullName,grade );
            return formatText+="\n";
        }


    }

