package com.sri.treeimplementation;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {6, 10, 4, 3, 1, 20};
        BSTImplementation bt = new BSTImplementation();

        bt.insert(8);
        bt.insertAll(arr);
        bt.inOrderTraversal();
        System.out.println(bt.find(10));
        bt.delete(10);
        System.out.println(bt.find(10));
        bt.inOrderTraversal();
        System.out.println("\n***********");
        bt.preOrderTraversal();
        System.out.println("\n***********");
        bt.postOrderTraversal();

    }
}
