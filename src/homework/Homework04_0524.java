package homework;

import java.math.BigDecimal;

public class Homework04_0524 {
	public static void main(String[] args) {
		Planets[] planetAll = Planets.values();

		for (Planets p : planetAll) {
			System.out.print(p.name() + "의 반지름 : " + p.getData() + "\t");
			System.out.println(p.name() + "의 표면적 : " + BigDecimal.valueOf(sphereArea(p.getData())));
		}
	}

	public static double sphereArea(double radius) {
		return radius * radius * Math.PI;
	}
}

enum Planets {
	수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

	private double data;

	private Planets(int data) {
		this.data = data;
	}
	public double getData() {
		return data;
	}
}