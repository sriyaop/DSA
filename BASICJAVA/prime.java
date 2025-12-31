import java.util.*;

public class prime {

    public static boolean isPrime(int n){
        if(n==2){
            return true;//directrly return true
        }

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void primeRange(int num){
        for(int i=2;i<=num;i++){
            if(isPrime(i)==true){
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number: ");
        int number=sc.nextInt();
        primeRange(number);
        sc.close();

    }
    
}
