package knou.grade;

class ArgsGrade {

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


public class practiceArgs {

  public static void main(String[] args) {

    ArgsGrade grade;
    grade = new ArgsGrade();

    grade.input_grade(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

    grade.output_grade();

  }

}
