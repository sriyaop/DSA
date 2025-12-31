public class Sortings{
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[],int si,int ei){
        //si,ei are start index and end index respectively
        //base case
        if(si>=ei){
            return;
        }
        //work
        int mid= si + (ei-si)/2; //(si+ei)/2
        mergeSort(arr, si, mid); //left part
        mergeSort(arr, mid+1, ei); //right part
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[],int si,int mid,int ei){
        //left(0,3)=4 elements right(4,6)=3 elements so total new temp size must be 6-0+1=7
        int temp[]=new int[ei-si+1];
        int i=si;//iterator for left part
        int j=mid+1;// for my right part
        int k=0;//iterator for temp arr

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements from the left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        //copy temp to original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }

    public static void quickSort(int arr[],int si,int ei){
        if(si>ei){
            return;
        }

        int pidx=partition(arr,si,ei);
        quickSort(arr, si, pidx-1); //left
        quickSort(arr,pidx+1, ei); //right
    }

    public static int partition(int arr[],int si,int ei){
        int pivot=arr[ei]; //we assume last element of each array part as pivot
        int i=si-1; //to make space for smaller elements than pivot
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        //do once for pivot also
        i++;
        //swap
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;

        return i; //current index of pivot
    }

    public static int searchSortedRotated(int arr[],int target,int start,int end){
        if(start>end){
            return -1;
        }

        int mid= start+ (end-start)/2;

        if(arr[mid]==target){
            return mid;
        }

        //Case 1: for Line 1-> L1
        if(arr[start]<=arr[mid]){
            //case a
            if(arr[start]<=target && target<=arr[mid]){//left of line 1
                return searchSortedRotated(arr, target, start, mid-1);
            }
            //case b
            else{// right of L1 and whole of L2
                return searchSortedRotated(arr, target, mid+1, end);
            }
        }

        //Case 2: for line 2 -> L2
        else{
            //case c
            if(arr[mid]<=target && target<=arr[end]){//right of line 2
                return searchSortedRotated(arr, target, mid+1, end);
            }
            //case d
            else{ //left of L2 and whole of L1
                return searchSortedRotated(arr, target, start, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        // int arr[]={4,3,9,4,2,8,-1};
        // mergeSort(arr, 0, arr.length-1);
        //quickSort(arr, 0, arr.length-1);

        int array[]={4,5,6,7,0,1,2,3};
        int target=3; //output->4
        int targetIndex=searchSortedRotated(array,target,0,array.length-1);
        System.out.println(targetIndex);;
    }
}