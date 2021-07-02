package com.example.demo.preparation;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.start();
    }

    private void start() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(7);
        binaryTree.insert(3);
        binaryTree.insert(9);
        binaryTree.insert(12);
    }
}
