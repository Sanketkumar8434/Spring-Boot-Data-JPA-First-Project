package com.sanket.Repository;

import com.sanket.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepo extends CrudRepository<Student, Integer> {

}
