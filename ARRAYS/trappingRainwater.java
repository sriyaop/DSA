public class trappingRainwater {
    public static int trappingRainWater(int height[]){
        int width=1;
        int n=height.length;
        //left-max array
        int left_max[]=new int[n];
        left_max[0]=height[0];
        for(int i=1;i<n;i++){
            left_max[i]=Math.max(left_max[i-1],height[i]);
        }
        //right-max array
        int right_max[]=new int[n];
        right_max[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            right_max[i]=Math.max(right_max[i+1],height[i]);
        }
        //loop for each of the bar
        int trappedWater=0;
        for(int i=0;i<n;i++){
            //waterlevel possible for that bar
            int waterLevel=Math.min(left_max[i],right_max[i])-height[i];
            //trapped water
            trappedWater+=waterLevel*width;
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        int height[]={8,9,7};
        System.out.println("Trapped rainwater in liters is : "+trappingRainWater(height));
    }
    
}
