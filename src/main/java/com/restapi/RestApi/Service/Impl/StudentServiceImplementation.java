package com.restapi.RestApi.Service.Impl;

import com.restapi.RestApi.Dto.StudentDto;
import com.restapi.RestApi.Entity.Student;
import com.restapi.RestApi.Reposetory.StudentRepo;
import com.restapi.RestApi.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepo.findAll();

        List<StudentDto> studentDtoList = students.stream()
                .map(student -> modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());

        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id) {
         Student student= studentRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Student Not Found With id"));
         return modelMapper.map(student,StudentDto.class);
    }
}
