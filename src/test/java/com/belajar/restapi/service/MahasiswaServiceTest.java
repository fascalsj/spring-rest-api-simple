package com.belajar.restapi.service;

import com.belajar.restapi.entity.Mahasiswa;
import com.belajar.restapi.repository.MahasiswaRepository;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MahasiswaServiceTest {

    @Autowired
    MahasiswaService mahasiswaService;

    @MockBean
    MahasiswaRepository mahasiswaRepository;

    private Mahasiswa mahasiswaMock;
    private List<Mahasiswa> mahasiswaListMock;

    @Before
    public void predefine(){
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
    public void testFindAll() {
        Mockito.when(mahasiswaRepository.findAll()).thenReturn(mahasiswaListMock);
        Pageable pageable = PageRequest.of(0, 3);
        List<Mahasiswa> actual = mahasiswaService.findAll(pageable);
        Assert.assertNotNull(actual);
    }

    @Test
    public void testFindById() {
        Mockito.when(mahasiswaRepository.find(Mockito.anyInt())).thenReturn(mahasiswaMock);
        Mahasiswa actual = mahasiswaService.findById(mahasiswaMock.getId());
        Assert.assertEquals(actual.getId(), mahasiswaMock.getId());

    }

    @Test
    public void testUpdateById() {
        Mockito.when(mahasiswaRepository.save(Mockito.any(Mahasiswa.class))).thenReturn(mahasiswaMock);
        Mahasiswa actual = mahasiswaService.updateById(mahasiswaMock.getId(), mahasiswaMock);
        Assert.assertEquals(actual.getNamaMahasiwa(), mahasiswaMock.getNamaMahasiwa());
    }

    @Test
    public void testCreate() {
        Mockito.when(mahasiswaRepository.save(Mockito.any(Mahasiswa.class))).thenReturn(mahasiswaMock);
        Mahasiswa actual = mahasiswaService.create(mahasiswaMock);
        Assert.assertEquals(actual.getId(),mahasiswaMock.getId());
        Assert.assertEquals(actual.getHapus(),mahasiswaMock.getHapus());
        Assert.assertEquals(actual.getIdJurusan(),mahasiswaMock.getIdJurusan());
        Assert.assertEquals(actual.getIdKelas(),mahasiswaMock.getIdKelas());
        Assert.assertEquals(actual.getNamaMahasiwa(),mahasiswaMock.getNamaMahasiwa());
    }

    @Test
    public void testDelete() {
        mahasiswaMock.setHapus(true);
        Mockito.when(mahasiswaRepository.delete(Mockito.anyInt())).thenReturn(mahasiswaMock);
        Mahasiswa actual = mahasiswaService.delete(mahasiswaMock.getId());
        Assert.assertTrue(actual.getHapus());
    }
}