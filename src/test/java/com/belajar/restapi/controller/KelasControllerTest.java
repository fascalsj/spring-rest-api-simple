package com.belajar.restapi.controller;

import com.belajar.restapi.entity.Kelas;
import com.belajar.restapi.service.KelasService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(KelasController.class)
public class KelasControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    KelasService kelasService;

    private Kelas kelasMock;
    private List<Kelas> kelasMockList;

    @Before
    public void predefine(){
        kelasMock = new Kelas();
        kelasMock.setHapus(false);
        kelasMock.setId(1);
        kelasMock.setIdJurusan(1);
        kelasMock.setNamaKelas("Fascal");

        kelasMockList = new ArrayList<>();

        Kelas kelasMock1 = new Kelas();
        kelasMock1.setHapus(false);
        kelasMock1.setId(1);
        kelasMock1.setIdJurusan(1);
        kelasMock1.setNamaKelas("IF-1");

        Kelas kelasMock2 = new Kelas();
        kelasMock2.setHapus(false);
        kelasMock2.setId(2);
        kelasMock2.setIdJurusan(1);
        kelasMock2.setNamaKelas("IF-2");

        Kelas kelasMock3 = new Kelas();
        kelasMock3.setHapus(false);
        kelasMock3.setId(3);
        kelasMock3.setIdJurusan(1);
        kelasMock3.setNamaKelas("IF-3");

        kelasMockList.add(kelasMock1);
        kelasMockList.add(kelasMock2);
        kelasMockList.add(kelasMock3);
    }

    @Test
    public void testCreate() throws Exception {
        Mockito.when(kelasService.create(Mockito.any(Kelas.class))).thenReturn(kelasMock);

        MockHttpServletRequestBuilder requestBuilder =  MockMvcRequestBuilders
                .post("/belajar/tdd/kelas")
                .servletPath("/kelas")
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"namaKelas\" : \"kelas\",\"idJurusan\" : 1,\"hapus\" : false}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPatch() throws Exception {
        Mockito.when(kelasService.updateById(Mockito.anyInt(), Mockito.any(Kelas.class))).thenReturn(kelasMock);

        MockHttpServletRequestBuilder requestBuilder =  MockMvcRequestBuilders
                .patch("/belajar/tdd/kelas/"+kelasMock.getId())
                .servletPath("/kelas/"+kelasMock.getId())
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"namaKelas\" : \"kelas\",\"idJurusan\" : 1,\"hapus\" : false}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findAll() throws Exception {
        Mockito.when(kelasService.findAll(Mockito.any(Pageable.class))).thenReturn(kelasMockList);

        MockHttpServletRequestBuilder requestBuilder =  MockMvcRequestBuilders
                .get("/belajar/tdd/kelas")
                .servletPath("/kelas")
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findById() throws Exception {
        Mockito.when(kelasService.findById(Mockito.anyInt())).thenReturn(kelasMock);

        MockHttpServletRequestBuilder requestBuilder =  MockMvcRequestBuilders
                .get("/belajar/tdd/kelas/"+kelasMock.getId())
                .servletPath("/kelas/"+kelasMock.getId())
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}