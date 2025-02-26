import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); 
        int T=sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
        	String s=sc.next();
        	String t=sc.next();
        	int snum=color(s);
        	int tnum=color(t);
        	if(s.equals(t)) System.out.println("E");
        	//5차이가 나거나 1차이가 나면 A
        	else if(Math.abs(tnum-snum)==1 || Math.abs(tnum-snum)==5)  System.out.println("A");
        		//3차이가 나면 C
        	else if(Math.abs(tnum-snum)==3) System.out.println("C");
        	else System.out.println("X");
        		
        }
   
       
    }
    private static int color(String a) {
    	switch(a) {
    		case "red": return 1;
    		case "purple":return 2;
    		case "blue":return 3;
    		case "green":return 4;
    		case "yellow":return 5;
    		case "orange":return 6;
    	}
    	return -1;
    }
}