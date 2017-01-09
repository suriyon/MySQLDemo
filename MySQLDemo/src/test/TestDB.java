package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dao.CarDAO;
import model.Car;

public class TestDB {

	public static void main(String[] args) throws IOException {
		Car car;
		CarDAO dao = new CarDAO();
		List<Car> cars = new ArrayList<Car>();
		String id, brand, model, color;
		int price, choice;
		boolean result;
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		do{
			System.out.println("----------main menu-----------");
			System.out.println("1. insert");
			System.out.println("2. update");
			System.out.println("3. delete");		
			System.out.println("4. select");
			System.out.println("5. search");
			System.out.println("6. end program.");
			System.out.println("------------------------------");
			
			System.out.print("select menu > ");
			choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				System.out.println("--------insert--------");
				System.out.print("enter id > ");
				id = br.readLine();
				System.out.print("enter brand > ");
				brand = br.readLine();
				System.out.print("enter model > ");
				model = br.readLine();
				System.out.print("enter color > ");
				color = br.readLine();
				System.out.print("enter price > ");
				price = Integer.parseInt(br.readLine());
				car = new Car();
				car.setId(id);
				car.setBrand(brand);
				car.setModel(model);
				car.setColor(color);
				car.setPrice(price);
				dao = new CarDAO();
				result = dao.insert(car);
				if(result){
					System.out.println("insert car success.");
				}else{
					System.out.println("insert car fail.");
				}
				System.out.print("press enter to continue!");
				br.readLine();
				break;
			case 2:
				System.out.println("--------update--------");
				System.out.print("enter id > ");
				id = br.readLine();
				System.out.print("enter brand > ");
				brand = br.readLine();
				System.out.print("enter model > ");
				model = br.readLine();
				System.out.print("enter color > ");
				color = br.readLine();
				System.out.print("enter price > ");
				price = Integer.parseInt(br.readLine());
				car = new Car();
				car.setId(id);
				car.setBrand(brand);
				car.setModel(model);
				car.setColor(color);
				car.setPrice(price);
				dao = new CarDAO();
				result = dao.update(car);
				if(result){
					System.out.println("update car success.");
				}else{
					System.out.println("update car fail.");
				}
				System.out.print("press enter to continue!");
				br.readLine();
				break;
			case 3:
				System.out.println("--------delete--------");
				System.out.print("enter id > ");
				id = br.readLine();			
				
				dao = new CarDAO();
				result = dao.delete(id);
				if(result){
					System.out.println("delete car success.");
				}else{
					System.out.println("delete car fail.");
				}
				System.out.print("press enter to continue!");
				br.readLine();
				break;
			case 4:
				System.out.println("--------select--------");
				dao = new CarDAO();
				cars = dao.selectAll();
				for (Car c : cars) {
					System.out.println(c.toString());
				}
				System.out.print("press enter to continue!");
				br.readLine();
				break;
			case 5:
				System.out.println("--------search--------");
				System.out.print("enter id > ");
				id = br.readLine();
				
				car = dao.selectById(id);
				if(car != null){
					System.out.println(car.toString());
				}else{
					System.out.println("Can not find car!");
				}
				System.out.print("press enter to continue!");
				br.readLine();
				break;
			case 6:
				System.out.println("------end program-------");
				break;
			default:
				System.out.println("-------out of menu------");
				System.out.print("press enter to continue!");
				br.readLine();
				break;
			}
		}while(choice != 6);
	}
}
