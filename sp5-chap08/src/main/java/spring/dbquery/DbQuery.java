package spring.dbquery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class DbQuery {

	private DataSource dataSource;

	public DbQuery(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int count() {
		Connection conn = null;
		try {
			/* DataSource에서 커넥션을 구하는데, 이 때 커넥션을 가져옴
			 * 이 시점에서 커넥션 conn은 활성 상태
			 */
			conn = dataSource.getConnection();
			try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) from MEMBER")) {
				rs.next();
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			/* 커넥션 사용이 끝나고 커넥션을 종료하면 실제 커넥션을 끊지 않고 풀에 반환
			 * 풀에 반환된 커넥션은 다시 유휴 상태가 됨
			 */
			if (conn != null) {
				try {
					conn.close(); // 풀에 반환
				} catch (SQLException e) {
				}
			}
		}
	}
}
