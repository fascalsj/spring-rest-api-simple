package com.belajar.rest.api.controller;

import com.belajar.rest.api.common.ResponseSuccess;
import com.belajar.rest.api.dto.MahasiswaDTO;
import com.belajar.rest.api.entity.Mahasiswa;
import com.belajar.rest.api.service.MahasiswaService;
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

    JMapper<Mahasiswa, MahasiswaDTO> mapper2Entity = new JMapper<>(Mahasiswa.class, MahasiswaDTO.class, "jmapper/mahasiswa/entity_mapper.xml");
    JMapper<MahasiswaDTO, Mahasiswa> mapper2Dto = new JMapper<>(MahasiswaDTO.class, Mahasiswa.class, "jmapper/mahasiswa/dto_mapper.xml");

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<MahasiswaDTO>> create(@RequestBody @Validated MahasiswaDTO mahasiswaDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Mahasiswa mahasiswaEntity = mapper2Entity.getDestination(mahasiswaDto);
        Mahasiswa mahasiswaCreate = mahasiswaService.create(mahasiswaEntity);
        mahasiswaDto = mapper2Dto.getDestination(mahasiswaCreate);

        /* Response */
        ResponseSuccess<MahasiswaDTO> responseSuccess = new ResponseSuccess<>();
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
    public ResponseEntity<ResponseSuccess<MahasiswaDTO>> patch(@PathVariable("id") Integer id, @RequestBody @Validated MahasiswaDTO mahasiswaDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        Mahasiswa mahasiswaEntity = mapper2Entity.getDestination(mahasiswaDto);
        Mahasiswa mahasiswaUpdated = mahasiswaService.updateById(id, mahasiswaEntity);
        mahasiswaDto = mapper2Dto.getDestination(mahasiswaUpdated);

        ResponseSuccess<MahasiswaDTO> responseSuccess = new ResponseSuccess<>();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mahasiswaDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<List<MahasiswaDTO>>> findAll(Pageable pageable) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        List<MahasiswaDTO> mahasiswaDtoList = new ArrayList<>();
        List<Mahasiswa> mahasiswaEntity = mahasiswaService.findAll(pageable);
        mahasiswaEntity.forEach(mahasiswa -> mahasiswaDtoList.add(mapper2Dto.getDestination(mahasiswa)));

        ResponseSuccess<List<MahasiswaDTO>> responseSuccess = new ResponseSuccess<>();
        responseSuccess.setMessage("Success Show Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mahasiswaDtoList);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<MahasiswaDTO>> findById(@PathVariable("id") Integer id) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        Mahasiswa mahasiswaUpdated = mahasiswaService.findById(id);

        MahasiswaDTO mahasiswaDto = mapper2Dto.getDestination(mahasiswaUpdated);

        ResponseSuccess<MahasiswaDTO> responseSuccess = new ResponseSuccess<>();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mahasiswaDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

}
