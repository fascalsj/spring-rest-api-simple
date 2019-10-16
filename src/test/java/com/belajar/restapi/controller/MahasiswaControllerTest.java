package com.belajar.restapi.controller;

import com.belajar.restapi.entity.Mahasiswa;
import com.belajar.restapi.service.MahasiswaService;
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
@WebMvcTest(MahasiswaController.class)
public class MahasiswaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MahasiswaService mahasiswaService;

    private Mahasiswa mahasiswaMock;
    private List<Mahasiswa> mahasiswaListMock;

    @Before
    public void predefine() {
        mahasiswaMock = new Mahasiswa();
        mahasiswaMock.setHapus(false);
        mahasiswaMock.setId(1);
        mahasiswaMock.setIdJurusan(1);
        mahasiswaMock.setIdKelas(1);
        mahasiswaMock.setNamaMahasiwa("Fascal Sapty Jarockohir");

        mahasiswaListMock = new ArrayList<>();

        Mahasiswa mahasiswaMock1 = new Mahasiswa();
        mahasiswaMock1.setHapus(false);
        mahasiswaMock1.setId(1);
        mahasiswaMock1.setIdJurusan(1);
        mahasiswaMock1.setIdKelas(1);
        mahasiswaMock1.setNamaMahasiwa("Mahasiswa 1");

        Mahasiswa mahasiswaMock2 = new Mahasiswa();
        mahasiswaMock2.setHapus(false);
        mahasiswaMock2.setId(1);
        mahasiswaMock2.setIdJurusan(1);
        mahasiswaMock2.setIdKelas(1);
        mahasiswaMock2.setNamaMahasiwa("Mahasiswa 2");

        Mahasiswa mahasiswaMock3 = new Mahasiswa();
        mahasiswaMock3.setHapus(false);
        mahasiswaMock3.setId(1);
        mahasiswaMock3.setIdJurusan(1);
        mahasiswaMock3.setIdKelas(1);
        mahasiswaMock3.setNamaMahasiwa("Mahasiswa 3");

        mahasiswaListMock.add(mahasiswaMock1);
        mahasiswaListMock.add(mahasiswaMock2);
        mahasiswaListMock.add(mahasiswaMock3);
    }

    @Test
    public void testCreate() throws Exception {
        Mockito.when(mahasiswaService.create(Mockito.any(Mahasiswa.class))).thenReturn(mahasiswaMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/belajar/tdd/mahasiswa")
                .servletPath("/mahasiswa")
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1,\"namaMahasiwa\" : \"Fascal\",\"idKelas\" : 1,\"idJurusan\" : 1,\"hapus\" : 0}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPatch() throws Exception {
        Mockito.when(mahasiswaService.updateById(Mockito.anyInt(), Mockito.any(Mahasiswa.class))).thenReturn(mahasiswaMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .patch("/belajar/tdd/mahasiswa/" + mahasiswaMock.getId())
                .servletPath("/mahasiswa/" + mahasiswaMock.getId())
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1,\"namaMahasiwa\" : \"Fascal\",\"idKelas\" : 1,\"idJurusan\" : 1,\"hapus\" : 0}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findAll() throws Exception {
        Mockito.when(mahasiswaService.findAll(Mockito.any(Pageable.class))).thenReturn(mahasiswaListMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/belajar/tdd/mahasiswa")
                .servletPath("/mahasiswa")
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findById() throws Exception {
        Mockito.when(mahasiswaService.findById(Mockito.anyInt())).thenReturn(mahasiswaMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/belajar/tdd/mahasiswa/" + mahasiswaMock.getId())
                .servletPath("/mahasiswa/" + mahasiswaMock.getId())
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}