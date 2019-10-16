package com.belajar.restapi.repository;

import com.belajar.restapi.entity.Mahasiswa;
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
    @Query(value = "SELECT m FROM Mahasiswa m where m.hapus = false")
    List<Mahasiswa> findAll();

    /**
     * Find mahasiswa.
     *
     * @param id the id
     * @return the mahasiswa
     */
    @Query(value = "SELECT m FROM Mahasiswa m where m.hapus = false AND m.id=:id ")
    Mahasiswa find(@Param("id") Integer id);

    /**
     * Delete mahasiswa.
     *
     * @param id the id
     * @return the mahasiswa
     */
    @Query(value = "Update Mahasiswa m set m.hapus = true WHERE m.id=:id ")
    Mahasiswa delete(@Param("id") Integer id);
}
