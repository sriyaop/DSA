import java.util.*;
public class floydTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the height of pyramid: ");
        int h=sc.nextInt();
        
        int num=1;
        for(int row=1;row<=h;row++){
            for(int col=1;col<=row;col++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
        
        sc.close();
    }
    
}

