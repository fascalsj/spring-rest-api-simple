package com.belajar.rest.api.repository;

import com.belajar.rest.api.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Mahasiswa repository.
 */
@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {
    @Query(value = "SELECT m FROM Mahasiswa m WHERE m.hapus = false")
    List<Mahasiswa> findAll();

    /**
     * Find mahasiswa.
     *
     * @param id the id
     * @return the mahasiswa
     */
    @Query(value = "SELECT m FROM Mahasiswa m WHERE m.hapus = false AND m.id=:id ")
    Mahasiswa find(@Param("id") Integer id);

    /**
     * Delete mahasiswa.
     *
     * @param id the id
     * @return the mahasiswa
     */
    @Query(value = "UPDATE Mahasiswa m SET m.hapus = true WHERE m.id=:id ")
    Mahasiswa delete(@Param("id") Integer id);
}
