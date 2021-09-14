package com.ag.stacks;

public class Queue <T>{

    private Stack<T> pushStack = new Stack<>();

    private Stack<T> popStack = new Stack<>();

    public static void main(String[] args) {
        Queue<String> que = new Queue<>();

        que.enqueue("Google");
        que.enqueue("Udemy");
        que.enqueue("Minio");

        System.out.println(que.dequeue());

    }

    public boolean enqueue(T value){
        if(pushStack.isEmpty()){
            fill(pushStack, popStack);
        }

        return pushStack.push(value);
    }

    public T dequeue(){
        if(popStack.isEmpty()){
            fill(popStack, pushStack);
        }

        return popStack.pop();
    }

    private void fill(Stack<T> toFillStack, Stack<T> fromStack) {
        while(!fromStack.isEmpty()) {
            toFillStack.push(fromStack.pop());
        }
    }

    public T peek(){
        if(popStack.isEmpty()){
            fill(popStack, pushStack);
        }

        return popStack.peek();
    }

}
