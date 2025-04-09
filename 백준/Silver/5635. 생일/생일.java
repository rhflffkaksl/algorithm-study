

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static class Student implements Comparable<Student> {
    String name;
    int day;
    int month;
    int year;

    public Student() {}

    public Student(String name, int day, int month, int year) {
      this.name = name;
      this.day = day;
      this.month = month;
      this.year = year;
    }

    @Override
    public int compareTo(Student o) {
      int result = this.year - o.year;
      if (o.year == this.year) {
        if (o.month == this.month) {
          result = this.day - o.day;
        } else
          result = this.month - o.month;
      }
      return result;
    }


  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Student[] std = new Student[n];


    for (int i = 0; i < n; i++) {
      std[i] = new Student();
      std[i].name = sc.next();
      std[i].day = sc.nextInt();
      std[i].month = sc.nextInt();
      std[i].year = sc.nextInt();
    }
    Arrays.sort(std);
    
    System.out.println(std[n - 1].name);
    System.out.println(std[0].name);
  }
}
