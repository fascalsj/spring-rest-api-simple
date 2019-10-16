package com.belajar.restapi.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Mata kuliah.
 */
@Setter
@Getter
public class MataKuliah {
    private Integer id;
    private String namaMataKuliah;
    private Integer idJurusan;
    private Boolean hapus;
}