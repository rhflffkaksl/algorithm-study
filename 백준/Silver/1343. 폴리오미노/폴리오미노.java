

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s=sc.next();
    StringBuilder sb=new StringBuilder();
    int cnt=0;
    for(int i=0;i<s.length();i++) {
      
      if (i == s.length() - 1 && s.charAt(i) == 'X')
        cnt++;
      if(s.charAt(i)=='.' || i==s.length()-1) {
        while(cnt/4>=1) {
          sb.append("AAAA"); 
          cnt-=4;
        }
        if (cnt % 2 == 0 && cnt != 0)
          sb.append("BB");
        else if (cnt > 0) {
          System.out.println(-1);
          return;
        }
        if (s.charAt(i) == '.')
          sb.append(".");
        cnt=0; 
         
      }else{
        cnt++;
      }
      
    }
    
    System.out.println(sb);

  }
}
