package ru.otus.java.basic.lesson17;

public class MainApp {

    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        myTree.getSortedList();
        System.out.println();

        myTree.loadBinaryTree();
        System.out.println(myTree.find(6));
        System.out.println(myTree.find(1));
        System.out.println(myTree.find(9));
        System.out.println(myTree.find(7));
        System.out.println(myTree.find(11));
        System.out.println(myTree.find(-32));
    }
}
