/*
    작성자 : 박정훈 [SCIM_A반]
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
import java.util.Scanner;

public class Input {

  public void input(ArrayList<Patient> patients) {
    Scanner scan = new Scanner(System.in);

    String io = "i";
    while (true) {
      if (io.equalsIgnoreCase("I")) {
        System.out.print("번호 : ");
        int number = scan.nextInt();
        System.out.print("진료코드 : ");
        String code = scan.next();
        System.out.print("입원일수 : ");
        int day = scan.nextInt();
        System.out.print("나이 : ");
        int age = scan.nextInt();

        patients.add(new Patient(number, day, age, code)); // 입력된 환자 기본정보 set

        System.out.print("입력/출력 (I/O) : "); // 입력 더 받을지 말지
        io = scan.next();
        System.out.println();
      } else if (io.equalsIgnoreCase("o")) {
        break;
      } else {
        System.out.println("옳지 않는 값을 입력하였습니다.");
        System.out.print("입력/출력 (I/O) : ");
        io = scan.next();
      }
    }
    scan.close();
  }
}
