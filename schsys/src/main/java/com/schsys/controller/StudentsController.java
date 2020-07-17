/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schsys.controller;

import com.schsys.beans.Classroom;
import com.schsys.beans.Modules;
import com.schsys.beans.Students;
import com.schsys.dao.ClassroomDAO;
import com.schsys.dao.ModulesDAO;
import com.schsys.dao.StudentsDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Naim
 */
@Controller
public class StudentsController {

    @Autowired
    StudentsDAO stdDao;

    @Autowired
    ClassroomDAO clsDao;

    @Autowired
    ModulesDAO modDao;

    /*Provide lists of students*/
    @RequestMapping("/viewstudents")
    public String viewStudents(Model model) {
        List<Students> stdList = stdDao.getStudents();
        model.addAttribute("stdList", stdList);
        return "viewstudents";
    }

    /*Provide lists of subjects*/
    @RequestMapping("/moduleslist")
    public String modulesList(Model model) {
        List<Modules> modList = modDao.getModules();
        model.addAttribute("modList", modList);
        return "moduleslist";
    }

    /*Provide subjects for the given id*/
    @RequestMapping(value = "/viewmodules/{stuId}")
    public String viewClassroom(@PathVariable int stuId, Model model) {
        List<Classroom> clsList = clsDao.getClassroomWithStudentsAndModules(stuId);
        model.addAttribute("clsList", clsList);
        model.addAttribute("stuId", stuId);
        return "viewmodules";
    }

    /*Display object data into form for the given Id*/
    @RequestMapping(value = "/editstd/{stuId}")
    public String edit(@PathVariable int stuId, Model model) {
        Students std = stdDao.getStudentsById(stuId);
//        Classroom cls  = clsDao.getDetailsById(stuId);
        model.addAttribute("command", std);
        return "editstd";
    }

    /*Update Object*/
    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("std") Students std) {
        stdDao.updateStudents(std);
        return "redirect:/viewstudents";
    }

    /*go to add modules to student page*/
    @RequestMapping("/moduleform/{classStuId}")
    public String addSubjectToStudent(@PathVariable int classStuId, Model model) {
        model.addAttribute("command", new Classroom());
        model.addAttribute("classStuId", classStuId);
        return "moduleform";
    }

    /*insert object into students has modules
        check for pre-existing modules*/
    @RequestMapping(value = "/savemoduletostudent/{classStuId}", method = RequestMethod.POST)
    public String saveModuleToStudent(@ModelAttribute("cls") Classroom cls) {
        List<Modules> listMod = modDao.checkIfModulesExist(cls.getClassModName());
        switch (listMod.size()) {
            case 1:
                clsDao.insertModulesByStudId(cls, listMod.get(0).getModId());
                return "redirect:/viewstudents";
            case 0:
                return "redirect:/error";
            default:
                return null;
        }
    }

    /*Display error page
        redirect to index*/
    @RequestMapping("/error")
    public String error(Model model) {
        return "error";
    }

    @RequestMapping("/studentform")
    public String showform(Model model) {
        model.addAttribute("command", new Students());
        return "studentform";
    }

    /*Add students*/
    @RequestMapping(value = "/savestudent", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("srd") Students std) {
        stdDao.saveStudents(std);
        return "redirect:/viewstudents";
    }

    /* It deletes record for the given id in URL and redirects to /viewstudents */
    @RequestMapping(value = "/deletestd/{stuId}", method = RequestMethod.GET)
    public String delete(@PathVariable int stuId) {
        clsDao.deleteClass(stuId);
        stdDao.deleteStudents(stuId);
        return "redirect:/viewstudents";
    }
}
