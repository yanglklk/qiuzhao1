package com.yanglk.qiuzhao.baidu93;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c5=0;
        int c0=0;
        int n =sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (sc.nextInt()==5)
                c5++;
            else c0++;
        }
        if (c0==0)
            System.out.println(-1);
        else if(c5<9)
            System.out.println(0);
        else {
            String s5="555555555";
            StringBuffer sb=new StringBuffer();
            for (int i=0;i< c5/9;i++){
                sb.append(s5);
            }
            for (int i = 0; i < c0; i++) {
                sb.append("0");
            }
            System.out.println(sb);
        }

    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println(count(n,m,new HashMap<>())%(10e9+7));


    }
    public static long count(int n, int m, Map<Integer,Long> map){
        long c=0;
        if (n==0)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        else if (n>=m){
            for (int i = 1; i <= m; i++) {
                c+=count(n-i,m,map);
            }
        }
        else {
            c+=count(n,n,map);
        }
        map.put(n,c);
        return c;

    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] c = new int[n];
            for (int j = 0; j < m; j++) {
                int k = sc.nextInt();
                for (int kk = 0; kk < k; kk++) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    for (int q = l ; q <= r; q++) {
                        c[q-1]++;
                    }
                }
            }
            ArrayList<Integer> l=new ArrayList<>();
            for (int i1 = 0; i1 < n; i1++) {
                int cc = c[i1];
                if (cc == m) {
                   l.add(i1+1);
                }
            }
            System.out.println(l.size());
            for (Integer integer : l) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] c = new int[n][m];
            for (int j = 0; j < m; j++) {
                int k = sc.nextInt();
                for (int kk = 0; kk < k; kk++) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    for (int q = l ; q <= r; q++) {
                        c[q-1][j]=1;
                    }
                }
            }
            ArrayList<Integer> l=new ArrayList<>();
            for (int i1 = 0; i1 < n; i1++) {
                int cc = 0;
                for (int i2 = 0; i2 < m; i2++) {
                    cc+=c[i1][i2];
                }
                if (cc == m) {
                    l.add(i1+1);
                }
            }
            System.out.println(l.size());
            for (Integer integer : l) {
                System.out.print(integer+" ");
            }
            System.out.print("\n");
        }
    }

}
