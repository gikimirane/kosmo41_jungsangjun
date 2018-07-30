package com.study.pattern04.factory_method2;

public class DatabaseFactoryUse extends DatabaseFactory {
	
	public DBType dbType = DBType.Oracle;
	
	
	@Override
	public Database setDatabase() {
		// 회사 사정에 의해 어떤 데이터베이스를 다시 사용할 지 모른다.
		// 그래서 구축한 정보를 지우지 않고 재사용시를 대비한다.
		if(dbType == DBType.MySQL)
		{
			System.out.println("MySQL USE...");
			return new MySQL();
		}
		else if 
		
		
		
		
		
		return null;
	}
	
	
	
	

}
