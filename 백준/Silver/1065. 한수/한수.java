import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		if(N<100) { //예외
			System.out.println(N);
			return;
		}
		
		int cnt=99; //한,두 자리수들은 그냥 포함하고 시작 1~99
		for(int t=100;t<=N;t++) {
		
		int temp=t;
		List<Integer> list=new ArrayList<>();
		boolean doCnt=true;
		
		while(temp>=1) {
			int p=temp%10;
			list.add(p); //각 자릿수 저장
			temp/=10;
		}
		
		int before=list.get(0);
		
		int gap=before-list.get(1);
		
		for(int i=2;i<list.size();i++) {
			int p=list.get(i);
			before=list.get(i-1);
			
			if(before-p!=gap) {	
				doCnt=false;
				break;
			}

		}
			if(doCnt) cnt++;
			
		
		}
		System.out.println(cnt);
	}

}
