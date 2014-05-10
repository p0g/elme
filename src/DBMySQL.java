import java.sql.*;

public class DBMySQL{
	
	Connection con;
	Statement stat;	
	
	public DBMySQL() throws Exception{
		
		// MySQL-Treiber einbinden
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		// Neue Connection aufbauen
		this.con = DriverManager.getConnection ("jdbc:mysql:///urladress","user","pswd");
		
		// Statement-Objekt erstellen f�r Querys
		this.stat = this.con.createStatement();
	}
	
	public ResultSet exec(String sql) throws Exception{
		// �bergebenen SQL-Statement ausf�hren und Result(Set) zur�ckgeben
		return this.stat.executeQuery(sql);
	}
	
	public void disconnect() throws Exception{
		// Verbindung trennen
		con.close();
	}
} 
