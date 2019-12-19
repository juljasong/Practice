/*
    작성자 : 이동길 [SCIM_A반]
    작성목적 : IT실습_병원관리프로그램
    작성날짜 : 2019년 4월 19일
    작성환경
        - O/S : Windows 7 professional K
        - 프로세서 : Intel(R) Core(TM) i5-4460 CPU @ 3.20GHz
        - 시스템 종류 : 64bit Operating System
        - eclipse 2019-03ver, JDK 8u202
 */
package scit.pm;

public class Patient {

  private int number, day, age, jinchalbi; 
  private String code;
  private double ipwonbi;
  private double jinryobi;
  private String buseo;

  public Patient(int number, int day, int age, String code) {
    this.number = number;
    this.day = day;
    this.age = age;
    this.code = code;
  }


public int getNumber() {
    return number;
  }


  public void setNumber(int number) {
    this.number = number;
  }


  public int getDay() {
    return day;
  }


  public void setDay(int day) {
    this.day = day;
  }


  public int getAge() {
    return age;
  }


  public void setAge(int age) {
    this.age = age;
  }


  public int getJinchalbi() {
    return jinchalbi;
  }


  public void setJinchalbi(int jinchalbi) {
    this.jinchalbi = jinchalbi;
  }


  public String getCode() {
    return code;
  }


  public void setCode(String code) {
    this.code = code;
  }


  public double getIpwonbi() {
    return ipwonbi;
  }


  public void setIpwonbi(double ipwonbi) {
    this.ipwonbi = ipwonbi;
  }


  public double getJinryobi() {
    return jinryobi;
  }


  public void setJinryobi(double jinryobi) {
    this.jinryobi = jinryobi;
  }


  public String getBuseo() {
    return buseo;
  }


  public void setBuseo(String buseo) {
    this.buseo = buseo;
  }

  @Override
  public String toString() {
    return " " + number + "        " + buseo + "           " +  jinchalbi + "       " + 
  ipwonbi + "     " + jinryobi;
  }
}
