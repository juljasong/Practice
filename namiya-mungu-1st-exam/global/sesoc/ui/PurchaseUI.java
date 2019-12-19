package global.sesoc.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import global.sesoc.service.PurchaseServiceImpl;
import global.sesoc.vo.Product;
import global.sesoc.vo.CustomerPurchase;

public class PurchaseUI {
	Scanner keyin = new Scanner(System.in);
	PurchaseServiceImpl service = new PurchaseServiceImpl();

	public PurchaseUI() {
		String choice = new String();

		while (true) {
			mainMenu();
			choice = keyin.next();

			switch (choice) {
			case "1":
				ownerProcess();
				break;
			case "2":
				customerProcess();
				break;

			case "0":
				System.out.println("** 프로그램을 종료합니다.");
				service.saveFile();
				// 모든 파일을 저장하고 종료
			default:
				break;
			}
		}
	}

	/**
	 * 주메뉴
	 */
	private void mainMenu() {
		System.out.println();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);

		System.out.println("         << 나미야 문방구 >>");
		System.out.println(year + "년 " + month + "월 " + date + "일");
		System.out.println("==============================");
		System.out.println("    1. 판매자");
		System.out.println("    2. 고  객");
		System.out.println("    0. 종  료");
		System.out.println("==============================");
		System.out.print("    >> 선택 : ");
	}

	///////////////////////// 판매자 관련 업무 ///////////////////////////
	/**
	 * 판매자 관련 메뉴를 화면에 출력함
	 */
	private void ownerProcess() {
		String choice = new String();
		while (true) {
			ownerMenu();
			choice = keyin.next();

			switch (choice) {
			case "1": // 판매자가 판매할 물품을 구매하여 재고를 확보
				ownerBuy();
				break;
			case "2": // 판매자가 현재 재고를 확인
				stockCheck();
				break;

			case "3": // 판매자가 오늘의 판매 수익을 확인
				profitCheck();
				break;

			case "0": // 이전 화면으로 돌아감
				return;

			default:
				System.out.println("** 오류 : 메뉴를 다시 선택해 주세요");
				break;
			}
		}
	}

	/**
	 * 판매자 메뉴
	 */
	private void ownerMenu() {
		System.out.println();
		System.out.println("           << 판매자 >>");
		System.out.println("==============================");
		System.out.println("    1. 물품 구입");
		System.out.println("    2. 재고 확인");
		System.out.println("    3. 판매 수익 확인");
		System.out.println("    0. 이전 메뉴로");
		System.out.println("==============================");
		System.out.print("    >> 선택 : ");
	}

	/**
	 * 판매자가 판매 물품 전체에 대한 재고를 확인
	 */
	private void stockCheck() {
		ArrayList<Product> productList = service.stockCheck();

		if (productList.size() == 0) {
			System.out.println("** 재고 물품이 하나도 없습니다. 판매할 물품의 재고를 확보하세요");
			return;
		}
		System.out.println("\n          [ 현재 판매 가능한 재고 수량 ]");
		System.out.println(" 품목번호      품목명                단가          재고              판매가 ");
		System.out.println("===============================================");

		for (Product product : productList)
			System.out.println(product);

	}

	/**
	 * 판매자가 물품 구매
	 */
	private void ownerBuy() {
		// 지역변수 선언
		String productId = new String();
		String productName = new String();
		int quantity = 0;
		int unitPrice = 0;

		try {
			System.out.print("1) 제품 일련번호 : ");
			productId = keyin.next();

			// 기존 제품이 존재하는지 확인
			Product product = service.stockCheck(productId);

			// 이전에 판매한 적 있는 물품 등록
			if (product != null) {
				System.out.println(product);
				System.out.print("2) 구매 수량 : ");
				quantity = keyin.nextInt();

				service.stockUpdate(productId, quantity);
			}

			// 이전에 판매한 적 없는 새로운 물품
			else {
				System.out.print("2) 물품명 : ");
				productName = keyin.next();
				System.out.print("3) 단가 : ");
				unitPrice = keyin.nextInt();
				System.out.print("4) 구매 수량 : ");
				quantity = keyin.nextInt();

				service.stockCreate(new Product(productId, productName, unitPrice, quantity));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("** 입력 데이터 오류. 처음으로 돌아갑니다.");
			return;
		}

		System.out.println("** 물품 구매 완료");
	}

	/**
	 * 현재 판매 이윤체크
	 */
	private void profitCheck() {
		ArrayList<Product> todaySales = service.nowSalesList();

		ArrayList<Product> temp=new ArrayList<>();
		temp.addAll(todaySales);
		
		if (todaySales.size() == 0) {
			System.out.println("** 오늘은 한 개도 판매하지 못했습니다.");
			return;
		}
		
		System.out.println("\n                [ 현재 판매 총액 및 이윤 ]");
		System.out.println(" 물품번호      물품명                단가         판매 수량         판매가              판매이익 ");
		System.out.println("============================================================");

		// Code Here
		int totalPrice =printprofit(temp);
		
		
		System.out.println("=======================================================");
		System.out.printf("현재까지 총 이윤 : %,d\n", totalPrice);
	}
	
	public int printprofit(ArrayList<Product> temp) {
		int totalPrice = 0;
		for (Product p:temp) {
			int profit=(p.getPrice()-p.getUnitPrice())*p.getQuantity();
			System.out.print(p.toString()+" "+profit+"\n");
			totalPrice+=profit;
			profit=0;
		}
		return totalPrice;
	}

	///////////////////////// 구매자 관련 업무 ///////////////////////////
	private void customerProcess() {
		String choice = new String();

		while (true) {
			customerMenu();

			choice = keyin.next();

			switch (choice) {
			case "1": // 구매하기
				customerBuy();
				break;
			case "2": // 구매 내역 확인
				purchaseCheck();
				break;

			case "0": // 이전 화면으로
				return;
			default:
				System.out.println("** 메뉴를 다시 선택해 주세요");
				break;
			}
		}
	}

	/**
	 * 구매자 메뉴
	 */
	private void customerMenu() {
		System.out.println();
		System.out.println("           << 구매자 >>");
		System.out.println("==============================");
		System.out.println("    1. 물건 구매하기");
		System.out.println("    2. 구매 내역 확인");
		System.out.println("    0. 이전 메뉴로");
		System.out.println("==============================");
		System.out.print("    >> 선택 : ");
	}

	/**
	 * 고객이 물건 구매 하기
	 */
	private void customerBuy() {
		String email = new String(); // 고객 이메일
		String productId = new String(); // 구매품 일련변호
		int quantity = 0; // 구매수량

		ArrayList<Product> product = service.stockCheck();
		boolean flag = false;

		System.out.println("\n>> 구매 가능한 품목");
		for (Product p : product) {
			if (p.getQuantity() > 0) {
				System.out.printf("%s)\t%s(%d개)\t%,6d원%n", p.getProductId(), p.getProductName(), p.getQuantity(),
						p.getPrice());
				flag = true;
			}
		}

		if (!flag) {
			System.out.println("** 죄송합니다. 오늘은 판매할 물건이 없습니다. 다음에 이용해 주세요");
			return;
		}

		// 고객이 물건을 구매하는 프로세스 처리
		// 이메일, 구매할 품목 고유번호를 입력받고 해당 고유번호와 동일한 품목이 있는지 검사한 후
		// 해당 품목이 존재하지 않을 경우 고객에게 알림
		// 구매수량을 입력받았는데, 재고수량보다 많은 경우 판매할 수 없다는 메시지 출력
		// Code Here

		System.out.print(">> 고객 이메일 입력 : ");
		email = keyin.next();
		System.out.print(">> 구매품 일련 번호 : ");
		productId = keyin.next();
		System.out.print(">> 구매 갯수 : ");
		quantity = keyin.nextInt();
		if(quantity>service.stockCheck(productId).getQuantity()) {
			System.out.print("**죄송합니다. 재고가 충분치 않습니다.");
			return;
		}
		service.todaySales(new CustomerPurchase(email, productId, quantity));
	}

	/**
	 * 고객이 자신이 오늘 구매한 품목을 확인함
	 */
	public void purchaseCheck() {
		String email = new String(); // 고객 이메일
		System.out.print(">> 고객 이메일 입력 : ");
		email = keyin.next();
		ArrayList<CustomerPurchase> temp = new ArrayList<>();
		temp.addAll(service.todayPurchase(email));
		printall(temp, email);
	}
	
	public void printall(ArrayList<CustomerPurchase> temp, String email) {
		int total = 0; // 총 구매가
		int quantity=0;
		if (temp.isEmpty()){
			System.out.println("**구매내역이 없습니다.");
			return;
		}
		System.out.println(">> 고객 이메일 : "+email);
		System.out.println("\n                [ 구 매 내 역 ]");
		System.out.println(" 물품번호    물품명      구매 수량        총 구매가액 ");
		System.out.println("=============================================");
		
		for(CustomerPurchase cp: temp) {
			for(CustomerPurchase that:temp) {
				if(cp.getProductId().equals(that.getProductId())) {
					quantity+=that.getBuyQuantity();
					total+=(that.getBuyQuantity()*service.stockCheck(that.getProductId()).getPrice());
				}
			}
			Product print=service.stockCheck(cp.getProductId());
			System.out.print(print.getProductId()+"\t");
			System.out.print(print.getProductName()+"\t");
			System.out.print(quantity+"\t");
			System.out.print(total+"\n");
			total=0;
			quantity=0;
		}		
	}
}
