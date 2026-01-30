package com.restapi.RestApi.Controller;

import com.restapi.RestApi.Dto.StudentDto;
import com.restapi.RestApi.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

        private final StudentService studentService;

        @GetMapping("/students")
        public List<StudentDto> getStudent() {
                return studentService.getAllStudent();
        }

        @GetMapping("/get")
        public StudentDto getStaticData() {
                return new StudentDto(1, "Riya", "singhriya34@gmail.com");
        }

        @GetMapping("students/{id}")
        public StudentDto getStudentById(@PathVariable Long id) {
                return studentService.getStudentById(id);
        }


}
