package com.template;

import javax.swing.tree.TreeNode;

/**
 * Created by huanghh on 2017/3/21.
 */
public class BinarySearchTree {
    NodeTree rootNode;

    class NodeTree{
        NodeTree leftNode, rightNode;
        int value;
        int position;

        public NodeTree(int value, int position) {
            this.value = value;
            this.position = position;
        }

        @Override
        public String toString() {
            return "NodeTree{" +
                    "leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    ", value=" + value +
                    ", position=" + position +
                    '}';
        }
    }

    private void addNode(int value, int position,NodeTree node) {
        if (value > node.value) {
            if (node.rightNode != null) {
                addNode(value,position,node.rightNode);
            }else {
                node.rightNode = new NodeTree(value,position);
            }
        }else if(value < node.value){
            if (node.leftNode != null) {
                addNode(value,position,node.leftNode);
            }else {
                node.leftNode = new NodeTree(value,position);
            }
        }
    }

    /**
     * 初始化根节点或者添加子节点
     * @param value
     * @param position
     */
    public void addNode(int value, int position) {
        if (rootNode == null) {
            rootNode = new NodeTree(value,position);
        }else{
            addNode(value,position,rootNode);
        }
    }


    private int search(int searchVal,NodeTree nodeTree) {

        if (nodeTree == null) {
            return -1;
        }else
//        System.out.println(nodeTree);
//        System.out.println();
        if (nodeTree == null){
            return nodeTree.position;
        }else if (nodeTree.value > searchVal) {
            return search(searchVal,nodeTree.leftNode);
        }else if (nodeTree.value < searchVal){
            return search(searchVal,nodeTree.rightNode);
        }else{
            return nodeTree.position;
        }
    }

    public int search(int searchVal) {
        return search(searchVal,rootNode);
    }
    private void traval(NodeTree nodeTree) {
        if (nodeTree==null){
            return;
        }
        traval(nodeTree.leftNode);
        System.out.println(nodeTree.value);
        traval(nodeTree.rightNode);


    }

    private void traval() {
        traval(rootNode);
    }

    private int depth() {
        return depth(rootNode);
    }

    private int depth(NodeTree nodeTree) {
        if (nodeTree == null) {
            return 0;
        }
        int leftDepth = depth(nodeTree.leftNode);
        int rightDepth = depth(nodeTree.rightNode);
        return Math.max(leftDepth,rightDepth) +1;//+1?
    }

    private void levelOrder() {
        int depth = depth();
        System.out.println("depth:"+depth);
        for (int level = 0; level < depth; level++) {
            printLevel(rootNode,level);
            System.out.println("--------------------------------------");
        }
    }

    private void printLevel(NodeTree node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            System.out.println(" " + node.value);
        }else{
            printLevel(node.leftNode,level-1);
            printLevel(node.rightNode,level-1);
        }
    }







    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] testData = {3,4,2,1,7,5,8,9,0,6};
        for (int i = 0; i < testData.length; i++) {
            binarySearchTree.addNode(testData[i],i);
        }

        binarySearchTree.levelOrder();
//        binarySearchTree.traval();
//        System.out.println(binarySearchTree.search(8));
//        System.out.println(binarySearchTree.search(3));
//        System.out.println(binarySearchTree.search(6));
//        System.out.println(binarySearchTree.search(30));

    }




}
