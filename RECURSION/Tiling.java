public class Tiling {
    public static int fillTiles(int n){
        //base condition
        if(n==0||n==1)return 1;//only 1 way
        // //vertical choice
        // int fnm1=fillTiles(n-1);

        // //horizontal choice
        // int fnm2=fillTiles(n-2);

        // int totalWays=fnm1+fnm2;
        // return totalWays;
        return fillTiles(n-1)+fillTiles(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fillTiles(5));
    }
}
