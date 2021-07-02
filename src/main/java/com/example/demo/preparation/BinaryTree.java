package com.example.demo.preparation;

public class BinaryTree implements BinaryTreeFunctions {
    Node rootNode;

    @Override
    public Node insert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = insert(currentNode.right, value);
        } else {
            return currentNode;
        }

        return currentNode;
    }

    @Override
    public void find(int value) {

    }

    public void insert(int value) {
        rootNode = insert(rootNode, value);
    }
}
