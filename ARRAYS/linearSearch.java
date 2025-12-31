// import java.util.*;
public class linearSearch {
    public static int linSearch(int array[],int element){
        for(int i=0;i<array.length;i++){
            if(array[i]==element){
                return i;
            }
        }
        return -1;
    }

    public static int largest(int array[]){
        int large=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]>large){
                large=array[i];
            }
        }
        return large;
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,7,3,7,10,2,4,34,5,1};
        System.out.println("Array is: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" " );
        }
        System.out.println();
        int element=10;
        System.out.println("Element is: "+element);
        System.out.println("The element found at index: "+linSearch(arr,element));
        System.out.println("The largest element :"+largest(arr));
    }
}
