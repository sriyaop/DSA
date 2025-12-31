public class fastExponentiation {
    
    public static int fastExpo(int a, int n){
        int ans=1;
        
        while(a>0){
            if((n&1)!=0){
                ans*=a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
         System.out.println(fastExpo(5, 3));
    }
}
