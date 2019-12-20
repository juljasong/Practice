package sesoc.namiya.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sesoc.namiya.vo.Product;
import sesoc.namiya.vo.CustomerPurchase;

public class PurchaseServiceImpl implements PurchaseService {
	ArrayList<Product> productList = new ArrayList<>(); // 판매자가 판매하는 모든 물품
	ArrayList<Product> todaySales = new ArrayList<>(); // 판매자가 오늘 판매한 모든 물품
	ArrayList<CustomerPurchase> customerSales = new ArrayList<>(); // 고객이 구매한 물품 목록
	File f = new File("hoyunissuperhandsome.dat");

	public PurchaseServiceImpl() {
		loadFile();
	}

	@Override
	public Product stockCheck(String productId) {
		for (Product p : productList) {
			if (p.getProductId().equals(productId))
				return p;
		}
		return null;
	}

	@Override
	public ArrayList<Product> stockCheck() {
		return productList;
	}

	@Override
	public boolean stockCreate(Product product) {
		Product temp = stockCheck(product.getProductId());
		if (temp == null)
			return productList.add(product);
		return false;
	}

	@Override
	public boolean stockUpdate(String productId, int quantity) {
		Product temp = stockCheck(productId);
		if (temp != null) {
			temp.setQuantity(temp.getQuantity() + quantity);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Product> nowSalesList() {
		return todaySales;
	}

	@Override
	public boolean todaySales(CustomerPurchase purchase) {
		Product temp = stockCheck(purchase.getProductId());
		if (temp != null) {
			temp.setQuantity(temp.getQuantity() - purchase.getBuyQuantity());
			addtoday(new Product(temp.getProductId(), temp.getProductName(), temp.getUnitPrice(),
					purchase.getBuyQuantity())); // 그대로 temp를 넘겨주면 옅은 복사로 1개의 객체가 2개의 리스트에 들어가서 그대로 동기화됨
			return customerSales.add(purchase);
		}
		return false;
	}

	public boolean addtoday(Product pd) {
		for (Product p : todaySales) {
			if (p.getProductId().equals(pd.getProductId())) {
				p.setQuantity(p.getQuantity() + pd.getQuantity());
				return true;
			}
		}
		return todaySales.add(pd);
	}

	@Override
	public ArrayList<CustomerPurchase> todayPurchase(String email) {
		ArrayList<CustomerPurchase> purchaseList = new ArrayList<>();
		for (CustomerPurchase cp : customerSales) {
			if (cp.getEmail().equals(email))
				purchaseList.add(cp);
		}
		return purchaseList;
	}

	@Override
	public void loadFile() {
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			if (!f.exists())
				f.createNewFile();
			productList = (ArrayList<Product>) ois.readObject();
			ois.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void saveFile() {
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Product p : productList) {
				if (p.getQuantity() == 0) {
					productList.remove(p);
				}
			}
			oos.writeObject(productList);
			oos.flush();
		} catch (Exception e) {
		}
	}
}