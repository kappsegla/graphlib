package org.fungover.tree;

public class Tree {
    Node root;

    public void add(int value) {

        Node currentNode = root;

        if (currentNode == null) {
            root = new Node(value);
            return;
        }

        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(value);
                    return;
                } else currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                if (currentNode.right == null) {
                    currentNode.right = new Node(value);
                    return;
                } else currentNode = currentNode.right;
            } else {
                //Already stored?
                return;
            }
        }
    }
}
