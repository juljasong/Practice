/*
    작성자 : 조두희 [SCIM_A반]
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

public class Output {

  public void output(ArrayList<Patient> patients) {

    drawLabel();
    for (int i = 0; i < patients.size(); i++) {
      display(patients, i);  
      System.out.println(patients.get(i).toString());
    }
  }

  private void drawLabel() {
    System.out.println("        <<<병원관리프로그램>>>");
    System.out.println("--------------------------------------------------------------------------");
    System.out.println("번호            진찰부서            진찰비            입원비            진료비     ");
    System.out.println("--------------------------------------------------------------------------");
  }


  public void display(ArrayList<Patient> patients, int i) {
    switch(patients.get(i).getCode()) {
      case "MI" : patients.get(i).setBuseo("외과"); break;
      case "NI" : patients.get(i).setBuseo("내과"); break;
      case "SI" : patients.get(i).setBuseo("피부과"); break;
      case "TI" : patients.get(i).setBuseo("소아과"); break;
      case "VI" : patients.get(i).setBuseo("산부인과"); break;
      case "WI" : patients.get(i).setBuseo("비뇨기과"); break;
      default : patients.get(i).setBuseo("기타");
    }
  }
}
