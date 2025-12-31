import java.util.*;
public class binToDecimal {

    public static void BtoD(int n){
        int power=0;
        int decimal=0;
        while(n>0){
            int last_digit=n%10;
            decimal=decimal+(last_digit*(int)Math.pow(2,power));
            n/=10;
            power++;
        }
        System.out.println("Decimal number is "+decimal);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number: ");
        int number=sc.nextInt();
        BtoD(number);
        sc.close();

    }

    
}
