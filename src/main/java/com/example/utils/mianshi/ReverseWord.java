package com.example.utils.mianshi;


import java.lang.String;
import java.util.Scanner;

/**
 * Created by cicada on 2019/12/22.
 */
public class ReverseWord {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=arr.length -1;i>=0;i--){
                stringBuilder.append(arr[i]+" ");
            }
            System.out.println(new String(stringBuilder));
        }
    }
}
