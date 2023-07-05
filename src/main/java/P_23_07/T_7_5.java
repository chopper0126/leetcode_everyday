package P_23_07;

public class T_7_5 {
    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum2(0,0,2,1));
    }
    // K 件物品的最大和
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;
        while (k-- > 0){
            if (numOnes  > 0) {
                numOnes--;
                ans++;
            }else if(numZeros > 0){
                numZeros--;
            }else if(numNegOnes > 0){
                numNegOnes--;
                ans--;
            }
        }
        return ans;
    }
    // 法二，分类讨论
    public static int kItemsWithMaximumSum2(int numOnes, int numZeros, int numNegOnes, int k) {
        if ( k <= numOnes) {
            return k;
        }else if(k <= numOnes + numZeros){
            return numOnes;
        }else {
            return numOnes -(k - numOnes - numZeros);
        }
    }
}
