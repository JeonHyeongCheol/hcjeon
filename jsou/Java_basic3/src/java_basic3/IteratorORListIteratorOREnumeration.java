package java_basic3;

public class IteratorORListIteratorOREnumeration {
	// Iterator, ListIterator, Enumeration은 모두 컬렉션에 저장된 요소를 접근하는데 사용되는 Interface.
	// Enumeration은 Iterator의 구버젼, ListIterator는 Iterator의 기능을 향상 시킨 것.
	
	// Iterator : 컬렉션 프레임웍에서는 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화함. 코드의 재사용성을 높이는 것이 가능.
	
	//	  		   컬렉션에 저장된 각 요소에 접근하는 기능 가진 Iterator 인터페이스를 정의,
	//			  Collection 인터페이스는 'Iterator(Iterator를 구현한 클래스의 인스턴스)'를 반환하는 iterator()를 정의.
	//			  iterator()는 Collection인터페이스에 정의된 메서드임(List나 Set에도 포함).
	// iterator 구현방법 : 컬렉션 클래스에 대해 iterator()를 호출, Iterator를 얻은 다음 반복문, 주로 while문을 사용해 컬렉션 클래스 요소들을 읽어옴.
	// 주의 : Map 인터페이스를 구현한 컬렉션 클래스는 키와 값을 쌍으로 저장하고 있기 때문에 iterator()를 직접 호출 할 수 없으며,
	// 		keySet()이나 entrySet()과 같은 메서드를 통해서 키와 값을 따로 Set의 형태로 얻어 온 후에 다시 iterator()를 호출해야 Iterator를 얻을 수 있음.
	
	// ListIterator 와 Enumeration
	// Enumeration : Iterator의 구버전, 잘 사용 하지 않음. 되도록 Iterator 사용 할 것
	// ListIterator : Iterator를 상속 받아 기능을 추가 한 것. Iterator는 단방향 이동이지만 ListIterator는 양방향 이동 가능.
	//				  ArrayList나 LinkedList와 같이 List인터페이스를 구현한 컬렉션에서만 사용 가능.
}
