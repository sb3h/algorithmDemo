package com.template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by huanghh on 2017/5/9.
 */

public class N18_BST {

    /**
     * 栈，有头无尾
     * @param <T>
     */
    static class Stack<T>{

        class Node<T>{
            Node next;
            T payload;

            public Node(T payload){
                this.payload = payload;
            }
        }

        Node<T> head;

        public Stack(){
            head = null;
        }
        //--------------------------------初始化动作-----------------------------------
        public void init(){

        }
        //--------------------------------查询动作-----------------------------------
        public T top() throws Exception {
            if (isEmpty()) {
                throw new Exception("you cannot get the top element from an empty stack");
            }
            return head.payload;
        }

        public boolean isEmpty(){
            return head == null;
        }
        //--------------------------------添删动作-----------------------------------

        /**
         * 推进来
         * @throws Exception
         */
        public void push(T value){
            /*
            因为头部肯定是最顶部的，
            所以只需要把头部位置和新的节点接上就好了
            */
            Node<T> newNode = new Node<T>(value);
            newNode.next = head;
            head = newNode;
        }

        /**
         * 弹出去
         * @throws Exception
         */
        public void pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("you cannot pop an element from an empty stack");
            }
            Node temp = head;
            head = head.next;
            temp = null;
        }
    }

    public static class BinarySearchTree{

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

        NodeTree rootNode;
        /**
         * 根据“值”得大小，逐层遍历到相应位置，再进行添加节点
         * @param value
         * @param position
         * @param node
         */
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

        /**
         * 通过比较大小进行，左右对比，查询到目的位置
         * @param searchVal
         * @param nodeTree
         * @return
         */
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

        /**
         * 搜索
         * @param searchVal
         * @return
         */
        public int search(int searchVal) {
            return search(searchVal,rootNode);
        }

        /***
         * 深度"优先"搜索
         * @param nodeTree
         */
        private void traval(NodeTree nodeTree) {
            if (nodeTree==null){
                return;
            }
//            proOrder(nodeTree);

            midOrder(nodeTree);
//
//            ordered(nodeTree);


        }

        /**
         * 后序
         * @param nodeTree
         */
        private void ordered(NodeTree nodeTree) {
            Stack<NodeTree> s = new Stack<>();
            NodeTree currentNode = nodeTree;
            List<Integer> list = new ArrayList<>();
            while (currentNode!=null){

                if (!nodeTree.equals(currentNode)) {
                    list.add(currentNode.value);
//                    System.out.println(currentNode.value);
                }//与前序不一样，把right与left互换
                NodeTree pushNode = currentNode.leftNode;
                if (pushNode!=null) {
                    s.push(pushNode);
                }
                NodeTree currentNodeMaybe = currentNode.rightNode;
                if (currentNodeMaybe!=null) {
                    currentNode = currentNodeMaybe;
                }else {
                    if (s.isEmpty()) {
                        currentNode = null;
//                        list.add(nodeTree.value);
//                        System.out.println(nodeTree.value);
                    }else{
                        try {
                            currentNode = s.top();
                            s.pop();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
            Collections.reverse(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            //最后才打印
            System.out.println(nodeTree.value);

        }
        /**
         * 中序
         * @param nodeTree 因为不懂，所以没有写出“栈”的中序
         */
        private void midOrder(NodeTree nodeTree) {
//            ordered(nodeTree.leftNode);

//            midOrder(nodeTree.rightNode);
//            System.out.println(nodeTree.value);
////
//            proOrder(nodeTree.rightNode);
        }

        /**
         * 前序
         * @param nodeTree
         */
        private void proOrder(NodeTree nodeTree) {
            Stack<NodeTree> s = new Stack<>();
            NodeTree currentNode = nodeTree;
            while (currentNode!=null){
                System.out.println(currentNode.value);
                NodeTree pushNode = currentNode.rightNode;
                if (pushNode!=null) {
                    s.push(pushNode);
                }
                NodeTree currentNodeMaybe = currentNode.leftNode;
                if (currentNodeMaybe!=null) {
                    currentNode = currentNodeMaybe;
                }else {
                    if (s.isEmpty()) {
                        currentNode = null;
                    }else{
                        try {
                            currentNode = s.top();
                            s.pop();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

        }
        /**
         * 深度优先搜索
         */
        private void traval() {
            traval(rootNode);
        }

        /**
         * 找出根节点，到最低部的层数
         * @return
         */
        private int depth() {
            return depth(rootNode);
        }

        /**
         * 通过根节点“左右层数”对比得到
         * 最后的深度层数
         * @param nodeTree
         * @return
         */
        private int depth(NodeTree nodeTree) {
            if (nodeTree == null) {
                return 0;
            }
            int leftDepth = depth(nodeTree.leftNode);
            int rightDepth = depth(nodeTree.rightNode);
            return Math.max(leftDepth,rightDepth) +1;//+1?
        }

        /**
         * 逐层遍历
         */
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
    }

    public static void main(String[] args) throws Exception {
       BinarySearchTree bst = new BinarySearchTree();
        int[] testData = {3,4,2,1,7,5,8,9,0,6};
        for (int i = 0; i < testData.length; i++) {
            bst.addNode(testData[i],i);
        }

        bst.traval();
    }
}
