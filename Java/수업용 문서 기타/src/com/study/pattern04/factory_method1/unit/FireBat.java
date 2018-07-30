package com.study.pattern04.factory_method1.unit;



public class FireBat extends Unit {

	
	
	public FireBat() {
		type = com.study.pattern04.factory_method1.unit.FireBat;
		name = "FireBat";
		hp = 80;
		exp 60;
		
		System.out.println(this.name+ "생성!!!");
	}
	@Override
	public void attack() {
		System.out.println(this.name+ "공격!!!");
	}

	
}