package com.ag.stacks;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private final List<T> list = new ArrayList<>();

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Google");
        stack.push("Udemy");
        stack.push("Minio");
        System.out.println(stack.pop());
    }

    public boolean push(T value) {
       return list.add(value);
    }

    public T pop(){
        return list.remove(list.size() - 1);
    }

    public T peek(){
        return list.get(list.size() - 1);
    }

    public boolean isEmpty(){
        return (list.size() == 0);
    }


}
