import java.util.*;
public class maxRectAreaInHist {
    public static int area(int heights[]){ //:O(n)-optimal
        int n=heights.length;
        //calculate next smaller left nsl :O(n)
        int nsl[]= new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        //calculate next smaller right nsr :O(n)
        int nsr[]= new int[n];
        s=new Stack<>();//empty the stack
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=-1;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //areas for each bar
        //current area: height[i] * width: j-i-1== nsr[i]-nsl[i]-1
        int maxArea=0;
        int currArea=0;
        int width=0;
        for(int i=0;i<n;i++){ //:O(n)
            width=nsr[i]-nsl[i]-1;
            currArea=heights[i]*width;
            maxArea= Math.max(currArea,maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int heights[]={2,1,5,6,2,3};
        System.out.println(area(heights));
    }
}
