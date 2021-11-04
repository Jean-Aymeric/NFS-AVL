package com.jad.bst;

import java.util.ArrayList;

public abstract class AbstractBST<T, N extends AbstractBinaryNode<T, N>> {
    private N root;

    public AbstractBST() {
        this.root = null;
    }

    public final void addData(int index, final T data) {
        if (this.root == null) {
            this.root = this.getNewNode(index, data);
        } else {
            this.root.addData(index, data);
        }
    }

    protected abstract N getNewNode(int index, T data);

    public final ArrayList<T> getDataListByIndex(int index) {
        return (this.root == null) ? null : this.root.getDataListByIndex(index);
    }

    public final String getIndexMap() {
        return (this.root == null) ? null : this.root.getIndexMap();
    }

    public final boolean isIndexExist(int index) {
        return this.root != null && this.root.isIndexExist(index);
    }
}
