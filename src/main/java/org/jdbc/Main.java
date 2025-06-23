package org.jdbc;

import org.jdbc.model.Task;
import org.jdbc.model.TaskPriority;
import org.jdbc.model.TaskStatus;
import org.jdbc.repository.Repository;
import org.jdbc.repository.TaskRepositoryImpl;
import org.jdbc.util.DatabaseConn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConn.getInstance()){
            Repository<Task> t = new TaskRepositoryImpl();
            System.out.println("PRINT LIST +++++>");
            t.show().forEach(System.out::println);

            System.out.println("PRINT TASK BY ID +++++>");
            Task tId = t.forId(2L);
            System.out.println("tId = " + tId);

            System.out.println("CREATED TASK +++++>");
            Task task = new Task();
            task.setId(6L);
            task.setName("COMPLETAR EL CRUD");
            task.setStatus(TaskStatus.COMPLETED);
            task.setDue_date(Date.valueOf("2025-10-1"));
            task.setPriority(TaskPriority.HIGH);
            t.save(task);
            System.out.println("TASK #6 EDIT");
            //System.out.println("CREATED TASK COMPLETED");
            t.show().forEach(System.out::println);

            System.out.println("DELETED TASK +++++>");
            //t.delete(4L);
            //System.out.println("DELETE TASK #4");
            //t.show().forEach(System.out::println);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}