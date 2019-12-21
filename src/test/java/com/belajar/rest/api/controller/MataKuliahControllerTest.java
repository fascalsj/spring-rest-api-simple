package com.belajar.rest.api.controller;

import com.belajar.rest.api.entity.MataKuliah;
import com.belajar.rest.api.service.MataKuliahService;
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
@WebMvcTest(MataKuliahController.class)
public class MataKuliahControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MataKuliahService mataKuliahService;

    private MataKuliah mataKuliahMock;
    private List<MataKuliah> mataKuliahListMock;

    @Before
    public void predefine() {
        mataKuliahMock = new MataKuliah();
        mataKuliahListMock = new ArrayList<>();

        mataKuliahMock.setHapus(false);
        mataKuliahMock.setId(1);
        mataKuliahMock.setIdJurusan(1);
        mataKuliahMock.setNamaMataKuliah("Pemograman Dasar");

        MataKuliah mataKuliahMock1 =  new MataKuliah();
        mataKuliahMock1.setHapus(false);
        mataKuliahMock1.setId(1);
        mataKuliahMock1.setIdJurusan(1);
        mataKuliahMock1.setNamaMataKuliah("Kalkulus");

        MataKuliah mataKuliahMock2 =  new MataKuliah();
        mataKuliahMock2.setHapus(false);
        mataKuliahMock2.setId(1);
        mataKuliahMock2.setIdJurusan(1);
        mataKuliahMock2.setNamaMataKuliah("Struktur Data");

        MataKuliah mataKuliahMock3 =  new MataKuliah();
        mataKuliahMock3.setHapus(false);
        mataKuliahMock3.setId(1);
        mataKuliahMock3.setIdJurusan(1);
        mataKuliahMock3.setNamaMataKuliah("Matematika Disktrit");

        mataKuliahListMock.add(mataKuliahMock1);
        mataKuliahListMock.add(mataKuliahMock2);
        mataKuliahListMock.add(mataKuliahMock3);
    }

    @Test
    public void testCreate() throws Exception {
        Mockito.when(mataKuliahService.create(Mockito.any(MataKuliah.class))).thenReturn(mataKuliahMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/belajar/tdd/mata-kuliah")
                .servletPath("/mata-kuliah")
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1,\"namaMataKuliah\" : \"Matematika\",\"idJurusan\" : 1,\"hapus\" : 1}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPatch() throws Exception {
        Mockito.when(mataKuliahService.updateById(Mockito.anyInt(), Mockito.any(MataKuliah.class))).thenReturn(mataKuliahMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .patch("/belajar/tdd/mata-kuliah/" + mataKuliahMock.getId())
                .servletPath("/mata-kuliah/" + mataKuliahMock.getId())
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1,\"namaMataKuliah\" : \"Matematika\",\"idJurusan\" : 1,\"hapus\" : 1}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findAll() throws Exception {
        Mockito.when(mataKuliahService.findAll(Mockito.any(Pageable.class))).thenReturn(mataKuliahListMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/belajar/tdd/mata-kuliah")
                .servletPath("/mata-kuliah")
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findById() throws Exception {
        Mockito.when(mataKuliahService.findById(Mockito.anyInt())).thenReturn(mataKuliahMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/belajar/tdd/mata-kuliah/" + mataKuliahMock.getId())
                .servletPath("/mata-kuliah/" + mataKuliahMock.getId())
                .contextPath("/belajar/tdd")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}