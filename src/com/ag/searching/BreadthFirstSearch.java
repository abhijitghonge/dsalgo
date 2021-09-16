package com.ag.searching;

import com.ag.trees.BinarySearchTree;
import com.ag.trees.BinarySearchTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Objects.isNull;

public class BreadthFirstSearch {
    private Queue<Node<Integer>> visitQueue = new LinkedList<>();

    public List<Integer> getResult() {
        return result;
    }

    private List<Integer> result = new ArrayList<>();


    public BreadthFirstSearch(Node<Integer> root) {
        this.visitQueue.offer(root);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

//        breadthFirstSearch(tree.getRoot()).forEach(System.out::println);
        BreadthFirstSearch bfs = new BreadthFirstSearch(tree.getRoot());
        bfs.recursiveBFS();
        bfs.getResult().forEach(System.out::println);

    }

    public static List<Integer> breadthFirstSearch(Node<Integer> root) {
        if (root == null) return new ArrayList<>();

        List<Integer> numberList = new ArrayList<>();
        Queue<Node<Integer>> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            Node<Integer> current = queue.remove();
            numberList.add(current.getValue());
            if(!isNull(current.getLeft())){
                queue.offer(current.getLeft());
            }
            if(!isNull(current.getRight())){
                queue.offer(current.getRight());
            }

        }

        return numberList;
    }

    public void recursiveBFS(){
        if(visitQueue.isEmpty()){
            return;
        }

        Node<Integer> current = visitQueue.remove();
        result.add(current.getValue());
        if(!isNull(current.getLeft())){
            visitQueue.offer(current.getLeft());
        }
        if(!isNull(current.getRight())){
            visitQueue.offer(current.getRight());
        }
        recursiveBFS();
    }
}
