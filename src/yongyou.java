import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class yongyou {
    public static void main(String args[])
    {
        test2();
    }
    static void test1() {
        Scanner in = new Scanner(System.in);
        String[] A=in.nextLine().split(" ");
        Set<String> set=new HashSet<>();
        int maxlen=0;
        int m2=0;
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if(A[i].length()>maxlen){
                maxlen=A[i].length();
            }
            if(A[i].length()==2){
                m2++;
            }
        }
        for (int i = 0; i < m2; i++) {
            if(A[i].charAt(1)==Integer.valueOf(i+1).toString().charAt(0)){
                System.out.println(A[i]);
                for (int j = 0; j < maxlen/2; j++) {
                    for (int k = 0; k < A.length; k++) {

                    }
                }
            }

        }
    }
    static void test2(){
        Scanner in = new Scanner(System.in);
        String[] A=in.nextLine().split(" ");
        int[] B=new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i]=Integer.parseInt(A[i]);
        }
        boolean flag=true;
        int res=1;
        int last=B[0];
        int max=1;
        int maxstart=B[0];
        for (int i = 1; i <A.length ; i++) {
            if(B[i]==last+1){
                res+=1;
                last=B[i];
                if(res>max){
                    max=res;
                    maxstart=B[i-max+1];
                }
            }else {
                res=1;
                last=B[i];
            }
        }
//        System.out.println(maxstart+" "+max);
//        System.out.println("["+maxstart+","+max+"]");
        System.out.println("["+maxstart+","+max+"]");
    }
}
