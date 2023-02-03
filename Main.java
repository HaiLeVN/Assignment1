/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.Scanner;

/**
 *
 * @author Thanh Hai
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List list = new List();
        Phone obj = new Phone();
        int choice;
        do {
            System.out.println("1. Add last ");
            System.out.println("2. Add first. ");
            System.out.println("3. Add node");
            System.out.println("4. Delete first");
            System.out.println("5. Delete last");
            System.out.println("6. Delete Node");
            System.out.println("7. Check existing Phone");
            System.out.println("8. Search by name");
            System.out.println("Others. Quit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice) {
                case 1:
                    list.input();
                    break;
                case 2:
                    obj = list.input();
                    list.add_First(obj);
                    break;
                case 3:
                    obj = list.input();
                    System.out.print("Input ID to add after: ");
                    int ID = sc.nextInt();
                    list.add_Node(obj, ID);
                    break;
                case 4:
                    list.delete_first();
                    list.show();
                    break;
                case 5:
                    list.delete_last();
                    list.show();
                    break;
                case 6:
                    System.out.print("Delete Phone ID: ");
                    ID = sc.nextInt();
                    list.deleteNode(ID);
                    break;
                case 7:
                    System.out.print("Enter Phone ID to check: ");
                    ID = sc.nextInt();
                    boolean check = list.isExisting(ID);
                    if(check) {
                        System.out.println("Phone exists");
                    } else {
                        System.out.println("Phone does not exist");
                    }
                    break;
                case 8:
                    System.out.print("Enter name to find: ");
                    String name = sc.nextLine();
                    list.search(name);
                    break;
            }       
        } while (choice>0 && choice<9);
    }
}
