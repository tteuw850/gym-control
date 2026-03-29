package com.mateus.crudeauth.services;

import com.mateus.crudeauth.model.Teacher;
import com.mateus.crudeauth.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



@Service
public class TeacherServices {

    private final TeacherRepository teacherRepository;

    public TeacherServices(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher saveTeacher(Teacher teacher) {
        if (teacher.getTeacherName() == null || teacher.getTeacherName().trim().isEmpty()) {
            throw new RuntimeException("Teacher name is empty");
        }
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getTeacher() {
        if (teacherRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found");
        }
        return teacherRepository.findAll();

    }



    @Transactional
    public void deleteTeacher(Integer id) {
        if(!teacherRepository.existsById(id)){
            throw new RuntimeException("User not found " + "Id: " + id);
        }
        teacherRepository.deleteById(id);
    }

    @Transactional
    public Teacher updateTeacher(Integer id, Teacher teacher) {
        Teacher existing = teacherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "User not found " + id));

               if (id <= 0) {
                   throw new ResponseStatusException(
                           HttpStatus.NOT_FOUND, "User not found ");
               }
               if (teacher.getTeacherName() == null) {
                   throw new RuntimeException("Teacher name is empty");
               }

               if (teacher.getEmail() == null || teacher.getEmail().trim().isEmpty()) {
                   throw new RuntimeException("Email is empty");
               }
               if (teacher.getTelephone() == null) {
                   throw new RuntimeException("Telephone is empty");
               }


        existing.setTeacherName(teacher.getTeacherName());
        existing.setEmail(teacher.getEmail());
        existing.setTelephone(teacher.getTelephone());



        return teacherRepository.save(existing);


    }
}






