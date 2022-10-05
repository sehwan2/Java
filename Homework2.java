import java.util.Scanner;

class student{
	private int student_number;
	private String name;
	private String major;
	private String grade;
	private String phone_number;
	//Korean = 0, Math = 1, Java = 2, C = 3, Python = 4
	private boolean[] classes = {false, false, false, false, false};
		
	// ������ ���� �޼ҵ�
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
//���� ���� ����
class Korean_Class extends Classes{
	student[] students = new student[10];
}
//���� ���� ����
class Math_Class extends Classes{
	student[] students = new student[10];
}
//�ڹ� ���� ����
class Java_Class extends Classes{
	student[] students = new student[10];
}
//C ���� ����
class C_Class extends Classes{
	student[] students = new student[10];
}
//���̽� ���� ����
class Python_Class extends Classes{
	student[] students = new student[10];
}

//�л� ���� ���α׷�
class Manage_Student{
	static Scanner input = new Scanner(System.in);
	
	Korean_Class korean_class = new Korean_Class(); //���� ���� ����
	Math_Class math_class = new Math_Class(); // ���� ���� ����
	Java_Class java_class = new Java_Class(); //�ڹ� ���� ����
	C_Class c_class = new C_Class(); //C ���� ����
	Python_Class python_class = new Python_Class(); //���̽� ���� ����
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
	void set_Student_Class() {//�л� ���� ���� �޴�

		System.out.println("�л� ���� ���� �޴�.");
		
		System.out.println("������ ������ �л��� �й��� �Է��ϼ���.");
		int student_number = input.nextInt(); //�й��� �Է¹���
		if (student_number <= 0) {
			System.out.println("�й��� ����� �Է����� �ʾҽ��ϴ�.");
			return;
		}
		student new_student = null;
		new_student.setStudent_number(student_number);
		isExist = false; //�̹� �л��� �����ϴ��� üũ�ϴ� ����
		
		all_search(new_student);
		
		if(!isExist) {
			System.out.println("Error : �ش� �л��� �������� �ʽ��ϴ�.");
			return;
		}
		System.out.println("���� ������ �����ϼ���.");
		System.out.println("1. Korean / 2. Math / 3. Java / 4. C / 5. Python");
		int select_class = input.nextInt(); //korean, math, java, c, python �߿��� �����ϴ� ����
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
					//���� ���� ������ �ִ� �й���� ���ο� �л��� �й� ��
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("�̹� �� �л��� "+class_name+"������ ��� �ֽ��ϴ�.");
						return;
					}
					i++;
				}
				//���� ������ �л� �߰�
				korean_class.students[i] = new_student;
				break;
			case 1 : //math
				for(student student : math_class.students) {
					//���� ���� ������ �ִ� �й���� ���ο� �л��� �й� ��
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("�̹� �� �л��� "+class_name+"������ ��� �ֽ��ϴ�.");
						return;
					}
					i++;
				}
				math_class.students[i] = new_student;
				break;
			case 2 : //java
				for(student student : java_class.students) {
					//���� ���� ������ �ִ� �й���� ���ο� �л��� �й� ��
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("�̹� �� �л��� "+class_name+"������ ��� �ֽ��ϴ�.");
						return;
					}
					i++;
				}
				java_class.students[i] = new_student;
				break;
			case 3 : //c
				for(student student : c_class.students) {
					//���� ���� ������ �ִ� �й���� ���ο� �л��� �й� ��
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("�̹� �� �л��� "+class_name+"������ ��� �ֽ��ϴ�.");
						return;
					}
					i++;
				}
				c_class.students[i] = new_student;
				break;
			case 4 : //python
				for(student student : python_class.students) {
					//���� ���� ������ �ִ� �й���� ���ο� �л��� �й� ��
					if(student.getStudent_number() == new_student.getStudent_number()) {
						System.out.println("�̹� �� �л��� "+class_name+"������ ��� �ֽ��ϴ�.");
						return;
					}
					i++;
				}
				python_class.students[i] = new_student;
				break;
		}
		System.out.println(class_name+"������ ���������� ���� �Ǿ����ϴ�.");
	}
	void search_student() {
		System.out.println("��ȸ�� �л��� �й��� �Է��ϼ���.");
		int student_number = input.nextInt(); //�й��� �Է¹���
		if (student_number <= 0) {
			System.out.println("�й��� ����� �Է����� �ʾҽ��ϴ�.");
			return;
		}
		student new_student = null;
		new_student.setStudent_number(student_number);
		isExist = false; //�̹� �л��� �����ϴ��� üũ�ϴ� ����
		//��ȸ�� �л��� �й�
		int success = all_search(new_student);
		if(!isExist) {
			System.out.println("Error : �ش� �л��� �������� �ʽ��ϴ�.");
			return;
		}	
		
		
	}
	
}


public class Homework2 {
	static Scanner input = new Scanner(System.in);
	public void start() {
		//�л� 10�� �� ���� 3�� ��ü�迭 ����
				student[] stu = new student[10];
				professor[] pro = new professor[3];
				//�л����� 10�� �Է�
				for (int i = 0; i < stu.length; i++) {
					stu[i] = new student();
					System.out.println("----------"+(i+1)+"��° �л� ���� �Է�----------");
					System.out.print("�й� : ");
					stu[i].setStudent_number(input.nextInt());
					System.out.print("�̸� : ");
					stu[i].setName(input.nextLine());
					stu[i].setName(input.nextLine());
					System.out.print("�а� : ");
					stu[i].setMajor(input.nextLine());
					System.out.print("�г� : ");
					stu[i].setGrade(input.nextLine());
					System.out.print("��ȭ��ȣ : ");
					stu[i].setPhone_number(input.nextLine());
					System.out.println();
				}
				//�������� 3�� �Է�
				for (int i = 0; i < pro.length; i++) {
					pro[i] = new professor();
					System.out.println("----------"+(i+1)+"��° ���� ���� �Է�----------");
					System.out.print("�̸� : ");
					pro[i].setName(input.nextLine());
					System.out.print("�а� : ");
					pro[i].setMajor(input.nextLine());
					System.out.println();
				}
				//�������� 5�� �Է�
				
				
				
	}
	public void mode() {
		Manage_Student manage = new Manage_Student();
		System.out.println("----------��� ����----------");
		System.out.print("1.�л����\t 2.�������\t 3.����\n>>>");
		int mode = input.nextInt();
		switch(mode) {
			case 1:
				System.out.println("-----------�л� ���---------\n1.��û\t2.Ȯ��");
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
[��������] 

������ �л����, �������, ������, ��米�� ���� �� �л��� ������û, ��ûȮ��, �׸��� ������ ������ Ȯ���� �� �� �ִ� ������û���� ���α׷��� 

��ü���� ����(���� 6)���� �ۼ��Ͻÿ�.



{����}    �л����� �Է� (10�� �ݺ�)

                |

           �������� �Է� (3�� �ݺ�)

                |

           �������� �Է� �� ��米�� ���� (5���� �ݺ�)             

                |

     ��   ���(�л�, ����, ����) ����

      |         |---------------------------------------------------------------------------------------------------��

      |         |                                                                    |                                                 |

      |    (�л���� ���)                                                  (������� ���)                             (���� ���)

      |         L �޴�(��û, Ȯ��) ����                                        L  ��米�� �λ��ȣ�Է�                L ���α׷� ����

      |                 |                                                                       |

      |                 |                                                                �����ڵ� �Է�

�ݺ�|                 |--------------------------------------��                        |

      |                 |                                              |                  ������ ��� ����

      |          (��û ���)                                 (Ȯ�� ���)

      |                    |                                           |

      |                 �й� �Է�                                �й� �Է�

      |                    |                                           |

      L                 ��û���� �Է� (3ȸ �ݺ�)            ������û ���� ���� 



    �� ������û ������ ��ܿ� �й�, �̸�, �а�, �г�, ��ȭ��ȣ�� ������ ����, ��û���� ����� �����ָ�, �ϴܿ� ��û���� �Ѱ踦 ǥ���Ѵ�.

        ��û���� ����� {����, �����ڵ�, �����, ����, ��米����}�� ����Ʈ�̴�.



    �� ������ ����� ��ܿ� ��米���� �̸�, �а�, ��ȭ��ȣ, �����ο��� ������ ����, ������ ����� �����ش�.

         ������ ����� {����, �̸�, �й�, �а�, �г�}�� ����Ʈ�̴�.
*/