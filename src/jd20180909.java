import java.util.Scanner;

public class jd20180909
{
    public static void main(String args[])
    {

    }
    static void test1(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        while(N > 0)
        {
            N--;
            int aa = in.nextInt();
            int bb = in.nextInt();
            int sss[][] = new int[aa][aa];

            while(bb > 0)
            {
                bb--;
                int i = in.nextInt() - 1;
                int j = in.nextInt() - 1;
                sss[i][j] = 1;
                sss[j][i] = 1;
            }
            int dsss[] = new int[aa];
            for(int i = 0; i < aa; i++)
            {

                for(int j = 0; j < aa; j++)
                {
                    if(sss[i][j]==1) dsss[i]++;
                }
            }
            boolean wwww = true;
            for(int i = 0; i < aa; i++)
            {

                for(int j = i; j < aa; j++)
                {

                    if(!(sss[i][j]==1))
                    {
                        if(dsss[i] != dsss[j])
                        {
                            wwww = false;
                            break;
                        }
                    }
                }
                if(!wwww) break;
            }
            if(!wwww)
            {
                System.out.println("No");
            }
            else
            {
                System.out.println("Yes");
            }
        }
    }
    static void test2(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] A=new int[n][3];
        for (int i = 0; i <n ; i++) {
            A[i][0]=in.nextInt();
            A[i][1]=in.nextInt();
            A[i][2]=in.nextInt();
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                if(A[i][0]<A[j][0]&&A[i][1]<A[j][1]&&A[i][2]<A[j][2]){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}