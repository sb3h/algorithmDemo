package com.template;

import java.util.Stack;

/**
 * Created by huanghh on 2017/5/9.
 */

public class N20_ExpressionBST {
    private static class BinarySearchTree{

        class BET{
            NodeTree root;

            public void parse(char exp ) {
                char p = exp;
                Stack<NodeTree> s = new Stack<>();
                while(p != '\0'){
                    if (p >= '0'
                            &&p <= '9'
                            ){
                        s.push(new NodeTree(p));
                    }else{
                        NodeTree newNode = new NodeTree(p);
                        newNode.rightNode = s.peek();
                        s.pop();
                        newNode.leftNode = s.peek();
                        s.pop();
                        s.push(newNode);
                    }
                    p++;
                }
                if (s.size()!=1) {
                    System.out.println("Illegal Expression");
                    root = null;
                }else{
                    root = s.peek();
                }
            }

            public int evaluate( ) {
//                if (root == null) {
//                    return
//                }
                return evaluate(root);
            }

            private int evaluate(NodeTree node) {
                switch (node.value){
                    case '-':
                        return evaluate(node.leftNode) - evaluate(node.leftNode);
                    case '+':
                        return evaluate(node.leftNode) + evaluate(node.leftNode);
                    case '*':
                        return evaluate(node.leftNode) * evaluate(node.leftNode);
                    case '/':
                        return evaluate(node.leftNode) / evaluate(node.leftNode);
                }
                return node.value - 0;
            }
        }

        class NodeTree{
            NodeTree leftNode, rightNode;
            char value;//因为要接受操作符号"+-*/"

            public NodeTree(char value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return "NodeTree{" +
                        "leftNode=" + leftNode +
                        ", rightNode=" + rightNode +
                        ", value=" + value +
                        '}';
            }
        }

        NodeTree rootNode;
        /**
         * 根据“值”得大小，逐层遍历到相应位置，再进行添加节点
         * @param value
         * @param node
         */
        private void addNode(char value,NodeTree node) {
            if (value > node.value) {
                if (node.rightNode != null) {
                    addNode(value);
                }else {
                    node.rightNode = new NodeTree(value);
                }
            }else if(value < node.value){
                if (node.leftNode != null) {
                    addNode(value);
                }else {
                    node.leftNode = new NodeTree(value);
                }
            }
        }

        /**
         * 初始化根节点或者添加子节点
         * @param value
         */
        public void addNode(char value) {
            if (rootNode == null) {
                rootNode = new NodeTree(value);
            }else{
                addNode(value,rootNode);
            }
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
//        ordered(nodeTree);


        }

        /**
         * 后序
         * @param nodeTree
         */
        private void ordered(NodeTree nodeTree) {
            traval(nodeTree.leftNode);
            traval(nodeTree.rightNode);
            System.out.println(nodeTree.value);
        }
        /**
         * 中序
         * @param nodeTree
         */
        private void midOrder(NodeTree nodeTree) {
            traval(nodeTree.leftNode);
            System.out.println(nodeTree.value);
            traval(nodeTree.rightNode);
        }

        /**
         * 前序
         * @param nodeTree
         */
        private void proOrder(NodeTree nodeTree) {
            System.out.println(nodeTree.value);
            traval(nodeTree.leftNode);
            traval(nodeTree.rightNode);
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
    //--------------------------------初始化动作-----------------------------------
    //--------------------------------查询动作-----------------------------------
    //--------------------------------添删动作-----------------------------------



    public static void main(String[] args) {

    }
}
