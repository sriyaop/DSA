public class DuplicatesInString{
    public static void duplicates(String str,int idx, StringBuilder newstr, boolean charArr[]){
        //base
        if(idx==str.length()){
            System.out.println(newstr);
            return;
        }

        char currChar=str.charAt(idx);

        //work
        if(charArr[currChar-'a']==true){
            //duplicate
            duplicates(str, idx+1, newstr, charArr);
        }else{
            //unique
            charArr[currChar-'a']=true;
            duplicates(str, idx+1, newstr.append(currChar), charArr);
        }
    }
    public static void main(String[] args) {
        String str="appnnacollege";
        duplicates(str,0, new StringBuilder(' '), new boolean[26]);
    }
} 