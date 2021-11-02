package com.jad;

import com.jad.bst.BST;

public class Main {

    public static void main(String[] args) {
        BST<String> myBST = new BST<>();

        for(int i = 0; i < 20;i++) {
            int index = (int) (Math.random()*10);
            StringBuilder data = new StringBuilder();
            for (int j = 0; j < (int) (Math.random() * 256); j++) {
                data.append((char) (Math.random() * 26 + 65));
            }
            myBST.addData(index, data.toString());
        }

        System.out.println(myBST.getIndexMap());
        for (int index = 0; index < 10; index++) {
            if (myBST.isIndexExist(index)) {
                System.out.println(index + " = " + myBST.getDataListByIndex(index).toString());
            }
        }

    }
}
