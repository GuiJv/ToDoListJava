/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import database.databaseConection;
import models.TaskModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Guilherme J. Vinhas
 */
public class TaskRepository {
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
    
    public void removeTask(int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (Connection conn = databaseConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, taskId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateTask(int taskId, TaskModel task) {
    String sql = "UPDATE tasks SET task = ?, task_type = ?, done = ? WHERE id = ?";

    try (Connection conn = databaseConection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, task.getTaskName());
        stmt.setString(2, task.getTaskType());
        stmt.setBoolean(3, task.isDone());
        stmt.setInt(4, taskId);

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("No task found with ID: " + taskId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
