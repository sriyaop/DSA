import java.util.*;
public class hollowRect {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of rectangle: ");
        int l=sc.nextInt();
        System.out.println("Enter the height of rectangle: ");
        int h=sc.nextInt();
        
        for(int row=1;row<=h;row++){
            if(row==1 || row==h){
                for(int col=1;col<=l;col++){
                    System.out.print("* ");
                }
            }else{
                for(int col=1;col<=l;col++){
                    if(col==1 || col==l){System.out.print("* ");}
                    else{ System.out.print("  ");}
                }
            }
            System.out.println();
        }
        
        sc.close();
    }
    
}
