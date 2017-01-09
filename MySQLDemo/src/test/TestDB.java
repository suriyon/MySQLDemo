package test;

import util.MySQLHelper;

public class TestDB {

	public static void main(String[] args) {
		if(MySQLHelper.openDB() != null){
			System.out.println("Connection Success.");
			MySQLHelper.closeDB();
		}else{
			System.out.println("Connection Fail.");
		}
	}
}
