/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
  public List<Integer> postorder(Node root) {
    if(root == null){
        return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    dfs(root, ans);
    return ans;
  }

  private void dfs(Node node, List<Integer> list) {
    for (Node child : node.children) {
      dfs(child, list);
    }
    list.add(node.val);
  }
}