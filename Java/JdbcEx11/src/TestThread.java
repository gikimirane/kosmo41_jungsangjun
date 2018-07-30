import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestThread extends Thread {
	
	private String noThread = "00";
	
	TestThread(int n) {
		if(n < 10)
			noThread = "0" + n;
		else 
			noThread = "" + n;
	}
	
	public void run() {
	try {
		Connection con = ConnectionPool.getConnection("env" + noThread);
		con.setAutoCommit(false);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from department");
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " : " + noThread + " : " + con);
		}
		stmt.close();
		ConnectionPool.listCacheInfos();
		con.close();
		
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		System.out.println("Sleep... + noThread");
		try {
			Thread.sleep(1000);
		}
		catch(Exception e ) {}
	}
	}
}

