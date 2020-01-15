package com.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
    class Node {
        int value;
        int key;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public String reorganizeString(String S) {

        int[] aux = new int[26];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < S.length(); i++) {
            aux[S.charAt(i) - 'a']++;
            max = Math.max(max, aux[S.charAt(i) - 'a']);
        }

        if (max > (S.length() + 1) / 2) {
            return "";
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        });

        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != 0) {
                Node node = new Node('a' + i, aux[i]);
                queue.add(node);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            Node first = queue.remove();
            Node second = queue.remove();

            sb.append((char) first.key).append((char) second.key);
            if (--first.value > 0) {
                queue.add(first);
            }
            if (--second.value > 0) {
                queue.add(second);
            }
        }
        if (queue.size() > 0) {
            sb.append((char) queue.remove().key);
        }
        return sb.toString();
    }
}
