import java.util.*;

public class test2 {
    public static void main(String[] argu){
        test3();
    }

    /**
     * 5
     * 1 2 3 3 5
     * 3
     * 1 2 1
     * 2 4 5
     * 3 5 3
     *
     * 样例解释:
     * 有5个用户，喜好值为分别为1、2、3、3、5，
     * 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
     * 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
     * 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
     *
     * 把喜好值作为key，对应该喜好值的人的集合作为value
     * 比如查询5的时候，直接找到所有喜好值为5的人的集合，遍历集合中哪些人在范围内。
     */
    static void test1(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        Integer[] A=new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i]=in.nextInt();
        }
//        List<Integer> list=Arrays.asList(A);
//        Collections.sort(list);
        int Q=in.nextInt();
        int[][] B=new int[Q][3];
        for (int i = 0; i < Q; i++) {
            B[i][0]=in.nextInt();
            B[i][1]=in.nextInt();
            B[i][2]=in.nextInt();
        }
        List<Integer> list=new LinkedList<>();
        for (int i = 0; i < Q; i++) {
            int conut=0;
            for (int j = B[i][0]-1; j <= B[i][1]-1; j++) {
                if(A[j]==B[i][2]){
                    conut++;
                }
            }
            list.add(conut);
        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * n个杂色串珠的手串,手串是一个环形,手串颜色任意连续的m个串珠里至多出现一次
     * 手串上的颜色一共有c种,按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些
     * 判断该手串上有多少种颜色不符合要求,即询问有多少种颜色在任意连续m个串珠中出现了至少两次
     *
     * 首先对每种颜色进行讨论，然后遍历每个串珠，找出拥有这个颜色的串珠的下标，相邻两个下标
     * 之间相减，得出距离，然后与M进行比较，小于M则此颜色至少出现两次，
     * 注意首尾的两个下标要单独讨论
     */
    static void test2(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        int C=in.nextInt();
        List[] B=new List[N];
        for (int i = 0; i < N; i++) {
            B[i]=new LinkedList();
            int temp=in.nextInt();
//            System.out.println(temp);
            B[i].add(temp);
            for (int j = 0; j < temp; j++) {
                B[i].add(in.nextInt());
            }
        }
        List<Integer> list=new LinkedList<>();

//        int[] A=new int[N];
        for (int i = 0; i <C ; i++) {
            List<Integer> location=new LinkedList<>();
            for (int j = 0; j <N ; j++) {
//                A[j]=0;
                for (int k = 1; k <=(Integer) B[j].get(0) ; k++) {
                    if((Integer) B[j].get(k)==i+1){
//                        A[j]=1;
                        location.add(j);
                        break;
                    }
                }
            }
            if(Math.abs(location.get(location.size()-1)-location.get(0)-N)<M){
                list.add(i);
                continue;
            }
            for (int j = 1; j <location.size() ; j++) {
                if(location.get(j)-location.get(j-1)<M){
                    list.add(i);
                    break;
                }
            }

        }
        System.out.println(list.size());

    }
    static void test3(){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        List<String> list=new LinkedList<>();
        for (int i = 0; i <T ; i++) {
            long n=in.nextLong();
            long k=in.nextLong();
            long d1=in.nextLong();
            long d2=in.nextLong();
            if(n-k>=2*d1+d2&&k>=2*d2+d1){
                long temp=n-k-(2*d1+d2);
                if(temp%3==0){
                    list.add("yes");
                    continue;
                }
            }
            if(n-k>=2*d2+d1&&k>=2*d1+d2){
                long temp=n-k-(2*d2+d1);
                if(temp%3==0){
                    list.add("yes");
                    continue;
                }
            }
            if(n-k>=d1+d2&&k>=(Math.max(d1,d2)+Math.abs(d2-d1))){
                long temp=n-k-(d1+d2);
                if(temp%3==0){
                    list.add("yes");
                    continue;
                }
            }
            if(n-k>=(Math.max(d1,d2)+Math.abs(d1-d2))&&k>=(d1+d2)){
                long temp=n-k-(Math.max(d1,d2)+Math.abs(d1-d2));
                if(temp%3==0){
                    list.add("yes");
                    continue;
                }
            }
            list.add("no");
        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }

}
