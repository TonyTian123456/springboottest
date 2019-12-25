package com.example.utils.mianshi;

import java.util.Scanner;

/**
 * Created by cicada on 2019/12/22.
 */
public class SushuDui {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int min = n;
            int a = 0;
            int b = 0;
            for(int i=2; i<=n/2; i++){
                if(!sushu(i) || !sushu(n-i))
                    continue;
                int temp = Math.abs((n-i-i));
                if(temp < min){
                    min = temp;
                    a = i;
                    b = n-i;
                }
            }
            System.out.println(a+"\n"+b);
        }
    }
    public static boolean sushu(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
