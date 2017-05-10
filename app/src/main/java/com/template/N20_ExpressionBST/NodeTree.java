package com.template.N20_ExpressionBST;

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