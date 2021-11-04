package com.jad.bst;

public class AVLNode<T> extends AbstractBinaryNode<T, AVLNode<T>> {
    private AVLNode<T> parent;

    public AVLNode(final int index, final T data) {
        super(index, data);
        this.parent = null;
    }

    @Override
    protected void setLeftExtended(final AVLNode<T> left) {
        if (left != null) {
            left.setParent(this);
        }
    }

    @Override
    protected void setRightExtended(final AVLNode<T> right) {
        if (right != null) {
            right.setParent(this);
        }
    }

    @Override
    public AVLNode<T> getNewNode(final int index, final T data) {
        return new AVLNode<>(index, data);
    }

    protected final AVLNode<T> getParent() {
        return parent;
    }

    protected final void setParent(final AVLNode<T> parent) {
        if (parent != null) {
            if (parent.getLeft() != this && parent.getRight() != this) {
                try {
                    throw new Exception("Link's AVL Node error.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.parent = parent;
    }
}
