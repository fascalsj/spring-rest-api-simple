package com.belajar.restapi.service;

import com.belajar.restapi.entity.Kelas;
import com.belajar.restapi.repository.KelasRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KelasServiceTest {
    @Autowired
    KelasService kelasService;

    @MockBean
    KelasRepository kelasRepository;

    private Kelas kelasMock;
    private List<Kelas> kelasMockList;

    @Before
    public void predifine(){
        kelasMock = new Kelas();
        kelasMock.setHapus(false);
        kelasMock.setId(1);
        kelasMock.setIdJurusan(1);
        kelasMock.setNamaKelas("IF-8");

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

    public void testFindAll() {
        Pageable pageable = PageRequest.of(0, 3);
        Mockito.when(kelasRepository.findAll()).thenReturn(kelasMockList);
        List<Kelas> actual = kelasService.findAll(pageable);
        Assert.assertNotNull(actual);
    }

    @Test
    public void testFindById() {
        Mockito.when(kelasRepository.find(Mockito.anyInt())).thenReturn(kelasMock);
        Kelas actual = kelasService.findById(kelasMock.getId());
        Assert.assertEquals(actual.getHapus(), kelasMock.getHapus());
        Assert.assertEquals(actual.getId(), kelasMock.getId());
        Assert.assertEquals(actual.getIdJurusan(), kelasMock.getIdJurusan());
        Assert.assertEquals(actual.getNamaKelas(), kelasMock.getNamaKelas());
    }

    @Test
    public void testUpdateById() {
        kelasMock.setIdJurusan(2);
        Mockito.when(kelasRepository.save(Mockito.any(Kelas.class))).thenReturn(kelasMock);
        Kelas actual = kelasService.updateById(kelasMock.getId(), kelasMock);
        Assert.assertEquals(actual.getIdJurusan(), kelasMock.getIdJurusan());
    }

    @Test
    public void testCreate() {
        Mockito.when(kelasRepository.save(Mockito.any(Kelas.class))).thenReturn(kelasMock);
        Kelas actual = kelasService.create(kelasMock);
        Assert.assertEquals(actual.getHapus(), kelasMock.getHapus());
        Assert.assertEquals(actual.getId(), kelasMock.getId());
        Assert.assertEquals(actual.getIdJurusan(), kelasMock.getIdJurusan());
        Assert.assertEquals(actual.getNamaKelas(), kelasMock.getNamaKelas());
    }

    @Test
    public void testDelete() {
        kelasMock.setHapus(true);
        Mockito.when(kelasRepository.delete(Mockito.anyInt())).thenReturn(kelasMock);
        Kelas actual = kelasService.delete(kelasMock.getId());
        Assert.assertTrue(actual.getHapus());
    }
}