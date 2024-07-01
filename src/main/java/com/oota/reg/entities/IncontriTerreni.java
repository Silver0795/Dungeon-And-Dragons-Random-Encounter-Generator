package com.oota.reg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "incontri_terreni")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IncontriTerreni {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @Column(name="nome")
    String name;

    @Column(name = "descrizione")
    String descrizione;

    @Column(name = "img")
    String img;

    @ManyToOne
    @JoinColumn (name = "id_luogo")
    Luoghi idLuogo;
}
