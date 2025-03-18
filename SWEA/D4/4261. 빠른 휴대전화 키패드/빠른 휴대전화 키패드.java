

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int TC=sc.nextInt();
	    for(int tc=1;tc<=TC;tc++) {
	    	String s=sc.next();
	    	int N=sc.nextInt();
	    	String[] word=new String[N];
	    	int cnt=0;
	    	
	    	for(int i=0;i<N;i++) {
	    		String input=sc.next();
	    		word[i]="";
	    		for(int j=0;j<input.length();j++) {
	    			word[i]+=toNum(input.charAt(j));
	    		}
	    		
	    		if(word[i].equals(s)) cnt++;	
	    		
	    	}

	    	System.out.println("#"+tc+" "+cnt);
	    }
	}
	
	static char toNum(char c) {
		switch(c) {
		case 'a':
		case 'b':
		case 'c':
			return '2';
		case 'd':
		case 'e':
		case 'f':
			return '3';
		case 'g':
		case 'h':
		case 'i':
			return '4';
		case 'j':
		case 'k':
		case 'l':
			return '5';
		case 'm':
		case 'n':
		case 'o':
			return '6';
		case 'p':
		case 'q':
		case 'r':
		case 's':
			return '7';
		case 't':
		case 'u':
		case 'v':
			return '8';
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			return '9';
		
		}
		return c;
		
	}
	
	
}
