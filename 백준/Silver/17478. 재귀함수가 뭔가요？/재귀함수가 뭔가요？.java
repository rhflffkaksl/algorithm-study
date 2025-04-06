import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		say(n);
		
	}
	
	static String indent = ""; // 들여쓰기
	
	static void say(int cnt) {
	    String currentIndent = indent; // 현재 들여쓰기 저장

        // 현재 단계 질문 출력
        System.out.println(currentIndent + "\"재귀함수가 뭔가요?\"");

        if (cnt == 0) {
            //마지막 문구
            System.out.println(currentIndent + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        } else {
            //중간 문구
            System.out.println(currentIndent + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(currentIndent + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(currentIndent + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

            indent += "____"; // 들여쓰기 추가
            say(cnt - 1); 
        }

        // 각 단계의 종료 문구
        System.out.println(currentIndent + "라고 답변하였지.");
    }
	
	

}
