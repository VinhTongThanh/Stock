package sentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.CoPhieuData;

public class LongTerm extends Sentence{
	private File myObj = new File("D://Games//Java//Stock//src//sentence//model//LongTerm.txt");
	private ArrayList<String> fileString = new ArrayList<String>();
	private CoPhieuData cpdt = new CoPhieuData();

	public LongTerm() throws IOException {
		ArrayList<String> tempString = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(
					   new InputStreamReader(
			                      new FileInputStream(myObj), "UTF8"));
			String s;
			while( (s = in.readLine()) != null) {
				tempString.add(s);
			}
			
			int ran = (int) Math.floor(Math.random()*(2-0+1)+0);
			switch (ran) {
			case 0:
				setSentence1(tempString.get(0));
				break;
			case 1:
				setSentence2(tempString.get(1));
				break;
			case 2:
				setSentence3(tempString.get(2));
				break;
			}
			
			in.close();
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}

	public ArrayList<String> getFileString() {
		return fileString;
	}
	
	public void setSentence1(String str) {
		String str1;
		float Total=0;
		for(int i=0;i<20;i++) {
			if(cpdt.getTotalTrade().get(i)>0) {
				Total= Total + cpdt.getTotalTrade().get(i);
			} else {
				Total= Total - cpdt.getTotalTrade().get(i);
			}
		}
		Float percent = (cpdt.getTotalTrade().get(0)/Total)*100;
		str1 = str.replaceAll("<stockPrice>",cpdt.getClose().get(0).toString() + " ngh�n");	
		str1 = str1.replace("<stockCode>", cpdt.getStockID().get(0));
		str1 = str1.replace("<stockCode>", cpdt.getStockID().get(1));
		str1 = str1.replaceAll("<stockVolume>", cpdt.getVolume().get(0).toString());
		str1 = str1.replaceAll("<percentage>", percent.toString());
		fileString.add(str1);
	}
	
	public void setSentence2(String str) {
		String str1;
		str1 = str.replaceAll("<stockPrice>",cpdt.getClose().get(0).toString() + " ngh�n");	
		str1 = str1.replaceAll("<stockCode>", cpdt.getStockID().get(0));
		str1 = str1.replaceAll("<stockVolume>", cpdt.getVolume().get(0).toString());
		fileString.add(str1);
	}
	
	public void setSentence3(String str) {
		String str1;
		str1 = str.replaceAll("<stockPrice>",cpdt.getClose().get(0).toString() + " ngh�n");	
		str1 = str1.replaceAll("<stockCode>", cpdt.getStockID().get(0));
		str1 = str1.replaceAll("<stockVolume>", cpdt.getVolume().get(0).toString());
		fileString.add(str1);
	}
}
