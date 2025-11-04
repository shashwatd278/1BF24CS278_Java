import java.util.Scanner;

abstract class shape{
    int l;
    int b;

    shape(int l, int b){
        this.l=l;
        this.b=b;
    }

    abstract void area();
}

class Rectangle extends shape{
    Rectangle(int l, int b){
        super(l,b);
    }

    void area(){
        System.out.println("Area of Rectangle is "+l*b);
    }
}

class Triangle extends shape{
    Triangle(int l, int b){
        super(l,b);
    }

    void area(){
        System.out.println("Area of Triangle is "+(double)(0.5*l*b));
    }
}

class Circle extends shape{
    Circle(int r){
        super(r,0);
    }

    void area(){
        System.out.println("Area of Circle is "+(double)(3.14*l*l));
    }
}


class area{
    public static void main(String[] args){
        int l,b,r,d1,d2;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Dimensions of rectangle: ");
        l=s.nextInt();
        b=s.nextInt();

        System.out.println("Enter Dimensions of triangle: ");
        d1=s.nextInt();
        d2=s.nextInt();

        System.out.println("Enter radius of circle: ");
        r=s.nextInt();

        shape rectangle = new Rectangle(l,b);
        shape triangle = new Triangle(d1,d2);
        shape circle = new Circle(r);

        rectangle.area();
        triangle.area();
        circle.area();
    }
}