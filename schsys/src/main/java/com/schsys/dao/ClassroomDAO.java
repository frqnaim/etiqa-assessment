/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schsys.dao;

import com.schsys.beans.Classroom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Naim
 */
public class ClassroomDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public List<Classroom> getClassroomWithStudentsAndModules(int stu_id) {
        String query = "SELECT a.stu_id, a.stu_name, GROUP_CONCAT(c.mod_name) FROM students a\n"
                    + "JOIN students_has_modules b ON a.stu_id = b.students_stu_id\n"
                    + "JOIN modules c on b.modules_mod_id = c.mod_id\n"
                    + "WHERE a.stu_id = '" + stu_id + "'" ;
        return template.query(query, new RowMapper<Classroom>() {
            public Classroom mapRow(ResultSet rs, int row) throws SQLException {
                Classroom cls = new Classroom();
                cls.setClassStuId(rs.getInt(1));
                cls.setClassStuName(rs.getString(2));
                cls.setClassModName(rs.getString(3));
                return cls;
            }
        });
    }

    public Classroom getDetailsById(int stu_id) {
        System.out.println("ID >>>>>>>>> " + stu_id);
        String query = "SELECT a.stu_id, a.stu_name, a.stu_age, a.stu_gender, a.stu_email, GROUP_CONCAT(c.mod_id), GROUP_CONCAT(c.mod_name) FROM students a\n"
                + "JOIN students_has_modules b ON a.stu_id = b.students_stu_id\n"
                + "JOIN modules c ON b.modules_mod_id = c.mod_id\n"
                + "WHERE a.stu_id =?";
        return template.queryForObject(query, new Object[]{stu_id}, new RowMapper<Classroom>(){
            public Classroom mapRow(ResultSet rs, int row) throws SQLException {
                Classroom cls = new Classroom();
                cls.setClassStuId(rs.getInt(1));
                cls.setClassStuName(rs.getString(2));
                cls.setClassStuAge(rs.getInt(3));
                cls.setClassStuGender(rs.getString(4));
                cls.setClassStuEmail(rs.getString(5));
                cls.setClassModId(rs.getString(6));
                cls.setClassModName(rs.getString(7));
                return cls;
            } 
        });
    }
    
    public int update (Classroom cls){
        String updateStudents = "UPDATE students SET stu_name = '" + cls.getClassStuName() 
                + "', stu_age = " + cls.getClassStuAge()
                + "', stu_gender = '" + cls.getClassStuGender()
                + "', stu_email = '" + cls.getClassStuEmail()
                + "' WHERE stu_id = " + cls.getClassStuId();
        
        String updateModules = "UPDATE modules SET mod_name = '" + cls.getClassModName()
                + "' WHERE mod_id = " + cls.getClassModId();
        return 0;
    }
    
    public int insertModulesByStudId (Classroom cls, int mod) {
        String insertSQL = "INSERT INTO students_has_modules (students_stu_id, modules_mod_id) " 
                + " VALUES ('"+ cls.getClassStuId() + "', '" + mod + "');";
        return template.update(insertSQL);
    }
    
    public int deleteClass(int stdId) {
        String delSQL = "DELETE FROM students_has_modules where students_stu_id = " + stdId + "";
        return template.update(delSQL);
    }
}
