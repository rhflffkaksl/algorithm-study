import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		int[] cnt=new int[10001]; //인덱스 1부터 시작
		for(int i=1;i<10000;i++) {
			int dn=i;
			int temp=i;
			
			while(temp>=1) {
				dn+=temp%10;
				temp/=10;
				
			}
			if(dn>10000) continue;
			cnt[dn]++;
			
		}
		
		for(int i=1;i<=10000;i++) {
			if(cnt[i]==0) System.out.println(i);
		}
		
		
            
        }
	}


