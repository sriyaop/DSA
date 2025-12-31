import java.util.*;
public class mirroredHalfPyramid {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the height of pyramid: ");
        int h=sc.nextInt();
        
        for(int row=1;row<=h;row++){
            for(int col=1;col<=h-row;col++){
                System.out.print("  ");
            }
            for(int col=1;col<=row;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
        
        sc.close();
    }
    
}

