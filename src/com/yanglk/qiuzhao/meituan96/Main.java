package com.yanglk.qiuzhao.meituan96;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class Main {


    public static void main5(String[] args) {
        //ConcurrentHashMap
         //       Vector
        Hashtable<Integer,Integer> integerIntegerHashtable=new Hashtable<>();
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < m; i++) {
            int t=sc.nextInt();
            list.add(t);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            int integer=list.get(i);
            if (!set.isEmpty()&&set.contains(integer)){
                continue;
            }
            else {
                set.add(integer);
                System.out.println(integer);
            }
        }

    }



    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] num=new int[n];
            for (int i = 0; i < n; i++) {
                num[i]=sc.nextInt();
            }
            Arrays.sort(num);
            for (int i = n; i > 0; i--) {

            }
        }
    }
    public static boolean hasChild(int[] num,int k){
        if (num[k]==1)
            return true;
//        for (int i = ; i < num[k]; i++) {
//
//        }
        return false;
    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a;
        int res=0;
        for (int i = 1; i <= n; i++) {
            a=sc.nextInt();
            int r=a;
            for (int j = 1; j <= i+1; j++) {
                r=r^(i%j);
            }
            r=r^(xor(n)^xor(i));
            res=res^r;
        }
        System.out.println(res);
    }
    public static int xor(int n){
        int s=n&3;
        if ((s&1)==1){
            return s/2^1;
        }
        return s/2^n;
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        int c=0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)>'Z'){
                c++;
            }
        }
        System.out.println(Math.abs((n/2)-c));
    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int q=sc.nextInt();
        Set<Integer> sp=new HashSet<>();
        Set<Integer> sq=new HashSet<>();
        for (int i = 0; i < p; i++) {
            sp.add(sc.nextInt());
        }
        int c=0;
        for (int i = 0; i < q; i++) {
            int v= sc.nextInt();
            if (sp.contains(v))
                c++;
            sq.add(v);
        }


        System.out.print(p-c+" ");
        System.out.print(q-c+" ");
        System.out.print(c);
    }
}
