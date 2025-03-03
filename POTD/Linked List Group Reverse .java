class Solution {
    public static Node reverseKGroup(Node head, int k) {
        Node ans = new Node(-1), ans_cur=ans;
        Node head_ptr = head;
        
        while(head_ptr!=null){
            Node start = head_ptr, end = head_ptr;
            int i=0;
            while(i<k && end!=null){
                i++;
                end = end.next;
            }
            
            Node rev = reverse(start,end);
            // System.out.println(end.data);
            ans_cur.next = rev;
            
            ans_cur = start;
            head_ptr = end;
        }
        
        return ans.next;
    }
    static Node reverse(Node start,Node end){
        if(start.next==end) return start;
        Node ans = reverse(start.next,end);
        start.next.next = start;
        start.next = null;
        return ans;
    }
}
