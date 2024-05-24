package homework;

import java.math.BigDecimal;
import java.util.Scanner;

public class Homework04_0524_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sel;

		Planet myPlanet;

		System.out.println("1. 원하는 행성의 면적 보기, 2. 모든 행성의 면적 보기");
		sel = sc.nextLine();

		if (sel.equals("1")) {
			System.out.println("원하는 행성의 이름을 입력하세요.");
			System.out.println("수성, 금성, 지구, 화성, 목성, 토성, 천왕성, 해왕성");
			sel = sc.nextLine();

			myPlanet = Planet.valueOf(sel);
			System.out.println(myPlanet);
			System.out.print(myPlanet.name() + "의 반지름 : " + myPlanet.getData() + "\t");
			System.out.println(myPlanet + "의 표면적 : " + BigDecimal.valueOf(sphereArea(myPlanet.getData())));

		} else if (sel.equals("2")) {
			Planet[] myPlanetAll = Planet.values();

			for (Planet p : myPlanetAll) {
				System.out.print(p.name() + "의 반지름 : " + p.getData() + "\t");
				System.out.println(p.name() + "의 표면적 : " + BigDecimal.valueOf(sphereArea(p.getData())));
			}
		}
	}

	public static double sphereArea(double radius) {
		return radius * radius * Math.PI;
	}
}

enum Planet {
	수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

	private double data;

	private Planet(int data) {
		this.data = data;
	}
	public double getData() {
		return data;
	}
}