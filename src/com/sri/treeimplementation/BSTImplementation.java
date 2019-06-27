package com.sri.treeimplementation;

public class BSTImplementation {
    BSTNode root;

    BSTImplementation(){
        this.root = null;
    }

    class BSTNode {
        BSTNode left, right;
        int data;

        BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int value){
            root = insertRec(root, value);
    }

    private BSTNode insertRec(BSTNode root, int value){
            if(root == null){
                root = new BSTNode(value);
                return root;
            }
            if(value < root.data){
                root.left = insertRec(root.left, value);
            }else if(value > root.data){
                root.right = insertRec(root.right,value);
            }
            return root;
    }

    public void insertAll(int[] arr){
            for(int i = 0; i < arr.length; i++){
                insert(arr[i]);
            }

    }

    public boolean find(int value){
        return findRec(root,value);
    }

    private boolean findRec(BSTNode root, int value) {
        if(root == null){
            return false;
        }
        if(value < root.data){
            if(root.left == null){
                return false;
            }else{
                return findRec(root.left,value);
            }
        }else if(value > root.data){
            if(root.right == null){
                return false;
            }else{
                return findRec(root.right, value);
            }
        }else{
            return true;
        }
    }

    public void delete(int value){
        root = deleteRec(root, value);
    }

    private BSTNode deleteRec(BSTNode root, int value) {
        if(root == null) return root;
        if(value < root.data){
            root.left = deleteRec(root.left, value);
        }else if(value > root.data){
            root.right = deleteRec(root.right, value);
        }else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            root.data = minValue(root.right);
            root.right = deleteRec(root.right,root.data);
        }return root;
    }

    private int minValue(BSTNode root) {
        int minVal = root.data;
        if(root.left != null){
            minVal = root.left.data;
            root = root.left;
        }return minVal;
    }

    public void inOrderTraversal(){
        inOrder(root);
    }

    private void inOrder(BSTNode root) {
        if(root.left != null){
            inOrder(root.left);
        }
        System.out.print(root.data + " ");
        if(root.right != null){
            inOrder(root.right);
        }
    }

    public void preOrderTraversal(){
        preOrder(root);
    }

    private void preOrder(BSTNode root) {
        System.out.print(root.data + " ");
        if(root.left != null){
            preOrder(root.left);
        }
        if(root.right != null){
            preOrder(root.right);
        }
    }

    public void postOrderTraversal(){
        postOrder(root);
    }

    private void postOrder(BSTNode root) {
        if(root.left != null){
            postOrder(root.left);
        }
        if(root.right != null){
            preOrder(root.right);
        }
        System.out.print(root.data + " ");
    }


}
