package com.restapi.RestApi.Controller;

import com.restapi.RestApi.Dto.AddStudentRequestDto;
import com.restapi.RestApi.Dto.StudentDto;
import com.restapi.RestApi.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

        private final StudentService studentService;

        @GetMapping("/students")
        public ResponseEntity<List<StudentDto>> getStudent() {
                return ResponseEntity.ok(studentService.getAllStudent());
        }

        @GetMapping("/get")
        public StudentDto getStaticData() {
                return new StudentDto(1, "Riya", "singhriya34@gmail.com");
        }

        @GetMapping("students/{id}")
        public  ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
                return ResponseEntity.ok(studentService.getStudentById(id));
        }

        @PostMapping("/students")
        public ResponseEntity<StudentDto>createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
                return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(addStudentRequestDto));
        }

        @DeleteMapping("students/{id}")
        public ResponseEntity<StudentDto>deleteStudent(@PathVariable Long id){
                studentService.deleteStudentById(id);
                return  ResponseEntity.noContent().build();
        }

        @PutMapping("/students/{id}")
        public ResponseEntity<StudentDto> updateStudent(
                @PathVariable Long id,
                @RequestBody AddStudentRequestDto addStudentRequestDto) {

                StudentDto updatedStudent = studentService.updateStudent(id, addStudentRequestDto);
                return ResponseEntity.ok(updatedStudent);
        }
}
