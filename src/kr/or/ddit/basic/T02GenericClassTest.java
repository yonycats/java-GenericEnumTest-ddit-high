package kr.or.ddit.basic;

public class T02GenericClassTest {

/*
	 	제너릭 클래스 생성하는 방법
	 	
	 	class 클래스명<제너릭 타입 글자>
	 	
	 		제너릭타입글자 변수명; // 변수 선언에 제너릭 문자 사용할 경우
	 	 	...
	 		제너릭타입글자 메서드명() { // 반환값이 있는 메서드에서 사용되는 경우 
	 			...
	 		
	 			return 값;
	 		}
	 		...
	 	}
	 	
-- 제너릭 타입 글자 --
T => Type
K => Key
V => Value
E => Element (자료구조에 들어가는 원소들을 의미할 때 사용됨)	
*/
	public static void main(String[] args) {
		// Object 클래스를 사용하면 값을 가져올 때마다 별도의 캐스팅을 해줘야 함
		// Object 클래스에 값 넣기
		NonGenericClass ng1 = new NonGenericClass();
		NonGenericClass ng2 = new NonGenericClass();
		ng1.setVal("가나다라");
		ng2.setVal(100);
		
		// Object 클래스에서 값 가져오기
		String rtnVal1 = (String) ng1.getVal();
		Integer rtnVal2 = (Integer) ng2.getVal();
		System.out.println("문자열 반환값 rtnVal1 : " + rtnVal1);		
		System.out.println("문자열 반환값 rtnVal2 : " + rtnVal2);
		
		
		System.out.println("///////////////////////////");
		
		
		// Generic 클래스를 사용하면 처음 객체를 선언할 때를 제외하고 
		// 값을 넣거나 가져올 때, 별도의 캐스팅 작업이 필요없음
		// Generic 클래스에 값 넣기
		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		// Generic 클래스에서 값 가져오기
		rtnVal1 = mg1.getVal();
		rtnVal2 = mg2.getVal();
		System.out.println("제너릭 문자열 반환값 : " + rtnVal1);
		System.out.println("제너릭 정수형 반환값 : " + rtnVal2);
	}
	
}
	
	
class NonGenericClass {
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}


class MyGeneric<T> {
	private T val;
	
	public T getVal() {
		return val;
	}
	
	// 제너릭 클래스 안에 있는 일반 메서드
	// 제너릭 클래스 안에 있기 때문에 파라미터를 제너릭으로 받을 뿐임
	public void setVal(T val) {
		this.val = val;
	}
}