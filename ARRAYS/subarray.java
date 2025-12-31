public class subarray {
    public static void subArr(int arr[]){
        int subSum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                subSum++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("No of Subarrays: "+subSum);
    }
    public static void main(String[] args) {
        int array[]={2,4,6,8,10};
        subArr(array);
        
    }
}
