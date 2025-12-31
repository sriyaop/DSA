public class array {
    public static void update(int arr[],int nonChangable){
        nonChangable=10;
        for(int i=0;i<arr.length;i++){
            arr[i]+=1;
        }
    }
    public static void main(String[] args) {
        int nonChangable=5;
        System.out.println("before: "+nonChangable);
        int array[]={97,98,99};
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" " );
        }
        System.out.println();
        update(array,nonChangable);
        System.out.println("before: "+nonChangable);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" " );
        }
    }
}
