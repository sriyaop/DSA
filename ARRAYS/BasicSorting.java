ppublic class BasicSorting {
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void BubbleSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j+1]<arr[j]){
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        printArray(arr);
    }
    public static void SelectionSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int minPos=i;
            for(int j=i;j<n;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            //swap
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
        printArray(arr);
    }

    public static void InsertionSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int curr=i;
            int prev=i-1;
            //finding the correct position to enter
            while(prev>=0&&arr[prev]>arr[curr]){
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insert
            arr[prev+1]=arr[curr];
        }
        printArray(arr);
    }

    public static void CountingSort(int arr[]){
        // find max number of array
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }

        //find count of each element in array
        int count[]=new int[max+1];//we gonna create a count array of size max+1
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        //now sort the array
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                count[i]--;
                j++;

            }
        }
        printArray(arr);

    }

    public static void main(String[] args) {
        int array[]={3,5,2,7,7,4,7,9,1};
        SelectionSort(array);
        BubbleSort(array);
        InsertionSort(array);
        CountingSort(array);

    }
}
