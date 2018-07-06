package com.study.pattern.factory1;

class Marine implements Unit {
	
	public Marine() {
		System.out.println("마린 생성!!!");
	}

	@Override
	public void move() 
	{
		System.out.println("마린 이동!!!");

	}

}
