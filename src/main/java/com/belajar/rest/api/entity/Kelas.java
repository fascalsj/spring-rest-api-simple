package com.belajar.rest.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Kelas.
 */
@Setter
@Getter
@Entity
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nama_kelas")
    private String namaKelas;

    @Column(name = "id_jurusan")
    private Integer idJurusan;

    @Column(name = "hapus")
    private Boolean hapus;
}
