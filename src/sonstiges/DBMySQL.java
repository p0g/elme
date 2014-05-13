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

		// Statement-Objekt erstellen für Querys
		this.stat = this.con.createStatement();
		
	}

	public ResultSet exec(String sql) throws Exception {
		// Übergebenen Select/Update-SQL-Statement ausführen und Result(Set) zurückgeben
		return this.stat.executeQuery(sql);
	}
	
	public ResultSet insert(String sql) throws Exception {
		// Übergebenen Insert-SQL-Statement ausführen und Generierte Keys (rs.getInt(1)) zurückgeben
		this.stat.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		return this.stat.getGeneratedKeys();
	}

	public void disconnect() throws Exception {
		// Verbindung trennen
		con.close();
	}
}
