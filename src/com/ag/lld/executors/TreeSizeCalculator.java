package com.ag.lld.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    ExecutorService service;
    TreeNode root;
    public TreeSizeCalculator(TreeNode root, ExecutorService service){
        this.root = root;
        this.service = service;
    }

    @Override
    public Integer call() throws Exception {
        return sizeOf(root);
    }

    private int sizeOf(TreeNode node) throws ExecutionException, InterruptedException {
        if(node == null){
            return 0;
        }

        Future<Integer> leftTree = service.submit(new TreeSizeCalculator(node.left, service));

        Future<Integer> rightTree =  service.submit(new TreeSizeCalculator(node.right, service));

        return leftTree.get()+ rightTree.get() + 1;

    }
}
