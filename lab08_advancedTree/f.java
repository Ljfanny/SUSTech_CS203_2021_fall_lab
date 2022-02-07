import java.util.Scanner;

public class f {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        AVLTree avlTree = new AVLTree();
        int isPer = 0;
        int n = scanner.nextInt();
        long cost = 0;
        for (int i = 0; i < n; i++) {
            int j = scanner.nextInt();
            long v = scanner.nextLong();
            if (avlTree.isEmpty())
                isPer = j;
            if (j == isPer) {
                avlTree.insert(v);
            } else {
                long min = 10000000000L;
                Node deleteNode = avlTree.root;
                Node now = avlTree.root;
                while (now != null) {
                    if (min > Math.abs(now.val - v)) {
                        min = Math.abs(now.val - v);
                        deleteNode = now;
                    }else if (min == Math.abs(now.val - v)) {
                        if (now.val < deleteNode.val)
                            deleteNode = now;
                    }
                    if (now.val >= v) {
                        now = now.left;
                    } else {
                        now = now.right;
                    }
                }
                cost += min;
                assert deleteNode != null;
                avlTree.delete(deleteNode.val);
            }
        }
        System.out.println(cost);
    }

    static class Node {
        int h;
        Node left;
        Node right;
        long val;

        Node(long val) {
            this.left = null;
            this.right = null;
            this.val = val;
            this.h = 0;
        }
    }

    static class AVLTree {
        Node root;

        public boolean isEmpty() {
            return root == null;
        }

        public Node MIN(Node root) {
            if (root == null)
                return null;
            else {
                while (root.left != null)
                    root = root.left;
                return root;
            }
        }

        public Node MAX(Node root) {
            if (root == null)
                return null;
            else {
                while (root.right != null)
                    root = root.right;
                return root;
            }
        }

        public void delete(long val) {
            this.root = delete(this.root, val);
        }

        private Node delete(Node root, long val) {
            if (root == null)
                return null;
            if (val == root.val) {
                if (root.left != null && root.right != null) {
                    if (root.left.h > root.right.h) {
                        root.val = MAX(root.left).val;
                        root.left = delete(root.left, root.val);
                    } else {
                        root.val = MIN(root.right).val;
                        root.right = delete(root.right, root.val);
                    }
                } else if (root.left != null) {
                    root = root.left;
                } else if (root.right != null)
                    root = root.right;
                else root = null;
            } else if (root.val > val) {
                root.left = delete(root.left, val);
                if (getH(root.right) - getH(root.left) > 1) {
                    if (getH(root.right.left) > getH(root.right.right))
                        root = RL(root);
                    else root = RR(root);
                }
            } else {
                root.right = delete(root.right, val);
                if (getH(root.left) - getH(root.right) > 1) {
                    if (getH(root.left.left) > getH(root.left.right))
                        root = LL(root);
                    else root = LR(root);
                }
            }
            if (root != null)
                root.h = Math.max(getH(root.left), getH(root.right)) + 1;
            return root;
        }

        public void insert(long val) {
            this.root = insert(this.root, val);
        }

        private Node insert(Node root, long val) {
            if (root == null)
                root = new Node(val);
            else if (val > root.val) {
                root.right = insert(root.right, val);
                if (getH(root.left) + 1 < getH(root.right)) {
                    if (val < root.right.val)
                        root = RL(root);
                    else root = RR(root);
                }
            } else {
                root.left = insert(root.left, val);
                if (getH(root.left) > 1 + getH(root.right)) {
                    if (val < root.left.val)
                        root = LL(root);
                    else root = LR(root);
                }
            }
            root.h = Math.max(getH(root.left), getH(root.right)) + 1;
            return root;
        }

        private int getH(Node a) {
            if (a == null)
                return -1;
            else return a.h;
        }

        private Node RL(Node tree) {
            tree.right = LL(tree.right);
            return RR(tree);
        }

        private Node LR(Node tree) {
            tree.left = RR(tree.left);
            return LL(tree);
        }

        private Node RR(Node tree) {
            Node r = tree.right;
            tree.right = r.left;
            r.left = tree;
            r.h = Math.max(getH(r.left), tree.h) + 1;
            tree.h = Math.max(getH(tree.left), getH(tree.right)) + 1;
            return r;
        }

        private Node LL(Node tree) {
            Node l = tree.left;
            tree.left = l.right;
            l.right = tree;
            tree.h = Math.max(getH(tree.left), getH(tree.right)) + 1;
            l.h = Math.max(getH(l.left), tree.h) + 1;
            return l;
        }
    }
}
