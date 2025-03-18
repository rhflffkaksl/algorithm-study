import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			//M에서 N개 선택 후 나열
			//M!/(M-N)!
			int answer = 1;
            for (int i = 1; i <= N; i++) {
                answer = answer * (M - N + i) / i;
            }
			//겹치면 안되기 떄문에 순서가 정해져있음-> 순열 아니고 조합!!!
			
			System.out.println(answer);
		}
	}
}