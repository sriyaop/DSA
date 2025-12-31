public class FriendsPairing {

    public static int pairing(int n){
        //base
        if(n==0){ return 1;}
        if(n==1||n==2){ return n;}

        //working
        //single
        int fnm1=pairing(n-1);

        //pairing
        int fnm2=pairing(n-2);

        int totalWays= fnm1+ (n-1)*fnm2;
        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(pairing(3));
    }
    
}
