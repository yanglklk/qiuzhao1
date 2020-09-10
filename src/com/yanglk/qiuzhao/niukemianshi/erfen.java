package com.yanglk.qiuzhao.niukemianshi;

import jdk.nashorn.internal.ir.ReturnNode;

public class erfen {
    public static void main(String[] args) {
        new erfen().upper_bound_(7,9,new int[]{1,2,4,9,9,9,10,15});
    }
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        if (a[0]>=v){
            return 1;
        }
        if (a[n-1]<v){
            return n+1;
        }
        int l=0;
        int r=n-1;
        int m=(l+r)/2;
        int i=0;
        while (l<r){
            if (a[m]<v){
                l=m+1;
            }
            else {
               i=m;
               r=m;
            }
            m=(l+r)/2;
        }

        return r+1;
    }
}
