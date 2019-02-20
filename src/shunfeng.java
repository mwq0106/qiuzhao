import java.util.Scanner;

public class shunfeng {
    public static void main(String[] args) {
        test1();
    }
    static void test1() {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        char last='-';
        int index=-1;
        A[] T=new A[5000];
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)!=last){
                index++;
                last=s.charAt(i);
                T[index]=new A(s.charAt(i),1);
            }else {
                T[index].count+=1;
            }
        }
        int maxlen=0;
        int start=-1;

        for (int i = 0; i <T.length-3 ; i++) {
            if(T[i]==null||T[i+1]==null||T[i+2]==null){
                break;
            }
            if(T[i].count==T[i+2].count && T[i+1].count<T[i+2].count){
                if((T[i].count+T[i+1].count+T[i+2].count)>maxlen){
                    start=i;
                    maxlen=T[i].count+T[i+1].count+T[i+2].count;
                }
            }
        }
        if(start==-1){
            System.out.println("NULL");
            return;
        }
        char a=T[start].value;
        int alen=T[start].count;
        char b=T[start+1].value;
        int blen=T[start+1].count;
        char c=T[start+2].value;
        int clen=T[start+2].count;
        for (int i = 0; i < alen; i++) {
            System.out.print(a);
        }
        for (int i = 0; i < blen; i++) {
            System.out.print(b);
        }
        for (int i = 0; i < clen; i++) {
            System.out.print(c);
        }
    }
    static class A{
        char value;
        int count;
        public A(char v,int c){
            count=c;
            value=v;
        }
    }
    static void test2(){
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        int n=Integer.parseInt(in.nextLine());
        String[] list=s.split(",");
        for (int i = 0; i <list.length ; i++) {
            System.out.println(list[i]);
        }
    }

}
