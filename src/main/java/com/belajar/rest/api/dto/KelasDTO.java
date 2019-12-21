package com.belajar.rest.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Kelas.
 */
@Setter
@Getter
public class KelasDTO {
    private Integer id;
    private String namaKelas;
    private Integer idJurusan;
    private Boolean hapus;
}
