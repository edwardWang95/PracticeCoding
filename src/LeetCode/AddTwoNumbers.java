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
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        printListNodes(addTwoNumbers(l1,l2));
    }
    static void printListNodes(ListNode listNode){
        if(listNode!=null){
            System.out.print(listNode.val);
            printListNodes(listNode.next);
        }
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solution = new ListNode(0);
        //create a pointer like temp shown below
        ListNode temp = solution;
        int carry = 0;
        while(l1 != null || l2 != null){
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            if(sum>=10){
                carry = 1;
                sum %= 10;
            }else{
                carry = 0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            if(l1 != null ){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            temp.next = new ListNode(carry);
        }
        return solution.next;
    }
}

class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
    }
}

