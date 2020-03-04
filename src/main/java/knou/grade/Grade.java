package knou.grade;

public class Grade {

  int eng;
  int mat;

  void input_grade(int eng, int mat) {
    this.eng = eng;
    this.mat = mat;
  }

  void output_grade() {
    System.out.println("영어 + 수학 = " + (eng + mat));
  }

}
