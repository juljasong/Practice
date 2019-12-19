package global.sesoc.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

public class ToyManagerMgr implements ToyManager {
	private final String FILE_NAME ="toy.dat";
	private List<Toy> toyList;			// 각종 Toy 정보를 담을 리스트

	private FileInputStream fis;		// 파일을 읽기 위한 객체
	private FileOutputStream fos;		// 파일을 쓰기 위한 객체
	private ObjectInputStream ois;		// 객체를 읽기 위한 객체
	private ObjectOutputStream oos;		// 객체를 쓰기 위한 객체
	
	public ToyManagerMgr() { //생성자
		//this.toyList = new ArrayList<Toy>();
		File file = new File(this.FILE_NAME);
		try {
		if(file.exists()) {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			this.toyList = (ArrayList<Toy>)ois.readObject();
		}else {
			file.createNewFile();
			this.toyList = new ArrayList<Toy>();
		}
	}catch(IOException ex) {
		ex.printStackTrace();
	}catch(ClassNotFoundException ex) {
		ex.printStackTrace();
	}
	}
	
	@Override
	public boolean insertToy(Toy toy) {
		// TODO Auto-generated method stub
		return toyList.add(toy);  //리스트명.add(받는거)
		//return false;
	}
	@Override
	public Toy searchToy(String serialNum) {
		int idx = -1;
		for (int i = 0; i < this.toyList.size(); i++) {
			if (this.toyList.get(i).getSerialNum().equals(serialNum)) {
				idx = i; 
				break;
			}
		}
		if(idx<0)
			return null;
		else 
			return this.toyList.get(idx);
	}
	@Override
	public boolean deleteToy(String serialNum) {
		Toy toy = this.searchToy(serialNum);
		if(toy !=null)
			return toyList.remove(toy);
		else 
			return false;
		//return false;
	}
	@Override
	public List<Toy> toyListForPrice(int minPrice, int maxPrice) {
		 List<Toy>list = new ArrayList<Toy>();
		 for (int i = 0; i < this.toyList.size(); i++) {
			Toy toy = this.toyList.get(i);
			if (toy.getPrice()>minPrice&&toyList.get(i).getPrice()<maxPrice) {
				list.add(toy);
				
			}
		}
		return null;
	}
	@Override
	public List<Toy> printToyInfo(int type) {
		List<Toy> list = new ArrayList<Toy>();
		
			switch(type) {
			case 1: list = this.toyList; break;
			case 2:
				for (int i = 0; i < this.toyList.size(); i++) {
					if (this.toyList.get(i) instanceof Bicycle) {
						list.add(this.toyList.get(i));
					}
				}	
					
					break;
				case 3:
					for (int i = 0; i < this.toyList.size(); i++) {
						if (this.toyList.get(i) instanceof Drone) {
							list.add(this.toyList.get(i));
						}
					}		
						
						break;
					case 4:
						for (int i = 0; i < this.toyList.size(); i++) {
							if (this.toyList.get(i) instanceof GameConsole) {
								list.add(this.toyList.get(i));
							}
								
							}
							break;
				}
			
		
		return list;
	}

	public void saveFile() {
		try {
		this.fos = new FileOutputStream(this.FILE_NAME);
		this.oos = new ObjectOutputStream(this.fos);
		this.oos.writeObject(this.toyList);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
	}	finally {
		try {
			if(oos!= null) oos.close();
				if(fos !=null) fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		}

}
	


