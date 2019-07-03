package com.carrental.controller;

import com.carrental.domain.model.Department;
import com.carrental.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/create")
    public String createDepartmentForm(Model model) {
        model.addAttribute("department", new Department());
        return "department/form";
    }

    @PostMapping("/create")
    public String createDepartment(@ModelAttribute("department") Department department) {
        departmentService.createDepartment(department);
        log.info("Created new department {}", department);

        return "redirect:/department/list";
    }

    @GetMapping("/list")
    public String departmentList(Model model) {
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("departments", departments);
        return "department/list";
    }

    @GetMapping("/edit/{id}")
    public String editDepartmentForm(@PathVariable("id") Integer id, Model model) {
        Optional<Department> maybeDepartment = departmentService.getDepartmentById(id);

        if (maybeDepartment.isPresent()) {
            model.addAttribute("department", maybeDepartment.get());
            return "department/edit-form";
        } else {
            return "redirect:/department/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editDepartment(@ModelAttribute("department") Department department) {
        departmentService.editDepartment(department);

        return "redirect:/department/list";
    }

    @GetMapping("/delete")
    public String deleteDepartment(@RequestParam("id") Integer id) {
        departmentService.deleteById(id);
        return "redirect:/department/list";
    }
}
