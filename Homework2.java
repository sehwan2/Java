import java.util.Scanner;

class student{
	private int student_number;
	private String name;
	private String major;
	private String grade;
	private String phone_number;
	//Korean = 0, Math = 1, Java = 2, C = 3, Python = 4
	private boolean[] classes = {false, false, false, false, false};
		
	// 변수값 저장 메소드
	public void setStudent_number(int p) {
		this.student_number = p;
	}
	public int getStudent_number() {
		return student_number;
	}
	public void setName(String p) {
		this.name = p;
	}
	public String getName() {
		return name;
	}
	public void setMajor(String p) {
		this.major = p;
	}
	public String getMajor() {
		return major;
	}
	public void setGrade(String p) {
		this.grade = p;
	}
	public String getGrade() {
		return grade;
	}
	public void setPhone_number(String p) {
		this.phone_number = p;
	}
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setClasses(int class_num, boolean ok) {
		this.classes[class_num] = ok;
	}
}
class professor{
	private String name;
	private String major;
	private String code;
	private String[] stu_list;
	
	public void setName(String p) {
		this.name = p;
	}
	public void setMajor(String p) {
		this.major = p;
	}
	public void setCode(String p) {
		this.code = p;
	}
	public void setStu_list(String[] p) {
		this.stu_list = p;
	}
}
class Classes{
	static student[] students = new student[10];
}
//국어 수업 정보
class Korean_Class extends Classes{
	student[] students = new student[10];
}
//수학 수업 정보
class Math_Class extends Classes{
	student[] students = new student[10];
}
//자바 수업 정보
class Java_Class extends Classes{
	student[] students = new student[10];
}
//C 수업 정보
class C_Class extends Classes{
	student[] students = new student[10];
}
//파이썬 수업 정보
class Python_Class extends Classes{
	student[] students = new student[10];
}

//학생 관리 프로그램
class Manage_Student{
	static Scanner input = new Scanner(System.in);
	
	Korean_Class korean_class = new Korean_Class(); //국어 수업 생성
	Math_Class math_class = new Math_Class(); // 수학 수업 생성
	Java_Class java_class = new Java_Class(); //자바 수업 생성
	C_Class c_class = new C_Class(); //C 수업 생성
	Python_Class python_class = new Python_Class(); //파이썬 수업 생성
	boolean isExist = false;
	int all_search(student student) {
		
		for (student Student : korean_class.students) {
			if(Student.getStudent_number() == student.getStudent_number()) {
				isExist = true;
				return Student.getStudent_number();
			}
		}
		for (student Student : math_class.students) {
			if(Student.getStudent_number() == student.getStudent_number()) {
				isExist = true;
				return Student.getStudent_number();
			}
		}
		for (student Student : java_class.students) {
			if(Student.getStudent_number() == student.getStudent_number()) {
				isExist = true;
				return Student.getStudent_number();
			}
		}
		for (student Student : c_class.students) {
			if(Student.getStudent_number() == student.getStudent_number()) {
				isExist = true;
				return Student.getStudent_number();
			}
		}
		for (student Student : python_class.students) {
			if(Student.getStudent_number() == student.getStudent_number()) {
				isExist = true;
				return Student.getStudent_number();
			}
		}
		return 0;
	}
	void set_Student_Class() {//학생 수업 참가 메뉴

		System.out.println("학생 수업 설정 메뉴.");
		
		System.out.println("수업에 참가할 학생의 학번을 입력하세요.");
		int student_number = input.nextInt(); //학번을 입력받음
		if (student_number <= 0) {
			System.out.println("학번을 제대로 입력하지 않았습니다.");
			return;
		}
		student new_student = null;
		new_student.setStudent_number(student_number);
		isExist = false; //이미 학생이 존재하는지 체크하는 변수
		
		all_search(new_student);
		
		if(!isExist) {
			System.out.println("Error : 해당 학생은 존재하지 않습니다.");
			return;
		}
		System.out.println("넣을 수업을 선택하세요.");
		System.out.println("1. Korean / 2. Math / 3. Java / 4. C / 5. Python");
		int select_class = input.nextInt(); //korean, math, java, c, python 중에서 선택하는 변수
		switch(select_class) {
			case 1://korean
				check_class(java_class, new_student, "Korean", 0);
				new_student.setClasses(0, true);
				break;
			case 2://math
				check_class(c_class, new_student, "Math", 1);
				new_student.setClasses(1, true);
				break;
			case 3://java
				check_class(java_class, new_student, "Java", 2);
				new_student.setClasses(2, true);
				break;
			case 4://c
				check_class(c_class, new_student, "C", 3);
				new_student.setClasses(3, true);
				break;
			case 5://python
				check_class(python_class, new_student, "Python", 4);
				new_student.setClasses(4, true);
				break;
		}
	}

	void check_class(Classes classes, student new_student, String class_name, int class_index) {
		int i = 0;
		switch(class_index) {
			case 0 : //korean
				for(student student : korean_class.students) {
					//기존 국어 수업에 있는 학번들과 새로운 학생의 학번 비교
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("이미 이 학생은 "+class_name+"수업을 듣고 있습니다.");
						return;
					}
					i++;
				}
				//국어 수업에 학생 추가
				korean_class.students[i] = new_student;
				break;
			case 1 : //math
				for(student student : math_class.students) {
					//기존 국어 수업에 있는 학번들과 새로운 학생의 학번 비교
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("이미 이 학생은 "+class_name+"수업을 듣고 있습니다.");
						return;
					}
					i++;
				}
				math_class.students[i] = new_student;
				break;
			case 2 : //java
				for(student student : java_class.students) {
					//기존 국어 수업에 있는 학번들과 새로운 학생의 학번 비교
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("이미 이 학생은 "+class_name+"수업을 듣고 있습니다.");
						return;
					}
					i++;
				}
				java_class.students[i] = new_student;
				break;
			case 3 : //c
				for(student student : c_class.students) {
					//기존 국어 수업에 있는 학번들과 새로운 학생의 학번 비교
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("이미 이 학생은 "+class_name+"수업을 듣고 있습니다.");
						return;
					}
					i++;
				}
				c_class.students[i] = new_student;
				break;
			case 4 : //python
				for(student student : python_class.students) {
					//기존 국어 수업에 있는 학번들과 새로운 학생의 학번 비교
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("이미 이 학생은 "+class_name+"수업을 듣고 있습니다.");
						return;
					}
					i++;
				}
				python_class.students[i] = new_student;
				break;
		}
		System.out.println(class_name+"수업에 정상적으로 참가 되었습니다.");
	}
	void search_student() {
		System.out.println("조회할 학생의 학번을 입력하세요.");
		int student_number = input.nextInt(); //학번을 입력받음
		if (student_number <= 0) {
			System.out.println("학번을 제대로 입력하지 않았습니다.");
			return;
		}
		student new_student = null;
		new_student.setStudent_number(student_number);
		isExist = false; //이미 학생이 존재하는지 체크하는 변수
		//조회된 학생의 학번
		int success = all_search(new_student);
		if(!isExist) {
			System.out.println("Error : 해당 학생은 존재하지 않습니다.");
			return;
		}	
		
		
	}
	
}


public class Homework2 {
	static Scanner input = new Scanner(System.in);
	public void start() {
		//학생 10명 및 교수 3명 객체배열 생성
				student[] stu = new student[10];
				professor[] pro = new professor[3];
				//학생정보 10명 입력
				for (int i = 0; i < stu.length; i++) {
					stu[i] = new student();
					System.out.println("----------"+(i+1)+"번째 학생 정보 입력----------");
					System.out.print("학번 : ");
					stu[i].setStudent_number(input.nextInt());
					System.out.print("이름 : ");
					stu[i].setName(input.nextLine());
					stu[i].setName(input.nextLine());
					System.out.print("학과 : ");
					stu[i].setMajor(input.nextLine());
					System.out.print("학년 : ");
					stu[i].setGrade(input.nextLine());
					System.out.print("전화번호 : ");
					stu[i].setPhone_number(input.nextLine());
					System.out.println();
				}
				//교수정보 3명 입력
				for (int i = 0; i < pro.length; i++) {
					pro[i] = new professor();
					System.out.println("----------"+(i+1)+"번째 교수 정보 입력----------");
					System.out.print("이름 : ");
					pro[i].setName(input.nextLine());
					System.out.print("학과 : ");
					pro[i].setMajor(input.nextLine());
					System.out.println();
				}
				//과목정보 5개 입력
				
				
				
	}
	public void mode() {
		Manage_Student manage = new Manage_Student();
		System.out.println("----------모드 선택----------");
		System.out.print("1.학생모드\t 2.교수모드\t 3.종료\n>>>");
		int mode = input.nextInt();
		switch(mode) {
			case 1:
				System.out.println("-----------학생 모드---------\n1.신청\t2.확인");
				int cho = input.nextInt();
				switch(cho) {
				case 1: manage.set_Student_Class();
					break;
				case 2: manage.search_student();
					break;
				default:
					break;
				}
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
	}
	public static void main(String[] args) {
		Homework2 hom = new Homework2();
		
		hom.start();
		hom.mode();
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