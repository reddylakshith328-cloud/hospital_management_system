package P1;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

class Array {

    String slots[] = {"09 A.M.-01 P.M.","03 P.M.-07 P.M.","07:30 P.M.-11:30 P.M."};

    int patientId[] = {101,102,103};
    String patientName[] = {"Rahul","Vishnu","Kiran"};
    String cause[] = {"Fever","Headache","Stomach Pain"};

    void displaySlots() {

        System.out.println("\nAppointment Slots");

        for(int i=0;i<slots.length;i++)
            System.out.println(slots[i]);
    }

    

    void displayDoctors() {

        FileReader FR = null;

        try {

            FR = new FileReader("C:\\javaexamples\\doctors.txt");

            int ch;

            while((ch = FR.read()) != -1)
                System.out.print((char)ch);
        }

        catch(IOException e) {
            System.out.println("Error "+e.getMessage());
        }

        finally {

            try {
                if(FR != null)
                    FR.close();
            }
            catch(IOException e) {
                System.out.println("Error "+e.getMessage());
            }
        }
    }

    void displayPatients() {

        System.out.println("\nPatients");

        for(int i=0;i<patientId.length;i++)
            System.out.println(patientId[i]+"   "+patientName[i]+"   "+cause[i]);
    }

    

    void searchPatient(int id) {

        boolean found = false;

        for(int i=0;i<patientId.length;i++) {

            if(patientId[i]==id) {

                System.out.println("Patient Found");
                System.out.println(patientId[i]+"   "+patientName[i]+"  "+cause[i]);
                found = true;
            }
        }

        if(!found)
            System.out.println("Patient Not Found");
    }

    

    void mergeSort(int l,int r) {

        if(l<r) {

            int m=(l+r)/2;

            mergeSort(l,m);
            mergeSort(m+1,r);

            merge(l,m,r);
        }
    }

    void merge(int l,int m,int r) {

        int n1=m-l+1;
        int n2=r-m;

        int L[]=new int[n1];
        int R[]=new int[n2];

        for(int i=0;i<n1;i++)
            L[i]=patientId[l+i];

        for(int j=0;j<n2;j++)
            R[j]=patientId[m+1+j];

        int i=0,j=0,k=l;

        while(i<n1 && j<n2) {

            if(L[i]<=R[j]) {
                patientId[k]=L[i];
                i++;
            }
            else {
                patientId[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1) {
            patientId[k]=L[i];
            i++;k++;
        }

        while(j<n2) {
            patientId[k]=R[j];
            j++;k++;
        }
    }

    void displaySorted() {

        System.out.println("Sorted Patient IDs");

        for(int i=0;i<patientId.length;i++)
            System.out.println(patientId[i]);
    }
}



class VisitNode {

    int id;
    String details;
    VisitNode next;
}

class VisitList {

    VisitNode head;

    void addVisit(int id,String d) {

        VisitNode newNode=new VisitNode();

        newNode.id=id;
        newNode.details=d;
        newNode.next=null;

        if(head==null) {
            head=newNode;
            System.out.println("Visit added successfully");
        }

        else {

            VisitNode cnode=head;

            while(cnode.next!=null) {
                cnode=cnode.next;
                System.out.println("Visit added successfully");
            }
            cnode.next=newNode;
        }
    }

    void deleteVisit(int id) {

        VisitNode cnode=head;
        VisitNode delnode=null;

        while(cnode!=null && cnode.id!=id) {

            delnode=cnode;
            cnode=cnode.next;
        }

        if(cnode==null)
            System.out.println("Visit Not Found");

        else if(delnode==null) {

            head=cnode.next;
            System.out.println("Visit Deleted");
        }

        else {

            delnode.next=cnode.next;
            System.out.println("Visit Deleted");
        }
    }

    void display() {

        VisitNode cnode=head;
while(cnode!=null) {
            System.out.println(cnode.id+"   "+cnode.details);
            cnode=cnode.next;
        }
    }
}



class Stack {

    String stack[] = new String[20];
    int top=-1;

    void push(String action) {

        top++;
        stack[top]=action;

        System.out.println("Action Recorded");
    }

    void pop() {

        if(top==-1)
            System.out.println("No Action");

        else {

            System.out.println("Undo "+stack[top]);
            top--;
        }
    }
}



class Queue {

    int q[]=new int[20];
    int front=-1,rear=-1;

    void enqueue(int id) {

        if(front==-1)
            front=0;

        rear++;
        q[rear]=id;

        System.out.println("Patient Added");
    }

    void dequeue() {

        if(front==-1  front>rear)
            System.out.println("Queue Empty");

        else {

            System.out.println("Serving Patient "+q[front]);
            front++;
        }
    }

    void display() {

        if(front==-1 || front>rear)
        {
            System.out.println("Queue Empty");
        }
        else
        {
            for(int i=front;i<=rear;i++)
                System.out.println(q[i]);
        }
    }
}



public class HosptialManagementSystem {

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        Array arr=new Array();
        VisitList visit=new VisitList();
        Stack stack=new Stack();
        Queue queue=new Queue();

        int choice,opt;

        System.out.println("     BBR SUPER SPECIALITY HOSPITAL     ");

        arr.displaySlots();

        do{

            System.out.println("\nHOSPITAL MANAGEMENT SYSTEM");

            System.out.println("1 Display Doctors");
            System.out.println("2 Display Patients");
            System.out.println("3 Add Visit");
            System.out.println("4 Delete Visit");
            System.out.println("5 Display Visits");
            System.out.println("6 Search Patient");
            System.out.println("7 Sort Patient IDs");
            System.out.println("8 Save Action");
            System.out.println("9 Undo Action");
            System.out.println("10 Add Patient Queue");
            System.out.println("11 Serve Patient");
            System.out.println("12 Display Queue");
            System.out.println("0 Exit");

            System.out.print("Enter Choice: ");
            choice=sc.nextInt();

            switch(choice) {

                case 1:
                    arr.displayDoctors();
                    break;

                case 2:
                    arr.displayPatients();
                    break;

                case 3:
                    System.out.print("Visit ID: ");
                    int vid=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Details: ");
                    visit.addVisit(vid,sc.nextLine());
                    break;

                case 4:
                    System.out.print("Visit ID: ");
                    visit.deleteVisit(sc.nextInt());
                    break;

                case 5:
                    visit.display();
                    break;

                case 6:
                    System.out.print("Patient ID: ");
                    arr.searchPatient(sc.nextInt());
                    break;

                case 7:
                    arr.mergeSort(0,arr.patientId.length-1);
                    arr.displaySorted();
                    break;

                case 8:
                    sc.nextLine();
                    System.out.print("Action: ");
                    stack.push(sc.nextLine());
                    break;

                case 9:
                    stack.pop();
                    break;

                case 10:
                    System.out.print("Patient ID: ");
                    queue.enqueue(sc.nextInt());
                    break;

                case 11:
                    queue.dequeue();
                    break;
case 12:
                    queue.display();
                    break;

                case 0:
                    System.out.println("System Closed");
                    
                    break;
            }

            System.out.println("\nEnter 19 to continue");
            opt=sc.nextInt();

        }while(opt==19);
    }
}
