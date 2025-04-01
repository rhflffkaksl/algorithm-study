import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        //PriorityQueue 사용 -> 내부적으로 이진 힙 구조이거, 삽입시 부분정렬하기 떄문에 삽입/정렬에 logN
        //list 하고 collection.sort 하면 시간초과!!O(N log N) 
       PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{//람다 어렵..
    	   int na=Math.abs(a);
    	   int nb=Math.abs(b);
    	   if (na == nb) return a - b; //절댓값이 같다면 원래 값 기준으로 오름차순
           return na - nb; //절댓값 오름차순
       });
        
        for(int i=0;i<N;i++) {
    	   int x=sc.nextInt();
    	   if(x==0) {
    		   System.out.println(pq.isEmpty()? 0 :pq.poll());//오름차순 기준 가장 작은 값이 나옴
    	   }else {
    		   pq.add(x);
    	   }
    	   
       }
        
    }
}

