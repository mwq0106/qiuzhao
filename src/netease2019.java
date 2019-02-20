import java.math.BigInteger;
import java.util.*;

public class netease2019 {
    public static void main(String[] arg){
        netease7();
    }


    public static void netease1(){
        Scanner in=new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int M=Integer.parseInt(line[1]);
        int[] conut=new int[N];
        line=in.nextLine().split(" ");
        for (int i = 0; i <M; i++) {
            conut[Integer.parseInt(line[i])-1]++;
        }
        int res=10000;
        for (int i = 0; i <conut.length; i++) {
            if(conut[i]<=res){
                res=conut[i];
            }
        }
        System.out.println(res);
    }


    public static void netease2(){
        Scanner in=new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int K=Integer.parseInt(line[1]);
        line=in.nextLine().split(" ");
        int[] A=new int[N];
        for (int i = 0; i < line.length; i++) {
            A[i]=Integer.parseInt(line[i]);
        }
        line=in.nextLine().split(" ");
        int[] awake=new int[N];
        for (int i = 0; i < awake.length; i++) {
            awake[i]=Integer.parseInt(line[i]);
        }
        int sum=0;
        for (int i = 0; i < N; i++) {
            if(awake[i]==1){
                sum+=A[i];
            }
        }
        int res=sum;
        for (int i = 0; i < N-K; i++) {

            int temp=0;
            int temp2=0;
            for (int j = i; j < K+i; j++) {
                temp+=A[j];
                if(awake[j]==1){
                    temp2+=A[j];
                }
            }

            if((sum-temp2+temp)>res){
                res=sum-temp2+temp;
            }
        }
        System.out.println(res);
    }

    /**
     * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
     * 二分查找
     */
    public static void netease3(){
        Scanner in=new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        String[] LINE=in.nextLine().split(" ");
        int M=Integer.parseInt(in.nextLine());
        String[] tempLine=in.nextLine().split(" ");

        int conut=0;

        int[] sum=new int[N];
        for (int i = 0; i < N; i++) {
            conut+=Integer.parseInt(LINE[i]);
            sum[i]=conut;
        }
        for (int i = 0; i < M; i++) {
            int start=0,end=N-1,mid=0;
            boolean flag=false;
            while (start<=end){
                mid=(start+end)/2;
                if(sum[mid]>Integer.parseInt(tempLine[i])){
                    end=mid-1;
                }else if(sum[mid]<Integer.parseInt(tempLine[i])){
                    start=mid+1;
                }else {
                    System.out.println(mid+1);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println(1+Math.max(start,end));
            }
        }

    }

    public static void netease5(){
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        int res=0;
        for (int i = 0; i < 4; i++) {
            if(i==0){
                for (int j = 0; j < 3; j++) {
                    if(j==0){
                        int temp=a+b+c;
                        if(temp>res){
                            res=temp;
                        }
                    }
                    if(j==1){
                        int temp=(a+b)+c;
                        if(temp>res){
                            res=temp;
                        }
                    }
                    if(j==2){
                        int temp=a+(b+c);
                        if(temp>res){
                            res=temp;
                        }
                    }
                }
            }
            if(i==1){
                for (int j = 0; j < 3; j++) {
                    if(j==0){
                        int temp=a+b*c;
                        if(temp>res){
                            res=temp;
                        }
                    }
                    if(j==1){
                        int temp=(a+b)*c;
                        if(temp>res){
                            res=temp;
                        }
                    }
                    if(j==2){
                        int temp=a+(b*c);
                        if(temp>res){
                            res=temp;
                        }
                    }
                }
            }
            if(i==2){
                for (int j = 0; j < 3; j++) {
                    if(j==0){
                        int temp=a*b*c;
                        if(temp>res){
                            res=temp;
                        }
                    }
                    if(j==1){
                        int temp=(a*b)*c;
                        if(temp>res){
                            res=temp;
                        }
                    }
                    if(j==2){
                        int temp=a*(b*c);
                        if(temp>res){
                            res=temp;
                        }
                    }
                }
            }
            if(i==3){
                for (int j = 0; j < 3; j++) {
                    if(j==0){
                        int temp=a*b+c;
                        if(temp>res){
                            res=temp;
                        }
                    }
                    if(j==1){
                        int temp=(a*b)+c;
                        if(temp>res){
                            res=temp;
                        }
                    }
                    if(j==2){
                        int temp=a*(b+c);
                        if(temp>res){
                            res=temp;
                        }
                    }
                }
            }
        }
        System.out.println(res);

    }
    public static void netease6(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int K=in.nextInt();
        int[] A=new int[N];
        for (int i = 0; i < N; i++) {
            A[i]=in.nextInt();
        }
        Integer maxNum=0,max=-1,min=-1,minNum=10000;
        List<String> list=new LinkedList<>();
        Integer s=0;
        for (int i = 0; i < K; i++) {
            maxNum=0;
            minNum=10000;
            max=-1;
            min=-1;
            for (int j = 0; j <N ; j++) {
                if(A[j]<minNum){
                    min=j;
                    minNum=A[j];
                }
                if(A[j]>maxNum){
                    maxNum=A[j];
                    max=j;
                }
            }
            s=maxNum-minNum;
            if(s<2){
                System.out.println("0 "+Integer.valueOf(i).toString());
                for (String s1:list){
                    System.out.println(s1);
                }
                return;
            }
            list.add(Integer.valueOf(max+1).toString()+" "+Integer.valueOf(min+1).toString());
            A[min]++;
            A[max]--;
        }
        maxNum=0;
        minNum=10000;
        for (int j = 0; j <N ; j++) {
            if(A[j]<minNum){
                minNum=A[j];
            }
            if(A[j]>maxNum){
                maxNum=A[j];
            }
        }
        s=maxNum-minNum;
        if(s<2){
            System.out.println("0 "+Integer.valueOf(K).toString());
            for (String s1:list){
                System.out.println(s1);
            }
            return;
        }else {
            System.out.println(Integer.valueOf(s).toString()+" "+Integer.valueOf(K).toString());
            for (String s1:list){
                System.out.println(s1);
            }
        }

    }

    /**
     * 字典内的每个单词都包含n个'a'和m个'z', 并且所有单词按照字典序排列，求第K个单词
     *
     * 假设第一个字符为a，则剩下n-1个'a'和m个'z'组成的子序列只能构成count(n-1+m,n-1)个单词，
     * 且是字典中前count(n-1+m,n-1)个单词。
     * 比较k和count(n-1+m,n-1)，若k小，说明k是前count(n-1+m,n-1)个单词，
     * 则第一个字符必为'a'。子问题化为在子序列(n-1个'a'和m个'z')找到第k个单词
     * 若k大，则说明第一个字符必为'z',单词是以'z'开头的单词中的第k-count(n-1+m,n-1)个。
     * 子问题化为在子序列(n个'a'和m-1个'z')找到第k-count(n+m-1,m-1)个单词。
     *
     * 关键也在于count(n-1+m,n-1)的计算，不能先只计算分子，然后计算分母，最后两者相除，
     * 这样会超出范围，应该同时计算分子加分母，即使这样，100 100的情况依然会超范围
     * 所以在计算过程当中判断结果是否大于K，如果大于直接返回结果
     */
    static void netease7(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        k=in.nextInt();
        StringBuffer sb=new StringBuffer();
        long res=g(n,n+m);
        if(res!=-1&&k>res){
            System.out.println("-1");
            return;
        }
        if(k==res){
            for (int i = 0; i <m ; i++) {
                sb.append("z");
            }
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            System.out.println(sb.toString());
            return;
        }
        while (true){
            long temp=g(Math.max(n-1,m),m+n-1);
            if(temp==-1){
                sb.append("a");
                n-=1;
            }else if(temp<k){
                sb.append("z");
                m-=1;
                k=k-temp;
            }else {
                sb.append("a");
                n-=1;
                for (int i = 0; i <m ; i++) {
                    sb.append("z");
                }
                for (int i = 0; i < n; i++) {
                    sb.append("a");
                }
                break;
            }
        }
        System.out.println(sb.toString());
    }
    static long k;
    /**
     * count(n-1+m,n-1)的计算
     * @param a
     * @param b
     * @return
     */
    static long g(int a, int b){
        long  temp=1;
        a=Math.min(b-a,a);
        if(a==0){
            return 1;
        }
        for (int i = 0; i <a ; i++) {
            temp*=(b-i);
            temp/=(i+1);
            if(temp>k){
                return -1;
            }
        }
        return temp;
    }
}
