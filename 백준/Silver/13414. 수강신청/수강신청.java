import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();  // 수강 가능 인원
        int L = sc.nextInt();  // 클릭 횟수
       

        LinkedHashSet<String> waitList = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String studentId = sc.next();

            // 이미 있으면 삭제 후 다시 추가 -> 맨 뒤로 이동
            if (waitList.contains(studentId)) {
                waitList.remove(studentId);
            }
            waitList.add(studentId);
        }

        // 앞에서부터 K개만 출력
        int count = 0;
        for (String id : waitList) {
            if (count >= K) break;
            System.out.println(id);
            count++;
        }
    }
}
