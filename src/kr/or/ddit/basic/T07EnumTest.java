package kr.or.ddit.basic;

// enum이 없을 때 사용하던 	방법
class Flower {
	static final int ROSE = 1; // 장미
	static final int TULIP = 2; // 튤립
}

class Animal {
	static final int LION = 1;
	static final int TIGER = 2;
}



public class T07EnumTest {

	/*
	 	열거형 => 상수값들을 선언하는 방법
	 	
	 	선언방법 : enum 열거형이름 {상수값1, 상수값2, ......, 상수값n}
	 	
	 */
	
	
	public enum HomeTown {광주, 부산, 평양, 제주도, 대구, 대전};
	
	
	// City 열거형 객체 선언 (기본값을 이용하는 열거형)
	// 상수 역할을 하는 객체들
	// ()안에 넣을 의미있는 정보들이 없다면 안써도 됨(생략가능)
	public enum City {서울, 부산, 대구, 광주(), 대전()};
	
	
	// 데이터값을 임의로 지정한 열거형 객체 선언
	// 데이터값을 정해줄 경우에는 생성자를 이용하여 제공해주면 된다.
	public enum Season {
		봄("3월부터 5월까지"), 여름("6월부터 8월까지"), 가을("9월부터 11월까지"), 겨울("12월부터 2월까지");
		
		// 괄호 안의 값이 저장될 변수 선언
		private String data;
		
		// 생성자 만들기 (열거형의 생성자는 제어자가 묵시적으로 'private'이다)
		private Season(String data) {
			this.data = data;
		}

		// getter 메서드
		public String getData() {
			return data;
		}
	}
	
	public static void main(String[] args) {
		
		int a = Animal.LION;
		
		// 비교값이 원하는 장미가 아니지만, 비교값이 같다고 출력되는 이유는
		// 해당 객체의 상수값이 동일한 1이기 때문
		// 이런 문제점을 해결하기 위해 나온 것이 enum
		if(a == Flower.ROSE) {
			System.out.println("이것은 장미입니다?");
		}
		System.out.println();
		
		
		
		
		
	/*
	 	열거형에서 사용하는 주요 메서드
	 	
	 	1. name() => 열거형 상수의 이름을 문자열로 반환한다.
	 	2. valueOf("열거형 상수이름") => '열거형 상수이름'과 일치하는 열거형 상수 객체를 반환한다.
	 	3. ordinal() => 열거형 상수가 정의된 순서값을 반환한다. (기본적으로 0부터 시작)
	 	
	 */
		
		City myCity1; // 열거형 객체변수 선언
		City myCity2; // 열거형 객체변수 선언
		
		// 열거형 상수의 이름을 문자열로 갖고 올 때
		myCity1 = City.서울;
		// 상수명을 알고 있고, 열거형 상수의 객체를 갖고올 때
		myCity2 = City.valueOf("서울");
		
		System.out.println("myCity1 : " + myCity1.name());
		System.out.println("myCity1의 ordinal : " + myCity1.ordinal());
		System.out.println();
		
		System.out.println("myCity2 : " + myCity2.name());
		System.out.println("myCity2의 ordinal : " + myCity2.ordinal());
		System.out.println();
		
		Season ss = Season.valueOf("여름");
		System.out.println("name => " + ss.name());
		System.out.println("ordinal => " + ss.ordinal());
		System.out.println("getter 메서드 호출 => " + ss.getData());
		System.out.println("----------------------------------");
		
		
		// 열거이름.values() => 열거형 배열값을 반환함.
		Season[] ssArr = Season.values();
		
		for (Season s : ssArr) {
			System.out.println(s.name() + " : " + s.ordinal() + " / " + s.getData());
		}
		System.out.println();
		
		for (City city : City.values()) {
			System.out.println(city.name() + " : " + city.ordinal());
		}
		
		
		System.out.println();
		
		
		City city = City.대구;
		
		System.out.println(city == City.대구);
		System.out.println(city == City.대전);
		
		// 서로 호환되지 않는 타입이라서 비교 자체가 불가능하기 때문에 오류가 뜸
//		System.out.println(city == HomeTown.대구);
		
		System.out.println();
		/////////////////////////////////
		
		// ordinal값으로 비교함
		// 두 열거형(enum) 상수를 비교해서 정수 값을 반환함
		// 결과값 : 대구 => 0, 서울 => 2, 대전 => -2
		// city가 '대구'이므로, 대구와 대구는 같은 위치이고,
		// 서울은 대구보다 2칸 앞 위치에 있고, 
		// 대전은 대구보다 2칸 뒤 위치에 있음.
		System.out.println("대구 => " + city.compareTo(City.대구));
		System.out.println("서울 => " + city.compareTo(City.서울));
		System.out.println("대전 => " + city.compareTo(City.대전));
		
	}
	
}
