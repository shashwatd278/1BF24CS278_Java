import java.util.Scanner;

class student{
    String name;
    String USN;
    int n;
    int credit[];
    int marks[];
    double totalcredits;
    double totalpoints;
    int gradepoints;
    double sgpa;

    void accept(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name:");
        name=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Student USN:");
        USN=sc.nextLine();
        sc.nextLine();

        System.out.println("Enter number of subject: ");
        n=sc.nextInt();

        credit=new int[n];
        marks=new int[n];

        for (int i=0; i<n; i++){
            System.out.println("Enter subject "+(i+1)+" details");
            System.out.println("Enter marks:");
            marks[i]=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter credits for the subject:");
            credit[i]=sc.nextInt();
            sc.nextLine();
        }
    }

    void display(){
        System.out.println("Student Details ");
        System.out.println("Student Name : "+name);
        System.out.println("Student USN : "+USN);
    }

    void sgpa(){
        
        for (int i=0; i<n; i++){
            if (marks[i]>=90){
                gradepoints=10;
            }
            else if(marks[i]>=80 && marks[i]<90){
                gradepoints=9;
            }
            else if(marks[i]>=70 && marks[i]<80){
                gradepoints=8;
            }
            else if(marks[i]>=60 && marks[i]<70){
                gradepoints=7;
            }
            else if(marks[i]>=50 && marks[i]<60){
                gradepoints=6;
            }
            else if(marks[i]>=40 && marks[i]<50){
                gradepoints=5;
            }
            else{
                gradepoints=4;
            }

            totalpoints+=gradepoints*credit[i];
            totalcredits+=credit[i];
        }
        sgpa=totalpoints/totalcredits;
        System.out.println("The Sgpa of the student is : "+sgpa);
    }
}

class SGPA{
    public static void main(String args[]) {

        int n = 2;
        student[] students = new student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            students[i] = new student();
            students[i].accept();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nDetails of Student " + (i + 1));
            students[i].display();
            students[i].sgpa();
        }

    }
}