import java.util.Scanner;

class student{
	private int student_number;
	private String name;
	private String major;
	private int grade;
	private String phone_number;
	
	void setStudent_number(int p) {
		student_number = p;
	}
	int getStudent_number() {
		return student_number;
	}
	
	void setName(String p) {
		name = p;
	}
	String getName() {
		return name;
	}
	
	void setMajor(String p) {
		major = p;
	}
	String getMajor() {
		return major;
	}
	
	void setGrade(int p) {
		grade = p;
	}
	int getGrade() {
		return grade;
	}
	
	void setPhone_number(String p) {
		phone_number = p;
	}
	String getPhone_number() {
		return phone_number;
	}
	
	
	
	
	
}

class professor{
	private String name;
	private String major;
	private String phone_number;
	private int user_number;
	
	void setName(String p) {
		name = p;
	}
	String getName() {
		return name;
	}
	
	void setMajor(String p) {
		major = p;
	}
	String getMajor() {
		return major;
	}
	
	void setPhone_number(String p) {
		phone_number = p;
	}
	String getPhone_number() {
		return phone_number;
	}
	
	void setUser_number(int p) {
		user_number = p;
	}
	int getUser_number() {
		return user_number;
	}
}

class subject{
	private int code;
	private String name;
	private int score;
	private int design_pro;
	private int[] student_number = new int[10]; // 수강생 학번
	void setCode(int p) {
		code = p;
	}
	int getCode() {
		return code;
	}
	
	void setName(String p) {
		name = p;
	}
	String getName() {
		return name;
	}
	
	void setScore(int p) {
		score = p;
	}
	int getScore() {
		return score;
	}
	
	void setDesign_pro(int p, int pro_length) {
		if(p < pro_length) {
			design_pro = p-1;
			return;
		}
		System.out.println("없는 번호입니다. 다시 선택하세요.");
		setDesign_pro(p, pro_length);
	}
	int getDesign_pro() {
		return design_pro;
	}
	
	void setStu(int p) {
		for (int i = 0; i < student_number.length; i++) {
			if(student_number[i] == 0) {
				student_number[i] = p;
			}
		}
	}
	int getStu(int p) {
		return student_number[p];
	}
}

class ManagementSystem{
	Scanner input = new Scanner(System.in);
	subject[] student(int p, student[] stu, professor[] pro,subject[] sub) {
		System.out.println("학번을 입력하세요.");
		int student_number = input.nextInt();
		
		//학번 확인
		for (int i = 0; i < stu.length; i++) {
			if(stu[i].getStudent_number() == student_number) {
				System.out.println("학번 확인이 되었습니다.");
				break;
			}
			if(i == stu.length) {
				System.out.println("존재하지 않는 학번입니다.");
				return sub;
			}
		}
		
		//신청
		if(p == 1) {
		
			System.out.println("수강신청입니다.");
			System.out.println("3회 반복합니다.");
			int choice = 0;
			for(int j = 0; j < 3; j++) {
				for (int i = 0; i < sub.length; i++) {
					System.out.println((i+1)+".");
					System.out.println("과목명 : "+sub[i].getName());
					System.out.println("과목코드 : "+sub[i].getCode());
					System.out.println("담당교수 : "+pro[sub[i].getDesign_pro()].getName());
					System.out.println();
				}
			choice = input.nextInt();
			if(choice<0 || choice>sub.length) {
				System.out.println("올바른 입력이 아닙니다.");
				return sub;
			}
			sub[(choice-1)].setStu(student_number);
			}
		}
		
		//확인
		if(p == 2){
			
			
			
			
			
			//이 학생이 듣고 있는 과목
			for (int i = 0; i < sub.length; i++) {
				for(int j = 0; j < 10; j++)
				if(sub[i].getStu(j) == student_number) {
					//
				}
			}
			//듣고 있는 과목의 학점 총계
			
		}
		
		
		
		return sub;
	}
	void professor() {
		
	}
}

public class Homework2 {
	Scanner input = new Scanner(System.in);
	void start() {
		student[] stu = new student[10];
		professor[] pro = new professor[3];
		subject[] sub = new subject[5];
		ManagementSystem manage = new ManagementSystem();
		//학생정보 10명 입력
		for (int i = 0; i < stu.length; i++) {
			stu[i] = new student();
			System.out.println("----------"+(i+1)+"번째 학생 정보 입력----------");
			System.out.print("학번 : ");
			stu[i].setStudent_number(input.nextInt());
			System.out.print("이름 : ");
			stu[i].setName(input.next());
			System.out.print("학과 : ");
			stu[i].setMajor(input.next());
			System.out.print("학년 : ");
			stu[i].setGrade(input.nextInt());
			System.out.print("전화번호 : ");
			stu[i].setPhone_number(input.next());
		}
		//교수정보 3명 입력
		for (int i = 0; i < pro.length; i++) {
			pro[i] = new professor();
			System.out.println("----------"+(i+1)+"번째 교수 정보 입력----------");
			System.out.print("이름 : ");
			pro[i].setName(input.next());
			System.out.print("학과 : ");
			pro[i].setMajor(input.next());
			System.out.print("전화번호 : ");
			pro[i].setPhone_number(input.next());
			System.out.print("인사번호 : ");
			pro[i].setUser_number(input.nextInt());
			System.out.println();
		}
		for (int i = 0; i < sub.length; i++) {
			sub[i] = new subject();
			System.out.println("----------"+(i+1)+"번째 과목 정보 입력----------");
			System.out.print("코드 : ");
			sub[i].setCode(input.nextInt());
			System.out.print("이름 : ");
			sub[i].setName(input.next());
			System.out.print("학점 : ");
			sub[i].setScore(input.nextInt());
			System.out.println("담당교수 지정");
			for (int j = 0; j < pro.length; j++) {
				System.out.print((j+1)+". "+ pro[j].getName()+"\t");
			}
			sub[i].setDesign_pro(input.nextInt(), pro.length);
		}

		int system = 0;
		int check_number = 0;
		while(true) {
			check_number = 0;
			System.out.println("-----1.학생모드\t2.교수모드\t3.종료-----");
			system = input.nextInt();
			switch(system) {
				case 1:
					System.out.println("학생모드입니다.");
					System.out.println("-----1.신청\t2.확인");
					check_number = input.nextInt();
					if(check_number != 1 && check_number != 2) {
						System.out.println("올바른 입력이 아닙니다.");
						break;
					}
					sub = manage.student(check_number, stu, pro, sub);
					break;
				case 2:
					System.out.println("교수모드입니다.");
					System.out.print("담당교수의 인사번호를 입력하세요 >>>");
					check_number = input.nextInt();
					for (int i = 0; i < pro.length; i++) {
						if(pro[i].getUser_number() == check_number) {
							System.out.println("인사번호 확인이 되었습니다.");
							System.out.print("과목코드를 입력하세요 >>>");
							check_number = input.nextInt();
							for (int j = 0; j < sub.length; j++) {
								if(sub[j].getCode() == check_number) {
									
									break;
								}
								
							}
							break;
						}
					}
					System.out.println("존재하지 않는 인사번호입니다.");
					break;
				case 3:
					System.out.println("종료합니다."); break;
			}
			
			if(system == 3)
				break;
		}
	}
	public static void main(String[] args) {
		Homework2 hom = new Homework2();
		hom.start();
	}

}



/*
	[과제내용] 

  직원의 학생등록, 교수등록, 과목등록, 담당교수 배정 후 학생의 수강신청, 신청확인, 그리고 교수의 수강자 확인을 할 수 있는 수강신청관리 프로그램을 

  객체지향 버전(버전 6)으로 작성하시오.



  {절차}    학생정보 입력 (10명 반복)

                  |

             교수정보 입력 (3명 반복)

                  |

             과목정보 입력 및 담당교수 배정 (5과목 반복)             

                  |

       ㅜ   모드(학생, 교수, 종료) 선택

        |         |---------------------------------------------------------------------------------------------------ㄱ

        |         |                                                                    |                                                 |

        |    (학생모드 경우)                                                  (교수모드 경우)                             (종료 경우)

        |         L 메뉴(신청, 확인) 선택                                        L  담당교수 인사번호입력                L 프로그램 종료

        |                 |                                                                       |

        |                 |                                                                과목코드 입력

  반복|                 |--------------------------------------ㄱ                        |

        |                 |                                              |                  수강자 명단 보기

        |          (신청 경우)                                 (확인 경우)

        |                    |                                           |

        |                 학번 입력                                학번 입력

        |                    |                                           |

        L                 신청과목 입력 (3회 반복)            수강신청 내역 보기 



      ※ 수강신청 내역은 상단에 학번, 이름, 학과, 학년, 전화번호를 보여준 다음, 신청과목 목록을 보여주며, 하단에 신청학점 총계를 표시한다.

          신청과목 목록은 {연번, 과목코드, 과목명, 학점, 담당교수명}의 리스트이다.



      ※ 수강자 명단은 상단에 담당교수의 이름, 학과, 전화번호, 수강인원을 보여준 다음, 수강자 목록을 보여준다.

           수강자 목록은 {연번, 이름, 학번, 학과, 학년}의 리스트이다.



*/
