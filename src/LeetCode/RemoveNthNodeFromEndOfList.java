package LeetCode;

/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args)
    {
        RemoveNthNodeFromEndOfListSolution solution = new RemoveNthNodeFromEndOfListSolution();
        test1(solution);
        test2(solution);
        test3(solution);
    }

    private static void test1(RemoveNthNodeFromEndOfListSolution solution)
    {
        System.out.println("Test 1");
        int n = 2;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode expectedOutput = new ListNode(1);
        expectedOutput.next = new ListNode(2);
        expectedOutput.next.next = new ListNode(3);
        expectedOutput.next.next.next = new ListNode(5);
        ListNode output = solution.removeNthFromEnd(head, n);
        boolean isCorrect = true;
        while(expectedOutput.next != null && output != null)
        {
            if(output == null)
            {
                isCorrect = false;
                break;
            }
            if(expectedOutput.val == output.val)
            {
                expectedOutput = expectedOutput.next;
                output = output.next;
            }else isCorrect = false;
        }
        System.out.println(isCorrect ? "Correct\n" : "Incorrect\n");
    }

    private static void test2(RemoveNthNodeFromEndOfListSolution solution)
    {
        System.out.println("Test 2");
        int n = 1;
        ListNode head = new ListNode(1);
        ListNode output = solution.removeNthFromEnd(head, n);
        System.out.println(output == null ? "Correct\n" : "Incorrect\n");
    }

    private static void test3(RemoveNthNodeFromEndOfListSolution solution)
    {
        System.out.println("Test 3");
        int n = 2;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode output = solution.removeNthFromEnd(head, n);
        ListNode expectedOutput = new ListNode(2);
        boolean isCorrect = true;
        while(expectedOutput != null)
        {
            if(output == null)
            {
                isCorrect = false;
                break;
            }
            if(expectedOutput.val == output.val)
            {
                expectedOutput = expectedOutput.next;
                output = output.next;
            }else isCorrect = false;
        }
        System.out.println(isCorrect ? "Correct\n" : "Incorrect\n");
    }
}

class RemoveNthNodeFromEndOfListSolution
{
    /**
     * Keep track of nth and mth[n+1] node.
     * Mth so that you can remove the nth node.
     * Nth so that in case Mth is null you can remove it directly as an edge case.
     *
     * Current solution runs 98.75% faster than all other submissions.
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int currIndex = 1;
        ListNode m = null, nthNode = null, currNode = head;
        while(currNode != null)
        {
            //set m
            if(currIndex == n+1) m = head;
            else if(currIndex > n+1) m = m.next;
            //set nthNode
            if(currIndex == n) nthNode = head;
            else if(currIndex > n) nthNode = nthNode.next;
            currNode = currNode.next;
            currIndex++;
        }
        if(m == null)
        {
            if(nthNode.next == null) head = null;
            else head = nthNode.next;
        }else if(m.next != null) m.next = m.next.next;
        printResult(head);
        return head;
    }

    private static void printResult(ListNode head)
    {
        if(head == null)
        {
            System.out.println("[]");
            return;
        }
        while(head != null)
        {
            System.out.print(head.val);
            head = head.next;
            if(head != null) System.out.print(" -> ");
        }
        System.out.println();
    }
}
