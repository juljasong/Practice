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
package scit.pm;

import java.util.ArrayList;

public class Sort {

  public void bubbleSort(ArrayList<Patient> patients) {

    for (int i = 0; i < patients.size() -1; i++) {
      for (int j = 0; j < patients.size() -1-i; j++) {
        if(patients.get(j).getNumber() > patients.get(j+1).getNumber()) {
          Patient temp = patients.get(j);
          patients.add(j, patients.get(j+1));
          patients.add(j+1, temp);
        }
      }
    }

  }
}