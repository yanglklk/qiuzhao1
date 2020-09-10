package com.yanglk.qiuzhao.mianshizhinan.list;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ListNode H1=new ListNode(-1);
        ListNode next=H1;
        for (int i = 0; i < n; i++) {
            ListNode p=new ListNode(i+1);
            next.next=p;
            next=p;
        }
        next.next=H1.next;
        next=H1.next;


        while (next.next!=next){
            for (int i = 1; i < m-1; i++) {
                next=next.next;
            }
            next.next=next.next.next;
            next=next.next;
        }
        System.out.println(next.val);
    }

    public static void main4(String[] args) { //反转部分
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode H1=new ListNode(-1);
        ListNode next=H1;
        for (int i = 0; i < n; i++) {
            ListNode p=new ListNode(sc.nextInt());
            next.next=p;
            next=p;
        }
        int l=sc.nextInt();
        int r=sc.nextInt();
        next =H1.next;
        int i=1;
        ListNode pr=null;
        ListNode pl=null;
        ListNode p=null;
        if (l==1){
            pl=H1;
            p=H1.next;
        }
        if (r==n){
            pr=null;
        }

        while (next!=null){
            if(i==l-1){
                pl=next;
                p=next.next;
            }
            if(i==r+1){
                pr=next;
            }
            i++;
            next=next.next;
        }
        pl.next=pr;
        while (p!=pr){
            next=p.next;
            p.next=pl.next;
            pl.next=p;
            p=next;
        }
        next=H1.next;
        while (next!=null){
            System.out.print(next.val+" ");
            next=next.next;
        }




    }

    public static void main3(String[] args) { //反转单双链表
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode H1=new ListNode(-1);
        ListNode next=H1;
        for (int i = 0; i < n; i++) {
            ListNode p=new ListNode(sc.nextInt());
            next.next=p;
            next=p;
        }
        int m=sc.nextInt();
        BiListNode H2=new BiListNode(-1);
        BiListNode binext=H2;
        for (int i = 0; i < m; i++) {
            BiListNode p=new BiListNode(sc.nextInt());
            binext.next=p;
            p.pre=binext;
            binext=p;
        }
        ListNode R1=new ListNode(-1);
        next=H1.next;
        ListNode p=next;
        while (p!=null){
           next=p.next;
           p.next=R1.next;
           R1.next=p;
           p=next;
        }
        R1=R1.next;
        while (R1!=null){
            System.out.print(R1.val+" ");
            R1=R1.next;
        }
        System.out.println();
        BiListNode R2=new BiListNode(-1);
        binext=H2.next;
        BiListNode q=binext;
        while (q!=null){
            binext=q.next;
            q.next=R2.next;
            q.pre=R2;
            R2.next=q;
            if(q.next!=null)
                q.next.pre=q;
            q=binext;
        }
        R2=R2.next;
        while (R2!=null){
            System.out.print(R2.val+" ");
            R2=R2.next;
        }


    }
    public static void main2(String[] args)  {//可见山峰
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        if(n==1){
            System.out.println(0);
            return;
        }
        long c=((long)n *(long)(n-1))/2;
        for (int i = 0; i < n; i++) {

            for (int j = i+2; j !=i+1&&j<=n; j++) {
                if(j==n) {
                    j=0;
                    continue;
                }
                int min=Math.min(nums[i],nums[j]);
                boolean flag=false;
                for (int k = i+1; k != j; k++) {
                    if (k==n) {
                        k=0;
                        continue;
                    }
                    if (nums[k]>min) {
                        flag=true;

                    }

                }
                if(!flag){
                    c++;
                }


            }
        }
        System.out.println(c-1);
    }
    public static void main1(String[] args) { //删除倒数K节点
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        ListNode L=new ListNode(-1);
        ListNode next=L;
        ListNode d=new ListNode(-1);
        for (int i = 0; i < n; i++) {
            ListNode p=new ListNode(sc.nextInt());
            next.next=p;
            if(i==n-k){
               d=next;
            }
            next=p;
        }
        d.next=d.next.next;
        L=L.next;
        while (L!=null){
            System.out.print(L.val+" ");
            L=L.next;
        }
    }
}
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//class BiListNode {
//    int val;
//    BiListNode next;
//    BiListNode pre;
//    BiListNode(int x) { val = x; }
//}