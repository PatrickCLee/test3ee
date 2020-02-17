package w3.tw.brad.myutils;

import java.util.HashSet;

public class BradAPI {
	public static String createLottery() {
		HashSet<Integer> set = new HashSet<Integer>();
		while (set.size()<6) {
			set.add((int)(Math.random()*49+1));
		}
		return set.toString();
	}
	
	public static String sayHello(String name) {
		return "Hello, " + name;
	}
	
	public static String calc(String x, String y, String op) {
		String ret = "";
		try {
			int intx = Integer.parseInt(x);
			int inty = Integer.parseInt(y);
			switch(op) {
			case "1": ret += (intx + inty);		break;
			case "2": ret += (intx - inty);		break;
			case "3": ret += (intx * inty);		break;
			case "4": ret += (intx *1.0 / inty);break;
			}			
			} catch (Exception e) {
				System.out.println(e);
			}
		return ret;
	}
	
	//以下是自己的寫法 但一開始開網頁無傳參數 故需try catch
//	public static String cal(String x, String y, String op) {
//		try {
//			int intx = Integer.parseInt(x);
//			int inty = Integer.parseInt(y);
//			switch(op) {
//			case "1": return intx + inty + "";
//			case "2": return intx - inty + "";
//			case "3": return intx * inty + "";
//			case "4": return intx *1.0 / inty + "";
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return "";
//	}
	
	public static int randomScore() {
		return (int)(Math.random()*101);
	}
	
}
