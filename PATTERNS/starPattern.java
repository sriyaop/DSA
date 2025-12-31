public class starPattern{
    public static void main(String[] args) {
        // Star pattern
        for(int line=1;line<=4;line++){
            for(int star=1;star<=line;star++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        // Inverted- Star pattern
        for(int line=1;line<=4;line++){
            for(int star=1;star<=4-line+1;star++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        //half pyramid pattern
        // Star pattern
        for(int line=1;line<=4;line++){
            for(int num=1;num<=line;num++){
                System.out.print(num);
            }
            System.out.println();
        }

        System.out.println();
        int n=4;
        char ch='A';
        for(int line=1;line<=n;line++){
            for(int chars=1;chars<=line;chars++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }

    }
}