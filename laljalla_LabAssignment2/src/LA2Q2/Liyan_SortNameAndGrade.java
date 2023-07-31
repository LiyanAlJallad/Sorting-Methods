package LA2Q2;

import java.util.Collections;
import java.util.Vector;

public class Liyan_SortNameAndGrade {
    public static void main(String[] args) {
        myHeader(2,2);

        //Arrays for the given names in the output
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {
                (int)(60 + Math.random()*26),
                (int)(60 +Math.random()*26),
                (int)(60 + Math.random()*26),
                (int)(60 + Math.random()*26),
                (int)(60 + Math.random()*26),
                (int)(60 + Math.random()*26),
                (int)(60 + Math.random()*26),
                (int)(60 +Math.random()*26)
        };

        //creating Vector<> class instance ‘sg’ with StudentGrade tag
        Vector <StudentGrade> sg = new Vector<>();

        //Adding each StudentGrade object to the Vector class with its add method
        for (int i =0;i< fnArray.length; i++){
        StudentGrade sgClass = new StudentGrade(fnArray[i],lnArray[i],grd[i]);
            sg.addElement(sgClass);

        }
        System.out.println("The Unsorted Array...\n"+sg+"\b");

        ///sorting ‘sg’ using Collections’ sort method, which will sort the list based on the grade
        Collections.sort(sg);
        System.out.println("Sorted by Grades...\n" + sg + "\b");

        //Creating an array of StudentGrade type with the length of the fnArray
        StudentGrade [] stGrdArr = new StudentGrade[fnArray.length];
        sg.copyInto(stGrdArr);

        //sorting the names according to first names
        insertionSort(stGrdArr,1);
        System.out.println("Sorted by First Names....");
        printArray(stGrdArr);

        //sorting the names according to last names
        insertionSort(stGrdArr,2);
        System.out.println("\nSorted by Last Names....");
        printArray(stGrdArr);

        myFooter(2,2);
    }

    //print array
    public static void printArray (StudentGrade [] arr ) {
        for (int i=0; i<arr.length;i++){
            String fullName = arr[i].getFirstName() + " " + arr[i].getLastName();
            System.out.printf("%16s: \t%d\n",fullName,arr[i].getGrade());
        }
//        for (StudentGrade student: arr) {
//            System.out.print(student);
//        }
    }


    public static <T extends Comparable<? super T>> void insertionSort(StudentGrade[] a, int num) {

        int n = a.length;
        for (int i = 1; i < n; i++) {
            StudentGrade key = a[i];
            int j;

            //if number is equal one it will compare the first names
            if (num == 1) {
                for (j = i - 1; (j >= 0) && (a[j].getFirstName().compareTo(key.getFirstName()) > 0); j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = key;
            }

            //if number is equal two it will compare the last names
            else if (num == 2) {
                for (j = i - 1; (j >= 0) && (a[j].getLastName().compareTo(key.getLastName()) > 0); j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = key;
            }
        }
    }

    public static void myHeader(int exerciseNum, int qNum) {
        System.out.printf("=======================================================\nLab Assignment %d, Q%d\nPrepared By: Liyan Al-Jallad\nStudent Number: 251246155\nGoal of this Exercise: Sorting Names and Grades\n=======================================================\n", exerciseNum,qNum);
    }

    public static void myFooter(int exerciseNum,int qNum) {
        System.out.printf("=======================================================\nCompletion of Lab Exercise %d, Q%1d is successful!\nSigning off- Liyan\n=======================================================\n", exerciseNum,qNum);
    }

}
