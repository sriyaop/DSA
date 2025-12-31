public class maxSubArrPrefixSum {
    public static void prefixSum(int arr[],int len){
        int pref[]=new int[len];
        for(int i=0;i<len;i++){
            pref[i]=i==0?arr[i]:pref[i-1]+arr[i];
        }
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                currSum=i==0?pref[j]:pref[j]-pref[i-1];
                System.out.print(currSum+" ");
                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
            System.out.println();
        }
        System.out.println("Max subarray sum is: "+maxSum);

    }
    public static void main(String[] args) {
        int array[]={2,4,6,8,10};
        int len=array.length;
        prefixSum(array,len);
        
    }
}
