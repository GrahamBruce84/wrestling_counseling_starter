package example.codeclan.com.wrestling;

import java.util.Scanner;

/**
 * Created by grahambruce on 26/06/2017.
 */

public class Runner {

    public static void main(String[] args){
        Subject.displaySubjectName();
        System.out.println();
        int choice = choose();
        Subject.getAllDetails(choice);
    }

    public static int choose(){
    Scanner sc = new Scanner(System.in);
        System.out.println("Make your choice: ");
        return sc.nextInt();
    }
}
