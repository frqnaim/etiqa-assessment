/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schsys.dao;

import com.schsys.beans.Students;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Naim
 */
public class StudentsDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public List<Students> getStudents(){
        return template.query("SELECT * FROM students", new RowMapper<Students>(){
            public Students mapRow(ResultSet rs, int row) throws SQLException {
                Students std = new Students();
                std.setStuId(rs.getInt(1));
                std.setStuName(rs.getString(2));
                std.setStuAge(rs.getInt(3));
                std.setStuGender(rs.getString(4));
                std.setStuEmail(rs.getString(5));    
                return std;
            }
        });
    }
    
    public Students getStudentsById(int stu_id) {
        String query = "SELECT a.stu_id, a.stu_name, a.stu_age, a.stu_gender, a.stu_email FROM students a WHERE stu_id=?";
        System.out.println(query + " >> ID >> " + stu_id);
        return template.queryForObject(query, new Object[]{stu_id}, new BeanPropertyRowMapper<>(Students.class));
    }
    
    public int updateStudents (Students std) {
        String updateStudentsSQL = "UPDATE students SET stu_name = '" + std.getStuName() 
                + "', stu_age = " + std.getStuAge()
                + ", stu_gender = '" + std.getStuGender()
                + "', stu_email = '" + std.getStuEmail()
                + "' WHERE stu_id = " + std.getStuId();
        return template.update(updateStudentsSQL); 
    }
    
    public int saveStudents (Students std) {
        String insSQL = "INSERT INTO students (stu_name, stu_age, stu_gender, stu_email) " 
                + " VALUES ('" + std.getStuName() + "', " + std.getStuAge() + ", '" + std.getStuGender() + "', '" + std.getStuEmail() + "');";
        return template.update(insSQL);
    }
    
    public int deleteStudents (int stdId) {
        String delSQL = "DELETE FROM students WHERE stu_id = " + stdId + ""; 
        return template.update(delSQL);
    }
}
