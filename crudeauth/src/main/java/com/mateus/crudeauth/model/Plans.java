package com.mateus.crudeauth.model;


import jakarta.persistence.*;

@Entity(name = "tb_plans")
@Table(name = "tb_plans")
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String price;
    private String duracaoDias;

    public Plans(Integer id, String name, String price, String duracaoDias) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.duracaoDias = duracaoDias;
    }

    public Plans(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(String duracaoDias) {
        this.duracaoDias = duracaoDias;
    }
}
