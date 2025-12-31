public class shortestPath {

    public static float findShortest(String path){
        int x=0;//x direction
        int y=0;//y direction

        for(int i=0;i<path.length();i++){
            char direction=path.charAt(i);

            if(direction=='S'){y--;}//South
            else if(direction=='N'){y++;}//North
            else if(direction=='W'){x--;}//West
            else if(direction=='E'){x++;}//East
        }
        //shortest distance
        return (float)Math.sqrt((x*x) + (y*y));
    }
    public static void main(String[] args) {
        String path="WNEENESENNN";
        System.out.println(findShortest(path));
    }
}
