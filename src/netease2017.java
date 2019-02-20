import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.lang.Math;
public class netease2017 {

    public static void main(String[] args) {
        netease10();
    }
    public static void netease1(){
        Scanner in=new Scanner(System.in);
        String num=in.nextLine();
        String line=in.nextLine();
        List<String> list=new LinkedList<>();
        list= Arrays.asList(line.split(" "));
        List<String> showList=new LinkedList<>();
        for (int i=list.size()-1;i>=0;i--){
            boolean have=false;
            for(String s:showList){
                if(s.equals(list.get(i))){
                   have=true;
                   break;
                }
            }
            if(have==false){
                showList.add(list.get(i));
            }
        }
        for (int i=showList.size()-1;i>0;i--){
            System.out.print(showList.get(i)+" ");
        }
        System.out.print(showList.get(0));
    }

    /**
     * 动态规划，01背包问题
     */
    public static void netease2(){
        Scanner in=new Scanner(System.in);
        String num=in.nextLine();
        String line=in.nextLine();
        List<String> list;
        list= Arrays.asList(line.split(" "));
        List<Integer> integerList=new LinkedList<>();
        int alltime=0;
        for(String s:list){
            integerList.add(Integer.parseInt(s)/1024);
            alltime+=Integer.parseInt(s)/1024;
        }
        int halftime=alltime/2;
        Integer lenth=Integer.parseInt(num);
        Integer[][] m=new Integer[lenth+1][halftime+1];
        for(int i=0;i<lenth+1;i++){
            for (int j=0;j<halftime+1;j++){
                m[i][j]=0;
            }
        }
        for(int i=1;i<=lenth;i++){
            for(int j=1;j<=halftime;j++){
                if(j<integerList.get(i-1)){
                    m[i][j]=m[i-1][j];
                }else {
                    if(m[i-1][j]>=(m[i-1][j-integerList.get(i-1)]+integerList.get(i-1))){
                        m[i][j]=m[i-1][j];
                    }else {
                        m[i][j]=m[i-1][j-integerList.get(i-1)]+integerList.get(i-1);
                    }
                }
            }
        }
        int longtime=alltime-m[lenth][halftime];
        System.out.println(longtime*1024);
    }

    /**
     * 动态规划，01背包问题空间优化
     */
    public static void netease2_2(){
        Scanner in=new Scanner(System.in);

        int lenth=Integer.parseInt(in.nextLine());

        String[] list= in.nextLine().split(" ");
        int[] integerList=new int[lenth];
        int alltime=0;
        for(int i=0;i<list.length;i++){
            integerList[i]=Integer.parseInt(list[i])/1024;
            alltime+=integerList[i];
        }

        int halftime=alltime/2;

        int[] m=new int[halftime+1];
        for(int i=0;i<halftime+1;i++){
            m[i]=0;
        }
        for(int i=1;i<=lenth;i++){
            for(int j=halftime;j>0;j--){
                if(j>=integerList[i-1]){
                    m[j]=Math.max(m[j],m[j-integerList[i-1]]+integerList[i-1]);
                }
            }
        }
        int longtime=alltime-m[halftime];
        System.out.println(longtime*1024);
    }
    public static void netease3(){
        Scanner in=new Scanner(System.in);
        int textPointNum=Integer.parseInt(in.nextLine());
        String[] tXTemp=in.nextLine().split(" ");
        String[] tYTemp=in.nextLine().split(" ");
        int[] tx=new int[textPointNum];
        int[] ty=new int[textPointNum];
        for(int i=0;i<textPointNum;i++){
            tx[i]=Integer.parseInt(tXTemp[i]);
            ty[i]=Integer.parseInt(tYTemp[i]);
        }
        String[] temp=in.nextLine().split(" ");
        int gx=Integer.parseInt(temp[0]);
        int gy=Integer.parseInt(temp[1]);
        temp=in.nextLine().split(" ");
        int walkTime=Integer.parseInt(temp[0]);
        int taxiTime=Integer.parseInt(temp[1]);

        int gDistance=Math.abs(gx)+Math.abs(gy);
//        int[] textCost=new int[textPointNum];
        int cost=gDistance*walkTime;
        for(int i=0;i<textPointNum;i++){
            int tempdis=Math.abs(tx[i])+Math.abs(ty[i]);
            int tempdis2=Math.abs(tx[i]-gx)+Math.abs(ty[i]-gy);
            int textCost=tempdis*walkTime+tempdis2*taxiTime;
            if(textCost<cost){
                cost=textCost;
            }
        }
        System.out.println(cost);
    }
    public static void netease4(){
        Scanner in=new Scanner(System.in);
        String line=in.nextLine();
        int temp1=0;//B
        int temp2=0;//G
        int BC=0;
        int GC=0;
        for(int i=0;i<line.length();i++){
            char T=line.charAt(i);
            if(T=='B'){
                temp1+=(i-BC);
                BC+=1;
            }else if(T=='G'){
                temp2+=(i-GC);
                GC+=1;
            }
        }
        System.out.println(Math.min(temp1,temp2));
    }

    /**
     * 递推矩阵，快速幂，稀疏矩阵的相乘
     */
    public static void netease5(){
        Scanner in=new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int k=Integer.parseInt(line[1]);
        line=in.nextLine().split(" ");
        int[][] T0=new int[1][n];
        for(int i=0;i<line.length;i++){
            T0[0][i]=Integer.parseInt(line[i]);
        }
        int[][] T=new int[n][n];
        for(int i=0;i<n;i++){//列
            for(int j=0;j<n;j++){//行
                if(j==i){
                    T[j][i]=1;
                    if(j!=n-1){
                        T[j+1][i]=1;
                    }else {
                        T[0][j]=1;
                    }
                }
            }
        }
        T=pow(T,k);
        int[][] RT=mul(T0,T);

        for(int j=0;j<RT[0].length-1;j++){
            System.out.print(RT[0][j]+" ");
        }
        System.out.print(RT[0][RT[0].length-1]);

    }

    /**
     * 矩阵的快速幂
     * @param T
     * @param k
     * @return
     */
    public static int[][] pow(int[][] T,int k){
        int[][] R=T;
        int[][] ans=new int[T.length][T.length];
        for(int i=0;i<T.length;i++){
            ans[i][i]=1;
        }
        while (k>0){
            if(k%2==1){
               ans=mul(ans,R);
            }
            R=mul(R,R);
            k>>=1;
        }
        return ans;
    }

    /**
     * 普通矩阵乘法
     * @param a
     * @param b
     * @return
     */
    public static int[][] mul2(int[][] a,int[][] b){
        int[][] T=new int[a.length][b[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b[0].length;j++){
                T[i][j]=0;
                for(int k=0;k<a[0].length;k++){
                    T[i][j]+=a[i][k]*b[k][j];
                }
                if(T[i][j]>=100){
                    T[i][j]=T[i][j]%100;
                }
            }
        }

        return T;
    }

    /**
     * 稀疏矩阵乘法
     * @param a
     * @param b
     * @return
     */
    public static int[][] mul(int[][] a,int[][] b){
        int[][] T=new int[a.length][b[0].length];
        for(int i=0;i<a.length;i++){
            for(int k=0;k<b[0].length;k++){
                if(a[i][k]!=0){
                    for(int j=0;j<b[0].length;j++){
                        T[i][j]+=a[i][k]*b[k][j];
                        if(T[i][j]>=100){
                            T[i][j]=T[i][j]%100;
                        }
                    }
                }
//                T[i][j]=0;
//                for(int k=0;k<a[0].length;k++){
//                    T[i][j]+=a[i][k]*b[k][j];
//                }
//                if(T[i][j]>=100){
//                    T[i][j]=T[i][j]%100;
//                }
            }
        }

        return T;
    }

    /**
     * 深度优先搜索，递归
     */
    static class netease6{
        int[] work=new int[6];
        int count;
        int[][] worker;
        int workerNum;
        public void start(){
            Scanner in=new Scanner(System.in);
            workerNum=Integer.parseInt(in.nextLine());
            worker=new int[workerNum][6];
            for(int i=0;i<workerNum;i++){
                String line=in.nextLine();
                for(int j=0;j<line.length();j++){
                    worker[i][((int) line.charAt(j))-48]=1;
                }
            }
            dfs(0);
            System.out.println(count);
        }
        public  void dfs(int n){
            if(n==workerNum){
                count++;
                return;
            }else {
                for(int i=0;i<6;i++){
                    if(work[i]==0 && worker[n][i]==1){
                        work[i]=1;
                        dfs(n+1);
                        work[i]=0;
                    }
                }
            }
        }
    }

    /**
     * 集合的使用还需增强
     */
    public static void netease7(){
        Scanner in=new Scanner(System.in);
        String[] list=in.nextLine().split(" ");
        int W=Integer.parseInt(list[0]),X=Integer.parseInt(list[1]),Y=Integer.parseInt(list[2]),Z=Integer.parseInt(list[3]);
        Set<Double> set=new HashSet<>();
        for(int i=W;i<=X;i++){
            for(int j=Y;j<=Z;j++){
                set.add((double) i/(double) j);
            }
        }
        System.out.println(set.size());
    }

    /**
     * 表达式求值3+5*7，这里没看清题目意思，参与计算的数字只有0~9，所以不需要考虑两位数
     */
    public static void netease8(){
//        String test="-+*09";
        //45
        //43
        //42
        //48
        //57
//        for (int i=0;i<test.length();i++){
//            System.out.println((int) test.charAt(i));
//        }
        Scanner in=new Scanner(System.in);
        String line=in.nextLine();
        int res=0;
        boolean firstNum=true;
        StringBuffer stringBuffer=new StringBuffer();
        int lastop=0;
        for(int i=0;i<line.length();i++){
            int temp=(int) line.charAt(i);
            if(temp<=57&&temp>=48){
                stringBuffer.append(temp-48);
//                System.out.println(stringBuffer.toString());
            }else {
                int temp2=Integer.parseInt(stringBuffer.toString());
                if(firstNum){
                    res=temp2;
                    firstNum=false;
                    lastop=(int) line.charAt(i);
                    stringBuffer=new StringBuffer();
                }else {
                    if(lastop==45){
                        res=res-temp2;
                        stringBuffer=new StringBuffer();
                        lastop=(int) line.charAt(i);
                    }else if(lastop==43){
                        res=res+temp2;
                        stringBuffer=new StringBuffer();
                        lastop=(int) line.charAt(i);
                    }else if(lastop==42){
                        res=res*temp2;
                        stringBuffer=new StringBuffer();
                        lastop=(int) line.charAt(i);
                    }
                }
            }
        }
        if(lastop!=0){
            int temp2=Integer.parseInt(stringBuffer.toString());
            if(lastop==45){
                res=res-temp2;
            }else if(lastop==43){
                res=res+temp2;
            }else if(lastop==42){
                res=res*temp2;
            }
        }else {
            res=Integer.parseInt(stringBuffer.toString());
        }
        System.out.println(res);
    }

    /**
     * 思路不错，使用dataArray[i+1]算数符右边的位来存储结果，下一次运算直接使用右边的来与下一个数运算，迭代
     * 此函数是错的，负数的情况明显不对，正数比较大也不对，用char型保存int型会有问题
     */
    public static void netease8_2(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int sum = 0;
        char dataArray[] = s.toCharArray();
        for(int i = 0;i < dataArray.length - 1;i ++){
            switch(dataArray[i]) {
                case '+':
                    sum = dataArray[i-1] + dataArray[i+1]-96;
                    dataArray[i+1] = (char) (sum+48);
                    break;
                case '-':
                    sum = dataArray[i-1] - dataArray[i+1];
                    dataArray[i+1] = (char) (sum+48);
                    break;
                case '*':
                    sum = (dataArray[i-1]-48) * (dataArray[i+1]-48);
                    dataArray[i+1] = (char) (sum+48);
                    break;
                default:
                    break;
            }
        }
        sc.close();
        System.out.println(sum);
    }
    public static void netease9(){
        Scanner in=new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        int[][] M=new int[N][N];
        for (int i=0;i<N;i++){
            String line=in.nextLine();
            for(int j=0;j<N;j++){
                if(line.charAt(j)=='B'){
                    M[i][j]=1;
                }else M[i][j]=0;
            }
        }
        int sum=0;
        for(int i=0;i<N;i++){
            int tmpMax=0;
            int last=2;
            for(int j=0;j<N;j++){
                if(M[j][i]==last){
                    tmpMax++;
                }else {
                    last=M[j][i];
                    if(tmpMax>sum){
                        sum=tmpMax;
                    }
                    tmpMax=1;
                }
            }
            if(tmpMax>sum){
                sum=tmpMax;
            }
        }
        System.out.println(sum);
    }

    /**
     * set集合的使用
     */
    public static void netease10(){
        Scanner in=new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int M=Integer.parseInt(line[1]);
        line=in.nextLine().split(" ");

        Set<String> rem=new HashSet<>();
        for (int i=0;i<N;i++){
            rem.add(line[i]);
        }
        line=in.nextLine().split(" ");
        long sum=0;
        for (int i=0;i<M;i++){
            if(rem.contains(line[i])){
                sum+=line[i].length()*line[i].length();
            }
        }
        System.out.println(sum);
    }

    public static void netease11(){
        Scanner in=new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        String[] list=in.nextLine().split(" ");
        int all=0;
        int[] heightList=new int[N];
        for (int i=0;i<list.length;i++){
            all+=Integer.parseInt(list[i]);
            heightList[i]=Integer.parseInt(list[i]);
        }
        if(all%2!=0){
            System.out.println("-1");
            return;
        }
        int half=all/2;
        int[][] T=new int[N+1][half+1];
        for (int i=1;i<=N;i++){
            for (int j=1;j<=half;j++){
                if(j<heightList[i-1]){
                    T[i][j]=T[i-1][j];
                }else {
                    T[i][j]=Math.max(T[i-1][j],T[i-1][j-heightList[i-1]]+heightList[i-1]);
                }
            }
        }
        System.out.println(half);
    }
    public static void netease12(){
        Scanner in=new Scanner(System.in);

        long K=Long.parseLong(in.nextLine());

    }

}
