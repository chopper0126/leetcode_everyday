package P_23_07;

import dataStrDefine.ListNode;

public class T_7_3 {
    public static void main(String[] args) {

    }
    /*1.反转链表l1;2.反转链表l2;3.两数相加（得到l3）；4.反转l3
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode l3 = addTwo(l1,l2);
        return reverseList(l3);
    }
    private ListNode addTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // 哨兵节点
        ListNode cur = dummy;
        int carry = 0; // 进位
        while (l1 != null || l2 != null || carry != 0) { // 有一个不是空节点，或者还有进位，就继续迭代
            if (l1 != null) carry += l1.val; // 节点值和进位加在一起
            if (l2 != null) carry += l2.val; // 节点值和进位加在一起
            cur = cur.next = new ListNode(carry % 10); // 每个节点保存一个数位
            carry /= 10; // 新的进位
            if (l1 != null) l1 = l1.next; // 下一个节点
            if (l2 != null) l2 = l2.next; // 下一个节点
        }
        return dummy.next; // 哨兵节点的下一个节点就是头节点
    }
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur!= null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
