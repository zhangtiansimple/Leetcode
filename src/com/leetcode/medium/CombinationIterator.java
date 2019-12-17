package com.leetcode.medium;

/**
 *
 * 请你设计一个迭代器类，包括以下内容：
 *
 *     一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
 *     函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 *     函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
 *
 *
 *
 * 示例：
 *
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator
 *
 * iterator.next(); // 返回 "ab"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "ac"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "bc"
 * iterator.hasNext(); // 返回 false
 *
 *
 *
 * 提示：
 *
 *     1 <= combinationLength <= characters.length <= 15
 *     每组测试数据最多包含 10^4 次函数调用。
 *     题目保证每次调用函数 next 时都存在下一个字母组合。
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {
    private int combinationLength;
    private String  characters;
    private List<List<Character>> res = new ArrayList<>();
    private int index;

    //先选定前置位 在依次选定后置位 全排列问题
    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        this.combinationLength = combinationLength;
        backtrace(new ArrayList<>(), 0);
    }

    private void backtrace(List<Character> list, int index) {
        if (list.size() == combinationLength) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < characters.length(); i++) {
            //从index开始 依次往后添加元素
            list.add(characters.charAt(i));
            //回溯下一个位置
            backtrace(list, i + 1);
            //移除最后一个位置 寻找当前节点的下一种可能
            list.remove(list.size() - 1);
        }
    }

    //使用全局变量index开始遍历整个集合
    public String next() {
        StringBuilder sb = new StringBuilder();
        for (char c : res.get(index)) {
            sb.append(c);
        }
        index++;
        return sb.toString();
    }

    //题目保证有解 不需要判断index范围
    public boolean hasNext() {
        return index < res.size();
    }
}
