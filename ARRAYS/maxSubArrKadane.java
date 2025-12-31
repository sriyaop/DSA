public class maxSubArrKadane {
    public static void kadane(int arr[],int len){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            currSum=currSum+arr[i];
            if(currSum<0){currSum=0;}
            maxSum=Math.max(currSum,maxSum);
        }
        System.out.println("max Sum is: "+maxSum);
    }
    public static void main(String[] args) {
        int array[]={-2,14,-6,8,-10};
        int len=array.length;
        kadane(array,len);
    }
}
