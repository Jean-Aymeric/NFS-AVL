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
        this.addDataExtended(index, data);
    }

    public abstract void addDataExtended(int index, T data);

    protected abstract N getNewNode(int index, T data);

    public final ArrayList<T> getDataListByIndex(int index) {
        return (this.root == null) ? null : ((this.getRoot().getIndex() == index) ? this.root.getDataList() : this.root.getDataListByIndex(index));
    }

    public final String getIndexMap() {
        return (this.root == null) ? null : this.root.getIndexMap();
    }

    public final boolean isIndexExist(int index) {
        return this.root != null && this.root.isIndexExist(index);
    }

    public final int getHeight(N node) {
        return (node == null) ? 0 : 1 + Math.max(this.getHeight(node.getLeft()), this.getHeight(node.getRight()));
    }

    public final int getHeight() {
        return this.getHeight(this.root);
    }

    public final N getRoot() {
        return this.root;
    }

    protected final void setRoot(N root) {
        this.root = root;
    }

    public final N getNodeByIndex(int index) {
        return (this.root == null) ? null : ((this.root.getIndex() == index) ? this.root : this.root.getNodeByIndex(index));
    }
}
