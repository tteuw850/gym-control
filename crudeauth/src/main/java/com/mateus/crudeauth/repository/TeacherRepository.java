package com.mateus.crudeauth.repository;

import com.mateus.crudeauth.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    void deleteById(Integer id);
    boolean existsById(Integer id);
    Optional<Teacher> findById(Integer id);
}
