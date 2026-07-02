import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }

                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            return leftCount + rightCount + 1;
        }

        public static int sumNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftSum = sumNodes(root.left);
            int rightSum = sumNodes(root.right);
            return leftSum + rightSum + root.data;
        }
    }

    public static int diameter2(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDaimeter = diameter2(root.left);
        int leftHt = BinaryTree.height(root.left);
        int rightDaimeter = diameter2(root.right);
        int rightHt = BinaryTree.height(root.right);

        return Math.max(Math.max(rightDaimeter, leftDaimeter), leftHt + rightHt + 1);
    }

    // Calculate height and daimeter in same function
    // static class Info {
    // int daim;
    // int ht;

    // public Info(int daim, int ht) {
    // this.daim = daim;
    // this.ht = ht;
    // }
    // }

    // public static Info daimeter(Node root) {
    // if (root == null) {
    // return new Info(0, 0);
    // }

    // Info leftDaim = daimeter(root.left);
    // Info rightDaim = daimeter(root.right);

    // int daim = Math.max(Math.max(leftDaim.daim, rightDaim.daim), leftDaim.ht +
    // rightDaim.ht + 1);
    // int ht = Math.max(leftDaim.ht, rightDaim.ht) + 1;

    // return new Info(daim, ht);
    // }

    public static boolean isIdentical(Node root, Node subTree) {
        if (root == null && subTree == null) {
            return true;
        } else if (root == null || subTree == null || root.data != subTree.data) {
            return false;
        }

        if (!isIdentical(root.left, subTree.left)) {
            return false;
        }
        if (!isIdentical(root.right, subTree.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subTree) {
        if (root == null) {
            return false;
        }
        if (root.data == subTree.data) {
            if (isIdentical(root, subTree)) {
                return true;
            }
        }
        return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);
    }

    static class Info {
        Node node;
        int hd; // Horizontal distance

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) { // occur first time
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void kthLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }

    // Lowest Common ansister
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i - 1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    // Min distance btw nodes
    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDis = lcaDist(root.left, n);
        int rightDis = lcaDist(root.right, n);

        if (leftDis == -1 && rightDis == -1) {
            return -1;
        } else if (rightDis == -1) {
            return leftDis + 1;
        } else {
            return rightDis + 1;
        }
    }

    public static int minDis(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        Node lca = lca2(root, n1, n2);
        int dis1 = lcaDist(root, n1);
        int dis2 = lcaDist(root, n2);

        return dis1 + dis2;
    }

    public static int kAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data + " ");
        }
        return max + 1;
    }

    // sum of tree
    public static int tranform(Node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = tranform(root.left);
        int rightChild = tranform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = leftChild + newLeft + rightChild + newRight;

        return data;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = BinaryTree.buildTree(nodes);
        // Node subTree = new Node(2);
        // subTree.left = new Node(4);
        // subTree.right = new Node(3);
        // System.out.println(root.data + " ");
        // BinaryTree.preOrder(root);
        // System.out.println();
        // BinaryTree.inOrder(root);
        // System.out.println();
        // BinaryTree.postOrder(root);
        // BinaryTree.levelOrder(root);
        // System.out.println(BinaryTree.height(root));
        // System.out.println(BinaryTree.count(root));
        // System.out.println(BinaryTree.sumNodes(root));
        // Info data = daimeter(root);
        // System.out.println(data.daim);
        // System.out.println(isSubtree(root, subTree));
        // topView(root);
        // kthLevel(root, 1, 3);
        // System.out.println();
        // System.out.println(lca(root, 4, 6).data);
        // System.out.println(lca2(root, 4, 6).data);
        // System.out.println(minDis(root, 4, 6));

        // System.out.println(kAncestor(root, 4, 2));
        tranform(root);
        BinaryTree.preOrder(root);
    }
}
