public class BackTracking {
    public static void findSubstrings(String str, String sub,int i){
        //O(N*2powN)
        //base case
        if(i==str.length()){
            if(sub.length()==0){
                System.out.println("null");
            }else{
                System.out.println(sub);
            }
            return;
        }
        //yes case for a substring
        findSubstrings(str, sub+str.charAt(i), i+1);

        //No case for substring
        findSubstrings(str, sub, i+1);
    }

    public static void findPermutation(String str, String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion O(n*n!)
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String NewStr=str.substring(0,i) + str.substring(i+1);
            findPermutation(NewStr, ans+curr);
        }
    }
    public static void main(String[] args) {
        findSubstrings("abc", "", 0);
        System.out.println();
        findPermutation("abc", "");
    }
}
