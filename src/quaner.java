import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class quaner {
    public static void main(String[] args) {
        test2();
    }
    static void test1(){
        Scanner in=new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        String a=line[0];
        String b=line[1];
        int[][] A=new int[a.length()+1][b.length()+1];
        for (int i = 1; i < a.length()+1; i++) {
            for (int j = 1; j <b.length()+1 ; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    A[i][j]=1;
                }
            }
        }
        int max=-1;
        for (int i = 1; i <a.length()+1 ; i++) {
            for (int j = 1; j <b.length()+1 ; j++) {
                if(A[i][j]==1){
                    A[i][j]=A[i-1][j-1]+1;
                    if(A[i][j]>max){
                        max=A[i][j];
                    }
                }
            }
        }
        if(max==-1){
            System.out.println(0);
        }else {
            System.out.println(max);
        }
    }
    static void test2(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] x=new int[10000];
        int[] y=new int[10000];
        for (int i = 0; i <n ; i++) {
            x[i]=in.nextInt();
            y[i]=in.nextInt();
        }
        x[n+1]=x[1];
        y[n+1]=y[1];
        x[n]=x[0];
        y[n]=y[0];
        int flag = 0;
        for(int i=2;i<=n+1;i++)
        {
            int ans =(y[i-1]-y[i-2])*(x[i]-x[i-2])-(x[i-1]-x[i-2])*(y[i]-y[i-2]);
            if(ans>0)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
            System.out.println("NO");
        else
            System.out.println("YES");
    }

}

