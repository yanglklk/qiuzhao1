package com.yanglk.qiuzhao.mi98;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        System.out.println(true);
    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int[] c=new int[4];
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].length()<8 ||ss[i].length()>120){
                System.out.println(1);
                continue;
            }
            for (int j = 0; j < ss[i].length(); j++) {
                if (ss[i].charAt(j)>='0'&&ss[i].charAt(j)<='9'){
                    c[0]=1;
                }
                else if (ss[i].charAt(j)>='a'&&ss[i].charAt(j)<='z'){
                    c[1]=1;
                }
                else if (ss[i].charAt(j)>='A'&&ss[i].charAt(j)<='Z'){
                    c[2]=1;
                }
                else {
                    c[3]=1;
                }
            }
            if (c[0]+c[1]+c[2]+c[3]==4){
                System.out.println(0);
            }
            else {
                System.out.println(2);
            }
            c[0]=0;
            c[1]=0;
            c[2]=0;
            c[3]=0;

        }
    }


}
