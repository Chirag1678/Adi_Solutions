import java.util.Scanner;

public class Ques_1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        int w=sc.nextInt();
        sc.close();
        System.out.println(total(arr,w));
    }
    public static int total(int[][] arr,int w){
        int[][] dp=new int[arr.length][w+1];
        for (int j = 0; j <= w; j++) {
            if (arr[0][0] > j) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = arr[0][1];
            }
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=w;j++){
                if(arr[i][0]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],(arr[i][1]+dp[i-1][j-arr[i][0]]));
                }
            }
        }
        return dp[arr.length-1][w];
    }
}