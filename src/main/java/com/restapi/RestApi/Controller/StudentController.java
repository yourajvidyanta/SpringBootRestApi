package com.restapi.RestApi.Controller;

import com.restapi.RestApi.Dto.StudentDto;
import com.restapi.RestApi.Entity.Student;
import com.restapi.RestApi.Reposetory.StudentRepo;
import com.restapi.RestApi.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

        private final StudentService studentService;

        @GetMapping("/student")
        public List<StudentDto> getStudent(){
        return studentService.getAllStudent();
        }


}
