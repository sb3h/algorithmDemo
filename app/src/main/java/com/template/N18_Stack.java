package com.template;

import java.util.Queue;

/**
 * Created by huanghh on 2017/5/9.
 */

public class N18_Stack {



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

    public static void main(String[] args) throws Exception {
        Stack<String> stack = new Stack();
        stack.push("123");
        stack.pop();
        String topE = stack.top();
        System.out.println(topE);
    }
}
