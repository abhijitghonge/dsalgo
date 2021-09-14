package com.ag.trees;

import com.ag.trees.BinarySearchTree.Node;

public class PrintVisitor<T> implements Visitor<Node<T>> {
    @Override
    public void visit(Node<T> node) {
        System.out.println(node.getValue());
    }
}
