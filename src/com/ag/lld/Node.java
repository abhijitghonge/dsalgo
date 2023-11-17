package com.ag.lld;

import java.util.Iterator;
import java.util.Objects;

public class Node implements Iterable<Node>{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next=null;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    @Override
    public Iterator<Node> iterator(){
        return new NodeIterator(this);
    }

    private static class NodeIterator implements Iterator<Node> {
        private Node current;

        public NodeIterator(Node start){
            this.current = start;
        }

        @Override
        public boolean hasNext(){
            return !Objects.isNull(this.current);
        }

        @Override
        public Node next(){
            Node current = this.current;
            this.current = this.current.next;

            return current;
        }
    }
}