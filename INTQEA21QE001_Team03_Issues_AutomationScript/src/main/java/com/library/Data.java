package com.library;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class Data {
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		
        //First enter starting row then ending row number from iterator column
		int Starting_row =1;
		int Ending_row =2;
		ArrayList<Object[]> testData=DataProviderr.getdata(Starting_row,Ending_row);
		return  testData.iterator();
		
	}

}
