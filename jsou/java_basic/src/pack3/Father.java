package pack3;

public class Father extends GrandFa{ // extends 상속관계   클레스에 final = 상속불가
		// C언어는 다중상속 가능하지만 JAVA에서는 단일 상속만 가능.
	
		//GrandFa fa = new GrandFa();   // 포함관계
//		private int nai = 55;              // 나이가 있지만 사용할수 없는 형태이다.
		public String gabo = "꽃병";         // 은닉화  : 가보가 없으면 할아버지꺼를 가져오지만 파더에 가보가 있으면 가보를 파더껄로 가져온다.
		private int house = 1;
		public String data = "Father data";
		
		public Father () {
//			super(88);          //기본생성자를 부를때는 필요가 없다. 기본생성자가 아니면 명시적으로 적어야한다.
			System.out.println("아버지 생성자");      // 위에 파일명에 별이 있으면 저장을 하라는 뜻이다.
		}
		
		public Father (int n) {
			super(n);          //기본생성자를 부를때는 필요가 없다. 기본생성자가 아니면 명시적으로 적어야한다.
//			this();            
			System.out.println("아버지 생성자");      
		}
		// Objcet 클래스를 제외한 모든 클래스의 생성자  줄에 생성사, this() 또는 super()를 호출 해야 함.
		// 그렇지 않으면 컴파일러가 자동적으로 super(); 를 생성자의 첫줄에 삽입 함.
		// 조상 클래스의 멤버변수는 이처럼 조상의 생성자에 의해 초기화 되도록 해야 함.
		
		
		@Override                       // 없어도 오버라이딩이 된다. 오버라이딩 가독성을 높이고 강요하는역활    
										// @ 언어테이션 = 내부적으로 프로그램을 짜는것이다.
										// method override(ing)  재정의
//		return super.say();
		
		// 오버라이팅(Overrideing) : 조상 클래스로부터 상속 받은 메서드의 내용을 변경하는 것.
		
		// 자손 클래스 자신에 맞게 변경해야 하는 경우, 조상의 메소드를 오버라이딩하여 수정하여 사용.
		
		// 오버라이딩의 조건 : 자손 클래스에서 오버라이딩하는 메서드는 조상 클래스의 메서드와 이름, 매개변수, 반환타입이 같아야 함.
		
		// 조상 클래스의 메서드를 자손 클래스에서 오버라이딩 할 때 
		// 1. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경 할 수 없음.
		// 2. 예외는 조상 클래스의 메서드보다 많이 선언 할 수 없음.
		// 3. 인스턴스메서드를 static 메서드로 또는 그 반대로 변경 할 수 없음.
		
		// 오버로딩 VS. 오버라이딩
		// 오버로딩(Overloading) : 기존에 없는 새로운 메서드를 정의하는 것(new)
		// 오버라이딩(Overriding) : 상속받은 메서드의 내용을 변경하는 것(change, modify)
		
		public String say() {                      // 오버라이딩이 된 상태에서 틀리면 에러가 떨어진다.
//			return super.say();                    // method override(ing)  재정의
			return "아버지 말씀 : 주말에는 총 정리";         // 다른내용을 진행하고 싶으면 이렇게 해야한다.
		}                                          // 부모의 say가 보이지 않고 아버지say가 보이면 부모의say가 숨어버린다.
//			return "할아버지 말씀: 그날 그날 정리해라";       // 오버라이딩 = 부모와 똑같은 것을 선언
//		}
		public int getHouse() {                    // 자식 클래스 고유의 매소드    자식은 부모것을 가져다 쓰는데 부모는 자식껏을 가질수 없다.
			return house;
		}
		
	}

