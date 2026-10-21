import java.util.*;
class Solution {
    static ArrayList<Node> list;
    static int n, idx;
    static int[][] answer;
    public int[][] solution(int[][] nodeinfo) {
        list = new ArrayList<>();
        n = nodeinfo.length;
        for(int i=0; i<n; i++){
            list.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }
        Collections.sort(list);
        for(int i=1; i<n; i++){
            insert(list.get(0), list.get(i));
        }
        
        answer = new int[2][n];
        idx = 0;
        preorder(list.get(0));
        idx=0;
        postorder(list.get(0));
        return answer;
    }
    
    static void insert(Node cur, Node input){
        boolean isLeft = cur.x > input.x;
        if(isLeft){
            if(cur.left==null){
                cur.left = input;
            } else insert(cur.left, input);
        } else {
            if(cur.right==null){
                cur.right = input;
            } else insert(cur.right, input);
        }
    }
    
    static void preorder(Node cur){
        if (cur == null) return;
        answer[0][idx++] = cur.num;
        preorder(cur.left);
        preorder(cur.right);
    }
    
    static void postorder(Node cur){
        if (cur == null) return;
        postorder(cur.left);
        postorder(cur.right);
        answer[1][idx++] = cur.num;
    }
    
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int num;
        Node left;
        Node right;
        
        public Node (int x, int y, int n){
            this.x = x;
            this.y = y;
            this.num = n;
        }
        
        @Override
        public int compareTo(Node o){
            return o.y - this.y;
        }
    }
}