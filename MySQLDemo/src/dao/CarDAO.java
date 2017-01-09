package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Car;
import util.MySQLHelper;

public class CarDAO {
	public boolean insert(Car car){
		boolean result = false;
		String sql = "insert into car values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, car.getId());
			ps.setString(2, car.getBrand());
			ps.setString(3, car.getModel());
			ps.setString(4, car.getColor());
			ps.setInt(5, car.getPrice());
			
			int row = ps.executeUpdate();
			if(row > 0)
				result = true;
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean update(Car car){
		boolean result = false;
		String sql = "update car set brand = ?, model = ?, color = ?, price = ? where id = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(5, car.getId());
			ps.setString(1, car.getBrand());
			ps.setString(2, car.getModel());
			ps.setString(3, car.getColor());
			ps.setInt(4, car.getPrice());
			
			int row = ps.executeUpdate();
			if(row > 0)
				result = true;
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean delete(String id){
		boolean result = false;
		String sql = "delete from car where id = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, id);
			
			int row = ps.executeUpdate();
			if(row > 0)
				result = true;
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Car> selectAll(){
		List<Car> cars = new ArrayList<Car>();
		String sql = "select * from car";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Car car = new Car();
				car.setId(rs.getString(1));
				car.setBrand(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setColor(rs.getString(4));
				car.setPrice(rs.getInt(5));
				
				cars.add(car);
			}
			rs.close();
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}
	public Car selectById(String id){
		Car car = null;
		String sql = "select * from car where id = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				car = new Car();
				car.setId(rs.getString(1));
				car.setBrand(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setColor(rs.getString(4));
				car.setPrice(rs.getInt(5));
			}
			rs.close();
			ps.close();
			MySQLHelper.closeDB();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}
}
