package com.example.utils.mianshi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by cicada on 2019/12/22.
 */
public class GetFirstChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            HashMap<Character,Integer>  map = new LinkedHashMap<Character,Integer>();
            for (int i=0;i<str.length();i++){
                if (map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),map.get(str.charAt(i))+1);
                }else{
                    map.put(str.charAt(i),1);
                }
            }

            Set<Character> set = map.keySet();
            Boolean res=false;
            for (Character c:set){
                if (map.get(c)==1){
                    System.out.println(c);
                    res=true;
                    break;
                }
            }
            if (!res){
                System.out.println(-1);
            }
        }
    }
}
