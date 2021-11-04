package com.jad.bst;

import java.util.ArrayList;

public class BinaryNode<T> {
    private final int index;
    private final ArrayList<T> data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(int index, final T data) {
        this.index = index;
        this.data = new ArrayList<>();
        this.data.add(data);
        this.left = null;
        this.right = null;
    }

    protected final BinaryNode<T> getLeft() {
        return left;
    }

    protected final void setLeft(final BinaryNode<T> left) {
        this.left = left;
    }

    protected final BinaryNode<T> getRight() {
        return right;
    }

    protected final void setRight(final BinaryNode<T> right) {
        this.right = right;
    }

    protected final int getIndex() {
        return index;
    }

    public final ArrayList<T> getDataList() {
        return new ArrayList<>(this.data);
    }

    public final void addData(int index, final T data) {
        if (this.getIndex() == index) {
            this.data.add(data);
        } else if (this.getIndex() > index) {
            if (this.getLeft() == null) {
                this.setLeft(new BinaryNode<>(index, data));
            } else {
                this.getLeft().addData(index, data);
            }
        } else {
            if (this.getRight() == null) {
                this.setRight(new BinaryNode<>(index, data));
            } else {
                this.getRight().addData(index, data);
            }
        }
    }

    public final String getIndexMap() {
        String stringToReturn = String.valueOf(this.getIndex());
        if (this.getLeft() != null) {
            stringToReturn += " -> (" + this.getLeft().getIndexMap() + ")";
        }
        if (this.getRight() != null) {
            stringToReturn += " -> [" + this.getRight().getIndexMap() + "]";
        }
        return stringToReturn;
    }

    public final ArrayList<T> getDataListByIndex(int index) {
        if (this.getIndex() == index) {
            return this.getDataList();
        }
        if (this.getIndex() > index) {
            return this.getLeft() == null ? null : this.getLeft().getDataListByIndex(index);
         } else {
            return this.getRight() == null ? null : this.getRight().getDataListByIndex(index);
        }
    }

    public final boolean isIndexExist(int index) {
        if (this.getIndex() == index) {
            return true;
        }
        if (this.getIndex() > index) {
            return (this.getLeft() != null) && this.getLeft().isIndexExist(index);
        } else {
            return (this.getRight() != null) && this.getRight().isIndexExist(index);
        }
    }
}
