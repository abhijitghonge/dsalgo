package com.ag.trees;


import com.ag.lld.parkinglot.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        tree.insert(200);
        tree.insert(15);
        tree.insert(1);

        tree.traverse(new PrintVisitor<Integer>(), tree.root);
        System.out.println(tree.lookup(56));
        System.out.println(tree.lookup(59));
        System.out.println(tree.validate());
        System.out.println(tree.maxDepth(tree.root));
        System.out.println(tree.maxDepthRecur(tree.root));
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public int maxDepth(Node<Integer> root){
        if(root == null) return 0;
        if(isLeaf(root)) return 1;
        int depth = 0;
        Queue<Node<Integer>> workQueue = new LinkedList<>();
        workQueue.offer(root);
        while(!workQueue.isEmpty()){
            depth++;
            int i = 0;
            List<Node<Integer>> nodeList = new ArrayList<>(workQueue.size());
            while(!workQueue.isEmpty()){
                nodeList.add(workQueue.poll());
            }
            nodeList.forEach(node->{
                if(nonNull(node.left)) workQueue.offer(node.left);
                if(nonNull(node.right)) workQueue.offer(node.right);

            });
        }

        return depth;
    }

    public int maxDepthRecur(Node<Integer> root){
        if(isNull(root)) return 0;
        if(root.isLeaf()) return 1;

        int depth = 1;
        return  depth + Math.max(maxDepthRecur(root.left), maxDepthRecur(root.right));

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
