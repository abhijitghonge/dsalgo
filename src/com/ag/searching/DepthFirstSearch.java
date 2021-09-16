package com.ag.searching;

import com.ag.trees.BinarySearchTree;
import com.ag.trees.BinarySearchTree.Node;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class DepthFirstSearch {


    private final List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.inOrder(tree.getRoot());
        System.out.println(dfs.getResult());
    }

    public List<Integer> getResult() {
        return result;
    }


    //inorder
    public void inOrder(Node<Integer> current){

        if(!isNull(current.getLeft())){
            inOrder(current.getLeft());
        }
        result.add(current.getValue());
        if(!isNull(current.getRight())){
            inOrder(current.getRight());
        }

    }

}
