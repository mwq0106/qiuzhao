import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mwq0106
 * @date 2020/9/8
 */
public class User {

    public static void main(String[] arg) throws Exception{
        Thread a = new Thread();
        Thread b = new Thread();
        Thread c = new Thread();
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
        c.join();
    }
    private Integer age;
    public Integer getAge(){
        return age;
    }
    public static void remove(List<User> userList){
        List<User> needDelete = new LinkedList<>();
        for (User user:userList){
            if(user.getAge()>20){
                needDelete.add(user);
            }
        }
        for (User user:needDelete){
            userList.remove(user);
        }
    }
    public static void print(int[] array){
        int l = 0;
        int r = array.length-1;
        int t = 10;
        while (true){
            int index = partion(array,l,r);
            if(index < t){
                l = index+1;
            }else if(index > t){
                r = index -1;
            }else {
                break;
            }
        }
        int[] res = new int[t];

        for (int i = 0; i < t; i++) {
            res[i] = array[i];
        }
        Arrays.sort(res);
        for (int i = 0; i < t; i++) {
            System.out.println(res[i]);
        }
    }
    public static int partion(int[] array,int l,int r){
        int indexValue = array[l];
        int minIndex = l+1;
        for (int i = l+1; i <= r; i++) {
            if(array[i] <=indexValue){
                if(minIndex != i){
                    swap(array,minIndex,i);
                }
                minIndex++;
            }
        }
        swap(array,l,--minIndex);
        return minIndex;
    }
    public static void swap(int[] num,int a,int b){
        int t = num[a];
        num[a] = num[b];
        num[b] = t;
    }
}
