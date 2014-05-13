package sonstiges;
import java.sql.*;

public class DBMySQL {

	Connection con;
	Statement stat;

	public DBMySQL() throws Exception {

		// MySQL-Treiber einbinden
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		// Neue Connection aufbauen
		this.con = DriverManager.getConnection("jdbc:mysql://wp266.webpack.hosteurope.de:3306/db10619302-uni", "db10619302-uni", "oo57RYFsguPpa-YM");

		// Statement-Objekt erstellen f�r Querys
		this.stat = this.con.createStatement();
		
	}

	public ResultSet exec(String sql) throws Exception {
		// �bergebenen Select/Update-SQL-Statement ausf�hren und Result(Set) zur�ckgeben
		return this.stat.executeQuery(sql);
	}
	
	public ResultSet insert(String sql) throws Exception {
		// �bergebenen Insert-SQL-Statement ausf�hren und Generierte Keys (rs.getInt(1)) zur�ckgeben
		this.stat.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		return this.stat.getGeneratedKeys();
	}

	public void disconnect() throws Exception {
		// Verbindung trennen
		con.close();
	}
}
