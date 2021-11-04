package com.jad.bst;

public class BinaryNode<T> extends AbstractBinaryNode<T, BinaryNode<T>>{
    public BinaryNode(final int index, final T data) {
        super(index, data);
    }

    @Override
    protected void setLeftExtended(final BinaryNode<T> left) {}

    @Override
    protected void setRightExtended(final BinaryNode<T> right) {}

    @Override
    public BinaryNode<T> getNewNode(final int index, final T data) {
        return new BinaryNode<>(index, data);
    }
}
