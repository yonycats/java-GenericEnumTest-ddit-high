package kr.or.ddit.basic;

/**
 
 	제한된 타입파라미터 예제
 
 */


public class T04BoundedParameterTest {
	 public static void main(String[] args) {
		// 뒤의 숫자가 더 크기 때문에 리턴값은 -1 
		int result = Util2.compare(10, 20);
		System.out.println(result);
		
		// 앞의 숫자가 더 크기 때문에 리턴값은 1
		result = Util2.compare(3.14, 3);
		System.out.println(result);
		
		// 받을 수 있는 타입을 Number를 상속받아 숫자 타입으로
		// 제한을 걸었기 때문에, String 타입의 글자를 받을 수 없다
//		result = Util2.compare("JAVA", 3);
	}
}


class Util2 {
	// 숫자 타입만 받을 수 있도록 타입을 제한하기 위해 Number롤 상속받음
	public static <T extends Number> int compare(T t1, T t2) {
		
		// 각 숫자 타입마다 비교 방식이 다르기 때문에
		// doubleValue() 메서드를 사용하여 전달받은 숫자 타입 객체를 모두 double 타입으로 변환
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		// 변환된 double 값을 사용하여 Double.compare(v1, v2) 메서드로 비교할 수 있다
		
		// 이와 같은 방식으로 compare 메서드를 제네릭하게 구현하면
		// 다양한 숫자 타입의 객체를 비교할 수 있으며, 사용자는 Integer, Double, BigDecimal 등 
		// 원하는 숫자 타입의 객체를 전달할 수 있고, 메서드는 이를 자동으로 처리할 수 있다
		return Double.compare(v1, v2);
	}
}