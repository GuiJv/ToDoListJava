/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskDAO;

import database.databaseConection;
import models.TaskModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Guilherme J. Vinhas
 */
public class TaskDAO {
        public void addTask(TaskModel task) {
        String sql = "INSERT INTO tasks (task, task_type, done) VALUES (?, ?, ?)";
        System.out.println(task.toString());
        try (Connection conn = databaseConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, task.getTaskName());
            stmt.setString(2, task.getTaskType());
            stmt.setBoolean(3, task.isDone());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TaskModel> listTasks() {
        List<TaskModel> list = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Connection conn = databaseConection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TaskModel task = new TaskModel(
                    rs.getInt("id"),
                    rs.getString("task"),
                    rs.getString("task_type"),
                    rs.getBoolean("done")
                );
                list.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
