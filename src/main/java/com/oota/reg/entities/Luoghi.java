package com.oota.reg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="luoghi")
@AllArgsConstructor @NoArgsConstructor @Data
public class Luoghi {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @Column(name="nome_luogo")
    String name;

    @Column(name = "descrizione")
    String descrizione;

    @Column(name = "img")
    String img;

}
