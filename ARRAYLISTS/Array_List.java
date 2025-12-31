import java.util.ArrayList;
import java.util.Collections;
public class Array_List {
    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list.add(120);
        list.add(20);
        list.add(16);
        list.add(40);
        list.add(5);
        // System.out.println(list);
        // //get operation
        // System.out.println(list.get(2));
        // //size operation
        // System.out.println(list.size());
        // //remove operation
        // list.remove(3);
        // System.out.println(list);
        // //set operation
        // list.set(2, 100);
        // System.out.println(list);
        // //contains operation
        // System.out.println(list.contains(100));

        //backward printing of array list
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //swap operation
        swap(list, 0, 4);
        System.out.println(list);

        //sort operation
        Collections.sort(list);
        System.out.println(list);

        //2-D array list
        ArrayList<ArrayList<Integer>> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(2);
        list3.add(list4);
        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(4);
        list3.add(list5);
        System.out.println(list3);

        //print 2-D array list
        for(int i=0;i<list3.size();i++){
            for(int j=0;j<list3.get(i).size();j++){
                System.out.print(list3.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}