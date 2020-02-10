package w2.tw.brad.javaee;
import w2.tw.brad.myutils.BCrypt;

public class BradAPIs {//plainPW為使用者輸入的密碼, hashPW為資料庫中已有account的對應的雜湊密碼
	public static boolean chPassword(String plainPW, String hashPW) { //checkPassword
		boolean isRight = false;					
		if (hashPW.startsWith("$2a$")) {	//字串比對, 大小寫嚴格區分
			isRight = BCrypt.checkpw(plainPW, hashPW);	//照理來說創建帳號密碼時,存入資料庫的密碼前面開頭會如上,但我們留了一組後門方便測試
		}else {									//若是按照常理創建的帳密,則再使用借來的編碼method驗證密碼是否正確
			isRight = true;
		}
		return isRight;
	}
}
