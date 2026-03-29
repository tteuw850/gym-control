package com.mateus.crudeauth.controller;

import com.mateus.crudeauth.services.TeacherServices;
import com.mateus.crudeauth.model.Teacher;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherServices teacherServices;

    public TeacherController(TeacherServices teacherServices) {

        this.teacherServices = teacherServices;
    }

    @Operation(description = "Salva novo professor")
    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(teacherServices.saveTeacher(teacher));
    }

    @Operation(description = "Exibe todos professores")
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherServices.getTeacher());
    }


    @Operation(description = "Exibe professor específico pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(
            @RequestBody Teacher teacher,
            @PathVariable Integer id) {
        Teacher teacherById = teacherServices.getTeacher().get(id);
        return ResponseEntity.ok(teacherById);
    }

    @Operation(description = "Atualiza professor específico pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity updateTeacher(
            @PathVariable ("id") Integer id,
            @RequestBody Teacher teacher) {
        Teacher updateTeacher = teacherServices.updateTeacher(id, teacher);
        return ResponseEntity.ok(teacherServices.updateTeacher(id, teacher));
    }


    @Operation(description = "Deleta professor específico pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(
            @PathVariable Integer id) {
        teacherServices.deleteTeacher(id);
        return ResponseEntity.ok("Delete Teacher Successfully");
    }





}
