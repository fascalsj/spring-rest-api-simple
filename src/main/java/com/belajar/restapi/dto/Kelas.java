package com.belajar.restapi.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Kelas.
 */
@Setter
@Getter
public class Kelas {
    private Integer id;
    private String namaKelas;
    private Integer idJurusan;
    private Boolean hapus;
}
