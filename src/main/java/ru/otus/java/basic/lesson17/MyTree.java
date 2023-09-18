package ru.otus.java.basic.lesson17;

import java.util.ArrayList;
import java.util.List;

public class MyTree implements SearchTree {
    private Node root;

    private static List<Integer> list = new ArrayList<>() {
        {
            add(10);
            add(1);
            add(7);
            add(3);
            add(4);
            add(2);
            add(5);
            add(9);
            add(6);
            add(8);
        }
    };

    @Override
    public Integer find(Integer element) {
        return recursiveFindElement(element, root);
    }

    public Integer recursiveFindElement(Integer element, Node root) {
        if (root != null) {
            if (root.value == element) {
                return element;
            }

            if (element > root.value) {
                return recursiveFindElement(element, root.right);
            } else {
                return recursiveFindElement(element, root.left);
            }
        } else {
            return null;
        }
    }

    @Override
    public List<Integer> getSortedList() {
        System.out.println("Unsorted list: " + list);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int temporaryValue = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temporaryValue);
                }
            }
        }
        System.out.println("Sorted list: " + list);
        return list;
    }

    public MyTree loadBinaryTree() {
        root = generateTree(list, 0, list.size() - 1);
        return this;
    }

    private Node generateTree(List<Integer> list, int sizeLeftPart, int sizeRightPart) {
        if (sizeLeftPart > sizeRightPart) {
            return null;
        }

        int mid = (sizeLeftPart + sizeRightPart) / 2;
        Node root = new Node(list.get(mid));
        root.left = generateTree(list, sizeLeftPart, mid - 1);
        root.right = generateTree(list, mid + 1, sizeRightPart);
        return root;
    }
}
