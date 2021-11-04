package com.jad.bst;

import java.awt.*;
import java.util.List;
import java.util.ListIterator;

public class AVL<T> extends AbstractBST<T, AVLNode<T>> {
    @Override
    protected AVLNode<T> getNewNode(final int index, final T data) {
        return new AVLNode<>(index, data);
    }

    public final int getBalanceFactor(AVLNode<T> node) {
        return (node == null) ? 0 : this.getHeight(node.getRight()) - this.getHeight(node.getLeft());
    }

    private String getAllBalanceFactorsByNode(AVLNode<T> node) {
        StringBuilder stringToReturn = new StringBuilder();
        stringToReturn.append(this.getBalanceFactor(node));
        if (node.getLeft() != null) {
            stringToReturn.append(" -> (").append(getAllBalanceFactorsByNode(node.getLeft())).append(")");
        }
        if (node.getRight() != null) {
            stringToReturn.append(" -> [").append(getAllBalanceFactorsByNode(node.getRight())).append("]");
        }
        return stringToReturn.toString();
    }

    public final String getAllBalanceFactors() {
        return this.getAllBalanceFactorsByNode(this.getRoot());
    }
}
