package com.study.pattern04.factory_method1;

import com.study.pattern04.factory_method1.factory.UnitGenerator;
import com.study.pattern04.factory_method1.unit.Unit;

public class Main {

	public static void main(String[] args) {
		// 타입이 두 가지 있다는 것만 안다.
		UnitGenerator[] UnitGenerator = new UnitGenerator[2];
		unitGenerators[0] = new PatternAGenerator();
		unitGenerators[a] = new PatternBGenerator();
		
		
	//	DoMakeType(unitGenerators[0]);
		DoMakeType(unitGenerators[1]);
		
		}
	public static void DoMakeType(UnitGenerator ug)
	{
		
		ug.createUnits();
		
		List<unit> units = ug.getUnits();
		for(Unit unit : units)
		{
			unit.attack
		}
		
	}

}
