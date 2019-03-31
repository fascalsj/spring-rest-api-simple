package com.belajar.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fascal
 */
@Setter /*Untuk Generate Setter*/
@Getter /*Untuk Generate Getter*/
@Entity /*Untuk Generate Entity*/
@Transactional
public class Hardware {

    @Id /*Sebagai Id*/
    @GeneratedValue(strategy = GenerationType.SEQUENCE )/*Untuk Generate Auto Increment*/
    private Long id;

    @Column(name = "tipe")/*Sesuai dengan field yang ada pada database*/
    private String tipe;

    @Column(name = "merk")/*Sesuai dengan field yang ada pada database*/
    private String merk;

    @Column(name = "harga")/*Sesuai dengan field yang ada pada database*/
    private Long harga;

    @Column(name = "jenis_garansi")/*Sesuai dengan field yang ada pada database*/
    private String jenisGaransi;

}
