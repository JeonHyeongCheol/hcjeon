package java_basic3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		// 컬렉션 프레임웍(Collections Framework) : 데이터 군을 저장하는 클래스들을 표준화한 설계
		// 다수의 데이터를 다루는데 필요한 다양하고 풍부한 클래스들을 제공하기 때문에 프로그래머의 짐을 상당히 덜어주며,
		// 인터페이스와 다형성을 이용한 객체지향적 설계를 통해 표준화되어 사용법을 익히기에 편리하며 재사용성이 높은 코드를 작성 할 수 있는 장점이 있음.
		
		// 컬렉션 프레임웍에 핵심 인터페이스
		// List : 순사기 있는 데이터의 집합, 데이터의 중복 허용.
		// Set : 순서를 유지않는 데이터의 집합, 데이터의 중복을 허용하지 않음.
		// Map : 키와 값의 쌍으로 이루어진 데이터의 집합, 순서가 유지되지 않고, 키는 중복을 허용하지 않고, 값은 중복을 허용
		
		// 컬렉션은 자료구조를 의미하고 배열과 비슷한 구조를 가짐. 기존배열 보완
		// 컬렉션 HashSet<Object>
		// 객체를 담는 그릇
		
		// Set 인터페이스 : 중복을 허용 하지 않고 저장순서가 유지되지 않는 컬렉션 클래스를 구현하는데 사용.
		// Set 인터페이스를 구현한 클래스 : HashSet, TreeSet 등

		HashSet<Object> list = new HashSet<>(); // <> 안에 들어가는 객체타입만 담아 둠. object는 모든 것을 담아줌.
		// HashSet : Set 인터페이스를 구현한 가장 태표적인 컬렉션, 중복된 요소를 저장하지 않음.
		// HashSet 새로운 요소 추가 : add(), addAll() 사용.
		// LinkedHashSet : HashSet으로 저장순서를 유지할 때.
	
		list.add("lee"); // add는 내용 추가. string 들어감.
		list.add(12); // int로 들어감.
		TryTest test = new TryTest();
		list.add(test);
		System.out.println(list.size()); // 컬렉션 list에 3개가 들어가 있기 때문에 3을 출력.
		
		list.clear(); // 컬렉션 내에 모든 내용을 지움
		System.out.println(list.size());
		
		list.add("lee");
		list.add("kim");
		list.add("choi");
		list.add("han");
		list.add("han"); // 중복을 허용하지 않음
		System.out.println(list.size()); // 중복이 하나 있기 때문에 list size는 4가 되는 것.
		
		list.remove("kim"); // 컬렉션내에 list 내용 하나를 지움.
		System.out.println(list.size()); 
		System.out.println(list);
		//System.out.println(list.toArray()); // 주소값 보여 주기.
		
		myprint(list); // set 타입
		myprint(list.toArray()); // object arr타입
		
	}
	
	
	
	public static void myprint(Set set) { // set 타입
		StringBuffer sb = new StringBuffer(); // 스트링 버퍼
		String imsi = null;
		
		Iterator<Object> iter = set.iterator();
		while(iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);
			
			
			//imsi += ss; // 문자열 더하기. 비권장. 속도가 떨어짐.
			sb.append(ss); // 문자열 더하기. 권장. 속도가 빠름.
			sb.append(" ");
		}
		
		System.out.println(sb.toString()); // 문자열 더하기 출력
	}
	
	public static void myprint(Object[] obj) { // object arr타입
		for(int i = 0; i < obj.length; i++ ) {
			System.out.println(obj[i]);
		}

	}
}
