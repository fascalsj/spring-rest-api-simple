package com.belajar.rest.api.service;

import com.belajar.rest.api.entity.Kelas;
import com.belajar.rest.api.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Kelas service.
 */
@Service
public class KelasService {
    /**
     * The Kelas repository.
     */
    @Autowired
    KelasRepository kelasRepository;

    public List<Kelas> findAll(Pageable pageable) {
        return kelasRepository.findAll();
    }

    public Kelas findById(Integer id) {
        return kelasRepository.find(id);
    }

    public Kelas updateById(Integer id, Kelas kelas) {
        kelas.setId(id);
        return kelasRepository.save(kelas);
    }
    public Kelas create(Kelas kelas) {
        kelas.setHapus(true);
        return kelasRepository.save(kelas);
    }

    public Kelas delete(Integer id) {
        return kelasRepository.delete(id);
    }
}
