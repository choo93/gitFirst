package kh.java.point.model.vo;

public abstract class Grade {
	private String name;
	private String grade;
	private int point;
	
	public Grade() {}
	
	public void setName(String name)	{this.name = name;}
	public void setGrade(String grade)	{this.grade = grade;}
	public void setPoint(int point)		{this.point = point;}
	
	public String getName()	{return name;}
	public String getGrade(){return grade;}
	public int getPoint()	{return point;}
	public abstract double getInterest();

	@Override
	public String toString() {
		return "name=" + name + ", grade=" + grade + ", point=" + point;
	}
	
	
}
