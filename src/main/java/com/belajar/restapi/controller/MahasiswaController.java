package com.belajar.restapi.controller;

import com.belajar.restapi.common.ResponseSuccess;
import com.belajar.restapi.dto.Mahasiswa;
import com.belajar.restapi.service.MahasiswaService;
import com.googlecode.jmapper.JMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "mahasiswa")
public class MahasiswaController {

    @Autowired
    MahasiswaService mahasiswaService;

    JMapper<com.belajar.restapi.entity.Mahasiswa, Mahasiswa> mapper2Entity = new JMapper<>(com.belajar.restapi.entity.Mahasiswa.class, Mahasiswa.class, "jmapper/mahasiswa/entity_mapper.xml");
    JMapper<Mahasiswa, com.belajar.restapi.entity.Mahasiswa> mapper2Dto = new JMapper<>(Mahasiswa.class, com.belajar.restapi.entity.Mahasiswa.class, "jmapper/mahasiswa/dto_mapper.xml");

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<Mahasiswa>> create(@RequestBody @Validated Mahasiswa mahasiswaDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        com.belajar.restapi.entity.Mahasiswa mahasiswaEntity = mapper2Entity.getDestination(mahasiswaDto);
        com.belajar.restapi.entity.Mahasiswa mahasiswaCreate = mahasiswaService.create(mahasiswaEntity);
        mahasiswaDto = mapper2Dto.getDestination(mahasiswaCreate);

        /* Response */
        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Create Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setTimestamp(new Timestamp(System.currentTimeMillis()));
        responseSuccess.setData(mahasiswaDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

    @PatchMapping(value = "{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<Mahasiswa>> put(@PathVariable("id") Integer id, @RequestBody @Validated Mahasiswa mahasiswaDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        com.belajar.restapi.entity.Mahasiswa mahasiswaEntity = mapper2Entity.getDestination(mahasiswaDto);
        com.belajar.restapi.entity.Mahasiswa mahasiswaUpdated = mahasiswaService.updateById(id, mahasiswaEntity);
        mahasiswaDto = mapper2Dto.getDestination(mahasiswaUpdated);

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mahasiswaDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<List<Mahasiswa>>> findAll(Pageable pageable) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        List<Mahasiswa> mahasiswaDtoList = new ArrayList<>();
        List<com.belajar.restapi.entity.Mahasiswa> mahasiswaEntity = mahasiswaService.findAll(pageable);
        mahasiswaEntity.forEach(mahasiswa -> mahasiswaDtoList.add(mapper2Dto.getDestination(mahasiswa)));

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Show Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mahasiswaDtoList);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<Mahasiswa>> findById(@PathVariable("id") Integer id) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        com.belajar.restapi.entity.Mahasiswa mahasiswaUpdated = mahasiswaService.findById(id);

        Mahasiswa mahasiswaDto = mapper2Dto.getDestination(mahasiswaUpdated);

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mahasiswaDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

}
