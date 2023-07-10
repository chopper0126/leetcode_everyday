package P_23_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chopper
 * @version 1.0
 * @description: 16. 最接近的三数之和
 * @date 2023/7/10 19:13
 */
public class T_7_10 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,3},1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1,end = nums.length - 1;

            while(start < end){
                int sum = nums[i] + nums[start] + nums[ end];
                if(Math.abs(ans  - target) > Math.abs(sum - target))
                    ans = sum;

                if (sum > target)
                    end--;
                else if(sum < target)
                    start++;

                else
                    return ans;

            }
        }
        return ans;
    }
}
