package pack3;

//public class Zzz extends Object{
public class Zzz{                    //최상의 슈퍼클레스는 Object 가 통상적이다.
	// Object 클래스는 모든 클래스 상속계층도의 최상위에 있는 조상클래스임.
	// 다른 클래스로부터 상속 받지 앟는 모든 클래스들은 자동적으로 Object 클래스로부터 상속받게 함으로써 이것을 가능하게함.
	public int aa = 10;
	
	@Override
	public String toString() {
		return "푸하하하하하";                         // 부모 값을 지우고 내가 원하는걸 넣으면 "오버라이딩(부모의 기능을 버리고 새로운 기능 취하)"
//		return super.toString();                   //super. 이 들어가면 
	}
	
	public static void main(String[] args) {       //클레스의 관계는 포함이나 상속에서 결정을 해야하는데 포함을 많이 선호.
		Zzz zz = new Zzz();                        //포함하면 자신것만 줄수있고 , 상속으로주면 내 부모것도 준다.
		System.out.println(zz);                    //객체변수의 주소를 찍어준다.
		System.out.println(zz.toString());         //toString 은 생략해도된다.
		
		
		
	}
}
