package com.yanglk.qiuzhao.niukemianshi;


import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        //new Solution().LRU(new int[][]{{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}},3);
        //new Solution().sqrt(1518991037);
        //new Solution().isValid("()");
        //new Solution().getMinStack(new int[][] {{1, -185224},{1, -515268},{3},{1, -57301},{2},{2},{1, 539954},{1, 886856},{1, 333965},{3}});
        //System.out.println(new Solution().maxLength(new int[]{2, 2, 3, 4, 3}));
        //new Solution().permute(new int[]{1,2,3});
        //new Solution().LIS(new int[]{2,1,5,3,6,4,8,9,7});
        new Solution().findMedianinTwoSortedAray(new int[]{1,3,5,7,9,11},new int[]{2,4,6,8,10,12});
    }



    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */

    public int[] LRU(int[][] operators, int k) {
        // write code here
        LRUMap<Integer, Integer> map = new LRUMap(k);
        List<Integer> list = new ArrayList<>();
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                map.put(operator[1], operator[2]);
            } else {
                if (map.containsKey(operator[1]))
                    list.add((Integer) map.get(operator[1]));
                else list.add(-1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int sqrt(int x) {
        // write code here
        if (x < 0)
            return -1;
        else {
            int l = 0;
            int r = x;
            int m = 0;
            while (l < r) {
                m = (l + r) / 2;
                double m1 = (double) m * m;
                double m2 = (double) (m + 1) * (m + 1);
                if (m1 <= x && m2 > x) {
                    return m;
                }
                if (m1 > x)
                    r = m;
                else
                    l = m + 1;
            }
            return l;
        }
    }

    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '}') {
                if (stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '{'))
                    return false;
            } else if (c == ']') {
                if (stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '['))
                    return false;
            } else if (c == ')') {
                if (stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '('))
                    return false;
            } else
                stack.push(c);

        }
        return stack.isEmpty();
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        int n = num.length;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (num[i] > 0)
                break;
            if (i == 0 || num[i] != num[i - 1]) {
                int l = i + 1;
                int r = n - 1;
                while (l < r) {
                    while (l < r && num[i] + num[l] + num[r] > 0)
                        r--;
                    if (l < r && num[i] + num[l] + num[r] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[l]);
                        list.add(num[r]);
                        lists.add(list);
                        int t = num[l];
                        while (l < r && num[l] == t)
                            l++;
                    } else {
                        l++;
                    }
                }
            }

        }
        return lists;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                break;
            }
        }
        if (q == null || q.next == null)
            return null;
        p = head;
        while (q != p) {
            p = p.next;
            q = q.next;
        }
        return p;


    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.add(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.add(head2.val);
            head2 = head2.next;
        }
        int c = 0;
        int p1 = 0;
        int p2 = 0;
        ListNode head = new ListNode(-1);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty())
                p1 = s1.pop();
            else
                p1 = 0;
            if (!s2.empty())
                p2 = s2.pop();
            else
                p2 = 0;
            int co = c + p1 + p2;
            ListNode n = new ListNode(-1);
            if (co >= 10) {
                n.val = co - 10;
                c = 1;
            } else {
                n.val = co;
                c = 0;
            }

            n.next = head.next;
            head.next = n;
        }
        return head.next;
    }

    public int[][] threeOrders(TreeNode root) {
        // write code here
        TreeNode rt = root;
        int[] p1 = preOrder(rt);
        int[] p2 = inOrder(rt);
        int[] p3 = postOrder(rt);
        int[][] pp = new int[][]{p1, p2, p3};
        return pp;

    }

    public int[] preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> l = new ArrayList<>();
        while (!stack.empty()) {
            TreeNode p = stack.pop();
            l.add(p.val);
            if (p.right != null)
                stack.push(p.right);
            if (p.left != null)
                stack.push(p.left);
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;

    }

    public int[] inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        List<Integer> l = new ArrayList<>();
        while (!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                l.add(p.val);
                p = p.right;
            }
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;

    }

    public int[] postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> l = new ArrayList<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode p = stack.pop();
            l.add(p.val);
            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.right != null) {
                stack.push(p.right);
            }

        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(l.size() - i - 1);
        }
        return res;

    }

    public int maxProfit(int[] prices) {
        // write code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int n = prices.length;
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            max = Math.max(max, prices[i] - min);
        }
        return max;

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null)
            return false;
        if (root.right == null && root.left == null && sum - root.val == 0)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public int[] getMinStack(int[][] op) {
        // write code here
        List<Integer> l = new ArrayList<>();
        int n = op.length;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        for (int i = 0; i < n; i++) {
            int a = op[i][0];
            if (a == 1) {
                int b = op[i][1];
                stack.push(b);
                if (!helper.empty()) {
                    if (b < helper.peek()) {
                        helper.push(b);
                    } else {
                        helper.push(helper.peek());
                    }
                } else {
                    helper.push(b);
                }
            }
            if (a == 2) {
                stack.pop();
                helper.pop();
            }
            if (a == 3) {
                l.add(helper.peek());

            }
        }

        int[] res = new int[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }
        return res;
    }

    public int reverse(int x) {
        // write code here
        long res = 0;
        while (x != 0) {
            res = res * 10 + res % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) res;
    }

    public double maxProduct(double[] arr) {
        double res = arr[0];
        int n = arr.length;
        double[] mina = new double[n];
        double[] maxa = new double[n];
        mina[0] = arr[0];
        maxa[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxa[i] = Math.max(arr[i], Math.max(maxa[i - 1] * arr[i], mina[i - 1] * arr[i]));
            mina[i] = Math.min(arr[i], Math.min(maxa[i - 1] * arr[i], mina[i - 1] * arr[i]));
            res = Math.max(res, maxa[i]);
        }
        return res;

    }



    public int maxLength (int[] arr) {
        // write code here
        Set<Integer> set=new HashSet<>();
        int n=arr.length;
        int maxLen=1;
        int l=0;
        int r=0;
        while (r<n){
            if (!set.contains(arr[r])){
                set.add(arr[r]);
                r++;
            }
            else {
                set.remove(arr[r]);
                l++;
            }
            maxLen=Math.max(maxLen,set.size());
        }
        return maxLen;
    }

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        if (root==null)
            return 0;
        if (root.val==o1 ||root.val==o2){
            return root.val;
        }
        int rl=lowestCommonAncestor(root.left,o1,o2);
        int rr=lowestCommonAncestor(root.right,o1,o2);
        if ((rl & rr) !=0)
            return root.val;
        if (rl!=0){
            return rl;
        }
        if (rr!=0){
            return rr;
        }
        return 0;
    }

    public int maxsumofSubarray (int[] arr) {
        // write code here
        int n=arr.length;
        int[] opt=new int[n];
        opt[0]=arr[0];
        for (int i = 1; i < n; i++) {
          opt[i]=Math.max(opt[i-1]+arr[i],arr[i]);
        }
        Arrays.sort(opt);
        return opt[n-1];

    }

    public int minPathSum (int[][] matrix) {
        // write code here
        int n,m;
        n=matrix.length;
        m=matrix[0].length;
        int[][] opt=new int[n][m];
        opt[0][0]=matrix[0][0];
        for (int i = 1; i < n; i++) {
            opt[i][0]=opt[i-1][0]+matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            opt[0][i]=opt[0][i-1]+matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                opt[i][j]=Math.min(opt[i-1][j],opt[i][j-1])+matrix[i][j];
            }
        }
        return opt[n-1][m-1];
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> list =new ArrayList<>();
        int[] vis=new int[num.length];
        permute1(num,list,lists,vis);
        return lists;
    }
    public void permute1(int[] num,ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists,int[] vis) {
        if (list.size()==num.length){
            ArrayList<Integer> list1=new ArrayList<>();
            list1.addAll(list);
            lists.add(list1);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (vis[i]==0){
                list.add(num[i]);
                vis[i]=1;
                permute1(num,list,lists,vis);
                list.remove(list.size()-1);
                vis[i]=0;
            }
        }
    }

    public String LCS (String s1, String s2) {
        // write code here
        int n1=s1.length();
        int n2=s2.length();

        int[][] opt=new int[n1+1][n2+1];
        StringBuffer sb=new StringBuffer();
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    opt[i][j]=opt[i-1][j-1]+1;
                    sb.append(i-1);
                }
                else {
                    opt[i][j]= Math.max(opt[i][j-1],opt[i-1][j]);
                }
            }
        }
        return sb.toString();
    }

    public int[] LIS (int[] arr) {
        // write code here
        int n=arr.length;
        int[] opt=new int[n];
        for (int i = 0; i < n; i++) {
            opt[i]=1;
            for (int j = 0; j < i; j++) {
                if (arr[j]<arr[i]){
                    opt[i]=Math.max(opt[j]+1,opt[i]);
                }
            }

        }

        int maxv=0,maxp=0;
        for (int i = 0; i < opt.length; i++) {
            if (opt[i]>maxv){
                maxp=i;
                maxv=opt[i];
            }
        }
        int[] res=new int[maxv];
        res[--maxv]=arr[maxp];

        for (int i = maxp; i >= 0; i--) {
            if (arr[i]<arr[maxp]&& opt[i]==opt[maxp]-1){
                res[--maxv]=arr[i];
                maxp=i;
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {

        // write code here

        int k=0;
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if (root==null)
            return lists;
        q.add(root);
        boolean f=true;
        while (!q.isEmpty()){
            TreeNode p=q.poll();
            if (!f)
                list.add(0,p.val);
            else
                list.add(p.val);

            if (p.left!=null){
                q.add(p.left);
                k++;
            }
            if (p.right!=null){
                q.add(p.right);
                k++;
            }
            if (k==q.size()){
                ArrayList<Integer> ll=new ArrayList();
                ll.addAll(list);
                lists.add(ll);
                list.clear();
                k=0;
                f=!f;
            }
        }
        return lists;
    }

    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        // write code here
        int n=arr1.length;
        int l1=0,l2=0;
        int r1=n-1,r2=n-1;
        int m1,m2;
        while (r1!=l1 || r2!=l2){
            m1=(l1+r1)/2;
            m2=(l2+r2)/2;
            if (arr1[m1]==arr2[m2]){
                return arr1[m1];
            }
            if (arr1[m1]<arr2[m2]){
                if ((l1+r1)%2!=0){
                    l1=m1+1;
                    r2=m2;
                }
                else {
                    l1=m1;
                    r2=m2;
                }

            }
            else {
                if ((r1+l1)%2!=0){
                    r1=m1;
                    l2=m2+1;
                }
                else {
                    r1=m1;
                    l2=m2;
                }
            }
        }
        return arr1[r1]<arr2[r2] ? arr1[r1]:arr2[r2];
    }


}
class LRUMap<K,V> extends LinkedHashMap{
    int size;
    LRUMap(int size){
        super(size,0.75f,true);
        this.size=size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size()>size;
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

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val){
        this.val=val;
    }
}