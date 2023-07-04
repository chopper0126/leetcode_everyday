package P_23年6月;

public class T_6_14 {
    public static void main(String[] args) {
//        System.out.println(numTimesAllBlue(new int[]{4,1,2,3}));
        System.out.println(numTimesAllBlue2(new int[]{4,1,2,3}));
    }
    public static int numTimesAllBlue(int[] flips) {

        int ans = 0;
        int n = flips.length;
        String str = "";
        int len = n;
        while (len-- > 0){
            str += '0';
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            sb.replace(flips[i] - 1 , flips[i] , "1");
            if(isValid(sb.toString(),i + 1)){
                ans++;
            }
        }
        return ans;
    }

    private static boolean isValid(String s, int index) {

        for (int i = 0; i < index; i++) {
            if(s.charAt(i) == '0') return false;
        }
        return true;
    }

    public static int numTimesAllBlue2(int[] flips){
        //前[1,i] 的数都为1，等价于前i次翻转中下表对应的flips[i] = i

        int ans = 0,right = 0;
        int n = flips.length;
        for (int i = 0; i < n; i++) {
            right = Math.max(right,flips[i]);
            if (right == i + 1){
                ans++;
            }
        }
        return ans;
    }

}
