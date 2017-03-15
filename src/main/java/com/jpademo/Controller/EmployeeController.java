package com.jpademo.Controller;

import com.jpademo.Entities.Department;
import com.jpademo.Entities.Employee;
import com.jpademo.Service.DepartmentService;
import com.jpademo.Service.EmailDetail;
import com.jpademo.Service.EmailService;
import com.jpademo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ritesh on 17-10-2016.
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public boolean home()  {

        List<String> attachments = new ArrayList<>();

        EmailDetail emailDetail = new EmailDetail();
        emailDetail.setToAddress("mmritesh1@gmail.com");
        emailDetail.setBody("Test Email");
        emailDetail.setSubject("Test Email");

        attachments.add("c:/temp.pdf");
        emailDetail.setFileAttachment(attachments);

            return emailService.sendEmail(emailDetail);

    }

    @RequestMapping(value = "/getEmployees",method = RequestMethod.GET)
    public List<Employee> details(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/createEmployee",method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @RequestMapping(value = "/createDept",method = RequestMethod.POST)
    public Department create(@RequestBody Department dept){
        departmentService.save(dept);
        return dept;
    }

    @RequestMapping(value = "/getDepts",method = RequestMethod.GET)
    public List<Department> getDept(){
        return departmentService.findAll();
    }


    /*@RequestMapping(value = "/UpdateDept",method = RequestMethod.PUT)
    public int update(@RequestBody Department dept) {
        return departmentService.update(dept.getId(),dept.getDeptName());
    }*/
}
