package com.template.N20_ExpressionBST;

import java.util.Stack;

class BET{
            NodeTree root;

            public void parse(String exp) {
                String tempExp = exp;
                Stack<NodeTree> s = new Stack<>();
                int index = 0;
                char p;
                while(index < (tempExp.length())){
                    p = tempExp.charAt(index);
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
                    index++;
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
                if (node==null) {
                    return 0;
                }
                switch (node.value){
//                    case '-':
//                        return evaluate(node.leftNode) - evaluate(node.leftNode);
                    case '+':
                        return evaluate(node.leftNode) + evaluate(node.leftNode);
                    case '*':
                        return evaluate(node.leftNode) * evaluate(node.leftNode);
                    case '/':
                        return evaluate(node.leftNode) / evaluate(node.leftNode);
                    default:
                        return node.value - '0';//看清楚。这里是字符"0"并非数字零（字节码不一样的）
                }

            }
        }