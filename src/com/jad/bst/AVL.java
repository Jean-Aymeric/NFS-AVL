package com.jad.bst;

public class AVL<T> extends AbstractBST<T, AVLNode<T>> {
    @Override
    protected AVLNode<T> getNewNode(final int index, final T data) {
        return new AVLNode<>(index, data);
    }
}
