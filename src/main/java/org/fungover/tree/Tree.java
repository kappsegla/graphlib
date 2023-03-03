package org.fungover.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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
                }
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                if (currentNode.right == null) {
                    currentNode.right = new Node(value);
                    return;
                }
                currentNode = currentNode.right;
            } else {
                //Already stored?
                return;
            }
        }
    }

    public boolean existsDFSPreOrder(int i) {
        return contains(root, i);
    }

    private boolean contains(Node current, int value) {
        if (current == null)
            return false;
        if (value == current.value)
            return true;
        if (value < current.value)
            return contains(current.left, value);
        else
            return contains(current.right, value);
    }

    public boolean existsBFS(int value) {
        Queue<Node> queue = new LinkedList<>();
        //Add root to queue
        if (root != null)
            queue.add(root);

        while (queue.size() > 0) {
            //Get first item from queue
            Node currentNode = queue.remove();

            //Check if value == currentNode.value, then return true
            if (value == currentNode.value)
                return true;
            //Add all non null childs to queue
            if( currentNode.left != null)
                queue.add(currentNode.left);
            if( currentNode.right != null)
                queue.add(currentNode.right);
        }
        return false;
    }
}
