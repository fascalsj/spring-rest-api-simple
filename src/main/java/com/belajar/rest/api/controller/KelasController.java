package com.belajar.rest.api.controller;

import com.belajar.rest.api.common.ResponseSuccess;
import com.belajar.rest.api.dto.KelasDTO;
import com.belajar.rest.api.entity.Kelas;
import com.belajar.rest.api.service.KelasService;
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

    JMapper<Kelas, KelasDTO> mapper2Entity = new JMapper<>(Kelas.class, KelasDTO.class, "jmapper/kelas/entity_mapper.xml");
    JMapper<KelasDTO, Kelas> mapper2Dto = new JMapper<>(KelasDTO.class, Kelas.class, "jmapper/kelas/dto_mapper.xml");

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<KelasDTO>> create(@RequestBody @Validated KelasDTO kelasDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Kelas kelasEntity = mapper2Entity.getDestination(kelasDto);
        Kelas kelasCreate = kelasService.create(kelasEntity);
        kelasDto = mapper2Dto.getDestination(kelasCreate);

        /* Response */
        ResponseSuccess<KelasDTO> responseSuccess = new ResponseSuccess<>();
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
    public ResponseEntity<ResponseSuccess<KelasDTO>> patch(@PathVariable("id") Integer id, @RequestBody @Validated KelasDTO kelasDto) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        Kelas kelasEntity = mapper2Entity.getDestination(kelasDto);
        Kelas kelasUpdated = kelasService.updateById(id, kelasEntity);
        kelasDto = mapper2Dto.getDestination(kelasUpdated);

        ResponseSuccess<KelasDTO> responseSuccess = new ResponseSuccess<>();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(kelasDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<List<KelasDTO>>> findAll(Pageable pageable) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        List<KelasDTO> kelasDtoList = new ArrayList<>();
        List<Kelas> kelasEntity = kelasService.findAll(pageable);
        kelasEntity.forEach(kelas -> kelasDtoList.add(mapper2Dto.getDestination(kelas)));

        ResponseSuccess<List<KelasDTO>> responseSuccess = new ResponseSuccess<>();
        responseSuccess.setMessage("Success Show Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(kelasDtoList);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuccess<KelasDTO>> findById(@PathVariable("id") Integer id) {
        /* Untuk mendapatkan nama method */
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        Kelas kelasUpdated = kelasService.findById(id);

        KelasDTO kelasDto = mapper2Dto.getDestination(kelasUpdated);

        ResponseSuccess<KelasDTO> responseSuccess = new ResponseSuccess<>();
        responseSuccess.setMessage("Success Update Data");
        responseSuccess.setService(nameofCurrMethod);
        responseSuccess.setData(kelasDto);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON)
                .body(responseSuccess);
    }

}
