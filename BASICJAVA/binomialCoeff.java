import java.util.*;

public class binomialCoeff {
    public static int factorial(int num){
        int fact=1;
        for(int i=1;i<=num;i++){
            fact*=i;
        }
        return fact;
    }

    public static double nCr(int n, int r){
        int n_fact=factorial(n);
        int r_fact=factorial(r);
        int nMinusr_fact=factorial(n-r);
        double coeff_nCr=n_fact/(r_fact* nMinusr_fact);
        return coeff_nCr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n: " );
        int n= sc.nextInt();
        System.out.println("Enter r: " );
        int r=sc.nextInt();
        System.out.println("The binomial coefficient of "+n+" and "+r+" is "+nCr(n,r));

        sc.close();
    }

    
}
