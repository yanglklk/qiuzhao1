package com.yanglk.qiuzhao.leetcode.list;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;
import jdk.nashorn.internal.ir.ReturnNode;

import javax.xml.bind.ValidationEvent;
import java.util.Stack;

public class Add_list {
    public static void main(String[] args) {
        ListNode L1=new ListNode(2);
        ListNode L2=new ListNode(4);
        ListNode L3=new ListNode(3);
        ListNode L4=new ListNode(7);
        ListNode L5=new ListNode(5);
        ListNode L6=new ListNode(6);
        ListNode L7=new ListNode(4);
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        L5.next=L6;
        L6.next=L7;
        new Add_list().add_List(L1,L5);


    }
    public ListNode add_List(ListNode L1,ListNode L2){
        Stack<Integer> S1=new Stack<>();
        Stack<Integer> S2=new Stack<>();
        while(L1!=null){
            S1.push(L1.val);
            L1=L1.next;
        }
        while(L2!=null){
            S2.push(L2.val);
            L2=L2.next;
        }
        ListNode ret=new ListNode(-1);
        ListNode p=ret;
        ret.next=p;
        int c=0;
        while (!S1.isEmpty()){
            int add=0;
            ListNode next=new ListNode(-1);
            if (S1.size()>S2.size()){
                add=S1.pop();
            }
            else if(S1.size()<S2.size()){
                add=S2.pop();
            }
            else{
                add=S1.pop()+S2.pop()+c;
                if (add>9){
                    c=1;
                    add-=10;
                }
                else {
                    c=0;
                }
            }
            next.val=add;
            p.next=next;
            p=next;
        }
        c++;
        return ret.next;
    }
    public ListNode mergeListNode(ListNode L1,ListNode L2){
        ListNode ret=new ListNode(-1);
        ListNode next=ret;
        ListNode p=L1;
        ListNode q=L2;
        while (p!=null && q !=null){
            if (p.val<q.val){
                next.next=p;
                p=p.next;
            }
            if (p.val>=q.val){
                next.next=q;
                q=q.next;
            }
            next=next.next;
        }
        if (p!=null){
            next.next=p;
        }
        if (q!=null){
            next.next=q;
        }
        return ret.next;
    }
    //select Name,count(*) from login_log where Time="2020-08-19" groupby Name
}
