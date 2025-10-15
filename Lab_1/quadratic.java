import java.util.Scanner;
import java.lang.Math;
class quadratic{
    public static void main (String args[]){
        int a,b,c;
        int r1,r2,D;
        Scanner in= new Scanner(System.in);
        System.out.println("Enter value for a: ");
        a=in.nextInt();

        System.out.println("Enter value for b: ");
        b=in.nextInt();

        System.out.println("Enter value for c: ");
        c=in.nextInt();

        D=(b*b)-(4*a*c);

        if(a==0){
            System.out.println("Value of a can't be 0!");
        }
        else{
            if(D>0){
                r1 = ((-b) +(int) (Math.sqrt(D)))/(2*a);
                r2 = ((-b) -(int) (Math.sqrt(D)))/(2*a);
                System.out.println("The roots are real "+r1+" and "+r2);
            }
            else if(D==0){
                r1=(-b)/(2*a);
                System.out.println("Roots are real and equal "+r1);
            }
            else{
                r1 = (-b)/(2*a);
                r2 = (int)Math.sqrt(-D)/(2*a);
                System.out.println("Roots are imaginary "+r1+" + "+r2+"i and "+r1+"-"+r2+"i");
            }
        }
    }
}