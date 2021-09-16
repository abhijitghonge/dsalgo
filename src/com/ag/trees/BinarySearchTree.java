package com.ag.trees;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BinarySearchTree {


    private Node<Integer> root = null;


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        tree.traverse(new PrintVisitor<Integer>(), tree.root);
        System.out.println(tree.lookup(56));
        System.out.println(tree.lookup(59));
        System.out.println(tree.validate());
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public boolean insert(Integer value) {
        Node<Integer> newNode = new Node<>(value);
        if (isNull(root)) {
            root = newNode;
            return true;
        }
        Node<Integer> current = root;
        Pair<Node<Integer>, Boolean> result = innerLookup(current, value);
        if (Boolean.TRUE == result.getValue()) return true;
        current = result.getKey();

        if (newNode.value > current.value) {
            current.right = newNode;
        } else if (newNode.value < current.value) {
            current.left = newNode;
        } else {
            return true;
        }

        return false;
    }

    public boolean validate(){
        if(isNull(root)) return true;

        Queue<Node<Integer>> workQueue = new LinkedList<>();
        workQueue.offer(root);
        while(!workQueue.isEmpty()){
            Node<Integer> current = workQueue.poll();
            if(nonNull(current.getLeft()) ){
                if(current.value < current.getLeft().value) {
                    return false;
                }else{
                    workQueue.offer(current.getLeft());
                }
            }

            if(nonNull(current.getRight()) ){
                if(current.value > current.getRight().value) {
                    return false;
                }else{
                    workQueue.offer(current.getRight());
                }
            }

        }

        return true;
    }




    private boolean isLeaf(Node<Integer> current) {
        return isNull(current.left) && isNull(current.right);
    }

    private Pair<Node<Integer>, Boolean> innerLookup(Node<Integer> current, Integer value) {
        if (isNull(root)) {
            return new Pair<>(null, false);
        }
        while (!isLeaf(current)) {
            if (value > current.value && nonNull(current.right)) {
                //traverse right
                current = current.right;
            } else if (value < current.value && nonNull(current.left)) {
                //traverse right
                current = current.left;
            } else {
                return new Pair<>(current, (value == current.value));
            }
        }

        return new Pair<>(current, (value == current.value));
    }

    public boolean lookup(Integer value) {

        return innerLookup(root, value).getValue();
    }

    //Inorder
    public void traverse(Visitor<Node<Integer>> visitor, Node<Integer> current) {

        if (current == null) {
            current = this.root;
        }

        //traverse left node
        if (nonNull(current.left)) {
            traverse(visitor, current.left);
        }
        //Visit current node
        visitor.visit(current);
        //traverse right node
        if (nonNull(current.right)) {
            traverse(visitor, current.right);
        }


    }


    public static class Node<T> {
        private final T value;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }

        public boolean isLeaf(){
            return isNull(this.left) && isNull(this.right);
        }

        public boolean isNotLeaf(){
            return !isNull(this.left) || !isNull(this.right);
        }

    }
}
