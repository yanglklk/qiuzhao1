package com.yanglk.qiuzhao.niukemianshi;

import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> topK=new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (topK.size()< K){
                topK.add(a[i]);
            }
            else {
                if (a[i]>topK.peek()){
                    topK.poll();
                    topK.add(a[i]);
                }
            }
        }
        return topK.peek();
    }
    public int findKth2(int[] a, int n, int K) {
       int num=findKth1(a,0,n-1,K);
        return num;
    }
    public int findKth1(int[] a, int l, int h,int K) {
        // write code here
        if (l>=h)
            return a[a.length-K];
        int v=a[l];
        int l1=l,h1=h;
        while (l<h){
            while (l<h && a[h]>=v)
                h--;
            a[l]=a[h];
            while (l<h && a[l]<=v)
                l++;
            a[h]=a[l];
        }
        a[l]=v;
        if (l==a.length-K){
            return a[l];
        }
        if (l>(a.length-K))
            return findKth1(a,l1,l,K);
        if (l<(a.length-K))
            return findKth1(a,l+1,h1,K);
        return -1;
    }


}
