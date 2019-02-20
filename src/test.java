import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class test {

    public static void main(String[] args) {
        mergeQujian();
    }

    /**
     * 若一序列进栈顺序为a1,a2,a3,a4，问存在多少种可能的出栈序列 15
     * 记住公式： C(2n,n)/(n+1)即结果=（8*7*6*5）/4*3*2*1/5=14
     */

    /**
     * 字节跳动
     * 多个关注的主播，每个主播开播时间都是一个区间，一天被划分为多个单位，
     * 一天最多看多少个主播
     * 先按区间右端点排序，从最小右端点开始，选出从零点以后开始的区间，
     * 再从这个右端点找到下一个最邻近的右端点，并且它的区间的左端点大于当前右端点
     * 一直到最后0点。边界处理比较麻烦
     * 这里做错了，做成了以左端点排序，思路与代码指得参考
     */
    static void test5_0812(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        B[] A=new B[n];
//        A[0]=new B(0,0);
        for (int i = 0; i <n ; i++) {
            int a=in.nextInt();
            int b=in.nextInt();
            A[i]=new B(a,b);
        }
        Arrays.sort(A);
        int temp=A.length;
        for (int i = 0; i < n; i++) {
            if(A[i].x>=m){
                temp=i;
                break;
            }
        }
        B[] C=Arrays.copyOfRange(A,0,temp);
        if(C.length==0){
            System.out.println(0);
            return;
        }
        int min=C[0].y;
        int current=C[0].x;
        int last=C[C.length-1].x;
        if(last==current){
            for (int i = 0; i <C.length ; i++) {
                if(C[i].y==0||C[i].y<m){
                    System.out.println("1");
                    return;
                }
            }
        }
        int count=0;
        int index=0;
        for (int i = 0; i <C.length ; i++) {
            if(current!=C[i].x){
                if(C[i].x!=last){
                    current=C[i].x;
                    min=C[i].y;
                    count++;
                }else {
                    count++;
                    index=i;
                    break;
                }
            }else if(C[i].y<min &&C[i].y>current){
                min=C[i].y;
            }
        }
        for (int i = index; i <C.length ; i++) {
            if(C[i].y==0||C[i].y<m){
                count++;
                break;
            }
        }
        System.out.println(count);
    }
    static class B implements Comparable<B>{
        int x;
        int y;
        public B(int a,int b){
            x=a;
            y=b;
        }
        @Override
        public int compareTo(B o) {
            if(x<o.x){
                return -1;
            }else if(x>o.x){
                return 1;
            }
            return 0;
        }
    }
    /**
     * 多个字区间重叠，进行区间合并
     * 区间按左端点排序
     * 维护一个left和right值，表示当前已有的连续区间的左端点和右端点
     * 下一个区间的左端点如果大于right，则必然不能合并，取下一组left和right值，否则更新right
     *
     * 此处实现了Comparable接口使用java自带的排序方法指的借鉴
     */
    static void mergeQujian(){
        int n=3;
        int[] A={1,10,32,45,78,94,5,16,80,100,200,220,16,32};
        qujian[] qujians=new qujian[A.length/2];
        for (int i = 0; i <A.length ; i+=2) {
            qujians[i/2]=new qujian(A[i],A[i+1]);
        }
        Arrays.sort(qujians);
        for (int i = 0; i <qujians.length ; i++) {
            System.out.println(qujians[i].left+"-"+qujians[i].right);
        }
        System.out.println("-----");
        List<qujian> list=new LinkedList<>();
        int left=-1;
        int right=-1;
        for (int i = 0; i <qujians.length  ; i++) {
            if(qujians[i].left>right){
                list.add(new qujian(left,right));
                left=qujians[i].left;
                right=qujians[i].right;
            }else if(qujians[i].right>right){
                right=qujians[i].right;
            }
        }
        list.add(new qujian(left,right));
        for (int i = 1; i <list.size() ; i++) {
            System.out.println(list.get(i).left+","+list.get(i).right);
        }
    }
    static class qujian implements Comparable<qujian>{
        int left;
        int right;
        public qujian(int a,int b){
            left=a;
            right=b;
        }
        @Override
        public int compareTo(qujian o) {
            if(this.left<o.left){
                return -1;
            }else if(this.left>o.left){
                return 1;
            }
            return 0;
        }
    }

    public static void case3(int[] num){
        Set<Integer> integers=new HashSet<>();
        for (int i = 0; i <num.length; i++) {
            while (num[i]!=i){
                if(num[i]==num[num[i]]){
                    integers.add(num[i]);
                    i++;
                    if(i<num.length){
                        continue;
                    }else break;
                }
                int temp=num[i];
                num[i]=num[temp];
                num[temp]=temp;
            }
        }
        Iterator iterator=integers.iterator();
        while (iterator.hasNext()){
            Integer integer=(Integer) iterator.next();
            iterator.remove();
            System.out.println(integer);
        }
    }
    public static void test1(){
        Integer N=3;
        int num=0,i=1;
        while (true){
            i*=2;
            if(i>N){
                i=i/2;
                num++;
                N=N-i;
                i=1;
                if(N==0){
                    System.out.println(num);
                    return;
                }
            }
        }

    }

    public static int trace(String num){
        int len = num.length();
        if (len==1){
            return 1;
        }else if (len==2) {
            if (Integer.parseInt(num)<=26){
                return 2;
            }else {
                return 1;
            }
        }else{
            return trace(num.substring(1,len))+
                    ((trace(num.substring(0,2)))-1)*trace(num.substring(2,len));
        }
    }

    /**
     * 走台阶，一次只能走一步或者两步，分治法
     * @param num
     * @return
     */
    public static int trace2(int num){
        if(num==1){
            return 1;
        }else if(num==2){
            return 2;
        }else {
            return trace2(num-1)+trace2(num-2);
        }
    }
    public static void test2(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int[] M=new int[N];
        if(N<6){
            System.out.println(N+1);
            return;
        }
        for (int i = 0; i <6 ; i++) {
            M[i]=i+1;
        }
        for (int i = 6; i <= N; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j <=i-2 ; j++) {
                int temp=M[j]*2;
                if(temp>M[i-2]&&temp<min){
                    min=temp;
                }
                temp=M[j]*3;
                if(temp>M[i-2]&&temp<min){
                    min=temp;
                }
                temp=M[j]*5;
                if(temp>M[i-2]&&temp<min){
                    min=temp;
                }
            }
            M[i-1]=min;
        }
        System.out.println(M[N-1]);
    }

    /**
     * 从1到n台阶，每次可以走任意多步，有多少种走法
     * 分治法或者说递归，从当前位置，可以一次走1到n步，得到n种情况，即子问题
     * @param num
     * @return
     */
    static int trace3(int num){
        if(num==1){
            return 1;
        }else if(num==2){
            return 2;
        }else {
            int temp=1;
            for (int i = 1; i <=num-1 ; i++) {
                temp+=trace3(num-i);
            }
            return temp;
        }
    }

    /**
     * 路由器子网地址去重
     * ip地址转为二进制，对所有IP地址遍历，如果遍历的IP的子网长度n大于当前IP地址
     * 的子网长度m并且遍历的IP地址的前m为等于当前IP地址，则将遍历的IP地址放入重复
     * 集合当中
     */
    static void luyouqi(){
        Scanner in=new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        String[][] M=new String[N][2];
        String[] R=new String[N];
        for (int i = 0; i < N; i++) {
            String s=in.nextLine();
            R[i]=s;
            M[i][0]=format(s.split("/")[0]);
            M[i][1]=s.split("/")[1];
        }
        Set<String> set=new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j!=i&&Integer.parseInt(M[i][1])<=Integer.parseInt(M[j][1])){
                    if(M[i][0].substring(0,Integer.parseInt(M[i][1])).equals(M[j][0].substring(0,Integer.parseInt(M[i][1])))){
                        set.add(M[j][0]+M[j][1]);
                    }
                }
            }
        }
        List<String> res=new LinkedList<>();
        for (int i = 0; i <N ; i++) {
            if(!set.contains(M[i][0]+M[i][1])){
                res.add(R[i]);
            }
        }
        System.out.println(res.size());
        for(String s:res){
            System.out.println(s);
        }
    }

    /**
     * Integer.toBinaryString整数转二进制函数
     * @param s
     * @return
     */
    static String format(String s){
        String[] temp=s.split("\\.");
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < temp.length; i++) {
            String stemp=Integer.toBinaryString(Integer.parseInt(temp[i]));
            for (int j = 0; j <8-stemp.length() ; j++) {
                sb.append("0");
            }
            sb.append(stemp);
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 几种钱币种类组成一个大的数额有多少种组法
     * 动态规划
     * 先遍历钱币数量，即行，然后遍历列，即数额，n行代表必须使用第n-1种钱币，
     * 减去第n-1种钱币数额即是子问题
     */
    static void moneyCount(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        long[] A=new long[N+1];
        A[0]=1;
        int[] C=new int[6];
        C[0]=1;C[1]=5;C[2]=10;C[3]=20;C[4]=50;C[5]=100;
        for (int i = 0; i <=5 ; i++) {
            for (int j = 1; j <=N ; j++) {
                if(C[i]<=j){
                    A[j]=A[j]+A[j-C[i]];
                }
            }
        }
        System.out.println(A[N]);
    }
    static void largestArea(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int[] A=new int[N];
        for (int i = 0; i < N; i++) {
            int temp=in.nextInt();
            A[i]=temp;
        }
        System.out.println(largestArea(A));
    }

    /**
     * 寻找柱状图中找到能组成的最大矩形的面积
     * 分治法：最大矩形面积只可能有三种情况：
     * 1. 取决于高度最小的柱子，此时面积等于高度乘总长度；
     * 2. 最大面积出现在高度最小的柱子左边；
     * 3. 最大面积出现在高度最小的柱子右边；
     * Arrays.copyOfRange()，数组复制函数
     * @param A
     * @return
     */
    static int largestArea(int[] A){
        if(A.length==1){
            return A[0];
        }else {
            int minIndex=-1;
            int temp=10000000;
            for (int i = 0; i < A.length; i++) {
                if(A[i]<temp){
                    temp=A[i];
                    minIndex=i;
                }
            }
            int A1=A[minIndex]*A.length;
            int A2=0,A3=0;
            if(minIndex!=0){
                A2=largestArea(Arrays.copyOfRange(A,0,minIndex));
            }
            if(minIndex!=A.length-1){
                A3=largestArea(Arrays.copyOfRange(A,minIndex+1,A.length));
            }
            if(A1>=A2&&A1>=A3){
                return A1;
            }else {
                return Math.max(A2,A3);
            }
        }
    }

    /**
     *给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。
     * 一个串为x轴，一个串为y轴，坐标处两坐标对应的字母相等则为1，计算所有对角线连续1的最大长度
     *
     */
    static void maxSubString(){
        Scanner in=new Scanner(System.in);
        String s1=in.nextLine();
        String s2=in.nextLine();
        char[] A1=new char[s1.length()+1];
        char[] A2=new char[s2.length()+1];
        int[][] A=new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i < s1.length()+1; i++) {
            A1[i]=s1.charAt(i-1);
        }
        for (int i = 1; i < s2.length()+1; i++) {
            A2[i]=s2.charAt(i-1);
        }
        int maxlength=0;
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                if(A1[i]==A2[j]){
                    A[i][j]=A[i-1][j-1]+1;
                    if(A[i][j]>maxlength){
                        maxlength=A[i][j];
                    }
                }
            }
        }
        System.out.println(maxlength);
    }

    /**
     * 判断一个string是否是另一个string的子串
     * string库(0<N <= 500)
     * 对给定的string,它是库中多少个string的子串
     *
     */
    static void chubaoSubstring(){
        Scanner in=new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        String[] All=new String[N];
        for (int i = 0; i <N ; i++) {
            All[i]=in.nextLine();
        }
        List<Integer> res=new LinkedList<>();
        while (in.hasNextLine()){
            String temp=in.nextLine();
            if(temp.equals("")){
                break;
            }
            int M=Integer.parseInt(temp);
            Set<Integer> stringSet=new HashSet<>();
            String[] testcase=new String[M];
            for (int i = 0; i <M ; i++) {
                testcase[i]=in.nextLine();
                for (int j = 0; j <N ; j++) {
                    if(All[j].length()>=testcase[i].length()){
                        for (int k = 0; k <=All[j].length()-testcase[i].length() ; k++) {
                            boolean flag=true;
                            for (int l = 0; l <testcase[i].length() ; l++) {
                                if(testcase[i].charAt(l)!=All[j].charAt(k+l)){
                                    flag=false;
                                }
                            }
                            if(flag){
                                stringSet.add(j);
                                break;
                            }
                        }
                    }
                }
            }
            res.add(stringSet.size());
        }
        for (int i = 0; i <res.size() ; i++) {
            System.out.println(res.get(i));
        }

    }
    static void jdSet(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            HashSet<Integer> hashset = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                hashset.add(in.nextInt());
            }
            for (int i = 0; i < m; i++) {
                hashset.add(in.nextInt());
            }
            Object[] arr = hashset.toArray();
            int[] array = new int[arr.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) arr[i];
            }
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
    static void charNumSort(){
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j <s.length() ; j++) {
                if((s.charAt(j)-'a')==i){
                    sb.append(Character.toChars(i+'a'));
                }
            }
        }
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <s.length() ; j++) {
                if(s.charAt(j)-'0'==i){
                    sb.append(Character.toChars(i+'0'));
                }
            }
        }
        System.out.println(sb.toString());
    }
    /**
     * 很多柱子，最大水池
     * @param
     */
    public static void shuichi()
    {
        int N=13;
        int[] A={0,3,0,1,3,5,0,0,5,0,1,0,3};

        List<Integer> highestList=new LinkedList<>();
        int high=-1;
        for (int i = 0; i <N ; i++) {
            if(A[i]>high){
                high=A[i];
                highestList=new LinkedList<>();
                highestList.add(i);
            }else if(A[i]==high){
                highestList.add(i);
            }
        }
        int res=0;
        for (int i = 0; i <N ; i++) {
            if(A[i]==high){
                break;
            }
            int temp=A[i];
            int count=0;
            for (int j = i+1; j <N ; j++) {
                if(temp>A[j]){
                    count+=(temp-A[j]);
                    if(count>res){
                        res=count;
                    }
                }else {
                    i=j-1;
                    break;
                }
            }
        }
        for (int i = N-1; i >=0 ; i--) {
            if(A[i]==high){
                break;
            }
            int temp=A[i];
            int count=0;
            for (int j = i-1; j >=0 ; j--) {
                if(temp>A[j]){
                    count+=(temp-A[j]);
                    if(count>res){
                        res=count;
                    }
                }else {
                    i=j+1;
                    break;
                }
            }
        }
        for (int i = 0; i <highestList.size()-1 ; i++) {
            int count=0;
            for (int j = highestList.get(i)+1; j <highestList.get(i+1) ; j++) {
                count+=(high-A[j]);
            }
            if(count>res){
                res=count;
            }
        }
        System.out.println(res);
    }
}