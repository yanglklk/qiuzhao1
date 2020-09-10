package com.yanglk.qiuzhao.xiecheng98;

import java.util.*;

public class Main {
    final static int a=3;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int n=sc.nextInt();
        int e=sc.nextInt();
        int x=sc.nextInt();
        int l=sc.nextInt();
        for (int i = 0; i < (M * n); i++) {
            int j=sc.nextInt();
        }
        System.out.println("NA");
    }


    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int n=ss.length;
        ArrayList<String> list=new ArrayList<>();

        list.add(ss[0]);

        for (int i = 1; i < n; i++) {
            ArrayList<String> ll=new ArrayList<>();

            for (int j = 0; j < list.size(); j++) {
                String sj=list.get(j);
                String si=ss[i];
                for (int i1 = 0; i1 < si.length(); i1++) {

                   StringBuffer sji=new StringBuffer(sj);
                   sji.append(si.charAt(i1));
                   ll.add(sji.toString());
                }
            }
            list.clear();;
            list.addAll(ll);

        }
        for (String s : list) {
            Set<Character> set=new HashSet<>();
            int i = 0;
            for (; i < s.length(); i++) {
                if (set.contains(s.charAt(i))){
                    System.out.println(s+"--circular dependency");
                    break;
                }
                set.add(s.charAt(i));
            }
            if (i!=s.length()){
                continue;
            }
            System.out.println(s);
        }

    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String m=sc.nextLine();
        String s=sc.nextLine();
        String t=sc.nextLine();
        int[] count=new int[26];
        for (int i = 0; i < m.length(); i++) {
            count[m.charAt(i)-'a']++;
        }
        StringBuffer sbb=new StringBuffer();
        for (int i = 0; i < s.length(); ) {
            int j1,j2;
            j1=  s.indexOf(' ',i)!=-1? s.indexOf(' ',i):Integer.MAX_VALUE;
            j2 = s.indexOf(',',i)!=-1? s.indexOf(',',i):Integer.MAX_VALUE;
            int j= j1<j2? j1:j2;
            if (j==Integer.MAX_VALUE){
               j=s.length();
            }
            String sb=s.substring(i,j);
            int[] cc=new int[26];
            for (int k = 0; k < sb.length(); k++) {
               cc[sb.charAt(k)-'a']++;
            }
            boolean f=false;
            for (int i1 = 0; i1 < cc.length; i1++) {
                if (cc[i1]!=count[i1]){
                    f=true;
                    break;
                }
            }
            if (!f){
                sbb.append(t);
            }
            else {
                sbb.append(sb);
            }
            if (j!=s.length()){
                sbb.append(s.charAt(j));
            }
            i=j+1;
        }

        System.out.println(sbb);
    }
}
