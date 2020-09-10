package com.yanglk.qiuzhao.zijie722;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,m;
        String[] ss1=sc.nextLine().split(",");
        n=Integer.valueOf(ss1[0]);
        m=Integer.valueOf(ss1[1]);
        Map<String, List<String>> map=new HashMap<>();
        Map<String, List<String>> mapp=new HashMap<>();
        Set<String> set=new HashSet<>();
        Map<String, Integer> mapc=new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] ss=sc.nextLine().split(",");
            if (map.keySet().contains(ss[0])){
                List<String> list = map.get(ss[0]);
                list.add(ss[1]);
                map.put(ss[0],list);
            }
            else {
                List<String> list=new ArrayList<>();
                list.add(ss[1]);
                map.put(ss[0],list);
            }

            if (mapp.keySet().contains(ss[1])){
                List<String> list = mapp.get(ss[1]);
                list.add(ss[0]);
                map.put(ss[1],list);
            }
            else {
                List<String> list=new ArrayList<>();
                list.add(ss[0]);
                mapp.put(ss[1],list);
            }
            set.add(ss[0]);
            set.add(ss[1]);
        }
        Map<String,Integer> vmap=new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] ss=sc.nextLine().split(",");
            vmap.put(ss[0],Integer.valueOf(ss[1]));
        }
        String start="";
        Set<String> end=new HashSet<>();
        for (String s : set) {
            if (map.keySet().contains(s) && !vmap.keySet().contains(s)){
                start=s;
            }
            if (!map.keySet().contains(s) && !vmap.keySet().contains(s)){
                end.add(s);
            }
            int c=mapp.containsKey(s) ? mapp.get(s).size():0;
            mapc.put(s,c);
        }
        Stack<String> stack=new Stack<>();
        Set<String> unique=new HashSet<>();
        stack.add(start);
        unique.add(start);
        int value=0,min=Integer.MAX_VALUE;
        Map<String,List<String>> pmap=new TreeMap<>();
        List<String> lll=new ArrayList<>();
        lll.add(start+",");
        pmap.put(start,lll);
        StringBuffer sb=new StringBuffer();
        while (!stack.empty()){
            String st=stack.pop();
            mapc.put(st,mapc.get(st)-1);
            if (mapc.get(st)==0){
                unique.add(st);
            }
            if (end.contains(st)){
                System.out.println(value);
                min=Math.min(min,value);

                continue;
            }
            if (vmap.keySet().contains(st)){
                value+=vmap.get(st);
            }
            List<String> list=map.get(st);
            List<String> ls2=pmap.get(st);
            //pmap.remove(st);
            //List<String> ll2=new ArrayList<>();
            for (String s2 : ls2) {
                for (String si : list) {
                    if (!unique.contains(si)){
                        stack.push(si);
                        String ss2=s2+si+",";
                        List<String> ll2=new ArrayList<>();
                        if (pmap.containsKey(si)){
                            ll2=pmap.get(si);
                            ll2.add(ss2);
                        }
                        else {
                            ll2.add(ss2);
                        }
                        pmap.put(si,ll2);
                    }
                }
            }

        }

        System.out.println(min);




        
    }

    void bp(Map<String,Integer> vmap,Map<String,
            List<String>> map, Set<String> end,Set<String> unique,String st){
        List<String> list=map.get(st);
        for (String si : list) {
            if (!unique.contains(si)){

            }
        }

    }

}
