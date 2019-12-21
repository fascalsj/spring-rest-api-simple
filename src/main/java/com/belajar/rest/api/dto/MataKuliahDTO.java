package com.belajar.rest.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Mata kuliah.
 */
@Setter
@Getter
public class MataKuliahDTO {
    private Integer id;
    private String namaMataKuliah;
    private Integer idJurusan;
    private Boolean hapus;
}