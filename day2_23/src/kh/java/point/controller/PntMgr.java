package kh.java.point.controller;

import java.util.Scanner;

import kh.java.point.model.vo.*;

public class PntMgr implements PntMgrInterface{
	private Grade [] g = new Grade[20];
	private int index = 0;	private int num = -1;

	@Override
	public void start() {
		Scanner sc = new Scanner(System.in);
		int sel;
		while(true) {
			while (true) {
				System.out.println("======ȸ�� ���� �ý���=======");
				System.out.println("1. ȸ�� �߰�");
				System.out.println("2. ȸ�� ��ȸ");
				System.out.println("3. ȸ�� ���� ����");
				System.out.println("4. ȸ�� ����");
				System.out.println("0. ����");
				System.out.print("���� : ");
				sel = sc.nextInt();
				if (0<=sel && sel<=4)	break;
				else	System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
			switch (sel)
			{
			case 1 : insertData();	break;
			case 2 : printData();	break;
			case 3 : modifyData();	break;
			case 4 : deleteData();	break;
			case 0 : System.out.println("�ý��� ����");	return;
			}
		}
	}

	@Override
	public void insertData() {
		Scanner sc = new Scanner(System.in);
		String name;	String grade;	int point;
		System.out.print("ȸ�� �̸� �Է� : ");
		name = sc.next();

		while(true) {							// ��� ������ ����� �Է��� ������ �ݺ� �Է�
			System.out.print("ȸ�� ��� �Է� : ");
			grade = sc.next();
			if (grade.equals("Silver")) { g[index] = new Silver();	break;		// �Է� �޴� ��޿� ���� �׿� �´� �� ��ü(Silver��� �Ӽ��� ����)�� �����ؼ� �θ� Ŭ���� ��ü�� g[]�� ����
			}else if(grade.equals("Gold"))	{ g[index] = new Gold();	break;
			}else if(grade.equals("Vip"))	{ g[index] = new Vip();	break;
			}else {	System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}						
		}

		System.out.print("����Ʈ �Է� : ");
		point = sc.nextInt();

		g[index].setName(name);	g[index].setGrade(grade);	g[index++].setPoint(point);
		System.out.println();
	}

	@Override
	public void printData() {
		System.out.println("ȸ�� ���� ���");
		System.out.println("�̸�\t���\t����Ʈ\t����");
		if (index==0) {
			System.out.println("ȸ�� ������ �����ϴ�.");
		}else {
			for(int i=0; i<index; i++) {
				System.out.printf("%s\t%s\t%d\t%.2f\n", g[i].getName(), g[i].getGrade(), g[i].getPoint(), g[i].getInterest());
			}
		}
		System.out.println();
	}

	@Override
	public int searchData() {
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.print("ã�� �̸� �Է� : ");
		name = sc.next();
		
		for(int i=0; i<index; i++) {
			if(name.equals(g[i].getName())) {
				num = i;
			}
		}
		if(num==-1)	System.out.println("ã���ô� ȸ���� �����ϴ�.");
		return num;
	}

	@Override
	public void modifyData() {
		Scanner sc = new Scanner(System.in);
		
		searchData();
		if(num==-1)	return;
		
		System.out.print("������ �̸� : ");
		g[num].setName(sc.next());
		
		while(true) {							// ��� ������ ����� �Է��� �� ���� �ݺ� �Է�
			System.out.print("������ ��� : ");
			g[num].setGrade(sc.next());
			if(g[num].getGrade().equals("Silver") || g[num].getGrade().equals("Gold") || g[num].getGrade().equals("Vip")) {
				break;
			}else {
				System.out.println("����� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		
		System.out.print("������ ����Ʈ : ");
		g[num].setPoint(sc.nextInt());
	}

	@Override
	public void deleteData() {
		searchData();
		if (num==-1)	return;
		index--;
		
		for(int i=num; i<index; i++) {
			g[i] = g[i+1];
		}
		System.out.println();
	}

}
