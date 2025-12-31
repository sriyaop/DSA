public class BitManipulation{

    public static void oddOrEven(int n){
        int bitMask=1;
        if((n & bitMask)==0){
            //even
            System.out.println("even number");    
        }else{
            //odd
            System.out.println("odd number");
        }
    }

    public static int getIthBit(int n,int i){
        int bitMask=1<<i;
        if((n & bitMask)==0){return 0;}
        else{return 1;}
    }

    public static int setIthBit(int n,int i){
        int bitMask=1<<i;
        return n|bitMask;
    }

    public static int clearIthBit(int n,int i){
        int negBitMask= ~(1<<i);
        return (n & negBitMask);
    }

    public static int updateIthBit(int n, int i, int newBit){
        // if(newBit==0){
        //     return clearIthBit(n, i);
        // }else{
        //     return setIthBit(n, i);
        // }

        //or another approch
        n=clearIthBit(n, i);
        int BitMask=newBit<<i;
        return BitMask|n;

    }

    public static int clearLastIBits(int n,int i){
        int bitMask=(~0)<<i;
        return n & bitMask;
    }

    public static int clearRangeOfBits(int n,int i,int j){
        int a=(~0)<<(j+1);
        int b=(1<<i)-1;
        int bitMask=a|b;
        return n&bitMask;
    }
    public static boolean isPowerOfTwo(int n){
        return (n&(n-1))==0;
    }

    public static int setBitsInNumber(int n){
        int count=0;
        for(int i=0;i<8;i++){
            if(((n>>i)&1)==1){count++;}
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(getIthBit(10, 0));
        System.out.println(setIthBit(10, 2));
        System.out.println(clearIthBit(10, 1));
        System.out.println(updateIthBit(15, 1, 0));
        System.out.println(updateIthBit(15, 1, 1));
        System.out.println(clearLastIBits(15, 2));
        System.out.println(clearRangeOfBits(2515, 2, 7 ));
        System.out.println(isPowerOfTwo(1001));
        System.out.println(setBitsInNumber(19));
    }
}