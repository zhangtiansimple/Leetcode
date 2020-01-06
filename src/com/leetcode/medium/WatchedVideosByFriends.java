package com.leetcode.medium;

import java.util.*;

public class WatchedVideosByFriends {
    //广度优先搜索
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<String, Integer> map = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.addLast(id);
        visited.add(id);
        int depth = -1;
        while (!queue.isEmpty()) {
            depth++;
            if (depth >= level) {
                for (Integer fri : queue) {
                    for (String s : watchedVideos.get(fri)) {
                        map.put(s, map.getOrDefault(s, 0) + 1);
                    }
                }
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer first = queue.removeFirst();
                for (int fri : friends[first]) {
                    if (!visited.contains(fri)) {
                        queue.addLast(fri);
                        visited.add(fri);
                    }
                }
            }
        }
        List<String> res = new ArrayList<>(map.keySet());
        res.sort((o1, o2) -> {
            Integer count1 = map.get(o1);
            Integer count2 = map.get(o2);
            return count1.equals(count2) ? o1.compareTo(o2) : count1 - count2;
        });
        return res;
    }
}
