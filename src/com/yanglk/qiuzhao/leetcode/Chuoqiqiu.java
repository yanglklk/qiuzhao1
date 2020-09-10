package com.yanglk.qiuzhao.leetcode;

public class Chuoqiqiu {
    public int maxCoins(int[] nums) {
        return 0;
    }

    public int minArray(int[] numbers) {
        int l=0;
        int r=numbers.length-1;

        while (l<r){
            int m=(l+r)/2;
            if (numbers[m]<numbers[r]){
                r=m;
            }
            else if(numbers[m]>numbers[r]){
                l=m+1;
            }
            else {
                r-=1;
            }
        }
        return numbers[l];
    }
}
