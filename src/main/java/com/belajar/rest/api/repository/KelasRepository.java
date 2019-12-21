package com.belajar.rest.api.repository;

import com.belajar.rest.api.entity.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Kelas repository.
 */
@Repository
public interface KelasRepository extends JpaRepository<Kelas, Integer> {

    @Query(value = "SELECT k FROM Kelas k WHERE k.hapus = false")
    List<Kelas> findAll();

    /**
     * Find kelas.
     *
     * @param id the id
     * @return the kelas
     */
    @Query(value = "SELECT k FROM Kelas k WHERE k.hapus = false AND k.id=:id ")
    Kelas find(@Param("id") Integer id);

    /**
     * Delete kelas.
     *
     * @param id the id
     * @return the kelas
     */
    @Query(value = "Update Kelas k set k.hapus = true WHERE k.id=:id ")
    Kelas delete(@Param("id") Integer id);
}