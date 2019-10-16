package com.belajar.restapi.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Mahasiswa.
 */
@Setter
@Getter
public class Mahasiswa {
    private Integer id;
    private String namaMahasiwa;
    private Integer idKelas;
    private Integer idJurusan;
    private Boolean hapus;
}
