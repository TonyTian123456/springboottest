package com.example.utils.mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by cicada on 2019/12/22.
 */
public class SortString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.hasNext()?scanner.nextInt():0;
        ArrayList<String> list =new ArrayList<>();
        while (i>=0 &&scanner.hasNext()){
            String str =scanner.nextLine();
            list.add(str);
            i--;
        }
        Collections.sort(list);
        for (String s:list){
            System.out.println(s);
        }
    }
}
