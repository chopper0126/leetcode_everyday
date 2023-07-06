package P_23_07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chopper
 * @version 1.0
 * @description: 2178. 拆分成最多数目的正偶数之和
 * @date 2023/7/6 19:13
 */
public class T_7_6 {
    public static void main(String[] args) {
        System.out.println(maximumEvenSplit(28));
    }
    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 > 0) {
            return ans;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        //也就是将剩余的数加到最后一个数
        ans.add(ans.remove(ans.size() - 1) + finalSum);
        return ans;
    }
}
