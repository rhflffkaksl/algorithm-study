import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // ✅ 빠른 입력
        StringBuilder sb = new StringBuilder(); 
        int k=Integer.parseInt(in.readLine());
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<k;i++){
            int a=Integer.parseInt(in.readLine());
            if(a==0) stack.pop();
            else stack.push(a);
        }
        int sum=0;
        for(int num:stack){
            sum+=num;
        }
        sb.append(sum);
        System.out.println(sum);
    }
}
