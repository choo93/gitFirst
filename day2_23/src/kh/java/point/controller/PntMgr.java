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
				System.out.println("======회원 관리 시스템=======");
				System.out.println("1. 회원 추가");
				System.out.println("2. 회원 조회");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("0. 종료");
				System.out.print("선택 : ");
				sel = sc.nextInt();
				if (0<=sel && sel<=4)	break;
				else	System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
			switch (sel)
			{
			case 1 : insertData();	break;
			case 2 : printData();	break;
			case 3 : modifyData();	break;
			case 4 : deleteData();	break;
			case 0 : System.out.println("시스템 종료");	return;
			}
		}
	}

	@Override
	public void insertData() {
		Scanner sc = new Scanner(System.in);
		String name;	String grade;	int point;
		System.out.print("회원 이름 입력 : ");
		name = sc.next();

		while(true) {							// 등급 정보를 제대로 입력할 때까지 반복 입력
			System.out.print("회원 등급 입력 : ");
			grade = sc.next();
			if (grade.equals("Silver")) { g[index] = new Silver();	break;		// 입력 받는 등급에 따라 그에 맞는 새 객체(Silver라는 속성을 가진)를 생성해서 부모 클래스 객체인 g[]에 대입
			}else if(grade.equals("Gold"))	{ g[index] = new Gold();	break;
			}else if(grade.equals("Vip"))	{ g[index] = new Vip();	break;
			}else {	System.out.println("잘못 입력하셨습니다.");
			}						
		}

		System.out.print("포인트 입력 : ");
		point = sc.nextInt();

		g[index].setName(name);	g[index].setGrade(grade);	g[index++].setPoint(point);
		System.out.println();
	}

	@Override
	public void printData() {
		System.out.println("회원 정보 출력");
		System.out.println("이름\t등급\t포인트\t이자");
		if (index==0) {
			System.out.println("회원 정보가 없습니다.");
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
		System.out.print("찾을 이름 입력 : ");
		name = sc.next();
		
		for(int i=0; i<index; i++) {
			if(name.equals(g[i].getName())) {
				num = i;
			}
		}
		if(num==-1)	System.out.println("찾으시는 회원이 없습니다.");
		return num;
	}

	@Override
	public void modifyData() {
		Scanner sc = new Scanner(System.in);
		
		searchData();
		if(num==-1)	return;
		
		System.out.print("수정된 이름 : ");
		g[num].setName(sc.next());
		
		while(true) {							// 등급 정보를 제대로 입력할 때 까지 반복 입력
			System.out.print("수정된 등급 : ");
			g[num].setGrade(sc.next());
			if(g[num].getGrade().equals("Silver") || g[num].getGrade().equals("Gold") || g[num].getGrade().equals("Vip")) {
				break;
			}else {
				System.out.println("등급을 잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
		
		System.out.print("수정된 포인트 : ");
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
