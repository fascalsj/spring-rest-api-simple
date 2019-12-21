package com.belajar.rest.api.controller;

import com.belajar.rest.api.common.ResponseSuccess;
import com.belajar.rest.api.dto.MataKuliahDTO;
import com.belajar.rest.api.entity.MataKuliah;
import com.belajar.rest.api.service.MataKuliahServiceImpl;
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
    MataKuliahServiceImpl mataKuliahService;

    JMapper<MataKuliah, MataKuliahDTO> mapper2Entity = new JMapper<>(MataKuliah.class, MataKuliahDTO.class, "jmapper/mata_kuliah/entity_mapper.xml");
    JMapper<MataKuliahDTO, MataKuliah> mapper2Dto = new JMapper<>(MataKuliahDTO.class, MataKuliah.class, "jmapper/mata_kuliah/dto_mapper.xml");

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<MataKuliahDTO>> create(@RequestBody @Validated MataKuliahDTO mataKuliahDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        MataKuliah mataKuliahEntity = mapper2Entity.getDestination(mataKuliahDto);
        MataKuliah mataKuliahCreate = mataKuliahService.create(mataKuliahEntity);
        mataKuliahDto = mapper2Dto.getDestination(mataKuliahCreate);

        /* Response */
        ResponseSuccess<MataKuliahDTO> responseSuccess = new ResponseSuccess<>();
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
    public ResponseEntity<ResponseSuccess<MataKuliahDTO>> put(@PathVariable("id") Integer id, @RequestBody @Validated MataKuliahDTO mataKuliahDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        MataKuliah mataKuliahEntity = mapper2Entity.getDestination(mataKuliahDto);
        MataKuliah mataKuliahUpdated = mataKuliahService.updateById(id, mataKuliahEntity);
        mataKuliahDto = mapper2Dto.getDestination(mataKuliahUpdated);

        ResponseSuccess<MataKuliahDTO> responseSuccess = new ResponseSuccess<>();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mataKuliahDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<List<MataKuliahDTO>>> findAll(Pageable pageable) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        List<MataKuliahDTO> mataKuliahDtoList = new ArrayList<>();
        List<MataKuliah> mataKuliahEntity = mataKuliahService.findAll(pageable);
        mataKuliahEntity.forEach(mataKuliah -> mataKuliahDtoList.add(mapper2Dto.getDestination(mataKuliah)));

        ResponseSuccess<List<MataKuliahDTO>> responseSuccess = new ResponseSuccess<>();
        responseSuccess.setMessage("Success Show Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mataKuliahDtoList);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<MataKuliahDTO>> findById(@PathVariable("id") Integer id) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        MataKuliah mataKuliahUpdated = mataKuliahService.findById(id);

        MataKuliahDTO mataKuliahDto = mapper2Dto.getDestination(mataKuliahUpdated);

        ResponseSuccess<MataKuliahDTO> responseSuccess = new ResponseSuccess<>();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(mataKuliahDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

}
