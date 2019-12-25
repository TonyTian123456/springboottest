package com.example.utils.mianshi;

import java.util.Scanner;

public class  ReverseString{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
           String str= scanner.next();
            StringBuilder stringBuilder =new StringBuilder();
            for (int i=str.length()-1;i>=0;i--){
                stringBuilder.append(str.charAt(i));
            }
            System.out.println(String.valueOf(stringBuilder));
        }
    }
}