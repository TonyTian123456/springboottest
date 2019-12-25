package com.example.utils.mianshi;

import com.example.entity.Student;
import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cicada on 2019/12/20.
 */
public class StringTest {
    public static void main(String[] args) {

        List<Student>  list  = new ArrayList<>();
        list.stream().map(student -> student.getId()).collect(Collectors.toList());
        list.stream().collect(Collectors.groupingBy(Student::getId));
        /*String s="desabrgc";
        char[] chars = s.toCharArray();
        quickSort(chars,0,chars.length-1);
        System.out.println(new String(chars));*/

        String[] str={"desabrgc","ades","defrs","dacbed","gdesabrc"};
        for (int i=0;i<str.length;i++){
            String temp=str[i];
            char[] chars1 = temp.toCharArray();
            quickSort(chars1,0,chars1.length-1);
            str[i]= new String(chars1);
        }
        sort(str);
//        List<String> list1 = Arrays.asList(str);
//        Collections.sort(list1);
        for (String temp:str){
            System.out.println(temp);
        }
    }

    public static void quickSort(char[] a,int left,int right)
    {
        if(left>right)
            return;
        char pivot=a[left];//定义基准值为数组第一个数
        int i=left;
        int j=right;

        while(i<j)
        {
            while(pivot<=a[j]&&i<j)//从右往左找比基准值小的数
                j--;
            while(pivot>=a[i]&&i<j)//从左往右找比基准值大的数
                i++;
            if(i<j)                     //如果i<j，交换它们
            {
                char temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        a[left]=a[i];
        a[i]=pivot;//把基准值放到合适的位置
        quickSort(a,left,i-1);//对左边的子数组进行快速排序
        quickSort(a,i+1,right);//对右边的子数组进行快速排序
    }

    public static void sort(String[] arr) {
        String tmp ="";
        for(int i= 0;i<= arr.length-1;i++) {
            for(int j=i+1;j< arr.length;j++) {
                if(getResult(arr[i],arr[j])) {
                    tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }

    public static  boolean  getResult(String s1,String s2){
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        int i=0;
        int j=0;
        boolean res=false;
        while (true){
            if (chars[i]==chars1[j]){
                ++i;
                ++j;
                if (i >chars.length-1 && j>chars1.length-1){
                    res=false;
                    break;
                }else if (i > chars.length-1 && j<=chars1.length-1){
                    res=false;
                    break;
                }else if (i <= chars.length-1 && j >chars1.length-1){
                    res=true;
                    break;
                }else{
                    continue;
                }
            }else if (chars[i]>chars1[j]){
                res=true;
                break;
            }else if (chars[i]<chars1[j]){
                res=false;
                break;
            }
        }
        return res;
    }
}
