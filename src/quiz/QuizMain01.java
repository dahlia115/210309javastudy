package quiz;

import java.util.Scanner;

public class QuizMain01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int stNum=0, num=0;
		String name;
		QuizFileIO fileIO = new QuizFileIO();
		QuizMember m = null;
		while(true) {
			System.out.println("1.검색 2.등록 3.종료");
			num = input.nextInt();
			switch(num) {
			case 1:
				System.out.print("검색 학번 입력 : ");
				stNum = input.nextInt();
				m = fileIO.searchNum(stNum);
				if(m != null) {
					System.out.println("---- 개인정보 ----");
					System.out.println("학번 : "+m.getStNum());
					System.out.println("이름 : "+m.getName());
				}else {
					System.out.println("조회하신 정보가 없습니다!~!!");
				}
				break;
			case 2:
				System.out.print("등록 학번 입력 : ");
				stNum = input.nextInt();
				System.out.print("등록 이름 입력 : ");
				name = input.next();
				m = new QuizMember();
				m.setStNum(stNum); m.setName(name);
				boolean bool = fileIO.saveMember(m);
				if(bool) {
					System.out.println("정상적으로 저장 되었습니다");
				}else {
					System.out.println("회원이 존재합니다");
				}
				break;
			case 3:return;
			}
		}
	}
}
