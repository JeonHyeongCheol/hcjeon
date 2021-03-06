package pack5;

public class AnimalMain {
	public static void main(String[] args) {
		Animal animal = null; // Animal 타입의 참조변수 animal을 선언하고 null로 초기화 함.
		AniCow cow2 = null;
		
		AniCow cow = new AniCow();
		System.out.println(cow.name() + " " + cow.action() + "에 " + cow.eat() + "먹음" );
		
		System.out.println();
		
		AniLion lion = new AniLion();
		System.out.println(lion.name() + " " + lion.action() + "에 " + lion.eat() + "먹음" );
		
		lion.eatOther(); // 라이언 고유 메소드이기 때문에 lion에만 사용가능.
		
		System.out.println("----------------------");
		
		// cow2 = (AniCow)animal; // 참조변수 형변환 자손 <- 조상 타입
		animal = cow; // 참조변수의 형변환, 조상 <- 자손 타입
		System.out.println(animal.name());
		animal = lion;
		System.out.println(animal.name());
		
		System.out.println("----------------------");
		
		AnimalUtil.find(cow); // static이기 때문에 클래스자체를 불러서 사용 가능.
		System.out.println();
		AnimalUtil.find(lion);
		
		System.out.println();
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
		// AniDog dog = new AniDog(); // AniDog는 추상클래스이기 때문에 새로운 객체를 만들수 없음.
		
		// 추상클래스는 다형성을 하기 위해서.
		
		AniDog dog = new AniDogWolf(); // 추상클래스에 밑에는 자식 클래스는 new 가능. 
		System.out.println(dog.name()); // Anidogwolf에 없기 때문에 부모클래스에 있는 name을 가져옴.
		System.out.println(dog.eat());
		System.out.println(dog.action());
	}
	
}
