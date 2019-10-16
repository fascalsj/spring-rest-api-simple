package com.belajar.restapi.repository;

import com.belajar.restapi.entity.MataKuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Mata kuliah repository.
 */
@Repository
public interface MataKuliahRepository extends JpaRepository<MataKuliah, Integer> {
    @Query(value = "SELECT m FROM MataKuliah m where m.hapus = false")
    List<MataKuliah> findAll();

    /**
     * Find mata kuliah.
     *
     * @param id the id
     * @return the mata kuliah
     */
    @Query(value = "SELECT m FROM MataKuliah m where m.hapus = false AND m.id=:id ")
    MataKuliah find(@Param("id") Integer id);

    /**
     * Delete mata kuliah.
     *
     * @param id the id
     * @return the mata kuliah
     */
    @Query(value = "Update MataKuliah m set m.hapus = true WHERE m.id=:id ")
    MataKuliah delete(@Param("id") Integer id);
}
