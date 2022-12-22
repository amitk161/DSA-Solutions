/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        map.put(node, new Node(node.val, new ArrayList<>()));
        
        while(!q.isEmpty()){
            Node h = q.poll();
            
            for(Node it: h.neighbors){
                if(!map.containsKey(it)){
                    map.put(it, new Node(it.val, new ArrayList<>()));
                    q.add(it);
                }
                map.get(h).neighbors.add(map.get(it));
            }
        }
        return map.get(node);
    }
}