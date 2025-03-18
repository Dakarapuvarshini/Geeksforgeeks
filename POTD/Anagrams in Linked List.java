class Node {
    char data;
    Node next;
 
    Node(char x)
    {
        data = x;
        next = null;
    }
}
 
class Solution {
 
    // Function to check whether sublink list and are
    // anagrams or not
    boolean anagram(HashMap<Character, Integer> smp,
                    HashMap<Character, Integer> cmp)
    {
 
        if (smp.size() != cmp.size())
            return false;
 
        for (Map.Entry<Character, Integer> entry :
             smp.entrySet()) {
 
            char key = entry.getKey();
            int value = entry.getValue();
 
            if (!cmp.containsKey(key)
                || cmp.get(key) != value) {
                return false;
            }
        }
 
        return true;
    }
 
    // Function to find starting points which are anagrams
    List<Node> findAnagrams(Node head, String s)
    {
 
        List<Node> ans = new ArrayList<>();
 
        Node prev = null;
 
        HashMap<Character, Integer> smp = new HashMap<>();
        HashMap<Character, Integer> cmp = new HashMap<>();
 
        Node curr = head;
        int n = s.length();
 
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            smp.put(c, smp.getOrDefault(c, 0) + 1);
        }
 
        while (curr != null) {
            Node temp = curr;
            for (int i = 0; i < n && temp != null; i++) {
                char c = temp.data;
                cmp.put(c, cmp.getOrDefault(c, 0) + 1);
                prev = temp;
                temp = temp.next;
            }
 
            // If they both are anagrams of each other
            if (anagram(smp, cmp)) {
                prev.next = null;
                ans.add(curr);
                curr = temp;
            }
 
            // If not
            else {
                curr = curr.next;
            }
            cmp.clear();
        }
        return ans;
    }
}
 
class GFG {
 
    // Function to print Linked list stored
    // in vector
    static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
 
    // Function to create linked list
    static Node inputList()
    {
 
        // Length of link list
        int n = 8;
 
        char[] data
            = { 'a', 'b', 'c', 'a', 'd', 'b', 'c', 'a' };
        Node head = new Node(data[0]);
        Node tail = head;
        for (int i = 1; i < n; ++i) {
            tail.next = new Node(data[i]);
            tail = tail.next;
        }
        return head;
    }
 
    public static void main(String[] args)
    {
        Node head = inputList();
        String s = "bac";
 
        Solution obj = new Solution();
        List<Node> res = obj.findAnagrams(head, s);
 
        for (int i = 0; i < res.size(); i++) {
            printList(res.get(i));
        }
 
        if (res.size() == 0)
            System.out.println("-1");
    }
}
 
