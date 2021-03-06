package java_basic3;

public class LinkedList {
	// LinkedList
	// 배열은 가장 기본적인 형태의 자료구조
	// 구조가 간단하며 사용하기 쉽고 데이터를 읽어오는데 걸리는 시간이 가장 빠르다는 장점을 가지고 있음.
	// 단점 :
	// 1. 크기를 변경할 수 없음 : 크기변경 할 수 없어 새로운 배열을 생성해 데이터 복사하여야 함.
	// 실행속도 향상을 위해 큰 배열 생성을 해야하는데 메모리 낭비가 됨.
	// 2. 비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸림.
	// 차례대로 데이터를 추가하고 마지막에서부터 데이터를 삭제하는 것은 빠르지만,
	// 배열의 중간에 데이터를 추가하려면, 빈자리를 만들기 위해 다른 데이터들을 복사해서 이동 해야 함.
	// 이러한 단점들을 보완하기 위해 링크드 리스크(Linked list)라는 자료구조가 고안 됨.

	// Linked list : 불연속적으로 존재하는 데이터를 서로 연결한 형태로 구성
	// Linked list는 이동방향이 단방향이기 때문에 다음 요소에 대한 접근은 쉽지만 이전요소에 대한 접근은 어려움.
	// 이 점을 보완하기위해 더블 링크드 리스트(이중 연결리스트, doubly linked list)를 사용.

	// Doubly linked list : 단순히 링크드 리스테에 참조변수를 하나 더 추가하여 다음요소에 대한 참조뿐 아니라 이전 요소에 대한
	// 참조도 가능하도록 함.

	// 더블 링크드 리스트의 접근성을 보다 향상시킨 것이 더블 써큘러 링크드 리스트(이중 원형 연결리스트, Doubly circular
	// linked list)임.
	// Doubly circular linked list : 마지막요소의 다음요소가 첫 번째 요소가되고, 첫번째 요소의 이전요소는 마지막 요소가
	// 됨.

	// 결론1. 순차적으로 추가/삭제하는 경우에는 ArrayList가 LinkedList보다 빠름.
	// 결론2. 중간 데이터를 추가/삭제하는 경우에는 LinkedList가 ArrayList보다 빠름.

	// 컬렉션 읽기(접근시간) 추가/삭제 비고
	// ArrayList 빠르다 느리다 순차적인 추가삭제는 더 빠름. 비효율적인 메모리 사용.
	// LinkedList 느리다 빠르다 데이터가 많을수록 접근성이 떨어짐.
}
