package com.example.utils.mianshi;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list =Permutation("abc");
        for (String t:list){
            System.out.println(t);
        }
    }
    public static ArrayList<String> Permutation(String str) {
       if (str == null) return null;
        //把字符串转化为数组
        char[] ins = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        DoPermutation(ins, 0, list);
        //按字典排序
        Collections.sort(list);
        return list;
    }

    private static void DoPermutation(char[] ins, int i, ArrayList<String> list) {
        if (ins == null) return;
        //如果i指向了最后一个字符
        if (i == ins.length - 1) {
            if (list.contains(String.valueOf(ins))) {
                return;
            }
            list.add(String.valueOf(ins));
        }
        //当i不指向最后一个时，i代表我们做排列操作的字符串的第一个字符
        else {
            for(int j=i;j<ins.length;j++) {
                swap(ins, i, j);//将第一个字符与后面的字符交换
                DoPermutation(ins, i + 1, list); //对后面的字符进行全排列
                swap(ins, j, i);//再将之前交换的字符交换回来，以便于第一个字符再与其他字符进行交换
            }
        }
    }

    /*交换*/
    private static void swap(char[] ins, int i, int j) {
        char tmp = ins[i];
        ins[i] = ins[j];
        ins[j] = tmp;
    }
}