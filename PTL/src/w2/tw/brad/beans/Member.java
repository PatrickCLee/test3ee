package w2.tw.brad.beans;
//javaBean需要無傳參數建構式，getter和setter的method名稱也要按照規定，屬性慣例為private
public class Member {
	private String account, realname;
	private int age;
	
	public Member() {
		this("","",0);
	}
	
	public Member(String account, String realname, int age) {
		this.account = account;
		this.realname = realname;
		this.age = age;
	}
	
	// getter & setter
	public String getAccount() {
		return "==>" + account;
	}
	public String getRealname() {
		return realname;
	}
	public int getAge() {
		return age;
	}

	public void setAccount(String account) {
		this.account = "***" + account;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return realname + "(" + age + ")";
	}
	
}
