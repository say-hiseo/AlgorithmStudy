import java.util.*;
class Solution {
    static int N;
    public String solution(int n, int k, String[] cmd) {
        boolean[] ox = new boolean[n];
        Arrays.fill(ox, true);
        N=n;
        Node[] nodes = new Node[n];
        Stack<Node> st = new Stack<>();
        for(int i=0; i<n; i++) nodes[i] = new Node(i);
        int cur = k;
        for(String c : cmd) {
            String[] str = c.split(" ");
            switch(str[0]){
                case "U":
                    int x = Integer.parseInt(str[1]);
                    while(x-->0){
                        cur = nodes[cur].prev;
                    }
                    break;
                case "D":
                    x = Integer.parseInt(str[1]);
                    while(x-->0){
                        cur = nodes[cur].next;
                    }
                    break;
                case "C":
                    ox[cur] = false;
                    st.add(nodes[cur]);
                    if(nodes[cur].prev != -1) nodes[nodes[cur].prev].next = nodes[cur].next;
                    if(nodes[cur].next != n) nodes[nodes[cur].next].prev = nodes[cur].prev;
                    cur = nodes[cur].next==n? nodes[cur].prev : nodes[cur].next;
                    break;
                case "Z":
                    Node latest = st.pop();
                    if(latest.prev != -1) nodes[latest.prev].next = latest.index;
                    if(latest.next != n) nodes[latest.next].prev = latest.index;
                    ox[latest.index] = true;
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(boolean b : ox){
            if(b) sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }
    
    static class Node {
        int index;
        int prev;
        int next;
        
        public Node (int index){
            this.index = index;
            this.prev = index-1;
            this.next = index+1;
        }
    }
}