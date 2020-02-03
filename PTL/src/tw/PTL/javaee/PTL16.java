package tw.PTL.javaee;
// model, 普通class
public class PTL16 {
	int x, y, op;
	public PTL16(String x, String y, String op) {
		this.x = Integer.parseInt(x); 
		this.y = Integer.parseInt(y);
		this.op= Integer.parseInt(op);
	}
	public double operation() {
		switch(op) {
		case 1: return x + y;	//有return就會結束, 不用break了
		case 2: return x - y;
		case 3: return x * y;
		case 4: return x*1.0 / y;
		default: return 0;
		}
	}
	
}
