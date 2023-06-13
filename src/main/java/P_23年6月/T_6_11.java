package P_23年6月;

import java.util.HashMap;
import java.util.Map;

public class T_6_11 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(-2);

        System.out.println(removeZeroSumSublists(head));
    }
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer,ListNode> map = new HashMap<>();
        int sum = 0;
        for(ListNode node = dummy;node != null;node = node.next){
            sum += node.val;
            map.put(sum,node);//如果出现重复的key，put会覆盖
        }
        sum = 0;
        for (ListNode node = dummy;node != null;node = node.next){
            sum += node.val;
            node.next = map.get(sum).next;
        }
        return dummy.next;
    }

}



