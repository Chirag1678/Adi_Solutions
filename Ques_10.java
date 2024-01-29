import java.util.ArrayList;
import java.util.Scanner;

public class Ques_10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        System.out.println(longest(arr));
    }
    public static int longest(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                list.add(arr[i]);
            }
        }
        return list.size();
    }
}
