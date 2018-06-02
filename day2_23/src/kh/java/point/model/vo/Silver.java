package kh.java.point.model.vo;

public class Silver extends Grade{

	@Override
	public double getInterest() {
		return getPoint()*0.03;
	}

}
