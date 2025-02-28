import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int tc = 1; tc <= T; tc++) {
      int N = sc.nextInt();
      Set<String> list=new HashSet<>();
    
      String answer="";
      int c=1;
       while(list.size()<10) {
    	  
    	   if(N==0) {
    		   answer="INSOMNIA";
    		   break;
    	   }
    	   int current=c*N;
    	   c++;
    	   String a=current+"";
    	   for(int i=0;i<a.length();i++) {
    		   list.add(a.charAt(i)+"");
    	   }
    	   if(list.size()==10)
    		   answer=a;
       }
      System.out.println("Case #" + tc + ": " + answer);
    }
  }

}