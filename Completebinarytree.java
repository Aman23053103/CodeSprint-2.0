import java.util.*;

public class Completebinarytree {
    static class treenode {
        int val;
        treenode left, right;

        treenode(int val) {
            this.val = val;
        }
    }

    public static treenode buildtree(List<String> nodes) {
        if (nodes == null || nodes.isEmpty() || nodes.get(0) == null)
            return null;
        treenode root = new treenode(Integer.parseInt(nodes.get(0)));
        Queue<treenode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < nodes.size()) {
            treenode current = queue.poll();
            if (i < nodes.size() && nodes.get(i) != null) {
                current.left = new treenode(Integer.parseInt(nodes.get(i)));
                queue.offer(current.left);
            }
            i++;
            if (i < nodes.size() && nodes.get(i) != null) {
                current.right = new treenode(Integer.parseInt(nodes.get(i)));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static int countnodes(treenode root) {
        if (root == null)
            return 0;
        int leftheight = getleftheight(root);
        int rightheight = getrightheight(root);
        if (leftheight == rightheight) {
            return (1 << leftheight) - 1;
        } else {
            return 1 + countnodes(root.left) + countnodes(root.right);
        }
    }

    private static int getleftheight(treenode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private static int getrightheight(treenode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the tree in level order: ");
        String line = sc.nextLine();
        List<String> input = Arrays.asList(line.trim().split("\\s+"));
        treenode root = buildtree(input);
        int result = countnodes(root);
        System.out.println("Number of nodes: " + result);
    }
}