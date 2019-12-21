package com.belajar.rest.api.service;

import com.belajar.rest.api.entity.Mahasiswa;
import com.belajar.rest.api.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Mahasiswa service.
 */
@Service
public class MahasiswaService {
    /**
     * The Mahasiswa repository.
     */
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    public List<Mahasiswa> findAll(Pageable pageable) {
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa findById(Integer id) {
        return mahasiswaRepository.find(id);
    }

    public Mahasiswa updateById(Integer id, Mahasiswa mahasiswa) {
        mahasiswa.setId(id);
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa create(Mahasiswa mahasiswa) {
        mahasiswa.setHapus(true);
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa delete(Integer id) {
        return mahasiswaRepository.delete(id);
    }
    
}
