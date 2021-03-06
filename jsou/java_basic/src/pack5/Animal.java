package pack5;

abstract public class Animal {
	// 다형성(polymorphism) : 여러 가지 형태를 가질 수 있는 능력
	// 조상 클래스 타입의 참조변수로 자손클래스의 인스턴트를 참조 할 수 있도록 하였음.
	// 둘 다 같은 타입의 인스턴스지만 참조변수의 타입에 따라 사용할 수 있는 멤버의 개수가 달라짐. 
	// ex) caption tv = new caption tv(caption tv의 참조변수 모두 사용 가능), 
	//     Tv t = new captionTv(조상 타입의 참조변수로 자손 인스턴스를 참조, 모든 멤버를 사용 할 수는 없음)
	// 위에 있는 타입은 같지만 참조변수에 따라 사용할 수 있는 멤버변수가 다름.
	// 참조변수가 사용 할 수 있는 멤버의 개수는 인스턴스의 멤버 개수보다 같거나 적어야 함.
	// 정리 : 조상타입의 참조변수로 자손타입의 인스턴스를 참조할 수 있으나(자기 자신것은 참조 못함),
	//		 반대로 자손타입의 참조변수는 조상타입의 인스턴스를 참조 할 수 없음.
	
	// 참조변수의 형변환(AnimalMain 참조)
	// 자손타입 -> 조상타입(Up-casting) : 형변환 생략가능
	// 자손타입 <- 조상타입(Down-casting) : 형변환 생략불가
	
	// 참조변수와 인스턴스의 연결 : 멤버변수가 조상클래스와 자손 클래스에 중복으로 정의된 경우,
	//					     조상타입의 참조변수를 사용했을 때는 조상 클래스에 선언된 멤버변수가 사용되고,
	//					     자손타입의 참조변수를 사용했을 때는 자손 클래스에 선언된 멤버변수를 사용함.
	
	// 추상메소드가 없어도 상관 없음.
	abstract public String name(); // 추상메소드
	abstract public String eat();
	abstract public String action();
	
	public void print() {
		System.out.println("동물 클래스의 일반 메소드 print");
	}
}
