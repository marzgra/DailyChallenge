package com.marzgra;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Given the root to a binary tree, implement serialize(root),
which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.

To run code with assertions use -ea run parameter.
 */

public class Challenge3 {
    private static final String DELIMITER = ",";
    private static final String EMPTY_NODE = "#";

    static class Node {
        private String value = null;
        private Node left = null;
        private Node right = null;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(String value) {
            this.value = value;
        }

        public String serialize() {
            ArrayList<String> list = new ArrayList<>();
            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(this);

            while (!queue.isEmpty()) {
                Node current = queue.pop();
                if (current == null) {
                    list.add(EMPTY_NODE);
                } else {
                    list.add(current.value);
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
            return String.join(DELIMITER, list);
        }

        public Node deserialize(String tree) {
            String[] values = tree.split(DELIMITER);
            if (values[0].equals(EMPTY_NODE)) {
                return null;
            }

            Node root = new Node(values[0]);
            LinkedList<Node> nodes = new LinkedList<>();
            nodes.offer(root);

            int i = 1;

            while (!nodes.isEmpty()) {
                Node h = nodes.poll();
                if (h != null) {
                    Node left = null;
                    if (!values[i].equals(EMPTY_NODE)) {
                        left = new Node(values[i]);
                    }
                    h.left = left;
                    nodes.offer(left);
                    i++;

                    Node right = null;
                    if (!values[i].equals(EMPTY_NODE)) {
                        right = new Node(values[i]);
                    }
                    h.right = right;
                    nodes.offer(right);
                    i++;
                }
            }

            return root;
        }
    }

    public static void main(String[] args) {
        Node node = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
        assert node.deserialize(node.serialize()).left.left.value.equals("left.left");
    }
}
