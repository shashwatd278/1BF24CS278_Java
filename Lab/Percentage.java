import java.util.Scanner;

abstract class Student{
    String name;
    String USN;
    String Collegename;
    int age;

    void StudDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student name:");
        this.name=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Student USN:");
        this.USN = sc.nextLine();
        sc.nextLine();
        this.Collegename="BMSCE";
        System.out.println ("Enter Student age:");
        this.age=sc.nextInt();
    }

    void display(){
        System.out.println("Student Details:");
        System.out.println("Name: "+ name);
        System.out.println("USN: " + USN);
        System.out.println("College Name: "+ Collegename);
        System.out.println("Age: "+age);
    }

    abstract void calcPercentage();
}

class Second extends Student{
    Scanner sc = new Scanner (System.in);
    int marks[] = new int [6];
    int total;

    void calcPercentage(){
        for (int i=0;i<6;i++){
            System.out.println("Enter subject "+(i+1)+" marks:");
            marks[i]=sc.nextInt();
            sc.nextLine();
        }
        for(int i=0;i<6;i++){
            total+=marks[i];
        }
        double percentage=(total/(double)300)*100;
        super.display();
        System.out.println("Percentage is: "+percentage);
    }
}

class Third extends Student{
    Scanner sc = new Scanner (System.in);
    int marks[] = new int [8];
    int total;

    void calcPercentage(){
        for (int i=0;i<8;i++){
            System.out.println("Enter subject "+(i+1)+" marks:");
            marks[i]=sc.nextInt();
            sc.nextLine();
        }
        for(int i=0;i<8;i++){
            total+=marks[i];
        }
        double percentage=(total/(double)400)*100;
        super.display();
        System.out.println("Percentage is: "+percentage);
    }
}

class Fourth extends Student{
    Scanner sc = new Scanner (System.in);
    int marks[] = new int [4];
    int total;

    void calcPercentage(){
        for (int i=0;i<4;i++){
            System.out.println("Enter subject "+(i+1)+" marks:");
            marks[i]=sc.nextInt();
            sc.nextLine();
        }
        for(int i=0;i<4;i++){
            total+=marks[i];
        }
        double percentage=(total/(double)400)*100;
        super.display();
        System.out.println("Percentage is: "+percentage);
    }
}



public class Percentage {
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        int year,n;
        System.out.println("Enter Student year :");
        year = sc.nextInt();
        System.out.println("Enter number of students :");
        n = sc.nextInt();


        if (year==2){
            Student second[] = new Second[n];
            for (int i =0;i<n;i++){
                second[i]=new Second();
                second[i].StudDetails();
                second[i].calcPercentage();
            }
            
        }

        else if (year==3){
            Student third[] = new Third[n];
            for (int i =0;i<n;i++){
                third[i]=new Third();
                third[i].StudDetails();
                third[i].calcPercentage();
            }
        }

        else if (year==4){
            Student fourth [] = new Fourth[n];
            for (int i =0;i<n;i++){
                fourth[i]=new Fourth();
                fourth[i].StudDetails();
                fourth[i].calcPercentage();
            }
        }

        else{
            System.out.println("Incorrect Year !");
            sc.close();
        }
    }
}
