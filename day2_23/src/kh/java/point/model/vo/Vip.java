package kh.java.point.model.vo;

public class Vip extends Grade{

	@Override
	public double getInterest() {
		return this.getPoint()*0.1;
	}

}
