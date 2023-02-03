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
        System.out.println("Enter the information of Phone");
        Phone phone = new Phone();
        Scanner sc = new Scanner(System.in);
        int code, amount, year;
        String name;
        double price;
        System.out.print("Phone ID: ");
        code = sc.nextInt();
        sc.nextLine();
        while (isExisting(code)) {
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
        phone = new Phone(code, name, price, amount, year);
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
            head = p;
        }
        size++;
    }

    public void add_Last(Phone data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node newest = new Node(data, null);
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
            size--;
        }
    }

    public void deleteNode(int PhoneID) {
        if(isEmpty()) {
            System.out.println("List is empty");
        }
        else {
            Node temp = head;
            Node prev = null;
            while(temp != null) {
                if(temp.data.getID() == PhoneID) {
                    if (prev != null) {
                        prev.next = temp.next;
                    } else {
                        head = temp.next;
                    }
                    size--;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
        }
    }

    public int search(String name) {
        Node p = head;
        int pos = 0;
        while (p != null) {
            if (p.data.equals(name)) {
                return pos;
            } else {
                System.out.println("Not exist");
            }
            p = p.next;
            pos++;
        }
        return 0;
    }

    public Node MaxValue() {
        Phone phone = new Phone();
        double max = 0;
        Node p = head;
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            max = head.data.getValue();
            while (p != null) {
                if (max < phone.getPrice()*phone.getAmount()) {                    
                    max = phone.getPrice()*phone.getAmount();
                }
                p = p.next;
            }
            System.out.println("Maximum value is : " + max);

        }
        return null;
    }

    public boolean isExisting(int code) {
        boolean check = false;
         for(Node k = head;k!=null;k=k.next){
            if(k.data.getID() == code) {
                check = true;
            }
        }
        return check;
    }
}
