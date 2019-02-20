import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class qiezi {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        findSum(m,1,n);
    }
    static void test1() {
        Scanner in=new Scanner(System.in);
        String[] list=in.nextLine().split(",");
        int count=0;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <list[0].length() ; i++) {
            boolean flag=true;
            for (int j = 0; j <list.length ; j++) {
                if(i>list[j].length()){
                    break;
                }
                if(list[0].charAt(i)!=list[j].charAt(i)){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                sb.append(list[0].charAt(i));
            }else {
                break;
            }
        }
        System.out.println(sb.toString());
    }
    static void test2(){
        Scanner in=new Scanner(System.in);
        String s1=in.nextLine();
        String s2=in.nextLine();
        String[] list1=s1.split(" ");
        String[] list2=s2.split(" ");
        int[] a=new int[list1.length];
        for (int i = 0; i <list1.length ; i++) {
            a[i]=Integer.parseInt(list1[i]);
        }
        int[] b=new int[list2.length];
        for (int i = 0; i <list2.length ; i++) {
            b[i]=Integer.parseInt(list2[i]);
        }
        int result[];
        result = new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length)
            if(a[i] <= b[j]) {
                result[k++] = a[i++];
            }else{
                result[k++] = b[j++];
            }
        while(i < a.length)
            result[k++] = a[i++];
        while(j < b.length)
            result[k++] = b[j++];
        for (int l = 0; l < result.length-1; l++) {
            System.out.print(result[l]+" ");
        }
        System.out.print(result[result.length-1]);
    }
    static LinkedList<Integer> list = new LinkedList<>();
    static LinkedList<A> res = new LinkedList<>();
    class A implements Comparable<A>{
        int a;
        int b;
        public A(int a,int b){
            this.a=a;
            this.b=b;
        }
        @Override
        public int compareTo(A o){
            return 1;
        }
    }
    public static void findSum(int sum, int start, int end) {
        if (sum < 0 || start > end + 1)
            return;
        else if (sum == 0){
            for (int i = list.size()-1; i >=0; i--) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            return;
        }
        if (sum >= start) {
            list.push(start);
            findSum(sum - start, start + 1, end);
            list.pop();
            findSum(sum, start+1, end);
        }
    }

}
