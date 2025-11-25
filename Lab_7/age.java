import java.util.Scanner;

class wrongAgeException extends Exception{
    public wrongAgeException(String msg){
        super(msg);
    }
}


class Father{
    int fage;
    Father(int fage) throws wrongAgeException{
        this.fage=fage;
        if (fage<=0){
            throw new wrongAgeException("Father age can't be negative");
        }
    }
}

class Son extends Father{
    int sage;
    Son(int fage, int sage) throws wrongAgeException{
        super(fage);
        this.sage=sage;
        if(sage<=0){
            throw new wrongAgeException("Son age can't be negative");
        }
        if (sage>=fage){
            throw new wrongAgeException("Son age can't be more than Father age");
        }
    }

    void display(){
        System.out.println("Father age is: "+fage);
        System.out.println("Son age is: "+sage);
    }
}

public class age {
    public static void main(String[] args) {
        try{
            Scanner s= new Scanner(System.in);
            System.out.println("Enter Father's age: ");
            int fage=s.nextInt();
            System.out.println("Enter Son's age: ");
            int sage=s.nextInt();
            Son fam = new Son(fage, sage);
            fam.display();
            s.close();
        }
        catch(wrongAgeException e){
            System.out.println("Error: "+e);
        }

    }
}
