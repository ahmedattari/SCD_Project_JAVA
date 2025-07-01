package core;

import java.sql.*;

public abstract class BaseModel {
    protected final Connection conn;

    public BaseModel() {
        this.conn = Database.getConnection();
    }

    protected ResultSet executeQuery(String sql, Object... params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql);
        setParams(stmt, params);
        return stmt.executeQuery();
    }

    protected int executeUpdate(String sql, Object... params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql);
        setParams(stmt, params);
        return stmt.executeUpdate();
    }

    private void setParams(PreparedStatement stmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
    }
}
