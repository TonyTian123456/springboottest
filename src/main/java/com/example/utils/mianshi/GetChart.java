package com.example.utils.mianshi;

import java.util.*;

/**
 * Created by cicada on 2019/12/21.
 */
public class GetChart {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            List<Character> list =new ArrayList<Character>();
            for (int i=0;i<s.length();i++){
                if (!list.contains(s.charAt(i))){
                    list.add(s.charAt(i));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c:list){
                stringBuilder.append(c);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
