public class stocks {
    public static int buyAndSellStocks(int prices[]){
        int buying_price=Integer.MAX_VALUE;
        int max_profit=0;
        for(int i=0;i<prices.length;i++){
            if(buying_price<prices[i]){
                //profit
                int curr_day_profit=prices[i]-buying_price;
                max_profit=Math.max(max_profit,curr_day_profit);
            }else{
                buying_price=prices[i];
            }
        }
        return max_profit;
    }
    public static void main(String[] args) {
        int stock_prices[]={7,1,5,3,6,4};
        System.out.println(buyAndSellStocks(stock_prices));
    }
}