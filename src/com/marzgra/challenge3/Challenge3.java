package com.marzgra.challenge3;

/*
Given the root to a binary tree, implement serialize(root),
which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.

To run code with assertions use -ea run parameter.
 */

public class Challenge3 {

    public static void main(String[] args) {
        Node node = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
        assert node.deserialize(node.serialize()).getLeft().getLeft().getValue().equals("left.left");
    }

}
