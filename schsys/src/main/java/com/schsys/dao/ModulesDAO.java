/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schsys.dao;

import com.schsys.beans.Modules;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Naim
 */
public class ModulesDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public List<Modules> getModules(){
        return template.query("SELECT * FROM modules", new RowMapper<Modules>(){
            public Modules mapRow(ResultSet rs, int row) throws SQLException {
                Modules mod = new Modules();
                mod.setModId(rs.getInt(1));
                mod.setModName(rs.getString(2));
                return mod;
            } 
        });
    }
    
    public List<Modules> checkIfModulesExist(String modName) {
        String searchModules = "SELECT * FROM modules WHERE mod_name LIKE '%" + modName + "%';";
        return template.query(searchModules, new RowMapper<Modules>(){
            public Modules mapRow(ResultSet rs, int row) throws SQLException {
                Modules mod = new Modules();
                mod.setModId(rs.getInt(1));
                mod.setModName(rs.getString(2));
                return mod;
            }
        });
    }
}
