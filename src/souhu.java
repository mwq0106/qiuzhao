import java.util.*;

public class souhu {

    public static void main(String args[])
    {
        test3();
    }
    static void test1(){
        Scanner in=new Scanner(System.in);
        String[] list=in.nextLine().split(" ");
        String a=list[0];
        String b=list[1];
        if(a.length()!=b.length()){
            System.out.println(0);
            return;
        }
        int x=-1;
        int y=-1;
        char a1='0';
        char a2='0';
        char b1='0';
        char b2='0';
        boolean first=true;
        int count=0;
        Map<String,Integer> map=new HashMap<>();

        for (int i = 0; i <a.length() ; i++) {
            if(a.charAt(i)!=b.charAt(i)&&first==true){
                x=i;
                a1=a.charAt(i);
                b1=b.charAt(i);

                first=false;
                count++;
            }else if(a.charAt(i)!=b.charAt(i)&&first==false){
                y=i;
                a2=a.charAt(i);
                b2=b.charAt(i);
                count++;
            }
        }
        if(a.equals(b)){
            for (int i = 0; i <a.length() ; i++) {
                Integer tt=map.get(String.valueOf(a.charAt(i)));
                if(tt==null){
                    map.put(String.valueOf(a.charAt(i)),1);
                }else {
                    map.put(String.valueOf(a.charAt(i)),tt+1);
                }
            }
            for(String s:map.keySet()){
                if(map.get(s)>1){
                    System.out.println(1);
                    return;
                }
            }
        }
        if(count!=2||a1=='0'||b1=='0'||a2=='0'||b2=='0'){
            System.out.println(0);
            return;
        }

        if(a1==b2&&b1==a2){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
    static void test2(){
        Scanner in=new Scanner(System.in);
        String[] list=in.nextLine().split(" ");
        String a=list[0];
        String b=list[1];
        int min=Math.min(a.length(),b.length());
        for (int i = 0; i <min ; i++) {
            char temp1=a.charAt(i);
            char temp2=b.charAt(i);
            if(temp1>temp2){
                System.out.println(1);
                return;
            }else if(temp1<temp2){
                System.out.println(-1);
                return;
            }else {

            }
        }
        String max;
        if(a.length()==min){
            max=b;

        }else {
            max=a;
        }
        for (int i = min; i <max.length() ; i++) {
            if(max.charAt(i)!='.' &&max.charAt(i)!='0'){
                if(a.length()==min){
                    System.out.println(-1);
                    return;
                }else {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
    static void test3(){
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=Math.abs(m);
        int down=-1;
        for (int i = 1; i < 300; i++) {
            if(i*(i+1)==2*n){
                System.out.println(i);
                return;
            }else if(i*(i+1)<2*n){

            }
        }

    }

}
