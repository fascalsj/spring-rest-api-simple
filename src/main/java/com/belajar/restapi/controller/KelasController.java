package com.belajar.restapi.controller;

import com.belajar.restapi.common.ResponseSuccess;
import com.belajar.restapi.dto.Kelas;
import com.belajar.restapi.service.KelasService;
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
@RequestMapping(value = "kelas")
public class KelasController {

    @Autowired
    KelasService kelasService;

    JMapper<com.belajar.restapi.entity.Kelas, Kelas> mapper2Entity = new JMapper<>(com.belajar.restapi.entity.Kelas.class, Kelas.class, "jmapper/kelas/entity_mapper.xml");
    JMapper<Kelas, com.belajar.restapi.entity.Kelas> mapper2Dto = new JMapper<>(Kelas.class, com.belajar.restapi.entity.Kelas.class, "jmapper/kelas/dto_mapper.xml");

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<Kelas>> create(@RequestBody @Validated Kelas kelasDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        com.belajar.restapi.entity.Kelas kelasEntity = mapper2Entity.getDestination(kelasDto);
        com.belajar.restapi.entity.Kelas kelasCreate = kelasService.create(kelasEntity);
        kelasDto = mapper2Dto.getDestination(kelasCreate);

        /* Response */
        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Create Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setTimestamp(new Timestamp(System.currentTimeMillis()));
        responseSuccess.setData(kelasDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

    @PatchMapping(value = "{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<Kelas>> put(@PathVariable("id") Integer id, @RequestBody @Validated Kelas kelasDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        com.belajar.restapi.entity.Kelas kelasEntity = mapper2Entity.getDestination(kelasDto);
        com.belajar.restapi.entity.Kelas kelasUpdated = kelasService.updateById(id, kelasEntity);
        kelasDto = mapper2Dto.getDestination(kelasUpdated);

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(kelasDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<List<Kelas>>> findAll(Pageable pageable) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        List<Kelas> kelasDtoList = new ArrayList<>();
        List<com.belajar.restapi.entity.Kelas> kelasEntity = kelasService.findAll(pageable);
        kelasEntity.forEach(kelas -> kelasDtoList.add(mapper2Dto.getDestination(kelas)));

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Show Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(kelasDtoList);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<Kelas>> findById(@PathVariable("id") Integer id) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        com.belajar.restapi.entity.Kelas kelasUpdated = kelasService.findById(id);

        Kelas kelasDto = mapper2Dto.getDestination(kelasUpdated);

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(kelasDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

}
