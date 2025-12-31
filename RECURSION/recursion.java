public class recursion{

    public static void printDec(int n){
        if(n==1){
            System.out.print(n+" ");
            return ;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void printInc(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        int factorial= n*fact(n-1);
        return (factorial); 
    }

    public static int sum(int n){
        if(n==1){
            return 1;
        }
        int ans=n+sum(n-1);
        return ans;
    }

    public static int fibo(int n){
        if(n==0||n==1){
            return n;
        }
        int f1=fibo(n-1);
        int f2=fibo(n-2);
        int fn=f1+f2;
        return fn;
    }

    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccurance(int arr[],int key, int i){
        if(arr[i]==key){
            return i;
        }
        return firstOccurance(arr, key, i+1);
    }

    public static int lastOccurance(int arr[],int key, int i){
        if(i==arr.length){
            return -1;
        }
        int isFound=lastOccurance(arr,key,i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }

    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        return x* power(x,n-1);
    }
    public static int optimizedPower(int x,int n){
        if(n==0){
            return 1;
        }
        int halfPow=optimizedPower(x, n/2);
        int halfPowSqr=halfPow*halfPow;
        
        if(n%2!=0) return x*halfPowSqr; 

        return halfPowSqr;
    }

    public static void towerOfHanoi(int n,char from_rod, char to_rod, char aux_rod){
        //Base case
        if(n==0){
            return;
        }

        //move n-1 disk from rod A (from_rod) to rod B (aux_rod).
        towerOfHanoi(n-1,from_rod,aux_rod,to_rod);

        //move nth disk from rod A (from_rod) to rod B (aux_rod).
        System.out.println("Move disk "+ n +" from rod "+ from_rod+" to rod "+to_rod);

        //move n-1 disk from rod B (aux_rod) to rod C (to_rod).
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }
    public static void main(String[] args) {
    //    printDec(10);
    //    System.out.println();
    //    printInc(10);
    //    System.out.println();
    //    System.out.println(fact(5));
    //    System.out.println(sum(5));
    //    System.out.println(fibo(4));
    //    int arr[]={1,3,4,7,4,3,2,2,3,5,30};
    //    System.out.println(isSorted(arr,0));
    //    System.out.println(firstOccurance(arr, 2, 0));
    //    System.out.println(lastOccurance(arr, 2, 0));
    //    System.out.println(power(4,5));
    //    System.out.println(optimizedPower(2,5));
    
       towerOfHanoi(3, 'A', 'B', 'C');
    }  
}