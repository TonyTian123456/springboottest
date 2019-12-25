package com.example.utils.mianshi;

import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by cicada on 2019/12/21.
 */
public class DeleteNum {

    public static void main(String[] args) {
//        new ThreadPoolExecutor();

        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] array =new int[n];
            for (int i=0;i<n;i++){
                array[i]=i;
            }
            int res=-1;
            int count =0;
            int i=0;
            int last = array.length;

            while (true){

                if (last ==1){
                    break;
                }

                if (array[i] !=-1){
                    count++;
                }
                if (count ==3){
                    array[i]=-1;
                    last--;
                    i++;
                    count=0;
                }else{
                    i++;
                }
                if (i >array.length-1){
                    i=0;
                }
            }

            for (int t:array){
                if (t!=-1){
                    res = t;
                }
            }
            System.out.println(res);
        }
    }

}
