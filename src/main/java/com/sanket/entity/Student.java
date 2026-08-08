package com.sanket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Student_Info")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer studId;
    private String studName;
    private String studAddrs;

}
