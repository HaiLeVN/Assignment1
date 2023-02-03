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
            System.out.println("3. Add node"); //Chưa có
            System.out.println("4. Delete first");
            System.out.println("5. Delete last");
            System.out.println("6. Delete Node"); //Lỗi khi xóa đuôi của List sẽ không thể thêm được
            System.out.println("7. Check existing Phone");
            System.out.println("8. Search by name");
            System.out.println("9. Show Phone list Year >2020");
            System.out.println("10. Check length");
            System.out.println("11. Clear all");
            System.out.println("12. Find the node maximum value");
            System.out.println("13. Load Phone (for test case) ");
            System.out.println("Others. Quit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice) {
                case 1:
                    obj = list.input();
                    list.add_Last(obj);
                    list.show();
                    break;
                case 2:
                    obj = list.input();
                    list.add_First(obj);
                    list.show();
                    break;
                case 3:
                    System.out.print("Input ID to add after: ");
                    int ID = Integer.parseInt(sc.nextLine());
                    obj = list.input();
                    list.add_Node(obj, ID);
                    list.show();
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
                    ID = Integer.parseInt(sc.nextLine());
                    list.deleteNode(ID);
                    list.show();
                    break;
                case 7:
                    System.out.print("Enter Phone ID to check: ");
                    ID = Integer.parseInt(sc.nextLine());
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
                    int count = list.search(name);
                    System.out.println("Counted "+count+" Node(s) with name '"+name+"'.");
                    break;
                case 9:
                    list.show2();
                    break;
                case 10:
                    int length = list.length();
                    System.out.println("Length of list: "+length);
                    break;
                case 11:
                    list.clear();
                    break;
                case 12:
                    list.MaxValue();
                    break;
                case 13:
                    obj = new Phone(1, "Samsung", 25, 7, 2022);
                    Phone obj2 = new Phone(2, "Vivo", 12, 2, 2021);
                    Phone obj3 = new Phone(3, "iPhone", 12, 2, 2018);
                    Phone obj4 = new Phone(4, "Nokia", 88, 1, 2012);
                    Phone obj5 = new Phone(5, "Oppo", 56, 4, 2023);
                    list.add_Last(obj);
                    list.add_Last(obj2);
                    list.add_Last(obj3);
                    list.add_Last(obj4);
                    list.add_Last(obj5);
                    System.out.println("Loaded 5 Phones successfully");
                    list.show();
                    break;
            }       
        } while (choice>0 && choice<14);
    }
}
