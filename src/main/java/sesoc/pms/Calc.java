/*
    작성자 : 송율리아 [SCIM_A반]
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

public class Calc {

  public void calc(ArrayList<Patient> patients) {

    for(int i = 0 ; i < patients.size() ; i++) {
      //입원비, 총입원비
      double halinyul = (patients.get(i).getDay() > 0 && patients.get(i).getDay() < 10) ? 1.00 :    //할인율
        (patients.get(i).getDay() >= 10 && patients.get(i).getDay() < 15) ? 0.85 :
          (patients.get(i).getDay() >= 15 && patients.get(i).getDay() < 20) ? 0.80 :
            (patients.get(i).getDay() >= 20 && patients.get(i).getDay() < 30) ? 0.77 :
              (patients.get(i).getDay() >= 30 && patients.get(i).getDay() < 100) ? 0.72 : 0.68;

      int oneDay = (patients.get(i).getDay() > 0 && patients.get(i).getDay() <= 3) ? 30000 : 25000; //1일 입원비
      int ipwonbiSum = oneDay * patients.get(i).getDay();                        //총입원비 = 1일 입원비 * 입원일수
      double ipwonbi = ipwonbiSum * halinyul;             //입원비 = 총입원비 * 할인비율

      int jinchalbi;      //진찰비
      if(patients.get(i).getAge() < 10) 
        jinchalbi = 7000;
      else if(patients.get(i).getAge() >= 10 && patients.get(i).getAge() < 20)
        jinchalbi = 5000;
      else if(patients.get(i).getAge() >= 20 && patients.get(i).getAge() < 30)
        jinchalbi = 8000;
      else if(patients.get(i).getAge() >= 30 && patients.get(i).getAge() < 40)
        jinchalbi = 7000;
      else if(patients.get(i).getAge() >= 40 && patients.get(i).getAge() < 50)
        jinchalbi = 4500;
      else
        jinchalbi = 2300;

      patients.get(i).setJinryobi((double)jinchalbi + ipwonbi);
      patients.get(i).setJinchalbi(jinchalbi);
      patients.get(i).setIpwonbi(ipwonbi);
    }
  }
}

