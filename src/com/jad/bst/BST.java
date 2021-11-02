package com.jad.bst;

import java.util.ArrayList;

public class BST<T> {
    private BinaryNode<T> root;

    public BST() {
        this.root = null;
    }

    public void addData(int index, T data) {
        if (this.root == null) {
            this.root = new BinaryNode<>(index, data);
        } else {
            this.root.addData(index, data);
        }
    }

    public ArrayList<T> getDataListByIndex(int index) {
        return (this.root == null) ? null : this.root.getDataListByIndex(index);
    }

    public String getIndexMap() {
        return (this.root == null) ? null : this.root.getIndexMap();
    }

    public boolean isIndexExist(int index) {
        return this.root != null && this.root.isIndexExist(index);
    }
}
