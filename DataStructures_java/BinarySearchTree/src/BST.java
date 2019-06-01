import java.util.Stack;
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的二分搜索树中插入元素e，递归算法
    private Node add(Node node, E e) {
        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else
            node.right = add(node.right, e);
        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }
    private boolean contains(Node node, E e){
        if (node == null)
            return false;
        if (e.compareTo(node.e)==0)
            return true;
        else if (e.compareTo(node.e)<0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }
    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node){
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    // 二分搜索树的非递归前序遍历
    public void preOrderNR(){
        if (root==null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }
    // 二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(node.e);
    }


    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuffer res) {
        if (node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }

        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
    }
}
