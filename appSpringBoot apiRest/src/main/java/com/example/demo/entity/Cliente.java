package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;



@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    @Size(min=4, max=12)
    @Column(nullable = false)
    private String nombre;

    @NotEmpty
    private String apellido;


    @NotEmpty
    @Email
    @Column(nullable=false, unique=true)
    private String email;


    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }


    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;



    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return this.apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public Date getCreateAt() {
        return this.createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }






    private static final long serialVersionUID = 1L;
}
