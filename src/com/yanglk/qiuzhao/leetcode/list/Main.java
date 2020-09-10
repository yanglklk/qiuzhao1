package com.yanglk.qiuzhao.leetcode.list;

import jdk.internal.org.objectweb.asm.Handle;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class Main {
    public static void main(String[] args) {

    }
    public ListNode reverse(ListNode L){
        ListNode head=new ListNode(-1);
        ListNode p=head.next;
        ListNode next=L.next;
        while (L!=null){
            next=L.next;
            head.next=L;
            L.next=p;
            L=L.next;
            p=L;
        }
        return head.next;
    }
}
