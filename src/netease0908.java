import java.util.Scanner;

public class netease0908 {
    public static void main(String[] args) {
        test3();
    }
    static void test1(){
        Scanner in=new Scanner(System.in);
        String string=in.nextLine();

        int b=0;
        int w=0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)=='b'){
                b++;
            }else {
                w++;
            }
        }
        if(w==b){
            System.out.println(b+w);
        }else if(w<b){
            System.out.println(2*w+1);
        }else {
            System.out.println(2*b+1);
        }
    }
    static void cal(String a){
        boolean flag=false;
        for (int i = 0; i <a.length() ; i++) {

        }
    }
    static void test2(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        for (int i = 0; i <N ; i++) {
            int n=in.nextInt();
            int k=in.nextInt();
            int a=k;
            int b=n-k;
            if(a<=b){
                if(a==0){
                    System.out.println("0 0");
                }else {
                    System.out.println("0"+" "+(Integer) (a-1));
                }
            }else{
                System.out.println("0"+" "+(Integer) (b));
            }
        }
    }
    static void test3(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int res=0;
        int count=0;
        for (int i = 0; i <n ; i++) {
            int a=in.nextInt();
            int b=in.nextInt();
            count+=b;
            if(a==1){
                res++;
            }
        }
        if(res>=m/2){
            System.out.println(0);
        }else {
            System.out.println(count);
        }

    }
}
