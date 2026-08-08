package com.sanket.Service;

import com.sanket.Repository.IStudentRepo;
import com.sanket.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class StudentServiceImpl implements IStudentService {

    private IStudentRepo studentRepo;
    @Autowired
    public StudentServiceImpl(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    @Override
    public String insertStudent(Student student) {

        Student student1 = studentRepo.save(student);
        return "Student infomation inserted successfully with ID number: "+student.getStudId();
    }
}
