import java.util.*;
public class diamond {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the num for diamond: ");
        int num=sc.nextInt();
        //upper half
        for(int i=1;i<=4;i++){
            //leftspaces
            for(int j=1;j<=num-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("* ");
            }
            for(int j=1;j<=num-i;j++){
                System.out.print("  ");
            }
            System.out.println();
        }
        //lower half
        for(int i=4;i>=1;i--){
            //leftspaces
            for(int j=1;j<=num-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("* ");
            }
            for(int j=1;j<=num-i;j++){
                System.out.print("  ");
            }
            System.out.println();
        }
        
        sc.close();
    }
    
}


