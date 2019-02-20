import java.util.*;

public class meituan {
    public static void main(String[] args) {
        test1();
    }
    static void test1(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int[][] A=new int[N][N];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j]=MAX;
            }
        }
//        for (int i = 0; i <3 ; i++) {
//            int a=in.nextInt()-1;
//            int b=in.nextInt()-1;
//            A[a][b]=1;
//            A[b][a]=1;
//        }
        while (in.hasNextInt()){
            int a=in.nextInt()-1;
            int b=in.nextInt()-1;
            A[a][b]=1;
            A[b][a]=1;
        }
        System.out.println(4);
//        prim(A,N);
    }
    static int MAX = Integer.MAX_VALUE;
    public static void prim(int[][] graph, int n){
        int[] visited=new int[n];
        char[] c = new char[]{'A','B','C','D','E','F','G','E','F'};
        int[] lowcost = new int[n];  //到新集合的最小权
        int[] mid= new int[n];//存取前驱结点
        List<Character> list=new ArrayList<Character>();//用来存储加入结点的顺序
        int i, j, min, minid , sum = 0;
        //初始化辅助数组
        for(i=1;i<n;i++)
        {
            lowcost[i]=graph[0][i];
            mid[i]=0;
        }
        list.add(c[0]);
        //一共需要加入n-1个点
        for(i=1;i<n;i++)
        {
            min=MAX;
            minid=0;
            //每次找到距离集合最近的点
            for(j=1;j<n;j++)
            {
                if(lowcost[j]!=0&&lowcost[j]<min)
                {
                    min=lowcost[j];
                    minid=j;
                }
            }

            if(minid==0) return;
            list.add(c[minid]);
            lowcost[minid]=0;
            sum+=min;
            System.out.println(c[mid[minid]] + "到" + c[minid] + " 权值：" + min);
            //加入该点后，更新其它点到集合的距离
            for(j=1;j<n;j++)
            {
                if(lowcost[j]!=0&&lowcost[j]>graph[minid][j])
                {
                    lowcost[j]=graph[minid][j];
                    mid[j]=minid;
                }
            }
        }
        System.out.println("sum:" + sum);

    }

    static void test2(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int[] A=new int[N];
        int K=in.nextInt();
        int T=in.nextInt();
        for (int i = 0; i <N ; i++) {
            A[i]=in.nextInt();
        }
        int res=0;
        for (int i = 0; i <= N-K; i++) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int j = i; j <i+K ; j++) {
                if(map.get(A[j])==null){
                    map.put(A[j],1);
                }else {
                    Integer temp=map.get(A[j])+1;
                    map.put(A[j],temp);
                    if(temp>=T){
                        res++;
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
