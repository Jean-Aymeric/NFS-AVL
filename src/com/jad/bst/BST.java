package com.jad.bst;

public class BST<T> extends AbstractBST<T, BinaryNode<T>> {
    @Override
    protected BinaryNode<T> getNewNode(final int index, final T data) {
        return new BinaryNode<>(index, data);
    }
}
