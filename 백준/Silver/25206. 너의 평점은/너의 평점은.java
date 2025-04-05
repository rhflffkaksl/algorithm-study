import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int totalCredit=0;
		double totalSum=0;
		for(int i=0;i<20;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			st.nextToken();
			
			double credit=Double.parseDouble(st.nextToken());
			String grade=st.nextToken();
			if(grade.equals("P")) continue;//계산에서 제외 
			
			totalCredit+=credit;
			double score=gradeToScore(grade);
			
			totalSum+=score*credit;
						
					
		}
		
		
		System.out.println(totalSum/totalCredit);
	}
	
	static double gradeToScore(String grade) {
	    switch (grade) {
	        case "A+": return 4.5;
	        case "A0": return 4.0;
	        case "B+": return 3.5;
	        case "B0": return 3.0;
	        case "C+": return 2.5;
	        case "C0": return 2.0;
	        case "D+": return 1.5;
	        case "D0": return 1.0;
	        case "F":  return 0.0;
	 
	        default: return -1.0; 
	    }
	}
	

}
