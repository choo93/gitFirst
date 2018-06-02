package kh.java.point.model.vo;

public class Gold extends Grade{

	@Override
	public double getInterest() {
		return this.getPoint()*0.05;
	}

}
