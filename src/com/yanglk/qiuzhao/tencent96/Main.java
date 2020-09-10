package com.yanglk.qiuzhao.tencent96;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        String s=sc.nextLine();
        int[] num=new int[n*2];
        String[] ss=sc.nextLine().split(" ");
        for (int i = 0; i < (n * 2); i++) {
            num[i]=Integer.valueOf(ss[i]);
        }
        System.out.println(4);
    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] num1=new int[n];
        int[] num=new int[n];
        for (int i = 0; i < n; i++) {
            int t=sc.nextInt();
            num1[i]=t;
            num[i]=t;
        }

        Arrays.sort(num);
        for (int i = 0; i < n; i++) {
            if (n%2==0){
                if (num1[i]<num[(n/2)]){
                    System.out.println(num[(n/2)]);
                }
                 else {
                    System.out.println(num[(n/2)-1]);
                }
            }
            else {
                if (num1[i]==(n-1)/2){
                    System.out.println(num[(n/2)-1]);
                }
                else {
                    System.out.println(num[(n/2)]);
                }
            }
        }

    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int n=sc.nextInt();
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
        for (int i = n; i > 0; i--) {
            int k=sc.nextInt();
            ArrayList<Integer> list=new ArrayList<>();
            for (int i1 = 0; i1 < k; i1++) {
                list.add(sc.nextInt());
            }
            for (int i1 = 0; i1 < list.size(); i1++) {
                int integer=list.get(i1);
                ArrayList<Integer> ll=new ArrayList<>();
                ll.addAll(list);
                if (!map.isEmpty()&&map.containsKey(integer)){
                    ll.addAll(map.get(integer));
                }
                map.put(integer,ll);
            }

        }
        ArrayList<Integer> list=map.get(0);
        Set<Integer> set=new HashSet<>();
        set.add(0);
        while (list.size()!=0){
            ArrayList<Integer> ll=new ArrayList<>();
            for (Integer integer : list) {
                if (!set.contains(integer)){
                    set.add(integer);
                    ll.addAll(map.get(integer));

                }
            }
            list=ll;
        }
        System.out.println(set.size());
    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode h1=new ListNode(-1);
        ListNode p=h1;
        for (int i = n; i > 0; i--) {
            ListNode q=new ListNode(sc.nextInt());
            p.next=q;
            p=q;
        }
        int m=sc.nextInt();
        ListNode h2=new ListNode(-1);
        p=h2;
        for (int i = m; i > 0; i--) {
            ListNode q=new ListNode(sc.nextInt());
            p.next=q;
            p=q;
        }

        ListNode q=null;
        p=h1.next;
        q=h2.next;
        while (q!=null&&p!=null){
            if (q.val==p.val){
                System.out.print(q.val+" ");
                p=p.next;
                q=q.next;
            } else if (q.val<p.val) {
                p=p.next;
            }else {
                q=q.next;
            }
        }
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}