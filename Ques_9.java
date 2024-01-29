import java.util.Scanner;

public class Ques_9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        sc.close();
        arr=firstNegative(arr,k);
        for(int i=0;i<=n-k;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] firstNegative(int[] arr,int k){
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int v=0;
            if(arr.length-i>=k){
                for(int j=i;j<i+k;j++){
                    if(arr[j]<0){
                        v=arr[j];
                        break;
                    }
                }
            }
            else{
                for(int j=i;j<arr.length;j++){
                    if(arr[j]<0){
                        v=arr[j];
                        break;
                    }
                }
            }
            ans[i]=v;
        }
        return ans;
    }
}
