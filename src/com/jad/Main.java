package com.jad;

import com.jad.bst.AVL;
import com.jad.bst.BST;

public class Main {

    public static void main(String[] args) {
        AVL<String> myAVL = new AVL<>();

        for(int index = 0; index < 100000;index++) {
//            int index = (int) (Math.random()*7);
            StringBuilder data = new StringBuilder();
            for (int j = 0; j < (int) (Math.random() * 256); j++) {
                data.append((char) (Math.random() * 26 + 65));
            }
            myAVL.addData(index, data.toString());
        }

//        System.out.println(myAVL.getIndexMap());
//        for (int index = 0; index < 10; index++) {
//            if (myAVL.isIndexExist(index)) {
//                System.out.println(index + " = " + myAVL.getDataListByIndex(index).toString());
//            }
//        }
        System.out.println("Height : " + myAVL.getHeight());
        //System.out.println(myAVL.getAllBalanceFactors());
        //System.out.println(myAVL.getIndexMap());
    }
}
