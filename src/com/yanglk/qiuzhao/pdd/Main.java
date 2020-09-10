package com.yanglk.qiuzhao.pdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /*
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k,n;
        k=sc.nextInt();
        n=sc.nextInt();
        int[] step=new int[n];
        int sum=0;
        int count=0;
        boolean flag=true;
        for (int i = 0; i < n; i++) {
            step[i]=sc.nextInt();
            sum+=step[i];
            if (sum==k){
                System.out.println("paradox");
                return;
            }
            if(sum>k){
                sum-=step[i];
                count++;
            }
        }
        System.out.println(k-sum+ " "+ count);
    }
*/
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] temp=new int[6];
            for (int j = 0; j < 6; j++) {
                temp[j]=sc.nextInt();
            }
            String ts=String.valueOf(temp[0])+String.valueOf(temp[1])
                    +String.valueOf(temp[2])+String.valueOf(temp[3])
                    +String.valueOf(temp[4])+String.valueOf(temp[5])+":";
            String key=getAll(temp);
            boolean flag=true;
            if (!map.keySet().isEmpty()) {
                for (String s : map.keySet()) {
                    if (s.contains(ts)) {
                        int k = map.get(s);
                        map.put(s, k + 1);
                        flag=false;
                    }
                }
                if (flag){
                    map.put(key,1);
                }
            }
            else {
                map.put(key,1);
            }
        }
        int[] res=new int[map.size()];
        int i=0;
        for (String s : map.keySet()) {
            res[i++]=map.get(s);
        }
        Arrays.sort(res);
        System.out.println(map.size());
        for (int i1 = res.length - 1; i1 >= 0; i1--) {
            System.out.print(res[i1]+" ");
        }

    }
    public static String getAll(int[] points){
        String s1=String.valueOf(points[0])+String.valueOf(points[1])
                    +String.valueOf(points[2])+String.valueOf(points[3])
                    +String.valueOf(points[4])+String.valueOf(points[5]);
        String s1_1=String.valueOf(points[0])+String.valueOf(points[1])
                +String.valueOf(points[5])+String.valueOf(points[4])
                +String.valueOf(points[2])+String.valueOf(points[3]);
        String s1_2=String.valueOf(points[0])+String.valueOf(points[1])
                +String.valueOf(points[3])+String.valueOf(points[2])
                +String.valueOf(points[5])+String.valueOf(points[4]);
        String s1_3=String.valueOf(points[0])+String.valueOf(points[1])
                +String.valueOf(points[5])+String.valueOf(points[4])
                +String.valueOf(points[3])+String.valueOf(points[2]);

        String s2=String.valueOf(points[1])+String.valueOf(points[0])
                +String.valueOf(points[2])+String.valueOf(points[3])
                +String.valueOf(points[5])+String.valueOf(points[4]);
        String s2_1=String.valueOf(points[1])+String.valueOf(points[0])
                +String.valueOf(points[4])+String.valueOf(points[5])
                +String.valueOf(points[2])+String.valueOf(points[3]);
        String s2_2=String.valueOf(points[1])+String.valueOf(points[0])
                +String.valueOf(points[3])+String.valueOf(points[2])
                +String.valueOf(points[4])+String.valueOf(points[5]);
        String s2_3=String.valueOf(points[1])+String.valueOf(points[0])
                +String.valueOf(points[5])+String.valueOf(points[4])
                +String.valueOf(points[3])+String.valueOf(points[2]);

        String s3=String.valueOf(points[2])+String.valueOf(points[3])
                +String.valueOf(points[4])+String.valueOf(points[5])
                +String.valueOf(points[0])+String.valueOf(points[1]);
        String s3_1=String.valueOf(points[2])+String.valueOf(points[3])
                +String.valueOf(points[1])+String.valueOf(points[0])
                +String.valueOf(points[4])+String.valueOf(points[5]);
        String s3_2=String.valueOf(points[2])+String.valueOf(points[3])
                +String.valueOf(points[5])+String.valueOf(points[4])
                +String.valueOf(points[1])+String.valueOf(points[0]);
        String s3_3=String.valueOf(points[2])+String.valueOf(points[3])
                +String.valueOf(points[0])+String.valueOf(points[1])
                +String.valueOf(points[5])+String.valueOf(points[4]);

        String s4=String.valueOf(points[3])+String.valueOf(points[2])
                +String.valueOf(points[4])+String.valueOf(points[5])
                +String.valueOf(points[1])+String.valueOf(points[0]);
        String s4_1=String.valueOf(points[3])+String.valueOf(points[2])
                +String.valueOf(points[0])+String.valueOf(points[1])
                +String.valueOf(points[4])+String.valueOf(points[5]);
        String s4_2=String.valueOf(points[3])+String.valueOf(points[2])
                +String.valueOf(points[5])+String.valueOf(points[4])
                +String.valueOf(points[0])+String.valueOf(points[1]);
        String s4_3=String.valueOf(points[3])+String.valueOf(points[2])
                +String.valueOf(points[1])+String.valueOf(points[0])
                +String.valueOf(points[5])+String.valueOf(points[4]);

        String s5=String.valueOf(points[4])+String.valueOf(points[5])
                +String.valueOf(points[2])+String.valueOf(points[3])
                +String.valueOf(points[1])+String.valueOf(points[0]);
        String s5_1=String.valueOf(points[4])+String.valueOf(points[5])
                +String.valueOf(points[0])+String.valueOf(points[1])
                +String.valueOf(points[2])+String.valueOf(points[3]);
        String s5_2=String.valueOf(points[4])+String.valueOf(points[5])
                +String.valueOf(points[3])+String.valueOf(points[2])
                +String.valueOf(points[0])+String.valueOf(points[1]);
        String s5_3=String.valueOf(points[4])+String.valueOf(points[5])
                +String.valueOf(points[1])+String.valueOf(points[0])
                +String.valueOf(points[3])+String.valueOf(points[2]);

        String s6=String.valueOf(points[5])+String.valueOf(points[4])
                +String.valueOf(points[2])+String.valueOf(points[3])
                +String.valueOf(points[0])+String.valueOf(points[1]);
        String s6_1=String.valueOf(points[5])+String.valueOf(points[4])
                +String.valueOf(points[1])+String.valueOf(points[0])
                +String.valueOf(points[2])+String.valueOf(points[3]);
        String s6_2=String.valueOf(points[5])+String.valueOf(points[4])
                +String.valueOf(points[3])+String.valueOf(points[2])
                +String.valueOf(points[1])+String.valueOf(points[0]);
        String s6_3=String.valueOf(points[5])+String.valueOf(points[4])
                +String.valueOf(points[0])+String.valueOf(points[1])
                +String.valueOf(points[3])+String.valueOf(points[2]);
        String[] ss={s1,s1_1,s1_2,s1_3,s2,s2_1,s2_2,s2_3,
                s3,s3_1,s3_2,s3_3,s4,s4_1,s4_2,s4_3,s5,s5_1,s5_2,s5_3,s6,s6_1,s6_2,s6_3};
        StringBuffer stringBuffer=new StringBuffer();
        for (String s : ss) {
            stringBuffer.append(s);
            stringBuffer.append(":");
        }
        return stringBuffer.toString();



    }

//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        for (int i = 6; i > 0; i--) {
//            sc.nextLine();
//        }
//        System.out.println(630);
//    }

}
