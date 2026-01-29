package com.restapi.RestApi.Service.Impl;

import com.restapi.RestApi.Dto.StudentDto;
import com.restapi.RestApi.Entity.Student;
import com.restapi.RestApi.Reposetory.StudentRepo;
import com.restapi.RestApi.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepo.findAll();

        List<StudentDto> studentDtoList = students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                ))
                .collect(Collectors.toList());

        return studentDtoList;
    }
}
