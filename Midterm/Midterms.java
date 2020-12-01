package Main;

import java.util.Scanner;
import java.util.ArrayList;

public class Midterms {

    public static Scanner input = new Scanner(System.in); //scanner accessible to all classes.
    public static ArrayList<String> listNames = new ArrayList<>(); //name list
    public static ArrayList<Integer> listAge = new ArrayList<>();  // age list

     //ADD ENTRY
    static void addEntry(ArrayList<String> names, ArrayList<Integer> ages) {
        System.out.println("Add Entry");
        System.out.print("Enter Name: ");
        String name = input.next();
        names.add(name);

        System.out.print("Enter Age: ");
        int age = input.nextInt();
        ages.add(age);
        reading(names, ages);
    }

    //DELETE ENTRY
    static void deleteEntry(ArrayList<String> userNames, ArrayList<Integer> userAges) {
        System.out.println("Delete Entry");

        System.out.print("Enter a Name to Delete: ");
        String delUser = input.next();

        if (userNames.contains(delUser)) {
            for (int i = 0; i < userNames.size(); i++) {
                if (delUser.equals(userNames.get(i))) {
                    System.out.println(userNames.get(i) + " has been deleted!");
                    userNames.remove(i);
                    userAges.remove(i);
                    break;
                }
            }
        } else {
            System.out.println("No " + delUser + " in the list");
        }
        reading(userNames, userAges);
    }

    // VIEW ENTRY
    static void viewEntry(ArrayList<String> userNames, ArrayList<Integer> userAges) {
        System.out.println("View All Entries");

        for (int i = 0; i < userNames.size(); i++) {
            System.out.println(userNames.get(i) + " is " + userAges.get(i));
        }
        reading(userNames, userAges);
    }

    //UPDATE ENTRY
    static void editEntry(ArrayList<String> userNames, ArrayList<Integer> userAges) {
        System.out.println("Edit Entry");

        System.out.print("Enter a Name to Update: ");
        String userUpdate = input.next();

        if (userNames.contains(userUpdate)) {
            for (int i = 0; i < userNames.size(); i++) {
                if (userUpdate.equals(userNames.get(i))) {
                    System.out.print("Enter New Name: ");
                    String name = input.next();
                    userNames.set(i, name);
                    System.out.print("Enter New Age: ");
                    int age = input.nextInt();
                    userAges.set(i, age);
                    break;
                }
            }
        } else {
            System.out.println("No " + userUpdate + " in the list");
        }

        reading(userNames, userAges);

    }

    //EXIT 
    static void exitEntry(ArrayList<String> userNames, ArrayList<Integer> userAges) {
        System.exit(0);
    }
    //OUPUT 
    static void reading(ArrayList<String> names, ArrayList<Integer> ages) {

        System.out.println(" Create an arraylist which has 2 fields for each person. ");
        System.out.println(" Choose your Options: ");
        System.out.println(" 1. Add Entry ");     
        System.out.println(" 2. Delete Entry ");                    
        System.out.println(" 3. View All Entries ");                  
        System.out.println(" 4. Edit Entry ");                
        System.out.println(" 0. Exit ");              
                                                                          
                     

        int userIn = 0;
        System.out.print("Please Enter Your Choice: ");
        try {
            userIn = input.nextInt();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Invalid input, please try again");
            System.exit(0);
        }
        switch (userIn) {

            case 0:
                exitEntry(names, ages);
            case 1:
                addEntry(names, ages);
            case 2:
                deleteEntry(names, ages);
            case 3:
                viewEntry(names, ages);
            case 4:
                editEntry(names, ages);
            default: {
                System.out.println("Invalid input, please try again");
                reading(names, ages);
            } 
        }        
    }

    public static void main(String[] args) {
        reading(listNames, listAge);

    } 
}
