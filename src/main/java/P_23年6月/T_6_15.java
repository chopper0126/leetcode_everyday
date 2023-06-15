package P_23年6月;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chopper
 * @version 1.0
 * @description: 1177. 构建回文串检测
 * @date 2023/6/15 9:45
 */
public class T_6_15 {
    public static void main(String[] args) {
//        System.out.println(canMakePaliQueries("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}}));
        System.out.println(canMakePaliQueries2("abcda",new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}}));
    }
    //思路：先把字串拿出来，统计子串没个此字符出现的次数，如果出现的次数是偶数那就忽略它（统计出现的种类个数），如果是奇数，那就加到种类中去
    //种类：0,1,2,3,4,5,6,7... 要改变的次数x = type / 2 ，if  x <= k,return true;
    /*输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
输出：[true,false,false,true,true]*/

//方法一：暴力
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = queries.length;
        String[][] subStr = new String[n][2];
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subStr[i][0] = s.substring(queries[i][0],queries[i][1]+1);
            subStr[i][1] = String.valueOf(queries[i][2]);
            res.add(isValid(subStr[i][0],queries[i][2]));
//            System.out.println(subStr[i][0] + subStr[i][1]);
        }
        return res;
    }
    private static boolean isValid(String s,int k){
        int x = 0;//要改变的次数x
        Map<Character,Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果map中没有此字符，则次数置为1
            if (!count.containsKey(c)) {
                count.put(c, 1);
            } else {
                //如果map中有此字符，则次数增1
                Integer temNum = count.get(c);
                temNum++;
                count.put(c, temNum);
            }
        }

        //遍历
        // 迭代键
        int type = 0;
        for (Character key : count.keySet()) {
            type++;
        }

        // 迭代值
        for (Integer value : count.values()) {
            if (value % 2 == 0) type--;
        }
        x = type / 2;
        if (x <= k){
            return true;
        }
        return false;
    }

//方法二：
    /**
     *
     * @description:
     * @param: s
    queries
     * @return: java.util.List<java.lang.Boolean>
     * @author chopper
     * @date: 2023/6/15 11:22
     */
    public static List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        int n = s.length();
        var sum = new int[n + 1][26];//sum[i+1][j] 表示 s[0] 到 s[i] 字母j出现的次数
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i].clone();
//            sum[i + 1][s.charAt(i) - 'a']++;
            sum[i + 1][s.charAt(i) - 'a'] ^= 1; // 奇数变偶数，偶数变奇数
        }
        List<Boolean> res = new ArrayList<>();
        for(var q : queries){
            int left = q[0],right = q[1],k = q[2],m = 0;
            for (int j = 0; j < 26; j++) {
//                m += (sum[right + 1][j] - sum[left][j]) % 2;//奇数+1，偶数+0
                m += sum[right + 1][j] ^ sum[left][j];
            }
            res.add( m / 2  <= k);
        }
        return res;
    }

    /**
     *
     * @description:  快速统计字符串中小写字母出现的次数
     * @param: null
     * @return:
     * @author chopper
     * @date: 2023/6/15 10:44
     */
    private static int[] countStringC(String s,int[][] queries){
        int n = s.length();
        int[] ans = new int[26];
        var sum = new int[n + 1][26];//sum[i+1][j] 表示 s[0] 到 s[i] 字母j出现的次数
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i].clone();
            sum[i + 1][s.charAt(i) - 'a']++;
        }
        for(var q : queries){
            int left = q[0],right = q[1],k = q[2];
            for (int j = 0; j < 26; j++) {
                ans[j] = sum[right + 1][j] - sum[left][j];
            }
        }
        return ans;
    }

}
