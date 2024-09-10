
class Solution {
    public int findGCD(int a, int b){
        if(a==0) return b;
        return findGCD(b%a,a);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;
        ListNode cur = head;
        while(cur.next!=null){
            int max = Math.max(cur.val,cur.next.val);
            int min = Math.min(cur.val,cur.next.val);
            int gcd = findGCD(max, min);
            ListNode gcdNode = new ListNode(gcd);
            gcdNode.next = cur.next;
            cur.next = gcdNode;
            cur = gcdNode.next;
        }
        return head;
    }
}
