package com.yanglk.qiuzhao.ali94;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int m=n*n;
        BigInteger co=BigInteger.valueOf(1);
        if (a>0){
            co=co.multiply(count(m,a));
        }
        if (b>0){
            co=co.multiply(count(m-a,b));
        }
        if (c>0){
            co=co.multiply(count(m-a-b,c));
        }
        if (d > 0) {
            co=co.multiply(count(m-a-b-c,d));
        }
        System.out.println(co.mod(BigInteger.valueOf(998244353)));
    }
    public static BigInteger count(int m, int i){
        BigInteger m1=BigInteger.valueOf(1);
        for (int m2 = m; m2 >m-i; m2--) {
            m1=m1.multiply(BigInteger.valueOf(m2));
        }
        BigInteger i1=BigInteger.valueOf(1);
        for (int i2 = i; i2 > 0; i2--) {
            i1=i1.multiply(BigInteger.valueOf(i2));
        }
        return m1.divide(i1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] match=new int[n+1];
        int[] count=new int[n+1];
        for (int i = n-1; i > 0; i--) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            match[b]=a;
            count[a]++;
        }
        int max=Integer.MIN_VALUE;
        for (int i = 1; i < count.length; i++) {
            int c=0;

            if (count[i]==0){
                int tep=i;
                while (tep!=1){
                    c+=count[match[tep]]-1;
                    tep=match[tep];
                }
            max=Math.max(c,max);
            }
        }
        System.out.println(max);
    }
}
