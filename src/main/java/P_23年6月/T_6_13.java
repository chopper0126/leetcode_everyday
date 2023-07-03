package P_23年6月;

import java.util.Arrays;

/**
 * @author chopper
 * @version 1.0
 * @description:  2475. 数组中不等三元组的数目
 * @date 2023/6/13 11:33
 */
public class T_6_13 {
    public static void main(String[] args) {
        System.out.println(unequalTriplets2(new int[]{2,4,4,4,3}));
    }
    public static int unequalTriplets(int[] nums) {

        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if(nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public static int unequalTriplets2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0,j = 0; i < n; i = j) {
            while (j < n && nums[i] == nums[j]){
                j++;
            }
            ans += i * (j - i) * (n - j);
        }
        return ans;
    }
}
