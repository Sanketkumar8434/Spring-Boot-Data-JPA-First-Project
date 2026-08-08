package com.sanket;

import com.sanket.Service.IStudentService;
import com.sanket.Service.StudentServiceImpl;
import com.sanket.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentRunner implements ApplicationRunner {

    private IStudentService studentService;
    @Autowired
    public StudentRunner(IStudentService studentService) {
        this.studentService = studentService;
    }
    Student student = new Student();
    @Override
    public void run(ApplicationArguments args) throws Exception {


        student.setStudName("Sandarv Kumar");
        student.setStudAddrs("Kolkata");
        String message = studentService.insertStudent(student);
        System.out.println(message);
    }
}
