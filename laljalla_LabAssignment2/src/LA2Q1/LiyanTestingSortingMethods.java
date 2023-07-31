package LA2Q1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class LiyanTestingSortingMethods {
    public static void main(String[] args) {
        myHeader(2,1);

       int sz=5;
       Integer [] arr = new Integer[sz];
       Integer [] backUpArr = new Integer[sz];

       for (int i=0; i<arr.length; i++){
           arr[i]=(int)(13+Math.random()*81);
       }

       System.arraycopy(arr,0,backUpArr,0,arr.length);

        List <Integer> arrList = Arrays.asList(arr);
        System.out.print("Testing execution time of different sorting methods for sorting 5 random numbers:"  );
        System.out.print("\nThe unsorted list: " + arrList);
        long startTime= System.nanoTime();
        Collections.sort(arrList);
        long endTime = System.nanoTime();
        long Time=endTime-startTime;
        System.out.printf("\nCollections' Sorting Time: %.2f milliseconds", (Time/1E+6));
        System.out.print("\nThe Sorted list using Collections' sort method: " + arrList);
        System.arraycopy(backUpArr,0,arr,0,backUpArr.length);


        System.out.print("\n\nThe unsorted list: " + arrList);
        System.out.print("\nMy Selection-Sort Time: ");
        System.out.printf("%.2f milliseconds",selectionSort(arr)/1E+6);
        System.out.print("\nThe sorted list using selection-sort: "+arrList);
        System.arraycopy(backUpArr,0,arr,0,backUpArr.length);

        System.out.print("\n\nThe unsorted list: " + arrList);
        System.out.print("\nMy Bubble-Sort Time: ");
        System.out.printf("%.2f milliseconds",bubbleSort(arr)/1E+6);
        System.out.print("\nThe sorted list using Bubble-sort: "+arrList);
        System.arraycopy(backUpArr,0,arr,0,backUpArr.length);

        System.out.print("\n\nThe unsorted list: " + arrList);
        System.out.print("\nMy Insertion-Sort Time: ");
        System.out.printf("%.2f milliseconds",insertionSort(arr)/1E+6);
        System.out.print("\nThe sorted list using Insertion-sort: "+arrList);
        System.arraycopy(backUpArr,0,arr,0,backUpArr.length);

        System.out.print("\n\nThe unsorted list: " + arrList);
        System.out.print("\nMy Merge-Sort Time: ");
        System.out.printf("%.2f milliseconds",mergeSort(arr)/1E+6);
        System.out.print("\nThe sorted list using Merge-sort: "+arrList);
        System.arraycopy(backUpArr,0,arr,0,backUpArr.length);

        System.out.print("\n\nThe unsorted list: " + arrList);
        System.out.print("\nMy Quick-Sort Time: ");
        System.out.printf("%.2f milliseconds",quickSort(arr,0,arr.length-1)/1E+6);
        System.out.print("\nThe sorted list using Quick-sort: "+arrList);
        System.arraycopy(backUpArr,0,arr,0,backUpArr.length);

        System.out.print("\n\nThe unsorted list: " + arrList);
        System.out.print("\nMy Bucket-Sort Time: ");
        System.out.printf("%.2f milliseconds",bucketSort(arr,0,arr.length-1,2)/1E+6);
        System.out.print("\nThe sorted list using Bucket-sort: "+arrList );
        System.out.println();
        System.arraycopy(backUpArr,0,arr,0,backUpArr.length);


        myFooter(2,1);
    }

    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long startTime = System.nanoTime();
        int n = a.length;

        //move boundary of unsorted subarray one by one
        for (int i = 0 ; i < n-1; i++ ){
            int nextSmlltIndx =i;

            //find the min element in unsorted array
            for (int j=i+1; j<n; j++){
                if (a[j].compareTo(a[nextSmlltIndx])<0) {
                    nextSmlltIndx = j;
                }
            }

            //Swap the found minimum element with the first element
            T temp = a[nextSmlltIndx];
            a[nextSmlltIndx] = a[i];
            a[i] = temp;
        }
        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        return time;
    }

    //compares adjacent array elements and swaps them if the element on the right is smaller than the element on the left.
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long startTime = System.nanoTime();

        for (int i=1; i<a.length; i++){
            for (int j=0; j<a.length-i; j++){
                if (a[j].compareTo(a[j+1])>0){

                    //swap arr[j+1] and arr[j]
                    T temp = a[j];
                    a[j] = a [j+1];
                    a[j+1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        return time;
    }

    //Insertion sort produces a sorted output list while iterating and consumes one input element every iteration.
    //Insertion sort takes one element from the input data after each iteration
    // locates its proper place in the sorted list
    // and inserts it there. until no input items are left, it iterates
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long startTime = System.nanoTime();

        int n = a.length;
        for (int i=1; i<n; i++ ){
            T key= a[i];
            int j;
            for (j=i-1; (j>=0) && (a[j].compareTo(key)>0); j--){
                a[j+1]=a[j];
            }
            a[j+1]=key;

        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime) ;
        return time;
    }

    //the merge sort method divides the list into halves, then iterates through the new halves
    //continually dividing them down further to their smaller parts
    public static <T extends Comparable<? super T>> long mergeSort(T[] a) {
        long startTime = System.nanoTime();

        int n = a.length;

            if (n < 2)           {
                long endTime = System.nanoTime();
                return endTime - startTime;  }

            else {
                int mid = n / 2;
                T[] S1 = Arrays.copyOfRange(a, 0, mid);
                T[] S2 = Arrays.copyOfRange(a, mid, n);

                mergeSort(S1);
                mergeSort(S2);

                int i = 0, j = 0;
                while (i + j < a.length) {
                    if (j == S2.length || (i < S1.length && (S1[i].compareTo(S2[j]) < 0)))
                        a[i + j] = S1[i++];
                    else
                        a[i + j] = S2[j++];

                }
            }

            long endTime = System.nanoTime();
            long time = (endTime - startTime);
            return time;
        }

    // divides a large data array into smaller ones. A vast array is divided into two arrays
    //one containing values smaller than the pivot
    //other contains values greater than the pivot value
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b){
        long startTime = System.nanoTime();


        if(a>b){
            long endTime = System.nanoTime();
            return endTime - startTime;}

            T p = s[b];
        int l = a;
        int r = b-1;

        while (l<=r){
            while (l<=r && (s[l].compareTo(p)<=0)){
                l=l+1;
            }
            while (l<=r && s[r].compareTo(p)>=0){
                r=r-1;
            }
            if (l<r){
                T temp = s[l];
                s[l]=s[r];
                s[r]=temp;
                l=l+1;
                r=r-1;
            }
        }
        T temp = s[l];
        s[l]=s[b];
        s[b]=temp;

        quickSort(s,a,l-1);
        quickSort(s,l+1, b);

        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        return time;
    }

    // divides the unsorted array elements into several groups called buckets
    //Each bucket is then sorted
    //Finally, the sorted buckets are combined to form a final sorted array
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){
        long startTime = System.nanoTime();

        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        return time;
    }

    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }

    public static void myHeader(int exerciseNum, int qNum) {
        System.out.printf("=======================================================\nLab Assignment %d, Q%d\nPrepared By: Liyan Al-Jallad\nStudent Number: 251246155\nGoal of this Exercise: Trying Sort Methods\n=======================================================\n", exerciseNum,qNum);
    }

    public static void myFooter(int exerciseNum,int qNum) {
        System.out.printf("=======================================================\nCompletion of Lab Exercise %d, Q%1d is successful!\nSigning off- Liyan\n=======================================================\n", exerciseNum,qNum);
    }



}
