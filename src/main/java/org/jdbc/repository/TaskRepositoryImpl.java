package org.jdbc.repository;

import org.jdbc.model.Task;
import org.jdbc.model.TaskPriority;
import org.jdbc.model.TaskStatus;
import org.jdbc.util.DatabaseConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements Repository<Task> {

    private Connection getConnection() throws SQLException {
        return DatabaseConn.getInstance();
    }

    // New List
    @Override
    public List<Task> show() {
        List<Task> l = new ArrayList<>();
        // Auto Close impl
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM taskcrud_6_25")) {
            while (rs.next()) {
                Task t = getTask(rs);
                l.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return l;
    }

    @Override
    public Task forId(Long id) {
        Task t = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM taskcrud_6_25 WHERE id=?")) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) t = getTask(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return t;
    }

    @Override
    public void save(Task task) {
        String sql;

        if(task.getId() > 0) {
            sql = "UPDATE taskcrud_6_25 SET name=?, status=?, due_date=?, priority=? WHERE id=?";
        } else {
            sql = "INSERT INTO taskcrud_6_25(name, status, due_date, priority) VALUES(?,?,?,?)";
        }

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getStatus().name());
            stmt.setDate(3, task.getDue_date());
            stmt.setString(4, task.getPriority().name());

            if(task.getId() > 0) {
                stmt.setLong(5, task.getId());
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM taskcrud_6_25 WHERE id=?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Task getTask(ResultSet rs) throws SQLException {
        Task t = new Task();
        t.setId(rs.getLong("id"));
        t.setName(rs.getString("name"));
        t.setRegister_date(rs.getDate("register_date"));
        t.setStatus(TaskStatus.valueOf(rs.getString("status")));
        t.setDue_date(rs.getDate("due_date"));
        t.setPriority(TaskPriority.valueOf(rs.getString("priority")));

        return t;
    }
}
