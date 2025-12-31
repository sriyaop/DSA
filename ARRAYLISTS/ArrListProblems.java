import java.util.ArrayList;
import java.util.Collections;

public class ArrListProblems {
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater=0;
        // //brute force
        // for(int i=0;i<height.size();i++){
        //     for(int j=i;j<height.size();j++){
        //         int water_level=Math.min(height.get(i),height.get(j));
        //         int width=j-i;
        //         int water_stored=water_level*width;
        //         if(maxWater<water_stored){
        //             maxWater=water_stored;
        //         }
        //     }
        // }

        //2-pointer method
        int lp=0,rp=height.size()-1;
        while(lp<rp){
            int water_level=Math.min(height.get(lp),height.get(rp));
            int width=rp-lp;
            int water_stored=water_level*width;
            if(maxWater<water_stored){
                 maxWater=water_stored;
            }
            if(height.get(lp)<height.get(rp)){lp++;}
            else{rp--;}
        }
        return maxWater;
    }  

    public static boolean pairSum(ArrayList<Integer> list,int target){
        // //brute force O(n2)
        // for(int i=0;i<list.size();i++){
        //     for(int j=i+1;j<list.size();j++){
        //         if(list.get(i)+list.get(j)==target){
        //             return true;
        //         }
        //     }
        // }

        //2 pointer O(n)
        int lp=0,rp=list.size()-1;
        while(lp<rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }else if(list.get(lp)+list.get(rp)<target){
                lp++;
            }else if(list.get(lp)+list.get(rp)>target){
                rp--;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storeWater(height));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int target=10;
        System.out.println(pairSum(list,target));
    }
}