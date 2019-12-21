package com.belajar.rest.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Mahasiswa.
 */
@Entity
@Setter
@Getter
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nama_mahasiswa")
    private String namaMahasiwa;

    @Column(name = "id_kelas")
    private Integer idKelas;

    @Column(name = "id_jurusan")
    private Integer idJurusan;

    @Column(name = "hapus")
    private Boolean hapus;
}
