package com.restapi.RestApi.Service;
import com.restapi.RestApi.Dto.AddStudentRequestDto;
import com.restapi.RestApi.Dto.StudentDto;
import java.util.List;


public interface StudentService {

    List<StudentDto>getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);
}
