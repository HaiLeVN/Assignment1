package Assignment;

import java.util.Scanner;

public class List {

    Node head, tail;
    int size;

    public List() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int length() {
        Node p = head;
        int count = 0;

        while (p != null) {
            p = p.next;
            count++;
        }

        return count;
    }

    public void show() {
        
        for(Node k = head;k!=null;k=k.next){
            System.out.println(k.data.toString());
        }
        
    }
    public Phone input() {
        Phone phone = new Phone();
        Scanner sc = new Scanner(System.in);
        int code, amount, year;
        String name;
        double price;
        System.out.print("Phone ID ");
        code = sc.nextInt();
        sc.nextLine();
        while (isIDExist(code)) {
            System.out.print("ID already exists, please enter a different ID: ");
            code = sc.nextInt();
            sc.nextLine();
        }
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Price: ");
        price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Amount: ");
        amount = sc.nextInt();
        sc.nextLine();
        System.out.print("Year: ");
        year = sc.nextInt();
        System.out.println("Successfully added!");
        phone = new Phone(code, name, price, amount, year);
        add_Last(phone);
        show();
        return phone;
    }

    public void show2() {
        for(Node k = head;k!=null;k=k.next){
            if(k.data.getYear() > 2020) {
                System.out.println(k.data.toString());
            }
        }
    }

    public void add_First(Phone data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node p = new Node(data, null);
            p.next = head;
            head = p;
        }
        size++;
    }

    public void add_Last(Phone data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node newest = new Node(data, null);
            newest.next = null;
            tail.next = newest;
            tail = newest; 
        }
        size++;
    }

    public void add_Node(Phone data, int PhoneID) {

    }

    public void delete_first() {
        if (isEmpty()) {
            tail = null;
        }
        if (!isEmpty()) {
            head = head.next;
        }
    }

    public void delete_last() {
        if (isEmpty()) {
            head = null;
        }
        if (!isEmpty()) {
            Node p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            p.next = null;
            tail = p;
        }
    }

    public void deleteNode(int PhoneID) {
        if (isEmpty()) {
            return;
        }
        Node p = head;
        Node prev = null;
        if (!isExisting(PhoneID)) {
            System.out.println("NOT FOUND !!!");
        }
        if (isExisting(PhoneID)) {
            while(p!=null){
                
            }
        }
    }

    public boolean isExisting(int PhoneID) {
        Node p = head;
        while (p != null) {
            if (p.data.equals(PhoneID)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }
    

    public int search(String name) {
        Node p = head;
        int pos = 0;
        while (p != null) {
            if (p.data.equals(name)) {
                return pos;
            }
            p = p.next;
            pos++;
        }
        return 0;
    }

    public Node MaxValue() {
        Phone phone = new Phone();
        double max = phone.getValue();
        Node p = head;
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            while (p != null) {
                
                }
                p = p.next;
            }
            System.out.println("Maximum value is : " + max);
        return null;
        }

    private boolean isIDExist(int code) {
        boolean check = false;
         for(Node k = head;k!=null;k=k.next){
            if(k.data.getID() == code) {
                check = true;
            }
        }
        return check;
    }
}
