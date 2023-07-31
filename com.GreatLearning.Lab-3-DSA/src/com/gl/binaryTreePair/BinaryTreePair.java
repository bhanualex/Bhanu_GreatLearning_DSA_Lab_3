package com.gl.binaryTreePair;

import java.util.Scanner;

class Node {
    int data;
    Node leftNode;
    Node rightNode;

    Node(int x) {
        data = x;
        leftNode = null;
        rightNode = null;
    }
}

class BinarySearchTree {
    Node root;

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.leftNode = insertRec(root.leftNode, data);
        else if (data > root.data)
            root.rightNode = insertRec(root.rightNode, data);
        return root;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    boolean isPairPresent(Node root, Node temp, int target) {
        if (temp == null)
            return false;
        return search(root, temp, target - temp.data) || isPairPresent(root, temp.leftNode, target)
                || isPairPresent(root, temp.rightNode, target);
    }

    boolean search(Node root, Node temp, int k) {
        if (root == null)
            return false;
        Node c = root;
        boolean flag = false;
        while (c != null && flag != true) {
            if (c.data == k && temp != c) {
                flag = true;
                System.out.println("Pair is (" + temp.data + "," + c.data+")");
                return true;
            } else if (k < c.data)
                c = c.leftNode;
            else
                c = c.rightNode;
        }
        return false;
    }
}

public class BinaryTreePair {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(30);
        tree.insert(10);
        tree.insert(20);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        System.out.print("Sum = ");
		Scanner in = new Scanner(System.in);
		int target=in.nextInt();
        boolean test = tree.isPairPresent(tree.root, tree.root,target);
        if (!test)
            System.err.println("Nodes are not found");
        in.close();
    }
}
