// import java.util.*;
public class binarySearch {
    public static void sort(int arr[]){

    }
    public static int BinarySearch(int arr[],int key){
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){//found
                return mid;
            }else if(arr[mid]>key){//left
                end=mid-1;
            }else{//right
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        int key=2;
        System.out.println("Elemnet found at: "+BinarySearch(arr, key));
    }
}
