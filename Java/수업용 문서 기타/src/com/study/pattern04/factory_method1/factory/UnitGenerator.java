package com.study.pattern04.factory_method1.factory;

import java.util.ArrayList;

import com.study.pattern04.factory_method1.unit.Unit;

///
/// 추상클래스
///

public abstract class UnitGenerator {
	public List<Unit> units = new ArrayList<>(Unit);
	
	//
	public List<Unit> getUnits();
	
	{
		return units;
	}
}
	public abstract void createUnits();
	{
	
	
	}
	
	
	
	
	