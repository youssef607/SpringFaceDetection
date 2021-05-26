package com.example.ghanim.qr.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmployee;
    private String nomEmployee;
    private String matricule;
    private String imageEmployee;
    private String codeQr;


    public Employee() {
    }

    public Employee(Long idEmployee, String nomEmployee, String matricule, String imageEmployee, String codeQr) {
        this.idEmployee = idEmployee;
        this.nomEmployee = nomEmployee;
        this.matricule = matricule;
        this.imageEmployee = imageEmployee;
        this.codeQr = codeQr;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNomEmployee() {
        return nomEmployee;
    }

    public void setNomEmployee(String nomEmployee) {
        this.nomEmployee = nomEmployee;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getImageEmployee() {
        return imageEmployee;
    }

    public void setImageEmployee(String imageEmployee) {
        this.imageEmployee = imageEmployee;
    }

    public String getCodeQr() {
        return codeQr;
    }

    public void setCodeQr(String codeQr) {
        this.codeQr = codeQr;
    }
}
