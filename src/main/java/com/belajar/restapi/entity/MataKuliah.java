package com.belajar.restapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Mata kuliah.
 */
@Entity
@Setter
@Getter
public class MataKuliah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nama_mata_kuliah")
    private String namaMataKuliah;

    @Column(name = "id_jurusan")
    private Integer idJurusan;

    @Column(name = "hapus")
    private Boolean hapus;
}