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
        int choice;
        do {
            System.out.println("1. Add a new phone. ");
            System.out.println("2. Add last. ");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice) {
                case 1:
                    list.input();
                    break;
                case 2:
                    break;
            }       
        } while (choice>0 && choice<7);
    }
}
