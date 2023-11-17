package com.ag.lld.iterators;

import java.util.Iterator;

public class Node implements Iterable<Integer>{
    private int data;
    private Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator(this);
    }
    private static class NodeIterator implements Iterator<Integer>{
        private Node current;
        public NodeIterator(Node current){
            this.current = current;
        }
        @Override
        public boolean hasNext() {

            return (current == null);
        }

        @Override
        public Integer next() {
            Node node = current;
            current = current.next;
            return node.data;
        }
    }

}


