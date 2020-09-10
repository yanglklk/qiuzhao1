package com.yanglk.qiuzhao.guanglianda99;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Map<Integer,int[]> map=new HashMap<>();

        for (int i = 0; i < list.size(); ) {
            int mink=Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                int k=list.get(j);
                if (!map.containsKey(k)){
                    map.put(k,new int[]{j,-1});
                }
                else {
                    int[] t=map.get(k);
                    if (t[1]==-1){
                        t[1]=j;
                        map.put(k,t);
                    }
                    mink=Math.min(mink,k);
                }
            }
            if (mink==Integer.MAX_VALUE){
                break;
            }
            int v1=map.get(mink)[0];
            int v2=map.get(mink)[1];
            list.remove(v1);
            list.set(v2-1,mink*2);
            i=0;
            map.clear();

        }
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }

    }

//    public static void bp(ArrayList<Integer> list,HashSet<Integer> set){
//        if (set.size()==list.size()){
//            return;
//        }
//        list.
//    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        double[] c=new double[n];
        int[] w=new int[n];
        for (int i = 0; i < n; i++) {
            c[i]=sc.nextDouble();
            w[i]=sc.nextInt();
        }

        int[][] opt=new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            int wi=w[i-1];
            double ci=c[i-1];
            for (int j = 1; j <= k; j++) {
                if (j>=ci){
                    opt[i][j]=Math.max(opt[i-1][j],opt[i-1][(int)Math.ceil(j-ci)]+wi);
                }
                else {
                    opt[i][j]=opt[i-1][j];
                }
            }

        }
        System.out.println(opt[n][k]);

    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int x=sc.nextInt();
        int[] num=new int[n];
        int min=Integer.MAX_VALUE;
        int ip=0;
        for (int i = 0; i < n; i++) {
            num[i]=sc.nextInt();
            if (num[i]<min){
                min=Math.min(min,num[i]);
                ip=i;
            }

        }

        for (int i = 0; i < m; i++) {
            num[ip]+=x;
            min=Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (num[j]<min){
                    min=Math.min(min,num[j]);
                    ip=j;
                }
            }
        }
        System.out.println(num[0]);

    }
}
