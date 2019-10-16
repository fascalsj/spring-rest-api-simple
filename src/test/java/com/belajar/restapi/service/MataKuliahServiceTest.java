package com.belajar.restapi.service;

import com.belajar.restapi.entity.MataKuliah;
import com.belajar.restapi.repository.MataKuliahRepository;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MataKuliahServiceTest extends TestCase {

    @Autowired
    MataKuliahService mataKuliahService;

    @MockBean
    MataKuliahRepository mataKuliahRepository;

    private MataKuliah mataKuliahMock;
    private List<MataKuliah> mataKuliahListMock;

    @Before
    public void predefine(){
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
    public void testFindAll() {
        Mockito.when(mataKuliahRepository.findAll()).thenReturn(mataKuliahListMock);
        PageRequest pageable = PageRequest.of(0,3);
        List<MataKuliah> actual = mataKuliahService.findAll(pageable);
        Assert.assertNotNull(actual);
    }

    @Test
    public void testFindById() {
        Mockito.when(mataKuliahRepository.find(Mockito.anyInt())).thenReturn(mataKuliahMock);
        MataKuliah actual = mataKuliahService.findById(mataKuliahMock.getId());
        Assert.assertEquals(actual.getId(), mataKuliahMock.getId());
    }

    @Test
    public void testUpdateById() {
        Mockito.when(mataKuliahRepository.save(Mockito.any(MataKuliah.class))).thenReturn(mataKuliahMock);
        MataKuliah actual = mataKuliahService.updateById(mataKuliahMock.getId(),mataKuliahMock);
        Assert.assertEquals(actual.getId(), mataKuliahMock.getId());
    }

    @Test
    public void testCreate() {
        Mockito.when(mataKuliahRepository.save(Mockito.any(MataKuliah.class))).thenReturn(mataKuliahMock);
        MataKuliah actual = mataKuliahService.create(mataKuliahMock);
        Assert.assertEquals(actual.getId(), mataKuliahMock.getId());
        Assert.assertEquals(actual.getIdJurusan(), mataKuliahMock.getIdJurusan());
        Assert.assertEquals(actual.getHapus(), mataKuliahMock.getHapus());
        Assert.assertEquals(actual.getNamaMataKuliah(), mataKuliahMock.getNamaMataKuliah());
    }

    @Test
    public void testDelete() {
        mataKuliahMock.setHapus(true);
        Mockito.when(mataKuliahRepository.delete(Mockito.anyInt())).thenReturn(mataKuliahMock);
        MataKuliah actual = mataKuliahService.delete(mataKuliahMock.getId());
        Assert.assertTrue(actual.getHapus());
    }
}