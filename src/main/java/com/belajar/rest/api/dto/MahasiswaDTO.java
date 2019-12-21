package com.belajar.rest.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Mahasiswa.
 */
@Setter
@Getter
public class MahasiswaDTO {
    private Integer id;
    private String namaMahasiwa;
    private Integer idKelas;
    private Integer idJurusan;
    private Boolean hapus;
}
