public class RecursionPracticeQs{
    public static void findOcc(int idx,int arr[],int key){
        if(idx==arr.length){
            System.out.println();
            return;
        }
        if(arr[idx]==key){
            System.out.print(idx+" ");
        }
        findOcc(idx+1,arr,key);
    }

    public static void numToEnglish(int number){
        if(number==0){
            System.out.println();
            return;
        }
        
        int lastDigit=number%10;
        numToEnglish(number/10);
        System.out.print(digits[lastDigit]+" ");
    }

    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    
    public static void main(String[] args) {
        int arr[]={3,2,4,5,6,2,7,2,2};
        findOcc(0,arr, 2);

        numToEnglish(2019);
    }
}
