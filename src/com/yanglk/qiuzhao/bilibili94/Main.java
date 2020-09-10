package com.yanglk.qiuzhao.bilibili94;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int[] SpiralMatrix (int[][] matrix) {
        // write code here
        int rl=0;
        int rh=matrix.length-1;
        int cl=0;
        int ch=matrix[0].length-1;
        List<Integer> l=new ArrayList<>();
        while (rl<=rh&& cl<=ch){
            circle(matrix,rl++,rh--,cl++,ch--,l);
        }
        int[]  res= new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i]=l.get(i);
        }
        return res;

    }
    public void circle(int[][] matrix,int rl, int rh, int cl, int ch, List<Integer> l){
        if (rh==rl){
            for (int i=cl; i < ch; i++) {
                l.add(matrix[rh][i]);
            }
        }
        else if (ch==cl){
            for (int i=rl; i < rh; i++) {
                l.add(matrix[i][ch]);
            }
        }
        else {
            int curc=cl;
            int curr=rl;
            while (curc!=ch){
                l.add(matrix[rl][curc++]);
            }
            while (curr!=rh){
                l.add(matrix[curr++][ch]);
            }
            while (curc!=cl){
                l.add(matrix[rh][curc--]);
            }
            while (curr!=rl){
                l.add(matrix[curr--][cl]);
            }
        }
    }

    public int GetFragment (String str) {
        // write code here
        char[] chars= str.toCharArray();
        int n= str.length();
        int l=0;
        int r=0;
        List<Integer> list=new ArrayList<>();
        int sum=0;
        int c=0;
        while (r<n){
            if (chars[r]!=chars[l]){

                l=r;
                c++;
            }
            r++;
        }
        return n/(c+1);

    }

    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        int l=0;
        int r=0;
        int res=0;
        int c=0;
        int n=arr.length;
        while (r<n){
            if (arr[r]==0){
                c++;
            }
            while (c>k){
                if (arr[l++]==0){
                    c--;
                }
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Main().GetFragment("aaabbaaac");
    }
}
