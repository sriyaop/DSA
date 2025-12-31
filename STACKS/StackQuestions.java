import java.util.*;
public class StackQuestions {
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }
    public static void reverseStrUsingStack(Stack<Character> s, String str,int idx){
        if(idx==str.length()){
            return;
        }
        s.push(str.charAt(idx));
        reverseStrUsingStack(s,str,idx+1);
    }
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static boolean isValidParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                s.push(currentChar);
            } else {
                if (s.isEmpty()) {  // If stack is empty and we encounter a closing bracket, return false.
                    return false;
                }

                char top = s.peek();  // Get the top of the stack

                // Check if the closing bracket matches the top of the stack
                if ((top == '{' && currentChar == '}') || 
                    (top == '(' && currentChar == ')') || 
                    (top == '[' && currentChar == ']')) {
                    s.pop();
                } else {
                    return false;  // If there's a mismatch
                }
            }
        }
        
        // If the stack is empty, then all brackets matched correctly.
        return s.isEmpty();
    }
    
    public static boolean isDuplicateParenthesis(String str){//O(n)
        Stack<Character> s= new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            //closing
            if(ch==')'){
                int count=0;
                while(s.pop()!='('){
                    count++;
                }
                if(count<1){
                    return true;//duplicate
                }
            }else{//opening, operators,operands
                s.push(ch);
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // //push at bottom
        // pushAtBottom(s, 4);
        //printStack(s);
        // //reverse string using stack
        // Stack<Character> stack=new Stack<>();
        // String str="Hello World!";
        // reverseStrUsingStack(stack,str,0);
        // while(!stack.isEmpty()){
        //     System.out.print(stack.pop());
        // }
        //reverse stack
        // reverseStack(s);
        // printStack(s);

       //to check is valid parenthesis string has duplicate parentheseis or not 
        String str1="((a+b))";//true
        String str2="(a+b)";//true
        System.out.println(isDuplicateParenthesis(str1));
        System.out.println(isDuplicateParenthesis(str2));
    }
}

