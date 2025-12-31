import java.util.*;

public class decimalToBinary {
    public static void DtoB(int n){
        int power=0;
        int binary=0;
        while(n>0){
            int last_digit=n%2;
            binary=binary+(last_digit*(int)Math.pow(10,power));
            n/=2;
            power++;
        }
        System.out.println("Binary number is "+binary);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number: ");
        int number=sc.nextInt();
        DtoB(number);
        sc.close();

    }

}
