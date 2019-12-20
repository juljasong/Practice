/*
    작성자 : 남창현 [SCIM_A반]
    작성목적 : IT실습_병원관리프로그램
    작성날짜 : 2019년 4월 19일
    작성환경
        - O/S : Windows 7 professional K
        - 프로세서 : Intel(R) Core(TM) i5-4460 CPU @ 3.20GHz
        - 시스템 종류 : 64bit Operating System
        - eclipse 2019-03ver, JDK 8u202
 */
package sesoc.pms;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {

    //final int SIZE = 5;
    //Patient[] patients = new Patient[SIZE];
    ArrayList<Patient> patients = new ArrayList<>();

    Input in = new Input();
    in.input(patients);
    Calc ca = new Calc();
    ca.calc(patients);
    Sort so = new Sort();
    so.bubbleSort(patients);
    Output ou = new Output();
    ou.output(patients);
  }
}
