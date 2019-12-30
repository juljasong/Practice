package sesoc.tms.ui;

import java.util.List;
import java.util.Scanner;

import sesoc.tms.manager.ToyManagerMgr;
import sesoc.tms.vo.Bicycle;
import sesoc.tms.vo.Drone;
import sesoc.tms.vo.GameConsole;
import sesoc.tms.vo.Toy;

public class ToyManagerUI {
  Scanner input = new Scanner(System.in);
  ToyManagerMgr manager = new ToyManagerMgr();

  /**
   * 생성자
   */
  public ToyManagerUI() {
    int mNum = 0;

    while(true) { //반복
      try {
        mainMenu();
        mNum = input.nextInt();

        switch(mNum) {
          case 1:
            insertToy();
            break;
          case 2:
            searchToy();
            break;
          case 3:
            //deleteToy();
            updateToy();
            break;
          case 4:
            searchForPrice();
            break;
          case 5:
            printToyInfo();
            break;
          case 9:		// 저장 후 끝냄
            System.out.println("데이터 저장 후 프로그램 종료합니다.");
            manager.saveFile();
            return;
          default : 
            System.out.println("오류 >>>>> 메뉴 선택을 다시해 주세요.");
            input.nextLine();	
        }
      } catch (Exception e) {
        System.out.println("오류 >>>>> 메뉴 선택을 다시해 주세요.\n");
        input.nextLine();
        continue; // 캐치로 잡아서 반복문의 처음 간다
      }
    }

  }

  private void updateToy() {

    //	this.searchToy();
    System.out.print(">장난감 고유번호:");
    String serialNum = this.input.nextLine();
    Toy toy = manager.searchToy(serialNum);
    if(toy !=null) {
      System.out.println(toy);
    }
    System.out.print(">이름:");
    String name = input.nextLine();
    System.out.print(">가격:");
    int price = input.nextInt();

    if(toy instanceof Bicycle) {
      System.out.print("종류:");
      String type = input.nextLine();
    }else if(toy instanceof Drone) {
      System.out.print(">날개수:");
      int wingCount = input.nextInt();
    }else if(toy instanceof GameConsole) {
      boolean isPortable;
      System.out.print("> 휴대가능여부(y/n): ");
      String yn = input.nextLine();
      if(yn == "y" || yn == "Y") {
        isPortable = true;
      }else if (yn == "n" || yn == "N") {
        isPortable = false;
      }else {
        System.out.println("잘못된 값 ^^");
      }

    }
  }

  /**
   * 주메뉴를 화면에 출력한다.
   */
  public void mainMenu() {
    System.out.println("\n===== Toy Manager ======");
    System.out.println("1. 장난감 등록");
    System.out.println("2. 장난감 검색");
    System.out.println("3. 장난감 업데이트");
    System.out.println("4. 가격대 검색");
    System.out.println("5. 장난감 정보 출력");
    System.out.println("9. 종료");
    System.out.println("=======================");
    System.out.print  ("[ 메뉴  선택  ] ");
  }

  /**
   * 장난감 객체를 생성해서 삽입하기 위한 메소드
   * 
   */
  public void insertToy() {
    while(true) {
      int iNum = 0;
      try {
        insertMenu();
        iNum = input.nextInt();

        if(iNum == 9) {
          return;
        }
      } catch(Exception e) {
        System.out.println("오류 >>>>> 다시 선택해 주세요.\n");
        input.nextLine();
        continue;
      }

      Toy toy = makeToy(iNum);
      manager.insertToy(toy);
    }
  }

  /**
   * 장난감 객체를 등록하기 위한 메뉴를 화면에 출력
   */
  public void insertMenu() {
    System.out.println("\n===== 장난감 등록 메뉴 =====");
    System.out.println("1. 자전거");
    System.out.println("2. 드론");
    System.out.println("3. 게임기");
    System.out.println("9. 상위메뉴");
    System.out.print  ("[ 장난감 선택 ] ");
  }

  /**
   * 장난감 객체를 저장하기 위해 Toy 객체를 새엉한다.
   * @param toyType 장난감 종류
   * @return 생성된 장난감 객체
   */
  public Toy makeToy(int toyType) {  // public 리턴값 함수명(파라미터)
    Toy toy = null; //껍떼기 만듬
    String name, serialNum; //이름과 고유번호 변수 선언
    int price = 0;

    while(true) {
      try {
        System.out.print("> 고유번호:");
        serialNum = input.next();

        Toy sToy = manager.searchToy(serialNum);

        if(sToy != null) {
          System.out.println("중복 오류 >>>>> 입력하신 고유번호의 장난감이 존재합니다.\n");
          continue;
        }

        System.out.print("> 이름:");
        name = input.next();

        System.out.print("> 가격:");
        price = input.nextInt();

        switch(toyType) {
          case 1:
            String type = null;

            System.out.print("> 자전거 종류(1. 도로용, 2. 산악용) => ");
            int tNum = input.nextInt();
            switch(tNum) {
              case 1:
                type = "road";
                break;
              case 2:
                type = "mountain";
                break;
              default:
                new Exception("익셉션 발생..");
                break;
            }

            toy = new Bicycle(serialNum, name, price, type);

            break;
          case 2:
            int wingCount = 0;
            System.out.print("> 날개 갯수 : ");
            wingCount = input.nextInt();

            toy = new Drone(serialNum, name, price, wingCount);

            break;

          case 3:
            System.out.print("> 휴대 가능 여부(y/n) ");
            String ip = input.next();
            boolean isPortable = false;

            if(ip.equalsIgnoreCase("y")) {
              isPortable = true;
            }
            else if(ip.equalsIgnoreCase("n")) {
              isPortable = false;
            }
            toy = new GameConsole(serialNum, name, price, isPortable);

            break;
        }

        return toy;
        //*** 중요 율리아왈 !!! 리턴값은 보면서 코딩하자!!!!!!!		
      } catch (Exception e) {
        input.nextLine();
        System.out.println("오류 >>>>> 다시 입력해 주세요.\n");
        continue;
      }
    }
  }

  /**
   * 고유번호에 해당하는 장난감을 검색하여 화면에 출력한다.
   * 
   */
  public void searchToy() {
    while(true) {
      System.out.print("\n> 장난감 고유번호: ");
      String serialNum = input.next();
      Toy sToy = manager.searchToy(serialNum);

      if(sToy != null) {
        System.out.println(sToy.toString());
      }
      else {
        System.out.println("검색 실패 >>>>> 입력하신 고유번호의 장난감이 존재하지 않습니다.\n");
      }
      return;
    }
  }

  /** 
   * 장난감의 시리얼번호를 입력받아 해당하는 장난감 정보를 삭제한다. 
   */
  public void deleteToy() {
    System.out.println("\n===== 장난감 삭제 메뉴 =====");
    System.out.print("> 장난감 고유 번호: ");
    String serialNum = input.next();

    if(manager.deleteToy(serialNum)) {
      System.out.println("[ 삭제 성공 ]\n");
    } else {
      System.out.println("삭제 실패 >>>>> 입력하신 고유번호의 장난감이 존재하지 않습니다.\n");
    }
  }

  /**
   * 가격 검색
   */
  public void searchForPrice() {
    System.out.println("\n===== 가격 검색 메뉴 =====");
    System.out.print("> 최소가격: ");
    int minPrice = input.nextInt();

    System.out.print("> 최대가격: ");
    int maxPrice = input.nextInt();

    int count = 0;

    List<Toy> tList = manager.toyListForPrice(minPrice, maxPrice);
    if(tList != null) {
      System.out.println("[ " + minPrice + "원 ~ " + maxPrice + "원 사이의 제품 검색 결과 ] ");

      for(Toy t : tList) {
        System.out.println(t);
        count++;
      }
      System.out.println("[ 총  "+ count +" 개의 제품이 검색되었습니다.]\n");
    } else {
      System.out.println(">>>>> 원하시는 가격 대의 제품이 존재하지 않습니다.\n");
    }
  }

  /**
   * 장난감 정보를 화면에 출력한다.
   */
  public void printToyInfo() {
    while(true) {
      printMenu();
      int pNum = input.nextInt();
      String msg = null;

      switch(pNum) {
        case 1:
          msg = "총 장난감 개수: [";
          break;
        case 2:
          msg = "총 자전거 대수: [";
          break;
        case 3:
          msg = "총 드론 대수: [";
          break;
        case 4:
          msg = "총 게임콘솔 대수: [";
          break;
        case 9:
          return;
      }
      List<Toy> tList = manager.printToyInfo(pNum);
      if(tList != null) {
        for(int i = 0, len = tList.size(); i < len; i++) {
          System.out.println(tList.get(i).toString());
        }
        System.out.println(msg + tList.size() + "] 대");
      }
    }
  }

  /**
   * 주 메뉴 출력 메서드
   */
  public void printMenu() {
    System.out.println("\n===== 장난감 정보 출력 =====");
    System.out.println("1. 전체 출력");
    System.out.println("2. 자전거 정보 출력");
    System.out.println("3. 드론 정보 출력");
    System.out.println("4. 게임콘솔 정보 출력");
    System.out.println("9. 상위 메뉴");
    System.out.print  ("[ 선택 ] ");

  }
}
