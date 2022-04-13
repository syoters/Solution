//        Charset w1251 = Charset.forName("Windows-1251");
//        args = new String[]{"C:\\someFile3.txt", "C:\\someFile1.txt", "C:\\someFile2.txt"};
//        Scanner in = new Scanner(System.in);
//        for (int i = 0; i < 2; i++) args[i] = in.nextLine();
//        args = new String[]{"C:\\someFile3.txt", "C:\\someFile1.txt", "C:\\someFile2.txt"};
//        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
//            for (int i = 0; i < 2; i++) args[i] = bf.readLine();}
//        String fileName;
//        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
//        fileName = bf.readLine();}

//<pre class='language-java line-numbers'><code>
//
//</code></pre>

//"jopa".chars().map(c -> c + '1').toArray()

//while (b != 0) b = a % (a = b);  // нод
//return a;

package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long t = new Date().getTime();
        new Main().run();
        System.out.println(new Date().getTime() - t + " ms");
    }

    private void run() throws IOException {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode z = new TreeNode(1, new TreeNode(2), new TreeNode());
        TreeNode z1 = new TreeNode(1, new TreeNode(), new TreeNode(2));

        System.out.println(isSameTree(p, q));
        System.out.println(isSameTree(p, z));
        System.out.println(isSameTree(z, z1));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) return false;
        return p == q || p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d, %d]", val, left.val, right.val);
        }
    }

}

