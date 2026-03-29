package com.mateus.crudeauth.model;
import jakarta.persistence.*;




@Entity(name = "teacher")
@Table(name = "tb_teacher")


public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teacherName;
    private String telephone;
    private String email;





    public Teacher(Integer id, String teacherName, String email, String telephone) {
        this.id = id;
        this.teacherName = teacherName;
        this.email = email;
        this.telephone = telephone;
    }

    public Teacher() {

    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
