package P_23_07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chopper
 * @version 1.0
 * @description: 2679. 矩阵中的和
 *              思路：1.先讲矩阵每一行进行排序（升序降序都可以，如果要降序，矩阵必须是Integer类型）
 *                   2.按列遍历，选取同一列中的最大值，定义colMax，加到res中
 * @date 2023/7/4 10:13
 */
public class T_7_4 {

    public static void main(String[] args) {
        System.out.println(matrixSum(new int[][]{{1}}));
    }
    public static int matrixSum(int[][] nums) {
        //1.先讲矩阵每一行进行排序（升序降序都可以，如果要降序，矩阵必须是Integer类型）
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        int res = 0;
        //2.按列遍历，选取同一列中的最大值，定义colMax，加到res中
        for (int i = 0; i < nums[0].length; i++) {
            int colMax = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j][i] > colMax){
                    colMax = nums[j][i];
                }
            }
            res += colMax;
        }
        return res;
    }


}
