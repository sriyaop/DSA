import java.util.*;

public class FractionalKnapsack{
    public static int FracKnap(int val[],int weight[],int capacity){
        double ratio[][]=new double[val.length][2];
        //0th col=>idx; ist col=>ratio

        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }

        //sort in asc order based on ratio=>o[1]
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int finalValue=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){//can include full item
                finalValue+=val[idx];
                capacity-=weight[idx];
            }else{
                //include fractional item
                finalValue+=ratio[i][1]*capacity;
                capacity=0;
                break;
            }
        }
        return finalValue;
    }
    public static void main(String[] args){
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int capacity=50;
        System.out.println(FracKnap(val, weight, capacity));
    }
} 
