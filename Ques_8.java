import java.util.Scanner;

public class Ques_8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] arr=new String[n];
        String arb="YesYesYesYesYes";
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        sc.close();
        for(int i=0;i<n;i++){
            if(arb.contains(arr[i])){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
