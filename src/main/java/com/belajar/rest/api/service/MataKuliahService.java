package com.belajar.rest.api.service;

import com.belajar.rest.api.entity.MataKuliah;
import com.belajar.rest.api.repository.MataKuliahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Mata kuliah service.
 */
@Service
public class MataKuliahService {
    /**
     * The Mata kuliah repository.
     */
    @Autowired
    MataKuliahRepository mataKuliahRepository;

    public List<MataKuliah> findAll(Pageable pageable) {
        return mataKuliahRepository.findAll();
    }

    public MataKuliah findById(Integer id) {
        return mataKuliahRepository.find(id);
    }

    public MataKuliah updateById(Integer id, MataKuliah mataKuliah) {
        mataKuliah.setId(id);
        return mataKuliahRepository.save(mataKuliah);
    }

    public MataKuliah create(MataKuliah mataKuliah) {
        mataKuliah.setHapus(true);
        return mataKuliahRepository.save(mataKuliah);
    }

    public MataKuliah delete(Integer id) {
        return mataKuliahRepository.delete(id);
    }

}
