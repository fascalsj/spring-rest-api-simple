package com.belajar.restapi.controller;

import com.belajar.restapi.common.ResponseSuccess;
import com.belajar.restapi.dto.MataKuliah;
import com.belajar.restapi.service.MataKuliahService;
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
@RequestMapping(value = "mata-kuliah")
public class MataKuliahController {

    @Autowired
    MataKuliahService mataKuliahService;

    JMapper<com.belajar.restapi.entity.MataKuliah, MataKuliah> mapper2Entity = new JMapper<>(com.belajar.restapi.entity.MataKuliah.class, MataKuliah.class, "jmapper/mata_kuliah/entity_mapper.xml");
    JMapper<MataKuliah, com.belajar.restapi.entity.MataKuliah> mapper2Dto = new JMapper<>(MataKuliah.class, com.belajar.restapi.entity.MataKuliah.class, "jmapper/mata_kuliah/dto_mapper.xml");

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<MataKuliah>> create(@RequestBody @Validated MataKuliah mataKuliahDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        com.belajar.restapi.entity.MataKuliah mataKuliahEntity = mapper2Entity.getDestination(mataKuliahDto);
        com.belajar.restapi.entity.MataKuliah mataKuliahCreate = mataKuliahService.create(mataKuliahEntity);
        mataKuliahDto = mapper2Dto.getDestination(mataKuliahCreate);

        /* Response */
        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Create Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setTimestamp(new Timestamp(System.currentTimeMillis()));
        responseSuccess.setData(mataKuliahDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

    @PatchMapping(value = "{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<MataKuliah>> put(@PathVariable("id") Integer id, @RequestBody @Validated MataKuliah mataKuliahDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        com.belajar.restapi.entity.MataKuliah mataKuliahEntity = mapper2Entity.getDestination(mataKuliahDto);
        com.belajar.restapi.entity.MataKuliah mataKuliahUpdated = mataKuliahService.updateById(id, mataKuliahEntity);
        mataKuliahDto = mapper2Dto.getDestination(mataKuliahUpdated);

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mataKuliahDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<List<MataKuliah>>> findAll(Pageable pageable) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        List<MataKuliah> mataKuliahDtoList = new ArrayList<>();
        List<com.belajar.restapi.entity.MataKuliah> mataKuliahEntity = mataKuliahService.findAll(pageable);
        mataKuliahEntity.forEach(mataKuliah -> mataKuliahDtoList.add(mapper2Dto.getDestination(mataKuliah)));

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Show Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mataKuliahDtoList);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<MataKuliah>> findById(@PathVariable("id") Integer id) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        com.belajar.restapi.entity.MataKuliah mataKuliahUpdated = mataKuliahService.findById(id);

        MataKuliah mataKuliahDto = mapper2Dto.getDestination(mataKuliahUpdated);

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mataKuliahDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

}
