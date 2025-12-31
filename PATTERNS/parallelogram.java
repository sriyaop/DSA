import java.util.*;

public class parallelogram {
    public static void Parallelogram(int num){
        int width=(2*num)-1;
        int l=width-num;
        int r=0;
        for(int row=1;row<=num;row++){
            for(int col=1;col<=l;col++){
                System.out.print("  ");
            }
            for(int col=1;col<=num;col++){
                System.out.print("* ");
            }
            for(int col=1;col<=r;col++){
                System.out.print("  ");
            }
            System.out.println();
            l--;
            r++;
        }

    }
    public static void HollowParellelogram(int num){
        int width=(2*num)-1;
        int l=width-num;
        int r=0;
        for(int row=1;row<=num;row++){
            for(int col=1;col<=l;col++){
                System.out.print("  ");
            }
            if(row==1 || row==num){
                for(int col=1;col<=num;col++){
                    System.out.print("* ");
                }
            }else{
                for(int col=1;col<=num;col++){
                    if(col==1 || col==num){System.out.print("* ");}
                    else{ System.out.print("  ");}
                }
            }
            for(int col=1;col<=r;col++){
                System.out.print("  ");
            }
            System.out.println();
            l--;
            r++;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num=sc.nextInt();
        Parallelogram(num);

        HollowParellelogram(num);

        sc.close();
    }
}
