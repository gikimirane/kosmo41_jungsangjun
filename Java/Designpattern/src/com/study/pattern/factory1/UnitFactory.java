package com.study.pattern.factory1;

enum UnityType {
	Marine,
	Firebat,
	Medic,
}
public class UnitFactory {
	
	public static Unit createUnit(UnityType type) {
		Unit unit = null;
		
		switch(type) {
		
		
		
		
		case Marine:
		unit = new Marine();
		break;
		case Firebat:
		unit = new Firebat();
		break;
		
	
		
		}
		
		
		
		
		return unit;
		
	}

}
