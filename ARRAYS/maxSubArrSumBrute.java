public class maxSubArrSumBrute {
    public static void subArrSum(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int subSum=0;
                for(int k=i;k<=j;k++){
                    subSum+=arr[k];
                }
                System.out.print(subSum+" ");
                if(max<subSum){
                    max=subSum;
                }
            }
            System.out.println();
        }
        System.out.println("Max subarray sum is: "+max);
    }
    public static void main(String[] args) {
        int array[]={-2,14,-6,8,-10};
        subArrSum(array);
        
    }
}
