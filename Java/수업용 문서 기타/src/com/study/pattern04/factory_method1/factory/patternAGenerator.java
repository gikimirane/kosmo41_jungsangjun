package com.study.pattern04.factory_method1.factory;

public class patternAGenerator extends UnitGenerator{
	
	@Override
	public void createUnits();
	
	units.add(new Marine());
	units.add(new Marine());
	units.add(new Marine());
	units.add(new Marine());
	units.add(new Marine());
	units.add(new Marine());
	

}
