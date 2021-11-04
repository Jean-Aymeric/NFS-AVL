package com.jad.bst;

public class AVL<T> extends AbstractBST<T, AVLNode<T>> {
    private static int left = 1;
    private static int right = 2;

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

    private final void rotate(AVLNode<T> pivot, int leftOrRight) {
        if ((this.getRoot() != null) && (pivot != null)
                && (((leftOrRight == AVL.left) && (pivot.getRight() != null))
                    || ((leftOrRight == AVL.right) && (pivot.getLeft() != null))) ) {
            AVLNode<T> newRoot = null;
            AVLNode<T> temporaryNode = (leftOrRight == AVL.left) ? pivot.getRight() : pivot.getLeft();
            if (pivot == this.getRoot()) {
                newRoot = temporaryNode;
            }
            if (pivot.getParent() != null) {
                if (pivot.getParent().getLeft() == pivot) {
                    pivot.getParent().setLeft(temporaryNode);
                } else {
                    pivot.getParent().setRight(temporaryNode);
                }
            }
            if (leftOrRight == AVL.left) {
                pivot.setRight(temporaryNode.getLeft());
                temporaryNode.setLeft(pivot);
            } else {
                pivot.setLeft(temporaryNode.getRight());
                temporaryNode.setRight(pivot);
            }
            if (newRoot != null) {
                this.setRoot(newRoot);
               newRoot.setParent(null);
            }
        }
    }

    public final void rotateLeft(AVLNode<T> pivot) {
        this.rotate(pivot, AVL.left);
    }

    public final void rotateRight(AVLNode<T> pivot) {
        this.rotate(pivot, AVL.right);
    }
}
