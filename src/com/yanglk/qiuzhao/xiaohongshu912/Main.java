package com.yanglk.qiuzhao.xiaohongshu912;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[][] box=new int[3*n][3];
            for (int i = 0; i < n; i++) {
                int w=sc.nextInt();
                int l=sc.nextInt();
                int h=sc.nextInt();
                box[i*3]=new int[]{w,l,h};
                box[i*3+1]=new int[]{l,h,w};
                box[i*3+2]=new int[]{h,w,l};
            }
            Arrays.sort(box, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]!=o2[0]? o1[0]=o2[0]:o1[1]-o2[1];
                }
            });
            int maxh=0;
            int[] opt=new int[3*n];
            opt[0]=box[0][2];
            for (int i = 1; i < 3 * n; i++) {
                opt[i]=opt[i-1];
                for (int j = 0; j < i; j++) {
                    if (box[j][1]<=box[i][1]){
                        opt[i]=Math.max(opt[i],opt[j]+box[i][2]);
                    }
                }
            }
            System.out.println(box[3*n-1][2]);
            }
        }
    }

