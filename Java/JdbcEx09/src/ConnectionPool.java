import java.sql.*; 
import java.util.*;
public final class ConnectionPool{ 

	static { 
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		} catch (ClassNotFoundException cnfe) { 
			cnfe.printStackTrace(); 
		} 
	}
	
	// ������� ���� Ŀ�ؼ� ��, �ʱ� Ŀ�ؼ��� �����ϴ� ���� 
	private ArrayList<Connection> free; 

	// ��� ���� Ŀ�ؼ��� �����ϴ� ���� 
	private ArrayList<Connection> used; 

	private String url; 
	private String user; 
	private String password; 

	// �ʱ� Ŀ�ؼǼ� 
	private int initialCons = 0; 

	// �ִ� Ŀ�ؼǼ� 
	private int maxCons = 0; 

	// �� Ŀ�ؼǼ� 
	private int numCons = 0; 
	private static ConnectionPool cp; 

	// ����
	public static ConnectionPool getInstance (
			String url, 
			String user,
			String password, 
			int initialCons, int maxCons )
	{ 
		try { 
			if (cp == null) { 
				synchronized(ConnectionPool.class) { 
					cp = new ConnectionPool(
							   url, user, password, initialCons, maxCons); 
				} 
			} 
		} 
		catch (SQLException sqle) { 
			sqle.printStackTrace(); 
		} 
		return cp; 
	} 

	private ConnectionPool(String url,
			               String user, 
			               String password,
			               int initialCons,
			               int maxCons) 
	throws SQLException
	{ 
		this.url = url; 
		this.user = user; 
		this.password = password; 
		this.initialCons = initialCons; 
		this.maxCons = maxCons; 

		if (initialCons < 0) 
			initialCons = 5; 
		if (maxCons < 0) 
			maxCons = 10; 

 		// �ʱ� Ŀ�ؼ� ������ ������ ArrayList�� ������ �� 
 		// �ֵ��� �ʱ� Ŀ�ؼ� ����ŭ ArrayList�� �����Ѵ�. 
		free = new ArrayList<Connection>(initialCons); 
		used = new ArrayList<Connection>(initialCons); 

		// initialCons ����ŭ Connection�� ����(free)�Ѵ�. 
		while (numCons < initialCons) {
			addConnection(); 
		} 
	} 
	
	// free�� Ŀ�ؼ� ��ü�� �����Ѵ�. 
	private void addConnection() throws SQLException 
	{ 
		free.add(getNewConnection()); 
	} 

	// ���ο� Ŀ�ؼ� ��ü�� �����Ѵ�. 
	private Connection getNewConnection() throws SQLException
	{ 
		Connection con = null; 
		try { 
			con = DriverManager.getConnection(url, user, password); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		System.out.println("connect to " + con); 
		//���ؼ� ������ ������ ���ڰ� �����Ѵ�. 
		++numCons; 
		return con; 
	} 

 	// free�� �ִ� Ŀ�ؼ��� used�� �ű�� �۾� => free-->used 
	public synchronized Connection getConnection() throws SQLException
	{ 
 		// free�� Connection�� ������ 
 		// maxCons��ŭ Connection�� �� �����Ѵ�. 
		if (free.isEmpty()) {
			while (numCons < maxCons) { 
				addConnection(); 
			} 
		} 
		Connection _con; 
		_con = free.get(free.size()-1); 
		free.remove(_con); 
		used.add(_con); 
		return _con; 
	} 
	
 	// used�� �ִ� Ŀ�ؼ��� free�� �ݳ��Ѵ�. 
	public synchronized void releaseConnection(Connection _con) 
					throws SQLException 
	{ 
		boolean flag = false; 
		if (used.contains(_con)){ 
			used.remove(_con); 
			numCons--; 
			flag = true; 
		} else { 
			throw new SQLException("ConnectionPool �� �����ʳ׿�!!"); 
		} 
		try { 
			if (flag) { 
				free.add(_con); 
				numCons++; 
			} else { 
				_con.close(); 
			} 
		} catch (SQLException e) {
			try { 
				_con.close(); 
			} catch (SQLException e2) { 
				e2.printStackTrace(); 
			} 
		} 
	} 
	
	// ��� Connection �ڿ��� �ݳ��Ѵ�. 
	public void closeAll(){ 
		// used�� �ִ� Ŀ�ؼ��� ��� �����Ѵ�. 
		for (int i=0; i<used.size(); i++) { 
			Connection _con = (Connection)used.get(i); 
			used.remove(i--); 
			try { 
				_con.close(); 
			} catch(SQLException sqle) { 
				sqle.printStackTrace(); 
			} 
		} 

		// free�� �ִ� Ŀ�ؼ��� ��� �����Ѵ�. 
		for (int i=0; i<free.size(); i++) { 
			Connection _con = (Connection)free.get(i); 
			free.remove(i--); 
			try { 
				_con.close(); 
			} catch(SQLException sqle) { 
				sqle.printStackTrace(); 
			} 
		} 
	} 
	
	public int getMaxCons(){ 
		return maxCons; 
	} 
	public int getNumCons(){
		return numCons; 
	} 
}
