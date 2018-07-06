package com.study.pattern.factory1;

class Firebat implements Unit 
{
	Firebat() 
	{
		System.out.println("파이어뱃 생성!!!");
	}

	@Override
	public void move() 
	{
		System.out.println("파이어뱃 이동!!!");

	}
}
	

	