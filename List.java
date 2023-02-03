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
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input, please enter an integer: ");
            sc.nextLine();
        }
        code = sc.nextInt();
        while (isExisting(code)) {
            System.out.print("ID already exists, please enter a different ID: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input, please enter an integer: ");
                sc.nextLine();
            }
            code = sc.nextInt();
        }
        sc.nextLine();
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Price: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input, please enter a number: ");
            sc.nextLine();
        }
        price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Amount: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input, please enter an integer: ");
            sc.nextLine();
        }
        amount = sc.nextInt();
        sc.nextLine();
        System.out.print("Year: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input, please enter an integer: ");
            sc.nextLine();
        }
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
            tail.next = newest;
            tail = newest; 
        }
        size++;
    }

    public void add_Node(Phone data, int PhoneID) {
        if(isEmpty()) {
            head = tail = new Node(data, null);
            
        } else {
            Node temp = head;
            while(temp != null) {
                if(temp.data.getID() == PhoneID) {
                    Node newest = new Node(data, temp.next);
                    temp.next = newest;
                    if(temp==tail) {
                        tail=newest;
                    }
                    size++;
                    return;
                }
                temp=temp.next;
            }
            add_Last(data);
        }
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

    
    // 1 (head) - 2 - 7 - 4 (tail) - null
    
    //Singly Linked List
    public void deleteNode(int PhoneID) {
        if(isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head.data.getID() == PhoneID) {
            head = head.next;
            if(head==null) {
                tail=null;
            }
            return;
        }
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if(current.data.getID() == PhoneID) {
                prev.next = current.next;
                
                if(current == tail) {
                    tail = prev;
                }
                break;
            } else {
                prev = current;
                current = current.next;
            }
        }
    }

    public int search(String name) {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (p.data.getName().equalsIgnoreCase(name)) {
                count++;
            }
            p = p.next;
        }
        return count;
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
