package com.example.utils.mianshi;

import java.util.Scanner;

/**
 * Created by cicada on 2019/12/21.
 */
public class SteamBottle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num =scanner.nextInt();
            if (num == 0){
                break;
            }
            int left=num;
            int total=0;
            while (left!=0){
                if (left ==1){
                    break;
                }else if (left ==2){
                    total+=1;
                    break;
                }else {
                    int current = left/3;
                    total+=current;
                    left=left-current*3+current;
                }
            }
            System.out.println(total);
        }
    }

}
