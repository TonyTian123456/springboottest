package com.example.utils.mianshi;
import java.util.Scanner;

/**
 * Created by cicada on 2019/12/22.
 */
public class HuaweiTest {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            if (num==0){
                System.out.println("End");
                break;
            }
            int result=0;
            for (int i=2;i<=num/2;i++){
                if (!isPri(i) || !isPri(num-i)){
                    continue;
                }else{
                    result+=1;
                }
            }
            System.out.println(result);
        }

    }

    public static  boolean  isPri(int num){
        if (num == 2){
            return true;
        }
        boolean res =true;
        for (int i =2;i<=num/2;i++){
            if (num % i==0){
                res=false;
                break;
            }
        }
        return res;
    }
}
