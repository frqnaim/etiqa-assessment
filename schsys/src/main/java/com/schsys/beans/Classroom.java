/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schsys.beans;


/**
 *
 * @author Naim
 */
public class Classroom {
    private int classStuId;
    private String classStuName;
    private Integer classStuAge;
    private String classStuGender;
    private String classStuEmail;
    private String classModId;
    private String classModName;
    private String studentsStuId;
    private String modulesModId;

    public String getStudentsStuId() {
        return studentsStuId;
    }

    public void setStudentsStuId(String studentsStuId) {
        this.studentsStuId = studentsStuId;
    }

    public String getModulesModId() {
        return modulesModId;
    }

    public void setModulesModId(String modulesModId) {
        this.modulesModId = modulesModId;
    }

    public int getClassStuId() {
        return classStuId;
    }

    public void setClassStuId(int classStuId) {
        this.classStuId = classStuId;
    }

    public String getClassStuName() {
        return classStuName;
    }

    public void setClassStuName(String classStuName) {
        this.classStuName = classStuName;
    }
    
    public String getClassModName() {
        return classModName;
    }

    public void setClassModName(String classModName) {
        this.classModName = classModName;
    }
 
    public Integer getClassStuAge() {
        return classStuAge;
    }

    public void setClassStuAge(Integer classStuAge) {
        this.classStuAge = classStuAge;
    }

    public String getClassStuGender() {
        return classStuGender;
    }

    public void setClassStuGender(String classStuGender) {
        this.classStuGender = classStuGender;
    }

    public String getClassStuEmail() {
        return classStuEmail;
    }

    public void setClassStuEmail(String classStuEmail) {
        this.classStuEmail = classStuEmail;
    }
    
    public String getClassModId() {
        return classModId;
    }

    public void setClassModId(String classModId) {
        this.classModId = classModId;
    }
}
