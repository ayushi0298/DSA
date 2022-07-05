package CollectionFramework_InterviewBit.DynamicProgramming;
//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/

public class BestTimeToBuyAndSellStocksI {
    public int maxProfit(final int[] A) {
        if(A.length==0){
            return 0; 
        }
        int buy = A[0], maxPrice = 0;
        for (int i = 1; i <A.length; i++) {
            if (buy > A[i]) {
                buy = A[i];
            } else if (A[i] - buy > maxPrice) {
                maxPrice = A[i] - buy;
            }
        }
        return maxPrice;
    }

    public static void main(String args[]) {
        BestTimeToBuyAndSellStocksI bt = new BestTimeToBuyAndSellStocksI();
        int[] input = new int[]{1,2};
        System.out.println(bt.maxProfit(input));

    }
}
