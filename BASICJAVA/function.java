import java.util.*;
public class function {
    public static void printHelloWorld(){
        System.out.println("Hello world!");
        return;
    }

    public static int sum(int a,int b) {  //parameters or formal parameters
        int sum=a+b;
        return sum;
    }
    public static void main(String[] args) {
        printHelloWorld();
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Sum is :"+sum(a,b));//arguments or actual parameters
        sc.close();
    }
}
