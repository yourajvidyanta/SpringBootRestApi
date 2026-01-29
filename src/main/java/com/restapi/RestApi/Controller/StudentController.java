package com.restapi.RestApi.Controller;

import com.restapi.RestApi.Entity.Student;
import com.restapi.RestApi.Reposetory.StudentRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

        private final StudentRepo studentRepo;
        public StudentController(StudentRepo studentRepo) {
                this.studentRepo = studentRepo;
        }

        @GetMapping("/student")
        public List<Student> getStudent(){
        return studentRepo.findAll();
        }


}
