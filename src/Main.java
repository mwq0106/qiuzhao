import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        test2();
    }
    static void test1() {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] res=new int[n];
        res[0]=in.nextInt();
        for (int i = 1; i <n ; i++) {
            res[i]=res[i-1]+in.nextInt();
        }
        int max=0;
        int last=n-1;
        for (int i = 0; i <n/2+1 ; i++) {
            int sum=res[i];
            for (int j = last; j >=i ; j--) {
                if(res[n-1]-res[j]>sum){
                    last=j;
                    break;
                }else if(res[n-1]-res[j]==sum){
                    max=sum;
                }
            }
        }
        System.out.println(max);
    }
    static void test2(){
        Scanner in = new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        int[] pre=new int[line1.length];
        String[] line2=in.nextLine().split(" ");
        int[] inorder=new int[line1.length];
        for (int i = 0; i <line1.length ; i++) {
            pre[i]=Integer.parseInt(line1[i]);
            inorder[i]=Integer.parseInt(line2[i]);
        }
        for (int i = 0; i <pre.length-1 ; i++) {
            System.out.print(inorder[i]+" ");
        }
        System.out.println(inorder[pre.length-1]);
    }
    static void test3(){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(n);
    }

}
