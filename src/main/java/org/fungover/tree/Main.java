package org.fungover.tree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(6);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        System.out.println(tree.existsDFSPreOrder(7));
        System.out.println(tree.existsBFS(7));
        System.out.println(tree.existsBFS(11));
    }
}
