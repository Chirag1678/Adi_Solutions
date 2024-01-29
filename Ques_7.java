import java.util.Scanner;

public class Ques_7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.close();
        String ans="Not so Cool";
        for(int i=1;i<s.length()/2;i++){
            String a=s.substring(0,i);
            String b=s.substring(s.length()-i,s.length());
            if(a.equals(b)){
                String c=s.substring(s.length()/2-a.length()/2,s.length()/2+a.length()/2);
                if(c.equals(b)){
                    ans=c;
                }
            }
        }
        System.out.println(ans);
    }
}
