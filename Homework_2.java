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
}



public class Homework_2 {
	static Scanner input = new Scanner(System.in);
	void start() {
		student[] stu = new student[10];
		professor[] pro = new professor[3];
		subject[] sub = new subject[5];
		
		//�л����� 10�� �Է�
		for (int i = 0; i < stu.length; i++) {
			stu[i] = new student();
			System.out.println("----------"+(i+1)+"��° �л� ���� �Է�----------");
			System.out.print("�й� : ");
			stu[i].setStudent_number(input.nextInt());
			System.out.print("�̸� : ");
			stu[i].setName(input.next());
			System.out.print("�а� : ");
			stu[i].setMajor(input.next());
			System.out.print("�г� : ");
			stu[i].setGrade(input.nextInt());
			System.out.print("��ȭ��ȣ : ");
			stu[i].setPhone_number(input.next());
			System.out.println();
		}
		//�������� 3�� �Է�
		for (int i = 0; i < pro.length; i++) {
			pro[i] = new professor();
			System.out.println("----------"+(i+1)+"��° ���� ���� �Է�----------");
			System.out.print("�̸� : ");
			pro[i].setName(input.next());
			System.out.print("�а� : ");
			pro[i].setMajor(input.next());
			System.out.print("��ȭ��ȣ : ");
			pro[i].setPhone_number(input.next());
			System.out.print("�λ��ȣ");
			pro[i].setUser_number(input.nextInt());
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Homework_2 hom = new Homework_2();
		hom.start();
	}

}
