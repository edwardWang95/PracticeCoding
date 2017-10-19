package LeetCode;

/**
 * 2. Add Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 * Created by edwardwang on 10/19/17.
 */
public class AddTwoNumbers {
    public static void main(String [] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printListNodes(addTwoNumbers(l1,l2));
    }
    static void printListNodes(ListNode listNode){
        if(listNode!=null){
            System.out.print(listNode.val);
            printListNodes(listNode.next);
        }
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solution = null;
        int carry = 0;
        int l1Val = 0;
        int l2Val = 0;
        while(l1 != null || l2 != null){
            solution = new ListNode(0);
            if(l1 != null){
                l1Val = l1.val;
            }
            if(l2 != null){
                l2Val = l2.val;
            }
            int sum = l1Val + l2Val + carry;
            if(sum>=10){
                carry = 1;
                sum -= 10;
            }else{
                carry = 0;
            }
            solution.val = sum;
            solution = solution.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return solution;
    }
}

class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
    }
}
