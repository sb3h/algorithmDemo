package com.template.N19_Queue;

/**
 * Created by huanghh on 2017/5/9.
 */

public class N19_Queue {


    class Queue<T>{
        T[] data;
        int head,tail,size,dataLen;

        public Queue(int dataLen) {
            this.dataLen = dataLen;
            data = (T[]) new Object[dataLen];
        }
//--------------------------------初始化动作-----------------------------------
        //--------------------------------查询动作-----------------------------------

        public void push(T value) throws Exception {
            if (size == dataLen){
                throw new Exception("queue is full");
            }
            data[head] = value;
            head = (head + 1)%dataLen;//为了形成一个闭环下标
            size++;
        }

        public void pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("queue is empty");
            }
            tail = (tail + 1)%dataLen;//为了形成一个闭环下标
            size--;
        }
        //--------------------------------添删动作-----------------------------------

        private boolean isEmpty() {
            return size == 0;
        }

        public T top() throws Exception {
            if (isEmpty()) {
                throw new Exception("you cannot get the top element from an empty queue");
            }
            //因为先进先出的原因，导致弹出是从尾部进行
            return data[tail];
        }

    }

    public static void main(String[] args) {

    }
}
